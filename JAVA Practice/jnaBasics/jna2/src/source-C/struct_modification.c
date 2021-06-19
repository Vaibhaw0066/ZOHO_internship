




// Struct 1
typedef struct  Struct{

    int d;

} Struct;




// ==================================================

// Modify value of Struct
void modify(Struct* d){

    d->d = 1000;

}

// Receive an array of Structt from JAVA
int send_struct_array(const Struct* s, int n){

    int total = 0;
    for(int i=0;i<n;i++){

        total+= s[i].d;
    } 
    return total;
}
