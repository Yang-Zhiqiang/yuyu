package yuyu.common.hozen.khcommon;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;

/**
 * {@link SetYuuyokknmanryobi}のモッククラスです。<br />
 */
public class SetYuuyokknmanryobiMock extends SetYuuyokknmanryobi {

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    @Override
    public BizDate getYuuyokknMnrybi() {
        //        if (caller == EditHurikomiIraiTuutiTblTest_exec.class) {
        //            return BizDate.valueOf("20150731");
        //        }
        if (caller == CheckYuuyokkngaiTest_exec.class) {
            return BizDate.valueOf("20140731");
        }
        else if ((caller == CommonNyuukinTest_exec.class ||
            caller == CommonNyuukinTest_exec1.class ||
            caller == CommonNyuukinTest_exec3.class ||
            caller == CommonNyuukinTest_exec4.class ||
            caller == CommonNyuukinTest_exec5.class ||
            caller == CommonNyuukinTest_exec6.class ||
            caller == CommonNyuukinTest_exec7.class ||
            caller == CommonNyuukinTest_exec8.class) &&
            TESTPATTERN1.equals(SYORIPTN)) {

            return BizDate.valueOf("20171231");
        }
        //        if (caller == CommonFstPNyuukinTest_exec.class) {
        //            return BizDate.valueOf("20151021");
        //        }
        return super.getYuuyokknMnrybi();
    }

    @Override
    public BizDate getTksnYuuyokknMnrybi() {
        //        if (caller == CommonFstPNyuukinTest_exec.class && TESTPATTERN1.equals(SYORIPTN)) {
        //            return BizDate.valueOf("20151010");
        //        }
        //        if (caller == CommonFstPNyuukinTest_exec.class && TESTPATTERN2.equals(SYORIPTN)) {
        //            return BizDate.valueOf("20151011");
        //        }
        if (caller == CheckYuuyokkngaiTest_exec.class && TESTPATTERN1.equals(SYORIPTN)) {
            return BizDate.valueOf("20161010");
        }
        else if ((caller == CommonNyuukinTest_exec.class ||
            caller == CommonNyuukinTest_exec1.class ||
            caller == CommonNyuukinTest_exec3.class ||
            caller == CommonNyuukinTest_exec4.class ||
            caller == CommonNyuukinTest_exec5.class ||
            caller == CommonNyuukinTest_exec6.class ||
            caller == CommonNyuukinTest_exec7.class ||
            caller == CommonNyuukinTest_exec8.class) &&
            TESTPATTERN1.equals(SYORIPTN)) {

            return BizDate.valueOf("20171231");
        }
        //        if (caller == SiCommonChkTest_chkFstPYuuyoKikan.class && TESTPATTERN1.equals(SYORIPTN)) {
        //            return BizDate.valueOf("20151010");
        //        }
        //        if (caller == SiCommonChkTest_chkPYuuyoKikanChoka.class && TESTPATTERN1.equals(SYORIPTN)) {
        //            return BizDate.valueOf("20151010");
        //        }
        //        if (caller == SiCommonChkTest_chkShrbiYuuyoKikan.class && TESTPATTERN1.equals(SYORIPTN)) {
        //            return BizDate.valueOf("20151010");
        //        }
        //        if (caller == SiCommonChkTest_chkYuuyoKikan.class && TESTPATTERN1.equals(SYORIPTN)) {
        //            return BizDate.valueOf("20151216");
        //        }

        return super.getTksnYuuyokknMnrybi();
    }

    @Override
    public void exec(String pSyono, BizDateYM pJyutouYM) {
        //        if (caller == EditHurikomiIraiTuutiTblTest_exec.class) {
        //            return ;
        //        }

        //        if (caller == CommonFstPNyuukinTest_exec.class) {
        //            return ;
        //        }

        if (caller == CheckYuuyokkngaiTest_exec.class) {
            return ;
        }
        else if ((caller == CommonNyuukinTest_exec.class ||
            caller == CommonNyuukinTest_exec1.class ||
            caller == CommonNyuukinTest_exec3.class ||
            caller == CommonNyuukinTest_exec4.class ||
            caller == CommonNyuukinTest_exec5.class ||
            caller == CommonNyuukinTest_exec6.class ||
            caller == CommonNyuukinTest_exec7.class ||
            caller == CommonNyuukinTest_exec8.class) &&
            TESTPATTERN1.equals(SYORIPTN)) {

            return;
        }
        //        if (caller == SiCommonChkTest_chkYuuyoKikan.class) {
        //            return ;
        //        }
        super.exec(pSyono, pJyutouYM);
    }
}