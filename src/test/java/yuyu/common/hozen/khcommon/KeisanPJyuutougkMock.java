package yuyu.common.hozen.khcommon;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.app.bosyuu.hbsekmos.hbseihowebsekmos.HbSeihoWebSekMosTest_execPostForm2;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_HrkkknsmnKbn;

/**
 * {@link KeisanPJyuutougk}のモッククラスです。<br />
 */
public class KeisanPJyuutougkMock extends KeisanPJyuutougk {
    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static final String TESTPATTERN3 = "3";

    public static final String TESTPATTERN4 = "4";

    public static final String TESTPATTERN5 = "5";

    public static final String TESTPATTERN6 = "6";

    public static final String TESTPATTERN7 = "7";

    private BizCurrency pJyuutougk;

    private BizNumber yoteiSinkeiyakuhiRitu;

    private BizNumber yoteiIjihiRitu;

    private BizNumber yoteiSyuukinhiRitu;

    private BizNumber kougakuWaribikiRitu;

    @Override
    public BizCurrency getPJyuutougk() {
        return pJyuutougk;
    }

    @Override
    public C_ErrorKbn exec(BizCurrency pPkyktuuka,
        BizCurrency pPYen,
        int pHhknnen,
        int pHrkkkn,
        C_HrkkknsmnKbn pHrkkknsmnkbn,
        BizDate pKykymd,
        BizDateYM pCalckijyunym) {

        if (caller == HbSeihoWebSekMosTest_execPostForm2.class) {

            if (TESTPATTERN5.equals(SYORIPTN)) {

                return C_ErrorKbn.ERROR;
            }

            return C_ErrorKbn.OK;
        }
        
        else if (caller == KeisanVHeijyunTangetuTest_exec.class && TESTPATTERN2.equals(SYORIPTN)) {
            return C_ErrorKbn.ERROR;
        }


        return super.exec(pPkyktuuka, pPYen, pHhknnen, pHrkkkn, pHrkkknsmnkbn, pKykymd, pCalckijyunym);
    }

    @Override
    public BizNumber getYoteiIjihiRitu() {
        if (caller == HbSeihoWebSekMosTest_execPostForm2.class) {

            if (TESTPATTERN5.equals(SYORIPTN)) {

                return BizNumber.valueOf(0);
            }

            return BizNumber.valueOf(1);
        }
        return yoteiIjihiRitu;
    }

    @Override
    public BizNumber getYoteiSyuukinhiRitu() {

        return yoteiSyuukinhiRitu;
    }

    @Override
    public BizNumber getYoteiSinkeiyakuhiRitu() {

        if (caller == HbSeihoWebSekMosTest_execPostForm2.class) {

            return BizNumber.valueOf(1);
        }

        return yoteiSinkeiyakuhiRitu;
    }

    @Override
    public BizNumber getKougakuWaribikiRitu() {

        return kougakuWaribikiRitu;
    }

}
