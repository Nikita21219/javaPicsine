import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        FileManager fm = new FileManager(args[0]);
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        while (!line.equals("exit")) {
            fm.execCommand(line);
            line = in.nextLine();
        }
        in.close();
    }
}
