import java.util.Random;

public class Ecosystemsimulation {

    private static final int RIVER_SIZE = 20;
    private static final int STEPS = 10;

    private Animal[] river = new Animal[RIVER_SIZE];
    private Random random = new Random();

    private enum AnimalType { BEAR, FISH }

    private static class Animal {
        AnimalType type;
        Animal(AnimalType type) { this.type = type; }
        char getSymbol() { return type == AnimalType.BEAR ? 'B' : 'F'; }
    }

    public Ecosystemsimulation() {
        for (int i = 0; i < RIVER_SIZE; i++) {
            int chance = random.nextInt(3);
            if (chance == 0) river[i] = new Animal(AnimalType.BEAR);
            else if (chance == 1) river[i] = new Animal(AnimalType.FISH);
            else river[i] = null;
        }
    }

    public void simulate() {
        for (int step = 1; step <= STEPS; step++) {
            System.out.println("Step " + step + ":");
            moveAnimals();
            printRiver();
            System.out.println();
        }
    }

    private void moveAnimals() {
        Animal[] newRiver = new Animal[RIVER_SIZE];

        for (int i = 0; i < RIVER_SIZE; i++) {
            Animal animal = river[i];
            if (animal == null) continue;

            int move = random.nextInt(3) - 1;
            int newPos = i + move;
            if (newPos < 0) newPos = 0;
            if (newPos >= RIVER_SIZE) newPos = RIVER_SIZE - 1;

            if (newRiver[newPos] == null) {
                newRiver[newPos] = animal;
            } else {
                Animal other = newRiver[newPos];

                if (animal.type == other.type) {
                    newRiver[newPos] = other;
                    placeNewAnimal(animal.type, newRiver);
                } else {
                    if (animal.type == AnimalType.BEAR && other.type == AnimalType.FISH) {
                        newRiver[newPos] = animal;
                    } else if (animal.type == AnimalType.FISH && other.type == AnimalType.BEAR) {
                        newRiver[newPos] = other;
                    }
                }
            }
        }

        river = newRiver;
    }

    private void placeNewAnimal(AnimalType type, Animal[] newRiver) {
        for (int attempt = 0; attempt < 100; attempt++) {
            int index = random.nextInt(RIVER_SIZE);
            if (newRiver[index] == null) {
                newRiver[index] = new Animal(type);
                break;
            }
        }
    }

    private void printRiver() {
        for (Animal a : river) {
            if (a == null) System.out.print("-");
            else System.out.print(a.getSymbol());
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Ecosystemsimulation sim = new Ecosystemsimulation();
        sim.printRiver();
        System.out.println();
        sim.simulate();
    }
}
