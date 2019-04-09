#include <stdio.h>
#include <stdlib.h>
#include <string.h>

void menu()
{
    system("cls");
    printf("*****-1.login-*****\n");
    printf("*****-2.exit-*****\n");
}

void  login()
{
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
    #if 0
    system("cls");
    int count = 0;
    char pass[3];
    char origionPass[3];
    strcpy(origionPass, "abc");
    printf("please input your password:\n");
    do{
        scanf("%s", &pass);
        //fgets(pass, 3, stdin);
        //gets(pass);
        //for(int i = 0; i < 3; i++)
        //    pass[i] = char(getchar());
        //printf("%s", pass[0]);
            
        if(strcmp (pass, origionPass) == 0)
        {
            printf("right, congratulations!");
            return 1;
        }
        else 
        {
            printf("erros\n");
            count += 1;
        }
    }while(count <= 3);
    printf(" sorry ,erros occurred 3 times, exit");
    return -1;
   #endif
}

int main()
{
    login();
    #if 0
    int choice = 0;
    int flag = 0;
    menu();
    while(1)
    {
        scanf("%d", &choice);
        switch (choice)
        {
            case 1:flag = login();
                break;
            case 2:return 0;
                break;
            default:
                break;
        }
        if(flag == -1) break;
    }
    #endif
    return 0;
}