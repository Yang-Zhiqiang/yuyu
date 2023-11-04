package yuyu.common.hozen.khcommon;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_HrkkknsmnKbn;

/**
 * {@link KeisanVHeijyunTangetu}のモッククラスです<br />
 */
public class KeisanVHeijyunTangetuMock extends KeisanVHeijyunTangetu{

    private BizDateYM tumitateYM;

    private BizCurrency tmttKngk;

    private BizCurrency vTyouseimae;

    private BizCurrency kiharaikomiPSoutougk;

    private BizNumber yoteiSinkeiyakuhiritu;

    private BizNumber yoteiIjihirituPhirei;

    private BizNumber yoteiIjihirituVhirei;

    private BizNumber yoteiSyuukinhiritu;

    private BizNumber kougakuWaribikiritu;

    @Override
    public BizDateYM getTumitateYM() {
        return tumitateYM;
    }

    @Override
    public BizCurrency getV() {
        return tmttKngk;
    }

    @Override
    public BizCurrency getVTyouseimae() {
        return vTyouseimae;
    }

    @Override
    public BizCurrency getKiharaikomiPSoutougk() {
        return kiharaikomiPSoutougk;
    }

    @Override
    public BizNumber getYoteiSinkeiyakuhiritu() {
        return yoteiSinkeiyakuhiritu;
    }

    @Override
    public BizNumber getYoteiIjihirituPhirei() {
        return yoteiIjihirituPhirei;
    }

    @Override
    public BizNumber getYoteiIjihirituVhirei() {
        return yoteiIjihirituVhirei;
    }

    @Override
    public BizNumber getYoteiSyuukinhiritu() {
        return yoteiSyuukinhiritu;
    }

    @Override
    public BizNumber getKougakuWaribikiritu() {
        return kougakuWaribikiritu;
    }

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    @Override
    public C_ErrorKbn exec(
        BizDateYM pCalckijyunym,
        BizDate pKykymd,
        BizCurrency pPYen,
        BizCurrency pPkyktuuka,
        Integer pHhknnen,
        Integer pHrkkkn,
        C_HrkkknsmnKbn pHrkkknsmnkbn,
        BizNumber pYoteiriritu,
        BizNumber pZeitaisibouritu,
        BizNumber pSoudaisibouritu,
        BizNumber pSoudaikaiyakuritu,
        BizCurrency pCalcKaisiymjitenPtumitatekin,
        BizCurrency pCalcKaisiymjitenKihrkPsoutougk){

        if (caller == KeisanVHeijyunTest_exec.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                tumitateYM = BizDateYM.valueOf(201905);
                tmttKngk = BizCurrency.valueOf(11111);
                vTyouseimae = BizCurrency.valueOf(22222);
                kiharaikomiPSoutougk = BizCurrency.valueOf(33333);
                yoteiSinkeiyakuhiritu = BizNumber.valueOf(4.4444);
                yoteiIjihirituPhirei = BizNumber.valueOf(5.5555);
                yoteiIjihirituVhirei = BizNumber.valueOf(6.6666);
                yoteiSyuukinhiritu = BizNumber.valueOf(7.7777);
                kougakuWaribikiritu = BizNumber.valueOf(8.8888);
                return C_ErrorKbn.OK;
            } else if (TESTPATTERN2.equals(SYORIPTN)) {
                return C_ErrorKbn.ERROR;
            }
        }

        return super.exec(pCalckijyunym,
            pKykymd,
            pPYen,
            pPkyktuuka,
            pHhknnen,
            pHrkkkn,
            pHrkkknsmnkbn,
            pYoteiriritu,
            pZeitaisibouritu,
            pSoudaisibouritu,
            pSoudaikaiyakuritu,
            pCalcKaisiymjitenPtumitatekin,
            pCalcKaisiymjitenKihrkPsoutougk);
    }
}
