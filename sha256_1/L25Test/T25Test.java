package L25Test;

import L25.T25;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class T25Test {

	@Test
    public void testFindDuplicateTransactions() {
        List<Transaction> transactions = Arrays.asList(
                new Transaction("tx1", "user1", 100.0),
                new Transaction("tx2", "user2", 150.0),
                new Transaction("tx3", "user1", 200.0),
                new Transaction("tx1", "user3", 50.0),
                new Transaction("tx4", "user2", 300.0)
        );

        Set<String> duplicates = T25.findDuplicateTransactions(transactions);
        assertEquals(1, duplicates.size(), "Should find one duplicate transaction ID");
        assertTrue(duplicates.contains("tx1"), "Duplicate transaction ID should be 'tx1'");
    }

    @Test
    public void testCalculateUserBalances() {
        List<Transaction> transactions = Arrays.asList(
                new Transaction("tx1", "user1", 100.0),
                new Transaction("tx2", "user2", 150.0),
                new Transaction("tx3", "user1", 200.0),
                new Transaction("tx4", "user2", 300.0)
        );

        Map<String, Double> userBalances = T25.calculateUserBalances(transactions);
        assertEquals(2, userBalances.size(), "There should be two users with balances");
        assertEquals(300.0, userBalances.get("user1"), "User1 balance should be 300.0");
        assertEquals(450.0, userBalances.get("user2"), "User2 balance should be 450.0");
    }

    @Test
    public void testFilterLargeTransactions() {
        List<Transaction> transactions = Arrays.asList(
                new Transaction("tx1", "user1", 100.0),
                new Transaction("tx2", "user2", 150.0),
                new Transaction("tx3", "user1", 200.0),
                new Transaction("tx4", "user2", 300.0)
        );

        List<Transaction> largeTransactions = T25.filterLargeTransactions(transactions, 150.0);
        assertEquals(2, largeTransactions.size(), "There should be two transactions with amounts greater than 150.0");
        assertTrue(largeTransactions.stream().anyMatch(t -> t.getAmount() == 200.0), "Transaction with 200.0 should be included");
        assertTrue(largeTransactions.stream().anyMatch(t -> t.getAmount() == 300.0), "Transaction with 300.0 should be included");
    }

    @Test
    public void testEmptyTransactionList() {
        List<Transaction> transactions = Collections.emptyList();

        Set<String> duplicates = T25.findDuplicateTransactions(transactions);
        assertTrue(duplicates.isEmpty(), "No duplicates should be found in an empty list");

        Map<String, Double> userBalances = T25.calculateUserBalances(transactions);
        assertTrue(userBalances.isEmpty(), "No users should have balances in an empty list");

        List<Transaction> largeTransactions = T25.filterLargeTransactions(transactions, 150.0);
        assertTrue(largeTransactions.isEmpty(), "No large transactions should be found in an empty list");
    }

    @Test
    public void testBoundaryCaseZeroAmountTransaction() {
        List<Transaction> transactions = Arrays.asList(
                new Transaction("tx1", "user1", 0.0),
                new Transaction("tx2", "user2", 150.0)
        );

        Map<String, Double> userBalances = transactions.calculateUserBalances(transactions);
        assertEquals(2, userBalances.size(), "There should be two users with balances");
        assertEquals(0.0, userBalances.get("user1"), "User1 balance should be 0.0 for zero amount transaction");
        assertEquals(150.0, userBalances.get("user2"), "User2 balance should be 150.0");
    }

    @Test
    public void testBoundaryCaseNegativeAmountTransaction() {
        List<Transaction> transactions = Arrays.asList(
                new Transaction("tx1", "user1", -100.0),
                new Transaction("tx2", "user2", 150.0)
        );

        Map<String, Double> userBalances = T25.calculateUserBalances(transactions);
        assertEquals(2, userBalances.size(), "There should be two users with balances");
        assertEquals(-100.0, userBalances.get("user1"), "User1 balance should be -100.0 for negative amount transaction");
        assertEquals(150.0, userBalances.get("user2"), "User2 balance should be 150.0");
    }

    @Test
    public void testFilterLargeTransactionsWithThreshold() {
        List<Transaction> transactions = Arrays.asList(
                new Transaction("tx1", "user1", 100.0),
                new Transaction("tx2", "user2", 50.0),
                new Transaction("tx3", "user1", 200.0),
                new Transaction("tx4", "user2", 300.0)
        );

        List<Transaction> largeTransactions = T25.filterLargeTransactions(transactions, 100.0);
        assertEquals(2, largeTransactions.size(), "There should be two transactions with amounts greater than 100.0");
        assertTrue(largeTransactions.stream().anyMatch(t -> t.getAmount() == 200.0), "Transaction with 200.0 should be included");
        assertTrue(largeTransactions.stream().anyMatch(t -> t.getAmount() == 300.0), "Transaction with 300.0 should be included");
    }

    @Test
    public void testAllTransactionsBelowThreshold() {
        List<Transaction> transactions = Arrays.asList(
                new Transaction("tx1", "user1", 50.0),
                new Transaction("tx2", "user2", 75.0),
                new Transaction("tx3", "user1", 80.0)
        );

        List<Transaction> largeTransactions = T25.filterLargeTransactions(transactions, 100.0);
        assertTrue(largeTransactions.isEmpty(), "No transactions should be found above the threshold of 100.0");
    }
}
