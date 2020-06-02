
import java.util.Arrays;
import java.util.List;

/**
 * PACKAGE_NAME
 *
 * @author: lele
 * @date: 2020-05-13
 */
public class Ti139_单词拆分 {

    private String s;
    private List<String> wordDict;
    public boolean wordBreak(String s, List<String> wordDict) {
        // 穷举法:将字符串拆分成n2中情况的子字符串，然后每种情况匹配
        // 反向思维:是否可用字典拼接处原字符串_dfs  ------ 超时了
        // 优化：增加一个memo数组
        this.s = s;
        this.wordDict = wordDict;
        return dfs("",0);
    }

    // 返回start开始往后的字符串是否符合字典
    boolean dfs(String curr,int start) {
        if( curr.equals(s) ) return true;
        if( start>s.length()-1 ) return false;
        boolean res = false;
        for( int i=0; i<wordDict.size(); i++ ){
            if( wordDict.get(i).startsWith(s.substring(start,start+1)) ){
                if( equals( start,wordDict.get(i) ) ){
                    res = res || dfs( curr+wordDict.get(i),start+wordDict.get(i).length());
                }
            }
        }
        return res;
    }

    boolean equals( int start,String ele ){
        if( start+ele.length() > s.length() ) return false;
        return ele.equals( s.substring(start,start+ele.length()) );
    }
    public static void main(String[] args) {
        Ti139_单词拆分 t = new Ti139_单词拆分();
        String[] a = new String[]{"leet", "code"};
        System.out.println(t.wordBreak("leetcode", Arrays.asList(a)));
    }
}
