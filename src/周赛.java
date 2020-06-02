import java.util.*;

public class 周赛 {
        public static int numOfSubarrays(int[] arr, int k, int threshold) {
            /**
             直接： 所有的k个子数组全部算一遍。
             动态规划(时间：n*k)
             dp[n]: dp[i]表示当前这一行， arr[i]+上轮dp[i-k]的和。及dp[i]代表i到之前k位数字的和
             */
            int[] dp = new int[arr.length];
            for(int i=0; i < arr.length; i++){
                dp[i] = 0;
            }
            for(int j=0; j < k;j++ ){
                for(int i=j; i < arr.length; i++){
                    dp[i] = dp[i]+arr[i-j];
                }
            }
            int result = 0;
            for( int i=k-1; i < dp.length; i++ ){
                if(dp[i] >= threshold){
                    result++;
                }
            }
            return result;
        }



    public int minSteps(String s, String t) {
        /**
         用一个hash保存s的所有元素《key,count》
         然后遍历t进行——操作。 时间复杂度 On
         */
        HashMap<Character,Integer> hash = new HashMap<Character,Integer>();
        for( Character sc : s.toCharArray() ){
            hash.put( sc, hash.getOrDefault(sc,0)+1 );
        }

        for( Character tc : t.toCharArray() ){
            if( hash.containsKey(tc) && hash.get(tc)!=0 ){
                hash.put( tc, hash.get(tc)-1 );
            }
        }

        int n = 0 ;
        for( Map.Entry entry : hash.entrySet() ){
            n += (int)entry.getValue();
        }
        return n;
    }

    public static boolean checkIfExist(int[] arr) {
        /**
         时间复杂度O（n）的方法：hash/布隆过滤器
         */
        HashSet<Integer> hash = new HashSet<Integer>();
        for( int a : arr ){
            hash.add(a);
        }
        for( int a : arr ){
            if( hash.contains(a*2) ){
                return true;
            }
        }
        return false;
    }


    public static int maxStudents(char[][] seats) {
        /**
         可以做的座位：
         1、周边一圈挨着墙的，且可看到的位置没有人。
         2、其他排，左上坏的、右上坏的、左边坏的，右边也是坏的
         考虑特殊情况：
         1、左上，右上、左边、右边是否存在。
         2、若当前座位没有坏但是不可用，则将该座位置为#；

         */
        int n = 0;
        for(int i=0; i< seats.length; i++ ){
            for(int j=0; j< seats[i].length; j++ ){
                if( seats[i][j] == '.' ){

                    if( (i==0 || seats[i-1][j]=='#') && (j==0 || (seats[i][j-1]=='#')  ) &&(j==seats[i].length-1 || seats[i][j+1]=='#') && ( i==0 || j==0 || seats[i-1][j-1]=='#' ) && ( i==0 || j==seats[i].length-1 || seats[i-1][j+1]=='#' ) ){
                        n++;
                    }else{
                        seats[i][j] = '#';
                    }
                }

            }
        }
        return n;
    }



    class TweetCounts {

        /**
         hash保存time、name
         区间用LinkedHashMap来区分，按照freq对使用时间按照 60、360、86400取除法，得到的key做value的+1

         */
        HashMap<String,Map<Integer,Integer>> hash = new HashMap<String,Map<Integer,Integer>>();// <name,<time,此刻发了几条>>>
        public TweetCounts() {

        }

        public void recordTweet(String tweetName, int time) {
            Map<Integer,Integer> record= hash.getOrDefault( tweetName, new HashMap()); // 获取当前用户数据
            record.put(time,record.getOrDefault(record,0)+1);
            hash.put( tweetName, record); // 更新当前用户
        }

        public List<Integer> getTweetCountsPerFrequency(String freq, String tweetName, int startTime, int endTime) {
            int time = 60;
            if(freq.equals("hour")){
                time = 60 * 60;
            }else if(freq.equals("day")){
                time = 60*60*24;
            }
            Map<Integer,Integer> userRecords = hash.getOrDefault( tweetName, new HashMap()); // 获取当前用户数据
            LinkedHashMap<Integer,Integer> result = new LinkedHashMap<Integer,Integer>();
            List<Integer> resultInt = new ArrayList<Integer>();
            for( Map.Entry<Integer,Integer> e :  userRecords.entrySet() ){
                Integer key = (e.getKey()-Integer.valueOf(startTime)) / time;
                result.put( key,
                        result.getOrDefault( key,0)+1 );
            }
            for( Map.Entry e :  result.entrySet() ){
                resultInt.add((int)e.getValue());
            }
            return resultInt;
        }
    }


    public static String rankTeams(String[] votes) {
        // 最多只有26个队伍，1000个人进行投票
        // 对每个人的投票进行加权，最后将26的队列的总权重进行排序
        // 用什么来做队伍和权重的映射？自定义排序器？
        Map<Character,Integer> map = new HashMap<Character,Integer>();
        for( int i=0; i<votes.length; i++ ){
            char[] tmp = votes[i].toCharArray();
            for( int j=0; j<tmp.length; j++ ){
                map.put( tmp[j], map.getOrDefault(tmp[j],0)+ (tmp.length-j)^3 ); // 权重赋值，越靠前权重越大
            }
        }
        // 颠倒map，可以通过value获取key
        Map<Integer,Character> map02 = new HashMap<Integer,Character>();
        map.forEach((key,value)->{
            map02.put( value,key );
        });

        // 对map的分数进行排序
        Integer[] scores = map02.keySet().toArray(new Integer[0]);
        Arrays.sort(scores);
        String result = "";
        for( int i=scores.length-1; i>=0; i-- ){
            result+= map02.get(scores[i]);
        }
        return result;

    }
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
    /**
     * Definition for a binary tree node.
     * public class 二叉树.TreeNode {
     *     int val;
     *     二叉树.TreeNode left;
     *     二叉树.TreeNode right;
     *     二叉树.TreeNode(int x) { val = x; }
     * }
    class Solution {
        public boolean isSubPath(ListNode head, 二叉树.TreeNode root) {
            // 对该二叉树从头开始遍历，找到一个结点与head值相同，则找他的子节点是否有与head相同
            if( head==null ) return true;
            if( root==null ) return false;

            boolean flag = false;
            if( root.val!=head.val ){
                flag = isSubPath( head,root.left ) || isSubPath( head,root.right );
            }else{
                // 如果等于，继续寻找两个子节点是否与head的子节点相同
                flag = isSubPath( head.next,root.left ) ||  isSubPath( head.next,root.right );
            }
            return flag;

        }
    }

    public static void main(String[] args) {
       /* int[] arr = new int[]{2,2,2,2,5,5,5,8};
        //System.out.println(numOfSubarrays(arr,3,4));

        int[] arr02 = new int[]{-2,0,10,-19,4,6,-8};
        //checkIfExist(arr02);

        char[][] arr03 = new char[][]{{'#','.','.','.','#'},
                {'.','#','.','#','.'},
                {'.','.','#','.','.'},
                {'.','#','.','#','.'},
                {'#','.','.','.','#'}};

        System.out.println(maxStudents(arr03));
        */
       String[] st = new String[]{"BCA","CAB","CBA","ABC","ACB","BAC"};
       // System.out.println(rankTeams(st));
    }

/**
 * Your TweetCounts object will be instantiated and called as such:
 * TweetCounts obj = new TweetCounts();
 * obj.recordTweet(tweetName,time);
 * List<Integer> param_2 = obj.getTweetCountsPerFrequency(freq,tweetName,startTime,endTime);
 */

