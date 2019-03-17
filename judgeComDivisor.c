#include <stdio.h>

#if 0
int comDivisor(int a, int b)//返回a和b的最大公约数
{
    int c = b;
    while(a % b != 0)
    {
        c = a % b;
        a = b;
        b = c;
    }
    return b;
}
#endif

int comDivisor(int a, int b)//return the greatest common divisor of two numbers
{
    int temp = 0;
    for(temp = b;;temp--)
        if((a % temp == 0) && (b % temp == 0))
            break;
    return temp;        
}


int main()
{
    int a = 0;
    int b = 0;
    printf("请输入2个数字，以空格隔开\n");
    scanf("%d %d", &a, &b);
    printf("%d和%d的最大公约数是:%d", a, b, comDivisor(a, b));
    return 0;
}