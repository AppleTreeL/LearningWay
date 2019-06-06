#include<stdio.h>

void drawMap(int row, int col) {
	int i = 0;
	int j = 0;
	for (i = 0; i < row; i++) {
		for (j = 0; j < col; j++) {
			printf("+");
		}
		printf("\n");
	}
}

void player_1Set(int row, int col, char** map) {
	map[row][col] = '*';
}

void player_2Set(int row, int col, char** map) {
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

void judgeWinner(int row, int col, int rowNum, int  colNum, char map[3][6]) {
	/*ºáÏòÅĞ¶Ï*/
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


	/*×İÏòÅĞ¶Ï*/
	for (i = row; j < rowNum -1; i++) {
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

	/*ÕıĞ±ÏòÅĞ¶Ï*/
	for (i = row; i < rowNum -1; i ++) {
		for (j = col; j < colNum; j++) {
			if (map[i][j] != map[i + 1][j + 1]) {
				break;
			}
			counter += 1;
		}
	}
	checkWinner(counter, map[i][j]);
	for (i = row; i >1; i--) {
		for (j = col; j > 0; j--) {
			if (map[i][j] != map[i - 1][j - 1]) {
				break;
			}
			counter += 1;
		}
	}
	checkWinner(counter, map[i][j]);
	printf("No winner");
}

int main() {
	char map[3][5] = {
	'*','*','*','*','*',
	'*','*','#','*','*',
	'*','*','#','*','#'
	};
	judgeWinner(0, 0, 3, 5, map);
	return 0;
}