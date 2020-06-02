import java.util.ArrayList;
import java.util.List;

public class Ti5380 {
    class Solution {
        public List<String> stringMatching(String[] words) {
            // 暴力contians？
            List<String> res = new ArrayList<String>();
            for( int i=0; i<words.length; i++ ){
                for( int j=0; j<words.length; j++ ){
                    if( i!=j && words[j].contains(words[i]) ){
                        res.add(words[i]);
                        break;
                    }
                }
            }
            return res;
        }
    }
}
