#define _CRT_SECURE_NO_WARNINGS


#include <stdio.h>
#include <stdlib.h>
#include <time.h>

//#include <windows.h>

//#pragma comment(lib, "Winmm.lib")

void guessNum()
{
	
	srand((unsigned)time(NULL)% 100 ) ;
	int aimNum = rand() % 100;
	//int aimNum = 98;
	int userIn = 0;

	while (1)
	{
		scanf("%d", &userIn);
		if (userIn > aimNum)
			printf("too big\n");
		if (userIn < aimNum)
			printf("too small\n");
		if (userIn == aimNum)
		{
			printf("right, congratulations!\n");
			/*mciSendString("E:\CloudMusic\������ - ����ȼ��.mp3",        //MCI�����ַ���
			        		NULL,                                //��ŷ�����Ϣ�Ļ�����
					        0,                                    //�������ĳ���       
							 NULL); */

			break;
		}
	}
}

int main()
{
	guessNum();
	return 0;
}