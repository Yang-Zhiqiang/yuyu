package yuyu.common.siharai.sicommon;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;
import yuyu.app.dsweb.dwhozeninfo.dwgethozenkeiyakuenitijisyusin.DwGetHozenKeiyakuEnItijiSyusinImplTest_execPostForm;
import yuyu.app.dsweb.dwhozeninfo.dwgethozenkiykgikhijynnnkn.DwGetHozenKiykGikHijynNnknImplTest_execPostForm;
import yuyu.app.dsweb.dwhozeninfo.dwgethozenkiykgikitijinnkn.DwGetHozenKiykGikItijiNnknImplTest_execPostForm;
import yuyu.app.dsweb.dwhozeninfo.dwgethozenkykenitijinnkn.DwGetHozenKykEnItijiNnknImplTest_execPostForm;
import yuyu.app.dsweb.dwhozeninfo.dwgethozenkyksntkhijynsysn.DwGetHozenKykSntkHijynSysnImplTest_execPostForm;
import yuyu.common.direct.dscommon.DsGetKeiyakuSyousaiTest_exec;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_HokenkinsyuruiKbn;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_Sdpd;
import yuyu.def.classification.C_SiinKbn;

/**
 * {@link CalcHkShrKngk}のモッククラスです。<br />
 */
public class CalcHkShrKngkMockForDirect extends CalcHkShrKngk {

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static final String TESTPATTERN3 = "3";

    public static final String TESTPATTERN4 = "4";

    public static final String TESTPATTERN5 = "5";

    public static final String TESTPATTERN6 = "6";

    public static final String TESTPATTERN7 = "7";

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    public static String mode = null;

    @Override
    public C_ErrorKbn execByKeisanWExt(String pSyoNo, BizDate pCalckijyunYmd, C_SiinKbn pSiinKbn,
        C_HokenkinsyuruiKbn pHokenkinsyuruiKbn, C_Sdpd pSdpd, C_Hrkkeiro pHrkkeiro) {

        if (caller == DwGetHozenKykEnItijiNnknImplTest_execPostForm.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                return C_ErrorKbn.ERROR;
            }
        }

        if (caller == DwGetHozenKeiyakuEnItijiSyusinImplTest_execPostForm.class) {

            if (TESTPATTERN1.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                return C_ErrorKbn.ERROR;
            }
            return C_ErrorKbn.OK;
        }

        if (caller == DsGetKeiyakuSyousaiTest_exec.class) {
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
                return C_ErrorKbn.OK;
            }
            else if (TESTPATTERN5.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
            else if (TESTPATTERN6.equals(SYORIPTN)) {
                return C_ErrorKbn.ERROR;
            }
        }

        if (caller == DwGetHozenKiykGikItijiNnknImplTest_execPostForm.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
            else  if (TESTPATTERN2.equals(SYORIPTN)) {
                return C_ErrorKbn.ERROR;
            }
        }

        else if (caller == DwGetHozenKiykGikHijynNnknImplTest_execPostForm.class) {
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

        if (DwGetHozenKykSntkHijynSysnImplTest_execPostForm.class == caller) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return C_ErrorKbn.ERROR;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
        }

