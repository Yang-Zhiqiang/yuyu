package yuyu.common.siharai.sicommon;


import java.util.List;

import yuyu.common.siharai.chksk.ChkSubSaigaiGaitouTest_exec;
import yuyu.common.siharai.chksk.ChkSubSgSbJisatuMensekiTest_exec;
import yuyu.def.classification.C_GeninKbn;
import yuyu.def.classification.C_SKNaiyouChkKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.JT_SkKihon;

/**
 * 災害該当判定モッククラス
 * {@link SaigaiGaitouHantei}のモッククラスです。<br />
 */

public class SaigaiGaitouHanteiMock extends SaigaiGaitouHantei {
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

    public static final String TESTPATTERN_B = "B";


    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    @Override
    public boolean chkGeninkbn(C_GeninKbn pGeninKbn) {

        if (caller == ChkSubSgSbJisatuMensekiTest_exec.class && TESTPATTERN1.equals(SYORIPTN)) {
            return true;
        }
        else if  (caller == ChkSubSgSbJisatuMensekiTest_exec.class && TESTPATTERN2.equals(SYORIPTN)) {
            return false;
        }
        else if  (caller == ChkSubSgSbJisatuMensekiTest_exec.class && TESTPATTERN3.equals(SYORIPTN)) {
            return true;
        }
        else if  (caller == ChkSubSgSbJisatuMensekiTest_exec.class && TESTPATTERN4.equals(SYORIPTN)) {
            return false;
        }
        else if  (caller == ChkSubSgSbJisatuMensekiTest_exec.class && TESTPATTERN5.equals(SYORIPTN)) {
            return false;
        }
        else if  (caller == ChkSubSgSbJisatuMensekiTest_exec.class && TESTPATTERN6.equals(SYORIPTN)) {
            return false;
        }
        else if  (caller == ChkSubSgSbJisatuMensekiTest_exec.class && TESTPATTERN7.equals(SYORIPTN)) {
            return false;
        }
        else if  (caller == ChkSubSgSbJisatuMensekiTest_exec.class && TESTPATTERN8.equals(SYORIPTN)) {
            return true;
        }
        else if  (caller == ChkSubSgSbJisatuMensekiTest_exec.class && TESTPATTERN9.equals(SYORIPTN)) {
            return false;
        }
        else if  (caller == ChkSubSgSbJisatuMensekiTest_exec.class && TESTPATTERN10.equals(SYORIPTN)) {
            return false;
        }
        else if  (caller == ChkSubSgSbJisatuMensekiTest_exec.class && TESTPATTERN11.equals(SYORIPTN)) {
            return false;
        }
        else if  (caller == ChkSubSgSbJisatuMensekiTest_exec.class && TESTPATTERN12.equals(SYORIPTN)) {
            return false;
        }
        else if  (caller == ChkSubSgSbJisatuMensekiTest_exec.class && TESTPATTERN13.equals(SYORIPTN)) {
            return false;
        }
        else if  (caller == ChkSubSgSbJisatuMensekiTest_exec.class && TESTPATTERN14.equals(SYORIPTN)) {
            return false;
        }
        else if  (caller == ChkSubSgSbJisatuMensekiTest_exec.class && TESTPATTERN_B.equals(SYORIPTN)) {
            return true;
        }
        else if (caller == ChkSubSaigaiGaitouTest_exec.class && TESTPATTERN1.equals(SYORIPTN)) {

            return true;
        }
        else if  (caller == ChkSubSaigaiGaitouTest_exec.class && TESTPATTERN2.equals(SYORIPTN)) {

            return false;
        }
        else if  (caller == ChkSubSaigaiGaitouTest_exec.class && TESTPATTERN3.equals(SYORIPTN)) {

            return false;
        }
        else if  (caller == ChkSubSaigaiGaitouTest_exec.class && TESTPATTERN4.equals(SYORIPTN)) {

            return false;
        }
        else if  (caller == ChkSubSaigaiGaitouTest_exec.class && TESTPATTERN5.equals(SYORIPTN)) {

            return true;
        }
        return  super.chkGeninkbn(pGeninKbn);
    }

