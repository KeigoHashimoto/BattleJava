import Event.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("ようこそ！ひのでクエストへ！");
        System.out.println("名前を登録してください");

        // ユーザーの名前設定
        String userName = new java.util.Scanner(System.in).nextLine();

        System.out.println("-------------------------------------------");
        System.out.println(userName + "さん、こんにちは。いざ、冒険に行こう！");
        System.out.println("-------------------------------------------");

        Battle battle = new Battle(userName);
        battle.battle();
    }
}
