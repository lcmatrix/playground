package lambda;

/**
 * Created by norman on 09.01.2015.
 * @see http://www.oracle.com/webfolder/technetwork/tutorials/obe/java/Lambda-QuickStart/index.html
 * @see http://www.javacodegeeks.com/2014/05/java-8-features-tutorial.html
 * @see http://examples.javacodegeeks.com/java-basics/lambdas/java-8-lambda-expressions-tutorial/
 */
public class FunctionalInterfacesExamples {
    public static final void main(String args[]) {
        MyInterface i = (y,z) -> {
            return y + z;
        };
        System.out.println(i.add(5, 6));

        Thread t = new Thread(() -> {
            for(int x = 0; x < 3; x++) {
                System.out.println(Thread.currentThread().getName() + ": " + x);
            }
        });
        t.start();
    }
}
interface MyInterface {
    int add(int a, int b);
}
