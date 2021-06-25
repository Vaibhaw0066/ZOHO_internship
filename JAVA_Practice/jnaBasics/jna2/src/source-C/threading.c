

#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>



void loop_for_n(int n){


printf("\n=======================================\n");
printf("========== FROM C  =======================\n");

printf("\n\n\nPrinting n nums: ");
for(int i=1;i<=n;i++)

    // printf("%d -> ",i);
    sleep(0.05);    
}


long long sum_of_n_natural_nums(int n){

    long long sum =0;
    for(long long i=1;i<=n;i++)
    {
         sum+=i;
    }       
    
    return sum;

}


void say_hi_n_times(int n){

    for(int i=0;i<n;i++)
    {
        printf("\nHi -> %dth time",i+1);
        sleep(0.1);
    }
}



int* return_n_length_array(int n){

    
    int *arr = (int*) malloc(sizeof(int)*n);

    for(int i=0;i<n;i++){
        arr[i] = rand()%100;
        // printf("%d -> %d \n",arr[i],i);
    }
        

    
    return arr;

}
