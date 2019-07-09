
CC := arm-linux-gcc

all:
	$(CC) -o safety_open_cgi.cgi safety_open.c -lcgi -L../cgilib/ -I../include/
	$(CC) -o safety_close_cgi.cgi safety_close.c -lcgi -L../cgilib/ -I../include/
clean:
	rm -f *.cgi
	
