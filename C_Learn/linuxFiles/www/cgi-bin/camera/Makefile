
CC := arm-linux-gcc

all:
	$(CC) -o camera_cgi.cgi camera_cgi.c -lcgi -L../cgilib/ -I../include/
	$(CC) -o cameraclose_cgi.cgi cameraclose_cgi.c -lcgi -L../cgilib/ -I../include/
	$(CC) -o photohis_cgi.cgi photohis_cgi.c -lcgi -L../cgilib/ -I../include/
	$(CC) -o photo_1_cgi.cgi photo_1_cgi.c -lcgi -L../cgilib/ -I../include/
	$(CC) -o photo_10_cgi.cgi photo_10_cgi.c -lcgi -L../cgilib/ -I../include/
clean:
	rm -f *.cgi
	
