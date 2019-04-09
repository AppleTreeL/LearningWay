#include <stdio.h>
#include <math.h>

double result()//calculate the "1/1-1/2+1/3-1/4+1/5 …… + 1/99 - 1/100 " and return the result
{
    double result = 0;
    int temp = 1;
    for(int i = 1; i < 101; i++)
    {
        result = result + (pow(-1, i + 1))/temp;
        temp += 1;
    }
    return result;
}

int main()
{
    printf("结果为: %lf",result());
    return 0;
}

#if 0
#include <stdio.h>
#include <math.h>
int main()
{	
    int i = 0;	
    double sum = 0.0;	
    for (i = 1; i <= 100; i++)	
    {		
        sum = sum + (pow(-1, i + 1)) / i;	
    }	
    printf("结果为:%lf\n", sum);	
    //system("pause");	
    return 0;
}
#endif