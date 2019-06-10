
#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>
#include <stdio.h>
#include <unistd.h>
#include <string.h>

int main(int argc, char *argv[])
{
    char buff[128] ={0};
    if(argc != 2){
        printf("Usage %s file \n",argv[0]);
	return -1;
    }

    int fd = open(argv[1],O_RDONLY);
    if(fd < 0)
    {
        perror("open");
        return -1;
    }
    chdir(argv[1]);
    while(1)
    {
	bzero(buff,sizeof(buff));
        ssize_t ret = read(fd,buff,sizeof(buff)-1);
        if(ret == 0) break;
        printf("%s",buff);
    }
    close(fd);


    return 0;
}
