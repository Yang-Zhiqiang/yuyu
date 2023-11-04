package yuyu.common.siharai.sicommon;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;
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
public class CalcHkShrKngkMockForSiharai extends CalcHkShrKngk {

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

        if (caller == SiSiharaiKingakuKeisanTest_exec.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return C_ErrorKbn.ERROR;
            }
            return C_ErrorKbn.OK;
        }
        return super.exec(pSyouhnCd, pSyouhnSdno, pRyouritusdNo, pYoteiRiritu, pHrkKaisuu, pHknkknsmnKbn, pHknKkn,
            pHrkKkn, pHhknNen, pHhknSei, pKihonS, pKykYmd, pCalckijyunYmd, pSyoNo, pTuukaSyu, pDai1hknKkn, pSiinKbn,
            pHokenkinsyuruiKbn, pHokenRyou, pKaiyakusjkkktyouseiRiritu, pKyksjkkktyouseiRiritu, pTmttkntaisyouYm,
            pTeiritutmttKngk, pSisuurendoutmttKngk, pTumitateRiritu, pHrkkknsmnKbn, pJkipjytYm, pPtmttKngk,
            pKihrkmPStgk, pFstPryosyuYmd, pYoteirrthendohosyuRiritu, pKykJyoutai, pYendthnkYmd, pSdpdkbn, pHrkkeiro);
    }

    @Override
    public C_ErrorKbn execByKeisanWExt(String pSyoNo, BizDate pCalckijyunYmd, C_SiinKbn pSiinKbn,
        C_HokenkinsyuruiKbn pHokenkinsyuruiKbn, C_Sdpd pSdpdkbn, C_Hrkkeiro pHrkkeiro) {

        if (caller == SiSiharaiKingakuKeisanTest_exec.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return C_ErrorKbn.ERROR;
            }
            return C_ErrorKbn.OK;
        }
        return super.execByKeisanWExt(pSyoNo, pCalckijyunYmd, pSiinKbn, pHokenkinsyuruiKbn, pSdpdkbn, pHrkkeiro);
    }

    @Override
    public CalcHkShrKngkBean getCalcHkShrKngkBean() {
        CalcHkShrKngkBean calcHkShrKngkBean = SWAKInjector.getInstance(CalcHkShrKngkBean.class);

        if (caller == SiSiharaiKingakuKeisanTest_exec.class) {
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
            } else if (TESTPATTERN13.equals(SYORIPTN)) {
                calcHkShrKngkBean.setKihons(BizCurrency.valueOf(18000000L,BizCurrencyTypes.DOLLAR));
                calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(12000000L,BizCurrencyTypes.DOLLAR));
                calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(13000000L,BizCurrencyTypes.DOLLAR));
                calcHkShrKngkBean.setHokenryoustGk(BizCurrency.valueOf(17000000L,BizCurrencyTypes.DOLLAR));
                calcHkShrKngkBean.setSibousGk(BizCurrency.valueOf(13000000L,BizCurrencyTypes.DOLLAR));
                calcHkShrKngkBean.setSaigaisGk(BizCurrency.valueOf(0,BizCurrencyTypes.DOLLAR));
                calcHkShrKngkBean.setHokenknGk(BizCurrency.valueOf(13000000L,BizCurrencyTypes.DOLLAR));
                calcHkShrKngkBean.setHknKknKbn(C_HknKknKbn.DAI1HKNKKN);
                calcHkShrKngkBean.setTeirituTmttkngk(BizCurrency.valueOf(12000000L,BizCurrencyTypes.DOLLAR));
                calcHkShrKngkBean.setSisuurendouTmttkngk(BizCurrency.valueOf(13000000L,BizCurrencyTypes.DOLLAR));
                calcHkShrKngkBean.setSbymdKaiyakuhenreiknGk(BizCurrency.valueOf(11100000L,BizCurrencyTypes.DOLLAR));
                calcHkShrKngkBean.setSbymdTmttKnGk(BizCurrency.valueOf(11200000L,BizCurrencyTypes.DOLLAR));
                calcHkShrKngkBean.setPruikei(BizCurrency.valueOf(11300000L,BizCurrencyTypes.DOLLAR));
                return calcHkShrKngkBean;
            } else if (TESTPATTERN14.equals(SYORIPTN)) {
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
            }
        }
        return super.getCalcHkShrKngkBean();
    }
}
