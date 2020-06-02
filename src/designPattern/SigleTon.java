package designPattern;

/**
 * 单例模式：线程安全、反序列化
 */
public class SigleTon {
    // 1、饿汉模式
    static SigleTon sigleTon = new SigleTon();
    private SigleTon getInstance(){
        return sigleTon;
    }
}

class SigleTon02 {
    SigleTon02 sigleTon02;
    // 2、饿汉模式 -- 线程不安全
    private SigleTon02 getInstance(){
        if(sigleTon02==null)
            return new SigleTon02();
        else
            return sigleTon02;
    }
}


class SigleTon03 {
    // 3、饿汉模式 -- 线程安全 -- 静态内部类
    /**
     *  为什么线程安全：因为 SigleTonInstance的sigleTon在类的初始化阶段被实例化。
     *      而类的初始化阶段是线程安全的。
     */
    private SigleTon03 getInstance(){
        return SigleTonInstance.sigleTon;
    }

    static class SigleTonInstance{
        private static SigleTon03 sigleTon = new SigleTon03();
    }
}


class  SigleTon04 {
    enum SigleTon{
        A,B,C,D
    }
    SigleTon sigleTon;
    // 4、饿汉模式 -- 枚举
    private SigleTon getInstance(){
        return sigleTon;
    }
}


class SigleTon05 {
    SigleTon05 sigleTon;
    // 5、饿汉模式 -- synchroized
    private synchronized SigleTon05 getInstance(){
        if(sigleTon==null){
            return new SigleTon05();
        }
        return sigleTon;
    }
}


class SigleTon06 {
    // volatile在这里防止重排序。防止第二个线程拿到第一个线程生成的不完整的对象。
    // 对象实例化的操作分为：分配内存空间、初始化成员变量、引用指向内存。
    // 第二、三步可能被指令重排，导致并发来的另一个线程拿到一个没有初始化成员变量的对象，造成错误。
    volatile SigleTon06 sigleTon;
    // 5、饿汉模式 -- 双重校验锁
    private synchronized SigleTon06 getInstance(){
        if(sigleTon==null){
            synchronized ( SigleTon.class ){ // 类锁
                if( sigleTon == null ) return new SigleTon06();
            }
        }
        return sigleTon;
    }
}