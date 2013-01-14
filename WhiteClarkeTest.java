import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Interview Question: find first non repeat character within a string.
 * User: daniel_hsh
 * Date: 14/01/13
 */
public class WhiteClarkeTest {

  public static void main (String[] args){

    WhiteClarkeTest temp = new WhiteClarkeTest();
    String input = "White Clarke Group";

    System.out.println(temp.getFirstNonRepeatChar(input));

  }

  public Character getFirstNonRepeatChar(String input){

    HashMap<Character, Integer> count = new HashMap<Character, Integer>();

    List<Character> list = new ArrayList<Character>();

    for(int i =0; i < input.length(); i++){
      if(count.containsKey(input.charAt(i))){
        list.remove((Character)input.charAt(i));
        count.put(input.charAt(i), count.get(input.charAt(i)) + 1);
      } else {
        count.put(input.charAt(i), 1);
        list.add(input.charAt(i));
      }
    }

    if (list.isEmpty()) {
      return null;
    } else {
      return list.get(0);
    }
  }



}
