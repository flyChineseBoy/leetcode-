public class Ti5390 {
    public int minNumberOfFrogs(String croakOfFrogs) {
        // 鸣叫中青蛙
        // 已结束青蛙
        // 分别记录五个字符出现的次数，当五个字符都大于1时，可以将一个鸣叫中青蛙转化为已结束。
        // 到最后如果五个字符串没有全部为0，则返回-1
        int c = 0;int r = 0;int o = 0;int a = 0;int k = 0;
        int running = 0;
        int end = 0;
        for( int i=0; i<croakOfFrogs.length(); i++ ){
            char ele = croakOfFrogs.charAt(i);
            switch(ele){
                case 'c':{
                    c++;
                    if( end>0 )end--;
                    running++;
                    break;
                }
                case 'r':{
                    if( c>0 )
                        r++;
                    break;
                }
                case 'o':{
                    if( c>0 && r>0)
                        o++;
                    break;
                }
                case 'a':{
                    if( c>0 && r>0 && o>0 )
                        a++;
                    break;
                }
                case 'k':{
                    if( c>0 && r>0 && o>0 && a>0)
                        k++;
                    break;
                }
                default:
                    break;
            }

            if( c>0 && r>0 &&a>0 && o>0 &&k>0 ) {
                c--;r--;a--;o--;k--;
                running--;end++;
            }
        }
        if( c==0 && r==0 && a==0 && o==0 && k==0 ) return end;
        return -1;
    }
}
