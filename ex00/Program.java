public class Program {
    public static void main(String[] args) {
        int number = 479598;
        int result = 0;
        for (int i = 0, mod = 10, div = 1; i < 6; i++, mod *= 10, div *= 10) {
            result += number % mod / div;
        }
        System.out.println(result);
    }
}
