package Character;

import Arms.Arms;

public class Character {
    public String name;
    public int power;
    public int hp;
    public Arms arms;

    public int atack(String name, String armsName, int armsDamage) {
        System.out.println(name + "は、" + armsName + "で" + armsDamage + "のダメージを与えた");
        return this.power;
    }
}
