#include <stdio.h>

int countNUm_9()//between 1 and 100,record the times of munber "9"
{
    int count  = 0;
    for(int i = 1; i < 100; i++)
    {
        if( (i % 10 == 9) ||  (i / 10 == 9))
            count += 1;
    }
    return count;
}
int main()
{
    printf("'9' occurs %d times\n", countNUm_9());
    return 0;
}