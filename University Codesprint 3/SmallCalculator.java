import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class SmallCalculator {

    static int solve(String opr) {
        int x=0,y=0,res=0;
        char op;

        char[] arr = opr.toCharArray();
        x = Character.getNumericValue(arr[0]);
        y = Character.getNumericValue(arr[2]);
        op = arr[1];
        switch(op){
            case '+' :
            res = x+y;
            break;
            case '-' :  
                if(x<0)
                    res = x+y;
                else
                    res = x-y;
            break;

        }
        return res;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String opr = in.next();
        int result = solve(opr);
        System.out.println(result);
        in.close();
    }
}
