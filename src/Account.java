import java.io.IOException;
import java.io.Serializable;

public class Account implements Serializable {
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String id;
    private static String idcounter = "0";
    public String accNumber;
    public float amount;
    private Client holder = new Client();

    public Account(float amount, Client client) throws IOException {

        this.amount = amount;
        holder.setAccounts(client.getAccounts());
        holder.setDetails(client.getDetails());
        this.id = Account.getAccountNum1();
        this.accNumber = "AC" + id;
        holder.totalAccounts = holder.totalAccountsCounter++;

    }

    public static String getAccountNum1() {
        int id1 = Integer.parseInt(idcounter);
        ++id1;
        idcounter = Integer.toString(id1);
        return idcounter;

    }

    @Override
    public String toString() {
        return "Account{" +
                "accNumber=" + accNumber +
                ", amount=" + amount + ", holder=" + holder.person_details.getName() +
                '}';
    }

    public String getAccNumber() {
        return accNumber;
    }

    public String setAccNumber(String accNumber) {
        this.accNumber = accNumber;
        return accNumber;
    }


    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public Client getHolder() {
        return holder;
    }

    public void setHolder(Client holder) {
        this.holder = holder;
    }

    float withdraw(float withdrawAmount) {
        System.out.println("Previous amouunt= "+amount);
        //returns remaining amount in account
        if (withdrawAmount <= this.amount) {
            this.amount -= withdrawAmount;
            System.out.println("Amount withdrawn successfully");
            System.out.println("New balance is: " + amount);
        } else {
            System.out.println("The amount entered is greater than Available balance");
        }
        return amount;
    }

    float deposit(float depositAmount) {
        System.out.println("Previous amount= "+amount);
        amount += depositAmount;
        System.out.println("Amount deposited successfully ");
        System.out.println("New amount: "+amount);
        //adds amount in account
        return amount;
    }

}
