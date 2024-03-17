public class Main {
    public static void main(String[] args) {
        Store toyStore = new Store();

        Toy toy1 = new Toy(1, "конструктор", 1, 20);
        toyStore.addToy(toy1);

        Toy toy2 = new Toy(2, "робот", 2, 20);
        toyStore.addToy(toy2);

        Toy toy3 = new Toy(3, "кукла", 3, 60);
        toyStore.addToy(toy3);

        toyStore.showAvailableToys();

        for(int i=0;i<10;i++) toyStore.playToys();

        toyStore.showAvailableToys();
    }
}