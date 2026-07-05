class Solution {

    public String encode(List<String> strs) {
            
        StringBuilder sb = new StringBuilder();
        for(String x: strs){
            sb.append(x);
            sb.append('π');
        }
        System.out.println(sb.toString());
        return sb.toString();

    }

    public List<String> decode(String str) {

        String[] strs = str.split("π",-1);
        List<String> res = new ArrayList<String>();
        for(String x: strs){
            StringBuilder sb = new StringBuilder(x);
            int len = sb.length();
            if(len==0){
                System.out.println("len is zero");
            }
            res.add(sb.toString());
        }
        return res.subList(0,res.size()-1); 

    }
}
