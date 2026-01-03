package recurssion;

public class PrintZigZag {
    public static void pzz(int n) {
        if (n == 0) {
            return;
        }
        System.out.print("pre" + n);
        pzz(n - 1);
        System.out.print("in" + n);
        pzz(n - 1);
        System.out.println("post" + n);

        }
}
