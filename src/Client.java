import java.io.Serializable;
import java.util.ArrayList;

public class Client implements Serializable {
    public int id;
    private static int idcounter;

    public Client() {
    }

    Person person_details = new Person();
    private ArrayList<Account> accounts = new ArrayList<>();


    public static int totalAccountsCounter;
    public int totalAccounts;

    public Client(Person person) {
        this.id=idcounter++;
        person_details.setName(person.getName());
        person_details.setCNIC(person.getCNIC());
        person_details.setNumber(person.getNumber());
    }

    @Override
    public String toString() {
        return "Client{" +
                "details="+ person_details +
                ", accounts=" + this.accounts +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Person getDetails() {
        return person_details;
    }

    public void setDetails(Person details) {
        this.person_details = details;
    }

    public ArrayList<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(ArrayList<Account> accounts) {
        this.accounts = accounts;
    }

    public int getTotalAccounts() {
        return totalAccounts;
    }

    public void setTotalAccounts(int totalAccounts) {
        this.totalAccounts = totalAccounts;
    }

    public float getTotalAmount() {
        float total = 0;
        // returns the total amount in all the accounts of any client combined
        for (Account a:accounts){
            total+=a.getAmount();
        }
        return total;
    }


    void withdraw(float amount, String accNo){
        // returns the remaining amount in account
        for (Account a: accounts){
            if (accNo.equals(a.getAccNumber())){
                a.amount-=amount;
            }
        }
    }

    void deposit (float amount, String accNo){
        // returns the current amount in account
        for (Account a: accounts){
            if (accNo.equals(a.getAccNumber())){
                a.amount+=amount;
            }
        }
    }

    void addAccount (Account a){
        // adding account to accountList
        this.accounts.add(a);
    }
}
