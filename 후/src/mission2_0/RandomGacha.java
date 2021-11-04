package mission2_0;

import java.util.*;
import java.util.stream.Stream;

class RandomGacha {

    final static int MIN_COIN = 1;

    Scanner coinSlot;
    private int coin = 0;
    List<CocoaMember> members;

    RandomGacha() {
        coinSlot = new Scanner(System.in);
        this.members = CocoaMember.makeShuffledSquad();
    }

    boolean isValidInput(String input) {
        try {
            if (Integer.parseInt(input) < MIN_COIN) {
                throw new InputMismatchException();
            }
            return true;
        } catch (NumberFormatException e) {
            System.out.println("숫자로 입력");
            return false;
        } catch (InputMismatchException e) {
            System.out.println("0보다 큰 숫자로 입력");
            return false;
        }
    }

    void getUserCoin() {
        String input = "";

        System.out.print("insert coin >>>>> ");
        input = coinSlot.nextLine();

        if (isValidInput(input)) {
            int coins = Integer.parseInt(input);
            insertCoin(coins);
            coinSlot.close();
            return;
        }

        getUserCoin();
    }

    void insertCoin(int coins) {
        this.coin += coins;
    }

    void pick() {
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

        gacha.getUserCoin();
        gacha.pick();
        gacha.returnCoin();
    }
}
