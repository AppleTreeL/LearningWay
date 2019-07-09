#include <stdio.h>
#include <stdlib.h>
#include <sys/types.h>
#include <sys/ioctl.h>
#include <sys/stat.h>
#include <fcntl.h>

#include "ioctl.h"

int main( )
{
	printf("%s%c%c","Content-Type:text/html;charset=gb2312\n\n",13,10);

	system("/www/cgi-bin/body_sensor/check_sensor");

	/*	if(fork()==0)
	 *	{execl("./execl/video_close","./execl/video_close",NULL);}*/
	printf("<META HTTP-EQUIV=\"REFRESH\" content=\"0;url=../../safety.html\">");
	printf("</HEAD>");
	return 0;
}
