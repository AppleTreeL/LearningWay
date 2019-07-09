#include <stdio.h>
#include <stdlib.h>

int main(void)
{
    //定义数据
	char *str_len=NULL;
	int len=0;
	char buf[100]="";	
	char user[20]="";
	char passwd[20]="";
	char *u = "root";
	char *p = "laomi";
	//输出网页的格式
	printf("%s\r\n\r\n","Content-Type:text/html");
  //	printf("<html>\n<head>\n<title> CGI3:log name</title></head>\n");
	//获取表单数据
	str_len = getenv("CONTENT_LENGTH");	
	//判断数据是否为空
	if( (str_len==NULL)  || (sscanf(str_len, "%d", &len)!=1) || (len>80) )
		printf("sorry!error!");
	//从stdin获取数据放入buf中	
	fgets(buf, len+1, stdin);
	//解析数据，存入user,passwd中
	sscanf(buf, "Username=%[^&]&Password=%s", user,passwd);
	//判断用户是否root 密码是否123456，如果正确，跳转到智能家居页面
	if( (strcmp(user,u)==0) && (strcmp(passwd,p)==0) )
	{
		printf("<Iframe src=\"http://192.168.1.230/main.html\" frameBorder=0  height=\"100%\" width=\"100%\" >  </iframe> ");
	}
	else
	{
		printf("<h1>Sorry! username or passwd error 9527！");	
	}
		return 0;
}
