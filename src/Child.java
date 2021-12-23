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

    public void addDevice(Device device){
        this.ticket.addDevice(device);
    }

    public boolean removeDevice(Device device){
        return this.ticket.removeDevice(device);
    }

    public void setValues(double height, double weight){
        this.height = height;
        this.weight = weight;
        this.ticket.setValues(height, weight, this.age);
    }

    public void setTicket(e_Ticket ticket) {
        this.ticket = ticket;
    }
}
