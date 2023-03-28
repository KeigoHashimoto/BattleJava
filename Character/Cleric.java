package Character;

public class Cleric extends Character {
    public int mp;
    final public int maxHp = 150;
    final public int maxMp = 10;
    public String[] command = { "攻撃", "回復" };

    public void selfAid() {
        if (this.mp > 5) {
            this.mp -= 5;
            int recovery = (maxHp - this.hp);
            this.hp = maxHp;

            System.out.println(this.name + "は、回復魔法を使った。" + recovery + "ポイントHPが回復した。");
            System.out.println("");
        } else {
            System.out.println("MPが足りません");
        }
    }

    public int magic(int monsterHp) {
        if (this.mp > 5) {
            System.out.println(this.name + "は、ファイヤーボールを唱えた");
            this.mp -= 5;
            int fireball = new java.util.Random().nextInt(300);
            System.out.println(this.name + "は、" + fireball + "のダメージを与えた");
            System.out.println("");
            monsterHp -= fireball;
        } else {
            System.out.println("MPが足りません");
            System.out.println("");
        }

        return monsterHp;

    }

}