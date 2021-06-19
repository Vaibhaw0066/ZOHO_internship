

#include<stdlib.h>
#include<stdio.h>

// Struct 1
typedef struct  Struct{

    int d;

} Struct;


// Struct containg double field
typedef struct Struct1
{
    double d;
}Struct1;




// ==================================================

// Modify value of Struct
void modify(Struct* d){

    d->d = 1000;

}

// Receive an array of Struct containg integers from JAVA
int send_struct_array(const Struct* s, int n){

    int total = 0;
    for(int i=0;i<n;i++){

        total+= s[i].d;
    } 
    return total;
}


// Send an array of Struct containg integers to JAVA
const Struct* recieve(int size){

    Struct *s = (Struct*)malloc(sizeof(Struct*)*size);
    for(int i=0;i<size;i++)
        s[i].d=i*i;
    return s;
}


// Recieve an array of Struct1 containing double from JAVA
void sendDouble(const Struct1* s,int  size){

    printf("Recieved from JAVA: \n");
    for(int i=0;i<size;i++)
        printf("%lf \n",s[i].d);

}