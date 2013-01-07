//SRM 144 DIV 1
import java.util.*;
public class Lottery {

  public class LotteryType implements Comparable{
    public String name;
    public int choices;
    public int blanks;
    public String sorted;
    public String unique;
    public long probability;

    public LotteryType(String input){
      String[] args = input.split(":");
      this.name = args[0];
      String[] properties = args[1].split(" ");
      this.choices = Integer.parseInt(properties[1]);
      this.blanks = Integer.parseInt(properties[2]);
      this.sorted = properties[3];
      this.unique = properties[4];
    }

    public int compareTo(Object otherObject){

      LotteryType otherType = (LotteryType) otherObject;
      if (this.probability == otherType.probability){
        return this.name.compareTo(otherType.name);
      }
      return (int) (this.probability - otherType.probability);

    }
    public void calculateProbability(){
      int[] combinations = new int[this.blanks];
      initCombination(combinations);
      long counter = 0;

      while (!isMaxCombination(combinations)){

        counter = validate(combinations, counter);
        increment(combinations,combinations.length-1);
      }

      counter = validate(combinations, counter);

      probability = counter;
    }

    private long validate(int[] combinations, long counter){

      if(sorted.equals("T") && unique.equals("T")){
        if (checkIfSorted(combinations) && checkIfUnique(combinations)){
          counter++;
        }
      } else if(sorted.equals("T") && unique.equals("F")){
        if (checkIfSorted(combinations)){
          counter++;
        }
      } else if(sorted.equals("F") && unique.equals("T")){
        if (checkIfUnique(combinations)){
          counter++;
        }
      } else {
        counter++;
      }

      return counter;
    }


    private boolean checkIfSorted(int[] combinations){
      boolean isSorted = true;

      for(int k=0; k<combinations.length-1; k++){
        for(int j=k+1;j<combinations.length;j++){
          if(combinations[k]>combinations[j]){
            isSorted = false;
          }
        }
      }
      return isSorted;
    }

    private boolean checkIfUnique(int[] combinations){
      boolean isUnique = true;

      for(int k=0; k<combinations.length-1; k++){
        for(int j=k+1;j<combinations.length;j++){
          if(combinations[k] == combinations[j]){
            isUnique = false;
          }
        }
      }
      return isUnique;
    }


    private boolean isMaxCombination(int[] combinations){
      boolean isMax = true;
      for(int j=0; j < combinations.length; j++){
        if(combinations[j]!= choices){
          isMax = false;
          break;
        }
      }
      return isMax;
    }
    private void increment(int[] combinations, int index){
      if(combinations[index] != choices){
        combinations[index]++;
      } else {
        combinations[index] = 1;
        if((index - 1) >=  0){
          increment(combinations, index - 1);
        } else {
          System.err.println("should not be in here");
        }
      }
    }

    private void initCombination(int[] combination){
      for(int k=0; k<combination.length;k++){
        combination[k] = 1;
      }
    }

    public String toString(){
      return this.name + " " + this.probability;

    }

  }

  public LotteryType createLotteryType (String name){
    return new LotteryType(name);
  }

  public String[] sortByOdds(String[] rules) {

    List<LotteryType> types = new ArrayList<LotteryType>();

    for(int i =0; i<rules.length; i++){
      types.add(createLotteryType(rules[i]));
    }

    for(int k =0; k<rules.length; k++){
      types.get(k).calculateProbability();
    }

    Collections.sort(types);

//    for(int l=0; l<types.size(); l++){
//      System.out.println(types.get(l));
//    }

    String[] result = new String[rules.length];

    for(int y=0; y<result.length; y++){
      result[y] = types.get(y).name;
    }

    return result;
  }


  public static void main(String[] args) {
		Lottery temp = new Lottery();
//    String[] rules = {"PICK ANY TWO: 10 2 F F"
//                     ,"PICK TWO IN ORDER: 10 2 T F"
//                     ,"PICK TWO DIFFERENT: 10 2 F T"
//                     ,"PICK TWO LIMITED: 10 2 T T"};

        String[] rules = {"PICK ANY TWO: 10 3 F F"
                     ,"PICK TWO IN ORDER: 10 3 T F"
                     ,"PICK TWO DIFFERENT: 10 3 F T"
                     ,"PICK TWO LIMITED: 10 3 T T"};



//    String[] rules = {"INDIGO: 93 8 T F",
//      "ORANGE: 29 8 F T",
//      "VIOLET: 76 6 F F",
//      "BLUE: 100 8 T T",
//      "RED: 99 8 T T",
//      "GREEN: 78 6 F T",
//      "YELLOW: 75 6 F F"};

    String[] result = temp.sortByOdds(rules);
    for(int k=0; k<result.length;k++){
      System.out.println(result[k]);
    }
	}
}
