package fruitappmanager;

import java.util.ArrayList;
import java.util.Scanner;

public class FruitApp {


    public static void main(String[] args) {
        ArrayList<Fruit> listOfFruits = new ArrayList<>();
        listOfFruits.add(new Fruit(1, "Orange", 2.99, 100));
        listOfFruits.add(new Fruit(2, "Apple", 5.99, 50));
        listOfFruits.add(new Fruit(3, "Avocado", 8.19, 20));
        listOfFruits.add(new Fruit(4, "Mango", 4.89, 120));
        listOfFruits.add(new Fruit(5, "Dragon Fruit", 12.35, 80));

        int userChoice;
        int selectedItem;


        do {
            userChoice = MenuConsole();
            switch (userChoice) {
                case 1 -> {
                    getAllItems(listOfFruits);
                    break;
                }
                case 2 -> {
                    addItemHandler(listOfFruits);
                    getAllItems(listOfFruits);
                    break;
                }

                case 3 -> {
                    deleteItemHandler(listOfFruits);
                    getAllItems(listOfFruits);
                    break;
                }

                case 4 -> {
                    editItemHandler(listOfFruits);
                    getAllItems(listOfFruits);
                }
                default -> {
                    break;
                }
            }
        } while (true);


    }

    public static int MenuConsole() {
        int userSelection;
        Scanner userInput = new Scanner(System.in);
        System.out.println("PRODUCT MANAGER");
        System.out.println("--------------------------------------------");
        System.out.println("Please make your selection below.");
        System.out.println("1. Print all products");
        System.out.println("2. Add new product.");
        System.out.println("3. Remove a product");
        System.out.println("4. Edit product");
        System.out.println("--------------------------------------------");

        userSelection = userInput.nextInt();

        return userSelection;
    }

//Option 1
private static void getAllItems(ArrayList<Fruit> listOfFruits) {
    for (Fruit fruit : listOfFruits) {
        System.out.println("----------------------------");
        System.out.println("Code: " + fruit.getId());
        System.out.println("Name: " + fruit.getName());
        System.out.println("Price: " + fruit.getPrice());
        System.out.println("Amount: " + fruit.getAmount());
    }
}

//Option 2

    public static void addItemHandler(ArrayList <Fruit> listOfFruits ){
        Scanner userInputs = new Scanner(System.in);

        System.out.println("+ Add new data");
        System.out.println("------------------------");

        System.out.println("Please enter id number: " );
        int inputId = userInputs.nextInt();

        System.out.println("Please enter name of item: ");
        String inputName = userInputs.next();

        System.out.println("Please enter the price of item: ");
        double inputPrice = userInputs.nextDouble();

        System.out.println("Please enter the amount of item: ");
        int inputAmount = userInputs.nextInt();


        Fruit newData = new Fruit(inputId, inputName, inputPrice, inputAmount);

        listOfFruits.add(newData);

    }

//Option 3
    public static void deleteItemHandler(ArrayList<Fruit> listOfFruits) {

//        getAllItems(listOfFruits);

        Scanner userInputs = new Scanner(System.in);
        System.out.println("Please choose the product you wish to delete bellow.");
        for (Fruit item : listOfFruits){
            System.out.println(item.getId() + " " + " " + item.getName());
        }
        int userInput = userInputs.nextInt();

        System.out.println("The item with code number " + userInput + " has been removed.");

      for (int i = 0 ; i < listOfFruits.size(); i++){
          if(listOfFruits.get(i).getId() == userInput){
              listOfFruits.remove(i);
          }
      }


    }

    public static void editItemHandler (ArrayList <Fruit> listOfFruits){
        Scanner userInput = new Scanner(System.in);
        System.out.println("Please select the item you wish to edit.");
        for (Fruit item : listOfFruits){
            System.out.println(item.getId() + ". " + item.getName() + "." );
        }

        int selectedItem = userInput.nextInt();

        for (Fruit item : listOfFruits){
            if(item.getId() == selectedItem){
                item.setId(getUserId(listOfFruits));

//                Change name of selected item.
                System.out.println("Please rename the item.");
                String renamedItem = userInput.next();
                int nameLength = renamedItem.length();

                if(nameLength <= 12) {
                    item.setName(renamedItem);
                }

                item.setPrice(getUserPrice(listOfFruits));
                item.setAmount(getInputAmount(listOfFruits));

            }

        };

    }

//    Method check available ID.
public static int getUserId(ArrayList <Fruit> listOfFruits){
    System.out.println("Please enter the new code number of the product.");

    Scanner userInput = new Scanner(System.in);
    boolean isValid;
    int newId;
    do {
        isValid = true;
        newId = userInput.nextInt();
        for (Fruit fruit: listOfFruits) {
            if (fruit.getId() == newId){
                isValid = false;
                break;
            }
        }
        if (!isValid) {
            System.out.println("The code number is available. Please enter a different code.");
        }



    }while(!isValid);


        return newId;
};

    public static double getUserPrice(ArrayList <Fruit> listOfFruits){
        System.out.println("Please enter the new price of item. ");

        Scanner inputs = new Scanner(System.in);
        double newPrice = inputs.nextDouble();
        return newPrice;
    }

    public static int getInputAmount(ArrayList <Fruit> listOfFruits){
        System.out.println("Please enter the new amount of item: ");
        Scanner inputs = new Scanner(System.in);
        int newAmount = inputs.nextInt();
        return newAmount;
    }

}






