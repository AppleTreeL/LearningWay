#include <stdio.h>
#include <stdlib.h>

bool isPrimerNum(int num)
{
    for (int i =2; i < num; i++)
    if(num % i == 0)
        return false;
    else
        return true;
}

int main()
{
    for(int num = 100; num < 201; num++)
    {
        if(isPrimerNum(num))
        {
            printf("%d\n", num);
        }
    }
    system("pause");
    return 0;
}