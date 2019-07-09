#include <stdio.h>
#include <termios.h>
#include <unistd.h>
#include <stdlib.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>

#include "ioctl.h"

#define FREQ 3

int main(void)
{
	int fd, ret;	

	fd = open("/dev/beep", O_RDWR | O_NDELAY);

	if(fd < 0){
		perror("open");
		exit(1);
	}

	ret = ioctl(fd, BEEP_SET_HZ, FREQ);
	if(ret < 0) {
		perror("set the frequency of the buzzer");
		exit(1);
	}

	close(fd);

	return 0;
}