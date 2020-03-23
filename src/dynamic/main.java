package dynamic;

/**
 * @author jianw.li
 * @date 2019/9/18 3:44 PM
 * @Description: TODO
 */
public class main extends Thread {

    public static void main(String[] args) {
        A a = new B();
        if (a instanceof C){
            System.out.println("1");
        }
    }
}
