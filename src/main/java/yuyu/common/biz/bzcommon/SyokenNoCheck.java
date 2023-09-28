package yuyu.common.biz.bzcommon;

import java.util.List;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.db.entity.BM_Syonokanri;

/**
 * 証券番号チェッククラスです。
 */
public class SyokenNoCheck {

    public static final int CHECKDEGIT_ERROR = -999;
    private static final String REGEXP10 = "^[\\d]{10}$";
    private static final String FORMAT = "^[0-9][0-9]8(0[6-9]|10)";
    private static final int[] WEIGHTS = { 3, 1, 3, 1, 3, 1, 3, 1, 3, 1 };

    public static boolean isValid(String pSyono) {

        if (pSyono == null || pSyono.length() != 11) {
            return false;
        }

        String checkDegit = pSyono.substring(10, 11);
        String syono10 = pSyono.substring(0, 10);

        int checkDegitRet = calcDegit(syono10);

        if (checkDegit.equals(checkDegitRet + "")) {
            return true;
        }

        return false;
    }

    public static int calcDegit(String pSyonoChkdigit) {

        int sum = 0;
        int chkdigit = 0;

        if (!isSyokenNoMatch(pSyonoChkdigit)) {
            return CHECKDEGIT_ERROR;
        }

        for (int i = 0; i < pSyonoChkdigit.length(); i++) {

            sum += Integer.parseInt(Character.toString(pSyonoChkdigit.charAt(i))) * WEIGHTS[i];
        }

        chkdigit = sum % 10;

        return chkdigit;
    }

    public static boolean ifExistSyokenNo(String pSyono) {

        BizDomManager bizManager = SWAKInjector.getInstance(BizDomManager.class);

        List<BM_Syonokanri> syonokanriList = bizManager.getSyonokanrisBySyono(pSyono);

        if (syonokanriList == null || syonokanriList.size() == 0) {
            return false;
        }
        return true;
    }

    private static boolean isSyokenNoMatch(String pSyono) {

        String syono5 = pSyono.substring(5, 10);
        int syonoRenban = 0;

        if (!pSyono.matches(REGEXP10)) {
            return false;
        }

        if (!pSyono.substring(0, 5).matches(FORMAT)) {
            return false;
        }

        syonoRenban = Integer.parseInt(syono5);

        if (syonoRenban == 0 || syonoRenban > 79989) {
            return false;
        }

        return true;
    }
}