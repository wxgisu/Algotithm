  public class LCS {
    public static void main(String[] args) {
        LCS lcs = new LCS();
        String s1 = "elephant";
        String s2 = "eretpat";
        int res = lcs.lcs(s1, s2);
        System.out.println(res);
    }

    public int lcs(String s1, String s2) {
        if (s1.length() == 0 || s2.length() == 0) return 0;
        return lcs(s1, s2, 0, 0);
    }

    private int lcs(String s1, String s2, int i1, int i2) {
        //base case
        if (i1 == s1.length() || i2 == s2.length()) return 0;

        //recrusion
        //match case
        int matchCase = 0;
        if (s1.charAt(i1) == s2.charAt(i2))
            matchCase = 1 + lcs(s1, s2, i1+1, i2+1);
        //mismatch
        int reserveS1Char = lcs(s1, s2, i1, i2+1);
        int reserveS2Char = lcs(s1, s2, i1+1, i2);
        return Math.max(matchCase, Math.max(reserveS1Char, reserveS2Char));
  }
}