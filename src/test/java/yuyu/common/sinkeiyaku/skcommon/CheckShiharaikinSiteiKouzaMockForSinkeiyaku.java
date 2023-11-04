package yuyu.common.sinkeiyaku.skcommon;

import java.util.ArrayList;
import java.util.List;

import jp.co.slcs.swak.date.BizDate;
import yuyu.common.sinkeiyaku.moschk.CheckTblKouzaJyouhouTest_exec;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_KouzasyuruiKbn;
import yuyu.def.classification.C_KzkykdouKbn;
import yuyu.def.classification.C_Tkhukaumu;
import yuyu.def.classification.C_YokinKbn;

/**
 * {@link CheckShiharaikinSiteiKouza}のモッククラスです<br />
 */
public class CheckShiharaikinSiteiKouzaMockForSinkeiyaku extends CheckShiharaikinSiteiKouza {

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

    public static final String TESTPATTERN14 = "14";

    public static final String TESTPATTERN15 = "15";

    public static final String TESTPATTERN16 = "16";

    public static final String TESTPATTERN17 = "17";

    public static final String TESTPATTERN18 = "18";

    public static final String TESTPATTERN19 = "19";

    public static final String TESTPATTERN20 = "20";

    public static final String TESTPATTERN21 = "21";

    public static final String TESTPATTERN22 = "22";

    public static final String TESTPATTERN23 = "23";

    public static final String TESTPATTERN24 = "24";

    public static final String TESTPATTERN25 = "25";

    public static final String TESTPATTERN26 = "26";

    public static final String TESTPATTERN27 = "27";

    public static final String TESTPATTERN28 = "28";

    public static final String TESTPATTERN29 = "29";

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    private List<Integer> errorCdlst;

