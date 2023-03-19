package Event;

import Arms.Arms;
import Character.*;

public class Battle {
    public void battle(String userName) {

        // 武器
        Arms arms = new Arms();
        arms.name = "エクスカリバー";
        arms.damage = 100;

        Arms bottle = new Arms();
        bottle.name = "隠洗ボトル";
        bottle.damage = 50;

        // ユーザー情報
        User user = new User();
        user.hp = 200;
        user.arms = arms;

        // 聖職者
        Cleric cleric = new Cleric();
        cleric.name = "介護助手";
        cleric.hp = cleric.maxHp;
        cleric.mp = cleric.maxMp;
        cleric.arms = bottle;

        // モンスター
        Monster monster = new Monster();
        monster.appearance();

        while (user.hp > 0 && cleric.hp > 0 || monster.hp > 0) {

            // キャラクターの攻撃力をランダム生成
            monster.power = new java.util.Random().nextInt(200);
            user.power = new java.util.Random().nextInt(150);
            cleric.power = new java.util.Random().nextInt(150);

            // ユーザーが生きている
            if (user.hp > 0) {
                System.out.println(userName + ":HP " + user.hp + " vs " + monster.name + ":HP " + monster.hp);
                System.out.println("");
                System.out.println(userName + "の操作を選択してください");
                System.out.println("1:戦う 2:逃げる");
                int select = new java.util.Scanner(System.in).nextInt();
                System.out.println("*****************************************************");
                System.out.println("");

                if (select == 1) {
                    System.out.println(userName + "の攻撃");
                    int atack = user.atack(userName, user.arms.name, user.arms.damage);
                    System.out.println("");
                    monster.hp -= atack;

                    if (monster.hp <= 0) {
                        System.out.println(monster.name + "を倒した！");
                        break;
                    }

                } else if (select == 2) {
                    System.out.println(userName + "は逃げ出した！");
                    break;
                } else {
                    System.out.println("コマンドエラー！失敗！");
                }
            }

            // clericが生きている
            if (cleric.hp > 0) {
                System.out.println(cleric.name + ":HP " + cleric.hp + " vs " + monster.name + ":HP " + monster.hp);
                System.out.println("");
                System.out.println(cleric.name + "の操作を選択してください");
                System.out.println("1:攻撃 2:回復魔法");
                int select2 = new java.util.Scanner(System.in).nextInt();
                System.out.println("*****************************************************");
                System.out.println("");

                if (select2 == 1) {
                    System.out.println(cleric.name + "の攻撃");
                    int clAtack = cleric.atack(cleric.name, cleric.arms.name, cleric.arms.damage);
                    System.out.println("");
                    monster.hp -= clAtack;

                    if (monster.hp <= 0) {
                        System.out.println(monster.name + "を倒した！");
                        break;
                    }

                } else if (select2 == 2) {
                    cleric.selfAid();
                } else {
                    System.out.println("コマンドエラー！失敗！");
                }
            }

            // どちらかが生きている
            if (user.hp > 0 || cleric.hp > 0) {
                // モンスターがどっちに攻撃するかの選択をランダム生成
                int monsterSelect = new java.util.Random().nextInt(2);

                if (monsterSelect == 0 && user.hp > 0) {
                    System.out.println(monster.name + "の攻撃！");
                    System.out.println(userName + "は、" + monster.power + "のダメージを受けた！");
                    System.out.println("");

                    user.hp -= monster.power;

                    if (user.hp <= 0 && cleric.hp > 0) {
                        System.out.println(userName + "は死んでしまった！");
                        System.out.println("");
                    }
                } else {
                    System.out.println(monster.name + "の攻撃！");
                    System.out.println(cleric.name + "は、" + monster.power + "のダメージを受けた！");
                    System.out.println("");

                    cleric.hp -= monster.power;

                    if (cleric.hp <= 0 && user.hp > 0) {
                        System.out.println(cleric.name + "は死んでしまった！");
                        System.out.println("");
                    }
                }

                if (cleric.hp <= 0 && user.hp <= 0) {
                    System.out.println("全滅した！");
                    System.out.println("");
                    break;
                }
            }
        }

    }
}
