#include <stdio.h>
#include <stddef.h>
#include <sys/stat.h>
#include <dirent.h>
#include <stdlib.h>
#include <iconv.h>
#include <string.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/wait.h>
#include "cgi.h"

int main(void)
{	
	char name[50]="\0";

	DIR *dp;
	struct dirent *ep;
	struct stat st;
	
	printf("%s%c%c\n","Content-Type:text/html;charset=utf-8",13,10);
	printf("<TITLE>历史照片</TITLE>\n");
	printf("<table align=\"center\" border=\"1\" bordercolor=\"#000000\" cellspacing=\"4\">");
	dp=opendir("/www/pics");
	chdir("/");
	if(dp!=NULL)
	{
		while(ep=readdir(dp))
		{
			if(ep->d_name[0]!='.')
			{
						
				printf("<tr><td>");
				printf("%s  ",ep->d_name);	
				printf("</td>");
				printf("<td>");
				printf("<img align=\"middle\" src=\"../../pics/%s\" width=\"640\" height=\"480\" />",ep->d_name);	
				printf("</td></tr>");
			}
		}
	}

	printf("</table>");
//	printf("</table><br/><a href=\"../../main.html#!/page_camera\">返回</a>");
	//printf("</table><br/><a href=\"../../camera.html\">返回</a>");
	//printf("<meta http-equiv=\"refresh\" content=\"15\">");
}
