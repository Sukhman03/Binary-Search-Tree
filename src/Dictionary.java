import java.util.Scanner;

public class Dictionary {

    BinaryTree dictionary = new BinaryTree();

    public void manageMenu() { // manages the menu
        boolean menuLoop = true;
        while (true) {
            menu();
            Scanner input = new Scanner(System.in);
            int command = input.nextInt();

            switch (command) {
                case 1:
                    getInfo();
                    break;
                case 2:
                    delete();
                    break;
                case 3:
                    search();
                    break;
                case 4:
                    traversalMethod();
                    break;
                case 5:
                    menuLoop = false;
                    break;
                default:
                    System.out.println("Invalid input entered.");
                    break;

            }

            if (menuLoop == false) {
                break;
            }
        }
        /*
        - Manages the commands that can be entered
        - No parameters
        - Returns void
         */
    }

    public void getInfo() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter the contact info:");

        System.out.println("\nEmployee ID: ");
        int employeeID = Integer.parseInt(scan.nextLine());

        System.out.println("First Name: ");
        String fName = scan.nextLine();

        System.out.println("Last Name: ");
        String lName = scan.nextLine();

        System.out.println("Phone Number: ");
        String pNumber = scan.nextLine();

        System.out.println("Address: ");
        String address = scan.nextLine();

        System.out.println("City: ");
        String city = scan.nextLine();

        System.out.println("State: ");
        String state = scan.nextLine();

       dictionary.add(employeeID, fName, lName, pNumber, address, city, state);
       /*
       - Adds info into the binary search tree
       - No parameters
       - Returns void
        */
    }

    public void search() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter the Employee ID to search: ");
        int employeeID = scan.nextInt();

        if(dictionary.search(employeeID) == null) {
            System.out.println("Sorry, that Employee ID does not exist.");
        } else {
            System.out.println(dictionary.search(employeeID));
        }
        /*
        - Searches through BST and prints out the value associated with the key
        - No parameters
        - Returns void
         */
    }

    public void delete() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter the Employee ID to delete: ");
        int employeeID = scan.nextInt();

        if(!dictionary.delete(employeeID)) {
            System.out.println("Sorry, that Employee ID does not exist.");
        } else {
            dictionary.delete(employeeID);
        }
        /*
        - Searches through BST and deletes value associated with the key
        - No parameters
        - Returns void
         */
    }

    public void traversalMethod() {
        Scanner console = new Scanner(System.in);
        System.out.println("Please select a traversal method: ");
        System.out.println("1. Pre Order Traversal");
        System.out.println("2. In Order Traversal");
        System.out.println("3. Post Order Traversal");
        int traversal = console.nextInt();

        switch(traversal) {
            case 1:
              dictionary.preOrderTraversal(dictionary.root);
              break;
            case 2:
                dictionary.inOrderTraversal(dictionary.root);
                break;
            case 3:
                dictionary.postOrderTraversal(dictionary.root);
                break;
            default:
                System.out.println("Invalid input entered.");
                traversalMethod();
        }
        /*
        - Prints out the tree using different traversal methods
        - No parameters
        - No returns
         */
    }

    public void menu() {
        System.out.println("\nPlease select a command: ");
        System.out.println("1. Add Employee Info");
        System.out.println("2. Delete Employee Info");
        System.out.println("3. Search Employee Info");
        System.out.println("4. Traverse Through Tree");
        System.out.println("5. Exit");
        /*
        - Prints out the menu options
        - No parameters
        - Returns void
         */
    }

}
