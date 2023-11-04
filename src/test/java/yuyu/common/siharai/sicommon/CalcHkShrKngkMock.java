package yuyu.common.siharai.sicommon;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;
import yuyu.app.bosyuu.hbsekmos.hbseihowebkaiyakuhrsuii.HbSeihoWebKaiyakuhrSuiiTest_execPostForm;
import yuyu.app.dsweb.dwhozeninfo.dwgethozenkeiyakuenitijisyusin.DwGetHozenKeiyakuEnItijiSyusinImplTest_execPostForm;
import yuyu.app.dsweb.dwhozeninfo.dwgethozenkiykgikhijynnnkn.DwGetHozenKiykGikHijynNnknImplTest_execPostForm;
import yuyu.app.dsweb.dwhozeninfo.dwgethozenkiykgikitijinnkn.DwGetHozenKiykGikItijiNnknImplTest_execPostForm;
import yuyu.app.dsweb.dwhozeninfo.dwgethozenkykenitijinnkn.DwGetHozenKykEnItijiNnknImplTest_execPostForm;
import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.bosyuu.hbkeiyakusyoukai.HbKeiyakuSyoukaiTest_exec;
import yuyu.common.direct.dscommon.DsGetKeiyakuSyousaiTest_exec;
import yuyu.common.hozen.khcommon.EditKykNaiyouOsirase1Test_editInfo;
import yuyu.common.hozen.khcommon.EditKykNaiyouOsirase2Test_editInfo;
import yuyu.common.hozen.khcommon.EditKykNaiyouOsirase3Test_editInfo;
import yuyu.common.hozen.khcommon.EditSyoukenTblSyuusinTest_editTBL;
import yuyu.common.hozen.khcommon.EditSyoukenTblTest_editTBL_A1;
import yuyu.common.hozen.khcommon.EditSyoukenTblTest_editTBL_A2;
import yuyu.common.hozen.khcommon.EditSyoukenTblTest_editTBL_A3;
import yuyu.common.hozen.khcommon.EditSyoukenTblTest_editTBL_A4;
import yuyu.common.hozen.khcommon.EditSyoukenTblTest_editTBL_A5;
import yuyu.common.hozen.setuibean.SetHosyouTest_exec;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_Hhknsei;
import yuyu.def.classification.C_HknKknKbn;
import yuyu.def.classification.C_HknkknsmnKbn;
import yuyu.def.classification.C_HokenkinsyuruiKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_HrkkknsmnKbn;
import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_Sdpd;
import yuyu.def.classification.C_SiinKbn;
import yuyu.def.classification.C_Tuukasyu;

/**
 * {@link CalcHkShrKngk}のモッククラスです。<br />
 */
public class CalcHkShrKngkMock extends CalcHkShrKngk {

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static final String TESTPATTERN3 = "3";

    public static final String TESTPATTERN4 = "4";

    public static final String TESTPATTERN5 = "5";

    public static final String TESTPATTERN6 = "6";

    public static final String TESTPATTERN7 = "7";

    public static final String TESTPATTERN8 = "8";

    public static final String TESTPATTERN9 = "9";

    public static final String TESTPATTERN10 = "10";

    public static final String TESTPATTERN11 = "11";

    public static final String TESTPATTERN12 = "12";

    public static final String TESTPATTERN13 = "13";

    public static final String TESTPATTERN14= "14";

    public static final String TESTPATTERN15= "15";

    public static final String TESTPATTERN16= "16";

    public static final String TESTPATTERN17= "17";

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    public static String mode = null;

