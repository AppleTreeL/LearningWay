
CC := arm-linux-gcc

all:
	$(CC) -o pwmstart_cgi.cgi pwmstart_cgi.c -lcgi -L../cgilib/ -I../include/
	$(CC) -o pwmstop_cgi.cgi pwmstop_cgi.c -lcgi -L../cgilib/ -I../include/
	make -C app/
clean:
	rm -f *.cgi
	make -C app/ clean
	
