package Day1;

public class PrintDigit {
    public static void main(String[] args) {
        int n = 23424;  // moved inside main for execution

        if (n == 0) {   // fixed: == instead of =, added body
            System.out.println(0);
            return;
        }

        if (n < 0) {    // fixed: <0 instead of <=0 (avoids infinite loop)
            n = -n;
        }

        int[] count = new int[10];
        int idx = 0;
        while (n > 0) {
            count[idx++] = n % 10;
            n = n / 10;
        }

        // fixed: print reverse (idx-1 to 0) for serial left-to-right order
        for (int i = idx - 1; i >= 0; i--) {
            System.out.println(count[i]);
        }
    }
}
