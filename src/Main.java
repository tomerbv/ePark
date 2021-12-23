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
        return res;
    }

    private static double getDoubleInput(Scanner input, String print){
        System.out.println(print + "\n");
        String str = input.nextLine();
        double res;
        try{
            res = Double.parseDouble(str);
        }
        catch (NumberFormatException nfe){
            System.out.println("Invalid Input");
            return getIntInput(input,print);
        }
        return res;

    }


    public static void main(String[] args) {
        /**
         *
         *
         */


        system MySystem = new system();

        Guardian guardian = new Guardian();
        System.out.println("Welcome to ePark !\n");
        Scanner input = new Scanner(System.in);
        int ID;
        int age;
        double height;
        double weight;
        int creditCard;




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


                    ID = getIntInput(input, "Please enter your child's ID");
                    age = getIntInput(input, "Please enter your child's age");
                    Child child = MySystem.createChild(guardian, ID, age);

                    creditCard = getIntInput(input, "Please enter your credit card number");
                    MySystem.isCardValid(creditCard);

                    e_Ticket ticket = MySystem.createTicket(guardian, child, creditCard);

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
                    /*
                     * Add ride
                     */
                    break;


                case 4:
                    /*
                     * Remove ride
                     */
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


                default:
                    System.out.println("Invalid Input, please try again");
                    break;
            }
        }

    }

}
