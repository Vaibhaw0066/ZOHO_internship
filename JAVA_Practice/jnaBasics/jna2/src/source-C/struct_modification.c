

#include<stdlib.h>
#include <stdio.h>
#include <assert.h>

// Struct 1
typedef struct  Struct{

    int d;

} Struct;


// Struct containg double field
typedef struct Struct1
{
    double d;
}Struct1;



// Struct containing an array of double
typedef struct Struct2{

    int size;
    double * d;
    
}Struct2;



typedef struct  Struct3
{
    int data;
}Struct3;

typedef struct  Struct4
{
    
    Struct3 *field;

}Struct4;




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

// Sends a array of struct containg double
const Struct1* recieveDouble(int size){

    Struct1* s = (Struct1*) malloc(sizeof(Struct1*)*size);

    for(int i=1;i<=5;i++){

        s[i-1].d = (double)(i*3)/5;
    }
    return s;
}


// Recieves an Struct which contains arrray of double
void send_double_struct(const Struct2* s){

    assert(NULL!=s);
    for(int i=0;i<s->size;i++){

        printf("%lf\n",s->d[i]);
 
    }

}


// Recieves array of Struct  containing int
void sendStructArray(Struct3* s,int size){

    for(int i=0;i<size;i++){

        printf("%d  ",s[i].data);

    }


}


// Swap two structure object
void swap_struct(Struct *s1,Struct *s2){


    printf("Data 1: %d\n",s1->d);
    printf("Data 2: %d\n",s2->d);

    Struct *s = s1;
    s1 = s2;
    s2 = s;
    
    printf("\n\nData 1: %d\n",s1->d);
    printf("Data 2: %d\n",s2->d);

}

