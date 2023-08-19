package week1.day4.concurrency;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.locks.ReentrantLock;

public class ComputeTransactions implements Runnable {
    volatile boolean sw = true;
    ConcurrentLinkedQueue<Transaction> transactions = null;
    ReentrantLock lock = new ReentrantLock();
    long[] deposit;

    public ComputeTransactions(ConcurrentLinkedQueue<Transaction> assignedTransaction, long deposit[]) {
        this.deposit = deposit;
        this.transactions = assignedTransaction;
    }

    public void compute(Transaction assignedTransaction) throws InterruptedException {

        lock.lock();
        deposit[assignedTransaction.getToAccount()-1] += assignedTransaction.getAmount();
        deposit[assignedTransaction.getFromAccount()-1] -= assignedTransaction.getAmount();
        lock.unlock();
    }
    @Override
    public void run() {

        Transaction assignedTransaction;
        while (true) {
            try {
                assignedTransaction = transactions.poll();
                if (assignedTransaction == null) {
                    break;
                }
                compute(assignedTransaction);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }



}