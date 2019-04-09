
//#define findMaxValue(a) findMaxValue(a , 10)
#include <stdio.h>

void findMaxValue(int* array)//find the max value between ten numbers
{
    int temp = 0;
    for(int i = 0; i < 10; i++)
    {
        for(int j = 0; j < 10 - 1 - i; j++ )
        {
            if(*(array + j) < *(array + j + 1))
            {
                temp = *(array + j);
                *(array + j) = *(array + j + 1);
                *(array + j + 1) = temp;
            }
        }
    }
    printf("the max_value is: %d", *(array+0));
}

int main()
{
    
    int array[10];
    for(int i = 0; i<10; i++)
    {
        scanf("%d", &array[i]);
    }
    findMaxValue(array);
    return 0;
}

