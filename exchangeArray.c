#include <stdio.h>
#include <stdlib.h>

void exchangeArray(int max, int* a, int* b)//exchange the two same size arrays, num is the size
{
    
    int temp;
    for(int i = 0; i < max; i++)
    {
        temp = *(a + i);
        *(a + i) = *(b+i);
        *(b + i) = temp;
    }
    
    for(int i = 0; i < max; i++)
    {
        printf("a:");
        printf("%d\t", *(a + i));   
    } 
    printf("\n");
    
    for(int i = 0; i < max; i++)
    {
        printf("b:");
        printf("%d\t", *(b + i));
    } 
    printf("\n");
}


int main()
{
    int a[10] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
    int b[10] = {11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
    exchangeArray(10, a, b);
    // for(int i = 0; i < sizeof(a)/sizeof(int); i++)
    // {
    //     printf("a:");
    //     printf("%d\t", *(a + i));   
    // } 
    printf("\n");
    system("pause");
    return 0;
}