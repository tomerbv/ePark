import java.util.ArrayList;


public class system {
    ArrayList<Object> systemObjects;
    ArrayList<Guardian> guardianList;
    ePark Park;

    public system(String parkName) {
        this.Park = new ePark(parkName);
        this.systemObjects = new ArrayList<>();
        this.guardianList = new ArrayList<>();
    }

    void registerGuardian(int idNumber, int guardNum){
        Guardian g = new Guardian( idNumber,  guardNum);
        guardianList.add(g);
        systemObjects.add((Object) g);
    }

    public Child createChild(Guardian g, int idNumber, int age){
        Child child = g.registerChild( idNumber,  age);
        systemObjects.add((Object) child);
        return child;
    }

    boolean isCardValid(int creditCard){
        return true;
    }

    e_Ticket createTicket(Guardian guardian, Child child, int creditCard,  int charge){
        e_Ticket ticket = new e_Ticket(creditCard);
        ticket.addCharge(charge);
        child.setTicket(ticket);
        systemObjects.add((Object) ticket);
        return ticket;
    }

    void measurementsUpdate(Child child, double height, double weight){
        child.setValues(height,weight);
    }


    public ArrayList<Device> getRelevantDevices(Child child) {
        ArrayList<Device> devices = this.Park.getDeviceList();
        ArrayList<Device> res = new ArrayList<Device>();
        for (int i = 0; i < devices.size(); i++) {
            if(child.canGoOn(devices.get(i))){
                res.add(devices.get(i));
            }
        }
        return res;
    }

    public ArrayList<Device> getChildsDevices(Child child) {
        return child.getDevices();
    }

    public void createDevice(int deviceCode, double price, String name, boolean isOpen, boolean isExtreme, int manufactorerCode, double weightLimit, double heightLimit, int ageLimit) {
        Device device = new Device( deviceCode,  price,  name,  isOpen,  isExtreme,  manufactorerCode,  weightLimit,  heightLimit,  ageLimit);
        systemObjects.add(device);
        Park.addDevice(device);
    }

    public void showAll() {
        for (Object obj: systemObjects ) {
            System.out.println(obj);
        }
    }

    public void addGuardian(Guardian guardian) {
        guardianList.add(guardian);
        systemObjects.add((Object) guardian);
    }

    public void removeChild(Child child, e_Ticket ticket) {
        for (int i = 0; i < this.systemObjects.size(); i++) {
            if(this.systemObjects.get(i) == child)
                this.systemObjects.remove(i);
            if(this.systemObjects.get(i) == ticket)
                this.systemObjects.remove(i);
        }
    }
}
