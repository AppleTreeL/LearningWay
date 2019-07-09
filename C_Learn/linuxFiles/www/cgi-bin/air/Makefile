
CC := arm-linux-gcc

all:
	$(CC) -o air_open_cgi.cgi air_open.c -lcgi -L../cgilib/ -I../include/
	$(CC) -o air_close_cgi.cgi air_close.c -lcgi -L../cgilib/ -I../include/
clean:
	rm -f *.cgi
	
