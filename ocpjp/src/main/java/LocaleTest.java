import java.util.Locale;

public class LocaleTest {
  public static void main(String[] args) {
    Locale de = new Locale("de", "DE");
    Locale en = new Locale("en", "GB");
    System.out.println("def " + de.getDisplayCountry());
    System.out.println("loc " + de.getDisplayCountry(de));
    System.out.println("def " + de.getDisplayLanguage());
    System.out.println("loc " + de.getDisplayLanguage(de));
    System.out.println("def " + en.getDisplayCountry());
    System.out.println("loc " + en.getDisplayCountry(en));
    System.out.println("def " + en.getDisplayLanguage());
    System.out.println("loc " + en.getDisplayLanguage(en));
    System.out.println("loc " + en.getDisplayCountry(de));
    System.out.println("loc " + en.getDisplayLanguage(de));
  }
}