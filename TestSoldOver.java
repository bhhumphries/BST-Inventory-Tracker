public class TestSoldOver {
    public static void main(String[] args) {
        // test to make sure the soldItem function does not apply when
        // the sold amount is greater than the current stock
        // but still applies when the current stock is equal to the sold amount
        InventorySystem is = new InventorySystem();
        is.addNewItem("bananas", 50, 1.99, 4.99);
        is.addNewItem("apples", 60, 1.15, 1.99);

        is.soldItem("bananas", 55);
        is.soldItem("apples", 60);

        if (is.currentStock("bananas") != 50) {
            StdOut.printf("Expected 50 bananas in stock but got %d", is.currentStock("bananas"));
            System.exit(1);
        }

        if (is.currentStock("apples") != 0) {
            StdOut.printf("Expected 0 apples in stock but got %d", is.currentStock("apples"));
            System.exit(1);
        }
        StdOut.println("Test passed!");
    }
}