    @Override
    public boolean chkByoumei(List<String> pByoumeiTourokuNoLst, C_SKNaiyouChkKbn pSKNaiyouChkKbn) {

        if (caller == ChkSubSgSbJisatuMensekiTest_exec.class && TESTPATTERN1.equals(SYORIPTN)) {
            return false;
        }
        else if  (caller == ChkSubSgSbJisatuMensekiTest_exec.class && TESTPATTERN2.equals(SYORIPTN)) {
            return true;
        }
        else if  (caller == ChkSubSgSbJisatuMensekiTest_exec.class && TESTPATTERN3.equals(SYORIPTN)) {
            return false;
        }
        else if  (caller == ChkSubSgSbJisatuMensekiTest_exec.class && TESTPATTERN4.equals(SYORIPTN)) {
            return true;
        }
        else if  (caller == ChkSubSgSbJisatuMensekiTest_exec.class && TESTPATTERN5.equals(SYORIPTN)) {
            return false;
        }
        else if  (caller == ChkSubSgSbJisatuMensekiTest_exec.class && TESTPATTERN6.equals(SYORIPTN)) {
            return false;
        }
        else if  (caller == ChkSubSgSbJisatuMensekiTest_exec.class && TESTPATTERN7.equals(SYORIPTN)) {
            return false;
        }
        else if  (caller == ChkSubSgSbJisatuMensekiTest_exec.class && TESTPATTERN8.equals(SYORIPTN)) {
            return false;
        }
        else if  (caller == ChkSubSgSbJisatuMensekiTest_exec.class && TESTPATTERN9.equals(SYORIPTN)) {
            return false;
        }
        else if  (caller == ChkSubSgSbJisatuMensekiTest_exec.class && TESTPATTERN10.equals(SYORIPTN)) {
            return true;
        }
        else if  (caller == ChkSubSgSbJisatuMensekiTest_exec.class && TESTPATTERN11.equals(SYORIPTN)) {
            return false;
        }
        else if  (caller == ChkSubSgSbJisatuMensekiTest_exec.class && TESTPATTERN12.equals(SYORIPTN)) {
            return false;
        }
        else if  (caller == ChkSubSgSbJisatuMensekiTest_exec.class && TESTPATTERN13.equals(SYORIPTN)) {
            return false;
        }
        else if  (caller == ChkSubSgSbJisatuMensekiTest_exec.class && TESTPATTERN14.equals(SYORIPTN)) {
            return false;
        }
        else if  (caller == ChkSubSgSbJisatuMensekiTest_exec.class && TESTPATTERN_B.equals(SYORIPTN)) {
            return false;
        }
        else if (caller == ChkSubSaigaiGaitouTest_exec.class && TESTPATTERN1.equals(SYORIPTN)) {

            return false;
        }
        else if  (caller == ChkSubSaigaiGaitouTest_exec.class && TESTPATTERN2.equals(SYORIPTN)) {

            return true;
        }
        else if  (caller == ChkSubSaigaiGaitouTest_exec.class && TESTPATTERN3.equals(SYORIPTN)) {

            return false;
        }
        else if  (caller == ChkSubSaigaiGaitouTest_exec.class && TESTPATTERN4.equals(SYORIPTN)) {

            return false;
        }
        else if  (caller == ChkSubSaigaiGaitouTest_exec.class && TESTPATTERN5.equals(SYORIPTN)) {

            return true;
        }
        return  super.chkByoumei(pByoumeiTourokuNoLst, pSKNaiyouChkKbn);
    }

    @Override
    public boolean chkSateikaisou(C_UmuKbn pSateiKakSaigaiKanouseiKbn) {

        if (caller == ChkSubSgSbJisatuMensekiTest_exec.class && TESTPATTERN1.equals(SYORIPTN)) {
            return false;
        }
        else if  (caller == ChkSubSgSbJisatuMensekiTest_exec.class && TESTPATTERN2.equals(SYORIPTN)) {
            return false;
        }
        else if  (caller == ChkSubSgSbJisatuMensekiTest_exec.class && TESTPATTERN3.equals(SYORIPTN)) {
            return false;
        }
        else if  (caller == ChkSubSgSbJisatuMensekiTest_exec.class && TESTPATTERN4.equals(SYORIPTN)) {
            return false;
        }
        else if  (caller == ChkSubSgSbJisatuMensekiTest_exec.class && TESTPATTERN5.equals(SYORIPTN)) {
            return true;
        }
        else if  (caller == ChkSubSgSbJisatuMensekiTest_exec.class && TESTPATTERN6.equals(SYORIPTN)) {
            return false;
        }
        else if  (caller == ChkSubSgSbJisatuMensekiTest_exec.class && TESTPATTERN7.equals(SYORIPTN)) {
            return false;
        }
        else if  (caller == ChkSubSgSbJisatuMensekiTest_exec.class && TESTPATTERN8.equals(SYORIPTN)) {
            return false;
        }
        else if  (caller == ChkSubSgSbJisatuMensekiTest_exec.class && TESTPATTERN9.equals(SYORIPTN)) {
            return false;
        }
        else if  (caller == ChkSubSgSbJisatuMensekiTest_exec.class && TESTPATTERN10.equals(SYORIPTN)) {
            return false;
        }
        else if  (caller == ChkSubSgSbJisatuMensekiTest_exec.class && TESTPATTERN11.equals(SYORIPTN)) {
            return false;
        }
        else if  (caller == ChkSubSgSbJisatuMensekiTest_exec.class && TESTPATTERN12.equals(SYORIPTN)) {
            return true;
        }
        else if  (caller == ChkSubSgSbJisatuMensekiTest_exec.class && TESTPATTERN13.equals(SYORIPTN)) {
            return false;
        }
        else if  (caller == ChkSubSgSbJisatuMensekiTest_exec.class && TESTPATTERN14.equals(SYORIPTN)) {
            return false;
        }
        else if  (caller == ChkSubSgSbJisatuMensekiTest_exec.class && TESTPATTERN_B.equals(SYORIPTN)) {
            return false;
        }
        else if (caller == ChkSubSaigaiGaitouTest_exec.class && TESTPATTERN1.equals(SYORIPTN)) {

            return false;
        }
        else if  (caller == ChkSubSaigaiGaitouTest_exec.class && TESTPATTERN2.equals(SYORIPTN)) {

            return false;
        }
        else if  (caller == ChkSubSaigaiGaitouTest_exec.class && TESTPATTERN3.equals(SYORIPTN)) {

            return true;
        }
        else if  (caller == ChkSubSaigaiGaitouTest_exec.class && TESTPATTERN4.equals(SYORIPTN)) {

            return false;
        }
        else if  (caller == ChkSubSaigaiGaitouTest_exec.class && TESTPATTERN5.equals(SYORIPTN)) {

            return true;
        }
        return  super.chkSateikaisou(pSateiKakSaigaiKanouseiKbn);
    }

