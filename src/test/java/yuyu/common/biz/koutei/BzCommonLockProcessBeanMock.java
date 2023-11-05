package yuyu.common.biz.koutei;

/**
 * {@link BzCommonLockProcessBeanMock}のモッククラスです。<br />
 */
public class BzCommonLockProcessBeanMock extends BzCommonLockProcessBean{

    private static final long serialVersionUID = 1L;

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    @Override
    public String getKouteiLockKey() {
        if(caller == BzCommonLockProcessTest_getKouteiLockKey.class&& TESTPATTERN1.equals(SYORIPTN)) {
            return "123";
        }
        return super.getKouteiLockKey();
    }

}
