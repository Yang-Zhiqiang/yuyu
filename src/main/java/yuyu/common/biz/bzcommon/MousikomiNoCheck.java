package yuyu.common.biz.bzcommon;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import yuyu.def.classification.C_KahiKbn;
import yuyu.def.db.entity.HT_MosnoKanri;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;

/**
 * 業務共通 共通 申込番号チェック
 */
public class MousikomiNoCheck {

    private static final int CHECKDEGIT_ERROR = -999;

    private static final String FORMAT = "^(78|79|86|87|88|97|98|99)(\\d{6})$";

    private static final int[] WEIGHTS = { 1, 2, 1, 2, 1, 2, 1, 2 };

    public static boolean isValid(String pMosno) {

        if (pMosno == null || pMosno.length() != 9) {
            return false;
        }

        String chkDegit = pMosno.substring(8, 9);
        String mosnoHatiketa = pMosno.substring(0, 8);

        int chkDegitSansyutuAfter = calcDegit(mosnoHatiketa);

        if (chkDegit.equals(String.valueOf(chkDegitSansyutuAfter))) {
            return true;
        }

        return false;
    }

    public static int calcDegit(String pDegitMosno) {

        int sum = 0;
        int result = 0;
        int chkDegit = 0;

        if (!isMosnoMatch(pDegitMosno)) {

            return CHECKDEGIT_ERROR;
        }

        for (int i = 0; i < pDegitMosno.length(); i++) {

            result = Integer.parseInt(Character.toString(pDegitMosno.charAt(i))) * WEIGHTS[i];

            if (result > 9) {
                sum += (result / 10) + (result % 10);
            }
            else {
                sum += result;
            }
        }

        if (sum % 10 == 0) {
            chkDegit = sum % 10;
        }
        else {
            chkDegit = 10 - sum % 10;
        }

        return chkDegit;
    }

    public static boolean ifExistMousikomiNo(String pMosno) {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        String mosno = pMosno.substring(0, 8);

        HT_MosnoKanri mosnoKanri = sinkeiyakuDomManager.getMosnoKanri(mosno);

        if (mosnoKanri != null && C_KahiKbn.HUKA.eq(mosnoKanri.getSaibankahikbn())) {
            return true;
        }
        return false;
    }

    private static boolean isMosnoMatch(String pDegitMosno) {

        if (!pDegitMosno.matches(FORMAT)) {
            return false;
        }

        return true;
    }
}