import javax.swing.*;

public class StaticApp {

    public static void main(String[] args) {
        // verwenden der statischen Konstante MyPI
        System.out.printf("MyPI = %.2f\n", MyMath.MyPI);
        // verwenden der nicht statischen Konstante MyPI_ns
        MyMath myM = new MyMath();
        System.out.printf("MyPI_ns = %.2f\n", myM.MyPI_ns);
    }

}
