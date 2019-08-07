package DayTest02;

import java.util.Scanner;

/**
 * @Classname FIngerGuessing
 * @Description 猜拳游戏
 * @Date 2019/8/7 14:09
 * @Created by AppleTree
 */
public class FIngerGuessing {

    /**
     * 判断赢家，平局返回字符串"Peace", A赢返回"A", B赢返回"B"
     * @param playerA, 玩家A
     * @param playerB, 玩家B
     * @return 平局返回字符串"Peace", A赢返回"A", B赢返回"B"
     */
    public static final String judgeWinner(String playerA, String playerB) {
        if(playerA.equals("C") && playerB.equals("J")) {
            return "A";
        }
        if(playerA.equals("C") && playerB.equals("B")) {
            return "B";
        }
        if(playerA.equals("C") && playerB.equals("C")) {
            return "Peace";
        }

        if(playerA.equals("J") && playerB.equals("B")) {
            return "A";
        }
        if(playerA.equals("J") && playerB.equals("C")) {
            return "B";
        }
        if(playerA.equals("J") && playerB.equals("J")) {
            return "Peace";
        }

        if(playerA.equals("B") && playerB.equals("C")) {
            return "A";
        }
        if(playerA.equals("B") && playerB.equals("J")) {
            return "B";
        }
        if(playerA.equals("B") && playerB.equals("B")) {
            return "Peace";
        }
        return null;
    }

    /**
     * 统计玩家胜利数
     * @param strings 记录猜拳结果情况的
     * @param player  统计对象
     * @return 赢的次数
     */
    public static final int countWin(String[] strings, String player) {

        int count = 0;
        for (int i = 0; i < strings.length; i++) {
            if(strings[i].equals(player))
                count += 1;
        }
        return count;
    }

    /**
     * 统计平局数量
     * @param strings, 猜拳的结果集
     * @return 返回平局数
     */
    public static final int countPeace(String[] strings) {
        int count = 0;
        for (int i = 0; i < strings.length; i++) {
            if(strings[i].equals("Peace")) {
                count += 1;
            }
        }
        return count;
    }


    /**
     * 输赢结果输出
     */
    public static final void countRes() {
        Scanner scanner = new Scanner(System.in);
        int times = scanner.nextInt();
        String[][] player = new String[times][2];
        //String[] playerB = new String[times];
        for (int i = 0; i <times ; i++) {
            for (int j = 0; j < 2; j++) {
                player[i][j] = scanner.next();
            }
        }

        int countA_C = 0;
        int countA_J = 0;
        int countA_B = 0;
        int countB_C = 0;
        int countB_J = 0;
        int countB_B = 0;
        String[] res = new String[times];
        for (int i = 0; i < player.length; i++) {
            res[i] = judgeWinner(player[i][0], player[i][1]);
            if(res[i].equals("A") && player[i][0].equals("C")) {
                countA_C += 1;
            }
            if(res[i].equals("A") && player[i][0].equals("J")) {
                countA_J += 1;
            }
            if(res[i].equals("A") && player[i][0].equals("B")) {
                countA_B += 1;
            }

            if(res[i].equals("B") && player[i][1].equals("C")) {
                countB_C += 1;
            }
            if(res[i].equals("B") && player[i][1].equals("J")) {
                countB_J += 1;
            }
            if(res[i].equals("B") && player[i][1].equals("B")) {
                countB_B += 1;
            }
        }

        String MAXA = null;
        if(countA_B > countA_C && countA_B > countA_J) {
            MAXA = "B";
        }
        if(countA_C > countA_B && countA_C > countA_J) {
            MAXA = "C";
        }
        if(countA_J > countA_B && countA_J > countA_C) {
            MAXA = "J";
        }
        //=============================================
        if(countA_B == countA_C && countA_B > countA_J) {
            MAXA = "B";
        }
        if(countA_C == countA_B && countA_C > countA_J) {
            MAXA = "B";
        }
        if(countA_J == countA_B && countA_J > countA_C) {
            MAXA = "B";
        }


        String MAXB = null;
        if(countB_B > countA_C && countB_B > countB_J) {
            MAXB = "B";
        }
        if(countB_C > countA_B && countB_C > countB_J) {
            MAXB = "C";
        }
        if(countB_J > countA_B && countB_J > countB_C) {
            MAXB = "J";
        }
        //=============================================
        if(countB_B == countA_C && countB_B > countB_J) {
            MAXB = "B";
        }
        if(countB_C == countA_B && countB_C > countB_J) {
            MAXB = "B";
        }
        if(countB_J == countA_B && countB_J > countB_C) {
            MAXB = "B";
        }

        System.out.println(countWin(res, "A") + " " + countPeace(res) + " " +
                (times - countWin(res, "A") - countPeace(res)));
        System.out.println(countWin(res, "B") + " " + countPeace(res) + " " +
                (times - countWin(res, "B") - countPeace(res)));
        System.out.println(MAXA + " " + MAXB);
    }

    public static void main(String[] args) {
        countRes();
    }
}
