package yuyu.common.direct.dscommon;

import yuyu.app.dsweb.dwhozeninfo.dwgethozenkeiyakuenitijisyusin.DwGetHozenKeiyakuEnItijiSyusinImplTest_execPostForm;
import yuyu.app.dsweb.dwhozeninfo.dwgethozenkiykgikhijynnnkn.DwGetHozenKiykGikHijynNnknImplTest_execPostForm;
import yuyu.app.dsweb.dwhozeninfo.dwgethozenkiykgikitijinnkn.DwGetHozenKiykGikItijiNnknImplTest_execPostForm;
import yuyu.app.dsweb.dwhozeninfo.dwgethozenkykenitijinnkn.DwGetHozenKykEnItijiNnknImplTest_execPostForm;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_KahiKbn;
import yuyu.def.classification.C_UmuKbn;

/**
 * {@link DsGetSeigyo}のモッククラスです。<br />
 */
public class DsGetSeigyoMock extends DsGetSeigyo {

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static final String TESTPATTERN3 = "3";

    public static final String TESTPATTERN4 = "4";

    public static final String TESTPATTERN5 = "5";

    @Override
    public GamenSeigyoBean getGamenSeigyo(DsSyouhinBean pDsSyouhinBean) {

        if (DwGetHozenKeiyakuEnItijiSyusinImplTest_execPostForm.class == caller) {

            GamenSeigyoBean gamenSeigyoBean = new GamenSeigyoBean();

            if (TESTPATTERN1.equals(SYORIPTN)) {
                gamenSeigyoBean.setErrorKbn(C_ErrorKbn.ERROR);
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                gamenSeigyoBean.setErrorKbn(C_ErrorKbn.OK);
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {
                gamenSeigyoBean.setErrorKbn(C_ErrorKbn.OK);
            }
            else if (TESTPATTERN4.equals(SYORIPTN)) {
                gamenSeigyoBean.setErrorKbn(C_ErrorKbn.OK);
            }
            else if (TESTPATTERN5.equals(SYORIPTN)) {
                gamenSeigyoBean.setErrorKbn(C_ErrorKbn.OK);
                gamenSeigyoBean.setTutakinUmukbn(C_UmuKbn.ARI);
            }
            return gamenSeigyoBean;
        }

        if (DwGetHozenKiykGikItijiNnknImplTest_execPostForm.class == caller) {

            GamenSeigyoBean gamenSeigyoBean = new GamenSeigyoBean();

            if (TESTPATTERN1.equals(SYORIPTN)) {
                gamenSeigyoBean.setErrorKbn(C_ErrorKbn.ERROR);
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                gamenSeigyoBean.setErrorKbn(C_ErrorKbn.OK);
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {
                gamenSeigyoBean.setErrorKbn(C_ErrorKbn.OK);
            }
            else if (TESTPATTERN4.equals(SYORIPTN)) {
                gamenSeigyoBean.setErrorKbn(C_ErrorKbn.OK);
            }
            else if (TESTPATTERN5.equals(SYORIPTN)) {
                gamenSeigyoBean.setErrorKbn(C_ErrorKbn.OK);
                gamenSeigyoBean.setTutakinUmukbn(C_UmuKbn.ARI);
                gamenSeigyoBean.setKaiyakuHrsuiiUmuKbn(C_UmuKbn.NONE);
            }
            return gamenSeigyoBean;
        }

        if (DwGetHozenKiykGikHijynNnknImplTest_execPostForm.class == caller) {

            GamenSeigyoBean gamenSeigyoBean = new GamenSeigyoBean();

            if (TESTPATTERN1.equals(SYORIPTN)) {
                gamenSeigyoBean.setErrorKbn(C_ErrorKbn.ERROR);
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                gamenSeigyoBean.setErrorKbn(C_ErrorKbn.OK);
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {
                gamenSeigyoBean.setErrorKbn(C_ErrorKbn.OK);
            }
            else if (TESTPATTERN4.equals(SYORIPTN)) {
                gamenSeigyoBean.setErrorKbn(C_ErrorKbn.OK);
            }
            else if (TESTPATTERN5.equals(SYORIPTN)) {
                gamenSeigyoBean.setErrorKbn(C_ErrorKbn.OK);
                gamenSeigyoBean.setTutakinUmukbn(C_UmuKbn.ARI);
                gamenSeigyoBean.setKaiyakuHrsuiiUmuKbn(C_UmuKbn.ARI);
            }
            return gamenSeigyoBean;
        }
        if (DwGetHozenKykEnItijiNnknImplTest_execPostForm.class == caller) {

            GamenSeigyoBean gamenSeigyoBean = new GamenSeigyoBean();

            if (TESTPATTERN1.equals(SYORIPTN)) {
                gamenSeigyoBean.setErrorKbn(C_ErrorKbn.ERROR);
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                gamenSeigyoBean.setErrorKbn(C_ErrorKbn.OK);
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {
                gamenSeigyoBean.setErrorKbn(C_ErrorKbn.OK);
            }
            else if (TESTPATTERN4.equals(SYORIPTN)) {
                gamenSeigyoBean.setErrorKbn(C_ErrorKbn.OK);
            }
            else if (TESTPATTERN5.equals(SYORIPTN)) {
                gamenSeigyoBean.setErrorKbn(C_ErrorKbn.OK);
                gamenSeigyoBean.setTutakinUmukbn(C_UmuKbn.ARI);
            }
            return gamenSeigyoBean;
        }

        return super.getGamenSeigyo(pDsSyouhinBean);
    }

    @Override
    public HosyouBean getHosyou(DsSyouhinBean pDsSyouhinBean) {

        if (DwGetHozenKeiyakuEnItijiSyusinImplTest_execPostForm.class == caller) {

            HosyouBean hosyouBean = new HosyouBean();

            if (TESTPATTERN1.equals(SYORIPTN)) {
                hosyouBean.setErrorKbn(C_ErrorKbn.OK);
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                hosyouBean.setErrorKbn(C_ErrorKbn.ERROR);
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {
                hosyouBean.setErrorKbn(C_ErrorKbn.OK);
            }
            else if (TESTPATTERN4.equals(SYORIPTN)) {
                hosyouBean.setErrorKbn(C_ErrorKbn.OK);
            }
            else if (TESTPATTERN5.equals(SYORIPTN)) {
                hosyouBean.setErrorKbn(C_ErrorKbn.OK);
                hosyouBean.setSbHsyUmuKbn(C_UmuKbn.ARI);
                hosyouBean.setKgHsyUmukbn(C_UmuKbn.ARI);
                hosyouBean.setIryHsyUmukbn(C_UmuKbn.ARI);
                hosyouBean.setRougoHsyUmukbn(C_UmuKbn.ARI);
            }
            return hosyouBean;
        }

        if (DwGetHozenKiykGikItijiNnknImplTest_execPostForm.class == caller) {
            HosyouBean hosyouBean = new HosyouBean();

            if (TESTPATTERN1.equals(SYORIPTN)) {
                hosyouBean.setErrorKbn(C_ErrorKbn.OK);
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                hosyouBean.setErrorKbn(C_ErrorKbn.ERROR);
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {
                hosyouBean.setErrorKbn(C_ErrorKbn.OK);
            }
            else if (TESTPATTERN4.equals(SYORIPTN)) {
                hosyouBean.setErrorKbn(C_ErrorKbn.OK);
            }
            else if (TESTPATTERN5.equals(SYORIPTN)) {
                hosyouBean.setErrorKbn(C_ErrorKbn.OK);
                hosyouBean.setSbHsyUmuKbn(C_UmuKbn.ARI);
                hosyouBean.setKgHsyUmukbn(C_UmuKbn.ARI);
                hosyouBean.setIryHsyUmukbn(C_UmuKbn.ARI);
                hosyouBean.setRougoHsyUmukbn(C_UmuKbn.ARI);
            }
            return hosyouBean;
        }

        if (DwGetHozenKiykGikHijynNnknImplTest_execPostForm.class == caller) {
            HosyouBean hosyouBean = new HosyouBean();

            if (TESTPATTERN1.equals(SYORIPTN)) {
                hosyouBean.setErrorKbn(C_ErrorKbn.OK);
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                hosyouBean.setErrorKbn(C_ErrorKbn.ERROR);
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {
                hosyouBean.setErrorKbn(C_ErrorKbn.OK);
            }
            else if (TESTPATTERN4.equals(SYORIPTN)) {
                hosyouBean.setErrorKbn(C_ErrorKbn.OK);
            }
            else if (TESTPATTERN5.equals(SYORIPTN)) {
                hosyouBean.setErrorKbn(C_ErrorKbn.OK);
                hosyouBean.setSbHsyUmuKbn(C_UmuKbn.ARI);
                hosyouBean.setKgHsyUmukbn(C_UmuKbn.ARI);
                hosyouBean.setIryHsyUmukbn(C_UmuKbn.ARI);
                hosyouBean.setRougoHsyUmukbn(C_UmuKbn.ARI);
            }
            return hosyouBean;
        }
        if (DwGetHozenKykEnItijiNnknImplTest_execPostForm.class == caller) {
            HosyouBean hosyouBean = new HosyouBean();

            if (TESTPATTERN1.equals(SYORIPTN)) {
                hosyouBean.setErrorKbn(C_ErrorKbn.OK);
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                hosyouBean.setErrorKbn(C_ErrorKbn.ERROR);
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {
                hosyouBean.setErrorKbn(C_ErrorKbn.OK);
            }
            else if (TESTPATTERN4.equals(SYORIPTN)) {
                hosyouBean.setErrorKbn(C_ErrorKbn.OK);
            }
            else if (TESTPATTERN5.equals(SYORIPTN)) {
                hosyouBean.setErrorKbn(C_ErrorKbn.OK);
                hosyouBean.setSbHsyUmuKbn(C_UmuKbn.ARI);
                hosyouBean.setKgHsyUmukbn(C_UmuKbn.ARI);
                hosyouBean.setIryHsyUmukbn(C_UmuKbn.ARI);
                hosyouBean.setRougoHsyUmukbn(C_UmuKbn.ARI);

            }
            return hosyouBean;
        }

        return super.getHosyou(pDsSyouhinBean);
    }

    @Override
    public TokuyakuBean getTokuyaku(DsSyouhinBean pDsSyouhinBean) {

        if (DwGetHozenKeiyakuEnItijiSyusinImplTest_execPostForm.class == caller) {

            TokuyakuBean tokuyakuBean = new TokuyakuBean();

            if (TESTPATTERN1.equals(SYORIPTN)) {
                tokuyakuBean.setErrorKbn(C_ErrorKbn.OK);
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                tokuyakuBean.setErrorKbn(C_ErrorKbn.OK);
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {
                tokuyakuBean.setErrorKbn(C_ErrorKbn.ERROR);
            }
            else if (TESTPATTERN4.equals(SYORIPTN)) {
                tokuyakuBean.setErrorKbn(C_ErrorKbn.OK);
            }
            else if (TESTPATTERN5.equals(SYORIPTN)) {
                tokuyakuBean.setErrorKbn(C_ErrorKbn.OK);
                tokuyakuBean.setStdrskTkyhkumu(C_UmuKbn.ARI);
                tokuyakuBean.setYenNyknThkumu(C_UmuKbn.ARI);
                tokuyakuBean.setGaikaNyknTkhkumu(C_UmuKbn.ARI);
                tokuyakuBean.setTargetTkhkumu(C_UmuKbn.ARI);
                tokuyakuBean.setInitSbjiYenSitiHsyTkhukaumu(C_UmuKbn.ARI);
                tokuyakuBean.setJyudKaigoMeharaiTkhukaumu(C_UmuKbn.ARI);
                tokuyakuBean.setZeiseiTkkkTkykhukaumu(C_UmuKbn.ARI);
            }
            return tokuyakuBean;
        }

        if (DwGetHozenKiykGikItijiNnknImplTest_execPostForm.class == caller) {

            TokuyakuBean tokuyakuBean = new TokuyakuBean();

            if (TESTPATTERN1.equals(SYORIPTN)) {
                tokuyakuBean.setErrorKbn(C_ErrorKbn.OK);
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                tokuyakuBean.setErrorKbn(C_ErrorKbn.OK);
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {
                tokuyakuBean.setErrorKbn(C_ErrorKbn.ERROR);
            }
            else if (TESTPATTERN4.equals(SYORIPTN)) {
                tokuyakuBean.setErrorKbn(C_ErrorKbn.OK);
            }
            else if (TESTPATTERN5.equals(SYORIPTN)) {
                tokuyakuBean.setErrorKbn(C_ErrorKbn.OK);
                tokuyakuBean.setStdrskTkyhkumu(C_UmuKbn.ARI);
                tokuyakuBean.setYenNyknThkumu(C_UmuKbn.ARI);
                tokuyakuBean.setGaikaNyknTkhkumu(C_UmuKbn.ARI);
                tokuyakuBean.setTargetTkhkumu(C_UmuKbn.ARI);
                tokuyakuBean.setInitSbjiYenSitiHsyTkhukaumu(C_UmuKbn.ARI);
                tokuyakuBean.setJyudKaigoMeharaiTkhukaumu(C_UmuKbn.ARI);
                tokuyakuBean.setZeiseiTkkkTkykhukaumu(C_UmuKbn.ARI);
            }
            return tokuyakuBean;
        }

        if (DwGetHozenKiykGikHijynNnknImplTest_execPostForm.class == caller) {

            TokuyakuBean tokuyakuBean = new TokuyakuBean();

            if (TESTPATTERN1.equals(SYORIPTN)) {
                tokuyakuBean.setErrorKbn(C_ErrorKbn.OK);
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                tokuyakuBean.setErrorKbn(C_ErrorKbn.OK);
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {
                tokuyakuBean.setErrorKbn(C_ErrorKbn.ERROR);
            }
            else if (TESTPATTERN4.equals(SYORIPTN)) {
                tokuyakuBean.setErrorKbn(C_ErrorKbn.OK);
            }
            else if (TESTPATTERN5.equals(SYORIPTN)) {
                tokuyakuBean.setErrorKbn(C_ErrorKbn.OK);
                tokuyakuBean.setStdrskTkyhkumu(C_UmuKbn.ARI);
                tokuyakuBean.setYenNyknThkumu(C_UmuKbn.ARI);
                tokuyakuBean.setGaikaNyknTkhkumu(C_UmuKbn.ARI);
                tokuyakuBean.setTargetTkhkumu(C_UmuKbn.ARI);
                tokuyakuBean.setInitSbjiYenSitiHsyTkhukaumu(C_UmuKbn.ARI);
                tokuyakuBean.setJyudKaigoMeharaiTkhukaumu(C_UmuKbn.ARI);
                tokuyakuBean.setZeiseiTkkkTkykhukaumu(C_UmuKbn.ARI);
            }
            return tokuyakuBean;
        }

        if (DwGetHozenKykEnItijiNnknImplTest_execPostForm.class == caller) {

            TokuyakuBean tokuyakuBean = new TokuyakuBean();

            if (TESTPATTERN1.equals(SYORIPTN)) {
                tokuyakuBean.setErrorKbn(C_ErrorKbn.OK);
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                tokuyakuBean.setErrorKbn(C_ErrorKbn.OK);
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {
                tokuyakuBean.setErrorKbn(C_ErrorKbn.ERROR);
            }
            else if (TESTPATTERN4.equals(SYORIPTN)) {
                tokuyakuBean.setErrorKbn(C_ErrorKbn.OK);
            }
            else if (TESTPATTERN5.equals(SYORIPTN)) {
                tokuyakuBean.setErrorKbn(C_ErrorKbn.OK);
                tokuyakuBean.setStdrskTkyhkumu(C_UmuKbn.ARI);
            }
            return tokuyakuBean;
        }

        return super.getTokuyaku(pDsSyouhinBean);
    }

    @Override
    public SyoriKahiBean getSyoriKahi(DsSyouhinBean pDsSyouhinBean) {

        if (DwGetHozenKeiyakuEnItijiSyusinImplTest_execPostForm.class == caller) {

            SyoriKahiBean syoriKahiBean = new SyoriKahiBean();

            if (TESTPATTERN1.equals(SYORIPTN)) {
                syoriKahiBean.setErrorKbn(C_ErrorKbn.OK);
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                syoriKahiBean.setErrorKbn(C_ErrorKbn.OK);
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {
                syoriKahiBean.setErrorKbn(C_ErrorKbn.OK);
            }
            else if (TESTPATTERN4.equals(SYORIPTN)) {
                syoriKahiBean.setErrorKbn(C_ErrorKbn.ERROR);
            }
            else if (TESTPATTERN5.equals(SYORIPTN)) {
                syoriKahiBean.setErrorKbn(C_ErrorKbn.OK);
                syoriKahiBean.setKjsmSaihakkouKahiKbn(C_KahiKbn.KA);
                syoriKahiBean.setKykMeigihnkKahiKbn(C_KahiKbn.KA);
                syoriKahiBean.setSyoukenSaihkKahiKbn(C_KahiKbn.KA);
                syoriKahiBean.setStdrskTkyTthkKahiKbn(C_KahiKbn.KA);
                syoriKahiBean.setTargetTkhkKahiKbn(C_KahiKbn.KA);
                syoriKahiBean.setKykNiyuSyoukaiKahiKbn(C_KahiKbn.KA);
                syoriKahiBean.setTumitatekinItenKahiKbn(C_KahiKbn.KA);
                syoriKahiBean.setDsKaiyakuKahiKbn(C_KahiKbn.KA);
                syoriKahiBean.setAdrHenkouKahiKbn(C_KahiKbn.KA);
            }
            return syoriKahiBean;
        }

        if (DwGetHozenKiykGikItijiNnknImplTest_execPostForm.class == caller) {

            SyoriKahiBean syoriKahiBean = new SyoriKahiBean();

            if (TESTPATTERN1.equals(SYORIPTN)) {
                syoriKahiBean.setErrorKbn(C_ErrorKbn.OK);
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                syoriKahiBean.setErrorKbn(C_ErrorKbn.OK);
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {
                syoriKahiBean.setErrorKbn(C_ErrorKbn.OK);
            }
            else if (TESTPATTERN4.equals(SYORIPTN)) {
                syoriKahiBean.setErrorKbn(C_ErrorKbn.ERROR);
            }
            else if (TESTPATTERN5.equals(SYORIPTN)) {
                syoriKahiBean.setErrorKbn(C_ErrorKbn.OK);
                syoriKahiBean.setKjsmSaihakkouKahiKbn(C_KahiKbn.KA);
                syoriKahiBean.setKykMeigihnkKahiKbn(C_KahiKbn.KA);
                syoriKahiBean.setSyoukenSaihkKahiKbn(C_KahiKbn.KA);
                syoriKahiBean.setStdrskTkyTthkKahiKbn(C_KahiKbn.KA);
                syoriKahiBean.setTargetTkhkKahiKbn(C_KahiKbn.KA);
                syoriKahiBean.setKykNiyuSyoukaiKahiKbn(C_KahiKbn.KA);
                syoriKahiBean.setTumitatekinItenKahiKbn(C_KahiKbn.KA);
                syoriKahiBean.setDsKaiyakuKahiKbn(C_KahiKbn.KA);
                syoriKahiBean.setAdrHenkouKahiKbn(C_KahiKbn.KA);
            }
            return syoriKahiBean;
        }

        if (DwGetHozenKiykGikHijynNnknImplTest_execPostForm.class == caller) {

            SyoriKahiBean syoriKahiBean = new SyoriKahiBean();

            if (TESTPATTERN1.equals(SYORIPTN)) {
                syoriKahiBean.setErrorKbn(C_ErrorKbn.OK);
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                syoriKahiBean.setErrorKbn(C_ErrorKbn.OK);
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {
                syoriKahiBean.setErrorKbn(C_ErrorKbn.OK);
            }
            else if (TESTPATTERN4.equals(SYORIPTN)) {
                syoriKahiBean.setErrorKbn(C_ErrorKbn.ERROR);
            }
            else if (TESTPATTERN5.equals(SYORIPTN)) {
                syoriKahiBean.setErrorKbn(C_ErrorKbn.OK);
                syoriKahiBean.setKjsmSaihakkouKahiKbn(C_KahiKbn.KA);
                syoriKahiBean.setKykMeigihnkKahiKbn(C_KahiKbn.KA);
                syoriKahiBean.setSyoukenSaihkKahiKbn(C_KahiKbn.KA);
                syoriKahiBean.setStdrskTkyTthkKahiKbn(C_KahiKbn.KA);
                syoriKahiBean.setTargetTkhkKahiKbn(C_KahiKbn.KA);
                syoriKahiBean.setKykNiyuSyoukaiKahiKbn(C_KahiKbn.KA);
                syoriKahiBean.setTumitatekinItenKahiKbn(C_KahiKbn.KA);
                syoriKahiBean.setDsKaiyakuKahiKbn(C_KahiKbn.KA);
                syoriKahiBean.setAdrHenkouKahiKbn(C_KahiKbn.KA);
            }
            return syoriKahiBean;
        }
        if (DwGetHozenKykEnItijiNnknImplTest_execPostForm.class == caller) {

            SyoriKahiBean syoriKahiBean = new SyoriKahiBean();

            if (TESTPATTERN1.equals(SYORIPTN)) {
                syoriKahiBean.setErrorKbn(C_ErrorKbn.OK);
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                syoriKahiBean.setErrorKbn(C_ErrorKbn.OK);
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {
                syoriKahiBean.setErrorKbn(C_ErrorKbn.OK);
            }
            else if (TESTPATTERN4.equals(SYORIPTN)) {
                syoriKahiBean.setErrorKbn(C_ErrorKbn.ERROR);
            }
            else if (TESTPATTERN5.equals(SYORIPTN)) {
                syoriKahiBean.setErrorKbn(C_ErrorKbn.OK);
                syoriKahiBean.setKjsmSaihakkouKahiKbn(C_KahiKbn.KA);
                syoriKahiBean.setKykMeigihnkKahiKbn(C_KahiKbn.KA);
                syoriKahiBean.setSyoukenSaihkKahiKbn(C_KahiKbn.KA);
                syoriKahiBean.setStdrskTkyTthkKahiKbn(C_KahiKbn.KA);
                syoriKahiBean.setTargetTkhkKahiKbn(C_KahiKbn.KA);
                syoriKahiBean.setKykNiyuSyoukaiKahiKbn(C_KahiKbn.KA);
                syoriKahiBean.setTumitatekinItenKahiKbn(C_KahiKbn.KA);
                syoriKahiBean.setDsKaiyakuKahiKbn(C_KahiKbn.KA);
                syoriKahiBean.setAdrHenkouKahiKbn(C_KahiKbn.KA);
            }
            return syoriKahiBean;
        }

        return super.getSyoriKahi(pDsSyouhinBean);
    }
}
