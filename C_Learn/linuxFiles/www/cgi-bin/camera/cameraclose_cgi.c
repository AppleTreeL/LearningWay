#include <stdio.h>
#include <stdlib.h>
int main( )
{
	printf("%s%c%c","Content-Type:text/html;charset=gb2312\n\n",13,10);
	system("killall -9 mjpg_streamer");
//	system("../../cgi-bin/main ");
	/*	if(fork()==0)
	 *	{execl("./execl/video_close","./execl/video_close",NULL);}*/
//	printf("<HEAD><TITLE>wait a monment</TITLE>");	
	printf("<META HTTP-EQUIV=\"REFRESH\" content=\"0;url=../../camera.html\">");
	printf("</HEAD>");
	return 0;
}
