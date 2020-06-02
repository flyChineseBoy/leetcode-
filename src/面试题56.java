public class 面试题56 {
    public static  int singleNumber(int[] nums) {
        // 1、hashmap
        // 2、计算每一个bit位的总和，出现3的倍数的都是3次数字的，出现余数说明是单次数在这一位上为1.
        // O(32*n)
        int flag = 1;
        int res = 0;
        for( int i=0; i<31; i++ ){
            int count=0;
            for( int j=0; j<nums.length; j++ ){
                if( (nums[j]&flag)!=0 ) count++;
            }
            if(count%3==1){
                res = flag | res;
            }
            flag <<= 1;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(singleNumber( new int[]{1,1,6,1}));
    }
}
