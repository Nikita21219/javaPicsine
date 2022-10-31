public class Main {
    public static void main(String[] args) {
        String regex = "[0-9]+";
        if (args.length != 1 || args[0].length() != 6 || args[0].matches(regex) == false) {
           System.out.println("Error");
        } else {
            int result = 0;
            String arg = args[0];
            for (int i = 0; i < 6; i++) {
               result += Character.getNumericValue(arg.charAt(i));
            }
           System.out.println(result);
        }
    }
}
