package task1;
class Account {
    private int balance = 50;
    public synchronized void withdraw(int amount) {
        if(balance >= amount) {
            balance -= amount;
            System.out.println(Thread.currentThread().getName() + " has withdrawn " + amount + ". Remaining balance: " + balance);
        } else {
            System.out.println(Thread.currentThread().getName() + " can't withdraw " + amount + ". Not enough balance.");
        }
    }
}

public class AccountTesting implements Runnable {
    private Account acct = new Account();
    public static void main(String[] args) {
        AccountTesting r = new AccountTesting();
        Thread one = new Thread(r);
        Thread two = new Thread(r);
        one.setName("Subhan");
        two.setName("Aman");
        one.start();
        two.start();
    }
    @Override
    public void run() {
        for (int x = 0; x < 5; x++) {
            acct.withdraw(10);
        }
    }
}