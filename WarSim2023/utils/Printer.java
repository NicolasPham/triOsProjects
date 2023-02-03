package utils;
import warrior.*;
import armor.*;
import weapon.*;

public class Printer {

    public ConsoleColor color = new ConsoleColor();

    public Armor armor = new Armor();
    public Weapon weapon = new Weapon();
    public String[] listCharacter = {"Knight", "Priest", "Assasin", "Archer", "Barbarian", "Witcher"};
    public String[] listArmor = {"Leather" ,"ChainShirt", "BreastPlate"};
    public String[] listWeapon = {"Axe", "Sword", "Bow", "Dagger", "Riftmaker"}; //{0, 1, 2, 3, 4}

    public Printer() {

    }


    public void welcome() {
        System.out.println(color.PURPLE_BACKGROUND + "WELCOME TO WARSIM 2023" + color.RESET);
    }

    public void characterOptions() {
        System.out.println("Which race would you like to play?");
        System.out.println(color.YELLOW + "1) Human with Knight and Priest" + color.RESET);
        System.out.println(color.GREEN + "2) Elf with Assasin and Archer" + color.RESET);
        System.out.println(color.RED + "3) Orc with Barbarian and Witcher" + color.RESET);
    }
/********************   Character Options  ********************************/ 
    public void humanOptions() {

        System.out.println("1) Knight - strong, medium damage but slow");
        System.out.println("2) Priest - medium strength and damage but fast like Elf");
    }
    public void elfOptions() {
        System.out.println("1) Assasin - huge damage, very fast but low health");
        System.out.println("2) Archer - the fastest class with big damage, low health");
    }
    public void orcOptions() {
        System.out.println("1) Barbarian: has the strongest health with big damage, very slow");
        System.out.println("2) Witcher - medium damage, big health but just faster than Barbarian");
    }
/********************   Stats Selection ********************************/ 
    public void intialStats(int characterChoice, int armorChoice, int weaponChoice, Warrior warrior, Armor armor, Weapon weapon) {
        int totalDefend = warrior.getDefend() + armor.getArmor()[0] + weapon.getWeapon()[2];
        int totalDamage = warrior.getDamage() + weapon.getWeapon()[0];
        int totalSpeed = warrior.getSpeed() + armor.getArmor()[1] + weapon.getWeapon()[1];

        System.out.printf(color.YELLOW + "Selection: \t%s, %s, %s\n", listCharacter[characterChoice], armor.listArmor[armorChoice], weapon.listWeapon[weaponChoice] + color.RESET);
        System.out.println("Health: \t" + warrior.getHealth());
        System.out.printf("Defend: \t%d + %d + %d = %d\n", warrior.getDefend(), armor.getArmor()[0], weapon.getWeapon()[2], totalDefend);
        System.out.printf("Damage: \t%d + %d = %d\n",warrior.getDamage(), weapon.getWeapon()[0], totalDamage);
        System.out.println("Staminia:\t" + warrior.getStaminia());
        System.out.printf("Speed / Dex: \t%d + %d + %d = %d\n", warrior.getSpeed(), armor.getArmor()[1], weapon.getWeapon()[1], totalSpeed);
        System.out.println("Skill: \t" + warrior.getAbility());
    }

    public void currentStats(Warrior warrior) {
        System.out.println(color.RED_BRIGHT + "Health: \t" + warrior.getHealth());
        System.out.println("Defend: \t" + warrior.getDefend());
        System.out.println("Damage: \t" + warrior.getDamage());
        System.out.println("Staminia:\t" + warrior.getStaminia());
        System.out.println("Speed / Dex: \t" + warrior.getSpeed() + color.RESET);
        System.out.println("");
    }

/******************** Armor Selection ********************************/ 
    public void armorSelection() {
        System.out.println("What type of armor do you want?");
        for (int i=0; i < armor.listArmor.length; i++) {
            System.out.printf("%d) %s: \t%d defend, %d speed\n",i+1,armor.listArmor[i], armor.defend[i], armor.speed[i]);
        }
    }
/******************** Weapon Selection ********************************/ 
    public void weaponSelection() {
        System.out.println("Which weapon would you like to play?");
        for (int i=0; i < weapon.listWeapon.length; i++)
        System.out.printf("%d) %s: \t%d damage, %d speed, %d defend\n", i+1, weapon.listWeapon[i], weapon.damage[i], weapon.speed[i], weapon.defend[i]);
    }

/*<=========================== Attack ===========================>*/ 
    public void strikeOptions() {
        System.out.println("It's your turn, let choose how you want to attack:");
        System.out.println("1) Basic");
        System.out.println("2) Swing");
        System.out.println(color.YELLOW_BACKGROUND + "3) Special skill" + color.RESET);
    }

    public void playerAttack(int damage, int health) {
        if (damage > 0 ) {
            System.out.printf(color.RED_BRIGHT + "You hit %d, and the enemy has %d remaining health\n"  + color.RESET, damage, health);
        } else {
            System.out.println(color.GREEN + "You miss the hit" + color.RESET);
        }
    }

}
