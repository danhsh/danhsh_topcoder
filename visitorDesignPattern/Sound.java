package visitorDesignPattern;

/**
 * Created with IntelliJ IDEA.
 * User: daniel_hsh
 * Date: 9/01/13
 * Time: 4:26 PM
 * To change this template use File | Settings | File Templates.
 */
public class Sound implements Operation{

  public void hereIsADog(Dog dog){
    System.out.println("Woof!");
  }
  public void hereIsACat(Cat cat){
    System.out.println("Meow!");
  }

  public static void main(String[] args)
  {
    Testing testing = new Testing().invoke();
    Cat cat = testing.getCat();
    Sound sound = testing.getSound();
    doSomething(testing);
  }

  private static void doSomething(Testing testing) {
    testing.getCat().letsDo(testing.getSound());
  }

  private static class Testing {
    private Cat cat;
    private Sound sound;

    public Cat getCat() {
      return cat;
    }

    public Sound getSound() {
      return sound;
    }

    public Testing invoke() {
      cat = new Cat();
      sound = new Sound();
      return this;
    }
  }
}
