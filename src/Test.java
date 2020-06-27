import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * PACKAGE_NAME
 *
 * @author: lele
 * @date: 2020-06-18
 */
public class Test {

    /*int queickSUm(List<Integer> list, int partLen ){
        Integer threadNum = list.size()/partLen;
        // stream方法：TODO stream设置threadNumge个并行线程
        int sum = list.parallelStream().mapToInt(ele -> ele).sum();
        //return sum;

        // 线程池方式
        ExecutorService pool = Executors.newFixedThreadPool(threadNum);
        AtomicInteger poolSum = new AtomicInteger(0);
        for (Integer i = 0; i < threadNum; i++) {
            AtomicInteger start = new AtomicInteger(i*threadNum);
            AtomicInteger end = new AtomicInteger((i+1)*threadNum);
            if( end.get()>list.size() ) end.set(list.size());

            pool.submit( ()->{
                int localSum = 0;
                for( int j=start.get(); j<end.get(); j++ ){
                     localSum += list.get(j);
                }

                int old = poolSum.get();
                int newNum
                while(poolSum.compareAndSet( old,  )){

                }
            });
        }

    }*/
}
