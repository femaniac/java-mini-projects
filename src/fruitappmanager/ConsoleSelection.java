package fruitappmanager;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class ConsoleSelection {
    public enum Choices {
        SHOW_ALL, ADD, REMOVE, EDIT;
    }

    private InputStream stream;
    private PrintStream printStream;

    public ConsoleSelection(InputStream inputStream, PrintStream printStream) {
        this.stream = inputStream;
        this.printStream = printStream;
    }

    public Choices readSelection() {
        int selection;
        Scanner userInput = new Scanner(stream);
        printStream.println("PRODUCT MANAGER");
        printStream.println("--------------------------------------------");
        printStream.println("Please make your selection below.");
        printStream.println("1. Print all products");
        printStream.println("2. Add new product.");
        printStream.println("3. Remove a product");
        printStream.println("4. Edit product");
        printStream.println("--------------------------------------------");

        selection = userInput.nextInt();

        return Choices.values()[selection - 1]; // enum starts from 0

    }

    public Fruit newFruitMenu() {
        Scanner userInputs = new Scanner(stream);

        printStream.println("+ Add new data");
        printStream.println("------------------------");

        printStream.println("Please enter id number: ");
        int inputId = userInputs.nextInt();

        printStream.println("Please enter name of item: ");
        String inputName = userInputs.next();

        printStream.println("Please enter the price of item: ");
        double inputPrice = userInputs.nextDouble();

        printStream.println("Please enter the amount of item: ");
        int inputAmount = userInputs.nextInt();

        return new Fruit(inputId, inputName, inputPrice, inputAmount);
    }

    public void showAllFruits(FruitBucket bucket) {
        for (Fruit fruit : bucket.listAll()) {
            printStream.println("----------------------------");
            printStream.println("Code: " + fruit.getId());
            printStream.println("Name: " + fruit.getName());
            printStream.println("Price: " + fruit.getPrice());
            printStream.println("Amount: " + fruit.getAmount());
        }
    }

    public Fruit selectFruit(FruitBucket bucket) {
        Scanner userInputs = new Scanner(stream);
        printStream.println("Please choose the product you wish to delete bellow.");
        for (Fruit item : bucket.listAll()) {
            printStream.println(item.getId() + " " + " " + item.getName());
        }
        int userInput = userInputs.nextInt();
        return bucket.find(userInput);
    }
}
