#include<stdlib.h>
#include<string.h>
typedef struct  data
{
    char *str;

}data;

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
