package thread.model;

public class Account {

    private int balance = 50;

    public int getBalance() {
        return balance;
    }

    public void withdrawal(int amount) {
        System.out.println(Thread.currentThread().getName() + " Balance before withdrawal: " + balance);
        this.balance -= amount;
        System.out.println(Thread.currentThread().getName() + " Balance after withdrawal: " + balance);
    }
}
