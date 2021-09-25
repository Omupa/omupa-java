package thread;

import thread.model.Account;

class AccountOperations implements Runnable {

    private final Account account = new Account();

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            this.withdrawalSyncBlock(10);
        }
    }

    public static synchronized void staticSyncMethod() { // Works with static method
        synchronized (AccountOperations.class) { // And works in static method using block
            // Do something
        }
    }

    private void withdrawalAsync(int amount) { // Async running
        if (account.getBalance() >= amount) {
            System.out.println(this.getThreadName() + ": Is going to withdrawal");
            account.withdrawal(amount);
            System.out.println(this.getThreadName() + ": Finished the withdrawal");

            this.threadSleep();

        } else {
            System.out.println(this.getThreadName() + " Can not withdrawal: do not have sufficiently balance");
        }
    }

    private synchronized void withdrawalSyncMethod(int amount) { // Sync threads running , it's using lock
        if (account.getBalance() >= amount) {
            System.out.println(this.getThreadName() + ": Is going to withdrawal");
            account.withdrawal(amount);
            System.out.println(this.getThreadName() + ": Finished the withdrawal");

            this.threadSleep();

        } else {
            System.out.println(this.getThreadName() + " Can not withdrawal: do not have sufficiently balance");
        }
    }

    private void withdrawalSyncBlock(int amount) { // Sync threads running , it's using lock with sync block
        synchronized (account) {
            if (account.getBalance() >= amount) {
                System.out.println(this.getThreadName() + ": Is going to withdrawal");
                account.withdrawal(amount);
                System.out.println(this.getThreadName() + ": Finished the withdrawal");

                this.threadSleep();

            } else {
                System.out.println(this.getThreadName() + " Can not withdrawal: do not have sufficiently balance");
            }
        }
    }

    private void threadSleep() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private String getThreadName() {
        return Thread.currentThread().getName();
    }

}

public class T04SynchronizedThread {

    public static void main(String[] args) {
        final AccountOperations accountOperations = new AccountOperations();

        final Thread t1 = new Thread(accountOperations, "Alice");
        final Thread t2 = new Thread(accountOperations, "Bob");

        t1.start();
        t2.start();
    }

}
