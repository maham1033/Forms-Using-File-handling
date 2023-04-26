import java.io.*;
import java.util.ArrayList;

public class Bank implements Serializable{
    @Override
    public String toString() {
        return "Bank{" +
                "name='" + name + '\'' + "Client='" + clients + '\'' + "accounts='" + accounts + '\'' +
                '}';
    }

    String name;
    public static ArrayList<Client> clients = new ArrayList<>();
    public static ArrayList<Account> accounts = new ArrayList<>();


    public Bank(String name) {
        this.name = name;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Client> getClients() {
        return clients;
    }

    public void setClients(ArrayList<Client> clients) {
        this.clients = clients;
    }

    public ArrayList<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(ArrayList<Account> accounts) {
        this.accounts = accounts;
    }


    public void addAccount (float amount, Client c) throws IOException {
        System.out.println("Account creation");
        Account account = new Account(amount,c);
        System.out.println(account.accNumber);
        accounts.add(account);
        c.addAccount(account);
        FileOutputStream fileOutputStream = new FileOutputStream("Account.txt");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(accounts);
        objectOutputStream.close();
        fileOutputStream.close();


    }

    public Client addClient(Person person) throws IOException {
        Client client = new Client(person);
        System.out.println(client);
        clients.add(client);
        FileOutputStream fileOutputStream = new FileOutputStream("Client.txt");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(clients);
        objectOutputStream.close();
        fileOutputStream.close();

        return client;
    }

    public static void removeAcc(String account){
        for (int i=0; i<accounts.size(); i++){
            if (accounts.get(i).getAccNumber().equals(account)){
                accounts.remove(accounts.get(i));
                System.out.println("Account removed");
            }

        }

//        for (Account a:accounts){
//            if (a.getAccNumber().equals(account)){
//                accounts.remove(a);
//                System.out.println("Account removed");
//            }
//        }
//        System.out.println(accounts);

    }

    public float totalAmount() {
        float total_amount = 0;

        for (Account a:accounts){
            total_amount += a.getAmount();
        }

        // returns the total amount in all the accounts of all the client combined
        return total_amount;
    }

    public Boolean removeClient(int id) {
        for (Client c:clients){
            if (clients.size()!=0){
                if (id==c.getId()){
                    for (Account a:c.getAccounts()){
                        accounts.remove(a);
                    }
                    clients.remove(c);
                    System.out.println("Client"+c+ "removed");
                }
            }else{
                System.out.println("No clients in bank");
            }

        }
        // when client is removed all the accounts of that client from the bank are also destroyed
        return true;
    }

    public void searchAcc (String accNum){
        Boolean found = false;
        while (found==false){
            for (Account a:accounts){
                if (accNum.equals(a.getAccNumber())){
                    System.out.println("Account found");
                    found=true;
                    break;

                }else{
                    System.out.println("Account not found");

                }
            }

        }

    }

    public Client searchCustomerDetail(String CNIC){
        for (Client c:clients){
            if (CNIC.equals(c.getDetails().getCNIC())){
                System.out.println("Client found");
                System.out.println(c);
            }else{
                System.out.println("Client not found");
            }
        }
        return null;
    }
}
