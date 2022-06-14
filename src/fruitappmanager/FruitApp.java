package fruitappmanager;

import java.io.InputStream;
import java.util.ArrayList;

public class FruitApp {

    private static ArrayList<Fruit> defaultFruitBucket() {
        ArrayList<Fruit> fruits = new ArrayList<>();
        fruits.add(new Fruit(1, "Orange", 2.99, 100));
        fruits.add(new Fruit(2, "Apple", 5.99, 50));
        fruits.add(new Fruit(3, "Avocado", 8.19, 20));
        fruits.add(new Fruit(4, "Mango", 4.89, 120));
        fruits.add(new Fruit(5, "Dragon Fruit", 12.35, 80));
        return fruits;
    }

    public static void main(String[] args) {
        FruitBucket bucket = new FruitBucket(defaultFruitBucket());
        ConsoleSelection ui = new ConsoleSelection(System.in, System.out);
        Fruit fruit;
        ConsoleSelection.Choices userChoice;
        while (true) {
            userChoice = ui.readSelection();

            switch (userChoice) {
                case SHOW_ALL:
                    ui.showAllFruits(bucket);
                    break;
                case ADD:
                    fruit = ui.newFruitMenu();
                    bucket.add(fruit);
                    break;
                case REMOVE:
                    fruit = ui.selectFruit(bucket);
                    bucket.delete(fruit.getId());
                    break;
                case EDIT:
                    fruit = ui.selectFruit(bucket);
                    bucket.update(fruit.getId(), fruit);
                default:
                    break;
            }
        }
    }

}