    @Override
    public C_ErrorKbn exec(C_Tkhukaumu pTeikisiharaitkykhkkbn, C_KouzasyuruiKbn pTeikishrkinshrtuuka, String pBankcd,
        String pSitencd, C_YokinKbn pYokinkbn, String pKouzano, C_KzkykdouKbn pKzkykdoukbn, String pKyknmkn,
        String pKzmeiginmkn, BizDate pSyoriymd) {

        if (caller == CheckTblKouzaJyouhouTest_exec.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
            if (TESTPATTERN2.equals(SYORIPTN)) {
                errorCdlst = new ArrayList<>();
                return C_ErrorKbn.ERROR;
            }
            if (TESTPATTERN3.equals(SYORIPTN)) {

                errorCdlst = new ArrayList<>();

                errorCdlst.add(SHRKINSITEIKOUZAJYOUHOU_NRK_ERROR);
                errorCdlst.add(SHRKINSITEIKOUZAJYOUHOU_MNRK_ERROR);
                errorCdlst.add(TEIKISIHARAIKINSHRTUUKA_MNRK_ERROR);
                errorCdlst.add(BANKCD_MNRK_ERROR);
                errorCdlst.add(SITENCD_MNRK_ERROR);
                errorCdlst.add(YOKINSYUMOKU_MNRK_ERROR);
                errorCdlst.add(YOKINSYUMOKUGAIKA_NRK_ERROR);
                errorCdlst.add(KOUZANO_MNRK_ERROR);
                errorCdlst.add(KZKYKDOUKBN_MNRK_ERROR);
                errorCdlst.add(KZKYKDOUKBNGAIKA_NRK_ERROR);
                errorCdlst.add(KZMEIGINMKN_NRK_ERROR);
                errorCdlst.add(KZMEIGINMKN_MNRK_ERROR);
                errorCdlst.add(BANKMASTER_SNZCHK_ERROR);
                errorCdlst.add(BANKYUUKOU_HANTEICHK_ERROR);
                errorCdlst.add(BANKYENSOUKIN_CHK_ERROR);
                errorCdlst.add(BANKGAIKASOUKIN_CHK_ERROR);
                errorCdlst.add(KOUZANO_KYOKAMOJICHK_ERROR);
                errorCdlst.add(KOUZANO_KETASUUCHK_ERROR);

                return C_ErrorKbn.ERROR;

            }
            if (TESTPATTERN4.equals(SYORIPTN)) {
                errorCdlst = new ArrayList<>();

                errorCdlst.add(KZMEIGINMKN_KETASUUCHK_ERROR);
                errorCdlst.add(KZMEIGINMKN_HUITTICHK_ERROR);
                errorCdlst.add(YOKINSYUMOKU_YUUTYOCHK_ERROR);

                return C_ErrorKbn.ERROR;
            }
            if (TESTPATTERN5.equals(SYORIPTN)) {
                errorCdlst = new ArrayList<>();

                errorCdlst.add(KZMEIGINMKN_KYOKAMOJICHK_ERROR);

                return C_ErrorKbn.ERROR;
            }
            if (TESTPATTERN6.equals(SYORIPTN)) {
                errorCdlst = new ArrayList<>();

                errorCdlst.add(SHRKINSITEIKOUZAJYOUHOU_NRK_ERROR);

                return C_ErrorKbn.ERROR;
            }
            if (TESTPATTERN7.equals(SYORIPTN)) {
                errorCdlst = new ArrayList<>();

                errorCdlst.add(SHRKINSITEIKOUZAJYOUHOU_MNRK_ERROR);

                return C_ErrorKbn.ERROR;
            }
            if (TESTPATTERN8.equals(SYORIPTN)) {
                errorCdlst = new ArrayList<>();

                errorCdlst.add(TEIKISIHARAIKINSHRTUUKA_MNRK_ERROR);

                return C_ErrorKbn.ERROR;
            }
            if (TESTPATTERN9.equals(SYORIPTN)) {
                errorCdlst = new ArrayList<>();

                errorCdlst.add(BANKCD_MNRK_ERROR);

                return C_ErrorKbn.ERROR;
            }
            if (TESTPATTERN10.equals(SYORIPTN)) {
                errorCdlst = new ArrayList<>();

                errorCdlst.add(SITENCD_MNRK_ERROR);

                return C_ErrorKbn.ERROR;
            }
            if (TESTPATTERN11.equals(SYORIPTN)) {
                errorCdlst = new ArrayList<>();

                errorCdlst.add(YOKINSYUMOKU_MNRK_ERROR);

                return C_ErrorKbn.ERROR;
            }
            if (TESTPATTERN12.equals(SYORIPTN)) {
                errorCdlst = new ArrayList<>();

                errorCdlst.add(YOKINSYUMOKUGAIKA_NRK_ERROR);

                return C_ErrorKbn.ERROR;
            }
            if (TESTPATTERN13.equals(SYORIPTN)) {
                errorCdlst = new ArrayList<>();

                errorCdlst.add(KOUZANO_MNRK_ERROR);

                return C_ErrorKbn.ERROR;
            }
            if (TESTPATTERN14.equals(SYORIPTN)) {
                errorCdlst = new ArrayList<>();

                errorCdlst.add(KZKYKDOUKBN_MNRK_ERROR);

                return C_ErrorKbn.ERROR;
            }
            if (TESTPATTERN15.equals(SYORIPTN)) {
                errorCdlst = new ArrayList<>();

                errorCdlst.add(KZKYKDOUKBNGAIKA_NRK_ERROR);

                return C_ErrorKbn.ERROR;
            }
            if (TESTPATTERN16.equals(SYORIPTN)) {
                errorCdlst = new ArrayList<>();

                errorCdlst.add(KZMEIGINMKN_NRK_ERROR);

                return C_ErrorKbn.ERROR;
            }
            if (TESTPATTERN17.equals(SYORIPTN)) {
                errorCdlst = new ArrayList<>();

                errorCdlst.add(KZMEIGINMKN_MNRK_ERROR);

                return C_ErrorKbn.ERROR;
            }
            if (TESTPATTERN18.equals(SYORIPTN)) {
                errorCdlst = new ArrayList<>();

                errorCdlst.add(BANKMASTER_SNZCHK_ERROR);

                return C_ErrorKbn.ERROR;
            }
            if (TESTPATTERN19.equals(SYORIPTN)) {
                errorCdlst = new ArrayList<>();

                errorCdlst.add(BANKYUUKOU_HANTEICHK_ERROR);

                return C_ErrorKbn.ERROR;
            }
            if (TESTPATTERN20.equals(SYORIPTN)) {
                errorCdlst = new ArrayList<>();

                errorCdlst.add(BANKYENSOUKIN_CHK_ERROR);

                return C_ErrorKbn.ERROR;
            }
            if (TESTPATTERN21.equals(SYORIPTN)) {
                errorCdlst = new ArrayList<>();

                errorCdlst.add(BANKGAIKASOUKIN_CHK_ERROR);

                return C_ErrorKbn.ERROR;
            }
            if (TESTPATTERN22.equals(SYORIPTN)) {
                errorCdlst = new ArrayList<>();

                errorCdlst.add(KOUZANO_KYOKAMOJICHK_ERROR);

                return C_ErrorKbn.ERROR;
            }
            if (TESTPATTERN23.equals(SYORIPTN)) {
                errorCdlst = new ArrayList<>();

                errorCdlst.add(KOUZANO_KETASUUCHK_ERROR);

                return C_ErrorKbn.ERROR;
            }
            if (TESTPATTERN24.equals(SYORIPTN)) {
                errorCdlst = new ArrayList<>();

                errorCdlst.add(KZMEIGINMKN_KYOKAMOJICHK_ERROR);

                return C_ErrorKbn.ERROR;
            }
            if (TESTPATTERN25.equals(SYORIPTN)) {
                errorCdlst = new ArrayList<>();

                errorCdlst.add(KZMEIGINMKN_KETASUUCHK_ERROR);

                return C_ErrorKbn.ERROR;
            }
            if (TESTPATTERN26.equals(SYORIPTN)) {
                errorCdlst = new ArrayList<>();

                errorCdlst.add(KZMEIGINMKN_HUITTICHK_ERROR);

                return C_ErrorKbn.ERROR;
            }
            if (TESTPATTERN27.equals(SYORIPTN)) {
                errorCdlst = new ArrayList<>();

                errorCdlst.add(YOKINSYUMOKU_YUUTYOCHK_ERROR);

                return C_ErrorKbn.ERROR;
            }
            if (TESTPATTERN28.equals(SYORIPTN)) {
                errorCdlst = new ArrayList<>();

                errorCdlst.add(BANKMASTER_SNZCHK_ERROR);
                errorCdlst.add(BANKYUUKOU_HANTEICHK_ERROR);
                errorCdlst.add(BANKYENSOUKIN_CHK_ERROR);
                errorCdlst.add(BANKGAIKASOUKIN_CHK_ERROR);
                errorCdlst.add(KOUZANO_KYOKAMOJICHK_ERROR);
                errorCdlst.add(KOUZANO_KETASUUCHK_ERROR);
                errorCdlst.add(YOKINSYUMOKU_YUUTYOCHK_ERROR);

                return C_ErrorKbn.ERROR;
            }
        }

        return super.exec(pTeikisiharaitkykhkkbn, pTeikishrkinshrtuuka, pBankcd, pSitencd,
            pYokinkbn, pKouzano, pKzkykdoukbn, pKyknmkn, pKzmeiginmkn, pSyoriymd);
    }

    @Override
    public List<Integer> getErrorCdList() {

        if (caller == CheckTblKouzaJyouhouTest_exec.class) {
            return errorCdlst;
        }
        return super.getErrorCdList();
    }
}
