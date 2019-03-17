#include <stdio.h>

void exchangeNum(int* a, int* b)//excahnge value
{
    int temp = 0;
    temp = &a;
    a = &b;
    b = temp; 
}


int main()
{
    int a = 0;
    int b = 0;
    printf("Please input a:");
    scanf("%d", &a);
    printf("please input b:");
    scanf("%d", &b);
    exchangeNum(&a, &b);
    printf("a = %d , b= %d", a, b);
    return 0;
}