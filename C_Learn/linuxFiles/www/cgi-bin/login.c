#include <stdio.h>
#include <stdlib.h>

int main(void)
{
    //��������
	char *str_len=NULL;
	int len=0;
	char buf[100]="";	
	char user[20]="";
	char passwd[20]="";
	char *u = "root";
	char *p = "laomi";
	//�����ҳ�ĸ�ʽ
	printf("%s\r\n\r\n","Content-Type:text/html");
  //	printf("<html>\n<head>\n<title> CGI3:log name</title></head>\n");
	//��ȡ������
	str_len = getenv("CONTENT_LENGTH");	
	//�ж������Ƿ�Ϊ��
	if( (str_len==NULL)  || (sscanf(str_len, "%d", &len)!=1) || (len>80) )
		printf("sorry!error!");
	//��stdin��ȡ���ݷ���buf��	
	fgets(buf, len+1, stdin);
	//�������ݣ�����user,passwd��
	sscanf(buf, "Username=%[^&]&Password=%s", user,passwd);
	//�ж��û��Ƿ�root �����Ƿ�123456�������ȷ����ת�����ܼҾ�ҳ��
	if( (strcmp(user,u)==0) && (strcmp(passwd,p)==0) )
	{
		printf("<Iframe src=\"http://192.168.1.230/main.html\" frameBorder=0  height=\"100%\" width=\"100%\" >  </iframe> ");
	}
	else
	{
		printf("<h1>Sorry! username or passwd error 9527��");	
	}
		return 0;
}
