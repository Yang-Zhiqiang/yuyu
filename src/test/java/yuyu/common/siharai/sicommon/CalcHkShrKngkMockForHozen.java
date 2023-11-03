package yuyu.common.siharai.sicommon;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;
import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.bosyuu.hbkeiyakusyoukai.HbKeiyakuSyoukaiTest_exec;
import yuyu.common.hozen.khcommon.EditKykNaiyouOsirase1Test_editInfo;
import yuyu.common.hozen.khcommon.EditKykNaiyouOsirase2Test_editInfo;
import yuyu.common.hozen.khcommon.EditKykNaiyouOsirase3Test_editInfo;
import yuyu.common.hozen.khcommon.EditKykNaiyouOsirase4Test_editInfo;
import yuyu.common.hozen.khcommon.EditKykNaiyouOsirase5Test_editInfo;
import yuyu.common.hozen.khcommon.EditKykNaiyouOsirase6Test_editInfo;
import yuyu.common.hozen.khcommon.EditKykNaiyouOsirase7Test_editInfo;
import yuyu.common.hozen.khcommon.EditSyoukenTblSyuusin2Test_editTBL;
import yuyu.common.hozen.khcommon.EditSyoukenTblSyuusinTest_editTBL;
import yuyu.common.hozen.renkei.KhGetSyanaiWebHeijyunNenkinInfoTest_getSyouhnInfo;
import yuyu.common.hozen.renkei.KhGetSyanaiWebHeijyunSyuusinInfoTest_getSyouhnInfo;
import yuyu.common.hozen.renkei.KhGetSyanaiWebItijiNenkinInfoTest_getSyouhnInfo;
import yuyu.common.hozen.renkei.KhGetSyanaiWebItijiSyuusinInfoTest_getSyouhnInfo;
import yuyu.common.hozen.renkei.KhGetSyanaiWebKyoutuuInfoTest_exec;
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
public class CalcHkShrKngkMockForHozen extends CalcHkShrKngk {

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
    public C_ErrorKbn exec(String pSyohinCd, Integer pSyouhnsdno, String pRyouritusdNo, BizNumber pYoteiRiritu,
        C_Hrkkaisuu pHaraikomikaisuu, C_HknkknsmnKbn pHknkknsmnKbn, Integer pHknKkn, Integer pHrkKkn, Integer pHhknnen,
        C_Hhknsei pHhknsei, BizCurrency pKihons, BizDate pKykymd, BizDate pCalckijyunymd, String pSyoukenNo,
        C_Tuukasyu pTuukaSyu, Integer pDai1hknKkn, C_SiinKbn pSiinKbn,
        C_HokenkinsyuruiKbn pHokenkinsyuruikbn, BizCurrency pHokenryou,
        BizNumber pKaiyakuSjkTsRitu, BizNumber pKyksjkkktsrrt,
        BizDateYM pTmttkntaisyouYm, BizCurrency pTeiritutmttKngk, BizCurrency pSisuurendoutmttKngk,
        BizNumber pTumitateRiritu, C_HrkkknsmnKbn pHrkkknsmnKbn, BizDateYM pJkipjytYm, BizCurrency pPtmttKngk,
        BizCurrency pKihrkmPStgk, BizDate pFstPryosyuYmd, BizNumber pYoteirrthendohosyuRiritu,
        C_Kykjyoutai pKykJyoutai, BizDate pYendthnkYmd, C_Sdpd pSdpdkbn, C_Hrkkeiro pHrkkeiro) {

        if (caller == HbKeiyakuSyoukaiTest_exec.class) {

            if (TESTPATTERN1.equals(SYORIPTN)) {

                return C_ErrorKbn.ERROR;
            }

            if (TESTPATTERN2.equals(SYORIPTN)) {
                if (BizDateUtil.compareYmd(BizDate.valueOf("20170901"), pCalckijyunymd) == BizDateUtil.COMPARE_EQUAL) {
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

                if (BizDateUtil.compareYmd(pCalckijyunymd, BizDate.valueOf("20170621")) == BizDateUtil.COMPARE_EQUAL) {
                    return C_ErrorKbn.ERROR;
                }

                return C_ErrorKbn.OK;
            }

            if (TESTPATTERN6.equals(SYORIPTN)) {

                return C_ErrorKbn.ERROR;
            }
            return C_ErrorKbn.OK;
        }

        if (caller == EditSyoukenTblSyuusin2Test_editTBL.class) {

            if (TESTPATTERN1.equals(SYORIPTN)) {

                return C_ErrorKbn.OK;
            }
        }

        if (caller == EditSyoukenTblSyuusinTest_editTBL.class) {

            if (TESTPATTERN1.equals(SYORIPTN)) {

                return C_ErrorKbn.OK;
            }
        }

        return super.exec(pSyohinCd, pSyouhnsdno, pRyouritusdNo, pYoteiRiritu, pHaraikomikaisuu, pHknkknsmnKbn,
            pHknKkn, pHrkKkn, pHhknnen, pHhknsei, pKihons, pKykymd, pCalckijyunymd, pSyoukenNo, pTuukaSyu,
            pDai1hknKkn, pSiinKbn, pHokenkinsyuruikbn, pHokenryou, pKaiyakuSjkTsRitu, pKyksjkkktsrrt,
            pTmttkntaisyouYm, pTeiritutmttKngk, pSisuurendoutmttKngk, pTumitateRiritu,
            pHrkkknsmnKbn, pJkipjytYm, pPtmttKngk, pKihrkmPStgk, pFstPryosyuYmd, pYoteirrthendohosyuRiritu,
            pKykJyoutai, pYendthnkYmd, pSdpdkbn, pHrkkeiro);

    }

    @Override
    public C_ErrorKbn execByKeisanWExt(String pSyoNo, BizDate pCalckijyunYmd, C_SiinKbn pSiinKbn,
        C_HokenkinsyuruiKbn pHokenkinsyuruiKbn, C_Sdpd pSdpdkbn, C_Hrkkeiro pHrkkeiro) {

        if (caller == EditKykNaiyouOsirase4Test_editInfo.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                return C_ErrorKbn.ERROR;
            }

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

        else if (caller == EditKykNaiyouOsirase5Test_editInfo.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                return C_ErrorKbn.ERROR;
            }
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

            if (TESTPATTERN6.equals(SYORIPTN)) {
                if (BizDateUtil.compareYmd(BizDate.valueOf("20170901"), pCalckijyunYmd)==BizDateUtil.COMPARE_EQUAL) {
                    return C_ErrorKbn.ERROR;
                }
                return C_ErrorKbn.OK;
            }
            return C_ErrorKbn.OK;
        }

        else if (caller == EditKykNaiyouOsirase1Test_editInfo.class || caller == EditKykNaiyouOsirase6Test_editInfo.class) {
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
            else if (TESTPATTERN5.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
            else if (TESTPATTERN6.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
        }

        if (caller == KhGetSyanaiWebKyoutuuInfoTest_exec.class) {

            if (TESTPATTERN1.equals(SYORIPTN)) {
                return C_ErrorKbn.ERROR;

            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;

            }
        }

        if (caller == KhGetSyanaiWebItijiSyuusinInfoTest_getSyouhnInfo.class) {

            if (TESTPATTERN1.equals(SYORIPTN)) {
                return C_ErrorKbn.ERROR;

            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;

            }
        }

        if (caller == KhGetSyanaiWebItijiNenkinInfoTest_getSyouhnInfo.class) {

            if (TESTPATTERN1.equals(SYORIPTN)) {
                return C_ErrorKbn.ERROR;

            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;

            }
        }

        if (caller == KhGetSyanaiWebHeijyunNenkinInfoTest_getSyouhnInfo.class) {

            if (TESTPATTERN1.equals(SYORIPTN)) {
                return C_ErrorKbn.ERROR;

            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;

            }
        }

        if (caller == SetHosyouTest_exec.class) {
            return C_ErrorKbn.OK;
        }

        if (caller == EditKykNaiyouOsirase7Test_editInfo.class) {

            if (TESTPATTERN1.equals(SYORIPTN)) {

                return C_ErrorKbn.ERROR;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {

                return C_ErrorKbn.OK;
            }
        }

        return super.execByKeisanWExt(pSyoNo,pCalckijyunYmd,pSiinKbn,pHokenkinsyuruiKbn,pSdpdkbn,pHrkkeiro);

    }

    @Override
    public CalcHkShrKngkBean getCalcHkShrKngkBean() {
        CalcHkShrKngkBean calcHkShrKngkBean = SWAKInjector.getInstance(CalcHkShrKngkBean.class);

        if (caller == EditKykNaiyouOsirase4Test_editInfo.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(3333L, BizCurrencyTypes.YEN));
                calcHkShrKngkBean.setSibousGk(BizCurrency.valueOf(107310L, BizCurrencyTypes.YEN));
                calcHkShrKngkBean.setHknKknKbn(C_HknKknKbn.DAI1HKNKKN);
                return calcHkShrKngkBean;
            }
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

        else if (caller == EditKykNaiyouOsirase5Test_editInfo.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(5656L, BizCurrencyTypes.YEN));
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

            if (TESTPATTERN6.equals(SYORIPTN)) {

                calcHkShrKngkBean.setHokenknGk(BizCurrency.valueOf(10000, BizCurrencyTypes.DOLLAR));

                return calcHkShrKngkBean;
            }
        }

        if (caller == EditSyoukenTblSyuusin2Test_editTBL.class) {

            if (TESTPATTERN1.equals(SYORIPTN)) {

                calcHkShrKngkBean.setSibousGk(BizCurrency.valueOf(10010));

                return calcHkShrKngkBean;
            }
        }

        else if (EditKykNaiyouOsirase1Test_editInfo.class == caller) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                calcHkShrKngkBean.setSibousGk(BizCurrency.valueOf(10001L, BizCurrencyTypes.YEN));
                calcHkShrKngkBean.setSaigaisGk(BizCurrency.valueOf(9999L, BizCurrencyTypes.YEN));
                calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(3333L, BizCurrencyTypes.YEN));
                calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(4444L, BizCurrencyTypes.YEN));
                calcHkShrKngkBean.setHknKknKbn(C_HknKknKbn.DAI1HKNKKN);
                return calcHkShrKngkBean;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                calcHkShrKngkBean.setSibousGk(BizCurrency.valueOf(1111L,BizCurrencyTypes.YEN));
                calcHkShrKngkBean.setSaigaisGk(BizCurrency.valueOf(2222L,BizCurrencyTypes.YEN));
                calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(3333L,BizCurrencyTypes.YEN));
                calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(4444L,BizCurrencyTypes.YEN));
                calcHkShrKngkBean.setHknKknKbn(C_HknKknKbn.DAI2HKNKKN);
                return calcHkShrKngkBean;
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {
                calcHkShrKngkBean.setSibousGk(BizCurrency.valueOf(1111L,BizCurrencyTypes.YEN));
                calcHkShrKngkBean.setSaigaisGk(BizCurrency.valueOf(2222L,BizCurrencyTypes.YEN));
                calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(3333L,BizCurrencyTypes.YEN));
                calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(4444L,BizCurrencyTypes.YEN));
                calcHkShrKngkBean.setHknKknKbn(C_HknKknKbn.DAI3HKNKKN);
                return calcHkShrKngkBean;
            }
            else if (TESTPATTERN5.equals(SYORIPTN)) {
                calcHkShrKngkBean.setSibousGk(BizCurrency.valueOf(9999L, BizCurrencyTypes.YEN));
                calcHkShrKngkBean.setSaigaisGk(BizCurrency.valueOf(10000L, BizCurrencyTypes.YEN));
                calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(3333L, BizCurrencyTypes.YEN));
                calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(4444L, BizCurrencyTypes.YEN));
                calcHkShrKngkBean.setHknKknKbn(C_HknKknKbn.DAI1HKNKKN);
                return calcHkShrKngkBean;
            }
            else if (TESTPATTERN6.equals(SYORIPTN)) {
                calcHkShrKngkBean.setSibousGk(BizCurrency.valueOf(10000L, BizCurrencyTypes.YEN));
                calcHkShrKngkBean.setSaigaisGk(BizCurrency.valueOf(10001L, BizCurrencyTypes.YEN));
                calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(3333L, BizCurrencyTypes.YEN));
                calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(4444L, BizCurrencyTypes.YEN));
                calcHkShrKngkBean.setHknKknKbn(C_HknKknKbn.DAI1HKNKKN);
                return calcHkShrKngkBean;
            }
        }
        else if (caller == EditKykNaiyouOsirase6Test_editInfo.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                calcHkShrKngkBean.setSibousGk(BizCurrency.valueOf(10001L, BizCurrencyTypes.YEN));
                calcHkShrKngkBean.setSaigaisGk(BizCurrency.valueOf(9999L, BizCurrencyTypes.YEN));
                calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(3333L, BizCurrencyTypes.YEN));
                calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(4444L, BizCurrencyTypes.YEN));
                calcHkShrKngkBean.setHknKknKbn(C_HknKknKbn.DAI1HKNKKN);
                return calcHkShrKngkBean;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                calcHkShrKngkBean.setSibousGk(BizCurrency.valueOf(1111L,BizCurrencyTypes.YEN));
                calcHkShrKngkBean.setSaigaisGk(BizCurrency.valueOf(2222L,BizCurrencyTypes.YEN));
                calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(3333L,BizCurrencyTypes.YEN));
                calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(4444L,BizCurrencyTypes.YEN));
                calcHkShrKngkBean.setHknKknKbn(C_HknKknKbn.DAI2HKNKKN);
                return calcHkShrKngkBean;
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {
                calcHkShrKngkBean.setSibousGk(BizCurrency.valueOf(1111L,BizCurrencyTypes.YEN));
                calcHkShrKngkBean.setSaigaisGk(BizCurrency.valueOf(2222L,BizCurrencyTypes.YEN));
                calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(3333L,BizCurrencyTypes.YEN));
                calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(4444L,BizCurrencyTypes.YEN));
                calcHkShrKngkBean.setHknKknKbn(C_HknKknKbn.DAI2HKNKKN);
                return calcHkShrKngkBean;
            }
            else if (TESTPATTERN5.equals(SYORIPTN)) {
                calcHkShrKngkBean.setSibousGk(BizCurrency.valueOf(9999L, BizCurrencyTypes.YEN));
                calcHkShrKngkBean.setSaigaisGk(BizCurrency.valueOf(10000L, BizCurrencyTypes.YEN));
                calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(3333L, BizCurrencyTypes.YEN));
                calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(4444L, BizCurrencyTypes.YEN));
                calcHkShrKngkBean.setHknKknKbn(C_HknKknKbn.DAI1HKNKKN);
                return calcHkShrKngkBean;
            }
            else if (TESTPATTERN6.equals(SYORIPTN)) {
                calcHkShrKngkBean.setSibousGk(BizCurrency.valueOf(10000L, BizCurrencyTypes.YEN));
                calcHkShrKngkBean.setSaigaisGk(BizCurrency.valueOf(10001L, BizCurrencyTypes.YEN));
                calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(3333L, BizCurrencyTypes.YEN));
                calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(4444L, BizCurrencyTypes.YEN));
                calcHkShrKngkBean.setHknKknKbn(C_HknKknKbn.DAI1HKNKKN);
                return calcHkShrKngkBean;
            }
        }
        if (caller == EditSyoukenTblSyuusinTest_editTBL.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {

                calcHkShrKngkBean.setSibousGk(BizCurrency.valueOf(10010));

                return calcHkShrKngkBean;
            }
        }


        if (caller == KhGetSyanaiWebKyoutuuInfoTest_exec.class) {

            if (TESTPATTERN2.equals(SYORIPTN)) {

                calcHkShrKngkBean.setHokenknGk(BizCurrency.valueOf(20010));
                return calcHkShrKngkBean;
            }
        }

        if (caller == KhGetSyanaiWebItijiSyuusinInfoTest_getSyouhnInfo.class) {

            if (TESTPATTERN2.equals(SYORIPTN)) {

                calcHkShrKngkBean.setHokenknGk(BizCurrency.valueOf(20010));
                return calcHkShrKngkBean;
            }
        }

        if (caller == KhGetSyanaiWebItijiNenkinInfoTest_getSyouhnInfo.class) {

            if (TESTPATTERN2.equals(SYORIPTN)) {

                calcHkShrKngkBean.setHokenknGk(BizCurrency.valueOf(20010));
                return calcHkShrKngkBean;
            }
        }
        if (caller == KhGetSyanaiWebHeijyunNenkinInfoTest_getSyouhnInfo.class) {

            if (TESTPATTERN2.equals(SYORIPTN)) {

                calcHkShrKngkBean.setHokenknGk(BizCurrency.valueOf(20010));
                return calcHkShrKngkBean;
            }
        }

        if (caller == KhGetSyanaiWebHeijyunSyuusinInfoTest_getSyouhnInfo.class) {

            if (TESTPATTERN2.equals(SYORIPTN)) {

                calcHkShrKngkBean.setHokenknGk(BizCurrency.valueOf(20010));
                return calcHkShrKngkBean;
            }
        }

        if (caller == SetHosyouTest_exec.class) {
            calcHkShrKngkBean.setSibousGk(BizCurrency.valueOf(20001));
            calcHkShrKngkBean.setSaigaisGk(BizCurrency.valueOf(30001));
            calcHkShrKngkBean.setSbymdTmttKnGk(BizCurrency.valueOf(500));
            return calcHkShrKngkBean;
        }

        if (caller == EditKykNaiyouOsirase7Test_editInfo.class) {

            if (TESTPATTERN2.equals(SYORIPTN)) {

                calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(20001));
                return calcHkShrKngkBean;
            }
        }

        return super.getCalcHkShrKngkBean();

    }

}
