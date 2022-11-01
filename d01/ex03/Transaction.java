import java.util.UUID;

public class Transaction {
    private UUID identifier;
    private User recipient;
    private User sender;
    private String transferCategory;
    private int transferAmount;

    public Transaction(User user1, User user2, int transferAmount) {
        if (transferAmount < 0) {
            sender = user1;
            recipient = user2;
            transferCategory = "credit";
        } else {
            sender = user2;
            recipient = user1;
            transferCategory = "debit";
        }
        this.transferAmount = transferAmount;
        this.identifier = UUID.randomUUID();
        setTransferAmount(transferAmount);
    }

    public UUID getIdentifier() {
        return identifier;
    }

    public User getRecipient() {
        return recipient;
    }

    public User getSender() {
        return sender;
    }

    public String getTransferCategory() {
        return transferCategory;
    }

    public int getTransferAmount() {
        return transferAmount;
    }

    public void setTransferAmount(int amount) {
        int newSenderBalance = sender.getBalance() + amount;
        if (newSenderBalance < 0) {
            System.err.println("ERROR: Sender balance is not enough");
            System.exit(-1);
        }
        sender.setBalance(newSenderBalance);
        recipient.setBalance(recipient.getBalance() - amount);
        this.transferAmount = amount;
    }

    public void tellAboutTransaction() {
        System.out.println("==================================================================");
        System.out.print("Transaction " + identifier);
        System.out.print(" from " + sender.getName());
        System.out.println(" to " + recipient.getName());
        System.out.println("Transfer category: " + transferCategory);
        System.out.println("Transfer amount: " + transferAmount);
        System.out.println("==================================================================");
    }
}
