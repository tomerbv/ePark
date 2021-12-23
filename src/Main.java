import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /**
         *
         *
         */
        //system MySystem = new system();
        System.out.println("Welcome to ePark !\n");
        Scanner input = new Scanner(System.in);
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
                    /*
                     * Register child
                     */
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
