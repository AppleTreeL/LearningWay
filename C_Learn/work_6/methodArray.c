#include <stdio.h>

void init(int* arr, int len)
{
    int i = 0;
    for (i = 0; i < len; i++)
    {
        *(arr + i) = 1;
    }
}

void empty(int* arr, int len)
{
    int i = 0;
    for (i = 0; i < len; i++)
    {
        *(arr + i) = 0;
    }
}

void show(int* arr, int len)
{
    int i = 0;
    for (i = 0; i < len; i++)
    {
        printf("%d\t", *(arr + i));
    }
}

void reverse(int* arr, int len)
{
    int start = 0;
    int end = len - 1;
    for(start = 0, end = len - 1; start < len, end >= 0; start ++, end --)
    {
        if((start == end) || (start > end))
        {
            //printf("break running");
            break;
        }
        *(arr + start) = *(arr + start) + *(arr + end);
        *(arr + end) = *(arr + start) - *(arr + end);
        *(arr + start) = *(arr + start) - *(arr + end);
        
    }
}
int main()
{
    int arr[10] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
    int len = sizeof(arr) / sizeof(arr[0]);
    
    show(arr, len);
    printf("\n");
    reverse(arr, len);
    show(arr, len);
    
    return 0;
}