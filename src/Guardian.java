import java.util.ArrayList;

public class Guardian {
    int idNumber;

    int guardNum;
    ArrayList<Child> children;
    String creditCompany;

    public Guardian(int idNumber, int guardNum) {
        this.idNumber = idNumber;
        this.guardNum = guardNum;
        this.children = new ArrayList<>();
    }

    public Guardian() {
        this.idNumber = 12345;
        this.guardNum = 1;
        this.children = new ArrayList<>();
    }

    public int getIdNumber() {
        return idNumber;
    }

    public ArrayList<Child> getChildren() {
        return children;
    }

    public int numberOfChildren(){
        return children.size();
    }

    public Child registerChild(int idNumber, int age){
        Child c = new Child( idNumber,  age);
        children.add(c);
        return c;
    }

    public Child getChild(int idNumber){
        for (int i = 0; i < this.children.size(); i++) {
            if(this.children.get(i).getIdNumber() == idNumber)
                return this.children.get(i);
        }
        return null;
    }


    public boolean addDevice(Device device, Child child){
        return child.addDevice(device);
    }

    public int getCreditBalance(Child child) {
        return child.getCreditBalance();
    }

    public boolean childContainsDevice(Device device, Child child) {
        return child.containsDevice(device);
    }

    public boolean removeDevice(Device device, Child child) {
        return child.removeDevice(device);
    }

    @Override
    public String toString(){
        return "Guardian - " + Integer.toString(this.idNumber);
    }


    public boolean hasId(int id) {
        for (Child child: this.children) {
            if(child.getIdNumber() == id)
                return true;
        }
        return false;
    }
}