    @Override
    public boolean chkKyuusyorui(JT_SkKihon pSkKihon) {

        if (caller == ChkSubSgSbJisatuMensekiTest_exec.class && TESTPATTERN1.equals(SYORIPTN)) {
            return false;
        }
        else if  (caller == ChkSubSgSbJisatuMensekiTest_exec.class && TESTPATTERN2.equals(SYORIPTN)) {
            return false;
        }
        else if  (caller == ChkSubSgSbJisatuMensekiTest_exec.class && TESTPATTERN3.equals(SYORIPTN)) {
            return false;
        }
        else if  (caller == ChkSubSgSbJisatuMensekiTest_exec.class && TESTPATTERN4.equals(SYORIPTN)) {
            return false;
        }
        else if  (caller == ChkSubSgSbJisatuMensekiTest_exec.class && TESTPATTERN5.equals(SYORIPTN)) {
            return false;
        }
        else if  (caller == ChkSubSgSbJisatuMensekiTest_exec.class && TESTPATTERN6.equals(SYORIPTN)) {
            return true;
        }
        else if  (caller == ChkSubSgSbJisatuMensekiTest_exec.class && TESTPATTERN7.equals(SYORIPTN)) {
            return false;
        }
        else if  (caller == ChkSubSgSbJisatuMensekiTest_exec.class && TESTPATTERN8.equals(SYORIPTN)) {
            return false;
        }
        else if  (caller == ChkSubSgSbJisatuMensekiTest_exec.class && TESTPATTERN9.equals(SYORIPTN)) {
            return false;
        }
        else if  (caller == ChkSubSgSbJisatuMensekiTest_exec.class && TESTPATTERN10.equals(SYORIPTN)) {
            return false;
        }
        else if  (caller == ChkSubSgSbJisatuMensekiTest_exec.class && TESTPATTERN11.equals(SYORIPTN)) {
            return false;
        }
        else if  (caller == ChkSubSgSbJisatuMensekiTest_exec.class && TESTPATTERN12.equals(SYORIPTN)) {
            return false;
        }
        else if  (caller == ChkSubSgSbJisatuMensekiTest_exec.class && TESTPATTERN13.equals(SYORIPTN)) {
            return true;
        }
        else if  (caller == ChkSubSgSbJisatuMensekiTest_exec.class && TESTPATTERN14.equals(SYORIPTN)) {
            return true;
        }
        else if  (caller == ChkSubSgSbJisatuMensekiTest_exec.class && TESTPATTERN_B.equals(SYORIPTN)) {
            return false;
        }
        else if (caller == ChkSubSaigaiGaitouTest_exec.class && TESTPATTERN1.equals(SYORIPTN)) {

            return false;
        }
        else if  (caller == ChkSubSaigaiGaitouTest_exec.class && TESTPATTERN2.equals(SYORIPTN)) {

            return false;
        }
        else if  (caller == ChkSubSaigaiGaitouTest_exec.class && TESTPATTERN3.equals(SYORIPTN)) {

            return false;
        }
        else if  (caller == ChkSubSaigaiGaitouTest_exec.class && TESTPATTERN4.equals(SYORIPTN)) {

            return true;
        }
        else if  (caller == ChkSubSaigaiGaitouTest_exec.class && TESTPATTERN5.equals(SYORIPTN)) {

            return true;
        }
        return  super.chkKyuusyorui(pSkKihon);
    }

}