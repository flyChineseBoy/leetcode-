package 双指针;

/**
 * 双指针
 *
 * @author: lele
 * @date: 2020-06-19
 */
public class Ti_125_验证回文串 {
    public boolean isPalindrome(String s) {
        // 回文验证，局略特殊字符和字母
        // 前后指针
        int i = 0;
        int j = s.length()-1;

        while( i<j ){
            if( !checkRange(s.charAt(i)) ) {
                i++;
                continue;
            }
            if( !checkRange(s.charAt(j)) ) {
                j--;
                continue;
            }
            if( Character.toUpperCase(s.charAt(j))!= Character.toUpperCase(s.charAt(i)) ) return false;
            else{
                i++;j--;
            }
        }
        return true;
    }

    boolean checkRange( char i ){
        if( '0'<=i && '9'>=i ) return true;
        if( 'a'<=i && 'z'>=i ) return true;
        if( 'A'<=i && 'Z'>=i ) return true;
        return false;
    }

    public static void main(String[] args) {
        Ti_125_验证回文串 t = new Ti_125_验证回文串();
        System.out.println(t.isPalindrome("A man, a plan, a canal: Panama"));
    }
}
