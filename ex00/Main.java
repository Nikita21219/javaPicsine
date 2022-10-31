public class Main {
    public static void main(String[] args) {
        int num = 479598;
        String numAsString = Integer.toString(num);
        if (numAsString.length() != 6) {
           System.out.println("Error");
        } else {
            int result = 0;
            for (int i = 0; i < 6; i++) {
               result += Character.getNumericValue(numAsString.charAt(i));
            }
           System.out.println(result);
        }
    }
}
