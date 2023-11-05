package yuyu.common.hozen.khcommon;

import java.util.ArrayList;
import java.util.List;

import jp.co.slcs.swak.date.BizDate;
import yuyu.common.sinkeiyaku.moschk.CheckTblKouzaJyouhouTest_exec;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_KzkykdouKbn;
import yuyu.def.classification.C_YokinKbn;

/**
 * {@link CheckKzhuriKouza}のモッククラスです<br />
 */
public class CheckKzhuriKouzaMockForSinkeiyaku extends CheckKzhuriKouza {

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static final String TESTPATTERN3 = "3";

    public static final String TESTPATTERN4 = "4";

    public static final String TESTPATTERN5 = "5";

    public static final String TESTPATTERN6 = "6";

    public static final String TESTPATTERN7 = "7";

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    private List<Integer> errorCdlst;

    @Override
    public C_ErrorKbn exec(String pBankcd, String pSitencd, C_YokinKbn pBfryokin, C_KzkykdouKbn pKzkykdoukbn,
        String pKyknmkn, String pKzmeiginmkn, String pKouzano, BizDate pSyoriymd) {

        if (caller == CheckTblKouzaJyouhouTest_exec.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            } else if (TESTPATTERN2.equals(SYORIPTN)) {
                errorCdlst = new ArrayList<>();
                return C_ErrorKbn.ERROR;
            } else if (TESTPATTERN3.equals(SYORIPTN)) {

                errorCdlst = new ArrayList<>();

                errorCdlst.add(BANKCD_NRK_ERROR);
                errorCdlst.add(SITENCD_NRK_ERROR);
                errorCdlst.add(BFRYOKIN_MINRYK_ERROR);
                errorCdlst.add(KOUZANO_MNYRYK_ERROR);
                errorCdlst.add(KZKYK_DOUKBNMINYURYK_ERROR);
                errorCdlst.add(KZMEIGINMKN_MNYRYKU_ERROR);
                errorCdlst.add(KZMEIGINMK_NNYRYKU_ERROR);
                errorCdlst.add(BFRYOKIN_YUUTYOCHK_ERROR);

                errorCdlst.add(BANKMASTER_SNZCHK_ERROR);
                errorCdlst.add(BANKYUUKOU_HANTEICHK_ERROR);
                errorCdlst.add(YOFURIKYOUTEI_CHK_ERROR);
                errorCdlst.add(KOUZANO_KYOKAMONJICHK_ERROR);
                errorCdlst.add(KOUZANO_KETASUCHK_ERROR);
                errorCdlst.add(KZMEIGINMKN_KYOKAMONJICHK_ERROR);
                errorCdlst.add(KZMEIGINMKN_KETASUUCHK_ERROR);

                return C_ErrorKbn.ERROR;

            }else if (TESTPATTERN4.equals(SYORIPTN)) {
                errorCdlst = new ArrayList<>();
                return C_ErrorKbn.ERROR;
            }
            else if (TESTPATTERN5.equals(SYORIPTN)) {
                errorCdlst = new ArrayList<>();
                errorCdlst.add(KZMEIGINMKN_KYOKAMONJICHK_ERROR);
                errorCdlst.add(KZMEIGINMKN_KETASUUCHK_ERROR);
                return C_ErrorKbn.ERROR;
            }
            else if (TESTPATTERN6.equals(SYORIPTN)) {
                errorCdlst = new ArrayList<>();
                return C_ErrorKbn.ERROR;
            }
            else if (TESTPATTERN7.equals(SYORIPTN)) {
                errorCdlst = new ArrayList<>();
                errorCdlst.add(KZMEIGINMKN_KYOKAMONJICHK_ERROR);
                errorCdlst.add(KZMEIGINMKN_KETASUUCHK_ERROR);
                return C_ErrorKbn.ERROR;
            }
        }
        return super.exec(pBankcd, pSitencd, pBfryokin, pKzkykdoukbn,
            pKyknmkn, pKzmeiginmkn, pKouzano, pSyoriymd);
    }

    @Override
    public List<Integer> getErrorCdlst() {

        if (caller == CheckTblKouzaJyouhouTest_exec.class) {
            return errorCdlst;
        }
        return super.getErrorCdlst();
    }
}
