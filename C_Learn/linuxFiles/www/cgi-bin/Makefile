CC := arm-linux-gcc
all:
	$(CC) -o login.cgi login.c -lcgi -Lcgilib/ -Iinclude/
	make -C air/
	make -C camera/
	make -C door/
	make -C lamp/
	make -C light/
	make -C safety/
clean:
	make -C air/    clean
	make -C camera/ clean
	make -C door/   clean
	make -C lamp/   clean
	make -C light/  clean
	make -C safety/ clean
	rm -f *.cgi
