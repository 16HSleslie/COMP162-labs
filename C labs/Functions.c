double array_mean(double *arr, int size);

#include <stdio.h>
#include <stdlib.h>
#include <math.h>

int main(void)
{
    double test_01[] = {1,2,3};
    double mean_01 = array_mean(test_01,3);
    
    double test_02[] = {10,12,-15,17.5,-20};
    double mean_02 = array_mean(test_02,5);
    
    printf("%.2f\n",mean_01);
}

double array_mean(double *arr, int size)
{
    double sum = 0;
    
    for (int i = 0; i < size; i++)
    {
        sum = sum + *(arr + i);
    }
    
    return sum / size;
}