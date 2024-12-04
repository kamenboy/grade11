public class ZooSimulation {
    public static void main(String[] args) {
        //composition: habitat it is created, which is then owned and used by Animals and Staff Class
        Habitat rainforest = new Habitat("rainforest", 500, 17.3);
        Habitat desert = new Habitat("desert", 1500, 36.2);
        Habitat jungle = new Habitat("jungle", 3500, 23.9);

        //association: Staff objects are created and associated with Habitat class later
        Staff kamen = new Staff("Kamen", "CEO of the Zoo");
        Staff vasko = new Staff("Vasko", "Habitat Cleaner");
        Staff dichev = new Staff("Dichev", "Animal Carer");

        //association
        kamen.assignHabitat(rainforest);
        vasko.assignHabitat(desert);
        dichev.assignHabitat(jungle);
        System.out.println();

        //composition
        Animals jaguar = new Animals("Jaggy", "jaguar", 12, rainforest);
        Animals camel = new Animals("Marlboro", "camel", 9, desert);
        Animals monkey = new Animals("DonkeyKong", "monkey", 3, jungle);
        Animals snake = new Animals("Slytherin", "snake", 6, jungle);

        //composition
        Zoo KamensZoo = new Zoo();
        KamensZoo.addAnimal1(jaguar);
        KamensZoo.addAnimal2(camel);
        KamensZoo.addAnimal3(monkey);
        KamensZoo.addAnimal4(snake);
        System.out.println();

        //association: feeding is an interaction between Animals and Staff
        jaguar.eat("Steak", kamen);
        camel.eat("Salmon", vasko);
        monkey.eat("Banana", dichev);
        snake.eat("Rats", dichev);
    }
}

class Animals {
    private String name;
    private String species;
    private int age;
    private Habitat habitat;  // here we use composition

    public Animals(String name, String species, int age, Habitat habitat) {
        this.name = name;
        this.species = species;
        this.age = age;
        this.habitat = habitat;
    }

    public void eat(String food, Staff staff) {  //association
        System.out.println(this.name + " is being fed with " + food + " by " + staff.getName() + ".");
    }

    public String getName() {
        return name;
    }

    public Habitat getHabitat() {
        return habitat;
    }

}

class Habitat {
    private String type;
    private int size;
    private double temperature;

    public Habitat(String type, int size, double temperature) {
        this.type = type;
        this.size = size;
        this.temperature = temperature;
    }

    public String getType() {
        return type;
    }

}

class Zoo {
    private Animals a1, a2, a3, a4;  //composition: a zoo "has" animals

    public void addAnimal1(Animals animal) {
        this.a1 = animal;
        System.out.println(animal.getName() + " is assigned to the " + animal.getHabitat().getType() + " habitat.");
    }

    public void addAnimal2(Animals animal) {
        this.a2 = animal;
        System.out.println(animal.getName() + " is assigned to the " + animal.getHabitat().getType() + " habitat.");
    }

    public void addAnimal3(Animals animal) {
        this.a3 = animal;
        System.out.println(animal.getName() + " is assigned to the " + animal.getHabitat().getType() + " habitat.");
    }

    public void addAnimal4(Animals animal) {
        this.a4 = animal;
        System.out.println(animal.getName() + " is assigned to the " + animal.getHabitat().getType() + " habitat.");
    }
}


class Staff {
    private String name;
    private String role;
    private Habitat assignedHabitat; //association

    public Staff(String name, String role) {
        this.name = name;
        this.role = role;
    }
        //association
    public void assignHabitat(Habitat habitat) {
        this.assignedHabitat = habitat;
        System.out.println(this.name + " is assigned to " + habitat.getType() + ".");
    }

    public String getName() {
        return name;
    }
}
