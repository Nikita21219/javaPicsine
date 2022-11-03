package d01.ex02;
public class User {
    private int identifier;
    private String name;
    private int balance;

    public User(String name, int balance) {
        setName(name);
        setBalance(balance);
        this.identifier = UserIdsGenerator.getInstance().generateId();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBalance(int balance) {
        if (balance < 0) {
            System.err.println("ERROR: Balance is less than 0");
            System.exit(-1);
        }
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public int getBalance() {
        return balance;
    }

    public int getIdentifier() {
        return identifier;
    }

    public void getInfo() {
        System.out.print("USER INFO: ");
        System.out.print("Name is " + getName());
        System.out.print("; Balance is " + getBalance());
        System.out.println("; User id is " + getIdentifier());
    }
}
