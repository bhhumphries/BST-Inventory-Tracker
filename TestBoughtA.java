public class TestBoughtA {
    public static void main(String[] args) {
        // test to make sure the bought function works properly
        InventorySystem is = new InventorySystem();
        is.addNewItem("bananas", 50, 1.99, 4.99);
        is.addNewItem("apples", 61, 1.15, 1.99);

        is.boughtItem("bananas", 10);
        is.boughtItem("apples", 40);

        if (is.currentStock("bananas") != 60) {
            StdOut.printf("Expected 60 bananas in stock but got %d", is.currentStock("bananas"));
            System.exit(1);
        }

        if (is.currentStock("apples") != 101) {
            StdOut.printf("Expected 101 apples in stock but got %d", is.currentStock("apples"));
            System.exit(1);
        }
        StdOut.println("Test passed!");
    }
}
