package yuyu.common.biz.bzcommon;

/**
 * {@link ConvertYuutyoSitencd}のモッククラスです。<br />
 */
public class ConvertYuutyoSitencdMock extends ConvertYuutyoSitencd {

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static final String TESTPATTERN3 = "3";

    public static final String TESTPATTERN4 = "4";

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    @Override
    public String exec(String pSitencd)  {

        if (caller == BzGetBankDataTest_exec.class ) {

            if (TESTPATTERN1.equals(SYORIPTN)) {
                return "458";
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                return "108";
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {
                return "118";
            }
            else if (TESTPATTERN4.equals(SYORIPTN)) {
                return "138";
            }
            else{
                return super.exec(pSitencd);
            }
        }
        return super.exec(pSitencd);
    }
}
