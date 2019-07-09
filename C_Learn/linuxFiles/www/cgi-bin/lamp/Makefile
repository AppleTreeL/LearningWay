
CC := arm-linux-gcc

all:
	$(CC) -o lamp_open_cgi.cgi lamp_open.c -lcgi -L../cgilib/ -I../include/
	$(CC) -o lamp_close_cgi.cgi lamp_close.c -lcgi -L../cgilib/ -I../include/
	$(CC) -o lamp_stop_cgi.cgi lamp_stop.c -lcgi -L../cgilib/ -I../include/
clean:
	rm -f *.cgi
	
