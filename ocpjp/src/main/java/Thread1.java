/**
 * Created by IntelliJ IDEA.
 * User: norman
 * Date: 06.03.12
 * Time: 18:27
 * To change this template use File | Settings | File Templates.
 */
public class Thread1 {
    void waitForSignal() {
        Object obj = new Object();
        synchronized (Thread.currentThread()) {
            // throws exception which must be handled
            // obj.wait();
            obj.notify();
        }
    }
}
