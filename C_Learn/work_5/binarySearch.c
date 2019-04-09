#define MAXSIZE 100
#include <stdio.h>

void sequence(int* arr, int size)//��������������Ա���ж��ֲ���
{
     printf("origional arr is:\t");//��ӡһ��ԭ��������
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
    printf("after sorting, the arr :");//��ӡһ������������
    for(int i = 0; i < size; i++)
        printf("%d\t", *(arr + i));
    printf("\n");
}

int binarySearch(int* array, int size, int aimNUm)//���ֲ���
{
    if(size <= 0)//������鲻����
        return -1;
    int left = 0;
    int right = size - 1;
    while(left <= right)
    {
        int mid = (left + right) / 2;
        if(array[mid] < aimNUm)//���Ŀ����aimNum���Ұ벿
        {
            left = mid + 1;
        }
        else if(array[mid] > aimNUm)//���Ŀ����aimNum����벿
        {
            right = mid - 1;
        }
        else//���Ŀ����aimNum�պþ����м��
        {
            return mid;
        }
    }
    return -1;//�Ҳ���Ŀ����
}

int main()
{
     int size = 0;
	int aimNUm = 0;
    printf("���鳤����:\n");
    scanf("%d", &size);//�������鳤��
    int arr[MAXSIZE];
    for(int i = 0; i < size; i++)
    {
        scanf("%d", &arr[i]);
    }
	printf("Ҫ�����:\n");
	scanf("%d", &aimNUm);
    sequence(arr, size);//����Ϊ��һ�����ֲ�����׼��
    printf("%d is located in %d", aimNUm, binarySearch(arr, 9, aimNUm));//���ֲ���

    return 0;
}