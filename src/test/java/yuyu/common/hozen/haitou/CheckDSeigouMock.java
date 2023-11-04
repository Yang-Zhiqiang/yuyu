package yuyu.common.hozen.haitou;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateY;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_UmuKbn;

/**
 * {@link SetDNnd}のモッククラスです。<br />
 */
public class CheckDSeigouMock extends CheckDSeigou{

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static final String TESTPATTERN3 = "3";

    public static final String TESTPATTERN4 = "4";

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    @Override
    public C_ErrorKbn exec(
        String pSyono,
        BizDateY pKykMfHitounendo,
        BizDate pKykYmd,
        BizDate pYendtHnkYmd,
        BizDate pSyoriYmd) {

        if (CheckDShrGengakuTest_checkDShr.class == caller) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return C_ErrorKbn.ERROR;
            }
            if (TESTPATTERN2.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
            if (TESTPATTERN3.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
        }
        if (CheckDShrKaiyakuTest_checkDShr.class == caller) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return C_ErrorKbn.ERROR;
            }
            if (TESTPATTERN2.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
            if (TESTPATTERN3.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
        }
        if (CheckDShrSibouTest_checkDShr.class == caller) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return C_ErrorKbn.ERROR;
            }
            if (TESTPATTERN2.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
            if (TESTPATTERN3.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
        }
        if (CheckDShrDShrTest_checkDShr.class == caller) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return C_ErrorKbn.ERROR;
            }
            if (TESTPATTERN2.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
            if (TESTPATTERN3.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
        }
        if (CheckDShrYendtHnkuketukeTest_checkDShr.class == caller) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return C_ErrorKbn.ERROR;
            }
            if (TESTPATTERN2.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
            if (TESTPATTERN3.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
        }
        if (CheckDShrYendtHnkTorikesiTest_checkDShr.class == caller) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return C_ErrorKbn.ERROR;
            }
            if (TESTPATTERN2.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
            if (TESTPATTERN3.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
        }
        if (CheckDShrNyukinTorikesiTest_checkDShr.class == caller) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return C_ErrorKbn.ERROR;
            }
            if (TESTPATTERN2.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
            if (TESTPATTERN3.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
        }
        return super.exec(pSyono, pKykMfHitounendo, pKykYmd, pYendtHnkYmd, pSyoriYmd);
    }

    @Override
    public C_UmuKbn getDHuseigouUmu() {

        if (CheckDShrGengakuTest_checkDShr.class == caller) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return C_UmuKbn.ARI;
            }
            if (TESTPATTERN2.equals(SYORIPTN)) {
                return C_UmuKbn.ARI;
            }
            if (TESTPATTERN3.equals(SYORIPTN)) {
                return C_UmuKbn.NONE;
            }
        }
        if (CheckDShrKaiyakuTest_checkDShr.class == caller) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return C_UmuKbn.ARI;
            }
            if (TESTPATTERN2.equals(SYORIPTN)) {
                return C_UmuKbn.ARI;
            }
            if (TESTPATTERN3.equals(SYORIPTN)) {
                return C_UmuKbn.NONE;
            }
        }
        if (CheckDShrSibouTest_checkDShr.class == caller) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return C_UmuKbn.ARI;
            }
            if (TESTPATTERN2.equals(SYORIPTN)) {
                return C_UmuKbn.ARI;
            }
            if (TESTPATTERN3.equals(SYORIPTN)) {
                return C_UmuKbn.NONE;
            }
        }
        if (CheckDShrDShrTest_checkDShr.class == caller) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return C_UmuKbn.ARI;
            }
            if (TESTPATTERN2.equals(SYORIPTN)) {
                return C_UmuKbn.ARI;
            }
            if (TESTPATTERN3.equals(SYORIPTN)) {
                return C_UmuKbn.NONE;
            }
        }
        if (CheckDShrYendtHnkuketukeTest_checkDShr.class == caller) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return C_UmuKbn.ARI;
            }
            if (TESTPATTERN2.equals(SYORIPTN)) {
                return C_UmuKbn.ARI;
            }
            if (TESTPATTERN3.equals(SYORIPTN)) {
                return C_UmuKbn.NONE;
            }
        }
        if (CheckDShrYendtHnkTorikesiTest_checkDShr.class == caller) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return C_UmuKbn.ARI;
            }
            if (TESTPATTERN2.equals(SYORIPTN)) {
                return C_UmuKbn.ARI;
            }
            if (TESTPATTERN3.equals(SYORIPTN)) {
                return C_UmuKbn.NONE;
            }
        }
        if (CheckDShrNyukinTorikesiTest_checkDShr.class == caller) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return C_UmuKbn.ARI;
            }
            if (TESTPATTERN2.equals(SYORIPTN)) {
                return C_UmuKbn.ARI;
            }
            if (TESTPATTERN3.equals(SYORIPTN)) {
                return C_UmuKbn.NONE;
            }
        }
        return super.getDHuseigouUmu();
    }

}
