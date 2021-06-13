#include <stdio.h>
#include <MagickWand/MagickWand.h>
#include <string.h>

void test_wand(char *filename,char *outfile)
{
	MagickWand *mw = NULL;

	MagickWandGenesis();

	/* Create a wand */
	mw = NewMagickWand();
	printf("searching in : %s",filename);
	/* Read the input image */
	if(MagickReadImage(mw,filename)==MagickFalse){
	printf("Image not found!\n");
	}else{
	printf("Image selected and converted to PNG\n");
	}
	
	/* write it */
	char *format = ".png";
	strcat(outfile,format);
	MagickWriteImage(mw,outfile);

	/* Tidy up */
	if(mw) mw = DestroyMagickWand(mw);

	MagickWandTerminus();
	//printf("All working!\n\n");
}

int main(int argc,char **argv){

	
	if(argc==3){

		char *filename = argv[1];
		char *outfile  = argv[2];
		test_wand(filename,outfile);
		
		}
	
return 0;
}

