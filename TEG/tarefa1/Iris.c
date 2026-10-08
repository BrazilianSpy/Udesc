#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include "Iris.h"

double DE(Vertice vi, Vertice vj) {
    double dif1 = vj.petal_length - vi.petal_length;
    double dif2 = vj.petal_width - vi.petal_width;
    double dif3 = vj.sepal_length - vi.sepal_length;
    double dif4 = vj.sepal_width - vi.sepal_width;

    return sqrt(dif1*dif1 + dif2*dif2 + dif3*dif3 + dif4*dif4); // Raiz da soma dos quadrados
}

double DEN(double valor, double menor, double divisor) {
    return (valor - menor) / divisor;
}
