package fruitappmanager;

public class FruitApp {

    public static void main(String[] args) {
        FruitBasket bucket = new FruitBasket();
        bucket.initWithMockData();
        CommandlineUI ui = new CommandlineUI(System.in, System.out);
        Fruit fruit;
        CommandlineUI.Choices userChoice;
        while (true) {
            userChoice = ui.readSelection();

            switch (userChoice) {
                case SHOW_ALL:
                    ui.showAll(bucket);
                    break;
                case ADD:
                    fruit = ui.newFruitMenu();
                    bucket.add(fruit);
                    break;
                case REMOVE:
                    fruit = ui.selectFruitMenu(bucket);
                    bucket.delete(fruit.getId());
                    break;
                case EDIT:
                    fruit = ui.selectFruitMenu(bucket);
                    bucket.update(fruit.getId(), fruit);
                default:
                    // TODO: handle error
                    break;
            }
        }
    }

}
