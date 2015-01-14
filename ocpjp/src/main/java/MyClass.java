import javax.swing.*;

/**
 * Created by norman on 14.04.14.
 */
public class MyClass extends JOptionPane {

    public static void main(String[] args) {
        MyClass c = new MyClass();
        int erg = MyClass.showConfirmDialog(null,"das is ein Test", "Test", YES_NO_OPTION, INFORMATION_MESSAGE);
        System.out.println(erg);
    }
}
