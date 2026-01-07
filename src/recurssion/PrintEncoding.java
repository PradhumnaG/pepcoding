package recurssion;

import java.util.Scanner;

public class PrintEncoding {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String str = input.nextLine();
        printEncoding(str, "");
    }
    public static void printEncoding(String str, String str2) {
        if (str.isEmpty()) {
            System.out.println(str2);
            return;
        } else if (str.length() == 1) {
            char ch = str.charAt(0);
            if (ch == '0') {
                return;
            } else {
                int chv = ch - '0';
                char code = (char) ('a' + chv - 1);
                str2 = str2 + code;
                System.out.println(str2);
            }

        } else {
            char ch = str.charAt(0);
            String ros = str.substring(1);

            if (ch == '0') {
                return;
            } else {
                int chv = ch - '0';
                char code = (char) ('a' + chv - 1);
                printEncoding(ros, str2 + code);
            }
            String ch12 = str.substring(0, 2);
            String ros12 = str.substring(2);
            int ch12v = Integer.parseInt(ch12);
            if (ch12v <= 26) {
                char code = (char) ('a' + ch12v - 1);
                printEncoding(ros12, str2 + code);

            }
        }
    }
    }