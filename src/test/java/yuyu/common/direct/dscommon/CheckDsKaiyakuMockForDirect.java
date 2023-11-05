package yuyu.common.direct.dscommon;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;
import yuyu.app.dsweb.dwdsinfo.dwgetdskanyuukeiyakuitiran.DwGetDsKanyuuKeiyakuItiranTest_execPostForm;
import yuyu.app.dsweb.dwhozentetuduki.dwkaiyakuuketuke.DwKaiyakuUketukeTest_execPostFormPrepare;
import yuyu.app.dsweb.dwhozentetuduki.dwkaiyakuuketuke.DwKaiyakuUketukeTest_execPostFormUpdate;
import yuyu.app.dsweb.dwninsyou.dwlogin.DwLoginTest_execPostForm;
import yuyu.def.classification.C_DsKaiyakuchkkekkaKbn;
import yuyu.def.classification.C_DsSyouhnbunruiKbn;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_UmuKbn;

/**
 * {@link CheckDsKaiyaku}のモッククラスです。<br />
 */
public class CheckDsKaiyakuMockForDirect extends CheckDsKaiyaku {

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

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

    @Override
    public C_UmuKbn kaiyakuUkeUmuChk(String pSyoNo) {

        C_UmuKbn umuKbn = null;

        if(caller == DsKokyakuYuukouKeiyakuHanteiTest_exec.class){
            if (TESTPATTERN1.equals(SYORIPTN)) {
                umuKbn = C_UmuKbn.ARI;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                umuKbn = C_UmuKbn.NONE;
            }
            else{
                umuKbn = super.kaiyakuUkeUmuChk(pSyoNo);
            }
        }
        if (caller == DwLoginTest_execPostForm.class) {
            if(TESTPATTERN1.equals(SYORIPTN)){
                umuKbn = C_UmuKbn.ARI;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                umuKbn = C_UmuKbn.NONE;
            }
            else {
                umuKbn = super.kaiyakuUkeUmuChk(pSyoNo);
            }
        }

        if (caller == DwKaiyakuUketukeTest_execPostFormPrepare.class ){
            if (TESTPATTERN10.equals(SYORIPTN)) {
                umuKbn = C_UmuKbn.ARI;
            }
            else if (TESTPATTERN11.equals(SYORIPTN)) {
                umuKbn = C_UmuKbn.NONE;
            }
            else {
                umuKbn = super.kaiyakuUkeUmuChk(pSyoNo);
            }
        }

        if (caller == DwKaiyakuUketukeTest_execPostFormUpdate.class ){
            if (TESTPATTERN1.equals(SYORIPTN)) {
                umuKbn = C_UmuKbn.NONE;
            }
            else {
                umuKbn = super.kaiyakuUkeUmuChk(pSyoNo);
            }
        }

        if (caller == CheckKaiyakuUketukeTest_kaiyakusyokaiChk.class ){

            if (TESTPATTERN10.equals(SYORIPTN)) {

                umuKbn = C_UmuKbn.ARI;
            } else if (TESTPATTERN11.equals(SYORIPTN)) {

                umuKbn = C_UmuKbn.NONE;

            } else {
                umuKbn = super.kaiyakuUkeUmuChk(pSyoNo);
            }

        }

        if (caller == DwGetDsKanyuuKeiyakuItiranTest_execPostForm.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                umuKbn = C_UmuKbn.NONE;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {

                if (pSyoNo.equals("17806000013") || pSyoNo.equals("11807111222")) {
                    umuKbn = C_UmuKbn.ARI;
                }
                else {
                    umuKbn = C_UmuKbn.NONE;
                }
            }
            else {
                umuKbn = super.kaiyakuUkeUmuChk(pSyoNo);
            }
        }
        return umuKbn;
    }

