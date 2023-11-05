package yuyu.common.biz.bznayose;

/**
 * {@link BzSaibanNayose}のモッククラスです。<br />
 */
public class BzSaibanNayoseMockForSinkeiyaku extends BzSaibanNayose{
    public static Class<?> caller = null;
    public static String SYORIPTN = null;
    public static final String TESTPATTERN1 = "1";

    @Override
    public String exec() {
        String youkyuuNo = "";
        if (caller == BzYoukyuuNoKanriTest_exec.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                youkyuuNo = "000000000000000010";
            }
        }
        return super.exec();
    }
}

