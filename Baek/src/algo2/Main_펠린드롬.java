package algo2;
import java.util.Scanner;
public class Main_펠린드롬 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		System.out.println(checkPalindrom(str));
		sc.close();
	}
    private static int checkPalindrom(String arg) {
        int j = arg.length() - 1;
        for (int i = 0; i < arg.length() / 2; i++, j--) {
            if (arg.charAt(i) != arg.charAt(j)) {
                return 0;
            }
        }        
        return 1;
    }
}
