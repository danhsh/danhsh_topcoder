import java.util.*;
public class PowerOutage {
  public int estimateTimeOut(int[] fromJunction, int[] toJunction, int[] ductLength) {

    int [] table = new int [50];
    table[0] = 0;
    int doubleDuct = 0;
    for(int x=0; x<ductLength.length;x++){
      doubleDuct += ductLength[x];

    }
    doubleDuct  *= 2;

    int maxFromZero = 0;

    for(int i = 1; i < 50; i++){
      for (int k=0; k< toJunction.length; k++){
        if(toJunction[k] == i){
          table[i] = table[fromJunction[k]] + ductLength[k];
        }
      }
      if(table[i]>maxFromZero){
        maxFromZero = table[i];

      }
    }

    return doubleDuct  - maxFromZero;

  }


  public static void main(String[] args) {
    PowerOutage temp = new PowerOutage();

//    int[][] rules = 	{{0,1,0},
//                       {1,2,3},
//                       {10,10,10}};
//
    int[][] rules =  {{0,0,0,1,4},
      {1,3,4,2,5},
      {10,10,100,10,5}};

    int result = temp.estimateTimeOut(rules[0],rules[1],rules[2]);

    System.out.println(result);

  }
}
