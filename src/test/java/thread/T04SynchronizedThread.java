package thread;

import thread.model.Account;

class AccountOperations implements Runnable {

    private final Account account = new Account();

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            this.withdrawal(10);
        }
    }

    private void withdrawal(int amount) {
        if (account.getBalance() >= amount) {
            System.out.println(this.getThreadName() + ": Is going to withdrawal");
            account.withdrawal(amount);
            System.out.println(this.getThreadName() + ": Finished the withdrawal");
        } else {
            System.out.println(this.getThreadName() + " Can not withdrawal: do not have sufficiently balance");
        }
    }

    private String getThreadName() {
        return Thread.currentThread().getName();
    }

}

public class T04SynchronizedThread {

    public static void main(String[] args) {
        // Scenario 1: With concurrency problem
        final AccountOperations accountOperations = new AccountOperations();

        final Thread t1 = new Thread(accountOperations, "Alice");
        final Thread t2 = new Thread(accountOperations, "Bob");

        t1.start();
        t2.start();

        // Scenario 2:
    }

}
