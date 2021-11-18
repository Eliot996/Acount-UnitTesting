public class Account {
    private final int TRANSFER_FEE = 5;
    private final int accountNumber;
    private final String clientName;
    private int balance = 0;

    public Account(int acountNumber, String clientName) {
        this.accountNumber = acountNumber;
        this.clientName = clientName;
    }

    public Account(int acountNumber, String clientName, int balance) {
        this.accountNumber = acountNumber;
        this.clientName = clientName;
        this.balance = balance;
    }

    public int  insert(int amount){
        // check if the amount is not a negatic number
        if (amount < 0) {
            throw new IllegalArgumentException("Cannot insert negativ numbers into an account");
        }

        // add to the balance
        balance += amount;

        // return the balance
        return balance;
    }

    public int withdraw(int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Cannot withdraw negativ numbers from an account");
        } else if (amount > balance) {
            throw new TooLowBalanceException("The account balance is to low");
        }

        // subtract
        balance -= amount;

        // return the new balance
        return balance;
    }

    public int transfer(int amount, Account target){
        if (amount < 0) {
            throw new IllegalArgumentException("Cannot transfer negativ numbers from an account");
        } else if (amount + TRANSFER_FEE > balance) {
            throw new TooLowBalanceException("The account balance is to low");
        } else if (target != null) {
            throw new IllegalArgumentException("Cannot transfer to an nonexsisting account");
        }

        // subtract
        balance -= amount + TRANSFER_FEE;

        // add to target
        target.insert(amount);

        // return the new balance
        return balance;
    }

    @Override
    public String toString() {
        return "Account number: " + accountNumber + '\n' +
                "Client Name: '" + clientName + '\n' +
                "Balance: " + balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public String getClientName() {
        return clientName;
    }

    public int getBalance() {
        return balance;
    }
}
