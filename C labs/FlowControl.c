#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include <time.h>
double array_mean(double *arr, int size)
{
    double sum = 0;
    
    for (int i = 0; i < size; i++)
    {
        sum = sum + *(arr + i);
    }
    
    return sum / size;
}

int main(void) 
{
    srand(time(NULL));
    /*
     * for (int i = 0; i < 10; i++) 
     * {      
     *     int random = rand() % 100;
     *     printf("%d\n", random);
     * }
    */
    
    double dist_to_obj = 100.00;
    int i = 0;
    double step_array[100];
    double *p = step_array;
    
    while (dist_to_obj > 0)
    {
        double step = rand() % 10 + 1.0;
        double current_pos = 100 - dist_to_obj;
        double next_pos = current_pos + step;
        
        dist_to_obj -= step;  
        
        if (dist_to_obj <= 0)
        {
            printf("Current Position: %.2f Step Size: %.2f Cannot move, would hit obstacle.\n", current_pos, step);
            break;
        }     
        
        *(p + i) = step;
        i++;
        
        printf("Current Position: %.2f Step Size: %.2f Moving to: %.2f\n", current_pos, step, next_pos);
    }
    
    double mean_step = array_mean(step_array, i);
    
    printf("Average step size: %.2f", mean_step);
    
    return 0;
}