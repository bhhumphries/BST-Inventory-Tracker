import java.util.Queue;

/**
 * This class represents an inventory system that a compnay may use to track how
 * many items of a given type are purchased and sold by the company and if the
 * company is currently making a profit on a given item.
 */
public class InventorySystem {
    /** internal class which represents the inventory items being tracked */
    private class InventoryItem {
        public String name;
        public int initialOrder;
        public int quantitySold;
        public double wholesale;
        public double resale;

        InventoryItem(String itemName, int order, double pricePurchase, double priceSelling) {
            name = itemName;
            initialOrder = order;
            quantitySold = 0;
            wholesale = pricePurchase;
            resale = priceSelling;
        }
    }

    /**
     * You will want to decalre your symbol table instance variable here, if you implemented an
     * inner class
     * you can leverage that in your symbol table if you made it generic. So you could have
     * something like
     **/

    /* Symbol table instance variable */
    SymbolTable<String, InventoryItem> inventory = new SymbolTable<String, InventoryItem>();

    /** Our basic constructor, this should initialize our backing symbol table */
    InventorySystem() {
    }

    /**
     * Adds a new item to the inventory
     *
     * @param name         The name of the item
     * @param initialOrder How many were initially purchased
     * @param wholesale    The wholesale(per item cost) that we paid
     * @param resale       The resale price(per item) that we will be selling the items for
     */
    public void addNewItem(String name, int initialOrder, double wholesale, double resale) {
        // create new InventoryItem
        InventoryItem value = new InventoryItem(name, initialOrder, wholesale, resale);
        // add the new item to the inventory by using the put function from SymbolTable
        inventory.put(name, value);
    }

    /**
     * Retreive the current number of of items we currently have in stock
     *
     * @param name The name of the item to look up
     * @return The number we currently have in stock, -1 if we don't carry the item
     */
    public int currentStock(String name) {
        // Retrieve the other information for the item
        InventoryItem item = inventory.get(name);
        // if the item is not in stock, return -1
        if (item == null) {
            return -1;
        }
        // if the item is in stock, return the current stock
        return (item.initialOrder - item.quantitySold);
    }

    /**
     * Track that we sold a certain number of items
     *
     * @param name The name of the item that was sold
     * @param qnty The number of items that were sold
     */
    public void soldItem(String name, int qnty) {
        // retrieve the other information of the item
        InventoryItem item = inventory.get(name);
        // if the item is not in the inventory, print message
        if (item == null) {
            StdOut.printf("\nWe don't currently carry %s", name);
            StdOut.printf("!\n");
        }
        // if the item is in the inventory
        if (item != null) {
            // if the sold amount is more than the current stock, print message
            // and keep the stock as is
            if (currentStock(name) < qnty) {
                StdOut.printf("\nWe don't currently have %d %s in stock!\n", qnty, name);
            }
            else if (qnty < 0) {
                StdOut.printf("\nWe cannot sell a negative amount of items!");
            }
            // otherwise update the sold amount
            else {
                item.quantitySold = item.quantitySold + qnty;
            }
        }
    }

    /**
     * Track that we purchased some number of items
     *
     * @param name The name of the item we purchased
     * @param qnty The number of items we purchased
     */
    public void boughtItem(String name, int qnty) {
        // retrieve the other information of the item
        InventoryItem item = inventory.get(name);
        // if the item exists, add the boughten quantity to current purchased amount
        if (item != null) {
            item.initialOrder = item.initialOrder + qnty;
        }
        // if the item isn't in the inventory, print message
        if (item == null) {
            StdOut.printf("\nWe don't currently carry %s", name);
            StdOut.printf("!\n");
        }
    }

