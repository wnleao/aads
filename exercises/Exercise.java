package exercises;

public abstract class Exercise implements Runnable {

  private String[] args;

  public Exercise(String[] args) {
    this.args = args;
  }

  public abstract void compute(String[] args);

  public void run() {
    System.out.println(getClass());
    compute(args);
  }

}