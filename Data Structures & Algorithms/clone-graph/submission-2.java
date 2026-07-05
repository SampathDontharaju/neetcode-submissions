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
    public Node cloneGraph(Node node) {
        if (node == null) return null;
        Map<Node,Node> map = new HashMap<>();
        return getCloneNode(node, map);
    }

    private Node getCloneNode(Node node, Map<Node,Node> map){
        if(map.containsKey(node)){
            return map.get(node);
        }else{
            Node clone = new Node();
            clone.val = node.val;
            map.put(node, clone);
            System.out.println("val ..."+clone.val);
            List<Node> neighbors = new ArrayList<Node>();
            for(Node n: node.neighbors){
                neighbors.add(getCloneNode(n,map));
            }
            clone.neighbors = neighbors;
            return clone;
        }
    }
}