
typedef struct Struct{
    int marks;
}Struct1;



double average(Struct1* s,int n){


    int sum =0;
    
    for(int i=0;i<n;i++){
        sum+=s[i].marks;
    }
    
    return (double)sum/n;
} 

