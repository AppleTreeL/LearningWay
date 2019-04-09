#include <stdio.h>

void noTempExcahange1(int* a, int* b)//交换函数，交换两个数的值,不创建中间变量,以异或方式
{
   *a = *a ^ *b;
   *b = *a ^ *b;
   *a = *a ^ *b;
}

void noTempExcahange2(int* a, int* b)//交换函数，交换两个数的值,不创建中间变量,以和的方式
{
    *a = *a + *b;
    *b = *a - *b;
    *a = *a - *b;
}

int main()
{
    int a = 0;
    int b = 0;
    printf("Please input a:");
    scanf("%d", &a);
    printf("please input b:");
    scanf("%d", &b);
    noTempExcahange1(&a, &b); 
    printf("after exchange: a = %d , b= %d", a, b);
    return 0;
}