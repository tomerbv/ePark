import java.util.ArrayList;

public class e_Ticket {
    double height;
    double weight;
    int age;
    String creditCard;
    ArrayList<Device> devices;

    public e_Ticket(String creditCard) {
        this.creditCard = creditCard;
    }

    public void setValues(double height, double weight, int age){
        this.age = age;
        this.weight = weight;
        this.height = height;
    }

    public boolean isAllowed(double heightLimit, double weightLimit, int ageLimit){
        return (height > heightLimit && weight > weightLimit && age > ageLimit);
    }

    public void addDevice(Device d){
        this.devices.add(d);
    }

    public boolean removeDevice(Device d){
        return this.devices.remove(d);
    }

}
