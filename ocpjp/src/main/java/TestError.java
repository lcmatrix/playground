/**
 * Created by IntelliJ IDEA.
 * User: norman
 * Date: 06.03.12
 * Time: 22:08
 * To change this template use File | Settings | File Templates.
 */
public class TestError {
    public static void main(String[] args) {
        try {
            test();
        } catch (Exception ex) {
           System.out.print("Exception");
        }
        System.out.print("end ");
    }
    
    static void test() throws Error {
        if(true) throw new AssertionError();
        System.out.print("test ");
    }
}
