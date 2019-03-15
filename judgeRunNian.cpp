#include <stdio.h>
#include <stdlib.h>

bool judgeRunNian(int year)
{
    if((year % 4 == 0) && (year % 100 != 0))
        return true;
    else
        return false;
}
int main()
{
    printf("1000~2000之间闰年年份:\n");
    for(int year = 1000; year < 2001; year++ )
    {
        if(judgeRunNian(year))
        {
            printf("%d\t", year);
        }
    }
    system("pause");
    return 0;
}