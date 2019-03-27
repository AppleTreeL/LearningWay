#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include<string.h>
#include<math.h>
//实现函数init()   初始化数组、
void Init(int arr[],int len)//
{
	int i = 0;
	for(i = 0;i < len;i++)
	{
		arr[i] = i;
	}
}
//实现empty（）清空数组、
void Empty(int arr[],int len)
{
	int i = 0;
	for(i = 0;i < len;i++)
	{
		arr[i] = 0;
	}
}
void Show(int arr[],int len)
{
	int i = 0;
	for(i = 0;i < len;i++)
	{
		printf("%d ",arr[i]);
	}
	printf("\n");
}
//实现reverse（）函数完成数组元素的逆置。
void Reverse1(int arr[],int len)
{
	int i = 0;
	int j = len-1;
	while(i < j)
	{
		int tmp = 0;
		tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
		i++;
		j--;
	}
}
void Reverse(int arr[],int len)
{
	int i = 0;
	for(i = 0;i < len/2;i++)
	{
		int tmp = 0;
		tmp = arr[i];
		arr[i] = arr[len-1-i];
		arr[len-1-i] = tmp;
	}
}
int main()
{
	int arr[10];
	int len = sizeof(arr)/sizeof(arr[0]);
	Init(arr,len);
	Show(arr,len);//0-9
	Reverse(arr,len);
	//Empty(arr,len);
	Show(arr,len);//9-0
	return 0;
}

#if 0
/*如果是闰年，返回1，否则返回0*/
int LeapYear(int year)
{
	/*if((year%4==0 && year %100 != 0) || (year%400 == 0))
	{
		return 1;
	}
	return 0;*/
	return ((year%4==0 && year %100 != 0) || (year%400 == 0));
}
int Fun(int a,int b)
{
	return a==b;
}
int IsPrime(int n)
{
	int i = 0;
	for(i = 2;i <= sqrt((double)n);i++)
	{
		if(n%i == 0)
		{
			return 0;
		}
	}
	return 1;
}
int main()
{
	int i = 0;
	for(i = 1;i <= 200;i++)
	{
		if(IsPrime(i) == 1)
		{
			printf("%d\n",i);
		}
		/*if(LeapYear(i) == 1)
		{
			printf("%d\n",i);
		}*/
	}
	return 0;
}


/*
《程序员的自我修养》
第一章   第二章  第三章  第六章  第十章
《高质量C/C++编程》 《C缺陷和陷阱》 《C语言深度剖析》
*/
void Swap1(int a,int b)
{
	int tmp = 0;
	tmp = a;
	a = b;
	b = tmp;
}
void Swap2(int *p,int *q)
{
	int *tmp = p;
	p = q;
	q = tmp;
}
void Swap3(int *p,int *q)
{
	int *tmp;
	tmp = p;
	p = q;
	q = tmp;
}
//按址传递   
void Swap(int *p,int *q)
{
	int tmp = *p;
	*p = *q;
	*q = tmp;
}
int main()
{
	int a = 10;
	int b = 20;
	//int *p;//野指针
	//*p = 100;
	printf("%d,%d\n",a,b);
	Swap(&a,&b);
	////tmp = a;
	////a = b;
	////b = tmp;
	printf("%d,%d\n",a,b);
	return 0;
}


/*
功能：打印乘法口诀表
函数名称：Multiply
参数：n  代表n*n的口诀表
无返回值
Author:GAOBO
DATA:
*/
void Multiply(int n)
{
	int i = 0;
	for(i = 1;i <= n;i++)
	{
		int j = 0;
		for(j = 1;j <= i;j++)
		{
			printf("%d*%d=%d ",i,j,i*j);
		}
		printf("\n");
	}
}
void Fun(int n)
{
	Multiply(n);
}

int main()
{
	int n = 0;
	scanf("%d",&n);
	Multiply(n);
	///Fun(n);
	return 0;
}

//Unicode
int main()
{
	int ch;
	//ctr+c  中断程序
	while((ch = getchar()) != EOF)//end of file    -1   ctr+z
	{
		//123abc4deF  ===> ABCDEf
		if(ch>='a' && ch<='z')
		{
			putchar(ch-32);
		}
		else if(ch>='A' && ch<='Z')
		{
			putchar(ch+32);
		}
		else
		{
		}
	}
	return 0;
}


//NULL   '0'   '\0'   0
int main()
{
	/*int a = 10;
	int *p = NULL;*/
	//假设原来的密码：123456
	char password[20];
	int count = 3;//最多输入3次密码
	int i  = 0;
	for(i = 0;i < 3;i++)
	{
		printf("请输入密码：");
		scanf("%s",&password);
		if(0 == strcmp(password,"123456"))
		{
			printf("密码正确\n");
			break;
		}
		else
		{
			count--;
			printf("你还有%d次机会!\n",count);
		}
	}
	if(i < 3)
	{
		printf("登录成功\n");
	}
	else
	{
		printf("登录失败\n");
	}
	return 0;
}
#endif