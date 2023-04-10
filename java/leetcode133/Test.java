package leetcode.leetcode133;

import java.util.*;

class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {}

    public Node(int _val,List<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
};

class Solution {
    public Node cloneGraph(Node node) {
        if(node == null) return null;
        Map<Node, Node> lookup = new HashMap<>();
        Node cloneNode = new Node(node.val, new ArrayList<>());
        lookup.put(node, cloneNode);
        Deque<Node> queue = new LinkedList<>();
        queue.offer(node);
        while(!queue.isEmpty()) {
            Node tmp = queue.poll();
            for(Node n : tmp.neighbors) {
                if(!lookup.containsKey(n)) {
                    queue.offer(n);
                    lookup.put(n, new Node(n.val, new ArrayList<>()));
                }
                lookup.get(tmp).neighbors.add(lookup.get(n));
            }
        }
        return cloneNode;
    }
}

public class Test {
    public static void main(String[] args) {
        Node n = new Node();
        n.val = 2;

        Solution s = new Solution();

        Node cn = s.cloneGraph(n);

        System.out.println(cn.val);
    }
}

