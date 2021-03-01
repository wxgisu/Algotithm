public class LPSString {
    public static void main(String[] args) {
        LPSString lps = new LPSString();
        String s1 = "ABCCBUA";
        String s2 = "ABCYRCFBTUA";
        int res1 = lps.lps(s1);
        int res2 = lps.lps(s2);
        System.out.println(res1 +" " + res2);
    }

    public int lps(String s) {
        if (s.length() == 0) return 0;
        return lps(s, 0, s.length()-1);
    }

    private int lps(String s, int startIndex, int endIndex) {
        //edge case
        if (startIndex > endIndex) return 0;
        if (startIndex == endIndex) return 1;

        //recursion
        //match case c1
        int c1 = 0;
        if (s.charAt(startIndex) == s.charAt(endIndex)) {
            int leftLen = endIndex - startIndex -1;
            if (lps(s, startIndex+1, endIndex-1) == leftLen) {
                c1 = 2 + leftLen; // because all leftover length is a palindrom, 
                                  // its definitely longer than removeing 1 char 
                                  // from either end, so can safely return
                return c1;
            }
        }
        //mis-match case
        int c2 = lps(s, startIndex, endIndex-1);
        int c3 = lps(s, startIndex+1, endIndex);
        return Math.max(c2, c3);
    }
}