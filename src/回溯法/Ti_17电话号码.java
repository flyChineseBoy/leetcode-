package 回溯法;/*
 * 回溯法
 * @author: lele
 * @date: 2020-04-29
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Ti_17电话号码 {
    static Map<Character, String> phone = new HashMap<Character, String>() {{
        put('2', "abc");
        put('3', "def");
        put('4', "ghi");
        put('5', "jkl");
        put('6', "mno");
        put('7', "pqrs");
        put('8', "tuv");
        put('9', "wxyz");
    }};

    public static List<String> letterCombinations(String digits) {
        // 回溯法
        if( digits.equals("") ) return new ArrayList();
        List<String> res =  new ArrayList<String>();
        StringBuilder path = new StringBuilder();
        dfs(digits,path,0,res);

        return res;
    }

    // 原数组，当前遍历路径，该到第几个数字，结果集
    static  void dfs( String digits,StringBuilder path, int i,List<String> res ){
        if( path.length() == digits.length() ){
            res.add( path.toString() );
            return;
        }
        if( i>digits.length()-1 ) return;
        //if( !phone.contains(digits.charAt(i)) ) path.add
        String selected = phone.get( digits.charAt(i) );
        for( int j=0; j<selected.length(); j++  ){
            path.append(selected.charAt(j));
            dfs( digits,path,i+1,res );
            path.deleteCharAt( path.length()-1 );
        }

    }

    public static void main(String[] args) {
        System.out.println(letterCombinations("23"));
    }
}
