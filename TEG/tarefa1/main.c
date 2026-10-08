#include "Iris.h"
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

// Verifica o tamanho do arquivo removendo o cabeçalho
int tamanho(const char path[]) {
    FILE *file = fopen(path, "r");
    if (file == NULL) {
        printf("Erro ao abrir arquivo");
        return 0;
    }
    
    int total = 0;
    char c;
    while ((c = fgetc(file)) != EOF) {
        if (c == '\n') total++;
    }
    return total-1;
}

// Marca o vértice como visitado e 
int visitar(int vertice, int tam, double matriz[tam][tam], int visitados[]) {
    visitados[vertice] = 1;
    int soma = 1;
    for (int j = 0; j < tam; j++) {
        if (matriz[vertice][j] == 1.0) {
            if (visitados[j] == 0) {
                soma += visitar(j, tam, matriz, visitados);
            }
        }
    }
    return soma;
}

int tam = 0;
int main() {
    tam = tamanho("IrisDataset.csv");

    FILE *file = fopen("IrisDataset.csv", "r");
    if (file == NULL) {
        printf("Erro ao abrir arquivo");
        return 0;
    }
    
    Vertice vertices[tam];
    double matriz[tam][tam];
    
    char line[100];

    fgets(line, 100, file); // Pula o cabecalho

    for (int i = 0; i < tam; i++) { // Le os vertices
        fgets(line, 100, file); // Pega o proximo vertice
        char *data = strtok(line, ","); // Separa a string

        data = strtok(NULL, ","); // Pula a primeira coluna
        vertices[i].petal_length = atof(data);

        data = strtok(NULL, ","); // Passa para o proximo valor
        vertices[i].petal_width = atof(data);

        data = strtok(NULL, ","); // Passa para o proximo valor
        vertices[i].sepal_length = atof(data);

        data = strtok(NULL, ","); // Passa para o proximo valor
        vertices[i].sepal_width = atof(data);
    }

    fclose(file); // Leitura terminou

    int menori = 0, menorj = 1, maiori = 0, maiorj = 1;
    double menor = DE(vertices[0],vertices[1]), maior = 0;
    for (int i = 0; i < tam; i++) {
        for (int j = 0; j < i; j++) {
            matriz[i][j] = DE(vertices[i],vertices[j]);

            if (matriz[i][j] < menor) {
                menori = i; menorj = j;
                menor = matriz[i][j]; // Salva o novo menor valor
            }
            if (matriz[i][j] > maior) {
                maiori = i; maiorj = j;
                maior = matriz[i][j]; // Salva o novo maior valor
            }
        }
    }

    double divisor = maior - menor;
    double maiorden = DEN(matriz[maiori][maiorj], menor, divisor);
    double menorden = DEN(matriz[menori][menorj], menor, divisor);    

    for (int i = 0; i < tam; i++) {
        for (int j = 0; j <= i; j++) {
            if (i == j) matriz[i][j] = 0;
            else if (DEN(matriz[i][j], menor, divisor) <= 0.3) {
                matriz[i][j] = 1;
                matriz[j][i] = 1;
            } else {
                matriz[i][j] = 0;
                matriz[j][i] = 0;
            }
        }
    }

    // Cálculo do Grau Máximo e Mínimo
    int maximo = 0, minimo = tam;
    for (int i = 0; i < tam; i++) {
        int soma = 0;
        for (int j = 0; j < tam; j++) {
            if (matriz[i][j] == 1) soma++;
        }
        if (soma > maximo) maximo = soma;
        if (soma < minimo) minimo = soma;
    }

    // Cálculo dos componentes
    
    Componente *inicial = NULL;
    int visitados[tam], quantidade = 0;
    for (int i = 0; i < tam; i++) visitados[i] = 0;

    for (int i = 0; i < tam; i++) {
        if (visitados[i] == 0) {
            Componente *novo = malloc(sizeof(Componente));
            novo->proximo = NULL;
            
            if (inicial == NULL) {
                inicial = novo;
            } else {
                Componente *aux = inicial;
                while (aux->proximo != NULL) {
                    aux = aux->proximo;
                }
                aux->proximo = novo;
            }
            
            novo->tamanho = visitar(i, tam, matriz, visitados); // Visita todos os vértices ligados a ele
        }
    }
    Componente *aux = inicial;
    while (aux != NULL) {
        quantidade++;
        aux = aux->proximo;
    }
    

    // Criação do CSV
    FILE *saida = fopen("output.csv", "w");

    fprintf(saida, "%d\n", tam);
    fprintf(saida, "%f (%d; %d)\n", maior, maiori, maiorj);
    fprintf(saida, "%f (%d; %d)\n", menor, menori, menorj);
    fprintf(saida, "%f (%d; %d)\n", maiorden, maiori, maiorj);
    fprintf(saida, "%f (%d; %d)\n", menorden, menori, menorj);
    fprintf(saida, "Grau maximo: %d; Grau minimo: %d\n", maximo, minimo);
    fprintf(saida, "Simples\n");
    fprintf(saida, "Quantidade de componentes: %d", quantidade);
    aux = inicial;
    while (aux != NULL) {
        fprintf(saida, " - tamanho = %d", aux->tamanho);
        aux = aux->proximo;
    }
    fprintf(saida, "\n");
    for (int i = 0; i < tam; i++) {
        for (int j = 0; j < tam; j++) {
            fprintf(saida, "%.0f", matriz[i][j]);
            if (j < tam-1) fprintf(saida, ",");
        }
        fprintf(saida, "\n");
    }

    fclose(saida);
    
    return 0;
}