package dynamic;

/**
 * @author jianw.li
 * @date 2019/9/5 7:08 PM
 * @Description: TODO
 */
public class B extends A {

    @Override
    protected BBean test() {
        BBean bBean = new BBean();
        bBean.setTest1("test1");
        bBean.setTest2("test2");
        return bBean;
    }
}
