package yuyu.common.direct.dscommon;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import yuyu.common.hozen.khcommon.EditKykNaiyouOsiraseKytKmTest_editDsTourokuJyou;
import yuyu.common.hozen.khcommon.EditSouhuannaiTblTest_editBean;
import yuyu.def.classification.C_DsKrPswdGnkTtStrkHnCdKbn;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_UmuKbn;

/**
 * {@link GenkyouTuutiKariPasswordHakkou}のモッククラスです。<br />
 */
public class GenkyouTuutiKariPasswordHakkouMock extends GenkyouTuutiKariPasswordHakkou {

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

    @Override
    public GenkyouTuutiyouKariPasswordBean exec(String pSyoNo, BizDate pSyoriYmd) {

        if (caller == EditSouhuannaiTblTest_editBean.class && TESTPATTERN1.equals(SYORIPTN)) {
            GenkyouTuutiyouKariPasswordBean genkyouTuutiyouKariPasswordBean = SWAKInjector
                .getInstance(GenkyouTuutiyouKariPasswordBean.class);
            genkyouTuutiyouKariPasswordBean.setDsKaiykServiceTourokuUmu(C_UmuKbn.ARI);
            return genkyouTuutiyouKariPasswordBean;
        }
        else if (caller == EditSouhuannaiTblTest_editBean.class && TESTPATTERN2.equals(SYORIPTN)) {
            GenkyouTuutiyouKariPasswordBean genkyouTuutiyouKariPasswordBean = SWAKInjector
                .getInstance(GenkyouTuutiyouKariPasswordBean.class);
            genkyouTuutiyouKariPasswordBean.setDsKaiykServiceTourokuUmu(C_UmuKbn.NONE);
            return genkyouTuutiyouKariPasswordBean;
        }

        else if (caller == EditKykNaiyouOsiraseKytKmTest_editDsTourokuJyou.class && TESTPATTERN1.equals(SYORIPTN)) {
            GenkyouTuutiyouKariPasswordBean genkyouTuutiyouKariPasswordBean = SWAKInjector
                .getInstance(GenkyouTuutiyouKariPasswordBean.class);
            genkyouTuutiyouKariPasswordBean.setErrorkbn(C_ErrorKbn.ERROR);
            return genkyouTuutiyouKariPasswordBean;
        }
        else if (caller == EditKykNaiyouOsiraseKytKmTest_editDsTourokuJyou.class && TESTPATTERN2.equals(SYORIPTN)) {
            GenkyouTuutiyouKariPasswordBean genkyouTuutiyouKariPasswordBean = SWAKInjector
                .getInstance(GenkyouTuutiyouKariPasswordBean.class);
            genkyouTuutiyouKariPasswordBean.setErrorkbn(C_ErrorKbn.OK);
            genkyouTuutiyouKariPasswordBean.setDsKanyuuUmu(C_UmuKbn.ARI);
            genkyouTuutiyouKariPasswordBean.setDsKrPswdGnkTtStrkHnCdKbn(C_DsKrPswdGnkTtStrkHnCdKbn.SAIHAKKOUSEIKYUUZUMI);
            genkyouTuutiyouKariPasswordBean.setDsKaiykServiceTourokuUmu(C_UmuKbn.ARI);
            return genkyouTuutiyouKariPasswordBean;
        }
        else if (caller == EditKykNaiyouOsiraseKytKmTest_editDsTourokuJyou.class && TESTPATTERN3.equals(SYORIPTN)) {
            GenkyouTuutiyouKariPasswordBean genkyouTuutiyouKariPasswordBean = SWAKInjector
                .getInstance(GenkyouTuutiyouKariPasswordBean.class);
            genkyouTuutiyouKariPasswordBean.setErrorkbn(C_ErrorKbn.OK);
            genkyouTuutiyouKariPasswordBean.setDsKanyuuUmu(C_UmuKbn.ARI);
            genkyouTuutiyouKariPasswordBean.setDsKrPswdGnkTtStrkHnCdKbn(C_DsKrPswdGnkTtStrkHnCdKbn.KRPASSWORDMIHAKKOU);
            genkyouTuutiyouKariPasswordBean.setDsKaiykServiceTourokuUmu(C_UmuKbn.NONE);
            return genkyouTuutiyouKariPasswordBean;
        }
        else if (caller == EditKykNaiyouOsiraseKytKmTest_editDsTourokuJyou.class && TESTPATTERN4.equals(SYORIPTN)) {
            GenkyouTuutiyouKariPasswordBean genkyouTuutiyouKariPasswordBean = SWAKInjector
                .getInstance(GenkyouTuutiyouKariPasswordBean.class);
            genkyouTuutiyouKariPasswordBean.setErrorkbn(C_ErrorKbn.OK);
            genkyouTuutiyouKariPasswordBean.setDsKanyuuUmu(C_UmuKbn.ARI);
            genkyouTuutiyouKariPasswordBean.setDsKrPswdGnkTtStrkHnCdKbn(C_DsKrPswdGnkTtStrkHnCdKbn.BLNK);
            genkyouTuutiyouKariPasswordBean.setDsKaiykServiceTourokuUmu(C_UmuKbn.ARI);
            return genkyouTuutiyouKariPasswordBean;
        }
        else if (caller == EditKykNaiyouOsiraseKytKmTest_editDsTourokuJyou.class && TESTPATTERN5.equals(SYORIPTN)) {
            GenkyouTuutiyouKariPasswordBean genkyouTuutiyouKariPasswordBean = SWAKInjector
                .getInstance(GenkyouTuutiyouKariPasswordBean.class);
            genkyouTuutiyouKariPasswordBean.setErrorkbn(C_ErrorKbn.OK);
            genkyouTuutiyouKariPasswordBean.setDsKanyuuUmu(C_UmuKbn.ARI);
            genkyouTuutiyouKariPasswordBean.setDsKrPswdGnkTtStrkHnCdKbn(C_DsKrPswdGnkTtStrkHnCdKbn.ZANZONKIKANSUKUNAI);
            genkyouTuutiyouKariPasswordBean.setDsKaiykServiceTourokuUmu(C_UmuKbn.ARI);
            return genkyouTuutiyouKariPasswordBean;
        }
        else if (caller == EditKykNaiyouOsiraseKytKmTest_editDsTourokuJyou.class && TESTPATTERN6.equals(SYORIPTN)) {
            GenkyouTuutiyouKariPasswordBean genkyouTuutiyouKariPasswordBean = SWAKInjector
                .getInstance(GenkyouTuutiyouKariPasswordBean.class);
            genkyouTuutiyouKariPasswordBean.setErrorkbn(C_ErrorKbn.OK);
            genkyouTuutiyouKariPasswordBean.setDsKanyuuUmu(C_UmuKbn.ARI);
            genkyouTuutiyouKariPasswordBean.setDsKrPswdGnkTtStrkHnCdKbn(C_DsKrPswdGnkTtStrkHnCdKbn.SERVICETEISITYUU);
            genkyouTuutiyouKariPasswordBean.setDsKaiykServiceTourokuUmu(C_UmuKbn.ARI);
            return genkyouTuutiyouKariPasswordBean;
        }
        else if (caller == EditKykNaiyouOsiraseKytKmTest_editDsTourokuJyou.class && TESTPATTERN7.equals(SYORIPTN)) {
            GenkyouTuutiyouKariPasswordBean genkyouTuutiyouKariPasswordBean = SWAKInjector
                .getInstance(GenkyouTuutiyouKariPasswordBean.class);
            genkyouTuutiyouKariPasswordBean.setErrorkbn(C_ErrorKbn.OK);
            genkyouTuutiyouKariPasswordBean.setDsKanyuuUmu(C_UmuKbn.ARI);
            genkyouTuutiyouKariPasswordBean.setDsKrPswdGnkTtStrkHnCdKbn(C_DsKrPswdGnkTtStrkHnCdKbn.SERVICETEISITYUU);
            genkyouTuutiyouKariPasswordBean.setDsKaiykServiceTourokuUmu(C_UmuKbn.NONE);
            return genkyouTuutiyouKariPasswordBean;
        }
        else if (caller == EditKykNaiyouOsiraseKytKmTest_editDsTourokuJyou.class && TESTPATTERN8.equals(SYORIPTN)) {
            GenkyouTuutiyouKariPasswordBean genkyouTuutiyouKariPasswordBean = SWAKInjector
                .getInstance(GenkyouTuutiyouKariPasswordBean.class);
            genkyouTuutiyouKariPasswordBean.setErrorkbn(C_ErrorKbn.OK);
            genkyouTuutiyouKariPasswordBean.setDsKanyuuUmu(C_UmuKbn.NONE);
            return genkyouTuutiyouKariPasswordBean;
        }

        return super.exec(pSyoNo, pSyoriYmd);
    }
}
