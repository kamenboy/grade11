public class RPG {

    public static void main(String[] args) {
        Wizard wizard = new Wizard("Merlin", 100, 10, 5);
        Warrior warrior = new Warrior("Ragnar", 100, 7, 10);
        Archer archer = new Archer("Elis", 100, 5, 25);

        System.out.println(wizard.getName() + "'s health: " + wizard.getHealth());
        System.out.println(warrior.getName() + "'s health: " + warrior.getHealth());
        System.out.println(archer.getName() + "'s health: " + archer.getHealth());
        System.out.println("Game is starting...");
        wizard.setHealthWarrior(warrior);
        System.out.println(warrior.getName() + " attacks " + wizard.getName() + ". Health updated: "+ wizard.getName() +": " + wizard.getHealth());
        archer.setHealthWizard(wizard);
        System.out.println(wizard.getName() + " attacks " + archer.getName() + ". Health updated: "+ archer.getName() +": " + archer.getHealth());
        warrior.setHealthArcher(archer);
        System.out.println(archer.getName() + " attacks " + warrior.getName() + ". Health updated for " + warrior.getName() +": " + warrior.getHealth());
        
    }
}


class Wizard {
    private String name;
    private int health;
    private int darkMagic;
    private int wizardArmor;

    public Wizard(String name, int health, int darkMagic, int wizardArmor) {
        this.name = name;
        this.health = health;
        this.darkMagic = darkMagic;
        this.wizardArmor = wizardArmor;
    }

    public String getName() {
        return name;
    }

    public int getDarkMagic() {
        return darkMagic;
    }

    public void setHealthWarrior(Warrior attack) {
        health = health - (attack.getSword() - wizardArmor);
    }

    public void setHealthArcher(Archer attack) {
        health = health - (attack.getArrow() - wizardArmor);
    }

    public int getHealth() {
        return health;
    }

}

class Warrior {
    private String name;
    private int health;
    private int sword;
    private int metalArmor;

    public Warrior(String name, int health, int sword, int metalArmor) {
        this.name = name;
        this.health = health;
        this.sword = sword;
        this.metalArmor = metalArmor;
    }

    public String getName() {
        return name;
    }

    public int getSword() {
        return sword;
    }

    public int getHealth() {
        return health;
    }

    public void setHealthWizard(Wizard attack) {
        health = health - (attack.getDarkMagic() - metalArmor);
    }

    public void setHealthArcher(Archer attack) {
        health = health - (attack.getArrow() - metalArmor);
    }

}

class Archer {
    private String name;
    private int health;
    private int arrow;
    private int goldenArmor;

    public Archer(String name, int health, int arrow, int goldenArmor) {
        this.name = name;
        this.health = health;
        this.arrow = arrow;
        this.goldenArmor = goldenArmor;
    }

    public String getName() {
        return name;
    }

    public int getArrow() {
        return arrow;
    }

    public int getHealth() {
        return health;
    }

    public void setHealthWarrior(Warrior attack) {
        health = health - (attack.getSword() - goldenArmor);
    }

    public void setHealthWizard(Wizard attack) {
        health = health - (attack.getDarkMagic() - goldenArmor);
    }
}

