package leetcode.leetcode210;

import java.util.*;

public class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int res[] = new int[numCourses];
        if(numCourses == 0) return new int[0];
        
        // 入度表
        int indegrees[] = new int[numCourses];

        // 将边缘列表转换为邻接表
        HashMap<Integer, HashSet<Integer>> adj = new HashMap<>();
        for(int[] p : prerequisites) {
            indegrees[p[0]]++;
            if(!adj.containsKey(p[1])) {
                adj.put(p[1], new HashSet<>());
            }
            adj.get(p[1]).add(p[0]);
        }

        // 将入度为0的节点加入队列
        LinkedList<Integer> queue = new LinkedList<>();
        for(int i=0; i<numCourses;i++) {
            if(indegrees[i] == 0) {
                queue.add(i);
            }
        }
        int count=0;
        while(!queue.isEmpty()) {
            int num = queue.removeFirst();
            res[count++] = num;
            if(!adj.containsKey(num)){
                continue;
            }
            for(int p : adj.get(num)) {
                if(--indegrees[p]==0) queue.add(p);
            }   
        }
        
        if(count != numCourses) {
            return new int[0];
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // int[][] prerequisites = {{1,0},{2,0},{3,1},{3,2}};
        // int[] res = s.findOrder(4, prerequisites);
        // for(int r : res) {
        //     System.out.println(r);
        // }

        System.out.println("=========================");
        int[][] pre = {{1,0},{0,1}};
        int[] res1 = s.findOrder(2, pre);
        for(int r : res1) {
            System.out.println(r);
        }
    }
}