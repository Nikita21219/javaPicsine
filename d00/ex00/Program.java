package d00.ex00;

public class Program {
    public static void main(String[] args) {
        int number = 479598;
        int result = 0;
        result += number % 10;
        result += number % 100 / 10;
        result += number % 1000 / 100;
        result += number % 10000 / 1000;
        result += number % 100000 / 10000;
        result += number % 1000000 / 100000;
        System.out.println(result);
    }
}
