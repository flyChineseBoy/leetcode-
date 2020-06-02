public class 面试题58 {
    public static String reverseWords(String s) {
        // 1、split然后反着拼接
        String[] split = s.split(" ");
        StringBuilder builder = new StringBuilder();
        for( int i=split.length-1; i>=0; i-- ){
            if(!split[i].trim().equals("") ) builder.append(split[i]+" ");
        }
        builder.deleteCharAt(builder.length()-1);

        return builder.toString();
    }

    public static void main(String[] args) {
        System.out.println( reverseWords("  hello world!  ") );
    }
}
