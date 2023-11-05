package yuyu.common.biz.kaikei;

import jp.co.slcs.swak.date.BizDate;
import yuyu.common.hozen.khcommon.KeisanSiharaibiTest_Exec;
import yuyu.common.siharai.chksk.ChkSubSksInfoTest_exec;
import yuyu.common.siharai.sicommon.SiSiharaiKingakuKeisanTest_exec;
import yuyu.common.sinkeiyaku.skcommon.HenkinTest_exec;
import yuyu.def.classification.C_ShrhousiteiKbn;
import yuyu.def.classification.C_Tuukasyu;

/**
 * {@link BzShiharaiDenpyouDateShutoku}のモッククラスです。<br />
 */
public class BzShiharaiDenpyouDateShutokuMock  extends BzShiharaiDenpyouDateShutoku{

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static final String TESTPATTERN3 = "3";

    public static final String TESTPATTERN4 = "4";

    public static final String TESTPATTERN5 = "5";

    public static final String TESTPATTERN6 = "6";

    public static final String TESTPATTERN7 = "7";

    public static final String TESTPATTERN8 = "8";

    public static final String TESTPATTERN9 = "9";

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    @Override
    public BizDate exec(BizDate pSyoriYmd, C_ShrhousiteiKbn pShrhousiteiKbn, C_Tuukasyu pTuukasyu, String pBankCd) {
        if (caller == HenkinTest_exec.class ) {

            if (SYORIPTN == TESTPATTERN1) {
                return BizDate.valueOf(20160405);
            }
            return BizDate.valueOf(20160401);
        }
        else if (caller == BzFbSoukinFileSksTest_creadFBsoukinfwairu.class) {
            return BizDate.valueOf(20160104);
        }

        else  if (caller == KeisanSiharaibiTest_Exec.class ) {

            if (SYORIPTN == TESTPATTERN1) {
                return BizDate.valueOf(20160302);
            }
            else if (SYORIPTN == TESTPATTERN2) {
                return BizDate.valueOf(20160303);
            }
            else if (SYORIPTN == TESTPATTERN3) {
                return BizDate.valueOf(20160301);
            }
        }
        else  if (caller == ChkSubSksInfoTest_exec.class ) {

            if (SYORIPTN == TESTPATTERN1) {
                return BizDate.valueOf(20160322);
            }
            else if (SYORIPTN == TESTPATTERN2) {
                return BizDate.valueOf(20170821);
            }
            else if (SYORIPTN == TESTPATTERN3) {
                return BizDate.valueOf(20170822);
            }
        }
        else  if (caller == SiSiharaiKingakuKeisanTest_exec.class ) {

            if (SYORIPTN == TESTPATTERN1) {
                return BizDate.getSysDate().addBusinessDays(1);
            }
            else if (SYORIPTN == TESTPATTERN2) {
                return BizDate.getSysDate().addBusinessDays(2);
            }
        }
        return super.exec(pSyoriYmd, pShrhousiteiKbn, pTuukasyu, pBankCd);
    }
}