    /**
     * Prints the current inventory status of all items in the inventory
     */
    public void printInventory() {
        // if inventory is empty, print message
        if (inventory.size() == 0) {
            StdOut.printf("\nInventory is empty!\n");
        }
        // if inventory is not empty
        else {
            StdOut.printf("%10s | Purchased | Sold | Remaining | Profit $\n", "Product");
            StdOut.println("-----------------------------------------------------------");
            // create queue of invetory items in alphabetical order
            Queue<String> order = inventory.traverse();
            // for every item in the queue
            for (String item : order) {
                // retrieve all info for the inventory item
                InventoryItem itemInfo = inventory.get(item);
                // calculate the profit of the item
                double profit = (itemInfo.quantitySold * itemInfo.resale) - (itemInfo.initialOrder
                        * itemInfo.wholesale);
                // print the information for the item
                StdOut.printf("%10s:%11d:%7d:%11d: ", itemInfo.name, itemInfo.initialOrder,
                              itemInfo.quantitySold, currentStock(item));
                StdOut.printf("$ %.2f.%n", profit);
            }
            StdOut.println();
        }
    }

    /**
     * Returns an array containing the names of our top 5 sellers in descending
     * order
     *
     * @return an array containing the name of our top 5 sellers in descending order
     */
    public String[] topSellers() {
        // if the inventory is empty, return null
        if (inventory.size() == 0) {
            String[] topNames = new String[0];
            return topNames;
        }
        // input bst names into queue
        Queue<String> order = inventory.traverse();
        // create arrays the size of the inventory
        int[] topSold = new int[inventory.size()];      // holds quantity sold values
        String[] topName = new String[inventory.size()]; // holds item names

        // input data into arrays
        int m = 0;
        for (String item : order) {
            InventoryItem itemInfo = inventory.get(item);
            topSold[m] = itemInfo.quantitySold;
            topName[m] = itemInfo.name;
            m++;
        }
        // sort topSold array in descending order and
        // topName array in the order topSold is in
        int tempi;
        String temps;
        for (int i = 0; i < topSold.length; i++) {
            for (int j = i + 1; j < topSold.length; j++) {
                if (topSold[i] < topSold[j]) {
                    tempi = topSold[i];
                    temps = topName[i];
                    topSold[i] = topSold[j];
                    topName[i] = topName[j];
                    topSold[j] = tempi;
                    topName[j] = temps;
                }
            }
        }
        // create new array that includes the top five names in descending order
        // if there were at least 5 items in the inventory, include the top 5
        if (inventory.size() >= 5) {
            String[] topNames = new String[5];
            for (int q = 0; q < 5; q++) {
                topNames[q] = topName[q];
            }
            return topNames;
        }
        // if there were not at least 5 items in the inventory, then
        // include the whole inventory but still in descending sale order
        else {
            String[] topNames = new String[inventory.size()];
            for (int q = 0; q < inventory.size(); q++) {
                topNames[q] = topName[q];
            }
            return topNames;
        }
    }


    /*
     * Removes an item from the inventory */
    public void deleteItem(String item) {
        inventory.delete(item);
    }

    public static void main(String[] args) {
        InventorySystem is = new InventorySystem();

        while (!StdIn.isEmpty()) {
            String cmd = StdIn.readString();
            if (cmd.equals("add")) {
                String item = StdIn.readString();
                int qnty = StdIn.readInt();
                double wholesale = StdIn.readDouble();
                double resale = StdIn.readDouble();
                is.addNewItem(item, qnty, wholesale, resale);
            }
            else if (cmd.equals("sold")) {
                String item = StdIn.readString();
                int qnty = StdIn.readInt();
                is.soldItem(item, qnty);
            }
            else if (cmd.equals("bought")) {
                String item = StdIn.readString();
                int qnty = StdIn.readInt();
                is.boughtItem(item, qnty);
            }
            else if (cmd.equals("stock")) {
                String item = StdIn.readString();
                StdOut.printf("Current stock of %s: %d\n", item, is.currentStock(item));
            }
            else if (cmd.equals("inventory")) {
                is.printInventory();
            }
            else if (cmd.equals("top")) {
                StdOut.println("Top sellers:\n-----------");
                for (String s : is.topSellers()) {
                    StdOut.println(s);
                }
            }
            else if (cmd.equals("remove")) {
                String item = StdIn.readString();
                StdOut.printf("Removing %s from the inventory\n", item);
                is.deleteItem(item);
            }
        }
    }
}
