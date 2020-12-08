public class TestStockA {
    public static void main(String[] args) {
        // test to make sure the currentStock function works properly
        InventorySystem is = new InventorySystem();
        is.addNewItem("bananas", 50, 1.99, 4.99);
        is.addNewItem("apples", 61, 1.15, 1.99);

        is.soldItem("bananas", 10);
        is.soldItem("apples", 40);

        if (is.currentStock("bananas") != 40) {
            StdOut.printf("Expected 40 bananas in stock but got %d", is.currentStock("bananas"));
            System.exit(1);
        }

        if (is.currentStock("apples") != 21) {
            StdOut.printf("Expected 21 apples in stock but got %d", is.currentStock("apples"));
            System.exit(1);
        }
        StdOut.println("Test passed!");
    }
}
