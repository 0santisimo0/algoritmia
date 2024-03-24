package bankGreedy;

public class Account {
    double value;
    public Account(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }

    public void mergeAccount(Account account, double p) {
        double sum = value + account.value;
        this.value = sum - (sum / 100 * p);
    }
}
