package yuyu.common.direct.dscommon;

import yuyu.app.dsweb.dwdsinfo.dwgetdskanyuukeiyakuitiran.DwGetDsKanyuuKeiyakuItiranTest_execPostForm;
import yuyu.common.direct.dscommon.CheckKaiyakuUketukeTest_kaiyakusyokaiChk;
import yuyu.common.direct.dscommon.DsGetKeiyakuSyousaiTest_exec;
import yuyu.common.direct.dscommon.DsGetSeigyoTest_getSyoriKahi;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_DsDataMaintenanceRiyuuKbn;

/**
 * {@link DsDataMaintenanceHantei}のモッククラスです。<br />
 */
public class DsDataMaintenanceHanteiMock extends DsDataMaintenanceHantei {

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static final String TESTPATTERN3 = "3";

    public static final String TESTPATTERN4 = "4";

    public static final String TESTPATTERN5 = "5";

    @Override
    public DsDataMaintenanceHanteiBean exec(String pSyoNo) {

        if (DwGetDsKanyuuKeiyakuItiranTest_execPostForm.class == caller) {

            DsDataMaintenanceHanteiBean dsDataMaintenanceHanteiBean = new DsDataMaintenanceHanteiBean();

            if (TESTPATTERN1.equals(SYORIPTN)) {
                dsDataMaintenanceHanteiBean.setKekkaKbn(C_ErrorKbn.OK);
                dsDataMaintenanceHanteiBean.setDsDataMaintenanceUmuKbn(C_UmuKbn.NONE);
                dsDataMaintenanceHanteiBean.setDsDataMaintenanceRiyuuKbn(C_DsDataMaintenanceRiyuuKbn.BLNK);
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                dsDataMaintenanceHanteiBean.setKekkaKbn(C_ErrorKbn.ERROR);
                dsDataMaintenanceHanteiBean.setDsDataMaintenanceUmuKbn(C_UmuKbn.NONE);
                dsDataMaintenanceHanteiBean.setDsDataMaintenanceRiyuuKbn(C_DsDataMaintenanceRiyuuKbn.BLNK);
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {
                dsDataMaintenanceHanteiBean.setKekkaKbn(C_ErrorKbn.OK);
                dsDataMaintenanceHanteiBean.setDsDataMaintenanceUmuKbn(C_UmuKbn.ARI);
                dsDataMaintenanceHanteiBean.setDsDataMaintenanceRiyuuKbn(C_DsDataMaintenanceRiyuuKbn.BLNK);
            }

            return dsDataMaintenanceHanteiBean;
        }

        if (caller == DsGetSeigyoTest_getSyoriKahi.class) {

            DsDataMaintenanceHanteiBean dsDataMaintenanceHanteiBean = new DsDataMaintenanceHanteiBean();

            if (TESTPATTERN1.equals(SYORIPTN)) {
                dsDataMaintenanceHanteiBean.setKekkaKbn(C_ErrorKbn.ERROR);
                dsDataMaintenanceHanteiBean.setDsDataMaintenanceUmuKbn(C_UmuKbn.NONE);
            }

            else if (TESTPATTERN2.equals(SYORIPTN)) {
                dsDataMaintenanceHanteiBean.setKekkaKbn(C_ErrorKbn.OK);
                dsDataMaintenanceHanteiBean.setDsDataMaintenanceUmuKbn(C_UmuKbn.ARI);
            }

            else if (TESTPATTERN3.equals(SYORIPTN)) {
                dsDataMaintenanceHanteiBean.setKekkaKbn(C_ErrorKbn.OK);
                dsDataMaintenanceHanteiBean.setDsDataMaintenanceUmuKbn(C_UmuKbn.NONE);
            }

            return dsDataMaintenanceHanteiBean;
        }

        if (CheckKaiyakuUketukeTest_kaiyakusyokaiChk.class == caller) {

            DsDataMaintenanceHanteiBean dsDataMaintenanceHanteiBean = new DsDataMaintenanceHanteiBean();

            if (TESTPATTERN1.equals(SYORIPTN)) {
                dsDataMaintenanceHanteiBean.setKekkaKbn(C_ErrorKbn.OK);
                dsDataMaintenanceHanteiBean.setDsDataMaintenanceUmuKbn(C_UmuKbn.NONE);
                dsDataMaintenanceHanteiBean.setDsDataMaintenanceRiyuuKbn(C_DsDataMaintenanceRiyuuKbn.BLNK);
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                dsDataMaintenanceHanteiBean.setKekkaKbn(C_ErrorKbn.ERROR);
                dsDataMaintenanceHanteiBean.setDsDataMaintenanceUmuKbn(C_UmuKbn.ARI);
                dsDataMaintenanceHanteiBean.setDsDataMaintenanceRiyuuKbn(C_DsDataMaintenanceRiyuuKbn.BLNK);
            }

            return dsDataMaintenanceHanteiBean;
        }

        if (DsGetKeiyakuSyousaiTest_exec.class == caller) {

            DsDataMaintenanceHanteiBean dsDataMaintenanceHanteiBean = new DsDataMaintenanceHanteiBean();

            if (TESTPATTERN1.equals(SYORIPTN)) {
                dsDataMaintenanceHanteiBean.setKekkaKbn(C_ErrorKbn.OK);
                dsDataMaintenanceHanteiBean.setDsDataMaintenanceUmuKbn(C_UmuKbn.ARI);
                dsDataMaintenanceHanteiBean.setDsDataMaintenanceRiyuuKbn(C_DsDataMaintenanceRiyuuKbn.BLNK);
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                dsDataMaintenanceHanteiBean.setKekkaKbn(C_ErrorKbn.ERROR);
                dsDataMaintenanceHanteiBean.setDsDataMaintenanceUmuKbn(C_UmuKbn.NONE);
                dsDataMaintenanceHanteiBean.setDsDataMaintenanceRiyuuKbn(C_DsDataMaintenanceRiyuuKbn.BLNK);
            }

            return dsDataMaintenanceHanteiBean;
        }

        return super.exec(pSyoNo);
    }
}
