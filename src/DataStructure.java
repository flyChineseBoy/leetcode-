import java.util.ArrayList;
import java.util.Arrays;

public class DataStructure {
    public static void main(String[] args) {
        Array list = Array.getArray();
        for( int i = 0; i < 10; i++ ){
            list.add(i);
            System.out.println("数组当前长度" + list.length());
        }

        for( int i = 0; i < list.length(); i++ ){
            System.out.println(list.get(i));
        }
    }
}

// 可添加元素的数组
class Array{
    private static Array instance;
    private int[] arrs;
     int size;


    /**
     * 屏蔽构造方法
     */
    private Array(){
        arrs = new int[5];
        size = 0;
    }

    /**
     * 获取唯一实例
     * @return
     */
    public static Array getArray(){  // 线程安全的单例模式返回实例
        // synchronized (instance){ // 如果在这里上锁，会导致每次都要同步，浪费资源。
        if( instance==null ){ // 两个线程同时都进入了这个if里面，就会破坏单例模式，需要改进。
            synchronized ( Array.class ){ //这里锁住class，即只有一个线程可以进来改变值，改变之后因为volidata会直接刷新值
                if( instance == null ) {  // 因为另外一个线程有可能进入这里，所以需要在这里再次判断是否为空
                    instance = new Array();
                }
            }
        }
        return instance;
    }

    /**
     * 添加元素
     * @param elem
     */
    public void add(int elem){
        checkCaptity();
        arrs[size] = elem;
        size++;
    }

    /**
     * 检查数组空间大小，空间2倍不够则扩容
     */
    void checkCaptity(){
        if(size < arrs.length){
            return;
        }
        arrs = Arrays.copyOf(arrs,arrs.length*2);
    }

    /**
     * 获取对应下标的元素
     * @param index
     */
    public int get(int index){
        return arrs[index];
    }

    /**
     * 获取长度
     */
    public int length(){
        return arrs.length;
    }
}


// 可添加元素的数组
class LinkedList{
    Node first;
    Node last;

    LinkedList(){}

    LinkedList(Integer value){
        first = new Node();
        first.value = value;
    }

    /**
     * 头结点插入一个元素
    public LinkedList push(){
        // this.first.
    }
     */

    class Node{
        Integer value;
        Node next;
    }

}
