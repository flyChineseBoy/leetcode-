import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

public class RetreentLockTest {

    public static void main(String[] args) {
        ExecutorService service = Executors.newCachedThreadPool();
        ReentrantLock lock = new ReentrantLock();
        for ( int i = 0; i < 100; i++ ){
            service.submit(new MyThread(i,lock));
        }

    }
}
class MyThread implements Callable {
    Integer id = 0;
    ReentrantLock lock;
    @Override
    public Object call() throws Exception {
        try {
            lock.lock();
            System.out.println(id + "获得");
            Thread.sleep((int) (Math.random() * 1000));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println(id + "释放");
            lock.unlock();
        }

        return null;
    }
    MyThread(Integer id,ReentrantLock lock){
        this.id = id;
        this.lock = lock;
    }
}