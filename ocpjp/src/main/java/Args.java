/**
 * Created by IntelliJ IDEA.
 * User: norman
 * Date: 07.03.12
 * Time: 19:12
 * To change this template use File | Settings | File Templates.
 */
public class Args {
    
    public static void main (String[] args) {
        try {
            args = null;
            args[0] = "test";
            System.out.print(args[0]);
        } catch(Exception e) {
            System.out.print(e);
        // this block is never reached / NPE has been caught
        /*} catch (NullPointerException e) {
            System.out.print(e);*/
        }
    }
}
