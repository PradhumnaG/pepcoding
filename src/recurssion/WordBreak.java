package recurssion;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class WordBreak {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int n = sc.nextInt();
        Set<String> dictionary = new HashSet<>();
        for (int i = 0; i < n; i++) {
            dictionary.add(sc.next());
        }
        sc.close();
        wordBreak(str, "", dictionary);
    }

    public static void wordBreak(String str, String ans, Set<String> dictionary) {
        if (str.length() == 0) {
            System.out.println(ans);
            return;
        }

        for (int i = 0; i < str.length(); i++) {
            String left = str.substring(0, i + 1);
            if (dictionary.contains(left)) {
                String right = str.substring(i + 1);
                wordBreak(right, ans + left+ " ", dictionary);
            }
        }
    }
}
