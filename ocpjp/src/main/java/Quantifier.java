import java.util.regex.*;

public class Quantifier {
  public static void main(String[] args) {
    String source = "yyxxxyxx";
    Pattern greedy = Pattern.compile(".*xx");
    Pattern reluctant = Pattern.compile(".*?xx");
    Pattern possessive = Pattern.compile(".*+xx");
    
    Matcher matcher = greedy.matcher(source);
    match(matcher);
    matcher = reluctant.matcher(source);
    match(matcher);
    matcher = possessive.matcher(source);
    match(matcher);
  }
  
  private static void match(Matcher matcher) {
    while(matcher.find()) {
      System.out.println(matcher.start() + ": " + matcher.group());
    }
  }
}