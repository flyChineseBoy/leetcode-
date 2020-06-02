public class Ti28 {
        public static int strStr(String haystack, String needle) {
            // 就遍历？然后haystack中找到needle的首字母就开始比较后面的？
            // KMP了解下
            char[] haystackChar = haystack.toCharArray();
            char[] needleChar = needle.toCharArray();
            int i = 0; //用于遍历haystackChar
            while( i < haystackChar.length ){
                if( haystackChar[i] == needleChar[0] ){
                    int j=0;
                    for( ; j<needleChar.length; j++ ){
                        if( i+j<haystackChar.length && needleChar[j] != haystackChar[i+j] ) break;
                    }
                    if( j == needleChar.length ) return i;
                }
                i++;
            }
            return -1;
        }

    public static void main(String[] args) {
        strStr("hello","ll");
    }
}
