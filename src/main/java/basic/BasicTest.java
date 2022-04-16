package basic;

import io.vavr.control.Option;

/**
 * For this basic test, you should not use any library. e.g. you should not use Math.pow for power method
 */
public class BasicTest {

  /**
   * return i ^ n for positive Integer, None otherwise
   * alse return None in case of errors
   */
 public static Option<Integer> power(Integer i, Integer n) {
        
            Option<Integer> res;
            if (n>=0){
        
                Long s=1l;
                int j;
                
                for( j=0;j<n && s<=Integer.MAX_VALUE;j++)
                    s*=i;
                        
                   
                if  (j==n)
                    res=Option.of(s.intValue());
                else
                    res= Option.none();
           
                return res ;
            }
            else
                return Option.none();
      
      }
}
