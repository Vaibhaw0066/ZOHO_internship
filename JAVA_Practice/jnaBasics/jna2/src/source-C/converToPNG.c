#include <stdio.h>
#include <MagickWand/MagickWand.h>
#include<string.h>
#include<unistd.h>
#include<limits.h>
void convert(char * filename)
{   

    char cwd[PATH_MAX];
    getcwd(cwd,sizeof(cwd));
    printf("Searching file in : %s\n",cwd);

    // Expected image folder
    char img []="./images/";
    strcat(img,filename);
    printf("\n===> %s <====\n",img);
    if(access( img, F_OK ) == 0){ 
        printf("Image found! -> %s\n",filename);
        


       	MagickWand *mw = NULL;

        MagickWandGenesis();

        /* Create a wand */
        mw = NewMagickWand();


        /* Read the input image */
        MagickReadImage(mw,img);

        printf("Image read: %s\n",filename);
        /*New file name "converted-filename.png"*/
        int i=0;
        char new_file_name[100];
        // char folder[]="../threading/images/converted/";
        char folder[]="./images/converted/";
        while (filename[i]!='\0')
        { 
            if (filename[i]=='.')
            {   


                char format[]= "-converted.png";
                strcat(new_file_name,format);

                
                strcat(folder,new_file_name);
                break;
            }else{
                new_file_name[i]=filename[i];
            }
            i++;
        }
        

        /* write it */
        MagickWriteImage(mw,folder);
        printf("Image Converted: %s\n\n",folder);

        /* Tidy up */
        if(mw) mw = DestroyMagickWand(mw);

        MagickWandTerminus();


        }
    else{
        printf("Image not found!");
    }


}
