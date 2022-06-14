package fruitappmanager;

import java.util.ArrayList;

public class FruitBasket {
    private ArrayList<Fruit> fruits;

    public FruitBasket(ArrayList<Fruit> listOfFruits) {
        this.fruits = listOfFruits;
    }

    public FruitBasket() {
        this.fruits = new ArrayList<>();
    }

    public void initWithMockData() {
        ArrayList<Fruit> fruits = new ArrayList<>();
        fruits.add(new Fruit(1, "Orange", 2.99, 100));
        fruits.add(new Fruit(2, "Apple", 5.99, 50));
        fruits.add(new Fruit(3, "Avocado", 8.19, 20));
        fruits.add(new Fruit(4, "Mango", 4.89, 120));
        fruits.add(new Fruit(5, "Dragon Fruit", 12.35, 80));
        this.fruits = fruits;
    }


    public Fruit find(int id) {
        return this.fruits.stream().filter(f -> f.getId() == id).findAny().orElse(null);
    }

    public void add(Fruit fruit) {
        this.fruits.add(fruit);
    }

    public void delete(int removeId) {
        this.fruits.removeIf(f -> f.getId() == removeId);
    }

    public ArrayList<Fruit> listAll() {
        return this.fruits;
    }

    public void update(int id, Fruit newFruit) {
        Fruit fruit = this.find(id);
        // TODO: assign possible properties.
        fruit.setName(newFruit.getName());
    }
}
