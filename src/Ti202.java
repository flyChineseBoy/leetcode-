import java.util.HashSet;

public class Ti202 {
    public static boolean isHappy(int n) {
        // 曾经出现的结果都存入set
        HashSet<String> set = new HashSet<String>();
        while (true) {
            if (n == 1) return true;
            String s = n + "";
            if (set.contains(s)) return false;
            set.add(s);
            char[] chars = s.toCharArray();
            n = 0;
            for (char i : chars) n += Math.pow( i-'0', 2);
        }
    }

    public static void main(String[] args) {
        isHappy( 19 );
    }

}
