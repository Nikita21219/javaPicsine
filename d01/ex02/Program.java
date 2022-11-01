public class Program {
    public static void main(String[] args) {
        User user1 = new User("user42", 500);
        User user2 = new User("user21", 999);

        UsersArrayList usersList = new UsersArrayList();
        usersList.addUser(user2);
        usersList.addUser(user1);

        try {
            System.out.println(usersList.getUserById(0).getName());
        } catch (UserNotFoundException e) {
            System.err.println(e.getMessage());
        }
    }
}
