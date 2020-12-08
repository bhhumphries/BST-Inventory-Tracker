



# Inventory Tracker Assignment

For this assignment you will be building an inventory tracking program which will be used to track the following information about a given set of items:

* Item name
* Quantity purchased
* Purchase price
* Quantity sold
* Selling price

This inventory system will accept multiple commands that indicate when an item was sold and how many were sold, when items were purchased and in what quantity, and a current summary of the total sales vs purchases and what the current profit is on each item in the inventory. Below are a full list of commands that the program must respond to:

* `add` - Adds a new item to the inventory
* `sold` - Marks n number of items as sold
* `bought` - Marks n number of items as being purchased
* `stock` - prints out the current quantity in stock for a given item
* `inventory` - prints out the current inventory and total profits per item
* `top` - prints out the top 5 best sellers in the inventory in descending order

These commands and their parameters will be provided via `stdin` or from a file via `stdin` redirection. See the `main` function of `InventorySystem.java` for details on how these commands are handled and how the information that is being provided on `StdIn` is being parsed. A sample input has been provided below

```text
add bannanas 55 .99 1.99
add apples 100 .85 2.99
add hamburger 255 1.99 4.99
add ham 100 1.50 3.99
add rice 500 .25 .99
sold bannanas 10
sold hamburger 25
sold ric 100
sold apples 25
sold hamburger 40
inventory
```

A sample output for this input can be seen below

```
We don't currently carry ric!
   Product | Purchased | Sold | Remaining | Profit $
-----------------------------------------------------------
    apples:        100:     25:         75: -$10.25
  bannanas:         55:     10:         45: -$34.55
       ham:        100:      0:        100: -$150.00
 hamburger:        255:     65:        190: -$183.10
      rice:        500:      0:        500: -$125.00
```

The inventory system should make use of a `SymbolTable` abstract data type to store the product information. To support that your program will require at least two files, `InventorySystem.java` which implements the inventory logic and `SymbolTable.java` which implements the Symbol Table data structure which the inventory system will use to store and retreive data. You symbol table should be implemented using a binary search tree to achieve average time `lg n` lookup and insertion times. 

## Expectations & Rules

* You are expected to corectly implement all required methods inside of `InventorySystem.java` and `SymbolTable.java`. Your implementations should also handle potential edge cases that could arrise without crashing.

* Your symbol table implementation should be your own, written from scratch implementation

* You may add additional class files to support your symbol table implementation

* You cannot change the prototype of any existing `public` method in the class

* You cannot add any new `public` methods to the class

* You can add new `private` methods and instance variables which act as helper functions

* Your method implementations should return in the correct manner, such that if it is a `void` method,  nothing should be returned, if it is a `boolean` method then a boolean should always be returned, etc

* If a sample output file is provided, then your output format must match the provided output _exactly_, including spaces, casing, etc. 

* You should include some number of test cases in other `.java` files that show the correctness of your program in both normal and edge case scenarios. Think about strange situations your code could end up in and show that your implementation is able to handle it correctly. For instance, what happens if the `getFront` method is called on a list that is empty, or what happens if you remove all nodes from the list and then start adding new nodes back into it? The required number of test cases will be dictated by the rubric below.

  

## Creating Test Cases

To create a new test case, create a new file called `Test<some test name>.java`. Note that the file name __must__ start with the word `Test`. Once you have created the test you can create an instance of your list and perform the necesary operations to show the success of the test. See the included Test files for examples, in general each test should follow these guidlines 

* The test file name must have the prefix `Test`
* If the test fails, a message should be printed saying that the test failed
* If the test fails, `System.exit(1);` must be called
* If the test succeeds then a message should be printed out indicating that it was successful

To build and run all tests you can use the included shell script called `run_tests.sh` This will find all test files, build them, and run them. This can be invoked from a terminal that is open to the assignment directory with:

```
./run_tests.sh
```

## Rubric

Your code will be graded based on the following rubric

| Category          |                                                              |                                                              |                                                              |                                                              |
| ----------------- | ------------------------------------------------------------ | ------------------------------------------------------------ | ------------------------------------------------------------ | ------------------------------------------------------------ |
| Readability       | 6 Points                                                     | 4 Points                                                     | 2 Points                                                     | 0 Points                                                     |
|                   | Code is clean, understandable, well-organized                | Minor issues such as inconsistent indentation, variable naming, general organization | At least one major issue that makes it difficult to read     | Several major issues that make it difficult to read.         |
| Unit Tests        | 6 Points                                                     | 4 Points                                                     | 2 Points                                                     | 0 Points                                                     |
|                   | At least 6 working unit tests are provided. 3 which show the program behaves properly in handling error cases and 3 which show the program exhibiting correct behavior | At least 4 working unit tests are provided. 2 which show the program behaves properly in handling error cases and 2 which show the program exhibiting correct behavior | At least 2 working unit tests are provided. 1 which show the program behaves properly in handling error cases and 1 which show the program exhibiting correct behavior | No unit tests were provided                                  |
| Elegance          |                                                              | 4 Points                                                     | 2 Points                                                     | 0 Points                                                     |
|                   |                                                              | Code duplication is minimized by implementing the appropriate number of functions and loop statements. | Poor design choices were used in at least one place, for example duplicate code that could have been extracted into a function or put inside of a loop was not | Code contained multiple instances of poor design, such as not modularizing duplicate code or lack of data structure use to maintain and organize data |
| Correctness       | 30 Points                                                    | 25 Points                                                    | 15 Points                                                    | 0 Points                                                     |
|                   | All specifications are met and the program always functions as expected regardless of the input provided to it | Program meets most requirements but behaves abnormally when certain edge cases are provided | The program produces incorrect output with most input sets   | Program does not compile or does not function correctly even when provided with the sample input |
| Specifications    |                                                              | 4 Points                                                     | 2 Points                                                     | 0 Points                                                     |
|                   |                                                              | Program meets all specifications provided in the assignment description file | Minor specifications have been violated (incorrectly named files, program input) | Many specifications were not met                             |
| Memory Management |                                                              | 5 Points                                                     | 3 Points                                                     | 0 Points                                                     |
|                   |                                                              | Program allocates the correct amount of data without extraneous allocations | Program has a small number of extraneous allocations that are not required | Program has many extraneous allocations                      |