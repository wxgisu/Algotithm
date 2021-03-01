public class ConvertString {
    public static void main(String[] args) {
        ConvertString cs = new ConvertString();
        String s1 = "table";
        String s2 = "tbres";
        System.out.println(cs.minOp(s1, s2));
    }

    public int minOp(String s1, String s2) {
        if (s1.length() == 0) return s2.length();
        if (s2.length() == 0) return s1.length();
        return minOp(s1, s2, 0, 0);
    }

    private int minOp(String s1, String s2, int i1, int i2) {
        //base case
        if (i1 == s1.length()) //delete all rest from s2
            return s2.length() - i2;
        if (i2 == s2.length()) //add all rest of s1 to s2
            return s1.length() - i1;
        
        //recursion when match
        if (s1.charAt(i1) == s2.charAt(i2))
            return minOp(s1, s2, i1+1, i2+1);
        
        //recursion when not match
        int insertionOp = 1 + minOp(s1, s2, i1+1, i2);
        int deletionOp = 1 + minOp(s1, s2, i1, i2+1);
        int replaceOp = 1 + minOp(s1, s2, i1+1, i2+1);
        return Math.min(insertionOp, Math.min(deletionOp, replaceOp));    

    }
}