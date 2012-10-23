import java.util.*;
public class G1 {
  public void takeList(List<? extends String> list) {
    // does not compile
    // list.add("foo");
  }
}