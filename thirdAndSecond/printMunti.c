#include <stdio.h>

int main()
{
    int i = 0;
    int j = 0;
    int n = 0;
    scanf("%d", &n);
    for(i = 1; i<= n; i++)//打印九九乘法表
    {
        for(j = 1; j <= i; j++)
        {
            printf("%d * %d = %2d\t", i, j, i*j);
        }
        printf("\n");
    }

    return 0;
}