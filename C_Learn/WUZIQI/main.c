#define _CRT_SECURE_NO_WARNINGS
#include<stdio.h>
#define COL 12
#define ROW 7

void drawMap(char map[ROW][COL]) {
	for (int i = 0; i < ROW; i++) {
		for (int  j = 0; j < COL; j++)
		{
			map[i][j] = '+';
		}
	}
}

void printMap(char map[ROW][COL]) {
	for (int i = 0; i < ROW; i++) {
		for (int j = 0; j < COL; j++)
		{
			printf("%c", map[i][j]);
		}
		printf("\n");
	}
}

void player_1Set(int row, int col, char map[ROW][COL]) {
	map[row][col] = '*';
}

void player_2Set(int row, int col, char map[ROW][COL]) {
	map[row][col] = '#';
}


int checkWinner(int num, char player) {
	if (num == 4) {
		if (player == '*') {
			printf("player_1 win");
			return 1;
		}
		else {
			printf("player_2 win");
			return 1;
		}
	}
	else {
		printf("No win");
		return 0;
	}
}

void judgeWinner(int row, int col, int rowNum, int  colNum, char map[ROW][COL]) {
	/*ºáÏòÅÐ¶Ï*/
	int i = row;
	int j = col;
	int counter = 0;
	for (j = col; j < colNum -1; j++) {
		if (map[i][j] != map[i][j + 1])
			break;
		counter += 1;
	}
	if (checkWinner(counter, map[i][j]) == 1) {
		checkWinner(counter, map[i][j]);
		return;
	}
	/*j = col;
	counter = 0;*/
	for (j = col; j > 1; j--) {
		if (map[i][j] != map[i][j - 1])
			break;
		counter += 1;
	}
	if (checkWinner(counter, map[i][j]) == 1) {
		checkWinner(counter, map[i][j]);
		return;
	}
	j = row;
	counter = 0;


	/*×ÝÏòÅÐ¶Ï*/
	for (i = row; i < rowNum -1; i++) {
		if (map[i][j] != map[i + 1][j])
			break;
		counter += 1;
	}
	if (checkWinner(counter, map[i][j]) == 1) {
		checkWinner(counter, map[i][j]);
		return;
	}
	/*i = row;
	counter = 0;*/
	for (i = row; i > 1; i--) {
		if (map[i][j] != map[i - 1][j])
			break;
		counter += 1;
	}
	if (checkWinner(counter, map[i][j]) == 1) {
		return;
	}
	i = row;
	counter = 0;

	/*ÕýÐ±ÏòÅÐ¶Ï*/
	for (i = row; i < rowNum -1; i ++) {
		for (j = col; j < colNum; j++) {
			if (map[i][j] != map[i + 1][j + 1]) {
				break;
			}
			counter += 1;
		}
	}
	if (checkWinner(counter, map[i][j]) == 1) {
		checkWinner(counter, map[i][j]);
		return;
	}
	for (i = row; i >1; i--) {
		for (j = col; j > 0; j--) {
			if (map[i][j] != map[i - 1][j - 1]) {
				break;
			}
			counter += 1;
		}
	}
	if (checkWinner(counter, map[i][j]) == 1) {
		checkWinner(counter, map[i][j]);
		return;
	}
	i = row;
	j = col;
	counter = 0;
	printf("No winner\n");
}

int main() {
	int x = 0;
	int y = 0;
	char map[ROW][COL];
	drawMap(map);
	while (1)
	{
		//system("cls");
		printf("please player_1 set\n");
		scanf("%d %d", &x, &y);
		player_1Set(x, y, map);
		judgeWinner(x, y, ROW, COL, map);
		printf("please player_2 set\n");
		scanf("%d %d", &x, &y);
		player_2Set(x, y, map);
		judgeWinner(x, y, ROW, COL, map);
		printMap(map);
	}
	//judgeWinner(0, 0, 3, 5, map);
	return 0;
}