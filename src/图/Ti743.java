package 图;/*
 * 图
 * @author: lele
 * @date: 2020-04-25
 */

import java.util.*;

public class Ti743 {

    class Node{
        Integer node;
        Integer val;
        Node(Integer node,Integer val){ this.node=node;this.val=val; }
    }
    public  int networkDelayTime(int[][] times, int N, int K) {
        // 利用dijkstra算法的dist数组求解,代码繁琐，不如邻接矩阵
        int[] dist = new int[N+1];
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>();
        Map<Integer,ArrayList<Node>> adjList = new HashMap<Integer,ArrayList<Node>>();

        // 初始化图的邻接表
        for( int i=0; i<times.length; i++ ){
            ArrayList nodeAdj = adjList.getOrDefault(times[i][0], new ArrayList<Node>());
            Node node = new Node(times[i][1],times[i][2]);
            nodeAdj.add(node);
            adjList.put( times[i][0], nodeAdj);
        }

        // 初始化各点到K点的距离
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[K] = 0;
        dist[0] = -1;

        // 松弛操作，从K点开始，以到K点距离优先的方式遍历所有节点
        heap.offer( K );
        while( !heap.isEmpty() ){
            Integer node = heap.poll();
            if( adjList.containsKey(node) ){
                ArrayList<Node> nodeAdj = adjList.get(node); // 获取该节点邻接列表
                for( int i=0; i<nodeAdj.size(); i++ ){
                    if( dist[nodeAdj.get(i).node] > dist[node]+nodeAdj.get(i).val ){
                        // 找到了一条K到nodeAdj.get(i)更短的路
                        heap.offer(nodeAdj.get(i).node);
                        dist[nodeAdj.get(i).node] = dist[node]+nodeAdj.get(i).val;
                    }
                }
            }
        }

        int max = -1;
        for( int node : dist ){
            max = Math.max(max,node);
        }
        if( max==Integer.MAX_VALUE ) return -1;
        return max;
    }


    public static void main(String[] args) {
        Ti743 ti = new Ti743();
        int[][] a = new int[][]{{2,1,1},{2,3,1},{3,4,1}};
        System.out.println(ti.networkDelayTime(a,4,2));
    }
}
