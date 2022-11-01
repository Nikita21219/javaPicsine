import java.util.UUID;

public class Transaction {
    private UUID identifier;
    private User recipient;
    private User sender;
    private String transferCategory;
    private int transferAmount;

    public Transaction(User user1, User user2, String transferCat, int transferAmount) {
        if (transferCat.equals("debit")) {
            this.recipient = user1;
            this.sender = user2;
        } else if (transferCat.equals("credit")) {
            this.recipient = user2;
            this.sender = user1;
        } else {
            System.err.println("ERROR: Transfer category is invalid");
            System.exit(-1);
        }
        if (transferAmount < 0) {
            System.err.println("ERROR: Transfer amount must be bigger than 0");
            System.exit(-1);
        }
        this.identifier = UUID.randomUUID();
        transferCategory = transferCat;
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

    public void setTransferAmount(int transferAmount) {
        int newSenderBalance = sender.getBalance() - transferAmount;
        if (newSenderBalance < 0) {
            System.err.println("ERROR: Sender balance is low");
            System.exit(-1);
        }
        sender.setBalance(newSenderBalance);
        recipient.setBalance(recipient.getBalance() + transferAmount);
        this.transferAmount = transferAmount;
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
