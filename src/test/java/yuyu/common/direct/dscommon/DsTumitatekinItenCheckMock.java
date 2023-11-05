package yuyu.common.direct.dscommon;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;

import org.slf4j.Logger;

import yuyu.app.dsweb.dwhozeninfo.dwgethozenkiykgikitijinnkn.DwGetHozenKiykGikItijiNnknImplTest_execPostForm;
import yuyu.app.dsweb.dwhozentetuduki.dwtumitatekinitenuketuke.DwTumitatekinItenUketukeTest_execPostFormPrepare;
import yuyu.app.dsweb.dwhozentetuduki.dwtumitatekinitenuketuke.DwTumitatekinItenUketukeTest_execPostFormUpdate;
import yuyu.def.classification.C_DsTmttknitenchkkekkaKbn;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_UmuKbn;

/**
 * {@link DsTumitatekinItenCheck}のモッククラスです。<br />
 */
public class DsTumitatekinItenCheckMock extends DsTumitatekinItenCheck{
    @Inject
    private static Logger logger;
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

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    @Override
    public DsTumitatekinItenCheckResultBean checkTumitatekinIten(String pSyono, BizDate pUktkymd,
            BizDate pTumitatekinitenyoteibi) {
        if (caller == DwTumitatekinItenUketukeTest_execPostFormPrepare.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                DsTumitatekinItenCheckResultBean dsTumitatekinItenCheckResultBean = SWAKInjector.getInstance(DsTumitatekinItenCheckResultBean.class);
                dsTumitatekinItenCheckResultBean.setErrorKbn(C_ErrorKbn.ERROR);
                dsTumitatekinItenCheckResultBean.setDsTmttknitenchkkekkaKbn(C_DsTmttknitenchkkekkaKbn.KYKYMDMITOURAI);

                return dsTumitatekinItenCheckResultBean;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                DsTumitatekinItenCheckResultBean dsTumitatekinItenCheckResultBean = SWAKInjector.getInstance(DsTumitatekinItenCheckResultBean.class);
                dsTumitatekinItenCheckResultBean.setErrorKbn(C_ErrorKbn.ERROR);
                dsTumitatekinItenCheckResultBean.setDsTmttknitenchkkekkaKbn(C_DsTmttknitenchkkekkaKbn.TRATKITISYSYOUHN);

                return dsTumitatekinItenCheckResultBean;
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {
                DsTumitatekinItenCheckResultBean dsTumitatekinItenCheckResultBean = SWAKInjector.getInstance(DsTumitatekinItenCheckResultBean.class);
                dsTumitatekinItenCheckResultBean.setErrorKbn(C_ErrorKbn.ERROR);
                dsTumitatekinItenCheckResultBean.setDsTmttknitenchkkekkaKbn(C_DsTmttknitenchkkekkaKbn.UKTKKKN);

                return dsTumitatekinItenCheckResultBean;
            }
            else if (TESTPATTERN4.equals(SYORIPTN)) {
                DsTumitatekinItenCheckResultBean dsTumitatekinItenCheckResultBean = SWAKInjector.getInstance(DsTumitatekinItenCheckResultBean.class);
                dsTumitatekinItenCheckResultBean.setErrorKbn(C_ErrorKbn.ERROR);
                dsTumitatekinItenCheckResultBean.setDsTmttknitenchkkekkaKbn(C_DsTmttknitenchkkekkaKbn.TEIRITUTUMITATE);

                return dsTumitatekinItenCheckResultBean;
            }
            else if (TESTPATTERN5.equals(SYORIPTN)) {
                DsTumitatekinItenCheckResultBean dsTumitatekinItenCheckResultBean = SWAKInjector.getInstance(DsTumitatekinItenCheckResultBean.class);
                dsTumitatekinItenCheckResultBean.setErrorKbn(C_ErrorKbn.ERROR);
                dsTumitatekinItenCheckResultBean.setDsTmttknitenchkkekkaKbn(C_DsTmttknitenchkkekkaKbn.SAISYUUHOKENNENDO);

                return dsTumitatekinItenCheckResultBean;
            }
            else if (TESTPATTERN6.equals(SYORIPTN)) {
                DsTumitatekinItenCheckResultBean dsTumitatekinItenCheckResultBean = SWAKInjector.getInstance(DsTumitatekinItenCheckResultBean.class);
                dsTumitatekinItenCheckResultBean.setErrorKbn(C_ErrorKbn.ERROR);
                dsTumitatekinItenCheckResultBean.setDsTmttknitenchkkekkaKbn(C_DsTmttknitenchkkekkaKbn.TMTTKNITENUKTKUMU);

                return dsTumitatekinItenCheckResultBean;
            }
            else if (TESTPATTERN7.equals(SYORIPTN)) {
                DsTumitatekinItenCheckResultBean dsTumitatekinItenCheckResultBean = SWAKInjector.getInstance(DsTumitatekinItenCheckResultBean.class);
                dsTumitatekinItenCheckResultBean.setErrorKbn(C_ErrorKbn.ERROR);
                dsTumitatekinItenCheckResultBean.setDsTmttknitenchkkekkaKbn(C_DsTmttknitenchkkekkaKbn.HOZENJYOUTAI);

                return dsTumitatekinItenCheckResultBean;
            }
            else if (TESTPATTERN8.equals(SYORIPTN)) {
                DsTumitatekinItenCheckResultBean dsTumitatekinItenCheckResultBean = SWAKInjector.getInstance(DsTumitatekinItenCheckResultBean.class);
                dsTumitatekinItenCheckResultBean.setErrorKbn(C_ErrorKbn.ERROR);
                dsTumitatekinItenCheckResultBean.setDsTmttknitenchkkekkaKbn(C_DsTmttknitenchkkekkaKbn.TETUDUKITYUUI);

                return dsTumitatekinItenCheckResultBean;
            }
            else if (TESTPATTERN9.equals(SYORIPTN)) {
                DsTumitatekinItenCheckResultBean dsTumitatekinItenCheckResultBean = SWAKInjector.getInstance(DsTumitatekinItenCheckResultBean.class);
                dsTumitatekinItenCheckResultBean.setErrorKbn(C_ErrorKbn.ERROR);
                dsTumitatekinItenCheckResultBean.setDsTmttknitenchkkekkaKbn(C_DsTmttknitenchkkekkaKbn.BLNK);

                return dsTumitatekinItenCheckResultBean;
            }
            else if (TESTPATTERN10.equals(SYORIPTN)) {
                DsTumitatekinItenCheckResultBean dsTumitatekinItenCheckResultBean = SWAKInjector.getInstance(DsTumitatekinItenCheckResultBean.class);
                dsTumitatekinItenCheckResultBean.setErrorKbn(C_ErrorKbn.OK);
                dsTumitatekinItenCheckResultBean.setDsTmttknitenchkkekkaKbn(C_DsTmttknitenchkkekkaKbn.BLNK);

                return dsTumitatekinItenCheckResultBean;
            }
        }
        else if (caller == DwTumitatekinItenUketukeTest_execPostFormUpdate.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                DsTumitatekinItenCheckResultBean dsTumitatekinItenCheckResultBean = SWAKInjector.getInstance(DsTumitatekinItenCheckResultBean.class);
                dsTumitatekinItenCheckResultBean.setErrorKbn(C_ErrorKbn.ERROR);
                dsTumitatekinItenCheckResultBean.setDsTmttknitenchkkekkaKbn(C_DsTmttknitenchkkekkaKbn.KYKYMDMITOURAI);

                return dsTumitatekinItenCheckResultBean;
            }
        }
        return super.checkTumitatekinIten(pSyono, pUktkymd, pTumitatekinitenyoteibi);

    }

    @Override
    public C_UmuKbn checkDsTumitatekinItenUketukeUmu(String pSyono){

        if (DwGetHozenKiykGikItijiNnknImplTest_execPostForm.class == caller) {

            if (TESTPATTERN1.equals(SYORIPTN)) {
                return C_UmuKbn.ARI;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                return C_UmuKbn.NONE;
            }
            return C_UmuKbn.ARI;
        }
        return super.checkDsTumitatekinItenUketukeUmu(pSyono);
    }
}