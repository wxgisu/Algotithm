public class LPSSeq {
    public static void main(String[] args) {
        LPSSeq lps = new LPSSeq();
        String s = "AMEEWMEA";
        int res = lps.lps(s);
        System.out.println(res);
    }

    public int lps(String s) {
        if (s.length() == 0) return 0;
        return lps(s, 0, s.length()-1);
    }

    private int lps(String s, int startIndex, int endIndex) {
        //base case
        if (startIndex > endIndex) return 0;
        if (startIndex == endIndex) return 1;

        //recursion
        //match case c1
        int c1 = 0;
        if (s.charAt(startIndex) == s.charAt(endIndex))
            c1 = 2 + lps(s, startIndex+1, endIndex-1);
        //mis-match case c2, c3
        int c2 = lps(s, startIndex, endIndex-1);
        int c3 = lps(s, startIndex+1, endIndex);
        
        return Math.max(c1, Math.max(c2, c3));
    }
}