        return super.execByKeisanWExt(pSyoNo, pCalckijyunYmd, pSiinKbn,pHokenkinsyuruiKbn, pSdpd, pHrkkeiro);

    }


    @Override
    public CalcHkShrKngkBean getCalcHkShrKngkBean() {
        CalcHkShrKngkBean calcHkShrKngkBean = SWAKInjector.getInstance(CalcHkShrKngkBean.class);

        if (caller == DwGetHozenKykEnItijiNnknImplTest_execPostForm.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(1234L,BizCurrencyTypes.YEN));
                calcHkShrKngkBean.setSibousGk(BizCurrency.valueOf(1234L,BizCurrencyTypes.YEN));
                calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(1234L,BizCurrencyTypes.YEN));
                return calcHkShrKngkBean;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                return calcHkShrKngkBean;
            }
        }

        if (caller == DwGetHozenKeiyakuEnItijiSyusinImplTest_execPostForm.class) {
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(20005));
            calcHkShrKngkBean.setSibousGk(BizCurrency.valueOf(10010));
            return calcHkShrKngkBean;
        }

        if (caller == DsGetKeiyakuSyousaiTest_exec.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(100.9));
                calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(200.9));
                calcHkShrKngkBean.setSibousGk(BizCurrency.valueOf(300.9));
                calcHkShrKngkBean.setSaigaisGk(BizCurrency.valueOf(400.9));
                return calcHkShrKngkBean;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(101.9));
                calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(201.9));
                calcHkShrKngkBean.setSibousGk(BizCurrency.valueOf(301.9));
                calcHkShrKngkBean.setSaigaisGk(BizCurrency.valueOf(0));
                return calcHkShrKngkBean;
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {
                calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(101.1));
                calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(201.2));
                calcHkShrKngkBean.setSibousGk(BizCurrency.valueOf(302.3));
                calcHkShrKngkBean.setSaigaisGk(BizCurrency.valueOf(302.4));
                return calcHkShrKngkBean;
            }
            else if (TESTPATTERN4.equals(SYORIPTN)) {
                calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(101.9, BizCurrencyTypes.DOLLAR));
                calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(201.9, BizCurrencyTypes.DOLLAR));
                calcHkShrKngkBean.setSibousGk(BizCurrency.valueOf(302.7, BizCurrencyTypes.DOLLAR));
                calcHkShrKngkBean.setSaigaisGk(BizCurrency.valueOf(100.8, BizCurrencyTypes.DOLLAR));
                return calcHkShrKngkBean;
            }
            else if (TESTPATTERN5.equals(SYORIPTN)) {
                calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(101.9));
                calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(201.9));
                calcHkShrKngkBean.setSibousGk(BizCurrency.valueOf(301.9));
                calcHkShrKngkBean.setSaigaisGk(BizCurrency.valueOf(401.9));
                return calcHkShrKngkBean;
            }
            else if (TESTPATTERN6.equals(SYORIPTN)) {
                calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(1000));
                calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(1001));
                calcHkShrKngkBean.setSibousGk(BizCurrency.valueOf(0));
                calcHkShrKngkBean.setSaigaisGk(BizCurrency.valueOf(1003));
                return calcHkShrKngkBean;
            }
        }

        if (caller == DwGetHozenKiykGikItijiNnknImplTest_execPostForm.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(7777L,BizCurrencyTypes.YEN));
                calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(5555L,BizCurrencyTypes.YEN));
                calcHkShrKngkBean.setSibousGk(BizCurrency.valueOf(6666L,BizCurrencyTypes.YEN));
                calcHkShrKngkBean.setTeirituTmttkngk(BizCurrency.valueOf(8888L,BizCurrencyTypes.YEN));
                calcHkShrKngkBean.setSisuurendouTmttkngk(BizCurrency.valueOf(9999L,BizCurrencyTypes.YEN));
                return calcHkShrKngkBean;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                return calcHkShrKngkBean;
            }
        }

        else if (caller == DwGetHozenKiykGikHijynNnknImplTest_execPostForm.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                calcHkShrKngkBean.setSibousGk(BizCurrency.valueOf(100004.00, BizCurrencyTypes.DOLLAR));
                return calcHkShrKngkBean;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                return calcHkShrKngkBean;
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {
                calcHkShrKngkBean.setSibousGk(null);
                return calcHkShrKngkBean;
            }
        }


        if (DwGetHozenKykSntkHijynSysnImplTest_execPostForm.class == caller) {

            if (TESTPATTERN2.equals(SYORIPTN)) {
                calcHkShrKngkBean.setSibousGk(BizCurrency.valueOf(100004.00, BizCurrencyTypes.DOLLAR));
                return calcHkShrKngkBean;
            }
        }

        return super.getCalcHkShrKngkBean();
    }
}
