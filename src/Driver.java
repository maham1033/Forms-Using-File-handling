import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.System.in;


public class Driver {
//    private static List<Person> persons = new ArrayList<Person>();

//    private static Person searchPerson(String ID) {
//        for (Person p : persons) {
//            if (p.getCNIC().compareTo(ID) == 0)
//                return p;
//        }
//        return null;
//    }


    public static void main(String args[]) throws IOException, ClassNotFoundException {
        Bank bank = new Bank("Bank");

        loadBank();
//        loadPeople();
//        loadCustomers();
//        loadAccounts();
        Scanner sc = new Scanner(in);

        System.out.println(Person.persons);
//        System.out.println("Enter number");
//        String accn = sc.next();
//        Bank.removeAcc(accn);

        String pname, pcnic, pnumber;
//        System.out.println("How many persons to add?");
//        int total_persons = sc.nextInt();
//        for (int i=0; i<total_persons; i++){
//            System.out.println("Enter name: ");
//            pname = sc.next();
//            System.out.println("Enter Cnic no: ");
//            pcnic = sc.next();
//            System.out.println("Enter Contact number: ");
//            pnumber = sc.next();
//            Person.addPersons(pname,pcnic,pnumber);
//
//        }
        String choice = "";
        while (choice.compareTo("F") != 0) {
            System.out.println("Enter the following \n C - adding clients \n A - adding account");
            System.out.println(" W - withdrawing money \n D - deposit money \n I - client Info \n B- Bank's Info ");
            System.out.println(" X - Account detail \n F - exit ");
            switch (sc.next()) {
                case "C": {
                    System.out.println("Enter Person's CNIC");
                    String cnic = sc.next();
                    for (Person p : Person.persons) {
                        if (cnic.equals(p.CNIC)) {
                            bank.addClient(p);
                            System.out.println("Client created");
                            break;

                        }
//                        else {
//                            continue;
//
//                        }
                    }

                    break;
                }
                case "A": {
                    System.out.println("Enter CNIC to open account");
                    String cnic = sc.next();
                    for (Client c : bank.getClients()) {
                        if (cnic.equals(c.getDetails().getCNIC())) {
                            System.out.println("Enter opening balance: ");
                            float balance = sc.nextFloat();
                            bank.addAccount(balance, c);
                            System.out.println("Account created");
                            break;

                        }
//
//                        } else {
//                            System.out.println("Client does not exist");
//
//                        }
                    }
                    break;
                }

                case "B": {
                    System.out.println(bank);
                    break;
                }
                case "W": {
                    System.out.println("Enter cnic: ");
                    String cnic = sc.next();
                    for (Client c : bank.getClients()) {
                        if (cnic.equals(c.getDetails().getCNIC())) {
                            System.out.println("Enter account number: ");
                            String accountNumber = sc.next();
                            for (Account a : bank.getAccounts()) {
                                if (accountNumber.equals(a.getAccNumber())) {
                                    System.out.println("Enter amount to withdraw: ");
                                    float amountWith = sc.nextFloat();
                                    a.withdraw(amountWith);

                                    break;
                                }
//                                else {
//                                    System.out.println("No account exists");
//                                }
                            }
                            break;

                        }
//                        else {
//                            System.out.println("No Client exists");
//                            break;
//
//                        }
                    }
                    break;
                }
                case "D": {
                    System.out.println("Enter cnic: ");
                    String cnic = sc.next();
                    for (Client c : bank.getClients()) {
                        if (cnic.equals(c.getDetails().getCNIC())) {
                            System.out.println("Enter account number: ");
                            String accountNumber = sc.next();
                            for (Account a : bank.getAccounts()) {
                                if (accountNumber.equals(a.getAccNumber())) {
                                    System.out.println("Enter amount to deposit: ");
                                    float amountDep = sc.nextFloat();
                                    a.deposit(amountDep);
                                    System.out.println("Amount deposited successfully");
                                    System.out.println("New balance is: " + a.getAmount());
                                    break;
                                }

//                                } else {
//                                    System.out.println("No account exists");
//                                    break;
//
//                                }
                            }
                            break;

                        }
//                        else {
//                            System.out.println("No Client exists");
//                            break;
//
//                        }
                    }

                    break;
                }
                case "I": {
                    System.out.println("Enter CNIC to check client's info");
                    String cnic = sc.next();
                    for (Client c : bank.getClients()) {
                        if (cnic.equals(c.getDetails().getCNIC())) {
                            System.out.println(c.getDetails());
                            for (Account a : bank.getAccounts()) {
                                if (cnic.equals(a.getHolder().person_details.getCNIC())) {
                                    System.out.println(a);

                                }
                            }

                        }
//                        else {
//                            System.out.println("No client with this cnic exists");
//                            break;

//                        }
                    }

                    break;
                }
                case "X": {
                    System.out.println("Enter Account number to check account's info");
                    String accNum = sc.next();
                    for (Account a : bank.getAccounts()) {
                        if (accNum.equals(a.getAccNumber())) {
                            System.out.println("Account found");
                            System.out.println(a);
                            break;
                        }

//                        } else {
//                            System.out.println("No account with this Account number exists");
//                            break;
//
//                        }
                    }
                    break;
                }
                case "F": {
                    System.exit(0);
                }
                default:
                    System.out.println("Enter valid input");
            }
        }


    }

    private static void loadAccounts() throws IOException, ClassNotFoundException {

        FileInputStream fileInputStream = new FileInputStream("src/Account.txt");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        Bank.accounts = (ArrayList<Account>) objectInputStream.readObject();
        objectInputStream.close();
        fileInputStream.close();
    }

    public static void loadBank() throws IOException, ClassNotFoundException {
        loadPeople();
        loadCustomers();
        loadAccounts();
    }

    private static void loadCustomers() throws IOException, ClassNotFoundException {

        FileInputStream fileInputStream = new FileInputStream("src/Client.txt");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        Bank.clients = (ArrayList<Client>) objectInputStream.readObject();
        objectInputStream.close();
        fileInputStream.close();

    }

    private static void loadPeople() throws IOException, ClassNotFoundException {

        FileInputStream fileInputStream = new FileInputStream("src/Person.txt");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        Person.persons = (ArrayList<Person>) objectInputStream.readObject();
        objectInputStream.close();
        fileInputStream.close();

    }

}

