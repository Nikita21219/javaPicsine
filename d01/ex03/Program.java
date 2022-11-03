package d01.ex03;
public class Program {
    public static void main(String[] args) {
        User user1 = new User("user42", 500);
        User user2 = new User("user21", 999);

        UsersArrayList usersList = new UsersArrayList();
        usersList.addUser(user2);
        usersList.addUser(user1);

        TransactionsList list = user1.getTransactions();
        list.addTransaction(new Transaction(user1, user2, 100));
        list.addTransaction(new Transaction(user2, user1, -450));
        Transaction[] array = list.toArray();
        for (int i = 0; i < array.length; i++) {
            array[i].tellAboutTransaction();
        }
    }
}
