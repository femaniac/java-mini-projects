package fruitappmanager;

import java.util.ArrayList;

public class FruitBucket {
    private ArrayList<Fruit> fruits;

    public FruitBucket(ArrayList<Fruit> listOfFruits) {
        this.fruits = listOfFruits;
    }

    public FruitBucket() {
        this.fruits = new ArrayList<>();
    }

    public Fruit find(int id) {
        return this.fruits.stream().filter(f -> f.getId() == id).findAny().orElse(null);

    }

    public void add(Fruit fruit) {
        this.fruits.add(fruit);
    }

    public void delete(int removeId){
        this.fruits.removeIf(f -> f.getId() == removeId);
    }
    public ArrayList<Fruit> listAll()  {
        return this.fruits;
    }

    public void update(int id, Fruit newFruit) {
        Fruit fruit = this.find(id);
        // TODO: assign possible properties.
        fruit.setName(newFruit.getName());

    }
}
