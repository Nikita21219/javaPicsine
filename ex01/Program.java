import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        in.close();
        if (num <= 1) {
            System.err.println("theIllegalArgument");
            System.exit(-1);
        }
        int i = 2;
        while (i * i <= num) {
            if (num % i == 0) {
                System.out.print("false ");
                System.out.println(i - 1);
                System.exit(0);
            }
            i++;
        }
        System.out.print("true ");
        System.out.println(i - 1);
    }
}