    @Override
    public CheckDsKaiyakuResultBean kaiyakukytChk(String pSyoNo, BizDate pKaiyakuYmd, BizCurrency pKaiyakuHrYen,
        C_DsSyouhnbunruiKbn pDsSyouhnBunruiKbn) {

        if (caller == DwKaiyakuUketukeTest_execPostFormPrepare.class ){
            CheckDsKaiyakuResultBean checkDsKaiyakuResultBean = SWAKInjector.getInstance(CheckDsKaiyakuResultBean.class);
            checkDsKaiyakuResultBean.setErrorKbn(C_ErrorKbn.ERROR);
            if (TESTPATTERN1.equals(SYORIPTN)) {
                checkDsKaiyakuResultBean.setDsKaiyakuchkkekkaKbn(C_DsKaiyakuchkkekkaKbn.HOZENJYOUTAI);
                return checkDsKaiyakuResultBean;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                checkDsKaiyakuResultBean.setDsKaiyakuchkkekkaKbn(C_DsKaiyakuchkkekkaKbn.TETUDUKITYUUI);
                return checkDsKaiyakuResultBean;
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {
                checkDsKaiyakuResultBean.setDsKaiyakuchkkekkaKbn(C_DsKaiyakuchkkekkaKbn.SITIKENSETTEI);
                return checkDsKaiyakuResultBean;
            }
            else if (TESTPATTERN4.equals(SYORIPTN)) {
                checkDsKaiyakuResultBean.setDsKaiyakuchkkekkaKbn(C_DsKaiyakuchkkekkaKbn.YENDATEHENKOUMAE);
                return checkDsKaiyakuResultBean;
            }
            else if (TESTPATTERN5.equals(SYORIPTN)) {
                checkDsKaiyakuResultBean.setDsKaiyakuchkkekkaKbn(C_DsKaiyakuchkkekkaKbn.SAKIYMDHENKOU);
                return checkDsKaiyakuResultBean;
            }
            else if (TESTPATTERN6.equals(SYORIPTN)) {
                checkDsKaiyakuResultBean.setDsKaiyakuchkkekkaKbn(C_DsKaiyakuchkkekkaKbn.KYKYMDMAE);
                return checkDsKaiyakuResultBean;
            }
            else if (TESTPATTERN7.equals(SYORIPTN)) {
                checkDsKaiyakuResultBean.setDsKaiyakuchkkekkaKbn(C_DsKaiyakuchkkekkaKbn.SOUKINJYOUGEN);
                return checkDsKaiyakuResultBean;
            }
            else if (TESTPATTERN8.equals(SYORIPTN)) {
                checkDsKaiyakuResultBean.setDsKaiyakuchkkekkaKbn(C_DsKaiyakuchkkekkaKbn.BLNK);
                return checkDsKaiyakuResultBean;
            }
            else if (TESTPATTERN9.equals(SYORIPTN)) {
                checkDsKaiyakuResultBean.setErrorKbn(C_ErrorKbn.OK);
                return checkDsKaiyakuResultBean;
            }
            else if (TESTPATTERN10.equals(SYORIPTN)) {
                checkDsKaiyakuResultBean.setErrorKbn(C_ErrorKbn.OK);
                return checkDsKaiyakuResultBean;
            }
            else if (TESTPATTERN11.equals(SYORIPTN)) {
                checkDsKaiyakuResultBean.setErrorKbn(C_ErrorKbn.OK);
                return checkDsKaiyakuResultBean;
            }
            else if (TESTPATTERN12.equals(SYORIPTN)) {
                checkDsKaiyakuResultBean.setDsKaiyakuchkkekkaKbn(C_DsKaiyakuchkkekkaKbn.MFHUSEIGOU);
                return checkDsKaiyakuResultBean;
            }
            else if (TESTPATTERN13.equals(SYORIPTN)) {
                checkDsKaiyakuResultBean.setDsKaiyakuchkkekkaKbn(C_DsKaiyakuchkkekkaKbn.MIHANEIHAITOUKIN);
                return checkDsKaiyakuResultBean;
            }
            else if (TESTPATTERN14.equals(SYORIPTN)) {
                checkDsKaiyakuResultBean.setDsKaiyakuchkkekkaKbn(C_DsKaiyakuchkkekkaKbn.HAITOUKINHANEIYMDSONZAI);
                return checkDsKaiyakuResultBean;
            }
            else if (TESTPATTERN15.equals(SYORIPTN)) {
                checkDsKaiyakuResultBean.setDsKaiyakuchkkekkaKbn(C_DsKaiyakuchkkekkaKbn.HARAIKOMIYUYOKIKAN);
                return checkDsKaiyakuResultBean;
            }
            else if (TESTPATTERN16.equals(SYORIPTN)) {
                checkDsKaiyakuResultBean.setDsKaiyakuchkkekkaKbn(C_DsKaiyakuchkkekkaKbn.HAITOUKIN);
                return checkDsKaiyakuResultBean;
            }
            else if (TESTPATTERN17.equals(SYORIPTN)) {
                checkDsKaiyakuResultBean.setDsKaiyakuchkkekkaKbn(C_DsKaiyakuchkkekkaKbn.MIHANEITUMITATEKIN);
                return checkDsKaiyakuResultBean;
            }
            else if (TESTPATTERN18.equals(SYORIPTN)) {
                checkDsKaiyakuResultBean.setDsKaiyakuchkkekkaKbn(C_DsKaiyakuchkkekkaKbn.ZENNOUMIJYUUTOU);
                return checkDsKaiyakuResultBean;
            }
        }
        if (caller == DwKaiyakuUketukeTest_execPostFormUpdate.class ){
            if (TESTPATTERN1.equals(SYORIPTN)) {
                CheckDsKaiyakuResultBean checkDsKaiyakuResultBean = SWAKInjector.getInstance(CheckDsKaiyakuResultBean.class);
                checkDsKaiyakuResultBean.setErrorKbn(C_ErrorKbn.OK);
                return checkDsKaiyakuResultBean;
            }
        }

        if (caller == CheckKaiyakuUketukeTest_kaiyakusyokaiChk.class ){
            CheckDsKaiyakuResultBean checkDsKaiyakuResultBean = SWAKInjector.getInstance(CheckDsKaiyakuResultBean.class);
            checkDsKaiyakuResultBean.setErrorKbn(C_ErrorKbn.ERROR);
            if (TESTPATTERN1.equals(SYORIPTN)) {
                checkDsKaiyakuResultBean.setDsKaiyakuchkkekkaKbn(C_DsKaiyakuchkkekkaKbn.HOZENJYOUTAI);
                return checkDsKaiyakuResultBean;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                checkDsKaiyakuResultBean.setDsKaiyakuchkkekkaKbn(C_DsKaiyakuchkkekkaKbn.TETUDUKITYUUI);
                return checkDsKaiyakuResultBean;
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {
                checkDsKaiyakuResultBean.setDsKaiyakuchkkekkaKbn(C_DsKaiyakuchkkekkaKbn.SITIKENSETTEI);
                return checkDsKaiyakuResultBean;
            }
            else if (TESTPATTERN4.equals(SYORIPTN)) {
                checkDsKaiyakuResultBean.setDsKaiyakuchkkekkaKbn(C_DsKaiyakuchkkekkaKbn.YENDATEHENKOUMAE);
                return checkDsKaiyakuResultBean;
            }
            else if (TESTPATTERN5.equals(SYORIPTN)) {
                checkDsKaiyakuResultBean.setDsKaiyakuchkkekkaKbn(C_DsKaiyakuchkkekkaKbn.SAKIYMDHENKOU);
                return checkDsKaiyakuResultBean;
            }
            else if (TESTPATTERN6.equals(SYORIPTN)) {
                checkDsKaiyakuResultBean.setDsKaiyakuchkkekkaKbn(C_DsKaiyakuchkkekkaKbn.KYKYMDMAE);
                return checkDsKaiyakuResultBean;
            }
            else if (TESTPATTERN7.equals(SYORIPTN)) {
                checkDsKaiyakuResultBean.setDsKaiyakuchkkekkaKbn(C_DsKaiyakuchkkekkaKbn.SOUKINJYOUGEN);
                return checkDsKaiyakuResultBean;
            }
            else if (TESTPATTERN8.equals(SYORIPTN)) {
                checkDsKaiyakuResultBean.setDsKaiyakuchkkekkaKbn(C_DsKaiyakuchkkekkaKbn.BLNK);
                return checkDsKaiyakuResultBean;
            }
            else if (TESTPATTERN9.equals(SYORIPTN)) {
                checkDsKaiyakuResultBean.setErrorKbn(C_ErrorKbn.OK);
                return checkDsKaiyakuResultBean;
            }
            else if (TESTPATTERN10.equals(SYORIPTN)) {
                checkDsKaiyakuResultBean.setErrorKbn(C_ErrorKbn.OK);
                return checkDsKaiyakuResultBean;
            }
            else if (TESTPATTERN11.equals(SYORIPTN)) {
                checkDsKaiyakuResultBean.setErrorKbn(C_ErrorKbn.OK);
                return checkDsKaiyakuResultBean;
            }
            else if (TESTPATTERN12.equals(SYORIPTN)) {
                checkDsKaiyakuResultBean.setDsKaiyakuchkkekkaKbn(C_DsKaiyakuchkkekkaKbn.MFHUSEIGOU);
                return checkDsKaiyakuResultBean;
            }
            else if (TESTPATTERN13.equals(SYORIPTN)) {
                checkDsKaiyakuResultBean.setDsKaiyakuchkkekkaKbn(C_DsKaiyakuchkkekkaKbn.MIHANEIHAITOUKIN);
                return checkDsKaiyakuResultBean;
            }
            else if (TESTPATTERN14.equals(SYORIPTN)) {
                checkDsKaiyakuResultBean.setDsKaiyakuchkkekkaKbn(C_DsKaiyakuchkkekkaKbn.HAITOUKINHANEIYMDSONZAI);
                return checkDsKaiyakuResultBean;
            }
            else if (TESTPATTERN15.equals(SYORIPTN)) {
                checkDsKaiyakuResultBean.setDsKaiyakuchkkekkaKbn(C_DsKaiyakuchkkekkaKbn.HARAIKOMIYUYOKIKAN);
                return checkDsKaiyakuResultBean;
            }
            else if (TESTPATTERN16.equals(SYORIPTN)) {
                checkDsKaiyakuResultBean.setDsKaiyakuchkkekkaKbn(C_DsKaiyakuchkkekkaKbn.HAITOUKIN);
                return checkDsKaiyakuResultBean;
            }
            else if (TESTPATTERN17.equals(SYORIPTN)) {
                checkDsKaiyakuResultBean.setDsKaiyakuchkkekkaKbn(C_DsKaiyakuchkkekkaKbn.MIHANEITUMITATEKIN);
                return checkDsKaiyakuResultBean;
            }
            else if (TESTPATTERN18.equals(SYORIPTN)) {
                checkDsKaiyakuResultBean.setDsKaiyakuchkkekkaKbn(C_DsKaiyakuchkkekkaKbn.ZENNOUMIJYUUTOU);
                return checkDsKaiyakuResultBean;
            }

        }

        return super.kaiyakukytChk(pSyoNo, pKaiyakuYmd, pKaiyakuHrYen, pDsSyouhnBunruiKbn);
    }
}
