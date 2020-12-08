public class TestSoldNeg {
    public static void main(String[] args) {
        // test to make sure the soldItem function does not apply when
        // the sold amount is negative
        InventorySystem is = new InventorySystem();
        is.addNewItem("bananas", 50, 1.99, 4.99);
        is.addNewItem("apples", 60, 1.15, 1.99);

        is.soldItem("bananas", -1);
        is.soldItem("apples", -65);

        if (is.currentStock("bananas") != 50) {
            StdOut.printf("Expected 50 bananas in stock but got %d", is.currentStock("bananas"));
            System.exit(1);
        }

        if (is.currentStock("apples") != 60) {
            StdOut.printf("Expected 60 apples in stock but got %d", is.currentStock("apples"));
            System.exit(1);
        }
        StdOut.println("\nTest passed!");
    }
}
