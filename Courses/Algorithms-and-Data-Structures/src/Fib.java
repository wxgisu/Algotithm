public class Fib{

    public static void main(String[] args) {
        System.out.println(Fib.fib(2));
    }
    //0 1 1 2 3 5 
    public static int fib(int i) {
        if (i<0) return -1;
        if (i==0 || i==1)
            return i;
        int res = fib(i-1) + fib(i-2);
        return res;
    }


    /*
    When to pass variables into recursive function?
    When to have recursive function return/not return value?
        - when a recursive function is post order, 
          meaning the current call is completely depending on 
          subsequent calls, return is necessary


    Does the recursive function
        - just do something (traverse, update data structure)
        - calculate something 

    */


}