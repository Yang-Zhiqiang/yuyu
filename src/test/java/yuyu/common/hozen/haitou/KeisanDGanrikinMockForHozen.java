package yuyu.common.hozen.haitou;

import java.util.ArrayList;
import java.util.List;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.common.hozen.haitou.SetDNnd.DRateBean;
import yuyu.def.classification.C_ErrorKbn;

/**
 * {@link KeisanDGanrikin}のモッククラスです。<br />
 */
public class KeisanDGanrikinMockForHozen extends KeisanDGanrikin {

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static final String TESTPATTERN3 = "3";

    public static final String TESTPATTERN4 = "4";

    public static final String TESTPATTERN5 = "5";

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    @Override
    public C_ErrorKbn exec(BizCurrency pRuigk, BizDate pCalckijyunfromymd, BizDate pCalckijyuntoymd) {

        if (KeisanDCommonTest_calcKariwariateDGanrikin.class == caller) {

            if (TESTPATTERN1.equals(SYORIPTN)) {
                return C_ErrorKbn.ERROR;
            }
            if (TESTPATTERN2.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
            if (TESTPATTERN3.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
            if (TESTPATTERN4.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
            if (TESTPATTERN5.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
        }

        if (KeisanDCommonTest_calcTumitateDGanrikin.class == caller) {

            if (TESTPATTERN1.equals(SYORIPTN)) {
                return C_ErrorKbn.ERROR;
            }
            if (TESTPATTERN2.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
            if (TESTPATTERN3.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
            if (TESTPATTERN4.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
            if (TESTPATTERN5.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
        }

        if (KeisanDCommonDShrTest_calcDShrgkAllhikidasi.class == caller) {

            return C_ErrorKbn.OK;
        }

        if (KeisanDCommonDShrTest_calcDShrgkItibuhikidasi.class == caller) {

            return C_ErrorKbn.OK;
        }

        if (KeisanDCommonGengakuTest_calcDShrgk.class == caller) {

            return C_ErrorKbn.OK;
        }

        if (KeisanDCommonKaiyakuTest_calcDShrgk.class == caller) {

            if (TESTPATTERN1.equals(SYORIPTN)) {
                return C_ErrorKbn.ERROR;
            }
            if (TESTPATTERN2.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
            if (TESTPATTERN3.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
            if (TESTPATTERN4.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
            if (TESTPATTERN5.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
        }

        if (KeisanDCommonSibouTest_calcDShrgk.class == caller) {

            if (TESTPATTERN1.equals(SYORIPTN)) {
                return C_ErrorKbn.ERROR;
            }
            if (TESTPATTERN2.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
            if (TESTPATTERN3.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
            if (TESTPATTERN4.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
            if (TESTPATTERN5.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
        }

        if (KeisanDCommonYendtHnk_calcDkngk.class == caller) {

            return C_ErrorKbn.OK;
        }

        return super.exec(pRuigk, pCalckijyunfromymd, pCalckijyuntoymd);
    }

    @Override
    public BizCurrency getDGanrikin() {

        if (KeisanDCommonDShrTest_calcDShrgkAllhikidasi.class == caller) {

            return BizCurrency.valueOf(130);
        }

        if (KeisanDCommonDShrTest_calcDShrgkItibuhikidasi.class == caller) {

            return BizCurrency.valueOf(50);
        }

        if (KeisanDCommonGengakuTest_calcDShrgk.class == caller) {

            if (TESTPATTERN1.equals(SYORIPTN)) {
                return BizCurrency.valueOf(10);
            }
            if (TESTPATTERN2.equals(SYORIPTN)) {
                return BizCurrency.valueOf(0);
            }
            if (TESTPATTERN3.equals(SYORIPTN)) {
                return BizCurrency.valueOf(-20);
            }
            if (TESTPATTERN4.equals(SYORIPTN)) {
                return BizCurrency.valueOf(12);
            }
        }

        if (KeisanDCommonKaiyakuTest_calcDShrgk.class == caller) {

            if (TESTPATTERN2.equals(SYORIPTN)) {
                return BizCurrency.valueOf(13);
            }
            if (TESTPATTERN3.equals(SYORIPTN)) {
                return BizCurrency.valueOf(-1);
            }
            if (TESTPATTERN4.equals(SYORIPTN)) {
                return BizCurrency.valueOf(0);
            }
            if (TESTPATTERN5.equals(SYORIPTN)) {
                return BizCurrency.valueOf(1);
            }
        }

        if (KeisanDCommonSibouTest_calcDShrgk.class == caller) {

            if (TESTPATTERN2.equals(SYORIPTN)) {
                return BizCurrency.valueOf(13);
            }
            if (TESTPATTERN3.equals(SYORIPTN)) {
                return BizCurrency.valueOf(-1);
            }
            if (TESTPATTERN4.equals(SYORIPTN)) {
                return BizCurrency.valueOf(0);
            }
            if (TESTPATTERN5.equals(SYORIPTN)) {
                return BizCurrency.valueOf(1);
            }
        }

        if (KeisanDCommonYendtHnk_calcDkngk.class == caller) {

            return BizCurrency.valueOf(12);
        }

        return super.getDGanrikin();
    }

    @Override
    public List<BizNumber> getHaitouRirituList() {

        List<BizNumber> haitouRirituListLst = new ArrayList<BizNumber>();

        if (KeisanDCommonDShrTest_calcDShrgkAllhikidasi.class == caller) {

            haitouRirituListLst.add(BizNumber.valueOf(2));

            return haitouRirituListLst;
        }

        if (KeisanDCommonDShrTest_calcDShrgkItibuhikidasi.class == caller) {

            haitouRirituListLst.add(BizNumber.valueOf(2));

            return haitouRirituListLst;
        }

        if (KeisanDCommonGengakuTest_calcDShrgk.class == caller) {

            haitouRirituListLst.add(BizNumber.valueOf(1));

            return haitouRirituListLst;
        }

        return super.getHaitouRirituList();
    }

    @Override
    public C_ErrorKbn execAllowOverAYear(BizCurrency pRuiKeik, List<DRateBean> pDRateBeanList) {

        if (KeisanDCommonTest_calcKariwariateDGanrikin.class == caller) {

            if (TESTPATTERN1.equals(SYORIPTN)) {
                return C_ErrorKbn.ERROR;
            }
            if (TESTPATTERN2.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
            if (TESTPATTERN3.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
            if (TESTPATTERN4.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
            if (TESTPATTERN5.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
        }

        if (KeisanDCommonTest_calcTumitateDGanrikin.class == caller) {

            if (TESTPATTERN1.equals(SYORIPTN)) {
                return C_ErrorKbn.ERROR;
            }
            if (TESTPATTERN2.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
            if (TESTPATTERN3.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
            if (TESTPATTERN4.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
            if (TESTPATTERN5.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
        }

        if (KeisanDCommonDShrTest_calcDShrgkAllhikidasi.class == caller) {

            return C_ErrorKbn.OK;
        }

        if (KeisanDCommonDShrTest_calcDShrgkItibuhikidasi.class == caller) {

            return C_ErrorKbn.OK;
        }

        if (KeisanDCommonGengakuTest_calcDShrgk.class == caller) {

            return C_ErrorKbn.OK;
        }

        if (KeisanDCommonKaiyakuTest_calcDShrgk.class == caller) {

            if (TESTPATTERN1.equals(SYORIPTN)) {
                return C_ErrorKbn.ERROR;
            }
            if (TESTPATTERN2.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
            if (TESTPATTERN3.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
            if (TESTPATTERN4.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
            if (TESTPATTERN5.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
        }

        if (KeisanDCommonSibouTest_calcDShrgk.class == caller) {

            if (TESTPATTERN1.equals(SYORIPTN)) {
                return C_ErrorKbn.ERROR;
            }
            if (TESTPATTERN2.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
            if (TESTPATTERN3.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
            if (TESTPATTERN4.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
            if (TESTPATTERN5.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
        }

        return super.execAllowOverAYear(pRuiKeik, pDRateBeanList);
    }

}
