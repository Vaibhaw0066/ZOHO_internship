#include<stdio.h>
#include<dirent.h>
#include<string.h>
#include <stdbool.h>
#include<MagickWand/MagickWand.h>


char *newFileName(char* filename){
	
	int len=0, i=0;
	while(filename[i++]!='\0')
		len++;	

	char *newfilename = malloc( sizeof(char) * ( len + 4 ) );    // +4 char for "_new"
	//newfilename ="";
	char format[] = ".png";
	char exten[]  = "_new";
	
	
	for(i=0;i<len-4;i++)
		newfilename[i]=filename[i];
	
	strcat(newfilename,exten);
	strcat(newfilename,format);
	
	printf("%s\n", newfilename);
	return newfilename;
}


void to_PNG(char *filename, char *dir){
	
	MagickWand *mw =NULL;
	MagickWandGenesis();
	
	/*Creanig new wand*/
	mw = NewMagickWand();
	
		
	strcat(dir,newFileName(filename));		
	//printf("Saved to %s  ->  \n", dir);
	
	
	/*Reading the input image*/
	/*
	if(MagickReadImage(mw,filename)==MagickTrue){
		
	
		if(MagickWriteImage(mw,dir)==MagickTrue)
			return true;
		else 
			return false;
	
	}else{
	
		return false;
	}
	*/

}


void convertAll(){


		DIR *d;
		struct dirent *dir;
	    	d = opendir("./images/");
	    	if (d)
		{
			char folder[] = "./converted/";
			while ((dir = readdir(d)) != NULL)
			{
		    		to_PNG(dir->d_name, folder);
				 //printf("%s -> is converted.\n",dir->d_name);
			}
			
			
			closedir(d);
	    	}
		else{
			printf("No folder found in current directory named \n");
		}




	



}


int main(int argc, char *argv[]){
	
	
	if(argc ==2){
	
		char *dir;
		dir = argv[1];
		
		convertAll(dir);
	}else{
		
		char *arr;
		arr=NULL;
		convertAll(arr);
	}
	

	return 0;

}
