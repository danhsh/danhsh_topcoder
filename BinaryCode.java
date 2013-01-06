public class BinaryCode {
	public String[] decode(String message) {

    String stringWithZero = solveWith(0, message);
    String stringWithOne = solveWith(1, message);
    String[] result = {stringWithZero, stringWithOne};
    return result;
	}

  private String solveWith(int assumption, String message){
    String p = "";
    p += assumption;
    for(int i=0; i< message.length() -1;i++){
      //Assume P[0] = 0.
      //Because Q[0] = P[0] + P[1] = 0 + P[1] = 1, we know that P[1] = 1.
      if(i==0){
        int pInti = Integer.parseInt("" + p.charAt(i));
        int qInti = Integer.parseInt("" + message.charAt(i));
        int pInt1 = qInti - pInti;
        p += (pInt1);
      } else {
        //Because Q[1] = P[0] + P[1] + P[2] = 0 + 1 + P[2] = 2, we know that P[2] = 1.
        //Because Q[2] = P[1] + P[2] + P[3] = 1 + 1 + P[3] = 3, we know that P[3] = 1.
        int pInt0 = Integer.parseInt("" + p.charAt(i - 1));
        int pInti = Integer.parseInt("" + p.charAt(i));
        int qInti = Integer.parseInt("" + message.charAt(i));
        int pInt2 = qInti - pInt0 - pInti;
        p += (pInt2);
      }
      if(p.charAt(p.length()-1)!= '1' && p.charAt(p.length()-1)!= '0'){
        p = "NONE";
        break;
      }
    }
    return p;
  }


	public static void main(String[] args) {
		BinaryCode temp = new BinaryCode();
    String message = "12221112222221112221111111112221111";

    String[] result = temp.decode(message);
		System.out.println(result[0] + " " + result[1]);
	}
}
