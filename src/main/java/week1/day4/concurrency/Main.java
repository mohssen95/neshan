package week1.day4.concurrency;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.stream.Stream;

import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    private static String readFile(String filename) throws IOException {
        return new String(
                Objects.requireNonNull(
                        Main.class.getResourceAsStream(filename)
                ).readAllBytes()
        );
    }

    private static final String COMMA_DELIMITER = ",";

    public static void main(String[] args) throws InterruptedException {

        ConcurrentLinkedQueue<Transaction> records = new ConcurrentLinkedQueue<>();
        long[] deposit = new long[15];
        long[] depositBackup = new long[15];

        try (Stream<String> lines = Arrays.stream(readFile("/transactions.csv").split(System.lineSeparator()))) {
            lines.forEach(line -> {
                line = line.replace("\"", "");
                String[] values = line.split(COMMA_DELIMITER);
                records.add(
                        new Transaction(
                                parseInt(values[0]),
                                parseInt(values[1]),
                                parseLong(
                                        values[2]
                                                .concat(
                                                        values[3]
                                                )
                                )
                        )
                );
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            String[] lines = readFile("/backupDeposit").split(System.lineSeparator());

            for (int i = 0; i < lines.length; i++) {

                depositBackup[i] = parseLong(lines[i]);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        ComputeTransactions computeTransactions = new ComputeTransactions(records, deposit);
        Thread thread = new Thread(computeTransactions);
        Thread thread1 = new Thread(computeTransactions);
        Thread thread2 = new Thread(computeTransactions);
        Thread thread3 = new Thread(computeTransactions);

        thread.setName("t1");
        thread1.setName("t2");
        thread2.setName("t3");
        thread3.setName("t4");

        thread.start();
        thread1.start();
        thread2.start();
        thread3.start();

        thread.join();
        thread1.join();
        thread2.join();
        thread3.join();

        Arrays.stream(deposit).forEach(System.out::println);
        System.out.println("compare two deposits:");
        for (int i = 0; i < deposit.length; i++) {
            System.out.println(deposit[i]+depositBackup[i]);
        }


    }
}
