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
        Device device;
        ArrayList<Device> relaventDevices;




        int choice;
        while (true) {
            System.out.println("1.  Register child ;-) ");
            System.out.println("2.  Manage ticket");
            System.out.println("3.  Add ride(on device ya bad boy)");
            System.out.println("4.  Remove ride");
            System.out.println("5.  Exit park");
            System.out.println("6.  Exit");

            choice = input.nextInt();
            input.nextLine();

            switch (choice) {

                case 1:

                    while(true){
                        ID = getIntInput(input, "Please enter your child's ID");
                        if(guardian.hasId(ID)){
                            System.out.println("ID already exists, try again");
                        }
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
                    /*
                     * Manage ticket
                     */
                    break;

                case 3:
                    ID = getIntInput(input, "Please enter your child's ID");
                    child = guardian.getChild(ID);
                    if (child == null) {
                        System.out.println("No such child ID exists in the system");
                        break;
                    }
                    relaventDevices = MySystem.getRelevantDevices(child);
                    if (relaventDevices == null || relaventDevices.size() == 0){
                        System.out.println("No relevant rides available for this child");
                        break;
                    }
                    System.out.println("Choose the ride you would like to add by number");
                    for (int i = 0; i < relaventDevices.size(); i++) {
                        System.out.println((i+1) + ". " + relaventDevices.get(i).getName());
                    }
                    while(true){
                        ID = input.nextInt();
                        if(ID > 0 && ID <= relaventDevices.size())
                            break;
                        else
                            System.out.println("Invalid Input, please try again");
                    }
                    device = relaventDevices.get(ID - 1);
                    if(guardian.childContainsDevice(device, child))
                        System.out.println("Device already on eCard");
                    else if(!guardian.addDevice(device, child)){
                        System.out.println("Insufficient credits on this child's eCard\nCurrent balance: " + guardian.getCreditBalance(child));
                    }
                    else{
                        System.out.println("Ride added successfully");
                    }
                    break;


                case 4:
                    ID = getIntInput(input, "Please enter your child's ID");
                    child = guardian.getChild(ID);
                    if (child == null) {
                        System.out.println("No such child ID exists in the system");
                        break;
                    }
                    relaventDevices = MySystem.getChildsDevices(child);
                    if (relaventDevices == null || relaventDevices.size() == 0){
                        System.out.println("No relevant rides available for this child");
                        break;
                    }
                    System.out.println("Choose the ride you would like to remove by number");
                    for (int i = 0; i < relaventDevices.size(); i++) {
                        System.out.println((i+1) + ". " + relaventDevices.get(i).getName());
                    }
                    while(true){
                        ID = input.nextInt();
                        if(ID > 0 && ID <= relaventDevices.size())
                            break;
                        else
                            System.out.println("Invalid Input, please try again");
                    }
                    device = relaventDevices.get(ID - 1);
                    if(guardian.removeDevice(device, child));
                        System.out.println("Ride removed successfully");
                    break;


                case 5:
                    /*
                     *Exit park
                     */

                    break;

                case 6:
                    /*
                     * Exit
                     */

                    break;

                case 7:
                    MySystem.showAll();
                    break;


                default:
                    System.out.println("Invalid Input, please try again");
                    break;
            }
        }

    }

}
