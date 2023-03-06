public class Node {
    int key;
    String fName;
    String lName;
    String address;
    String city;
    String pNumber;
    String state;
    Node leftChild;
    Node rightChild;

    Node(int key, String fName, String lName, String pNumber, String address, String city, String state) {
        this.key = key;
        this.fName = fName;
        this.lName = lName;
        this.pNumber = pNumber;
        this.address = address;
        this.city = city;
        this.state = state;
    }

    public String toString() {
        return fName + " " + lName + "'s Employee ID Number: " + key + "\nPhone Number: " + pNumber +
                "\nAddress: " + address + ", " + city + " " + state;
    }
}

