package d00.ex03;

import java.util.Scanner;

public class Program {
    private static long storage = 0L;

    private static boolean checkUserInput(int i, String line) {
        if (line.equals("42")) {
            return true;
        }
        if (line.equals("Week " + i) == false) {
            System.err.println("theIllegalArgument");
            System.exit(-1);
        }
        return false;
    }

    private static int getMin(Scanner in) {
        int grade;
        int minGrade = 9;
        for (int i = 0; i < 5; i++) {
            grade = in.nextInt();
            if (grade < minGrade) {
                minGrade = grade;
            }
        }
        return minGrade;
    }

    private static void displayOneWeek(int grade) {
        for (int i = 0; i < grade; i++) {
            System.out.print("=");
        }
        System.out.println(">");
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int weekDay = 0, rank = 1;
        while (weekDay < 18) {
            if (checkUserInput(++weekDay, in.nextLine())) {
                break;
            }
            storage += getMin(in) * rank;
            rank *= 10;
            in.nextLine();
        }
        in.close();
        int mod = 10, div = 1;
        for (int i = 0; i < weekDay - 1; i++) {
            int res = (int) (storage % mod / div);
            System.out.print("Week " + (i + 1) + " ");
            displayOneWeek(res);
            mod *= 10;
            div *= 10;
        }
    }
}
