public class Program {
    public static void main(String[] args) {
        User user1 = new User("user42", 500, 1);
        User user2 = new User("user21", 999, 2);
        
        user1.getInfo();
        user2.getInfo();

        System.out.print("\n");

        Transaction transaction1 = new Transaction(user1, user2, -300);
        transaction1.tellAboutTransaction();

        user1.getInfo();
        user2.getInfo();

        Transaction transaction2 = new Transaction(user2, user1, -1200);
        transaction2.tellAboutTransaction();
        
        user1.getInfo();
        user2.getInfo();
    }
}
