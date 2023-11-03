package yuyu.common.hozen.khcommon;

import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;
import yuyu.app.bosyuu.hbsekmos.hbseihowebnenkinkaiyakuhrsuii.HbSeihoWebNenkinKaiyakuhrSuiiTest_execPostForm;
import yuyu.app.bosyuu.hbsekmos.hbseihowebsekmos.HbSeihoWebSekMosTest_execPostForm2;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_Tuukasyu;

/**
 * 契約保全 共通 指数連動年金契約時積立金計算<br />
 * {@link KeisanSisuuRendouNkKykTmttkn}のモッククラスです。<br />
 */
public class KeisanSisuuRendouNkKykTmttknMock extends KeisanSisuuRendouNkKykTmttkn {

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static final String TESTPATTERN3 = "3";

    public static final String TESTPATTERN4 = "4";

    private BizCurrency teirituTmttkngk;

    private BizCurrency sisuurendouTmttkngk;

    @Override
    public C_ErrorKbn exec(C_Tuukasyu pTuukasyu, BizCurrency pHokenryou,  BizNumber pSisuurendourate) {
        if (caller == HbSeihoWebSekMosTest_execPostForm2.class && TESTPATTERN1.equals(SYORIPTN)) {
            teirituTmttkngk = BizCurrency.valueOf(1.5);
            sisuurendouTmttkngk = BizCurrency.valueOf(2.5);
            return C_ErrorKbn.OK;
        }
        else if (caller == HbSeihoWebSekMosTest_execPostForm2.class && TESTPATTERN2.equals(SYORIPTN)) {
            teirituTmttkngk = BizCurrency.valueOf(5);
            sisuurendouTmttkngk = BizCurrency.valueOf(10);
            return C_ErrorKbn.OK;
        }
        else if (caller == HbSeihoWebSekMosTest_execPostForm2.class && TESTPATTERN3.equals(SYORIPTN)) {
            return C_ErrorKbn.ERROR;
        }

        else if (caller == EditSuiihyouTblTest_editTBL.class && TESTPATTERN1.equals(SYORIPTN)) {
            teirituTmttkngk = BizCurrency.valueOf(2, BizCurrencyTypes.YEN);
            sisuurendouTmttkngk = BizCurrency.valueOf(5, BizCurrencyTypes.YEN);
            return C_ErrorKbn.OK;
        }
        if (caller == HbSeihoWebNenkinKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN4.equals(SYORIPTN)) {
            return C_ErrorKbn.ERROR;
        }
        else if (caller == HbSeihoWebNenkinKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN1.equals(SYORIPTN)) {
            teirituTmttkngk = BizCurrency.valueOf(1.5);
            sisuurendouTmttkngk = BizCurrency.valueOf(2.5);
            return C_ErrorKbn.OK;
        }
        if (caller == EditSuiihyouTblNenkinTest_editTBL.class)  {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                teirituTmttkngk = BizCurrency.valueOf(11);
                sisuurendouTmttkngk = BizCurrency.valueOf(12);
                return C_ErrorKbn.OK;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                teirituTmttkngk = BizCurrency.valueOf(21);
                sisuurendouTmttkngk = BizCurrency.valueOf(22);
                return C_ErrorKbn.ERROR;
            }
        }
        return super.exec(pTuukasyu, pHokenryou, pSisuurendourate);
    }

    @Override
    public BizCurrency getTeiritutmttkngk() {
        if (caller == HbSeihoWebSekMosTest_execPostForm2.class && TESTPATTERN1.equals(SYORIPTN)) {
            return teirituTmttkngk;
        }
        else if (caller == HbSeihoWebSekMosTest_execPostForm2.class && TESTPATTERN2.equals(SYORIPTN)) {
            return teirituTmttkngk;
        }
        else if (caller == EditSuiihyouTblTest_editTBL.class && TESTPATTERN1.equals(SYORIPTN)) {
            return teirituTmttkngk;
        }

        if (caller == HbSeihoWebNenkinKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN1.equals(SYORIPTN)) {
            return teirituTmttkngk;
        }
        if (caller == EditSuiihyouTblNenkinTest_editTBL.class)  {
            return teirituTmttkngk;
        }
        return super.getTeiritutmttkngk();
    }

    @Override
    public BizCurrency getSisuurendoutmttkngk() {
        if (caller == HbSeihoWebSekMosTest_execPostForm2.class && TESTPATTERN1.equals(SYORIPTN)) {
            return sisuurendouTmttkngk;
        }
        else if (caller == HbSeihoWebSekMosTest_execPostForm2.class && TESTPATTERN2.equals(SYORIPTN)) {
            return sisuurendouTmttkngk;
        }
        else if (caller == EditSuiihyouTblTest_editTBL.class && TESTPATTERN1.equals(SYORIPTN)) {
            return sisuurendouTmttkngk;
        }

        if (caller == HbSeihoWebNenkinKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN1.equals(SYORIPTN)) {
            return sisuurendouTmttkngk;
        }
        if (caller == EditSuiihyouTblNenkinTest_editTBL.class)  {
            return sisuurendouTmttkngk;
        }
        return super.getSisuurendoutmttkngk();
    }
}