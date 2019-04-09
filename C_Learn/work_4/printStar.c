#include <stdio.h>

void printStar() //上半部分的星号
{
    for(int i = 0; i < 12; i += 2)
    {
        for(int j = 0; j < i+1; j += 1)
            printf("*");
        printf("\n");
    }
}
void printDeStar() //下半部分的星号
{
  for(int i = 12; i > 0; i -= 2)
    {
        for(int j = 0; j < i+1; j += 1)
            printf("*");
        printf("\n");
    }  
}
//**************
//*************
//*************

int main()
{
    printStar();
    printDeStar();
    return 0;
}