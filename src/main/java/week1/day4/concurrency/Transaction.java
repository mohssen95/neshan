package week1.day4.concurrency;

public class Transaction {
    private int fromAccount,toAccount;
    private long amount;
    public Transaction(int froAacc,int toAcc,long amount){
        this.fromAccount=froAacc;
        this.toAccount=toAcc;
        this.amount=amount;

    }

    public int getFromAccount() {
        return fromAccount;
    }

    public int getToAccount() {
        return toAccount;
    }

    public long getAmount() {
        return amount;
    }
}
