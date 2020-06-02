import java.util.HashMap;
import java.util.Map;

public class TI5382 {
        public static String entityParser(String text) {
            // 用map保存规则，然后顺序遍历test，按照规则改变字符串
            //
            Map<String,Character> map = new HashMap<String,Character>();
            map.put("&quot;",'"'); //6
            map.put("&apos;",'\'');// 5
            map.put("&amp;",'&');// 5
            map.put("&gt;",'>');// 4
            map.put("&lt;",'<'); // 4
            map.put("&frasl;",'/'); //7

            StringBuilder builder = new StringBuilder(text);
            for (int i = 0; i < builder.length(); i++) {
                if(  builder.charAt(i)=='&'){
                    for( int j=4; j<8; j++ ){
                        if( map.containsKey( builder.substring(i,i+j)  )){
                            Character character = map.get( builder.substring(i,i+j)  );
                            builder.delete(i,i+j);
                            builder.insert(i,character);
                            break;
                        }
                    }
                }
            }
            return  builder.toString();
        }

        public static void main(String[] args) {
            System.out.println(entityParser("&amp; is an HTML entity but &ambassador; is not."));
        }
}
