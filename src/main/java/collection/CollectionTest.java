package collection;

import java.util.List;
import java.util.stream.Collectors;
import basic.BasicTest;

/**
 * You should complete the function in this class
 * <p>
 * Feel free to define any method and / or class you want
 */
class CollectionTest {


  /**
   * operation : x -> ((x * 2) + 3) ^ 5
   */
 public static List<Double> compute1(List<Integer> input) {
 List<Double> output= input.stream().map(x-> new Double(BasicTest.power((x*2)+3,5).get())).collect(Collectors.toList());
    return output;
  }

  /**
   * operation : abc -> AbcAbc
   */
  public static List<String> compute2(List<String> input) {
    List<String> output =input.stream().map(x->x.substring(0,Math.min(x.length(),1)).toUpperCase()+x.substring(Math.min(x.length(),1))).map(x->x+x).collect(Collectors.toList());
    return output;
  }

}
