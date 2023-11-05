package yuyu.common.hozen.haitou;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import yuyu.common.hozen.khcommon.EditKykNaiyouOsiraseKytKmTest_editInfo;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_SyorikahiKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YouhiKbn;

/**
 * 契約保全 配当 配当支払チェック（配当金支払）<br />
 * {@link CheckDShrDShr}のモッククラスです。<br />
 */
public class CheckDShrDShrMockForHozen extends CheckDShrDShr {

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static final String TESTPATTERN3 = "3";

    public static final String TESTPATTERN4 = "4";

    public CheckDShrDShrMockForHozen() {
        super();
    }

    @Override
    public C_ErrorKbn checkDShr(String pSyono, BizDate pCalcKijyunYmd, BizDateYM pJkipjytYm,
        C_YouhiKbn pPMinyuuCheckYouhi, BizDate pSyoriYmd) {

        if (caller == EditKykNaiyouOsiraseKytKmTest_editInfo.class) {
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
        }

        return super.checkDShr(pSyono, pCalcKijyunYmd, pJkipjytYm, pPMinyuuCheckYouhi, pSyoriYmd);
    }

    @Override
    public C_SyorikahiKbn getSyorikahiKbn() {

        if (caller == EditKykNaiyouOsiraseKytKmTest_editInfo.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return C_SyorikahiKbn.SYORIKANOU;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                return C_SyorikahiKbn.SYORIHUKA;
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {
                return C_SyorikahiKbn.SYORIHUKA;
            }
            else if (TESTPATTERN4.equals(SYORIPTN)) {
                return C_SyorikahiKbn.SYORIHUKA;
            }
        }

        return super.getSyorikahiKbn();
    }

    @Override
    public C_UmuKbn getDHuseigouUmu() {

        if (caller == EditKykNaiyouOsiraseKytKmTest_editInfo.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return C_UmuKbn.NONE;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                return C_UmuKbn.ARI;
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {
                return C_UmuKbn.NONE;
            }
            else if (TESTPATTERN4.equals(SYORIPTN)) {
                return C_UmuKbn.ARI;
            }
        }

        return super.getDHuseigouUmu();
    }

    @Override
    public C_UmuKbn getMihaneiDUmu() {

        if (caller == EditKykNaiyouOsiraseKytKmTest_editInfo.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return C_UmuKbn.NONE;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                return C_UmuKbn.ARI;
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {
                return C_UmuKbn.ARI;
            }
            else if (TESTPATTERN4.equals(SYORIPTN)) {
                return C_UmuKbn.ARI;
            }
        }

        return super.getMihaneiDUmu();
    }

  //    @Override
  //    public C_UmuKbn getDHaneiYmdUmu() {
  //
  //        if (caller == EditKykNaiyouOsiraseKytKmTest_editInfo.class) {
  //            if (TESTPATTERN1.equals(SYORIPTN)) {
  //                return C_UmuKbn.NONE;
  //            }
  //            else if (TESTPATTERN2.equals(SYORIPTN)) {
  //                return C_UmuKbn.ARI;
  //            }
  //        }
  //
  //        return super.getDHaneiYmdUmu();
  //    }
  //
  //    @Override
  //    public C_UmuKbn getDShrYmdUmu() {
  //
  //        if (caller == EditKykNaiyouOsiraseKytKmTest_editInfo.class) {
  //            if (TESTPATTERN1.equals(SYORIPTN)) {
  //                return C_UmuKbn.NONE;
  //            }
  //            else if (TESTPATTERN2.equals(SYORIPTN)) {
  //                return C_UmuKbn.ARI;
  //            }
  //        }
  //
  //        return super.getDShrYmdUmu();
  //    }

}
