#include<stdio.h>
#include<string.h>
#include<MagickWand/MagickWand.h>


void readUrl(char *url, char *name){

    // wand pointer
    MagickWand *mw =  NULL;
   	
    //Initialize the MagickWand enviornment
	MagickWandGenesis(); 

	// New wand
	mw = NewMagickWand();

	if(MagickReadImage(mw,url)==MagickTrue)
	{   
        char extension[] =".png";
        strcat(name,extension);
		MagickWriteImage(mw,name);
        printf("image saved as %s\n",name);

	}else{

        printf("%s not found.\n",url);
    } 

    // Releasing memory
    if(mw) mw = DestroyMagickWand(mw);
    MagickWandTerminus();

}

int main(int argc, char** argv){

    if(argc<=3 && argc>1){

        if(argc==2){
            printf("Please provide output image name without extension.\n");
        }
        readUrl(argv[1],argv[2]);
    }else{
        printf("No url found!\n");
    }

    return 0;
}