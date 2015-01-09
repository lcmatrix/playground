package lambda;

import java.awt.*;
import java.util.ArrayList;
import java.util.stream.Stream;

/**
 * Created by norman on 06.01.2015.
 * @see http://www.oracle.com/webfolder/technetwork/tutorials/obe/java/Lambda-QuickStart/index.html
 * @see http://www.javacodegeeks.com/2014/05/java-8-features-tutorial.html
 * @see http://examples.javacodegeeks.com/java-basics/lambdas/java-8-lambda-expressions-tutorial/
 *
 */
public class Lambda {
    public static final void main(String args[]) {

        Button button = new Button();

        button.addActionListener(ae -> {
                    System.out.println(ae.getSource());
                }
        );
        java.util.List<String> list = new ArrayList<>();
        list.add("Hallo");
        list.add("Norman");
        list.add("Luise");
        list.sort(Lambda::test);
        System.out.println(list);

        list.forEach(c -> {
            if (c.equals("Norman")) {
                System.out.println(c);
            }
        });

        Lambda l = new Lambda();
        list.sort(l::test2);

        Stream<String> stream = list.stream().filter(f -> f.equals("Norman"));

        InterfaceOne i = (y,z) -> {
            return y + z;
        };

        Thread t = new Thread(() -> {
           for(int x = 0; x < 3; x++) {
               System.out.println(Thread.currentThread().getName() + ": " + x);
           }
        });
        t.start();

        System.out.println(i.add(5, 6));
    }

    public static int test(String a, String c) {
        return a.compareTo(c);
    }

    public int test2(String s, String t) {
        return s.compareTo(t);
    }
}

@FunctionalInterface
interface InterfaceOne {
    int add(int a, int b);
}