#include <stdio.h>
#include <math.h>
//������C/C++���
int series(int num, int n)//ָ��һ������num�� ָ������n
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
    printf("��ֱ�����ָ�����ֺ�ǰn��͵������� �ÿո����\n");
    scanf("%d %d", &num, &n);
    printf("ǰ%d�ĺ�Ϊ%d", n, series(num, n));
    return 0;
}