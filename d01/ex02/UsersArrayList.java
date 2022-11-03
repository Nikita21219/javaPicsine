package d01.ex02;

import java.util.ArrayList;

public class UsersArrayList implements UsersList {
    private ArrayList<User> users;

    public UsersArrayList() {
        users = new ArrayList<>();
    }

    public void addUser(User user) {
        users.add(user);
    }

    public User getUserById(int id) throws UserNotFoundException {
        User user;
        for (int i = 0; i < users.size(); i++) {
            user = users.get(i);
            if (user.getIdentifier() == id) {
                return user;
            }
        }
        throw new UserNotFoundException("Exception: user not found");
    }

    public User getUserByIndex(int idx) {
        return users.get(idx);
    }

    public int getNumberOfUsers() {
        return 0;
    }

}
