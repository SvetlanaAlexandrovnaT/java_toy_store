import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Store {
    private List<Toy> toys;
    private Random random;

    public Store() {
        toys = new ArrayList<>();
        random = new Random();
    }

    public void addToy(Toy toy) {
        toys.add(toy);
    }

    public void updateToyWeight(int toyId, double newWeight) {
        for (Toy toy : toys) {
            if (toy.getId() == toyId) {
                toy.setWeight(newWeight);
                break;
            }
        }
    }

    private int getRandom(){
        int rezult = 0;

        rezult = random.nextInt(10);
        if(rezult >= 0 && rezult < 2) rezult = 1;
        if(rezult > 1 && rezult < 4) rezult = 2;
        if(rezult > 3) rezult = 3;

        return rezult;
    }

    public Toy getToy(int toyId) {
        for(Toy toy : toys){
            if(toy.getId() == toyId) return toy;
        }
        return null;
    }

    public void playToys() {

        Toy prizeToy = getToy(getRandom());
        while (!(prizeToy.getQuantity()>0)) {
            prizeToy = getToy(getRandom());
        }
        try {
            FileWriter writer = new FileWriter("prize_toys.txt", true);
            writer.write(prizeToy.toString() + "\n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        prizeToy.decreaseQuantity();
        System.out.println("Призовая игрушка: " + prizeToy.toString());
    }

    public void showAvailableToys() {
        if (toys.isEmpty()) {
            System.out.println("Доступных игрушек нет.");
            return;
        }

        for (Toy toy : toys) {
            System.out.println(toy.toString());
        }
    }
}