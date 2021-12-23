import java.util.ArrayList;

public class Guardian {
    int idNumber;

    int guardNum;
    ArrayList<Child> children;
    String creditCompany;

    public Guardian(int idNumber, int guardNum) {
        this.idNumber = idNumber;
        this.guardNum = guardNum;
    }

    public Guardian() {
        this.idNumber = 12345;
        this.guardNum = 1;
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

    public void addDevice(Device device){

    }
}
