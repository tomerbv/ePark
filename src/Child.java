import java.util.ArrayList;

public class Child {
    int idNumber;
    int age;
    double height;
    double weight;
    e_Ticket ticket;

    public Child(int idNumber, int age) {
        this.idNumber = idNumber;
        this.age = age;
    }

    public boolean addDevice(Device device){
        return this.ticket.addDevice(device);
    }

    public boolean removeDevice(Device device){
        return this.ticket.removeDevice(device);
    }

    public int getIdNumber() {
        return idNumber;
    }

    public e_Ticket getTicket() {
        return ticket;
    }

    public void setValues(double height, double weight){
        this.height = height;
        this.weight = weight;
        this.ticket.setValues(height, weight, this.age);
    }

    public void setTicket(e_Ticket ticket) {
        this.ticket = ticket;
    }

    public boolean canGoOn(Device device) {
        return (height >= device.getHeightLimit() && weight >= device.getWeightLimit() && age >= device.getAgeLimit());
    }

    public int getCreditBalance() {
        return this.ticket.getCreditLeft();
    }

    public boolean containsDevice(Device device) {
        return this.ticket.containsDevice(device);
    }

    public ArrayList<Device> getDevices() {
        return this.ticket.getDevices();
    }

    @Override
    public String toString(){
        String res = "Child - id: " + Integer.toString(this.idNumber);
        res += ", age: " + this.age;
        res += ", height: " + this.height;
        res += ", weight: " + this.weight;
        return res;
    }
}
