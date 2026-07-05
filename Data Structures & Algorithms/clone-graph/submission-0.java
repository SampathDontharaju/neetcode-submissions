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

    public Map<Node,Node> nodeMap;
    public Node cloneGraph(Node node) {
        nodeMap = new HashMap<>();
        Node clonedNode = getClonedNode(node);
        return clonedNode;
    }

    public Node getClonedNode(Node node){
        
        if(node==null){
            return null;
        }
        System.out.println("get cloned node for");
        if(nodeMap.size()>0 && nodeMap.containsKey(node)){
            return nodeMap.get(node);
        }else{
            System.out.println("else condn"+node.val);
            Node cloneNode = new Node(node.val);
            List<Node> cloneNeighbors = new ArrayList<>();
            cloneNode.neighbors = cloneNeighbors;
            nodeMap.put(node, cloneNode);

            List<Node> neighbors = node.neighbors;
            for(Node n: neighbors){
                Node clone = getClonedNode(n);
                cloneNeighbors.add(clone);
            }
            cloneNode.neighbors = cloneNeighbors;
            nodeMap.put(node, cloneNode);
            return cloneNode;
        }
    }
}