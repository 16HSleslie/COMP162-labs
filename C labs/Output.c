#include <stdio.h>
#include <stdlib.h>
#include <math.h>

int main(void)
{
    /*
     * int i = 42;
     * char z = 'c';
     * double d = 3.14;
     * 
     * printf("The integer is %d, the char is %c and the double is %f", i, z, d);
    */
    
    char planet_name[] = "Mars";
    double planet_dist_million_km = 227.9;
    double planet_speed_km_per_sec = 29.78;
    int orbital_period_days = 687;
    
    
    printf("%s is %.1f million km from the sun, moving at %.2f km per sec. One yearlasts %d days.", planet_name, planet_dist_million_km, planet_speed_km_per_sec, orbital_period_days);
    
    return 0;
}