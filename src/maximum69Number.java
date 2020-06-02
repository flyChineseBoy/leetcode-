import java.util.ArrayList;

class maximum69Number {
    public static int maximum69Number (int num) {
        /**
         将遇到的数字全部检查是否为9
         */
        ArrayList<Integer> nums = new ArrayList<Integer>();
        while( num > 0 ){
            nums.add( num % 10 );
            num = num / 10;
        }
        for( int i = nums.size()-1; i >= 0 ; i-- ){
            if( nums.get(i) != 9 ){
                nums.set( i, 9 );
                break;
            }
        }
        for( int i = 0 ; i < nums.size(); i++ ){
            if( i != 0 ){
                num += nums.get(i) * Math.pow( 10, i);
            }
            else{
                num += nums.get(i);
            }

        }
        return num;
    }

    public static int maximum69Number02 (int num) {
        /**
            将遇到的数字全部检查是否为9
         */
        StringBuilder s = new StringBuilder( String.valueOf(  num ) );
        for (int i = 0; i < s.length(); i++) {
            if( s.charAt(i) == '6' ){
                s.setCharAt( i, '9' );
                break;
            }
        }
        num = Integer.valueOf( s.toString() );
        return num;
    }
    public static void main(String[] args) {
        //System.out.println(maximum69Number02(996669));
        // System.out.println(Math.pow(10,2));
        int i = 2;
        //i << 1;
        System.out.println( i );
    }
}