    @Override
    public C_ErrorKbn exec(String pSyouhnCd, Integer pSyouhnSdno, String pRyouritusdNo, BizNumber pYoteiRiritu,
        C_Hrkkaisuu pHrkKaisuu, C_HknkknsmnKbn pHknkknsmnKbn, Integer pHknKkn, Integer pHrkKkn, Integer pHhknNen,
        C_Hhknsei pHhknSei, BizCurrency pKihonS, BizDate pKykYmd, BizDate pCalckijyunYmd, String pSyoNo,
        C_Tuukasyu pTuukaSyu, Integer pDai1hknKkn, C_SiinKbn pSiinKbn,
        C_HokenkinsyuruiKbn pHokenkinsyuruiKbn, BizCurrency pHokenRyou,
        BizNumber pKaiyakusjkkktyouseiRiritu,BizNumber pKyksjkkktyouseiRiritu,
        BizDateYM pTmttkntaisyouYm,BizCurrency pTeiritutmttKngk,BizCurrency pSisuurendoutmttKngk,BizNumber pTumitateRiritu,
        C_HrkkknsmnKbn pHrkkknsmnKbn,BizDateYM pJkipjytYm,BizCurrency pPtmttKngk,BizCurrency pKihrkmPStgk,
        BizDate pFstPryosyuYmd,BizNumber pYoteirrthendohosyuRiritu,C_Kykjyoutai pKykJyoutai,
        BizDate pYendthnkYmd,  C_Sdpd pSdpdkbn,  C_Hrkkeiro pHrkkeiro) {

        CalcHkShrKngkBean calcHkShrKngkBean = SWAKInjector.getInstance(CalcHkShrKngkBean.class);
        if (caller == HbKeiyakuSyoukaiTest_exec.class) {

            if (TESTPATTERN1.equals(SYORIPTN)) {

                return C_ErrorKbn.ERROR;
            }

            if (TESTPATTERN2.equals(SYORIPTN)) {
                if (BizDateUtil.compareYmd(BizDate.valueOf("20170901"),pCalckijyunYmd)==BizDateUtil.COMPARE_EQUAL ) {
                    return C_ErrorKbn.ERROR;
                }
                return C_ErrorKbn.OK;
            }

            if (TESTPATTERN3.equals(SYORIPTN)) {

                return C_ErrorKbn.OK;
            }
            if (TESTPATTERN4.equals(SYORIPTN)) {

                return C_ErrorKbn.OK;
            }
            if (TESTPATTERN5.equals(SYORIPTN)) {

                if (BizDateUtil.compareYmd(pCalckijyunYmd, BizDate.valueOf("20170621")) == BizDateUtil.COMPARE_EQUAL) {
                    return C_ErrorKbn.ERROR;
                }

                return C_ErrorKbn.OK;
            }
            return C_ErrorKbn.OK;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN1.equals(SYORIPTN)) {
            super.exec(pSyouhnCd, pSyouhnSdno, pRyouritusdNo, pYoteiRiritu, pHrkKaisuu, pHknkknsmnKbn, pHknKkn,
                pHrkKkn, pHhknNen, pHhknSei, pKihonS, pKykYmd, pCalckijyunYmd, pSyoNo, pTuukaSyu, pDai1hknKkn,
                pSiinKbn, pHokenkinsyuruiKbn, pHokenRyou, pKaiyakusjkkktyouseiRiritu, pKyksjkkktyouseiRiritu,
                pTmttkntaisyouYm, pTeiritutmttKngk, pSisuurendoutmttKngk, pTumitateRiritu, pHrkkknsmnKbn, pJkipjytYm,
                pPtmttKngk, pKihrkmPStgk, pFstPryosyuYmd, pYoteirrthendohosyuRiritu, pKykJyoutai, pYendthnkYmd,
                pSdpdkbn, pHrkkeiro);
            return C_ErrorKbn.OK;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN)) {

            return C_ErrorKbn.OK;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN3.equals(SYORIPTN)) {

            return C_ErrorKbn.ERROR;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN4.equals(SYORIPTN) && mode ==null) {
            mode="1";
            return C_ErrorKbn.OK;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN4.equals(SYORIPTN) && "1".equals(mode)) {
            mode=null;
            return C_ErrorKbn.ERROR;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN5.equals(SYORIPTN) && mode ==null) {
            mode="1";
            return C_ErrorKbn.OK;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN5.equals(SYORIPTN) && "1".equals(mode)) {
            mode="2";
            return C_ErrorKbn.OK;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN5.equals(SYORIPTN) && "2".equals(mode)) {
            mode=null;
            return C_ErrorKbn.ERROR;
        }
        else if (caller == DsGetKeiyakuSyousaiTest_exec.class && TESTPATTERN1.equals(SYORIPTN) ) {
            return C_ErrorKbn.OK;
        }
        else if (caller == DsGetKeiyakuSyousaiTest_exec.class && TESTPATTERN2.equals(SYORIPTN) ) {
            return C_ErrorKbn.OK;
        }
        else if (caller == DsGetKeiyakuSyousaiTest_exec.class && TESTPATTERN3.equals(SYORIPTN) ) {
            return C_ErrorKbn.OK;
        }
        else if (caller == DsGetKeiyakuSyousaiTest_exec.class && TESTPATTERN4.equals(SYORIPTN) ) {
            return C_ErrorKbn.OK;
        }
        else if (caller == DsGetKeiyakuSyousaiTest_exec.class && TESTPATTERN5.equals(SYORIPTN) ) {
            return C_ErrorKbn.OK;
        }
        else if (caller == DsGetKeiyakuSyousaiTest_exec.class && TESTPATTERN6.equals(SYORIPTN)) {
            return C_ErrorKbn.ERROR;
        }
        else if ((caller == EditSyoukenTblTest_editTBL_A1.class || caller == EditSyoukenTblTest_editTBL_A2.class ||
            caller == EditSyoukenTblTest_editTBL_A3.class || caller == EditSyoukenTblTest_editTBL_A4.class ||
            caller == EditSyoukenTblTest_editTBL_A5.class) && TESTPATTERN1.equals(SYORIPTN)) {
            return C_ErrorKbn.OK;
        }
        else if (caller == EditSyoukenTblSyuusinTest_editTBL.class && TESTPATTERN1.equals(SYORIPTN)) {
            return C_ErrorKbn.OK;
        }
        else if (caller == SiSiharaiKingakuKeisanTest_exec.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return C_ErrorKbn.ERROR;
            }
            return C_ErrorKbn.OK;
        }
        else {
            return super.exec(pSyouhnCd, pSyouhnSdno, pRyouritusdNo, pYoteiRiritu, pHrkKaisuu, pHknkknsmnKbn, pHknKkn,
                pHrkKkn, pHhknNen, pHhknSei, pKihonS, pKykYmd, pCalckijyunYmd, pSyoNo, pTuukaSyu, pDai1hknKkn,
                pSiinKbn, pHokenkinsyuruiKbn, pHokenRyou, pKaiyakusjkkktyouseiRiritu, pKyksjkkktyouseiRiritu,
                pTmttkntaisyouYm, pTeiritutmttKngk, pSisuurendoutmttKngk, pTumitateRiritu, pHrkkknsmnKbn, pJkipjytYm,
                pPtmttKngk, pKihrkmPStgk, pFstPryosyuYmd, pYoteirrthendohosyuRiritu, pKykJyoutai, pYendthnkYmd,
                pSdpdkbn, pHrkkeiro);
        }

    }

    @Override
    public C_ErrorKbn execByKeisanWExt(String pSyoNo, BizDate pCalckijyunYmd, C_SiinKbn pSiinKbn,
        C_HokenkinsyuruiKbn pHokenkinsyuruiKbn, C_Sdpd pSdpdkbn, C_Hrkkeiro pHrkkeiro) {

        CalcHkShrKngkBean calcHkShrKngkBean = SWAKInjector.getInstance(CalcHkShrKngkBean.class);

        if (caller == SetHosyouTest_exec.class) {
            return C_ErrorKbn.OK;
        }
        else if (caller == HbKeiyakuSyoukaiTest_exec.class) {

            if (TESTPATTERN1.equals(SYORIPTN)) {

                return C_ErrorKbn.ERROR;
            }

            if (TESTPATTERN2.equals(SYORIPTN)) {
                if (BizDateUtil.compareYmd(BizDate.valueOf("20170901"), pCalckijyunYmd)==BizDateUtil.COMPARE_EQUAL) {
                    return C_ErrorKbn.ERROR;
                }
                return C_ErrorKbn.OK;
            }

            if (TESTPATTERN3.equals(SYORIPTN)) {

                return C_ErrorKbn.OK;
            }
            if (TESTPATTERN4.equals(SYORIPTN)) {

                return C_ErrorKbn.OK;
            }
            if (TESTPATTERN5.equals(SYORIPTN)) {

                if (BizDateUtil.compareYmd(pCalckijyunYmd, BizDate.valueOf("20170621")) == BizDateUtil.COMPARE_EQUAL) {
                    return C_ErrorKbn.ERROR;
                }

                return C_ErrorKbn.OK;
            }
            return C_ErrorKbn.OK;
        }
        else if (caller == SiSiharaiKingakuKeisanTest_exec.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return C_ErrorKbn.ERROR;
            }
            return C_ErrorKbn.OK;
        }

        else if (caller == DwGetHozenKeiyakuEnItijiSyusinImplTest_execPostForm.class) {

            if (TESTPATTERN1.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                return C_ErrorKbn.ERROR;
            }
            return C_ErrorKbn.OK;
        }

        else if (caller == DsGetKeiyakuSyousaiTest_exec.class && TESTPATTERN1.equals(SYORIPTN) ) {
            return C_ErrorKbn.OK;
        }
        else if (caller == DsGetKeiyakuSyousaiTest_exec.class && TESTPATTERN2.equals(SYORIPTN) ) {
            return C_ErrorKbn.OK;
        }
        else if (caller == DsGetKeiyakuSyousaiTest_exec.class && TESTPATTERN3.equals(SYORIPTN) ) {
            return C_ErrorKbn.OK;
        }
        else if (caller == DsGetKeiyakuSyousaiTest_exec.class && TESTPATTERN4.equals(SYORIPTN) ) {
            return C_ErrorKbn.OK;
        }
        else if (caller == DsGetKeiyakuSyousaiTest_exec.class && TESTPATTERN5.equals(SYORIPTN) ) {
            return C_ErrorKbn.OK;
        }
        else if (caller == DsGetKeiyakuSyousaiTest_exec.class && TESTPATTERN6.equals(SYORIPTN)) {
            return C_ErrorKbn.ERROR;
        }
        else if (caller == DwGetHozenKiykGikItijiNnknImplTest_execPostForm.class && TESTPATTERN1.equals(SYORIPTN)) {
            return C_ErrorKbn.OK;
        }
        else  if (caller == DwGetHozenKiykGikItijiNnknImplTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN)) {
            return C_ErrorKbn.ERROR;
        }
        else if (caller == DwGetHozenKykEnItijiNnknImplTest_execPostForm.class && TESTPATTERN1.equals(SYORIPTN)) {
            return C_ErrorKbn.OK;
        }
        else  if (caller == DwGetHozenKykEnItijiNnknImplTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN)) {
            return C_ErrorKbn.ERROR;
        }
        else if (caller == DwGetHozenKiykGikHijynNnknImplTest_execPostForm.class && TESTPATTERN1.equals(SYORIPTN)) {
            return C_ErrorKbn.OK;
        }
        else  if (caller == DwGetHozenKiykGikHijynNnknImplTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN)) {
            return C_ErrorKbn.ERROR;
        }
        else  if (caller == DwGetHozenKiykGikHijynNnknImplTest_execPostForm.class && TESTPATTERN3.equals(SYORIPTN)) {
            return C_ErrorKbn.OK;
        }
        else if (caller == EditKykNaiyouOsirase1Test_editInfo.class && TESTPATTERN1.equals(SYORIPTN) ) {
            return C_ErrorKbn.OK;
        }
        else if (caller == EditKykNaiyouOsirase1Test_editInfo.class && TESTPATTERN2.equals(SYORIPTN) ) {
            return C_ErrorKbn.OK;
        }
        else if (caller == EditKykNaiyouOsirase1Test_editInfo.class && TESTPATTERN3.equals(SYORIPTN) ) {
            return C_ErrorKbn.OK;
        }
        else if (caller == EditKykNaiyouOsirase1Test_editInfo.class && TESTPATTERN4.equals(SYORIPTN) ) {
            return C_ErrorKbn.ERROR;
        }
        else if (caller == EditKykNaiyouOsirase1Test_editInfo.class && TESTPATTERN5.equals(SYORIPTN)) {
            return C_ErrorKbn.OK;
        }
        else if (caller == EditKykNaiyouOsirase1Test_editInfo.class && TESTPATTERN6.equals(SYORIPTN)) {
            return C_ErrorKbn.OK;
        }
        else if (EditKykNaiyouOsirase2Test_editInfo.class == caller) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return C_ErrorKbn.ERROR;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
            else {
                return C_ErrorKbn.OK;
            }
        }
        else if (EditKykNaiyouOsirase3Test_editInfo.class == caller) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                return C_ErrorKbn.ERROR;
            }
            else {
                return C_ErrorKbn.OK;
            }
        }
        else {
            return super.execByKeisanWExt(pSyoNo, pCalckijyunYmd, pSiinKbn, pHokenkinsyuruiKbn, pSdpdkbn, pHrkkeiro);
        }

    }


    @Override
    public CalcHkShrKngkBean getCalcHkShrKngkBean() {
        CalcHkShrKngkBean calcHkShrKngkBean = SWAKInjector.getInstance(CalcHkShrKngkBean.class);
        if (caller == DsGetKeiyakuSyousaiTest_exec.class && TESTPATTERN1.equals(SYORIPTN) ) {
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(100.9));
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(200.9));
            calcHkShrKngkBean.setSibousGk(BizCurrency.valueOf(300.9));
            calcHkShrKngkBean.setSaigaisGk(BizCurrency.valueOf(400.9));
        }
        else if (caller == DsGetKeiyakuSyousaiTest_exec.class && TESTPATTERN2.equals(SYORIPTN) ) {
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(101.9));
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(201.9));
            calcHkShrKngkBean.setSibousGk(BizCurrency.valueOf(301.9));
            calcHkShrKngkBean.setSaigaisGk(BizCurrency.valueOf(401.9));
        }
        else if (caller == DsGetKeiyakuSyousaiTest_exec.class && TESTPATTERN3.equals(SYORIPTN) ) {
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(101.1));
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(201.2));
            calcHkShrKngkBean.setSibousGk(BizCurrency.valueOf(302.3));
            calcHkShrKngkBean.setSaigaisGk(BizCurrency.valueOf(302.4));
        }
        else if (caller == DsGetKeiyakuSyousaiTest_exec.class && TESTPATTERN4.equals(SYORIPTN) ) {
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(101.9, BizCurrencyTypes.DOLLAR));
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(201.9, BizCurrencyTypes.DOLLAR));
            calcHkShrKngkBean.setSibousGk(BizCurrency.valueOf(302.7, BizCurrencyTypes.DOLLAR));
            calcHkShrKngkBean.setSaigaisGk(BizCurrency.valueOf(100.8, BizCurrencyTypes.DOLLAR));
        }
        else if (caller == DsGetKeiyakuSyousaiTest_exec.class && TESTPATTERN5.equals(SYORIPTN) ) {
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(101.9));
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(201.9));
            calcHkShrKngkBean.setSibousGk(BizCurrency.valueOf(301.9));
            calcHkShrKngkBean.setSaigaisGk(BizCurrency.valueOf(401.9));
        }
        else if (caller == DsGetKeiyakuSyousaiTest_exec.class && TESTPATTERN6.equals(SYORIPTN)) {
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(1000));
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(1001));
            calcHkShrKngkBean.setSibousGk(BizCurrency.valueOf(1002));
            calcHkShrKngkBean.setSaigaisGk(BizCurrency.valueOf(1003));
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN1.equals(SYORIPTN) && mode ==null) {
            mode="1";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(1));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(2));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN1.equals(SYORIPTN) && "1".equals(mode)) {
            mode="2";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(11));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(22));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN1.equals(SYORIPTN) && "2".equals(mode)) {
            mode=null;
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(111));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(222));
            return calcHkShrKngkBean;
        }

        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && mode ==null) {
            mode="1";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(1));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(101));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "1".equals(mode)) {
            mode="2";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(201));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(301));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "2".equals(mode)) {
            mode="3";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(401));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(501));
            return calcHkShrKngkBean;
        }

        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "3".equals(mode)) {
            mode="4";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(2));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(102));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "4".equals(mode)) {
            mode="5";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(202));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(302));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "5".equals(mode)) {
            mode="6";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(402));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(502));
            return calcHkShrKngkBean;
        }

        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "6".equals(mode)) {
            mode="7";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(3));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(103));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "7".equals(mode)) {
            mode="8";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(203));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(303));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "8".equals(mode)) {
            mode="9";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(403));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(503));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "9".equals(mode)) {
            mode="10";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(4));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(104));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "10".equals(mode)) {
            mode="11";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(204));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(304));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "11".equals(mode)) {
            mode="12";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(404));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(504));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "12".equals(mode)) {
            mode="13";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(5));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(105));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "13".equals(mode)) {
            mode="14";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(205));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(305));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "14".equals(mode)) {
            mode="15";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(405));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(505));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "15".equals(mode)) {
            mode="16";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(6));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(106));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "16".equals(mode)) {
            mode="17";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(206));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(306));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "17".equals(mode)) {
            mode="18";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(406));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(506));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "18".equals(mode)) {
            mode="19";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(7));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(107));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "19".equals(mode)) {
            mode="20";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(207));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(307));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "20".equals(mode)) {
            mode="21";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(407));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(507));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "21".equals(mode)) {
            mode="22";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(8));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(108));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "22".equals(mode)) {
            mode="23";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(208));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(308));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "23".equals(mode)) {
            mode="24";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(408));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(508));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "24".equals(mode)) {
            mode="25";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(9));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(109));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "25".equals(mode)) {
            mode="26";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(209));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(309));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "26".equals(mode)) {
            mode="27";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(409));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(509));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "27".equals(mode)) {
            mode="28";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(10));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(110));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "28".equals(mode)) {
            mode="29";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(210));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(310));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "29".equals(mode)) {
            mode="30";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(410));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(510));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "30".equals(mode)) {
            mode="31";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(11));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(111));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "31".equals(mode)) {
            mode="32";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(211));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(311));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "32".equals(mode)) {
            mode="33";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(411));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(511));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "33".equals(mode)) {
            mode="34";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(12));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(112));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "34".equals(mode)) {
            mode="35";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(212));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(312));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "35".equals(mode)) {
            mode="36";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(412));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(512));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "36".equals(mode)) {
            mode="37";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(13));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(113));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "37".equals(mode)) {
            mode="38";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(213));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(313));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "38".equals(mode)) {
            mode="39";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(413));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(513));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "39".equals(mode)) {
            mode="40";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(14));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(114));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "40".equals(mode)) {
            mode="41";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(214));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(314));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "41".equals(mode)) {
            mode="42";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(414));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(514));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "42".equals(mode)) {
            mode="43";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(15));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(115));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "43".equals(mode)) {
            mode="44";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(215));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(315));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "44".equals(mode)) {
            mode="45";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(415));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(515));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "45".equals(mode)) {
            mode="46";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(16));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(116));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "46".equals(mode)) {
            mode="47";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(216));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(316));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "47".equals(mode)) {
            mode="48";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(416));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(516));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "48".equals(mode)) {
            mode="49";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(17));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(117));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "49".equals(mode)) {
            mode="50";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(217));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(317));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "50".equals(mode)) {
            mode="51";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(417));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(517));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "51".equals(mode)) {
            mode="52";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(18));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(118));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "52".equals(mode)) {
            mode="53";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(218));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(318));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "53".equals(mode)) {
            mode="54";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(418));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(518));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "54".equals(mode)) {
            mode="55";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(19));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(119));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "55".equals(mode)) {
            mode="56";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(219));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(319));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "56".equals(mode)) {
            mode="57";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(419));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(519));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "57".equals(mode)) {
            mode="58";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(20));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(120));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "58".equals(mode)) {
            mode="59";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(220));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(320));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "59".equals(mode)) {
            mode="60";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(420));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(520));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "60".equals(mode)) {
            mode="61";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(21));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(121));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "61".equals(mode)) {
            mode="62";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(221));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(321));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "62".equals(mode)) {
            mode="63";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(421));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(521));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "63".equals(mode)) {
            mode="64";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(22));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(122));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "64".equals(mode)) {
            mode="65";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(222));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(322));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "65".equals(mode)) {
            mode="66";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(422));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(522));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "66".equals(mode)) {
            mode="67";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(23));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(123));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "67".equals(mode)) {
            mode="68";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(223));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(323));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "68".equals(mode)) {
            mode="69";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(423));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(523));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "69".equals(mode)) {
            mode="70";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(24));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(124));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "70".equals(mode)) {
            mode="71";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(224));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(324));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "71".equals(mode)) {
            mode="72";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(424));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(524));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "72".equals(mode)) {
            mode="73";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(25));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(125));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "73".equals(mode)) {
            mode="74";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(225));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(325));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "74".equals(mode)) {
            mode="75";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(425));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(525));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "75".equals(mode)) {
            mode="76";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(26));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(126));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "76".equals(mode)) {
            mode="77";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(226));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(326));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "77".equals(mode)) {
            mode="78";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(426));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(526));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "78".equals(mode)) {
            mode="79";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(27));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(127));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "79".equals(mode)) {
            mode="80";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(227));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(327));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "80".equals(mode)) {
            mode="81";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(427));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(527));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "81".equals(mode)) {
            mode="82";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(28));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(128));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "82".equals(mode)) {
            mode="83";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(228));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(328));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "83".equals(mode)) {
            mode="84";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(428));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(528));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "84".equals(mode)) {
            mode="85";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(29));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(129));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "85".equals(mode)) {
            mode="86";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(229));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(329));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "86".equals(mode)) {
            mode="87";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(429));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(529));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "87".equals(mode)) {
            mode="88";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(30));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(130));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "88".equals(mode)) {
            mode="89";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(230));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(330));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "89".equals(mode)) {
            mode="90";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(430));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(530));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "90".equals(mode)) {
            mode="91";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(31));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(131));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "91".equals(mode)) {
            mode="92";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(231));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(331));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "92".equals(mode)) {
            mode="93";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(431));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(531));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "93".equals(mode)) {
            mode="94";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(32));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(132));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "94".equals(mode)) {
            mode="95";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(232));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(332));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "95".equals(mode)) {
            mode="96";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(432));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(532));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "96".equals(mode)) {
            mode="97";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(33));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(133));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "97".equals(mode)) {
            mode="98";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(233));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(333));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "98".equals(mode)) {
            mode="99";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(433));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(533));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "99".equals(mode)) {
            mode="100";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(34));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(134));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "100".equals(mode)) {
            mode="101";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(234));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(334));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "101".equals(mode)) {
            mode="102";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(434));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(534));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "102".equals(mode)) {
            mode="103";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(35));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(135));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "103".equals(mode)) {
            mode="104";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(235));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(335));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "104".equals(mode)) {
            mode="105";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(435));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(535));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "105".equals(mode)) {
            mode="106";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(36));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(136));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "106".equals(mode)) {
            mode="107";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(236));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(336));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "107".equals(mode)) {
            mode="108";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(436));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(536));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "108".equals(mode)) {
            mode="109";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(37));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(137));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "109".equals(mode)) {
            mode="110";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(237));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(337));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "110".equals(mode)) {
            mode="111";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(437));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(537));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "111".equals(mode)) {
            mode="112";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(38));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(138));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "112".equals(mode)) {
            mode="113";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(238));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(338));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "113".equals(mode)) {
            mode="114";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(438));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(538));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "114".equals(mode)) {
            mode="115";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(39));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(139));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "115".equals(mode)) {
            mode="116";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(239));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(339));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "116".equals(mode)) {
            mode="117";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(439));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(539));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "117".equals(mode)) {
            mode="118";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(40));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(140));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "118".equals(mode)) {
            mode="119";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(240));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(340));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "119".equals(mode)) {
            mode="120";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(440));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(540));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "120".equals(mode)) {
            mode="121";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(41));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(141));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "121".equals(mode)) {
            mode="122";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(241));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(341));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "122".equals(mode)) {
            mode="123";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(441));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(541));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "123".equals(mode)) {
            mode="124";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(42));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(142));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "124".equals(mode)) {
            mode="125";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(242));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(342));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "125".equals(mode)) {
            mode="126";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(442));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(542));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "126".equals(mode)) {
            mode="127";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(43));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(143));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "127".equals(mode)) {
            mode="128";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(243));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(343));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "128".equals(mode)) {
            mode="129";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(443));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(543));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "129".equals(mode)) {
            mode="130";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(44));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(144));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "130".equals(mode)) {
            mode="131";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(244));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(344));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "131".equals(mode)) {
            mode="132";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(444));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(544));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "132".equals(mode)) {
            mode="133";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(45));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(145));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "133".equals(mode)) {
            mode="134";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(245));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(345));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "134".equals(mode)) {
            mode="135";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(445));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(545));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "135".equals(mode)) {
            mode="136";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(46));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(146));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "136".equals(mode)) {
            mode="137";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(246));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(346));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "137".equals(mode)) {
            mode="138";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(446));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(546));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "138".equals(mode)) {
            mode="139";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(47));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(147));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "139".equals(mode)) {
            mode="140";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(247));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(347));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "140".equals(mode)) {
            mode="141";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(447));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(547));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "141".equals(mode)) {
            mode="142";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(48));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(148));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "142".equals(mode)) {
            mode="143";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(248));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(348));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "143".equals(mode)) {
            mode="144";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(448));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(548));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "144".equals(mode)) {
            mode="145";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(49));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(149));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "145".equals(mode)) {
            mode="146";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(249));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(349));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "146".equals(mode)) {
            mode="147";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(449));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(549));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "147".equals(mode)) {
            mode="148";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(50));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(150));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "148".equals(mode)) {
            mode="149";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(250));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(350));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "149".equals(mode)) {
            mode="150";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(450));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(550));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "150".equals(mode)) {
            mode="151";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(51));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(151));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "151".equals(mode)) {
            mode="152";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(251));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(351));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "152".equals(mode)) {
            mode="153";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(451));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(551));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "153".equals(mode)) {
            mode="154";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(52));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(152));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "154".equals(mode)) {
            mode="155";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(252));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(352));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "155".equals(mode)) {
            mode="156";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(452));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(552));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "156".equals(mode)) {
            mode="157";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(53));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(153));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "157".equals(mode)) {
            mode="158";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(253));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(353));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "158".equals(mode)) {
            mode="159";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(453));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(553));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "159".equals(mode)) {
            mode="160";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(54));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(154));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "160".equals(mode)) {
            mode="161";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(254));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(354));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "161".equals(mode)) {
            mode="162";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(454));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(554));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "162".equals(mode)) {
            mode="163";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(55));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(155));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "163".equals(mode)) {
            mode="164";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(255));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(355));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "164".equals(mode)) {
            mode="165";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(455));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(555));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "165".equals(mode)) {
            mode="166";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(56));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(156));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "166".equals(mode)) {
            mode="167";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(256));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(356));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "167".equals(mode)) {
            mode="168";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(456));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(556));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "168".equals(mode)) {
            mode="169";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(57));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(157));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "169".equals(mode)) {
            mode="170";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(257));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(357));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "170".equals(mode)) {
            mode="171";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(457));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(557));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "171".equals(mode)) {
            mode="172";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(58));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(158));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "172".equals(mode)) {
            mode="173";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(258));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(358));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "173".equals(mode)) {
            mode="174";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(458));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(558));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "174".equals(mode)) {
            mode="175";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(59));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(159));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "175".equals(mode)) {
            mode="176";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(259));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(359));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "176".equals(mode)) {
            mode="177";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(459));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(559));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "177".equals(mode)) {
            mode="178";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(60));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(160));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "178".equals(mode)) {
            mode="179";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(260));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(360));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "179".equals(mode)) {
            mode="180";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(460));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(560));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "180".equals(mode)) {
            mode="181";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(61));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(161));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "181".equals(mode)) {
            mode="182";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(261));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(361));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "182".equals(mode)) {
            mode="183";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(461));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(561));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "183".equals(mode)) {
            mode="184";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(62));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(162));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "184".equals(mode)) {
            mode="185";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(262));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(362));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "185".equals(mode)) {
            mode="186";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(462));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(562));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "186".equals(mode)) {
            mode="187";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(63));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(163));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "187".equals(mode)) {
            mode="188";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(263));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(363));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "188".equals(mode)) {
            mode="189";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(463));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(563));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "189".equals(mode)) {
            mode="190";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(64));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(164));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "190".equals(mode)) {
            mode="191";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(264));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(364));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "191".equals(mode)) {
            mode="192";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(464));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(564));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "192".equals(mode)) {
            mode="193";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(65));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(165));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "193".equals(mode)) {
            mode="194";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(265));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(365));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "194".equals(mode)) {
            mode="195";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(465));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(565));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "195".equals(mode)) {
            mode="196";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(66));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(166));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "196".equals(mode)) {
            mode="197";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(266));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(366));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "197".equals(mode)) {
            mode="198";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(466));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(566));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "198".equals(mode)) {
            mode="199";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(67));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(167));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "199".equals(mode)) {
            mode="200";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(267));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(367));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "200".equals(mode)) {
            mode="201";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(467));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(567));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "201".equals(mode)) {
            mode="202";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(68));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(168));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "202".equals(mode)) {
            mode="203";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(268));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(368));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "203".equals(mode)) {
            mode="204";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(468));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(568));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "204".equals(mode)) {
            mode="205";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(69));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(169));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "205".equals(mode)) {
            mode="206";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(269));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(369));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "206".equals(mode)) {
            mode="207";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(469));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(569));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "207".equals(mode)) {
            mode="208";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(70));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(170));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "208".equals(mode)) {
            mode="209";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(270));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(370));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "209".equals(mode)) {
            mode="210";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(470));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(570));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "210".equals(mode)) {
            mode="211";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(71));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(171));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "211".equals(mode)) {
            mode="212";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(271));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(371));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "212".equals(mode)) {
            mode="213";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(471));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(571));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "213".equals(mode)) {
            mode="214";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(72));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(172));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "214".equals(mode)) {
            mode="215";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(272));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(372));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "215".equals(mode)) {
            mode="216";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(472));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(572));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "216".equals(mode)) {
            mode="217";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(73));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(173));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "217".equals(mode)) {
            mode="218";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(273));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(373));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "218".equals(mode)) {
            mode="219";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(473));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(573));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "219".equals(mode)) {
            mode="220";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(74));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(174));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "220".equals(mode)) {
            mode="221";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(274));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(374));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "221".equals(mode)) {
            mode="222";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(474));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(574));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "222".equals(mode)) {
            mode="223";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(75));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(175));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "223".equals(mode)) {
            mode="224";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(275));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(375));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "224".equals(mode)) {
            mode="225";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(475));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(575));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "225".equals(mode)) {
            mode="226";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(76));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(176));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "226".equals(mode)) {
            mode="227";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(276));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(376));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "227".equals(mode)) {
            mode="228";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(476));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(576));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "228".equals(mode)) {
            mode="229";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(77));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(177));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "229".equals(mode)) {
            mode="230";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(277));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(377));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "230".equals(mode)) {
            mode="231";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(477));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(577));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "231".equals(mode)) {
            mode="232";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(78));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(178));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "232".equals(mode)) {
            mode="233";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(278));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(378));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "233".equals(mode)) {
            mode="234";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(478));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(578));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "234".equals(mode)) {
            mode="235";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(79));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(179));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "235".equals(mode)) {
            mode="236";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(279));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(379));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "236".equals(mode)) {
            mode="237";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(479));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(579));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "237".equals(mode)) {
            mode="238";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(80));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(180));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "238".equals(mode)) {
            mode="239";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(280));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(380));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "239".equals(mode)) {
            mode="240";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(480));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(580));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "240".equals(mode)) {
            mode="241";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(81));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(181));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "241".equals(mode)) {
            mode="242";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(281));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(381));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "242".equals(mode)) {
            mode="243";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(481));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(581));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "243".equals(mode)) {
            mode="244";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(82));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(182));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "244".equals(mode)) {
            mode="245";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(282));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(382));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "245".equals(mode)) {
            mode="246";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(482));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(582));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "246".equals(mode)) {
            mode="247";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(83));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(183));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "247".equals(mode)) {
            mode="248";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(283));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(383));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "248".equals(mode)) {
            mode="249";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(483));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(583));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "249".equals(mode)) {
            mode="250";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(84));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(184));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "250".equals(mode)) {
            mode="251";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(284));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(384));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "251".equals(mode)) {
            mode="252";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(484));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(584));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "252".equals(mode)) {
            mode="253";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(85));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(185));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "253".equals(mode)) {
            mode="254";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(285));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(385));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "254".equals(mode)) {
            mode="255";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(485));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(585));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "255".equals(mode)) {
            mode="256";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(86));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(186));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "256".equals(mode)) {
            mode="257";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(286));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(386));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "257".equals(mode)) {
            mode="258";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(486));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(586));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "258".equals(mode)) {
            mode="259";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(87));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(187));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "259".equals(mode)) {
            mode="260";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(287));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(387));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "260".equals(mode)) {
            mode="261";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(487));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(587));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "261".equals(mode)) {
            mode="262";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(88));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(188));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "262".equals(mode)) {
            mode="263";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(288));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(388));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "263".equals(mode)) {
            mode="264";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(488));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(588));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "264".equals(mode)) {
            mode="265";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(89));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(189));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "265".equals(mode)) {
            mode="266";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(289));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(389));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "266".equals(mode)) {
            mode="267";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(489));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(589));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "267".equals(mode)) {
            mode="268";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(90));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(190));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "268".equals(mode)) {
            mode="269";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(290));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(390));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "269".equals(mode)) {
            mode="270";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(490));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(590));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "270".equals(mode)) {
            mode="271";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(91));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(191));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "271".equals(mode)) {
            mode="272";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(291));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(391));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "272".equals(mode)) {
            mode="273";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(491));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(591));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "273".equals(mode)) {
            mode="274";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(92));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(192));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "274".equals(mode)) {
            mode="275";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(292));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(392));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "275".equals(mode)) {
            mode="276";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(492));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(592));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "276".equals(mode)) {
            mode="277";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(93));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(193));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "277".equals(mode)) {
            mode="278";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(293));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(393));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "278".equals(mode)) {
            mode="279";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(493));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(593));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "279".equals(mode)) {
            mode="280";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(94));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(194));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "280".equals(mode)) {
            mode="281";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(294));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(394));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "281".equals(mode)) {
            mode="282";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(494));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(594));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "282".equals(mode)) {
            mode="283";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(95));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(195));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "283".equals(mode)) {
            mode="284";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(295));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(395));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "284".equals(mode)) {
            mode="285";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(495));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(595));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "285".equals(mode)) {
            mode="286";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(96));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(196));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "286".equals(mode)) {
            mode="287";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(296));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(396));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "287".equals(mode)) {
            mode="288";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(496));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(596));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "288".equals(mode)) {
            mode="289";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(97));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(197));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "289".equals(mode)) {
            mode="290";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(297));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(397));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "290".equals(mode)) {
            mode="291";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(497));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(597));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "291".equals(mode)) {
            mode="292";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(98));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(198));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "292".equals(mode)) {
            mode="293";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(298));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(398));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "293".equals(mode)) {
            mode="294";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(498));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(598));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "294".equals(mode)) {
            mode="295";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(99));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(199));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "295".equals(mode)) {
            mode="296";
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(299));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(399));
            return calcHkShrKngkBean;
        }
        else if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN) && "296".equals(mode)) {
            mode=null;
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(499));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(599));
            return calcHkShrKngkBean;
        }
        else if (caller == SiSiharaiKingakuKeisanTest_exec.class) {
            if (TESTPATTERN2.equals(SYORIPTN)) {
                calcHkShrKngkBean.setKihons(BizCurrency.valueOf(11000000L,BizCurrencyTypes.DOLLAR));
                calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(12000000L,BizCurrencyTypes.DOLLAR));
                calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(13000000L,BizCurrencyTypes.DOLLAR));
                calcHkShrKngkBean.setHokenryoustGk(BizCurrency.valueOf(14000000L,BizCurrencyTypes.DOLLAR));
                calcHkShrKngkBean.setSibousGk(BizCurrency.valueOf(15000000L,BizCurrencyTypes.DOLLAR));
                calcHkShrKngkBean.setSaigaisGk(BizCurrency.valueOf(16000000L,BizCurrencyTypes.DOLLAR));
                calcHkShrKngkBean.setHokenknGk(BizCurrency.valueOf(17000000L,BizCurrencyTypes.DOLLAR));
                calcHkShrKngkBean.setHknKknKbn(C_HknKknKbn.DAI1HKNKKN);
                calcHkShrKngkBean.setTeirituTmttkngk(BizCurrency.valueOf(18000000L,BizCurrencyTypes.DOLLAR));
                calcHkShrKngkBean.setSisuurendouTmttkngk(BizCurrency.valueOf(19000000L,BizCurrencyTypes.DOLLAR));
                calcHkShrKngkBean.setSbymdKaiyakuhenreiknGk(BizCurrency.valueOf(11100000L,BizCurrencyTypes.DOLLAR));
                calcHkShrKngkBean.setSbymdTmttKnGk(BizCurrency.valueOf(11200000L,BizCurrencyTypes.DOLLAR));
                calcHkShrKngkBean.setPruikei(BizCurrency.valueOf(0,BizCurrencyTypes.DOLLAR));
                return calcHkShrKngkBean;
            } else if (TESTPATTERN3.equals(SYORIPTN)) {
                if (mode == null) {
                    mode = "1";
                    calcHkShrKngkBean.setKihons(BizCurrency.valueOf(18000000L,BizCurrencyTypes.DOLLAR));
                    calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(12000000L,BizCurrencyTypes.DOLLAR));
                    calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(13000000L,BizCurrencyTypes.DOLLAR));
                    calcHkShrKngkBean.setHokenryoustGk(BizCurrency.valueOf(17000000L,BizCurrencyTypes.DOLLAR));
                    calcHkShrKngkBean.setSibousGk(BizCurrency.valueOf(17000000L,BizCurrencyTypes.DOLLAR));
                    calcHkShrKngkBean.setSaigaisGk(BizCurrency.valueOf(18000000L,BizCurrencyTypes.DOLLAR));
                    calcHkShrKngkBean.setHokenknGk(BizCurrency.valueOf(17000000L,BizCurrencyTypes.DOLLAR));
                    calcHkShrKngkBean.setHknKknKbn(C_HknKknKbn.DAI1HKNKKN);
                    calcHkShrKngkBean.setTeirituTmttkngk(BizCurrency.valueOf(18000000L,BizCurrencyTypes.DOLLAR));
                    calcHkShrKngkBean.setSisuurendouTmttkngk(BizCurrency.valueOf(19000000L,BizCurrencyTypes.DOLLAR));
                    calcHkShrKngkBean.setSbymdKaiyakuhenreiknGk(BizCurrency.valueOf(11100000L,BizCurrencyTypes.DOLLAR));
                    calcHkShrKngkBean.setSbymdTmttKnGk(BizCurrency.valueOf(11200000L,BizCurrencyTypes.DOLLAR));
                    calcHkShrKngkBean.setPruikei(BizCurrency.valueOf(0,BizCurrencyTypes.DOLLAR));
                    return calcHkShrKngkBean;
                } else if ("1".equals(mode)) {
                    calcHkShrKngkBean.setKihons(BizCurrency.valueOf(18000000L,BizCurrencyTypes.DOLLAR));
                    calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(12000000L,BizCurrencyTypes.DOLLAR));
                    calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(13000000L,BizCurrencyTypes.DOLLAR));
                    calcHkShrKngkBean.setHokenryoustGk(BizCurrency.valueOf(17000000L,BizCurrencyTypes.DOLLAR));
                    calcHkShrKngkBean.setSibousGk(BizCurrency.valueOf(17000000L,BizCurrencyTypes.DOLLAR));
                    calcHkShrKngkBean.setSaigaisGk(BizCurrency.valueOf(18000000L,BizCurrencyTypes.DOLLAR));
                    calcHkShrKngkBean.setHokenknGk(BizCurrency.valueOf(0,BizCurrencyTypes.DOLLAR));
                    calcHkShrKngkBean.setHknKknKbn(C_HknKknKbn.DAI1HKNKKN);
                    calcHkShrKngkBean.setTeirituTmttkngk(BizCurrency.valueOf(18000000L,BizCurrencyTypes.DOLLAR));
                    calcHkShrKngkBean.setSisuurendouTmttkngk(BizCurrency.valueOf(19000000L,BizCurrencyTypes.DOLLAR));
                    calcHkShrKngkBean.setSbymdKaiyakuhenreiknGk(BizCurrency.valueOf(11100000L,BizCurrencyTypes.DOLLAR));
                    calcHkShrKngkBean.setSbymdTmttKnGk(BizCurrency.valueOf(11200000L,BizCurrencyTypes.DOLLAR));
                    calcHkShrKngkBean.setPruikei(BizCurrency.valueOf(0,BizCurrencyTypes.DOLLAR));
                    return calcHkShrKngkBean;
                }
            } else if (TESTPATTERN4.equals(SYORIPTN)) {
                if (mode == null) {
                    mode = "1";
                    calcHkShrKngkBean.setKihons(BizCurrency.valueOf(18000000L,BizCurrencyTypes.DOLLAR));
                    calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(12000000L,BizCurrencyTypes.DOLLAR));
                    calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(13000000L,BizCurrencyTypes.DOLLAR));
                    calcHkShrKngkBean.setHokenryoustGk(BizCurrency.valueOf(17000000L,BizCurrencyTypes.DOLLAR));
                    calcHkShrKngkBean.setSibousGk(BizCurrency.valueOf(17000000L,BizCurrencyTypes.DOLLAR));
                    calcHkShrKngkBean.setSaigaisGk(BizCurrency.valueOf(18000000L,BizCurrencyTypes.DOLLAR));
                    calcHkShrKngkBean.setHokenknGk(BizCurrency.valueOf(0,BizCurrencyTypes.DOLLAR));
                    calcHkShrKngkBean.setHknKknKbn(C_HknKknKbn.DAI1HKNKKN);
                    calcHkShrKngkBean.setTeirituTmttkngk(BizCurrency.valueOf(18000000L,BizCurrencyTypes.DOLLAR));
                    calcHkShrKngkBean.setSisuurendouTmttkngk(BizCurrency.valueOf(19000000L,BizCurrencyTypes.DOLLAR));
                    calcHkShrKngkBean.setSbymdKaiyakuhenreiknGk(BizCurrency.valueOf(11100000L,BizCurrencyTypes.DOLLAR));
                    calcHkShrKngkBean.setSbymdTmttKnGk(BizCurrency.valueOf(11200000L,BizCurrencyTypes.DOLLAR));
                    calcHkShrKngkBean.setPruikei(BizCurrency.valueOf(0,BizCurrencyTypes.DOLLAR));
                    return calcHkShrKngkBean;
                } else if ("1".equals(mode)) {
                    calcHkShrKngkBean.setKihons(BizCurrency.valueOf(18000000L,BizCurrencyTypes.DOLLAR));
                    calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(12000000L,BizCurrencyTypes.DOLLAR));
                    calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(13000000L,BizCurrencyTypes.DOLLAR));
                    calcHkShrKngkBean.setHokenryoustGk(BizCurrency.valueOf(17000000L,BizCurrencyTypes.DOLLAR));
                    calcHkShrKngkBean.setSibousGk(BizCurrency.valueOf(17000000L,BizCurrencyTypes.DOLLAR));
                    calcHkShrKngkBean.setSaigaisGk(BizCurrency.valueOf(18000000L,BizCurrencyTypes.DOLLAR));
                    calcHkShrKngkBean.setHokenknGk(BizCurrency.valueOf(18000000L,BizCurrencyTypes.DOLLAR));
                    calcHkShrKngkBean.setHknKknKbn(C_HknKknKbn.DAI1HKNKKN);
                    calcHkShrKngkBean.setTeirituTmttkngk(BizCurrency.valueOf(18000000L,BizCurrencyTypes.DOLLAR));
                    calcHkShrKngkBean.setSisuurendouTmttkngk(BizCurrency.valueOf(19000000L,BizCurrencyTypes.DOLLAR));
                    calcHkShrKngkBean.setSbymdKaiyakuhenreiknGk(BizCurrency.valueOf(11100000L,BizCurrencyTypes.DOLLAR));
                    calcHkShrKngkBean.setSbymdTmttKnGk(BizCurrency.valueOf(11200000L,BizCurrencyTypes.DOLLAR));
                    calcHkShrKngkBean.setPruikei(BizCurrency.valueOf(0,BizCurrencyTypes.DOLLAR));
                    return calcHkShrKngkBean;
                }
            }  else if (TESTPATTERN5.equals(SYORIPTN)) {
                if (mode == null) {
                    mode = "1";
                    calcHkShrKngkBean.setKihons(BizCurrency.valueOf(18000000L,BizCurrencyTypes.DOLLAR));
                    calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(12000000L,BizCurrencyTypes.DOLLAR));
                    calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(13000000L,BizCurrencyTypes.DOLLAR));
                    calcHkShrKngkBean.setHokenryoustGk(BizCurrency.valueOf(17000000L,BizCurrencyTypes.DOLLAR));
                    calcHkShrKngkBean.setSibousGk(BizCurrency.valueOf(17000000L,BizCurrencyTypes.DOLLAR));
                    calcHkShrKngkBean.setSaigaisGk(BizCurrency.valueOf(18000000L,BizCurrencyTypes.DOLLAR));
                    calcHkShrKngkBean.setHokenknGk(BizCurrency.valueOf(17000000L,BizCurrencyTypes.DOLLAR));
                    calcHkShrKngkBean.setHknKknKbn(C_HknKknKbn.DAI2HKNKKN);
                    calcHkShrKngkBean.setTeirituTmttkngk(BizCurrency.valueOf(18000000L,BizCurrencyTypes.DOLLAR));
                    calcHkShrKngkBean.setSisuurendouTmttkngk(BizCurrency.valueOf(19000000L,BizCurrencyTypes.DOLLAR));
                    calcHkShrKngkBean.setSbymdKaiyakuhenreiknGk(BizCurrency.valueOf(11100000L,BizCurrencyTypes.DOLLAR));
                    calcHkShrKngkBean.setSbymdTmttKnGk(BizCurrency.valueOf(11200000L,BizCurrencyTypes.DOLLAR));
                    calcHkShrKngkBean.setPruikei(BizCurrency.valueOf(0,BizCurrencyTypes.DOLLAR));
                    return calcHkShrKngkBean;
                } else if ("1".equals(mode)) {
                    calcHkShrKngkBean.setKihons(BizCurrency.valueOf(18000000L,BizCurrencyTypes.DOLLAR));
                    calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(12000000L,BizCurrencyTypes.DOLLAR));
                    calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(13000000L,BizCurrencyTypes.DOLLAR));
                    calcHkShrKngkBean.setHokenryoustGk(BizCurrency.valueOf(17000000L,BizCurrencyTypes.DOLLAR));
                    calcHkShrKngkBean.setSibousGk(BizCurrency.valueOf(17000000L,BizCurrencyTypes.DOLLAR));
                    calcHkShrKngkBean.setSaigaisGk(BizCurrency.valueOf(18000000L,BizCurrencyTypes.DOLLAR));
                    calcHkShrKngkBean.setHokenknGk(BizCurrency.valueOf(0,BizCurrencyTypes.DOLLAR));
                    calcHkShrKngkBean.setHknKknKbn(C_HknKknKbn.DAI2HKNKKN);
                    calcHkShrKngkBean.setTeirituTmttkngk(BizCurrency.valueOf(18000000L,BizCurrencyTypes.DOLLAR));
                    calcHkShrKngkBean.setSisuurendouTmttkngk(BizCurrency.valueOf(19000000L,BizCurrencyTypes.DOLLAR));
                    calcHkShrKngkBean.setSbymdKaiyakuhenreiknGk(BizCurrency.valueOf(11100000L,BizCurrencyTypes.DOLLAR));
                    calcHkShrKngkBean.setSbymdTmttKnGk(BizCurrency.valueOf(11200000L,BizCurrencyTypes.DOLLAR));
                    calcHkShrKngkBean.setPruikei(BizCurrency.valueOf(0,BizCurrencyTypes.DOLLAR));
                    return calcHkShrKngkBean;
                }
            }  else if (TESTPATTERN6.equals(SYORIPTN)) {
                if (mode == null) {
                    mode = "1";
                    calcHkShrKngkBean.setKihons(BizCurrency.valueOf(18000000L,BizCurrencyTypes.DOLLAR));
                    calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(12000000L,BizCurrencyTypes.DOLLAR));
                    calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(13000000L,BizCurrencyTypes.DOLLAR));
                    calcHkShrKngkBean.setHokenryoustGk(BizCurrency.valueOf(17000000L,BizCurrencyTypes.DOLLAR));
                    calcHkShrKngkBean.setSibousGk(BizCurrency.valueOf(17000000L,BizCurrencyTypes.DOLLAR));
                    calcHkShrKngkBean.setSaigaisGk(BizCurrency.valueOf(18000000L,BizCurrencyTypes.DOLLAR));
                    calcHkShrKngkBean.setHokenknGk(BizCurrency.valueOf(17000000L,BizCurrencyTypes.DOLLAR));
                    calcHkShrKngkBean.setHknKknKbn(C_HknKknKbn.DAI3HKNKKN);
                    calcHkShrKngkBean.setTeirituTmttkngk(BizCurrency.valueOf(18000000L,BizCurrencyTypes.DOLLAR));
                    calcHkShrKngkBean.setSisuurendouTmttkngk(BizCurrency.valueOf(19000000L,BizCurrencyTypes.DOLLAR));
                    calcHkShrKngkBean.setSbymdKaiyakuhenreiknGk(BizCurrency.valueOf(11100000L,BizCurrencyTypes.DOLLAR));
                    calcHkShrKngkBean.setSbymdTmttKnGk(BizCurrency.valueOf(11200000L,BizCurrencyTypes.DOLLAR));
                    calcHkShrKngkBean.setPruikei(BizCurrency.valueOf(0,BizCurrencyTypes.DOLLAR));
                    return calcHkShrKngkBean;
                } else if ("1".equals(mode)) {
                    calcHkShrKngkBean.setKihons(BizCurrency.valueOf(18000000L,BizCurrencyTypes.DOLLAR));
                    calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(12000000L,BizCurrencyTypes.DOLLAR));
                    calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(13000000L,BizCurrencyTypes.DOLLAR));
                    calcHkShrKngkBean.setHokenryoustGk(BizCurrency.valueOf(17000000L,BizCurrencyTypes.DOLLAR));
                    calcHkShrKngkBean.setSibousGk(BizCurrency.valueOf(17000000L,BizCurrencyTypes.DOLLAR));
                    calcHkShrKngkBean.setSaigaisGk(BizCurrency.valueOf(18000000L,BizCurrencyTypes.DOLLAR));
                    calcHkShrKngkBean.setHokenknGk(BizCurrency.valueOf(0,BizCurrencyTypes.DOLLAR));
                    calcHkShrKngkBean.setHknKknKbn(C_HknKknKbn.DAI3HKNKKN);
                    calcHkShrKngkBean.setTeirituTmttkngk(BizCurrency.valueOf(18000000L,BizCurrencyTypes.DOLLAR));
                    calcHkShrKngkBean.setSisuurendouTmttkngk(BizCurrency.valueOf(19000000L,BizCurrencyTypes.DOLLAR));
                    calcHkShrKngkBean.setSbymdKaiyakuhenreiknGk(BizCurrency.valueOf(11100000L,BizCurrencyTypes.DOLLAR));
                    calcHkShrKngkBean.setSbymdTmttKnGk(BizCurrency.valueOf(11200000L,BizCurrencyTypes.DOLLAR));
                    calcHkShrKngkBean.setPruikei(BizCurrency.valueOf(0,BizCurrencyTypes.DOLLAR));
                    return calcHkShrKngkBean;
                }
            } else if (TESTPATTERN7.equals(SYORIPTN)) {
                calcHkShrKngkBean.setKihons(BizCurrency.valueOf(21000000L,BizCurrencyTypes.YEN));
                calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(22000000L,BizCurrencyTypes.YEN));
                calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(23000000L,BizCurrencyTypes.YEN));
                calcHkShrKngkBean.setHokenryoustGk(BizCurrency.valueOf(24000000L,BizCurrencyTypes.YEN));
                calcHkShrKngkBean.setSibousGk(BizCurrency.valueOf(25000000L,BizCurrencyTypes.YEN));
                calcHkShrKngkBean.setSaigaisGk(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
                calcHkShrKngkBean.setHokenknGk(BizCurrency.valueOf(27000000L,BizCurrencyTypes.YEN));
                calcHkShrKngkBean.setHknKknKbn(C_HknKknKbn.BLNK);
                calcHkShrKngkBean.setTeirituTmttkngk(BizCurrency.valueOf(28000000L,BizCurrencyTypes.YEN));
                calcHkShrKngkBean.setSisuurendouTmttkngk(BizCurrency.valueOf(29000000L,BizCurrencyTypes.YEN));
                calcHkShrKngkBean.setSbymdKaiyakuhenreiknGk(BizCurrency.valueOf(21100000L,BizCurrencyTypes.YEN));
                calcHkShrKngkBean.setSbymdTmttKnGk(BizCurrency.valueOf(21200000L,BizCurrencyTypes.YEN));
                calcHkShrKngkBean.setPruikei(BizCurrency.valueOf(0,BizCurrencyTypes.YEN));
                return calcHkShrKngkBean;
            } else if (TESTPATTERN8.equals(SYORIPTN)) {
                calcHkShrKngkBean.setKihons(BizCurrency.valueOf(18000000L,BizCurrencyTypes.DOLLAR));
                calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(12000000L,BizCurrencyTypes.DOLLAR));
                calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(13000000L,BizCurrencyTypes.DOLLAR));
                calcHkShrKngkBean.setHokenryoustGk(BizCurrency.valueOf(17000000L,BizCurrencyTypes.DOLLAR));
                calcHkShrKngkBean.setSibousGk(BizCurrency.valueOf(13000000L,BizCurrencyTypes.DOLLAR));
                calcHkShrKngkBean.setSaigaisGk(BizCurrency.valueOf(0,BizCurrencyTypes.DOLLAR));
                calcHkShrKngkBean.setHokenknGk(BizCurrency.valueOf(13000000L,BizCurrencyTypes.DOLLAR));
                calcHkShrKngkBean.setHknKknKbn(C_HknKknKbn.BLNK);
                calcHkShrKngkBean.setTeirituTmttkngk(BizCurrency.valueOf(12000000L,BizCurrencyTypes.DOLLAR));
                calcHkShrKngkBean.setSisuurendouTmttkngk(BizCurrency.valueOf(13000000L,BizCurrencyTypes.DOLLAR));
                calcHkShrKngkBean.setSbymdKaiyakuhenreiknGk(BizCurrency.valueOf(11100000L,BizCurrencyTypes.DOLLAR));
                calcHkShrKngkBean.setSbymdTmttKnGk(BizCurrency.valueOf(11200000L,BizCurrencyTypes.DOLLAR));
                calcHkShrKngkBean.setPruikei(BizCurrency.valueOf(0,BizCurrencyTypes.DOLLAR));
                return calcHkShrKngkBean;
            } else if (TESTPATTERN9.equals(SYORIPTN)) {
                calcHkShrKngkBean.setKihons(BizCurrency.valueOf(18000000L,BizCurrencyTypes.DOLLAR));
                calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(12000000L,BizCurrencyTypes.DOLLAR));
                calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(13000000L,BizCurrencyTypes.DOLLAR));
                calcHkShrKngkBean.setHokenryoustGk(BizCurrency.valueOf(17000000L,BizCurrencyTypes.DOLLAR));
                calcHkShrKngkBean.setSibousGk(BizCurrency.valueOf(13000000L,BizCurrencyTypes.DOLLAR));
                calcHkShrKngkBean.setSaigaisGk(BizCurrency.valueOf(0,BizCurrencyTypes.DOLLAR));
                calcHkShrKngkBean.setHokenknGk(BizCurrency.valueOf(13000000L,BizCurrencyTypes.DOLLAR));
                calcHkShrKngkBean.setHknKknKbn(C_HknKknKbn.BLNK);
                calcHkShrKngkBean.setTeirituTmttkngk(BizCurrency.valueOf(12000000L,BizCurrencyTypes.DOLLAR));
                calcHkShrKngkBean.setSisuurendouTmttkngk(BizCurrency.valueOf(13000000L,BizCurrencyTypes.DOLLAR));
                calcHkShrKngkBean.setSbymdKaiyakuhenreiknGk(BizCurrency.valueOf(11100000L,BizCurrencyTypes.DOLLAR));
                calcHkShrKngkBean.setSbymdTmttKnGk(BizCurrency.valueOf(11200000L,BizCurrencyTypes.DOLLAR));
                calcHkShrKngkBean.setPruikei(BizCurrency.valueOf(11300000L,BizCurrencyTypes.DOLLAR));
                return calcHkShrKngkBean;
            } else if (TESTPATTERN10.equals(SYORIPTN)) {
                calcHkShrKngkBean.setKihons(BizCurrency.valueOf(21000000L,BizCurrencyTypes.YEN));
                calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(22000000L,BizCurrencyTypes.YEN));
                calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(23000000L,BizCurrencyTypes.YEN));
                calcHkShrKngkBean.setHokenryoustGk(BizCurrency.valueOf(24000000L,BizCurrencyTypes.YEN));
                calcHkShrKngkBean.setSibousGk(BizCurrency.valueOf(25000000L,BizCurrencyTypes.YEN));
                calcHkShrKngkBean.setSaigaisGk(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
                calcHkShrKngkBean.setHokenknGk(BizCurrency.valueOf(27000000L,BizCurrencyTypes.YEN));
                calcHkShrKngkBean.setHknKknKbn(C_HknKknKbn.BLNK);
                calcHkShrKngkBean.setTeirituTmttkngk(BizCurrency.valueOf(28000000L,BizCurrencyTypes.YEN));
                calcHkShrKngkBean.setSisuurendouTmttkngk(BizCurrency.valueOf(29000000L,BizCurrencyTypes.YEN));
                calcHkShrKngkBean.setSbymdKaiyakuhenreiknGk(BizCurrency.valueOf(21100000L,BizCurrencyTypes.YEN));
                calcHkShrKngkBean.setSbymdTmttKnGk(BizCurrency.valueOf(21200000L,BizCurrencyTypes.YEN));
                calcHkShrKngkBean.setPruikei(BizCurrency.valueOf(0,BizCurrencyTypes.YEN));
                return calcHkShrKngkBean;
            } else if (TESTPATTERN11.equals(SYORIPTN)) {
                if (mode == null) {
                    mode = "1";
                    calcHkShrKngkBean.setKihons(BizCurrency.valueOf(700L,BizCurrencyTypes.DOLLAR));
                    calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(700L,BizCurrencyTypes.DOLLAR));
                    calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(700L,BizCurrencyTypes.DOLLAR));
                    calcHkShrKngkBean.setHokenryoustGk(BizCurrency.valueOf(700L,BizCurrencyTypes.DOLLAR));
                    calcHkShrKngkBean.setSibousGk(BizCurrency.valueOf(700L,BizCurrencyTypes.DOLLAR));
                    calcHkShrKngkBean.setSaigaisGk(BizCurrency.valueOf(700L,BizCurrencyTypes.DOLLAR));
                    calcHkShrKngkBean.setHokenknGk(BizCurrency.valueOf(700L,BizCurrencyTypes.DOLLAR));
                    calcHkShrKngkBean.setHknKknKbn(C_HknKknKbn.DAI1HKNKKN);
                    calcHkShrKngkBean.setTeirituTmttkngk(BizCurrency.valueOf(700L,BizCurrencyTypes.DOLLAR));
                    calcHkShrKngkBean.setSisuurendouTmttkngk(BizCurrency.valueOf(700L,BizCurrencyTypes.DOLLAR));
                    calcHkShrKngkBean.setSbymdKaiyakuhenreiknGk(BizCurrency.valueOf(700L,BizCurrencyTypes.DOLLAR));
                    calcHkShrKngkBean.setSbymdTmttKnGk(BizCurrency.valueOf(700L,BizCurrencyTypes.DOLLAR));
                    calcHkShrKngkBean.setPruikei(BizCurrency.valueOf(0,BizCurrencyTypes.DOLLAR));
                    return calcHkShrKngkBean;
                } else if ("1".equals(mode)) {
                    calcHkShrKngkBean.setKihons(BizCurrency.valueOf(700L,BizCurrencyTypes.DOLLAR));
                    calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(700L,BizCurrencyTypes.DOLLAR));
                    calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(700L,BizCurrencyTypes.DOLLAR));
                    calcHkShrKngkBean.setHokenryoustGk(BizCurrency.valueOf(700L,BizCurrencyTypes.DOLLAR));
                    calcHkShrKngkBean.setSibousGk(BizCurrency.valueOf(700L,BizCurrencyTypes.DOLLAR));
                    calcHkShrKngkBean.setSaigaisGk(BizCurrency.valueOf(700L,BizCurrencyTypes.DOLLAR));
                    calcHkShrKngkBean.setHokenknGk(BizCurrency.valueOf(0,BizCurrencyTypes.DOLLAR));
                    calcHkShrKngkBean.setHknKknKbn(C_HknKknKbn.DAI1HKNKKN);
                    calcHkShrKngkBean.setTeirituTmttkngk(BizCurrency.valueOf(700L,BizCurrencyTypes.DOLLAR));
                    calcHkShrKngkBean.setSisuurendouTmttkngk(BizCurrency.valueOf(700L,BizCurrencyTypes.DOLLAR));
                    calcHkShrKngkBean.setSbymdKaiyakuhenreiknGk(BizCurrency.valueOf(700L,BizCurrencyTypes.DOLLAR));
                    calcHkShrKngkBean.setSbymdTmttKnGk(BizCurrency.valueOf(700L,BizCurrencyTypes.DOLLAR));
                    calcHkShrKngkBean.setPruikei(BizCurrency.valueOf(0,BizCurrencyTypes.DOLLAR));
                    return calcHkShrKngkBean;
                }
            } else if (TESTPATTERN12.equals(SYORIPTN)) {
                calcHkShrKngkBean.setKihons(BizCurrency.valueOf(990000L,BizCurrencyTypes.YEN));
                calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(990000L,BizCurrencyTypes.YEN));
                calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(990000L,BizCurrencyTypes.YEN));
                calcHkShrKngkBean.setHokenryoustGk(BizCurrency.valueOf(990000L,BizCurrencyTypes.YEN));
                calcHkShrKngkBean.setSibousGk(BizCurrency.valueOf(990000L,BizCurrencyTypes.YEN));
                calcHkShrKngkBean.setSaigaisGk(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
                calcHkShrKngkBean.setHokenknGk(BizCurrency.valueOf(990000L,BizCurrencyTypes.YEN));
                calcHkShrKngkBean.setHknKknKbn(C_HknKknKbn.BLNK);
                calcHkShrKngkBean.setTeirituTmttkngk(BizCurrency.valueOf(990000L,BizCurrencyTypes.YEN));
                calcHkShrKngkBean.setSisuurendouTmttkngk(BizCurrency.valueOf(990000L,BizCurrencyTypes.YEN));
                calcHkShrKngkBean.setSbymdKaiyakuhenreiknGk(BizCurrency.valueOf(990000L,BizCurrencyTypes.YEN));
                calcHkShrKngkBean.setSbymdTmttKnGk(BizCurrency.valueOf(990000L,BizCurrencyTypes.YEN));
                calcHkShrKngkBean.setPruikei(BizCurrency.valueOf(0,BizCurrencyTypes.YEN));
                return calcHkShrKngkBean;
            }
        }
        else if (caller == HbKeiyakuSyoukaiTest_exec.class) {

            if (TESTPATTERN1.equals(SYORIPTN)) {

                return null;
            }

            if (TESTPATTERN2.equals(SYORIPTN)) {

                calcHkShrKngkBean.setHokenknGk(BizCurrency.valueOf(10000, BizCurrencyTypes.DOLLAR));

                return calcHkShrKngkBean;
            }

            if (TESTPATTERN3.equals(SYORIPTN)) {

                calcHkShrKngkBean.setHokenknGk(BizCurrency.valueOf(10000, BizCurrencyTypes.EURO));

                return calcHkShrKngkBean;
            }
            if (TESTPATTERN4.equals(SYORIPTN)) {

                calcHkShrKngkBean.setHokenknGk(BizCurrency.valueOf(10000, BizCurrencyTypes.AU_DOLLAR));

                return calcHkShrKngkBean;
            }
        }
        else if ((caller == EditSyoukenTblTest_editTBL_A1.class || caller == EditSyoukenTblTest_editTBL_A2.class ||
            caller == EditSyoukenTblTest_editTBL_A3.class || caller == EditSyoukenTblTest_editTBL_A4.class ||
            caller == EditSyoukenTblTest_editTBL_A5.class) && TESTPATTERN1.equals(SYORIPTN)) {
            calcHkShrKngkBean.setSibousGk(BizCurrency.valueOf(10010));
        }
        else if (caller == EditSyoukenTblSyuusinTest_editTBL.class && TESTPATTERN1.equals(SYORIPTN)) {
            calcHkShrKngkBean.setSibousGk(BizCurrency.valueOf(10010));
        }

        else if (caller == DwGetHozenKeiyakuEnItijiSyusinImplTest_execPostForm.class) {
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(20005));
            calcHkShrKngkBean.setSibousGk(BizCurrency.valueOf(10010));
        }
        else if (caller == SetHosyouTest_exec.class) {
            calcHkShrKngkBean.setSibousGk(BizCurrency.valueOf(20001));
            calcHkShrKngkBean.setSaigaisGk(BizCurrency.valueOf(30001));
            calcHkShrKngkBean.setSbymdTmttKnGk(BizCurrency.valueOf(500));
        }

        else if (caller == DwGetHozenKiykGikItijiNnknImplTest_execPostForm.class && TESTPATTERN1.equals(SYORIPTN)) {
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(7777L,BizCurrencyTypes.YEN));
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(5555L,BizCurrencyTypes.YEN));
            calcHkShrKngkBean.setSibousGk(BizCurrency.valueOf(6666L,BizCurrencyTypes.YEN));
            calcHkShrKngkBean.setTeirituTmttkngk(BizCurrency.valueOf(8888L,BizCurrencyTypes.YEN));
            calcHkShrKngkBean.setSisuurendouTmttkngk(BizCurrency.valueOf(9999L,BizCurrencyTypes.YEN));
            return calcHkShrKngkBean;

        }
        else  if (caller == DwGetHozenKiykGikItijiNnknImplTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN)) {
            return calcHkShrKngkBean;
        }

        else if (caller == DwGetHozenKykEnItijiNnknImplTest_execPostForm.class && TESTPATTERN1.equals(SYORIPTN)) {
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(1234L,BizCurrencyTypes.YEN));
            calcHkShrKngkBean.setSibousGk(BizCurrency.valueOf(1234L,BizCurrencyTypes.YEN));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(1234L,BizCurrencyTypes.YEN));
            return calcHkShrKngkBean;
        }
        else  if (caller == DwGetHozenKykEnItijiNnknImplTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN)) {
            return calcHkShrKngkBean;
        }

        else if (caller == DwGetHozenKiykGikHijynNnknImplTest_execPostForm.class && TESTPATTERN1.equals(SYORIPTN)) {
            calcHkShrKngkBean.setSibousGk(BizCurrency.valueOf(100004.00, BizCurrencyTypes.DOLLAR));
            return calcHkShrKngkBean;
        }
        else  if (caller == DwGetHozenKiykGikHijynNnknImplTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN)) {
            return calcHkShrKngkBean;
        }
        else  if (caller == DwGetHozenKiykGikHijynNnknImplTest_execPostForm.class && TESTPATTERN3.equals(SYORIPTN)) {
            calcHkShrKngkBean.setSibousGk(null);
            return calcHkShrKngkBean;
        }

        else if (caller == EditKykNaiyouOsirase1Test_editInfo.class && TESTPATTERN1.equals(SYORIPTN)) {
            calcHkShrKngkBean.setSibousGk(BizCurrency.valueOf(10001L, BizCurrencyTypes.YEN));
            calcHkShrKngkBean.setSaigaisGk(BizCurrency.valueOf(9999L, BizCurrencyTypes.YEN));
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(3333L, BizCurrencyTypes.YEN));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(4444L, BizCurrencyTypes.YEN));
            calcHkShrKngkBean.setHknKknKbn(C_HknKknKbn.DAI1HKNKKN);
            return calcHkShrKngkBean;
        }
        else  if (caller == EditKykNaiyouOsirase1Test_editInfo.class && TESTPATTERN2.equals(SYORIPTN)) {
            calcHkShrKngkBean.setSibousGk(BizCurrency.valueOf(1111L,BizCurrencyTypes.YEN));
            calcHkShrKngkBean.setSaigaisGk(BizCurrency.valueOf(2222L,BizCurrencyTypes.YEN));
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(3333L,BizCurrencyTypes.YEN));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(4444L,BizCurrencyTypes.YEN));
            calcHkShrKngkBean.setHknKknKbn(C_HknKknKbn.DAI2HKNKKN);
            return calcHkShrKngkBean;
        }
        else  if (caller == EditKykNaiyouOsirase1Test_editInfo.class && TESTPATTERN3.equals(SYORIPTN)) {
            calcHkShrKngkBean.setSibousGk(BizCurrency.valueOf(1111L,BizCurrencyTypes.YEN));
            calcHkShrKngkBean.setSaigaisGk(BizCurrency.valueOf(2222L,BizCurrencyTypes.YEN));
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(3333L,BizCurrencyTypes.YEN));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(4444L,BizCurrencyTypes.YEN));
            calcHkShrKngkBean.setHknKknKbn(C_HknKknKbn.DAI3HKNKKN);
            return calcHkShrKngkBean;
        }
        else if (caller == EditKykNaiyouOsirase1Test_editInfo.class && TESTPATTERN5.equals(SYORIPTN)) {
            calcHkShrKngkBean.setSibousGk(BizCurrency.valueOf(9999L, BizCurrencyTypes.YEN));
            calcHkShrKngkBean.setSaigaisGk(BizCurrency.valueOf(10000L, BizCurrencyTypes.YEN));
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(3333L, BizCurrencyTypes.YEN));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(4444L, BizCurrencyTypes.YEN));
            calcHkShrKngkBean.setHknKknKbn(C_HknKknKbn.DAI1HKNKKN);
            return calcHkShrKngkBean;
        }
        else if (caller == EditKykNaiyouOsirase1Test_editInfo.class && TESTPATTERN6.equals(SYORIPTN)) {
            calcHkShrKngkBean.setSibousGk(BizCurrency.valueOf(10000L, BizCurrencyTypes.YEN));
            calcHkShrKngkBean.setSaigaisGk(BizCurrency.valueOf(10001L, BizCurrencyTypes.YEN));
            calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(3333L, BizCurrencyTypes.YEN));
            calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(4444L, BizCurrencyTypes.YEN));
            calcHkShrKngkBean.setHknKknKbn(C_HknKknKbn.DAI1HKNKKN);
            return calcHkShrKngkBean;
        }
        else if (EditKykNaiyouOsirase2Test_editInfo.class == caller) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                calcHkShrKngkBean.setSibousGk(BizCurrency.valueOf(1111L,BizCurrencyTypes.YEN));
                calcHkShrKngkBean.setSaigaisGk(BizCurrency.valueOf(2222L,BizCurrencyTypes.YEN));
                calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(3333L,BizCurrencyTypes.YEN));
                calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(4444L,BizCurrencyTypes.YEN));
                calcHkShrKngkBean.setHknKknKbn(C_HknKknKbn.DAI3HKNKKN);
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                calcHkShrKngkBean.setSibousGk(BizCurrency.valueOf(1111L,BizCurrencyTypes.YEN));
                calcHkShrKngkBean.setSaigaisGk(BizCurrency.valueOf(2222L,BizCurrencyTypes.YEN));
                calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(3333L,BizCurrencyTypes.YEN));
                calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(4444L,BizCurrencyTypes.YEN));
                calcHkShrKngkBean.setHknKknKbn(C_HknKknKbn.DAI3HKNKKN);
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {
                calcHkShrKngkBean.setSibousGk(BizCurrency.valueOf(110,BizCurrencyTypes.DOLLAR));
                calcHkShrKngkBean.setSaigaisGk(BizCurrency.valueOf(220,BizCurrencyTypes.DOLLAR));
                calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(330.6,BizCurrencyTypes.DOLLAR));
                calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(440,BizCurrencyTypes.DOLLAR));
                calcHkShrKngkBean.setHknKknKbn(C_HknKknKbn.DAI3HKNKKN);
            }
            else {
                calcHkShrKngkBean.setSibousGk(BizCurrency.valueOf(11000,BizCurrencyTypes.YEN));
                calcHkShrKngkBean.setSaigaisGk(BizCurrency.valueOf(22000,BizCurrencyTypes.YEN));
                calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(33000,BizCurrencyTypes.YEN));
                calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(44000,BizCurrencyTypes.YEN));
                calcHkShrKngkBean.setHknKknKbn(C_HknKknKbn.DAI3HKNKKN);
            }
            return calcHkShrKngkBean;
        }
        else if (EditKykNaiyouOsirase3Test_editInfo.class == caller) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                calcHkShrKngkBean.setSibousGk(BizCurrency.valueOf(1111L,BizCurrencyTypes.YEN));
                calcHkShrKngkBean.setSaigaisGk(BizCurrency.valueOf(2222L,BizCurrencyTypes.YEN));
                calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(3333L,BizCurrencyTypes.YEN));
                calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(4444L,BizCurrencyTypes.YEN));
                calcHkShrKngkBean.setHknKknKbn(C_HknKknKbn.DAI3HKNKKN);
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                calcHkShrKngkBean.setSibousGk(BizCurrency.valueOf(1111L,BizCurrencyTypes.YEN));
                calcHkShrKngkBean.setSaigaisGk(BizCurrency.valueOf(2222L,BizCurrencyTypes.YEN));
                calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(3333L,BizCurrencyTypes.YEN));
                calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(4444L,BizCurrencyTypes.YEN));
                calcHkShrKngkBean.setHknKknKbn(C_HknKknKbn.DAI3HKNKKN);
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {
                calcHkShrKngkBean.setSibousGk(BizCurrency.valueOf(110,BizCurrencyTypes.DOLLAR));
                calcHkShrKngkBean.setSaigaisGk(BizCurrency.valueOf(220,BizCurrencyTypes.DOLLAR));
                calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(330.6,BizCurrencyTypes.DOLLAR));
                calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(440,BizCurrencyTypes.DOLLAR));
                calcHkShrKngkBean.setHknKknKbn(C_HknKknKbn.DAI3HKNKKN);
            }
            else {
                calcHkShrKngkBean.setSibousGk(BizCurrency.valueOf(11000,BizCurrencyTypes.YEN));
                calcHkShrKngkBean.setSaigaisGk(BizCurrency.valueOf(22000,BizCurrencyTypes.YEN));
                calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(33000,BizCurrencyTypes.YEN));
                calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(44000,BizCurrencyTypes.YEN));
                calcHkShrKngkBean.setHknKknKbn(C_HknKknKbn.DAI3HKNKKN);
            }
            return calcHkShrKngkBean;
        }
        else {
            return super.getCalcHkShrKngkBean();
        }

        return calcHkShrKngkBean;

    }
}
