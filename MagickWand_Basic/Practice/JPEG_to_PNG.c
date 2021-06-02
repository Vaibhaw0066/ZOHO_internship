#include <stdio.h>
#include <MagickWand/MagickWand.h>

void test_wand(void)
{
	MagickWand *mw = NULL;

	MagickWandGenesis();

	/* Create a wand */
	mw = NewMagickWand();

	/* Read the input image */
	if(MagickReadImage(mw,"testing.jpg")==MagickFalse){
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

test_wand();
return 0;
}

