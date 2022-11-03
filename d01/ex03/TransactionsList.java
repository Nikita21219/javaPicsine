package d01.ex03;
import java.util.UUID;

public interface TransactionsList {
    public void addTransaction(Transaction tr);
    public void removeById(UUID id) throws TransactionNotFoundException;
    public Transaction[] toArray();
}
