public class Ti1392 {

    // 字符串hash解法
    class StrHash {

        static final long P = 805306457;
        static final long MOD = (int) (1e9+7);
        long[] hash;
        long[] power;
        char[] arr;

        public StrHash(char[] arr) {
            this.arr = arr;
            int len = arr.length;
            hash = new long[len];
            power = new long[len];
            calcHashAndPower();
        }

        void calcHashAndPower() {
            hash[0] = arr[0];
            power[0] = 1;
            for (int i = 1; i < arr.length; i++) {
                hash[i] = (hash[i-1] * P + arr[i]) % MOD;
                power[i] = (power[i-1] * P) % MOD;
            }
        }

        long getSubStrHash(int l, int r) {
            if (l == 0) {
                return hash[r];
            }
            return ((hash[r] - power[r-l+1] * hash[l-1]) % MOD + MOD) % MOD;
        }

    }
    class Solution{
        public String longestPrefix(String s) {
            char[] arr = s.toCharArray();
            StrHash strHash = new StrHash(arr);
            int len = arr.length;

            for (int i = len - 2; i >= 0; i--) {
                long prefix = strHash.getSubStrHash(0, i);
                long suffix = strHash.getSubStrHash(len - i - 1, len - 1);
                if (prefix == suffix) {
                    return s.substring(0, i + 1);
                }
            }

            return "";
        }
    }



 // 2、KMP解法
 class Solution02 {
     public String longestPrefix(String s) {
         // KMP
         // 求解next数组，next数组最后一位即为真后缀的最后一位
         int[] next = new int[s.length()+1];
         getNext(s,next);
         return s.substring( 0,next[s.length()] );
     }

     // O(n)
     void getNext(String s,int[] next ){
         int i=0; // 后指针，不断后移
         int j=-1; // 前指针，不断寻找与后指针相同的值，否则跳回前面去
         next[0] = -1; // 下标0不代表任何一个字母，作为特殊的边界处理
         while( i<s.length() ){
             if( j==-1 || s.charAt(i)==s.charAt(j) ){
                 next[++i] = ++j;
             }else{
                 j = next[j];
             }
         }
     }
 }


}
