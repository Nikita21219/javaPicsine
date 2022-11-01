import java.util.LinkedList;
import java.util.UUID;

public class TransactionsLinkedList implements TransactionsList {
    private LinkedList<Transaction> transactions;

    public TransactionsLinkedList() {
        transactions = new LinkedList<>();
    }

    @Override
    public void addTransaction(Transaction tr) {
        transactions.add(tr);
    }

    @Override
    public void removeById(UUID id) throws TransactionNotFoundException {
        Transaction transaction;
        for (int i = 0; i < transactions.size(); i++) {
            transaction = transactions.get(i);
            if (transaction.getIdentifier() == id) {
                transactions.remove(i);
                break;
            }
        }
        throw new TransactionNotFoundException("Transaction not found((");
    }

    @Override
    public Transaction[] toArray() {
        Transaction[] array = new Transaction[transactions.size()];
        return transactions.toArray(array);
    }

    public int size() {
        return transactions.size();
    }
}
