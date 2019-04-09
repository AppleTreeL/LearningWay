#include <stdio.h>
#include <math.h>
/**/
int countBit(int num)
{
    int count = 0;
    do{
        num = num / 10;
        count ++;
    }while(num != 0);
    return count;
}

void deffodil()
{
    for(int i = 0; i < 9; i++)
        for(int j = 0; j < 9; j++)
            for(int k = 0; k < 9; k++)
                if(pow(i, 3) + pow(j, 3) + pow(k, 3) == i*100 + j*10 + k)
                    printf("%d\t", i*100 + j*10 + k);
}

int main()
{
    deffodil();
     return 0;
}