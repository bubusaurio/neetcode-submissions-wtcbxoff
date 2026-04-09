/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node dfs(Node node, Map<Node, Node> seen){
        if(seen.containsKey(node)){
            return seen.get(node);
        }

        Node newNode = new Node(node.val);
        seen.put(node, newNode);

        for(Node neighbor: node.neighbors){
            newNode.neighbors.add(dfs(neighbor, seen));
        }

        return newNode;
    }

    public Node cloneGraph(Node node) {
        if(node == null){
            return null;
        }

        Map<Node, Node> seen = new HashMap<>();

        return dfs(node, seen);
    }
}