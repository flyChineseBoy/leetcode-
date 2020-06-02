import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Ti5388 {
    class Solution {
        public String reformat(String s) {
            if(s.length()<1) return "";
            int i=0;
            int j=0;
            StringBuilder digits = new StringBuilder();
            StringBuilder chars = new StringBuilder();
            StringBuilder res = new StringBuilder();

            for( int k=0; k< s.length(); k++ ){
                if( s.charAt(k)>='a' && s.charAt(k)<='z' ) chars.append(s.charAt(k));
                else digits.append(s.charAt(k));
            }

            if( Math.abs(digits.length() -chars.length())>=2 ) return "";

            if( i>j )
                while( i<digits.length() || j<chars.length() ){
                    if(i<digits.length() ) res.append( digits.charAt(i++) );
                    if(j<chars.length() ) res.append( chars.charAt(j++) );
                }
            else
                while( i<digits.length() || j<chars.length() ){
                    if(j<chars.length() ) res.append( chars.charAt(j++) );
                    if(i<digits.length() ) res.append( digits.charAt(i++) );
                }

            return res.toString();


        }
    }

    public static void main(String[] args) {
        List<List<String>> head = new ArrayList<List<String>> ();
        PriorityQueue q = new  PriorityQueue<String>(); // 保存所有桌子
    }
}
