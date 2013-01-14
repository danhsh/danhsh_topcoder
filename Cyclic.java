/**
 *
 * Daniel Ho 9/1/2013
 *
 * Write a program that returns the amount of cyclic representations of a word,
 * within a list. i.e. {word, ordw} would return 1
 * {the, brown, fox, oxf} would return 3
 */
public class Cyclic {

  public int getAmountOfCyclicRepresentation(String[] input){

    int amount = 0;
    boolean unique;

    for(int i=0; i< input.length; i++){
      unique = true;
      for(int k=0; k<i; k++){
        if(isCyclic(input[i],input[k])){
          unique = false;
        }
      }
      if(unique){
        amount++;
      }
    }
    return amount;
  }

  private boolean isCyclic(String stringA, String stringB){

    boolean isSequential = false;

    for(int k=0; k<stringB.length(); k++){
      for(int i=0; i<stringA.length(); i++){
        isSequential = true;
        if(stringA.charAt(i) != stringB.charAt((k+i) % stringB.length())){
          isSequential = false;
          break;
        }
      }
      if(isSequential){
        return true;
      }
    }
    return isSequential;
  }

  public static void main(String[] args) {
//    String[] input =  {"the", "brown", "fox", "oxf"};
    String[] input =  {"xoxoxoxoxoxoxoxoxo", "oxoxoxoxoxoxoxoxox"};
    Cyclic temp = new Cyclic();
    System.out.println(temp.getAmountOfCyclicRepresentation(input));

  }

}
