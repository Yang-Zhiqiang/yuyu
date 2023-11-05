package yuyu.common.biz.koutei;

/**
 * {@link SetKouteiKanriId}のモッククラスです。<br />
 */
public class SetKouteiKanriIdMock extends SetKouteiKanriId {

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    @Override
    public String exec(SetKouteiKanriIdInBean pSetKouteiKanriIdInBean) {
        if (caller == BzProcessCreateTest_exec.class && TESTPATTERN1.equals(SYORIPTN)) {
            super.exec(pSetKouteiKanriIdInBean);
            return "10011";
        }
        if (caller == BzProcessCreateTest_exec.class && TESTPATTERN2.equals(SYORIPTN)) {
            return "10011";
        }
        return super.exec(pSetKouteiKanriIdInBean);
    }

}