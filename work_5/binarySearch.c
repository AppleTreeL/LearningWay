#define MAXSIZE 100
#include <stdio.h>

void sequence(int* arr, int size)//对数组进行排序，以便进行二分查找
{
     printf("origional arr is:\t");//打印一下原来的数组
    for(int i = 0; i < size; i++)
        printf("%d\t", *(arr + i));
    printf("\n");
    int temp = 0;
    for(int i = 0; i < size; i++)
    for(int j = 0; j < size - i -1; j++)
    {
        if(*(arr + j) > *(arr + j + 1))
        {
            temp = *(arr + j);
            *(arr + j) = *(arr + j + 1);
            *(arr + j + 1) = temp;
        }
    }
    printf("after sorting, the arr :");//打印一下排序后的数组
    for(int i = 0; i < size; i++)
        printf("%d\t", *(arr + i));
    printf("\n");
}

int binarySearch(int* array, int size, int aimNUm)//二分查找
{
    if(size <= 0)//如果数组不存在
        return -1;
    int left = 0;
    int right = size - 1;
    while(left <= right)
    {
        int mid = (left + right) / 2;
        if(array[mid] < aimNUm)//如果目标数aimNum在右半部
        {
            left = mid + 1;
        }
        else if(array[mid] > aimNUm)//如果目标数aimNum在左半部
        {
            right = mid - 1;
        }
        else//如果目标数aimNum刚好就是中间的
        {
            return mid;
        }
    }
    return -1;//找不到目标数
}

int main()
{
     int size = 0;
	int aimNUm = 0;
    printf("数组长度是:\n");
    scanf("%d", &size);//输入数组长度
    int arr[MAXSIZE];
    for(int i = 0; i < size; i++)
    {
        scanf("%d", &arr[i]);
    }
	printf("要查的数:\n");
	scanf("%d", &aimNUm);
    sequence(arr, size);//排序，为下一步二分查找做准备
    printf("%d is located in %d", aimNUm, binarySearch(arr, 9, aimNUm));//二分查找

    return 0;
}