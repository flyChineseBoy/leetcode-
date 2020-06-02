import  java.util.LinkedList;

public class Ti5381 {
    class Solution {
        public int[] processQueries(int[] queries, int m) {
            // 暴力挪动，应该超时
            // 1.找到值，2.找到对应下标（保存）， 3. 将值放在队列头，删掉原值， 4. 下一个值。
            int[] res = new int[queries.length];
            LinkedList mQ = new LinkedList();
            for( int i=0; i<m; i++) mQ.add(i+1);

            for( int i=0; i<queries.length; i++ ){
                int index = mQ.indexOf(queries[i]);
                res[i]=index;
                mQ.remove(index);
                mQ.push(queries[i]);
            }
            return res;
        }
    }
}
