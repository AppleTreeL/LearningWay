#include <stdio.h>
#include <stdlib.h>
int main()
{
    int mul = 0;
    for(int i = 1; i < 10; i++)
        for(int j = 1; j < 10; j++)
        {
            mul = i * j;
            printf("%d * %d = %d,\t",  i, j, mul);
            if(j == 9)
                printf("\n");
        }
    system("pause");  
    return 0;
}