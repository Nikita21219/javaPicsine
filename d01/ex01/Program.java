import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        User user1 = new User("user42", 500);
        User user2 = new User("user21", 999);
        user1.getInfo();
        user2.getInfo();
    }
}
