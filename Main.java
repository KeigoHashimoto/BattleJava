import Character.*;
import Event.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("ようこそ！ひのでクエストへ！");
        System.out.println("名前を登録してください");

        // ユーザー情報
        User user1 = new User();
        user1.name = new java.util.Scanner(System.in).nextLine();

        System.out.println("-------------------------------------------");
        System.out.println(user1.name + "さん、こんにちは。いざ、冒険に行こう！");
        System.out.println("-------------------------------------------");

        // battle 勇者
        Battle battle = new Battle();
        battle.battle(user1.name);
    }
}
