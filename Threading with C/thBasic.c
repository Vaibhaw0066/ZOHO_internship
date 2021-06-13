
#include<pthread.h>
#include<unistd.h>
#include<stdio.h>


void* myTurn(void *args){


    while(1){
        printf("My turn\n");
        sleep(1);
    }
    return NULL;
}




void yourTurn(){


    while(1){
        printf("Your turn\n");
        sleep(1);
    }
}


int main(){


    pthread_t newthread;
    pthread_create(&newthread,NULL, myTurn,NULL); 
     yourTurn();
     myTurn(NULL);
   



}
