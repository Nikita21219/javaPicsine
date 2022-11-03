package d01.ex02;
public interface UsersList {
    public void addUser(User user);
    public User getUserById(int id) throws UserNotFoundException;
    public User getUserByIndex(int idx);
    public int getNumberOfUsers();
}
