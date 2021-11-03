package codesquad.day3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class RefacRandomPick {
    public static void main(String args[]) {
        List<String> cocoaMembersList = addMembers();
        List<String> lastMembersList = shuffleMembers(cocoaMembersList);

        Scanner sc = new Scanner(System.in);
        System.out.print("몇 명인가요 ?");
        int pickMemberCount = sc.nextInt();

        for (int i = 0; i < pickMemberCount; i++) {
            System.out.print(lastMembersList.get(i)+" ");
        }

    }

    public static List<String> addMembers() {
        List<String> cocoaMemberList = new ArrayList<String>();
        cocoaMemberList.add("Tany");
        cocoaMemberList.add("땃쥐");
        cocoaMemberList.add("피오");
        cocoaMemberList.add("K");
        cocoaMemberList.add("mandoo");
        cocoaMemberList.add("donggi");
        cocoaMemberList.add("Jerry");
        cocoaMemberList.add("노리");
        cocoaMemberList.add("Hoo");
        cocoaMemberList.add("taksu");
        cocoaMemberList.add("MK");

        return cocoaMemberList;

    }

    public static List<String> shuffleMembers(List<String> cocoaMemberList) {
        Collections.shuffle(cocoaMemberList);

        return cocoaMemberList;

    }
}
