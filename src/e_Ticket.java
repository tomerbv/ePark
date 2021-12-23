import java.util.ArrayList;

public class e_Ticket {
    private static int idCounter = 0;
    private int id;
    private double height;
    private double weight;
    private int age;
    private int creditCard;
    private int creditLeft;
    private int creditSpent;
    private ArrayList<Device> devices;

    public int getCreditLeft() {
        return creditLeft;
    }

    public int getCreditSpent() {
        return creditSpent;
    }



    public e_Ticket(int creditCard) {
        idCounter++;
        this.id = idCounter;
        this.creditCard = creditCard;
        this.devices = new ArrayList<>();
    }

    public void setValues(double height, double weight, int age){
        this.age = age;
        this.weight = weight;
        this.height = height;
    }

    public boolean isAllowed(double heightLimit, double weightLimit, int ageLimit){
        return (height > heightLimit && weight > weightLimit && age > ageLimit);
    }

    public boolean addDevice(Device d){
        if(creditLeft >= d.getPrice()){
            creditLeft -= d.getPrice();
            creditSpent += d.getPrice();
            this.devices.add(d);
            return true;
        }
        return false;
    }

    public boolean containsDevice(Device d){
        return devices.contains(d);
    }

    public boolean removeDevice(Device d){
        return this.devices.remove(d);
    }

    public ArrayList<Device> getDevices() {
        return this.devices;
    }

    @Override
    public String toString(){
        String res = "e_Ticket - " + Integer.toString(this.id);
        res += ", creditLeft: " + this.creditLeft;
        res += ", Devices: " + this.devices;
        return res;
    }


    public String fancyPrint(){
        String res = "--------eTicket--------";
        res += "\nSerial Number: " + this.id;
        res += "\nRides Entries: " + this.devices;
        res += "\nCredit spent: " + this.creditSpent;
        res += "\nCredit left: " + this.creditLeft;
        res += "\nCredit Card number: " + this.creditCard;
        res += "\nRegistered height: " + this.height;
        res += "\nRegistered weight: " + this.weight;
        res += "\nRegistered age: " + this.age;
        return res;
    }

    public void addCharge(int charge) {
        this.creditLeft += charge;
    }
}
