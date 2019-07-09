#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>
#include <unistd.h>
#include <sys/ioctl.h>
#include <string.h>
#include <stdio.h>

#include "ioctl.h"

int jbuzzer_off(int fd)
{
	int ret;

	ret = ioctl(fd, BEEP_MUTE);
	if (ret < 0) {
		perror("ioctl");
		return -1;
	}

	return 0;
}

int jbuzzer_on(int fd)
{
	int ret;

	ret = ioctl(fd, BEEP_SET_HZ, 5);

	if (ret < 0) {
		perror("ioctl");
		return -1;
	}

	return 0;
}

int main(int argc, char **argv)
{
	int fd;
	int fd_b;
	int ret;

	if ((fd = open("/dev/HC-SR501", O_RDWR)) < 0) {
		perror("open");
		return -1;
	}

	if ((fd_b = open("/dev/beep", O_RDWR)) < 0) {
		perror("open");
		return -1;
	}

	while (1) {
		ret = ioctl (fd, ENABLE_ALARM);
		if (ret) {
		//	printf("checked people...\n");
			jbuzzer_on(fd_b);
		} else {
			//printf("checked no people...\n");
			jbuzzer_off(fd_b);
		}
		sleep(1);
	}

	return 0;
}
