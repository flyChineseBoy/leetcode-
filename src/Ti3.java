import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Ti3 {
    class Solution {
        public int[] getTriggerTime(int[][] increase, int[][] requirements) {
            // 触发剧情数组，默认为-1；
            int[] trigger = new int[requirements.length];
            int[] base =  new int[3];
            // 每一轮获取最小三个数，若本次资源未达到这是三个数，直接跳过
            int[] minRequire = new int[3];
            for(int i =0; i<minRequire.length;i++) minRequire[i]=requirements[0][i];
            // 用list保存剩余还没有被触发的requirements
            List<Integer> others = new ArrayList<Integer>();


            Arrays.fill(trigger,-1); // 初始化结果集


            for(int j =0; j<trigger.length;j++) {
                if(trigger[j]!=-1) continue; // 剧情已经触发
                else if( base[0]>=requirements[j][0] && base[1]>=requirements[j][1] && base[2]>=requirements[j][2] ) trigger[j]=0;
                else{
                    // 保留三个最小值
                    minRequire[0] = Math.min(minRequire[0],requirements[j][0]);
                    minRequire[1] = Math.min(minRequire[1],requirements[j][1]);
                    minRequire[2] = Math.min(minRequire[2],requirements[j][2]);
                    others.add(j);
                }
            }

            for(int i =0; i<increase.length;i++){
                base[0] += increase[i][0];
                base[1] += increase[i][1];
                base[2] += increase[i][2];
                if( base[0]<minRequire[0] || base[1]<minRequire[1] || base[2]<minRequire[2]) continue;

                Iterator<Integer> it = others.iterator();
                while(it.hasNext()){
                    Integer j = it.next();
                    if(trigger[j]!=-1) continue; // 剧情已经触发
                    if( base[0]>=requirements[j][0] && base[1]>=requirements[j][1] && base[2]>=requirements[j][2] ){
                        trigger[j]=i+1;
                        it.remove();
                    }
                    else{
                        // 保留三个最小值
                        minRequire[0] = Math.min(minRequire[0],requirements[j][0]);
                        minRequire[1] = Math.min(minRequire[1],requirements[j][1]);
                        minRequire[2] = Math.min(minRequire[2],requirements[j][2]);

                    }

                }
            }

            return trigger;
        }
    }


    public static void main(String[] args) {
        List<Integer> a = new ArrayList<Integer>();
        a.add(1);
        a.add(2);
        a.add(3);
        Iterator<Integer> it = a.iterator();
        while(it.hasNext()){
            Integer x = it.next();
            if(x.equals(1)) it.remove();
        }

        a.forEach(x-> System.out.println(x));
    }
}
