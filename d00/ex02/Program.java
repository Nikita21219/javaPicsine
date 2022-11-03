package d00.ex02;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        int sum, countDigit, result = 0;
        while (true) {
            if (num == 42) {
                break;
            }
            if (num < 0) {
                num = in.nextInt();
                continue;
            }
            countDigit = 0;
            for (int div = 1; num / div > 0; div *= 10) {
                countDigit++;
            }
            sum = 0;
            for (int i = 0, mod = 10, div = 1; i < countDigit; mod *= 10, div *= 10, i++) {
                sum += num % mod / div;
            }
            boolean isPrime = true;
            for (int j = 2; j * j <= sum; j++) {
                if (sum % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                result += 1;
            }
            num = in.nextInt();
        }
        in.close();
        System.err.println("Count of coffee - request - " + result);
    }
}
