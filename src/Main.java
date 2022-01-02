import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static String getStrInput(Scanner input, String print){
        System.out.println(print);
        String str = input.nextLine();

        while(str.length() == 0){
            System.out.println(print);
            str = input.nextLine();
        }

        return str;
    }

    private static int getIntInput(Scanner input,String print){
        System.out.println(print);
        String str = input.nextLine();
        int res;
        try{
            res = Integer.parseInt(str);
        }
        catch (NumberFormatException nfe){
            System.out.println("Invalid Input");
            return getIntInput(input,print);
        }
        if(res < 0)
            return getIntInput(input,print);
        return res;
    }

    private static double getDoubleInput(Scanner input, String print){
        System.out.println(print);
        String str = input.nextLine();
        double res;
        try{
            res = Double.parseDouble(str);
        }
        catch (NumberFormatException nfe){
            System.out.println("Invalid Input");
            return getDoubleInput(input,print);
        }
        if(res < 0)
            return getDoubleInput(input,print);
        return res;

    }

    private static void addRide(Scanner input, Guardian guardian, system MySystem, Child child){
        ArrayList<Device> relevantDevices = MySystem.getRelevantDevices(child);
        if (relevantDevices == null || relevantDevices.size() == 0){
            System.out.println("No relevant rides available for this child");
            return;
        }
        System.out.println("Choose the ride you would like to add by number");
        for (int i = 0; i < relevantDevices.size(); i++) {
            System.out.println((i+1) + ". " + relevantDevices.get(i).getName() + ", Price: " + relevantDevices.get(i).getPrice());
        }
        int num;
        while(true){
            num = input.nextInt();
            if(num > 0 && num <= relevantDevices.size())
                break;
            else
                System.out.println("Invalid Input, please try again");
        }
        Device device = relevantDevices.get(num - 1);
        if(guardian.childContainsDevice(device, child))
            System.out.println("Device already on eCard");

        else if(device.isExtreme){
            String yesNo = getStrInput(input,"This device is classified as Extreme are you sure your kid can handle that shit?" +
                    "\nType \"Y\" to continue or anything else if you believe your child is a little bitch");
            if(yesNo.toLowerCase() != "y"){
                System.out.println("Action cancelled");
            }
        }

        else if(!guardian.addDevice(device, child)){
            System.out.println("Insufficient credits on this child's eCard\nCurrent balance: " + guardian.getCreditBalance(child));
        }

        else{
            System.out.println("Ride added successfully");
        }
    }

    private static void removeRide(Scanner input, Guardian guardian, system MySystem, Child child){
        ArrayList<Device> relevantDevices = MySystem.getChildsDevices(child);
        if (relevantDevices == null || relevantDevices.size() == 0){
            System.out.println("No relevant rides available for this child");
            return;
        }
        System.out.println("Choose the ride you would like to remove by number");
        for (int i = 0; i < relevantDevices.size(); i++) {
            System.out.println((i+1) + ". " + relevantDevices.get(i).getName());
        }
        int num;
        while(true){
            num = input.nextInt();
            if(num > 0 && num <= relevantDevices.size())
                break;
            else
                System.out.println("Invalid Input, please try again");
        }
        Device device = relevantDevices.get(num - 1);
        if(guardian.removeDevice(device, child));
        System.out.println("Ride removed successfully");

    }

    private static void removeChild(Child child, Guardian guardian, system MySystem){
        e_Ticket ticket = child.getTicket();
        int charge = ticket.getCreditSpent();
        guardian.removeChild(child);
        MySystem.removeChild(child, ticket);
        System.out.println("Child successfully exited the park\nThe damage to your credit card is: " + charge);
    }


    public static void main(String[] args) {
        /**
         *
         *
         */


        system MySystem = new system("The Devil's lettuce");
        MySystem.createDevice( 123, 2, "Mamba Ride", true, true, 135, 0, 140, 12);
        MySystem.createDevice( 456, 1, "Giant Wheel", true, false, 111, 0, 0, 0);
        MySystem.createDevice( 789, 3, "Carrousel", true, false, 222, 0, 0, 8);
        Guardian guardian = new Guardian();
        MySystem.addGuardian(guardian);
        System.out.println("Welcome to ePark !\n");
        Scanner input = new Scanner(System.in);
        int ID;
        int age;
        int charge;
        double height;
        double weight;
        int creditCard;
        Child child;
        e_Ticket ticket;


        int choice;
        while (true) {
            System.out.println("1.  Register child");
            System.out.println("2.  Manage ticket");
            System.out.println("3.  Add ride");
            System.out.println("4.  Remove ride");
            System.out.println("5.  Exit park");
            System.out.println("6.  Exit");

            try {
                choice = input.nextInt();
                input.nextLine();
            }
            catch(Exception e){
                input.next();
                choice = 10;
            }


            switch (choice) {

                case 1:
                    /** Register child **/
                    while(true){
                        ID = getIntInput(input, "Please enter your child's ID");
                        if(guardian.hasId(ID)){
                            System.out.println("ID already exists, try again");
                        }
                        else
                            break;
                    }
                    age = getIntInput(input, "Please enter your child's age");
                    child = MySystem.createChild(guardian, ID, age);

                    charge = getIntInput(input, "Please enter the credit you would like to charge");
                    creditCard = getIntInput(input, "Please enter your credit card number");
                    if(MySystem.isCardValid(creditCard))
                        System.out.println("Credit card valid, your eTicket is charged");
                    MySystem.createTicket(guardian, child, creditCard, charge);

                    height = getDoubleInput(input, "Please enter your child's height");
                    weight = getDoubleInput(input, "Please enter your child's weight");
                    MySystem.measurementsUpdate(child, height, weight);

                    break;

                case 2:
                    /** Manage ticket **/
                    ID = getIntInput(input, "Please enter your child's ID");
                    child = guardian.getChild(ID);
                    if (child == null) {
                        System.out.println("No such child ID exists in the system");
                        break;
                    }
                    ticket = child.getTicket();
                    System.out.println(ticket.fancyPrint());
                    System.out.println("What action would you like to do today sir?");
                    System.out.println("1.  Add ride ");
                    System.out.println("2.  Remove ride");
                    System.out.println("3.  Never mind, forgot I dont even have a child");
                    choice = input.nextInt();
                    switch (choice) {
                        case 1:
                            addRide( input,  guardian,  MySystem, child);
                            break;
                        case 2:
                            removeRide( input,  guardian,  MySystem, child);
                            break;
                        case 3:
                            break;
                        default:
                            System.out.println("Invalid Input, please try again");
                            break;
                    }
                    break;



                case 3:
                    /** Add ride **/
                    ID = getIntInput(input, "Please enter your child's ID");
                    child = guardian.getChild(ID);
                    if (child == null) {
                        System.out.println("No such child ID exists in the system");
                        break;
                    }
                    addRide( input,  guardian,  MySystem, child);
                    break;


                case 4:
                    /** Remove ride **/
                    ID = getIntInput(input, "Please enter your child's ID");
                    child = guardian.getChild(ID);
                    if (child == null) {
                        System.out.println("No such child ID exists in the system");
                        break;
                    }
                    removeRide( input,  guardian,  MySystem, child);
                    break;


                case 5:
                    /** Exit Park **/
                    ID = getIntInput(input, "Please enter your child's ID");
                    child = guardian.getChild(ID);
                    if (child == null) {
                        System.out.println("No such child ID exists in the system");
                        break;
                    }
                    removeChild( child,  guardian,  MySystem);
                    break;



                case 6:
                    /** Exit **/
                    ArrayList<Child> children = guardian.getChildren();
                    while(guardian.numberOfChildren() > 0){
                        removeChild( children.get(0),  guardian,  MySystem);
                    }
                    System.exit(0);
                    break;

                case 7:
                    /** Show all objects **/
                    MySystem.showAll();
                    break;


                default:
                    System.out.println("Invalid Input, please try again");
                    break;
            }
        }

    }

}
