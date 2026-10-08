typedef struct {
    double petal_length;
    double petal_width;
    double sepal_length;
    double sepal_width;
} Vertice;

typedef struct componente {
    int tamanho;
    struct componente *proximo;
} Componente;

#define TAM 150

double DE(Vertice vi, Vertice vj);
double DEN(double valor, double menor, double divisor);