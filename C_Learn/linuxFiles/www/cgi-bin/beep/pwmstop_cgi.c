#include <stdio.h>
#include <stdlib.h>
#include <sys/types.h>
#include <sys/ioctl.h>
#include <sys/stat.h>
#include <fcntl.h>
#include "pwm.h"

int main( )
{
	int fd;
	printf("%s%c%c","Content-Type:text/html;charset=gb2312\n\n",13,10);

	system("/www/cgi-bin/beep/buzzer_stop");

	/*	if(fork()==0)
	 *	{execl("./execl/video_close","./execl/video_close",NULL);}*/
	printf("<HEAD><TITLE>wait a monment</TITLE>");	
	printf("<META HTTP-EQUIV=\"REFRESH\" content=\"0;url=../../main.html\">");
	printf("</HEAD>");
	return 0;
}
