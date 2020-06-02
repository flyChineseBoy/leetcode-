public class Ti5367 {
    class Solution {
        public String longestPrefix(String s) {
            // 从尾部开始往前找，与头字母相同的字符，找到后比较子串
            // 从头部开始往后找，找到与尾字符……
            // 无法动态规划，如何减少时间？
            int max = -1;
            for( int i=0; i<s.length()-1; i++ ){
                if( s.charAt(i)==s.charAt(s.length()-1) ){
                    if( compare(s,i) && i>max ){
                        max = i;
                    }
                }
            }
            if(max==-1) return "";
            return s.substring(0,max+1);
        }

        boolean compare(String s,int i){
            int j = 0;
            for( ; i>=0; i-- ){
                if(s.charAt(i)!=s.charAt(s.length()-1-j)) return false;
                j++;
            }
            return true;
        }
    }
}
