public class TestTopSmall {
    public static void main(String[] args) {
        // test to make sure it still prints the top sales list even if there
        // are not 5 items in the inventory

        InventorySystem is = new InventorySystem();
        is.addNewItem("bannanas", 50, 1.99, 4.99);
        is.addNewItem("apples", 61, 1.15, 1.99);

        is.soldItem("bannanas", 30);
        is.soldItem("apples", 5);

        String[] top_products = is.topSellers();

        if (top_products[0] != "bannanas") {
            StdOut.printf("Expected bannanas but got %s", top_products[0]);
            System.exit(1);
        }

        if (top_products[1] != "apples") {
            StdOut.printf("Expected apples but got %s", top_products[1]);
            System.exit(1);
        }
        StdOut.println("Test passed!");
    }
}
