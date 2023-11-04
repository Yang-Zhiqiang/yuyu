package yuyu.common.hozen.khcommon;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;
import yuyu.app.bosyuu.hbsekmos.hbseihowebnenkinkaiyakuhrsuii.HbSeihoWebNenkinKaiyakuhrSuiiTest_execPostForm;
import yuyu.common.bosyuu.hbkeiyakusyoukai.HbKeiyakuSyoukaiTest_exec;
import yuyu.common.siharai.sicommon.CalcHkKngkHijynbrKojinNkTest_exec;
import yuyu.common.siharai.sicommon.CalcHkShrKngkItijibrKojinNkTest_exec;
import yuyu.common.siharai.sicommon.CalcHkShrKngkItijibrSysnTest_exec;
import yuyu.common.siharai.sicommon.GetSibouymdWTest_exec;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_FiSiyouKbn;

/**
 * {@link KeisanW}のモッククラスです。<br />
 */
public class KeisanWMock extends KeisanW {

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static final String TESTPATTERN3 = "3";

    public static final String TESTPATTERN4 = "4";

    public static final String TESTPATTERN5 = "5";

    public static final String TESTPATTERN6 = "6";

    public static final String TESTPATTERN7 = "7";

    private String flag = "0";

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    @Override
    public C_ErrorKbn exec(BizDate pCalcKijyunYmd, BizDateYM pKijyunYm, KeisanWExtBean pKeisanWExtBean) {

        if (caller == HbKeiyakuSyoukaiTest_exec.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {

                return C_ErrorKbn.OK;
            }

            if (TESTPATTERN2.equals(SYORIPTN)) {

                return C_ErrorKbn.ERROR;
            }
        }
        else if (caller == KeisanYendtHnkSTest_exec.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return C_ErrorKbn.ERROR;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
            else if (TESTPATTERN4.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
            else if (TESTPATTERN5.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
        }
        else if (caller == WSuiihyouNenkinTest_exec.class) {

            if (TESTPATTERN1.equals(SYORIPTN)) {

                return C_ErrorKbn.OK;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {

                if (BizNumber.valueOf(0.5).equals(pKeisanWExtBean.getKaiyakusjkkktyouseiriritu())) {

                    return C_ErrorKbn.ERROR;
                } else if (BizNumber.valueOf(1.5).equals(pKeisanWExtBean.getKaiyakusjkkktyouseiriritu())) {

                    return C_ErrorKbn.ERROR;
                } else if (BizNumber.valueOf(2.5).equals(pKeisanWExtBean.getKaiyakusjkkktyouseiriritu())) {

                    return C_ErrorKbn.ERROR;
                } else {
                    return C_ErrorKbn.OK;
                }
            } else if (TESTPATTERN3.equals(SYORIPTN)) {

                if (BizNumber.valueOf(0.5).equals(pKeisanWExtBean.getKaiyakusjkkktyouseiriritu())) {

                    return C_ErrorKbn.ERROR;
                } else if (BizNumber.valueOf(1.5).equals(pKeisanWExtBean.getKaiyakusjkkktyouseiriritu())) {

                    return C_ErrorKbn.ERROR;
                } else if (BizNumber.valueOf(2.5).equals(pKeisanWExtBean.getKaiyakusjkkktyouseiriritu())) {

                    return C_ErrorKbn.ERROR;
                } else {
                    return C_ErrorKbn.OK;
                }
            } else if (TESTPATTERN4.equals(SYORIPTN)) {

                if (BizNumber.valueOf(0.5).equals(pKeisanWExtBean.getKaiyakusjkkktyouseiriritu())) {

                    return C_ErrorKbn.ERROR;
                } else if (BizNumber.valueOf(1.5).equals(pKeisanWExtBean.getKaiyakusjkkktyouseiriritu())) {

                    return C_ErrorKbn.ERROR;
                } else if (BizNumber.valueOf(2.5).equals(pKeisanWExtBean.getKaiyakusjkkktyouseiriritu())) {

                    return C_ErrorKbn.ERROR;
                } else {
                    return C_ErrorKbn.OK;
                }
            } else if (TESTPATTERN5.equals(SYORIPTN)) {

                if (BizNumber.valueOf(0.5).equals(pKeisanWExtBean.getKaiyakusjkkktyouseiriritu())) {

                    return C_ErrorKbn.ERROR;
                } else if (BizNumber.valueOf(1.5).equals(pKeisanWExtBean.getKaiyakusjkkktyouseiriritu())) {

                    return C_ErrorKbn.ERROR;
                } else if (BizNumber.valueOf(2.5).equals(pKeisanWExtBean.getKaiyakusjkkktyouseiriritu())) {

                    return C_ErrorKbn.ERROR;
                } else {
                    return C_ErrorKbn.OK;
                }
            }
        }
        else if (caller == WSuiihyouSyuusin2Test_exec.class) {
            if (TESTPATTERN4.equals(SYORIPTN)) {
                return C_ErrorKbn.ERROR;
            }
            else if (TESTPATTERN5.equals(SYORIPTN) && "0".equals(flag)) {
                flag = "1";
            }
            else if (TESTPATTERN5.equals(SYORIPTN) && "1".equals(flag)) {
                flag = "0";
                return C_ErrorKbn.ERROR;
            }
            else if (TESTPATTERN6.equals(SYORIPTN) && "0".equals(flag)) {
                flag = "1";
            }
            else if (TESTPATTERN6.equals(SYORIPTN) && "1".equals(flag)) {
                flag = "2";
            }
            else if (TESTPATTERN6.equals(SYORIPTN) && "2".equals(flag)) {
                flag = "0";
                return C_ErrorKbn.ERROR;
            }
        }
        else if (caller == WSuiihyouTest_exec.class) {
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
            else if (TESTPATTERN5.equals(SYORIPTN) && "0".equals(flag)) {
                flag = "1";
                return C_ErrorKbn.OK;
            }
            else if (TESTPATTERN5.equals(SYORIPTN) && "1".equals(flag)) {
                flag = "0";
                return C_ErrorKbn.ERROR;
            }
            else if (TESTPATTERN6.equals(SYORIPTN) && "0".equals(flag)) {
                flag = "1";
                return C_ErrorKbn.OK;
            }
            else if (TESTPATTERN6.equals(SYORIPTN) && "1".equals(flag)) {
                flag = "2";
                return C_ErrorKbn.OK;
            }
            else if (TESTPATTERN6.equals(SYORIPTN) && "2".equals(flag)) {
                flag = "0";
                return C_ErrorKbn.ERROR;
            }
            else if (TESTPATTERN7.equals(SYORIPTN) && "0".equals(flag)) {
                flag = "1";
                return C_ErrorKbn.OK;
            }
            else if (TESTPATTERN7.equals(SYORIPTN) && "1".equals(flag)) {
                flag = "2";
                return C_ErrorKbn.OK;
            }
            else if (TESTPATTERN7.equals(SYORIPTN) && "2".equals(flag)) {
                flag = "3";
                return C_ErrorKbn.OK;
            }
            else if (TESTPATTERN7.equals(SYORIPTN) && "3".equals(flag)) {
                flag = "0";
                return C_ErrorKbn.ERROR;
            }
        }
        if (caller == CalcHkShrKngkItijibrSysnTest_exec.class){
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return C_ErrorKbn.ERROR;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
            else if (TESTPATTERN4.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
            else if (TESTPATTERN5.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
            else if (TESTPATTERN6.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
        }
        else if (caller == CalcHkShrKngkItijibrKojinNkTest_exec.class){
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return C_ErrorKbn.ERROR;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
            else if (TESTPATTERN4.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
            else if (TESTPATTERN5.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
        }
        else if (caller == CalcHkKngkHijynbrKojinNkTest_exec.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return C_ErrorKbn.ERROR;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
            else if (TESTPATTERN4.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
            else if (TESTPATTERN5.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
        }
        else if (caller == GetSibouymdWTest_exec.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return C_ErrorKbn.ERROR;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
        }
        if (caller == KeisanCommonKaiyakuTest_keisanKaiyakuseisankin.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return C_ErrorKbn.ERROR;
            }
            if (TESTPATTERN2.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
            if (TESTPATTERN3.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
        }

        if (caller == HbSeihoWebNenkinKaiyakuhrSuiiTest_execPostForm.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
            if (TESTPATTERN2.equals(SYORIPTN)) {
                return C_ErrorKbn.ERROR;
            }
            if (TESTPATTERN3.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
        }

        else if(caller == WSuiihyouNenkin2Test_exec.class){
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                return C_ErrorKbn.ERROR;
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {
                if (pKeisanWExtBean.getTmttkntaisyouym() == null) {
                    return C_ErrorKbn.OK;
                }
                return C_ErrorKbn.ERROR;
            }
        }
        return super.exec(pCalcKijyunYmd, pKijyunYm, pKeisanWExtBean);
    }

    @Override
    public BizCurrency getW() {

        if (caller == HbKeiyakuSyoukaiTest_exec.class && TESTPATTERN1.equals(SYORIPTN)) {
            return BizCurrency.valueOf(1000);
        }
        else if (caller == KeisanYendtHnkSTest_exec.class) {
            if (TESTPATTERN2.equals(SYORIPTN)) {
                return BizCurrency.valueOf(1234567890);
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {
                return BizCurrency.valueOf(123456711);
            }
            else if (TESTPATTERN4.equals(SYORIPTN)) {
                return BizCurrency.valueOf(123456710);
            }
            else if (TESTPATTERN5.equals(SYORIPTN)) {
                return BizCurrency.valueOf(1234567121);
            }
        }
        else if (caller == WSuiihyouNenkinTest_exec.class) {

            if (TESTPATTERN1.equals(SYORIPTN)) {

                return BizCurrency.valueOf(10000);
            }
        }
        else if (caller == WSuiihyouTest_exec.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return BizCurrency.valueOf(70);
            }
            else if (caller == WSuiihyouTest_exec.class && TESTPATTERN2.equals(SYORIPTN)) {
                return BizCurrency.valueOf(100);
            }
            else if (caller == WSuiihyouTest_exec.class && TESTPATTERN3.equals(SYORIPTN)) {
                return BizCurrency.valueOf(55);
            }
            else if (TESTPATTERN5.equals(SYORIPTN) ||
                caller == WSuiihyouTest_exec.class && TESTPATTERN6.equals(SYORIPTN) ||
                caller == WSuiihyouTest_exec.class && TESTPATTERN7.equals(SYORIPTN)) {
                return BizCurrency.valueOf(100);
            }

        }
        if (caller == CalcHkShrKngkItijibrSysnTest_exec.class){
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                return BizCurrency.valueOf(6000002000006L, BizCurrencyTypes.DOLLAR);
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {
                return BizCurrency.valueOf(5000002000005L, BizCurrencyTypes.EURO);
            }
            else if (TESTPATTERN4.equals(SYORIPTN)) {
                return BizCurrency.valueOf(8000002000008L, BizCurrencyTypes.AU_DOLLAR);
            }
            else if (TESTPATTERN5.equals(SYORIPTN)) {
                return BizCurrency.valueOf(7000022200007L, BizCurrencyTypes.AU_DOLLAR);
            }
            else if (TESTPATTERN6.equals(SYORIPTN)) {
                return BizCurrency.valueOf(7000022200007L, BizCurrencyTypes.YEN);
            }
        }
        else if (caller == CalcHkShrKngkItijibrKojinNkTest_exec.class){

            if (TESTPATTERN2.equals(SYORIPTN)) {
                return BizCurrency.valueOf(6000002000006L, BizCurrencyTypes.DOLLAR);
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {
                return BizCurrency.valueOf(5000002000005L, BizCurrencyTypes.EURO);
            }
            else if (TESTPATTERN4.equals(SYORIPTN)) {
                return BizCurrency.valueOf(8000002000008L, BizCurrencyTypes.AU_DOLLAR);
            }
            else if (TESTPATTERN5.equals(SYORIPTN)) {
                return BizCurrency.valueOf(8000002000008L, BizCurrencyTypes.YEN);
            }
        }
        else if (caller == CalcHkKngkHijynbrKojinNkTest_exec.class) {
            if (TESTPATTERN2.equals(SYORIPTN)) {
                return BizCurrency.valueOf(6000001000006L, BizCurrencyTypes.DOLLAR);
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {
                return BizCurrency.valueOf(6000004000006L, BizCurrencyTypes.DOLLAR);
            }
            else if (TESTPATTERN4.equals(SYORIPTN)) {
                return BizCurrency.valueOf(6000004000006L, BizCurrencyTypes.EURO);
            }
            else if (TESTPATTERN5.equals(SYORIPTN)) {
                return BizCurrency.valueOf(6000007000006L, BizCurrencyTypes.AU_DOLLAR);
            }
        }
        else if (caller == GetSibouymdWTest_exec.class) {
            if (TESTPATTERN2.equals(SYORIPTN)) {
                return BizCurrency.valueOf(6000006000006L, BizCurrencyTypes.AU_DOLLAR);
            }
        }
        if (caller == KeisanCommonKaiyakuTest_keisanKaiyakuseisankin.class) {

            if (TESTPATTERN1.equals(SYORIPTN)) {
                return BizCurrency.valueOf(1234);
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                return BizCurrency.valueOf(1234);
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {
                return BizCurrency.valueOf(1001);
            }
        }
        else if(caller == WSuiihyouNenkin2Test_exec.class){
            if (TESTPATTERN1.equals(SYORIPTN) || TESTPATTERN3.equals(SYORIPTN)) {
                return BizCurrency.valueOf(654.666);
            }
        }

        return super.getW();
    }

    @Override
    public BizCurrency getV() {

        if (caller == WSuiihyouNenkinTest_exec.class) {

            if (TESTPATTERN1.equals(SYORIPTN)) {

                return BizCurrency.valueOf(15000);
            }
        }
        else if (caller == WSuiihyouTest_exec.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return BizCurrency.valueOf(55);
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                return BizCurrency.valueOf(68);
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {
                return BizCurrency.valueOf(55);
            }
            else if (TESTPATTERN5.equals(SYORIPTN) ||
                caller == WSuiihyouTest_exec.class && TESTPATTERN6.equals(SYORIPTN) ||
                caller == WSuiihyouTest_exec.class && TESTPATTERN7.equals(SYORIPTN)) {
                return BizCurrency.valueOf(68);
            }

        }
        else if (caller == CalcHkShrKngkItijibrSysnTest_exec.class){
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                return BizCurrency.valueOf(3000003000003L, BizCurrencyTypes.DOLLAR);
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {
                return BizCurrency.valueOf(7000003000007L, BizCurrencyTypes.EURO);
            }
            else if (TESTPATTERN4.equals(SYORIPTN)) {
                return BizCurrency.valueOf(4000003000004L, BizCurrencyTypes.AU_DOLLAR);
            }
            else if (TESTPATTERN5.equals(SYORIPTN)) {
                return BizCurrency.valueOf(2000033300002L, BizCurrencyTypes.AU_DOLLAR);
            }
            else if (TESTPATTERN6.equals(SYORIPTN)) {
                return BizCurrency.valueOf(2000033300002L, BizCurrencyTypes.YEN);
            }
        }
        else if (caller == CalcHkShrKngkItijibrKojinNkTest_exec.class){

            if (TESTPATTERN2.equals(SYORIPTN)) {
                return BizCurrency.valueOf(3000003000003L, BizCurrencyTypes.DOLLAR);
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {
                return BizCurrency.valueOf(7000003000007L, BizCurrencyTypes.EURO);
            }
            else if (TESTPATTERN4.equals(SYORIPTN)) {
                return BizCurrency.valueOf(4000003000004L, BizCurrencyTypes.AU_DOLLAR);
            }
            else if (TESTPATTERN5.equals(SYORIPTN)) {
                return BizCurrency.valueOf(4000003000004L, BizCurrencyTypes.YEN);
            }
        }
        else if (caller == CalcHkKngkHijynbrKojinNkTest_exec.class) {
            if (TESTPATTERN2.equals(SYORIPTN)) {
                return BizCurrency.valueOf(5000001000006L, BizCurrencyTypes.DOLLAR);
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {
                return BizCurrency.valueOf(5000004000006L, BizCurrencyTypes.DOLLAR);
            }
            else if (TESTPATTERN4.equals(SYORIPTN)) {
                return BizCurrency.valueOf(6000004000002L, BizCurrencyTypes.EURO);
            }
            else if (TESTPATTERN5.equals(SYORIPTN)) {
                return BizCurrency.valueOf(9000007000008L, BizCurrencyTypes.AU_DOLLAR);
            }
        }
        else if (caller == GetSibouymdWTest_exec.class) {
            if (TESTPATTERN2.equals(SYORIPTN)) {
                return BizCurrency.valueOf(9000009000009L, BizCurrencyTypes.AU_DOLLAR);
            }
        }
        if (caller == KeisanCommonKaiyakuTest_keisanKaiyakuseisankin.class) {

            if (TESTPATTERN1.equals(SYORIPTN)) {
                return BizCurrency.valueOf(1234);
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                return BizCurrency.valueOf(1234);
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {
                return BizCurrency.valueOf(1001);
            }
        }
        else if (caller == HbSeihoWebNenkinKaiyakuhrSuiiTest_execPostForm.class) {

            if (TESTPATTERN1.equals(SYORIPTN)) {

                return BizCurrency.valueOf(40);
            }
        }

        else if(caller == WSuiihyouNenkin2Test_exec.class){
            if (TESTPATTERN1.equals(SYORIPTN) || TESTPATTERN3.equals(SYORIPTN)) {
                return BizCurrency.valueOf(963852);
            }
        }
        else if (caller == HbKeiyakuSyoukaiTest_exec.class) {
            switch (SYORIPTN) {
                case TESTPATTERN1: return BizCurrency.valueOf(1000);
                default: break;
            }
        }
        return super.getV();
    }

    @Override
    public BizCurrency getKaiyakukjMaeW() {

        if (caller == WSuiihyouNenkinTest_exec.class) {

            if (TESTPATTERN1.equals(SYORIPTN)) {

                return BizCurrency.valueOf(25000);
            }
        }
        if (caller == KeisanCommonKaiyakuTest_keisanKaiyakuseisankin.class) {

            if (TESTPATTERN1.equals(SYORIPTN)) {
                return BizCurrency.valueOf(1234);
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                return BizCurrency.valueOf(1234);
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {
                return BizCurrency.valueOf(1001);
            }
        }
        return super.getKaiyakukjMaeW();
    }

    @Override
    public BizCurrency getTeirituTmttkngk() {
        if (caller == CalcHkShrKngkItijibrSysnTest_exec.class){
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                return BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR);
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {
                return BizCurrency.valueOf(0, BizCurrencyTypes.EURO);
            }
            else if (TESTPATTERN4.equals(SYORIPTN)) {
                return BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR);
            }
            else if (TESTPATTERN5.equals(SYORIPTN)) {
                return BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR);
            }
            else if (TESTPATTERN6.equals(SYORIPTN)) {
                return BizCurrency.valueOf(1000000, BizCurrencyTypes.YEN);
            }
        }
        else if (caller == CalcHkShrKngkItijibrKojinNkTest_exec.class){

            if (TESTPATTERN2.equals(SYORIPTN)) {
                return BizCurrency.valueOf(1000000, BizCurrencyTypes.DOLLAR);
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {
                return BizCurrency.valueOf(2000000, BizCurrencyTypes.EURO);
            }
            else if (TESTPATTERN4.equals(SYORIPTN)) {
                return BizCurrency.valueOf(3000000, BizCurrencyTypes.AU_DOLLAR);
            }
            else if (TESTPATTERN5.equals(SYORIPTN)) {
                return BizCurrency.valueOf(3000000, BizCurrencyTypes.YEN);
            }
        }

        if (caller == KeisanCommonKaiyakuTest_keisanKaiyakuseisankin.class) {

            if (TESTPATTERN1.equals(SYORIPTN)) {
                return BizCurrency.valueOf(1234);
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                return BizCurrency.valueOf(1234);
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {
                return BizCurrency.valueOf(1001);
            }
        }

        return super.getTeirituTmttkngk();
    }

    @Override
    public BizCurrency getSisuurendouTmttkngk() {
        if (caller == CalcHkShrKngkItijibrSysnTest_exec.class){
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                return BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR);
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {
                return BizCurrency.valueOf(0, BizCurrencyTypes.EURO);
            }
            else if (TESTPATTERN4.equals(SYORIPTN)) {
                return BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR);
            }
            else if (TESTPATTERN5.equals(SYORIPTN)) {
                return BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR);
            }
            else if (TESTPATTERN6.equals(SYORIPTN)) {
                return BizCurrency.valueOf(1230000, BizCurrencyTypes.YEN);
            }
        }
        else if (caller == CalcHkShrKngkItijibrKojinNkTest_exec.class){

            if (TESTPATTERN2.equals(SYORIPTN)) {
                return BizCurrency.valueOf(12000000, BizCurrencyTypes.DOLLAR);
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {
                return BizCurrency.valueOf(2300000, BizCurrencyTypes.EURO);
            }
            else if (TESTPATTERN4.equals(SYORIPTN)) {
                return BizCurrency.valueOf(3400000, BizCurrencyTypes.AU_DOLLAR);
            }
            else if (TESTPATTERN5.equals(SYORIPTN)) {
                return BizCurrency.valueOf(3400000, BizCurrencyTypes.YEN);
            }
        }

        if (caller == KeisanCommonKaiyakuTest_keisanKaiyakuseisankin.class) {

            if (TESTPATTERN1.equals(SYORIPTN)) {
                return BizCurrency.valueOf(1234);
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                return BizCurrency.valueOf(1234);
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {
                return BizCurrency.valueOf(1001);
            }
        }
        return super.getSisuurendouTmttkngk();
    }

    @Override
    public BizNumber getSjkkktyouseiritu() {
        if (caller == KeisanCommonKaiyakuTest_keisanKaiyakuseisankin.class) {

            if (TESTPATTERN1.equals(SYORIPTN)) {
                return BizNumber.valueOf(1001);
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                return BizNumber.valueOf(2001);
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {
                return BizNumber.valueOf(3001);
            }
        }
        return super.getSjkkktyouseiritu();
    }

    @Override
    public BizCurrency getSjkkktyouseigk() {
        if (caller == KeisanCommonKaiyakuTest_keisanKaiyakuseisankin.class) {

            if (TESTPATTERN1.equals(SYORIPTN)) {
                return BizCurrency.valueOf(1001);
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                return BizCurrency.valueOf(2001);
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {
                return BizCurrency.valueOf(3001);
            }
        }
        return super.getSjkkktyouseigk();
    }

    @Override
    public BizCurrency getKaiyakukjgk() {
        if (caller == KeisanCommonKaiyakuTest_keisanKaiyakuseisankin.class) {

            if (TESTPATTERN1.equals(SYORIPTN)) {
                return BizCurrency.valueOf(1001);
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                return BizCurrency.valueOf(2001);
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {
                return BizCurrency.valueOf(3001);
            }
        }
        return super.getKaiyakukjgk();
    }
    @Override
    public BizNumber getKaiyakukjritu() {
        if (caller == KeisanCommonKaiyakuTest_keisanKaiyakuseisankin.class) {

            if (TESTPATTERN1.equals(SYORIPTN)) {
                return BizNumber.valueOf(1001);
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                return BizNumber.valueOf(2001);
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {
                return BizNumber.valueOf(3001);
            }
        }
        return super.getKaiyakukjritu();
    }

    @Override
    public C_FiSiyouKbn getFiSiyouKbn() {
        if (caller == KeisanCommonKaiyakuTest_keisanKaiyakuseisankin.class) {

            if (TESTPATTERN1.equals(SYORIPTN)) {
                return C_FiSiyouKbn.BLNK;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                return C_FiSiyouKbn.TJTMATU;
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {
                return C_FiSiyouKbn.TJTSI;
            }
        }

        return super.getFiSiyouKbn();
    }

    @Override
    public BizDateYM getPtumitatekinKeisanYM() {

        if(caller == WSuiihyouNenkin2Test_exec.class){
            if (TESTPATTERN1.equals(SYORIPTN) || TESTPATTERN3.equals(SYORIPTN)) {
                return BizDateYM.valueOf(201904);
            }
        }

        return super.getPtumitatekinKeisanYM();
    }

    @Override
    public BizCurrency getPruikei() {

        if(caller == WSuiihyouNenkin2Test_exec.class){
            if (TESTPATTERN1.equals(SYORIPTN) || TESTPATTERN3.equals(SYORIPTN)) {
                return BizCurrency.valueOf(1234.555);
            }
        }
        if (caller == CalcHkKngkHijynbrKojinNkTest_exec.class) {
            if (TESTPATTERN2.equals(SYORIPTN)) {
                return BizCurrency.valueOf(5000001000005L, BizCurrencyTypes.DOLLAR);
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {
                return BizCurrency.valueOf(5000004000005L, BizCurrencyTypes.DOLLAR);
            }
            else if (TESTPATTERN4.equals(SYORIPTN)) {
                return BizCurrency.valueOf(6000004000001L, BizCurrencyTypes.EURO);
            }
            else if (TESTPATTERN5.equals(SYORIPTN)) {
                return BizCurrency.valueOf(9000007000009L, BizCurrencyTypes.AU_DOLLAR);
            }
        }
        else if (caller == GetSibouymdWTest_exec.class) {
            if (TESTPATTERN2.equals(SYORIPTN)) {
                return BizCurrency.valueOf(7000007000007L, BizCurrencyTypes.AU_DOLLAR);
            }
        }
        return super.getPruikei();
    }
}

