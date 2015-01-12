package lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by norman on 09.01.2015.
 * @see http://www.oracle.com/webfolder/technetwork/tutorials/obe/java/Lambda-QuickStart/index.html
 * @see http://www.javacodegeeks.com/2014/05/java-8-features-tutorial.html
 * @see http://examples.javacodegeeks.com/java-basics/lambdas/java-8-lambda-expressions-tutorial/
 *
 */
public class ListExamples {
    public static final void main(String args[]) {
        List<String> list = new ArrayList<>();
        list.add("First");
        list.add("Second");
        list.add("Last");
        list.sort(ListExamples::mycompare);
        System.out.println(list);

        list.forEach(c -> {
            if (c.equals("First")) {
                System.out.println(c);
            }
        });

        Stream<String> stream = list.stream().filter(f -> f.equals("Second"));
    }

    public static int mycompare(String a, String c) {
        return a.compareTo(c);
    }
}
