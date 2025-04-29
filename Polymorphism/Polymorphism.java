public class Polymorphism {
    public static void main(String[] args) {
        Animal[] farmAnimals = {
            new Chicken(1, "Henrietta", 2, "female"),
            new Cow(2, "Bessie", 4, "female"),
            new Sheep(3, "Shaun", 3, "male")
        };

        System.out.println("Morning on the farm!");
        for (Animal animal : farmAnimals) {
            animal.makeSound();
            System.out.println(animal.getName() + " produces: " + animal.getProduct());
            System.out.println();
        }
    }
}

class Animal {
    int id;
    String name;
    int age;
    String gender;

    public Animal(int id, String name, int age, String gender) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void makeSound() {
    }

    public String getProduct() {
        return "";
    }
}

class Chicken extends Animal {
    public Chicken(int id, String name, int age, String gender) {
        super(id, name, age, gender);
    }

    @Override
    public void makeSound() {
        System.out.println(name + " the chicken says: Cluck cluck!");
    }

    @Override
    public String getProduct() {
        if (gender.equalsIgnoreCase("female")) {
            return "Eggs";
        } else {
            return "Nothing (just feathers!)";
        }
    }
}

class Cow extends Animal {
    public Cow(int id, String name, int age, String gender) {
        super(id, name, age, gender);
    }

    @Override
    public void makeSound() {
        System.out.println(name + " the cow says: Moo!");
    }

    @Override
    public String getProduct() {
        if (gender.equalsIgnoreCase("female")) {
            return "Milk";
        } else {
            return "Nothing (maybe beef someday!)";
        }
    }
}

class Sheep extends Animal {
    public Sheep(int id, String name, int age, String gender) {
        super(id, name, age, gender);
    }

    @Override
    public void makeSound() {
        System.out.println(name + " the sheep says: Baa!");
    }

    @Override
    public String getProduct() {
        return "Wool";
    }
}
