#include<stdio.h>
#include<stdlib.h>

// typedef struct Example3Struct {
// 	int val;
// } Example3Struct;

// void example3_sendStruct(const Example3Struct* sval)
// {
// 	// note: printfs called from C won't be flushed
// 	// to stdout until the Java process completes
// 	printf("(C) %d\n", sval->val);
// }


typedef struct foo_t {
    int field1;
    int field2;
    char *field3;
} foo_t1;

void printByReference(foo_t1 *data){
	
	printf("\n=============  Called form Native - C  =========");
	
	printf("\nOrignal Field1: %d\n",data->field1);
	printf("Orignal Field2: %d\n",data->field2);
	printf("Orignal Field3: %s\n",data->field3);
	

	data->field1 =200;
	data->field2 =10000;
	data->field3 = "From Native - C";
	

}




typedef struct NativeStructure
{
	char *data;
}NativeStr;





void printByReference2(NativeStr *d){
	
	printf("\n=============  Called form Native - C  =========");
	printf("\nOrignal Field1: %s\n",d->data);

}




NativeStr* getStructFromC(){

	NativeStr *d = malloc(sizeof(*d));
	d->data = "Hello, dood!\n"; 

	printf("Structure NativeStr sent to JAVA : \n");

	return d;

}