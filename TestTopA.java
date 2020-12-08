public class TestTopA {
    public static void main(String[] args) {
        InventorySystem is = new InventorySystem();
        is.addNewItem("bannanas", 50, 1.99, 4.99);
        is.addNewItem("apples", 61, 1.15, 1.99);
        is.addNewItem("chocolate", 71, 1.99, 5.25);
        is.addNewItem("snickers", 41, 1.00, 3.99);
        is.addNewItem("bacon", 21, 1, 2.99);

        is.soldItem("chocolate", 50);
        is.soldItem("bannanas", 30);
        is.soldItem("snickers", 20);
        is.soldItem("bacon", 10);
        is.soldItem("apples", 5);

        String[] top_products = is.topSellers();
        if (top_products[0] != "chocolate") {
            StdOut.printf("Expected chocolate but got %s", top_products[0]);
            System.exit(1);
        }
        if (top_products[1] != "bannanas") {
            StdOut.printf("Expected bannanas but got %s", top_products[1]);
            System.exit(1);
        }
        if (top_products[2] != "snickers") {
            StdOut.printf("Expected snickers but got %s", top_products[2]);
            System.exit(1);
        }
        if (top_products[3] != "bacon") {
            StdOut.printf("Expected bacon but got %s", top_products[3]);
            System.exit(1);
        }
        if (top_products[4] != "apples") {
            StdOut.printf("Expected apples but got %s", top_products[4]);
            System.exit(1);
        }
        StdOut.println("Test passed!");
    }
}
