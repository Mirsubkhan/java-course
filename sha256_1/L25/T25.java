package L25;

import java.util.*;
import java.util.stream.Collectors;

class Transaction {
    private String transactionId;
    private String userId;
    private double amount;

    public Transaction(String transactionId, String userId, double amount) {
        this.transactionId = transactionId;
        this.userId = userId;
        this.amount = amount;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public String getUserId() {
        return userId;
    }

    public double getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "transactionId='" + transactionId + '\'' +
                ", userId='" + userId + '\'' +
                ", amount=" + amount +
                '}';
    }
}

public class T25 {
    public static Set<String> findDuplicateTransactions(List<Transaction> transactions) {
        Set<String> seen = new HashSet<>();
        Set<String> duplicates = new HashSet<>();

        for (Transaction transaction : transactions) {
            if (!seen.add(transaction.getTransactionId())) {
                duplicates.add(transaction.getTransactionId());
            }
        }

        return duplicates;
    }

    public static Map<String, Double> calculateUserBalances(List<Transaction> transactions) {
        Map<String, Double> userBalances = new HashMap<>();

        for (Transaction transaction : transactions) {
            userBalances.put(
                    transaction.getUserId(),
                    userBalances.getOrDefault(transaction.getUserId(), 0.0) + transaction.getAmount()
            );
        }

        return userBalances;
    }

    public static List<Transaction> filterLargeTransactions(List<Transaction> transactions, double threshold) {
        return transactions.stream()
                .filter(transaction -> transaction.getAmount() > threshold)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<Transaction> transactions = Arrays.asList(
                new Transaction("tx1", "user1", 100.0),
                new Transaction("tx2", "user2", 150.0),
                new Transaction("tx3", "user1", 200.0),
                new Transaction("tx1", "user3", 50.0),
                new Transaction("tx4", "user2", 300.0)
        );

        Set<String> duplicates = findDuplicateTransactions(transactions);
        System.out.println("Duplicate Transaction IDs: " + duplicates);

        Map<String, Double> userBalances = calculateUserBalances(transactions);
        System.out.println("User Balances: " + userBalances);

        List<Transaction> largeTransactions = filterLargeTransactions(transactions, 150.0);
        System.out.println("Large Transactions: " + largeTransactions);
    }
}

