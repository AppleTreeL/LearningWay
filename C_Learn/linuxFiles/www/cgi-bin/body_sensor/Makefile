
CC := arm-linux-gcc

all:
	$(CC) -o check_cgi.cgi check_cgi.c -lcgi -L../cgilib/ -I../include/
	$(CC) -o kill_cgi.cgi kill_cgi.c -lcgi -L../cgilib/ -I../include/
	$(CC) -o check_sensor check_sensor.c
clean:
	rm -f *.cgi check_sensor
	
