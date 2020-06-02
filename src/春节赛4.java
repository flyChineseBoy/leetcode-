public class 春节赛4 {
        public static int minJump(int[] jump) {
            //青蛙跳台阶，变态版-变形
            // 对于最后弹簧来说，可能是前10000的任何一个台阶跳过来的
            // 贪心法，跳之前，先看看要跳的这一段里面有没有能跳的更远的。
            int i=0;
            int num = 0;
            while( i < jump.length ){
                int j = i+1;
                int next = i+ jump[i];
                int max = 0;
                if( next<jump.length && jump[next] < jump.length ){
                    max = next+jump[next]; // 两步之后能到达的位置
                }else if(next>=jump.length){
                    num +=1; // 两步之后会蹦出去，那么就直接跳，因为回跳也是至少两步
                    break;
                }else{
                    num +=2;
                    break;
                }

                boolean flag = false;
                while( j < next ){
                    if( jump[j] > max ) {
                        max = jump[j];
                        num+=2;
                        i=jump[j];
                        flag = true;
                    }
                    j++;
                }

                if(!flag){
                    i = next;
                    num++;
                }
            }
            return num;

        }

    public static void main(String[] args) {
        System.out.println(minJump(new int[]{2,5,1,1,1,1}));
    }
}
