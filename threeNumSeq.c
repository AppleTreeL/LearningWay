#include <stdio.h>

void sequence_3(int* a)//sorting three numbers from big to small
{
    int tem = 0;
    for(int i = 0; i < 2; i++)
        for(int j = 0; j < 2 - i; j++)
        {
            if(*(a + j) < *(a + j + 1))
            {
                tem =  *(a + j + 1);
                *(a + j + 1) = *(a + j);
                *(a + j) = tem; 
            }
        }
    printf("排序后为: ");
    for(int i = 0; i < 3; i++)
        printf("%d\t", *(a + i));
}

int main()
{
    int a[3];
    printf("请输入三个数字，以空格隔开\n");
    scanf("%d %d %d", &a[0], &a[1], &a[2]);
    sequence_3(a);
    return 0;
}