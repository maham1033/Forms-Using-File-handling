import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Person implements Serializable {
    public static List<Person> persons = new ArrayList<Person>();

    @Override
    public String toString() {
        return "Person{" +
                "Name='" + Name + '\'' +
                ", CNIC='" + CNIC + '\'' +
                ", number='" + number + '\'' +
                '}';
    }
    public static void showPersons(){
        if (persons.size()>0){
            for (Person p : persons){
                System.out.println(p);
            }
        }else{
            System.out.println("No person available");
        }


    }
    public static void loadPersons() throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream = new FileInputStream("src/Person.txt");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        persons = (List<Person>) objectInputStream.readObject();
        objectInputStream.close();
        fileInputStream.close();
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getCNIC() {
        return CNIC;
    }

    public void setCNIC(String CNIC) {
        this.CNIC = CNIC;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }


    public Person(String name, String CNIC, String number) {
        Name = name;
        this.CNIC = CNIC;
        this.number = number;

    }

    public Person() {
    }

    public static void addPersons(String name, String reg, String num) throws IOException {
        Person p = new Person(name,reg,num);
        persons.add(p);
        FileOutputStream fileOutputStream = new FileOutputStream("Person.txt");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(persons);
        objectOutputStream.close();
        fileOutputStream.close();
    }

    String Name;
    String CNIC;
    String number;


}