package Event;

import java.util.concurrent.TimeUnit;

import Character.*;

public class Battle {
    public String userName;

    public Battle(String userName) {
        this.userName = userName;
    }

    public void battle() {
        // ユーザー
        User user = new User();
        user.name = this.userName;
        user.hp = 200;

        // 助手
        Cleric assistant = new Cleric();
        assistant.name = "介護助手";
        assistant.hp = assistant.maxHp;
        assistant.mp = assistant.maxMp;

        // battle
        // モンスター
        Monster monster = new Monster();
        monster.appearance();

        while (monster.hp > 0) {
            user.setPower(100);
            assistant.setPower(100);
            monster.setPower(150);

            if (user.hp <= 0) {
                System.out.println("---------------------------------");
                System.out.println(assistant.name + ":" + assistant.hp);
                System.out.println(monster.name + ":" + monster.hp);
                System.out.println("---------------------------------");
            } else if (assistant.hp <= 0) {
                System.out.println("---------------------------------");
                System.out.println(user.name + ":" + user.hp);
                System.out.println(monster.name + ":" + monster.hp);
                System.out.println("---------------------------------");
            } else {
                System.out.println("---------------------------------");
                System.out.println(user.name + ":" + user.hp);
                System.out.println(assistant.name + ":" + assistant.hp);
                System.out.println(monster.name + ":" + monster.hp);
                System.out.println("---------------------------------");
            }

            if (user.hp > 0) {
                System.out.println(user.name + "のターン。");
                for (int i = 0; i < user.command.length; i++) {
                    System.out.print((i + 1) + ":" + user.command[i]);
                    System.out.println("");
                }
                int commandSelect = new java.util.Scanner(System.in).nextInt();

                if (commandSelect == 1) {
                    int attack = user.attack(user.name, user.power, user.armsName);
                    monster.hp -= attack;
                } else if (commandSelect == 2) {
                    user.escape();
                    break;
                } else {
                    System.out.println("コマンドエラー");
                }

                if (monster.hp <= 0) {
                    System.out.println(monster.name + "を倒した！");
                    break;
                }

            }

            if (assistant.hp > 0) {
                System.out.println(assistant.name + "のターン。");
                int commandSelect = new java.util.Random().nextInt(assistant.command.length);

                if (commandSelect == 0) {
                    int attack = assistant.attack(assistant.name, assistant.power, assistant.armsName);
                    monster.hp -= attack;
                } else if (commandSelect == 1) {
                    int magic = assistant.magic(monster.hp);
                    monster.hp = magic;
                } else {
                    System.out.println("コマンドエラー");
                }

                if (monster.hp <= 0) {
                    System.out.println(monster.name + "を倒した！");
                    break;
                }
            }

            // ユーザーかアシスタントのどちらかが生きている時
            if (user.hp > 0 || assistant.hp > 0) {
                System.out.println(monster.name + "の攻撃");
                int monstersSelect = new java.util.Random().nextInt(2);
                if (monstersSelect == 0 || assistant.hp <= 0) {
                    user.hp -= monster.power;
                    System.out.println(user.name + "は、" + monster.power + "のダメージを受けた");
                    if (user.hp <= 0) {
                        System.out.println(user.name + "は、死んでしまった");
                    }
                } else if (monstersSelect == 1 || user.hp <= 0) {
                    assistant.hp -= monster.power;
                    System.out.println(assistant.name + "は、" + monster.power + "のダメージを受けた");
                    if (assistant.hp <= 0) {
                        System.out.println(assistant.name + "は、死んでしまった");
                    }
                } else {
                    System.out.println("エラー");
                }
            } else {
                System.out.println("全滅した");
                break;
            }
        }
    }
}