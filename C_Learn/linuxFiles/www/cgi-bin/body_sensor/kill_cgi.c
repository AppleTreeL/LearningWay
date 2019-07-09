#include <stdio.h>
#include <stdlib.h>
#include <sys/types.h>
#include <sys/ioctl.h>
#include <sys/stat.h>
#include <fcntl.h>

#include "ioctl.h"

int main( )
{
	int fd;
	int ret;

	printf("%s%c%c","Content-Type:text/html;charset=gb2312\n\n",13,10);

	system("killall -9 check_sensor");
	
	if ((fd = open("/dev/beep", O_RDWR)) < 0) {
		perror("open");
		return -1;
	}

	ret = ioctl(fd, BEEP_MUTE);
	if (ret < 0) {
		perror("ioctl");
		return -1;
	}
	
	close(fd);

	/*	if(fork()==0)
	 *	{execl("./execl/video_close","./execl/video_close",NULL);}*/
	printf("<META HTTP-EQUIV=\"REFRESH\" content=\"0;url=../../safety.html\">");
	printf("</HEAD>");
	return 0;
}
