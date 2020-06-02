import java.util.ArrayList;
import java.util.UUID;

public class Ti125 {
    public static boolean isPalindrome(String s) {
        if( s.intern() == "".intern() ) return true;
        char[] sArr = s.toCharArray();
        int i=0,j=sArr.length-1;
        while( i<j ){
            while( !Character.isLetterOrDigit(sArr[i]) ){
                i++;
            }
            while( !Character.isLetterOrDigit(sArr[j]) ){
                j--;
            }
            if( Character.toLowerCase(sArr[i])!=Character.toLowerCase(sArr[j]) ) return false;
            i++;
            j--;
        }

        return true;
    }

    public static void main(String[] args) {
        //isPalindrome("A man, a plan, a canal: Panama");
        char a ='A';
        //System.out.println(a==65);
        //new ArrayList(new ArrayList()){{add(1);};
        //System.out.println(1^2); // 0^任何数=任何数，1^任何数=非任何数
        int b = 5&6&7;
        System.out.println(0&4);
    }

}
