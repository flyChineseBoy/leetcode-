package 动态规划;

/**
 * 动态规划
 *
 * @author: lele
 * @date: 2020-05-14
 */
public class Ti409_最长回文子串 {
    private boolean[][] dp;
    public int longestPalindrome(String s) {
        // 1、i、j表示子串下标，逐个判断是否为回文串。 O(n2)
        // 2、dp：状态转移：dp[i,j]=dp[i-1,j+1] && s[i]==s[j]
        //    边界： dp[i,j]=true ; dp[i,i+i]= s[i]==s[i+1]
        dp = new boolean[s.length()][s.length()];
        int L = s.length();
        for( int i=0; i<L; i++ ){
            dp[i][i] = true;
        }
        int max = 1;
        // k为i和j之间的距离
        for( int k=1; k<L; k++ ){
            for( int i=0; i<L-k; i++ ){
                dp[i][i+k] = dp[i+1][i+k-1] && s.charAt(i)==s.charAt(i+k);
                if( dp[i][i+k] )
                    max = Math.max(k,max);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Ti409_最长回文子串 t = new Ti409_最长回文子串();
        System.out.println( t.longestPalindrome("abccccdd") );
    }
}
