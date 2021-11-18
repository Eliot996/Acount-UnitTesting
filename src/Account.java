public class Account {
    private int acountNumber;
    private String clientName;
    private int balance = 0;

    public Account(int acountNumber, String clientName) {
        this.acountNumber = acountNumber;
        this.clientName = clientName;
    }

    public Account(int acountNumber, String clientName, int balance) {
        this.acountNumber = acountNumber;
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

    public int getAcountNumber() {
        return acountNumber;
    }

    public String getClientName() {
        return clientName;
    }

    public int getBalance() {
        return balance;
    }
}
