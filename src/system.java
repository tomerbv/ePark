import java.util.ArrayList;


public class system {
    ArrayList<Object> systemObjects;
    ArrayList<Guardian> guardianList;
    ePark Park;

    void registerGuardian(int idNumber, int guardNum){
        Guardian g = new Guardian( idNumber,  guardNum);
        guardianList.add(g);
        systemObjects.add((Object) g);
    }

    void createChild(Guardian g, int idNumber, int age){
        Child child = g.registerChild( idNumber,  age);
        systemObjects.add((Object) child);
    }

    boolean isCardValid(String creditCard){
        return true;
    }

    void createTicket(Guardian guardian, Child child, String creditCard){
        e_Ticket ticket = new e_Ticket(creditCard);
        child.setTicket(ticket);
        systemObjects.add((Object) ticket);

    }

    void measurementsUpdate(Child child, double height, double weight){
        child.setValues(height,weight);
    }




    Payment enterPayment(){
        return null;
    }

    Child getChild(){
        return null;
    }



}
