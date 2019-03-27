#include <stdio.h>

void exchangeLetter()
{
    int ch = 0;
    while((ch = getchar()) != EOF)//end of file == -1, ctr + c == interrupt program
    {
        //printf("%c", ch);
        if(ch >= 97 && ch <= 123)
            printf("%c", ch - 32);
        if( ch >= 65 && ch <= 91)
            printf("%c", ch + 32);
    }
}

int main()
{
    #if 0
    int a = 10;
    int& p = a;
    //p = 20;
    a = 40;

    printf("%d\n", a);
    a = 30;
    printf("%d\n", p);
    #endif
    exchangeLetter();
    

    return 0;
}