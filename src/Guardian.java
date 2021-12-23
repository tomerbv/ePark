import java.util.ArrayList;

public class Guardian {
    int idNumber;

    int guardNum;
    ArrayList<Child> children;
    String creditCompany;

    public Guardian(int idNumber, int guardNum, String creditCompany) {
        this.idNumber = idNumber;
        this.guardNum = guardNum;
        this.creditCompany = creditCompany;
    }

    public Guardian(String creditCompany) {
        this.idNumber = 12345;
        this.guardNum = 1;
        this.creditCompany = creditCompany;
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

    public void addChild(Child child){
        children.add(child);
    }

    public void addDevice(Device device){

    }
}
