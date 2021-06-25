
#include<stdio.h>
#include <stdlib.h>
#include<time.h>

 

typedef struct Struct1{

    char *word;

}Struct1;



Struct1* assignRandomWords(int size){


    Struct1 *words = (Struct1*)malloc(size*sizeof(Struct1*));

    for(int i=0;i<size;i++){

        // Generating random word
        // of length 5
        char *word = (char*)malloc(6*sizeof(char));
        
        // printf("Random : ");
        for(int j =0;j<6;j++){
           
            int random = rand();
            // printf("%c ",(random%26 + 'a'));
            word[j]=('a'+random%26);

        }
 

        // printf("\n");
        words[i].word = word;
        // printf("%s => ",words[i].word);

    } 
    return words;

}