#include<stdlib.h>
#include<string.h>
#include <stdio.h>
typedef struct  data
{
    char *str;

}data;



typedef struct Struct{

    int size;
    char **string;
    


}Struct;













// =====================================================



// Return a struct containg string
data getStructString(){

    data d;
    d.str = (char*)malloc(sizeof(char*)*100);
    memset(d.str,0,sizeof(char)*6);
    strcpy(d.str,"String from C");
    return d;
}


void cleanup_data(data d)
{
	free(d.str);
}


// returns a string 
char *reverse(char *data){

    int n=0;
    while(data[n]!='\0')
        n++;

    for(int i=0;i<n/2;i++){
        
        char t = data[i];
        data[i] = data[n-i-1];
        data[n-i-1] = t;

    }
        return data;
}




// Send a struct containg array of strings from JAVA
Struct* recieve_string_array(){

    Struct *s = (Struct*)malloc(sizeof(Struct*));
    s->string =  (char **)malloc(sizeof(char**)*100);

    s->string[0]="Hello";
    s->string[1]="Friends";
    s->string[2]="!";

    s->size=3;

    return s;

}

// Recieves a struct containg array of strings from JAVA
void send_string_Array(const Struct* s){

    for(int i=0;i<s->size;i++)
        printf("%s -> ",s->string[i]);

}
