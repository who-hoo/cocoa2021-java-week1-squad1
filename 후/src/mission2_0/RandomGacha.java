package mission2_0;

import java.util.*;
import java.util.stream.Stream;

class RandomGacha {

    private int coin = 0;
    List<CocoaMember> members;

    RandomGacha() {
        this.members = CocoaMember.makeShuffledSquad();
    }

    int getUserCoin() {
        Scanner sc = new Scanner(System.in);
        int coins = 0;
        while (true) {
            System.out.print("insert coin >>>>> ");
            try {
                coins = Integer.parseInt(sc.nextLine());
                if (coins > 0) {
                    sc.close();
                    break;
                }
            } catch (Exception e) {
            }
            System.out.println("양의 정수로 입력하시죠");
        }
        return coins;
    }

    void insertCoin(int coins) {
        this.coin += coins;
    }

    void draw() {
        StringBuilder result = new StringBuilder();
        Stream<CocoaMember> memberStream;
        memberStream = members.stream();

        memberStream
            .limit(coin)
            .peek(member -> coin--)
            .forEach(member -> result.append(member.getName() + ", "));

        System.out.println(result.substring(0, result.length() - 2));
    }

    void returnCoin() {
        System.out.println("남은 동전을 반환합니다...");
        while (coin > 0) {
            System.out.print("\uD83D\uDFE1 ");
            coin--;
        }
        System.out.println("...끝!");
    }

    public static void main(String[] args) {
        RandomGacha gacha = new RandomGacha();

        int coins = gacha.getUserCoin();
        gacha.insertCoin(coins);
        gacha.draw();
        gacha.returnCoin();
    }
}
