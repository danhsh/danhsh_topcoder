package visitorDesignPattern;

/**
 * Created with IntelliJ IDEA.
 * User: daniel_hsh
 * Date: 9/01/13
 * Time: 4:21 PM
 * To change this template use File | Settings | File Templates.
 */
public class Dog extends Animal {
  public void letsDo(Operation operation){
    operation.hereIsADog(this);
  }
}
