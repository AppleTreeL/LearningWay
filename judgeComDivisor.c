#include <stdio.h>

#if 0
int comDivisor(int a, int b)//����a��b�����Լ��
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
    printf("������2�����֣��Կո����\n");
    scanf("%d %d", &a, &b);
    printf("%d��%d�����Լ����:%d", a, b, comDivisor(a, b));
    return 0;
}