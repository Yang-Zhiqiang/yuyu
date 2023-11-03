package yuyu.common.hozen.khcommon;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;
import yuyu.common.hozen.renkei.KhGetSyanaiWebHeijyunNenkinInfoTest_getSyouhnInfo;
import yuyu.common.hozen.renkei.KhGetSyanaiWebHeijyunSyuusinInfoTest_getSyouhnInfo;
import yuyu.common.hozen.renkei.KhGetSyanaiWebItijiNenkinInfoTest_getSyouhnInfo;
import yuyu.common.hozen.renkei.KhGetSyanaiWebItijiSyuusinInfoTest_getSyouhnInfo;
import yuyu.common.hozen.renkei.KhGetSyanaiWebKyoutuuInfoTest_exec;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.IT_KykKihon;

/**
 * 契約保全 契約保全共通  解約共通計算クラス
 */
public class KeisanCommonKaiyakuMockForHozen extends KeisanCommonKaiyaku{

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static final String TESTPATTERN3 = "3";

    public static final String TESTPATTERN4 = "4";

    public static final String TESTPATTERN5 = "5";


    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    private KeisanCommonKaiyakuOutBean keisanCommonKaiyakuOutBean = new KeisanCommonKaiyakuOutBean();

    @Override
    public KeisanCommonKaiyakuOutBean getKeisanCommonKaiyakuOutBean () {

        if (caller == EditKykNaiyouOsirase3Test_editInfo.class) {

            if (TESTPATTERN1.equals(SYORIPTN)) {
                keisanCommonKaiyakuOutBean.setShrgkkeiYen(BizCurrency.valueOf(8888, BizCurrencyTypes.YEN));
                keisanCommonKaiyakuOutBean.setZennouseisankYen(BizCurrency.valueOf(4444, BizCurrencyTypes.YEN));
                keisanCommonKaiyakuOutBean.setKaiyakuhrgoukeiYen(BizCurrency.valueOf(33333333, BizCurrencyTypes.YEN));
                keisanCommonKaiyakuOutBean.setKaiyakuhrgoukeigk(BizCurrency.valueOf(222222.00, BizCurrencyTypes.DOLLAR));
            }

            else if (TESTPATTERN2.equals(SYORIPTN)) {
                keisanCommonKaiyakuOutBean.setShrgkkeiYen(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
                keisanCommonKaiyakuOutBean.setZennouseisankYen(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
                keisanCommonKaiyakuOutBean.setKaiyakuhrgoukeiYen(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
                keisanCommonKaiyakuOutBean.setKaiyakuhrgoukeigk(BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR));
            }

            else if (TESTPATTERN3.equals(SYORIPTN)) {
                keisanCommonKaiyakuOutBean.setShrgkkeiYen(BizCurrency.valueOf(8888, BizCurrencyTypes.YEN));
                keisanCommonKaiyakuOutBean.setZennouseisankYen(BizCurrency.valueOf(4444, BizCurrencyTypes.YEN));
                keisanCommonKaiyakuOutBean.setKaiyakuhrgoukeiYen(BizCurrency.valueOf(33333333, BizCurrencyTypes.YEN));
                keisanCommonKaiyakuOutBean.setKaiyakuhrgoukeigk(BizCurrency.valueOf(222222.00, BizCurrencyTypes.DOLLAR));
                keisanCommonKaiyakuOutBean.setZennoumijyuutouFlg(C_UmuKbn.ARI);
            }
            else if (TESTPATTERN4.equals(SYORIPTN)) {
                keisanCommonKaiyakuOutBean.setShrgkkeiYen(BizCurrency.valueOf(8888, BizCurrencyTypes.YEN));
                keisanCommonKaiyakuOutBean.setZennouseisankYen(BizCurrency.valueOf(4444, BizCurrencyTypes.YEN));
                keisanCommonKaiyakuOutBean.setKaiyakuhrgoukeiYen(BizCurrency.valueOf(33333333, BizCurrencyTypes.YEN));
                keisanCommonKaiyakuOutBean.setKaiyakuhrgoukeigk(BizCurrency.valueOf(222222.00, BizCurrencyTypes.DOLLAR));
            }

        }

        if (caller == KhGetSyanaiWebKyoutuuInfoTest_exec.class) {

            if (TESTPATTERN1.equals(SYORIPTN)) {

                keisanCommonKaiyakuOutBean.setKaiyakuHrYen(BizCurrency.valueOf(66666));
                keisanCommonKaiyakuOutBean.setShrgkkeiYen(BizCurrency.valueOf(7777));
                keisanCommonKaiyakuOutBean.setKaiyakuHr(BizCurrency.valueOf(88888.00, BizCurrencyTypes.DOLLAR));
                keisanCommonKaiyakuOutBean.setShrgkkeigk(BizCurrency.valueOf(9999.00, BizCurrencyTypes.DOLLAR));
                keisanCommonKaiyakuOutBean.setPtumitatekin(BizCurrency.valueOf(10000));
                keisanCommonKaiyakuOutBean.setKaiyakusjkkktyouseiriritu(BizNumber.valueOf(0.01));
                keisanCommonKaiyakuOutBean.setZennouseisankYen(BizCurrency.valueOf(10010));
                keisanCommonKaiyakuOutBean.setKaiyakuhrgoukeigk(BizCurrency.valueOf(8888.00, BizCurrencyTypes.DOLLAR));
                keisanCommonKaiyakuOutBean.setKaiyakuhrgoukeiYen(BizCurrency.valueOf(6666));
                keisanCommonKaiyakuOutBean.setKaiyakuKjgk(BizCurrency.valueOf(123.00, BizCurrencyTypes.DOLLAR));
                keisanCommonKaiyakuOutBean.setKaiyakuKjRitu(BizNumber.valueOf(0.023));
            }

            if (TESTPATTERN3.equals(SYORIPTN)) {

                keisanCommonKaiyakuOutBean.setKaiyakuHrYen(BizCurrency.valueOf(666600,BizCurrencyTypes.YEN));
                keisanCommonKaiyakuOutBean.setShrgkkeiYen(BizCurrency.valueOf(7777,BizCurrencyTypes.YEN));
                keisanCommonKaiyakuOutBean.setKaiyakuHr(BizCurrency.valueOf(0));
                keisanCommonKaiyakuOutBean.setShrgkkeigk(BizCurrency.valueOf(0));
                keisanCommonKaiyakuOutBean.setPtumitatekin(BizCurrency.valueOf(0));
                keisanCommonKaiyakuOutBean.setZennouseisankYen(BizCurrency.valueOf(11000,BizCurrencyTypes.YEN));
                keisanCommonKaiyakuOutBean.setZennouseisankGk(BizCurrency.valueOf(0));
                keisanCommonKaiyakuOutBean.setKaiyakuhrgoukeigk(BizCurrency.valueOf(0));
                keisanCommonKaiyakuOutBean.setKaiyakuhrgoukeiYen(BizCurrency.valueOf(148227,BizCurrencyTypes.YEN));
            }
        }

        if (caller == KhGetSyanaiWebItijiSyuusinInfoTest_getSyouhnInfo.class) {

            if (TESTPATTERN1.equals(SYORIPTN)) {

                keisanCommonKaiyakuOutBean.setKaiyakuHrYen(BizCurrency.valueOf(6666));
                keisanCommonKaiyakuOutBean.setShrgkkeiYen(BizCurrency.valueOf(7777));
                keisanCommonKaiyakuOutBean.setKaiyakuHr(BizCurrency.valueOf(8888));
                keisanCommonKaiyakuOutBean.setShrgkkeigk(BizCurrency.valueOf(9999.00, BizCurrencyTypes.DOLLAR));
                keisanCommonKaiyakuOutBean.setPtumitatekin(BizCurrency.valueOf(10000));
                keisanCommonKaiyakuOutBean.setKaiyakusjkkktyouseiriritu(BizNumber.valueOf(0.01));
                keisanCommonKaiyakuOutBean.setZennouseisankYen(BizCurrency.valueOf(10010));
                keisanCommonKaiyakuOutBean.setKaiyakuhrgoukeigk(BizCurrency.valueOf(8888.00, BizCurrencyTypes.DOLLAR));
                keisanCommonKaiyakuOutBean.setKaiyakuhrgoukeiYen(BizCurrency.valueOf(6666));
                keisanCommonKaiyakuOutBean.setKaiyakuKjgk(BizCurrency.valueOf(123.00, BizCurrencyTypes.DOLLAR));
                keisanCommonKaiyakuOutBean.setKaiyakuKjRitu(BizNumber.valueOf(0.023));
            }
        }

        if (caller == KhGetSyanaiWebItijiNenkinInfoTest_getSyouhnInfo.class) {

            if (TESTPATTERN1.equals(SYORIPTN)) {

                keisanCommonKaiyakuOutBean.setKaiyakuHrYen(BizCurrency.valueOf(6666));
                keisanCommonKaiyakuOutBean.setShrgkkeiYen(BizCurrency.valueOf(7777));
                keisanCommonKaiyakuOutBean.setKaiyakuHr(BizCurrency.valueOf(8888.00, BizCurrencyTypes.DOLLAR));
                keisanCommonKaiyakuOutBean.setShrgkkeigk(BizCurrency.valueOf(9999.00, BizCurrencyTypes.DOLLAR));
                keisanCommonKaiyakuOutBean.setPtumitatekin(BizCurrency.valueOf(10000));
                keisanCommonKaiyakuOutBean.setKaiyakusjkkktyouseiriritu(BizNumber.valueOf(0.01));
                keisanCommonKaiyakuOutBean.setZennouseisankYen(BizCurrency.valueOf(10010));
                keisanCommonKaiyakuOutBean.setKaiyakuhrgoukeigk(BizCurrency.valueOf(8888.00, BizCurrencyTypes.DOLLAR));
                keisanCommonKaiyakuOutBean.setKaiyakuhrgoukeiYen(BizCurrency.valueOf(6666));
                keisanCommonKaiyakuOutBean.setKaiyakuKjgk(BizCurrency.valueOf(123.00, BizCurrencyTypes.DOLLAR));
                keisanCommonKaiyakuOutBean.setKaiyakuKjRitu(BizNumber.valueOf(0.023));
            }
        }

        if (caller == KhGetSyanaiWebHeijyunNenkinInfoTest_getSyouhnInfo.class) {

            if (TESTPATTERN1.equals(SYORIPTN)) {

                keisanCommonKaiyakuOutBean.setKaiyakuHrYen(BizCurrency.valueOf(6666));
                keisanCommonKaiyakuOutBean.setShrgkkeiYen(BizCurrency.valueOf(7777));
                keisanCommonKaiyakuOutBean.setKaiyakuHr(BizCurrency.valueOf(8888.00, BizCurrencyTypes.DOLLAR));
                keisanCommonKaiyakuOutBean.setShrgkkeigk(BizCurrency.valueOf(9999.00, BizCurrencyTypes.DOLLAR));
                keisanCommonKaiyakuOutBean.setPtumitatekin(BizCurrency.valueOf(10000));
                keisanCommonKaiyakuOutBean.setKaiyakusjkkktyouseiriritu(BizNumber.valueOf(0.01));
                keisanCommonKaiyakuOutBean.setZennouseisankYen(BizCurrency.valueOf(10010));
                keisanCommonKaiyakuOutBean.setKaiyakuhrgoukeigk(BizCurrency.valueOf(8888.00, BizCurrencyTypes.DOLLAR));
                keisanCommonKaiyakuOutBean.setKaiyakuhrgoukeiYen(BizCurrency.valueOf(6666));
                keisanCommonKaiyakuOutBean.setKaiyakuKjgk(BizCurrency.valueOf(123.00, BizCurrencyTypes.DOLLAR));
                keisanCommonKaiyakuOutBean.setKaiyakuKjRitu(BizNumber.valueOf(0.23));
            }
        }

        if (caller == KhGetSyanaiWebHeijyunSyuusinInfoTest_getSyouhnInfo.class) {

            if (TESTPATTERN1.equals(SYORIPTN)) {

                keisanCommonKaiyakuOutBean.setKaiyakuHrYen(BizCurrency.valueOf(17950150, BizCurrencyTypes.YEN));
                keisanCommonKaiyakuOutBean.setShrgkkeiYen(BizCurrency.valueOf(17950158, BizCurrencyTypes.YEN));
                keisanCommonKaiyakuOutBean.setKaiyakuHr(BizCurrency.valueOf(147040.00, BizCurrencyTypes.DOLLAR));
                keisanCommonKaiyakuOutBean.setShrgkkeigk(BizCurrency.valueOf(147048.07, BizCurrencyTypes.DOLLAR));
                keisanCommonKaiyakuOutBean.setPtumitatekin(BizCurrency.valueOf(0));
                keisanCommonKaiyakuOutBean.setZennouseisankYen(BizCurrency.valueOf(0));
                keisanCommonKaiyakuOutBean.setZennouseisankGk(BizCurrency.valueOf(119579.88,  BizCurrencyTypes.DOLLAR));
                keisanCommonKaiyakuOutBean.setKaiyakuhrgoukeigk(BizCurrency.valueOf(167040.00, BizCurrencyTypes.DOLLAR));
                keisanCommonKaiyakuOutBean.setKaiyakuhrgoukeiYen(BizCurrency.valueOf(27950150, BizCurrencyTypes.YEN));
            }

            if (TESTPATTERN3.equals(SYORIPTN)) {

                keisanCommonKaiyakuOutBean.setKaiyakuHrYen(BizCurrency.valueOf(666600,BizCurrencyTypes.YEN));
                keisanCommonKaiyakuOutBean.setShrgkkeiYen(BizCurrency.valueOf(7777,BizCurrencyTypes.YEN));
                keisanCommonKaiyakuOutBean.setKaiyakuHr(BizCurrency.valueOf(0));
                keisanCommonKaiyakuOutBean.setShrgkkeigk(BizCurrency.valueOf(0));
                keisanCommonKaiyakuOutBean.setPtumitatekin(BizCurrency.valueOf(0));
                keisanCommonKaiyakuOutBean.setZennouseisankYen(BizCurrency.valueOf(11000,BizCurrencyTypes.YEN));
                keisanCommonKaiyakuOutBean.setZennouseisankGk(BizCurrency.valueOf(0));
                keisanCommonKaiyakuOutBean.setKaiyakuhrgoukeigk(BizCurrency.valueOf(0));
                keisanCommonKaiyakuOutBean.setKaiyakuhrgoukeiYen(BizCurrency.valueOf(148227));
            }
        }


        return keisanCommonKaiyakuOutBean;
    }

    @Override
    public C_ErrorKbn keisanKaiyakuseisankin(String pKinouBunrui, IT_KykKihon pKykKihon,
        BizDate pSyoriYmd, KeisanKaiyakuBean pKeisanKaiyakuBean) {

        if (caller == EditKykNaiyouOsirase3Test_editInfo.class) {

            if (TESTPATTERN1.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
            else if (TESTPATTERN4.equals(SYORIPTN)) {
                return C_ErrorKbn.ERROR;
            }
        }
        if (caller == KhGetSyanaiWebKyoutuuInfoTest_exec.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;

            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                return C_ErrorKbn.ERROR;

            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;

            }

        }
        if (caller == KhGetSyanaiWebItijiSyuusinInfoTest_getSyouhnInfo.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;

            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                return C_ErrorKbn.ERROR;

            }

        }
        if (caller == KhGetSyanaiWebItijiNenkinInfoTest_getSyouhnInfo.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;

            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                return C_ErrorKbn.ERROR;

            }

        }
        if (caller == KhGetSyanaiWebHeijyunNenkinInfoTest_getSyouhnInfo.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;

            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                return C_ErrorKbn.ERROR;

            }
        }

        if (caller == KhGetSyanaiWebHeijyunSyuusinInfoTest_getSyouhnInfo.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;

            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                return C_ErrorKbn.ERROR;

            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;

            }
        }

        return super.keisanKaiyakuseisankin(pKinouBunrui, pKykKihon, pSyoriYmd, pKeisanKaiyakuBean);
    }

}
