#include <stdio.h>
#include <math.h>
//高质量C/C++编程
int series(int num, int n)//指定一个数字num， 指定项数n
{
    int result = 0;
    int list = 0;
    for(int i = 0; i < n ; i++ )
    {
        list = 10*list + num;
        //list  = num * pow(10, i) + list;
        result = result + list;
    }
    return result;
}

int main()
{
    int num = 0;
    int n = 0;
    printf("请分别输入指定数字和前n项和的项数， 用空格隔开\n");
    scanf("%d %d", &num, &n);
    printf("前%d的和为%d", n, series(num, n));
    return 0;
}