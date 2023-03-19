package Character;

public class Cleric extends Character {
    public int mp;
    final public int maxHp = 150;
    final public int maxMp = 10;

    public void selfAid() {
        this.mp -= 5;
        int recovery = (maxHp - this.hp);
        this.hp = maxHp;

        System.out.println(this.name + "は、回復魔法を使った。" + recovery + "ポイントHPが回復した。");
        System.out.println("");
    }

}