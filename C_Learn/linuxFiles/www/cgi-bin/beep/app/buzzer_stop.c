
#include <stdio.h>
#include <termios.h>
#include <unistd.h>
#include <stdlib.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>


#include "ioctl.h"

int main(void)
{
	int fd, ret;	

	fd = open("/dev/beep", O_RDWR | O_NDELAY);

	if(fd < 0){
		perror("open");
		exit(1);
	}

	ret = ioctl(fd, BEEP_MUTE);
	if(ret < 0) {
		perror("stop the buzzer");
		exit(1);
	}

	close(fd);

	return 0;
}

