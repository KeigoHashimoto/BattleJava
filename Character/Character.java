package Character;

import Arms.Arms;

public class Character {
    public String name;
    public int power;
    public int hp;
    public String armsName;
    public String[] command;

    /*
     * 攻撃
     */
    public int attack(String name, int power, String armsName) {
        if (armsName != null) {
            System.out.println(name + "は、" + armsName + "で" + power + "のダメージを与えた");
            System.out.println("");

        } else {
            System.out.println(name + "は、素手で" + power + "のダメージを与えた");
            System.out.println("");
        }
        return power;
    }

    /*
     * 魔法
     */
    public void magic() {
        System.out.println(this.name + "は、魔法が使えません");
    }

    /*
     * 逃げる
     */
    public void escape() {
        System.out.println(this.name + "は逃げ出した");
    }

    /*
     * 装備を身につける
     */
    public void setArms(String name, int damage) {
        Arms arms = new Arms(name, damage);
        this.armsName = arms.name;
        this.power = this.power + arms.damage;
        System.out.println(arms.name + "を装備しました");
    }

    /*
     * 攻撃力をランダムで決める
     */
    public void setPower(int amount) {
        // キャラクターの攻撃力をランダム生成
        this.power = new java.util.Random().nextInt(amount);
    }
}
