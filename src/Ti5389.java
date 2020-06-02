import java.util.*;

public class Ti5389 {
    class Solution {
        public List<List<String>> displayTable(List<List<String>> orders) {
            //List<String> head = new ArrayList<String>();
            Map<String,Integer> headSet = new HashMap<String,Integer>();
            List<String> foods = new ArrayList<>(); // 保存所有食物
            PriorityQueue<Integer> tables = new PriorityQueue<Integer>(); // 保存所有桌子

            for( List<String> order : orders ){
                if( !tables.contains(Integer.valueOf(order.get(1)) )) {
                    tables.offer(Integer.valueOf(order.get(1)));
                }
                if(!foods.contains(order.get(2))) foods.add(order.get(2));
                headSet.put( order.get(1)+"_"+order.get(2),headSet.getOrDefault(order.get(1)+"_"+order.get(2),0)+1 );
            }


            Collections.sort(foods);

            List<List<String>> res = new ArrayList<List<String>>();
            List<String> h = new ArrayList<String>();
            h.add("Table");
            for( String food : foods ){
                h.add( food );
            }
            res.add(h);

            while( !tables.isEmpty() ){
                String table = tables.poll()+"";
                List<String> t = new ArrayList<String>();
                t.add(table);
                for( String food : foods ){
                    if( headSet.containsKey(table+"_"+food) ) t.add(headSet.get(table+"_"+food)+"");
                    else t.add("0");
                }
                res.add(t);
            }
            return res;
        }
    }
}
