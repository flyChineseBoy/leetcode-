import java.util.UUID;

public class 股票2 {
    public static int maxProfit(int[] prices) {
        // 暴力递归解：模拟所有的交易过程
        //
        int i = 0; // 代表当前为第几天
        int flag = 0; // 代表当前手里有没有股票
        return Math.max( maxProfit02(prices,0,i+1),maxProfit02(prices,1,i+1)-prices[i] );
    }

    public static int maxProfit02(int[] prices,int flag,int i) {
        if( i >= prices.length ) return 0;
        if( flag==0 ){
            // 没有股票，可以选择买或不买
            return Math.max( maxProfit02(prices,0,i+1),maxProfit02(prices,1,i+1)-prices[i] );
        }
        // 有股票，可以选择卖或不卖
        return Math.max( maxProfit02(prices,0,i+1)+prices[i],maxProfit02(prices,1,i+1) );
    }

    public static void main(String[] args) {

    }
}
