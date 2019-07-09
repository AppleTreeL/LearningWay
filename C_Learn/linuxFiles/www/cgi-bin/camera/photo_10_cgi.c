#include <stdio.h> 
#include <stdlib.h>
#include "cgi.h"
#include <iconv.h>
#include <string.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/wait.h>
#include <sys/ipc.h>
#include <sys/msg.h>

int main( )
{
	char *sw_id;
	s_cgi *cgi;
	
	cgi = cgiInit();
	
	printf("%s%c%c\n","Content-Type:text/html;charset=utf-8",13,10); 
	printf("连拍拍照中，请稍候。。");

	pid_t pid1;
	pid1 = fork();

	if(pid1 < 0)
		perror("fork:");
	else if (pid1 == 0)
	{
		umask(0);
		int i;
		for(i = 0;i<getdtablesize();i++)
		{
			close(i);
		}
		system("echo laomi > /tmp/webcom");
		exit(0);
	}
	printf("<meta http-equiv=\"refresh\" content=\"1;url=../../camera.html\">");
}
