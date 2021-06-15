#include<stdlib.h>
#include<string.h>
#include<stdio.h>


/*     PRIMITIVE DATA STRUCTUES   */
	
    // returns the sum of two numbers
    int sum(int  a,int b){return a+b;}
		
	// prints the given charater n time
    void printNchars(char c,int n)
    {    
        printf("%d times %c -> ",n,c);
        for(int i=0;i<n;i++)
             printf("%c",c);   
        printf("\n"); 
    }
	
	// Print squre of with '*'
	void printSquare(int side)
    {
        printf("\n");   
        for(int i=0;i<side;i++)
        {
            for(int j=0;j<side;j++)
                printf("*");
            printf("\n");
        }
        
    }
		
	// returns a^n 
	long pow_recu(int a, int n)
    {
        if(n==0) return 1;
        return (long)(a * pow_recu(a,n-1));
    }
		
	// Concatenate the gives string to itself n times
	char* concatNtimes(char* a,int n)
    {
        char *res = malloc(sizeof(char)*10000);
        res[0]='\0';
        for(int i=0;i<n;i++)
        {
            strcat(res,a);
        }
        return res;
    }

