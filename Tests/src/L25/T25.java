package L25;

import java.util.*;
import java.util.stream.Collectors;


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
}

