#include <stdio.h>
#include <MagickWand/MagickWand.h>

void convert_to_PNG(char *filename)
{
	
	printf("%s is being converted to PNG\n",filename);

	
	MagickWand *mw = NULL;

	MagickWandGenesis();

	/* Create a wand */
	mw = NewMagickWand();

	/* Read the input image */
	if(MagickReadImage(mw,filename)==MagickFalse){
	printf("Image not found!\n");
	}else{
	printf("Image selected and converted to PNG\n");
	}
	
	/* write it */
	MagickWriteImage(mw,"converted.png");

	/* Tidy up */
	if(mw) mw = DestroyMagickWand(mw);

	MagickWandTerminus();
	//printf("All working!\n\n");
	
	
}

int main(){

char filename[] = "https://www.guru99.com/images/1/101218_1400_WhatisMeanS1.png";
convert_to_PNG(filename);
return 0;
}

