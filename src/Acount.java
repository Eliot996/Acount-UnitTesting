public class Acount {
    private int acountNumber;
    private String clientName;
    private int balance = 0;

    public Acount(int acountNumber, String clientName) {
        this.acountNumber = acountNumber;
        this.clientName = clientName;
    }

    public Acount(int acountNumber, String clientName, int balance) {
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
