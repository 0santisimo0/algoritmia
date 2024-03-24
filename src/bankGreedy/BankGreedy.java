package bankGreedy;

import java.util.*;


public class BankGreedy {
    public double accountsMerge(int n, List<Account> accounts, double p) {
        PriorityQueue<Account> queue = new PriorityQueue<>(Comparator.comparingDouble(Account::getValue));
        queue.addAll(accounts);

        while (n>1) {
            Account account1 = queue.poll();
            Account account2 = queue.poll();
            assert account2 != null;
            assert account1 != null;
            account1.mergeAccount(account2, p);
            queue.add(account1);
            n--;
        }
        return Objects.requireNonNull(queue.poll()).value;
    }

    public static void main(String[] args) {
        BankGreedy bankGreedy = new BankGreedy();
        Account account1 = new Account(1000);
        Account account2 = new Account(1100);
        Account account3 = new Account(1200);
        Account account4 = new Account(1300);
        double result = bankGreedy.accountsMerge(4,List.of(account1, account2, account3, account4), 5);
        System.out.println(result);
    }

}
