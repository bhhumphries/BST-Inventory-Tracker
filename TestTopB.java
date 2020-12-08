public class TestTopB {
    public static void main(String[] args) {
        // Test when there are more then 5 items in the inventory and the
        // cut off between #5 and #6 is a tie
        // this example has a tie between bread and snickers
        // When there is a tie, it should pick by alphabetical order by item name
        InventorySystem is = new InventorySystem();
        is.addNewItem("bananas", 50, 1.99, 4.99);
        is.addNewItem("apples", 61, 1.15, 1.99);
        is.addNewItem("chocolate", 71, 1.99, 5.25);
        is.addNewItem("snickers", 41, 1.00, 3.99);
        is.addNewItem("bacon", 21, 1, 2.99);
        is.addNewItem("bread", 30, 1, 1.99);

        is.soldItem("chocolate", 50);
        is.soldItem("bananas", 30);
        is.soldItem("snickers", 5);
        is.soldItem("bacon", 10);
        is.soldItem("apples", 15);
        is.soldItem("bread", 5);

        String[] top_products = is.topSellers();
        if (top_products[0] != "chocolate") {
            StdOut.printf("Expected chocolate but got %s", top_products[0]);
            System.exit(1);
        }
        if (top_products[1] != "bananas") {
            StdOut.printf("Expected bananas but got %s", top_products[1]);
            System.exit(1);
        }
        if (top_products[2] != "apples") {
            StdOut.printf("Expected apples but got %s", top_products[2]);
            System.exit(1);
        }
        if (top_products[3] != "bacon") {
            StdOut.printf("Expected bacon but got %s", top_products[3]);
            System.exit(1);
        }
        if (top_products[4] != "bread") {
            StdOut.printf("Expected bread  but got %s", top_products[4]);
            System.exit(1);
        }
        StdOut.println("Test passed!");
    }
}
