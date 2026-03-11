public class Task7 {
    public interface BankAccountInterface {
        void deposit(double amount);
        void withdraw(double amount);
        double getBalance();
    }
    public static class BankAccount implements BankAccountInterface {
        private double balance;

        // Конструктор
        public BankAccount(double initialBalance) {
            this.balance = initialBalance;
        }
        @Override
        public void deposit(double amount) {
            if (amount > 0) {
                balance += amount;
            }
        }
        @Override
        public void withdraw(double amount) {
            if (amount > 0 && amount <= balance) {
                balance -= amount;
            }
        }
        @Override
        public double getBalance() {
            return balance;
        }
    }
    public static void main(String[] args) {
        BankAccount account = new BankAccount(1000); // стартовый баланс 1000
        account.deposit(500);                        // кладём 500
        account.withdraw(300);                      // снимаем 300
        System.out.println("Текущий баланс: " + account.getBalance());
    }
}
