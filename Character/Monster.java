package Character;

public class Monster extends Character {

    public void appearance() {
        int nameSelector = new java.util.Random().nextInt(3);

        // モンスターをランダムに出現
        if (nameSelector == 0) {
            this.name = "片麻痺";
            this.hp = 100;
        } else if (nameSelector == 1) {
            this.name = "認知症";
            this.hp = 300;
        } else if (nameSelector == 2) {
            this.name = "精神疾患";
            this.hp = 500;
        }

        System.out.println(this.name + "が現れた！");
    }
}
