package yuyu.common.bosyuu.hbcommon;

import java.util.List;

import yuyu.app.bosyuu.hbsekmos.hbseihowebcreditkessaiyouno.HbSeihoWebCreditkessaiyounoTest_execPostForm;
import yuyu.app.bosyuu.hbsekmos.hbseihowebheijyunkaiyakuhrsuii.HbSeihoWebHeijyunKaiyakuhrSuiiTest_execPostForm;
import yuyu.app.bosyuu.hbsekmos.hbseihowebkaiyakuhrsuii.HbSeihoWebKaiyakuhrSuiiTest_execPostForm;
import yuyu.app.bosyuu.hbsekmos.hbseihowebmosno.HbSeihoWebMosnoTest_execPostForm;
import yuyu.app.bosyuu.hbsekmos.hbseihowebnenkinkaiyakuhrsuii.HbSeihoWebNenkinKaiyakuhrSuiiTest_execPostForm;
import yuyu.app.bosyuu.hbsekmos.hbseihowebsekmos.HbSeihoWebSekMosTest_execPostForm;
import yuyu.app.bosyuu.hbsekmos.hbseihowebsekmos.HbSeihoWebSekMosTest_execPostForm2;
import yuyu.app.bosyuu.hbsksyoukai.hbseihowebmossyoukai.HbSeihoWebMosSyoukaiTest_execPostForm2;
import yuyu.common.biz.bzdairiten.BzGetAgInfoBean;
import yuyu.def.biz.bean.param.WsBzWebserviceReqParamBean;
import yuyu.def.bosyuu.bean.webservice.WsHbSeihoWebSekMosInputBean;
import yuyu.def.classification.C_SeihowebkengenKbn;
import yuyu.def.classification.C_SeihowebsousasyaKbn;

/**
 * {@link HbSeihoWebHanteiKengen}のモッククラスです。<br />
 */
public class HbSeihoWebHanteiKengenMockForSinkeiyaku extends HbSeihoWebHanteiKengen {

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static final String TESTPATTERN3 = "3";

    public static final String TESTPATTERN4 = "4";

    @Override
    public C_SeihowebkengenKbn execChkTanmatuKengen(WsBzWebserviceReqParamBean pWsBzWebserviceReqParamBean) {

        if (caller == HbSeihoWebCreditkessaiyounoTest_execPostForm.class) {

            if (TESTPATTERN1.equals(SYORIPTN) ||
                TESTPATTERN4.equals(SYORIPTN)) {
                return C_SeihowebkengenKbn.ARI;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                return C_SeihowebkengenKbn.TANMATUERROR;
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {
                return C_SeihowebkengenKbn.SIYOUSHAERROR;
            }
        }
        if (caller == HbSeihoWebSekMosTest_execPostForm2.class) {
            return C_SeihowebkengenKbn.ARI;
        }

        if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class) {

            if (TESTPATTERN1.equals(SYORIPTN)) {
                return C_SeihowebkengenKbn.ARI;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                return C_SeihowebkengenKbn.TANMATUERROR;
            }
            else {
                return C_SeihowebkengenKbn.SIYOUSHAERROR;
            }
        }

        if (caller == HbSeihoWebMosnoTest_execPostForm.class) {

            if (TESTPATTERN1.equals(SYORIPTN)) {
                return C_SeihowebkengenKbn.TANMATUERROR;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                return C_SeihowebkengenKbn.SIYOUSHAERROR;
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {
                return C_SeihowebkengenKbn.ARI;
            }
        }
        if (caller == HbSeihoWebNenkinKaiyakuhrSuiiTest_execPostForm.class) {

            if (TESTPATTERN1.equals(SYORIPTN)) {
                return C_SeihowebkengenKbn.TANMATUERROR;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                return C_SeihowebkengenKbn.SIYOUSHAERROR;
            }
            else if (TESTPATTERN4.equals(SYORIPTN)) {
                return C_SeihowebkengenKbn.ARI;
            }
        }
        if (caller == HbSeihoWebHeijyunKaiyakuhrSuiiTest_execPostForm.class) {

            if (TESTPATTERN1.equals(SYORIPTN)) {
                return C_SeihowebkengenKbn.TANMATUERROR;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                return C_SeihowebkengenKbn.SIYOUSHAERROR;
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {
                return C_SeihowebkengenKbn.ARI;
            }
        }

        return super.execChkTanmatuKengen(pWsBzWebserviceReqParamBean);
    }

    @Override
    public C_SeihowebsousasyaKbn getSeihowebUserKbn(WsBzWebserviceReqParamBean pWsBzWebserviceReqParamBean,
        String pAAtukaikojinCd) {

        if (caller == HbSeihoWebSekMosTest_execPostForm2.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return C_SeihowebsousasyaKbn.SUPPORTDESK;
            }else if (TESTPATTERN2.equals(SYORIPTN) ||
                TESTPATTERN4.equals(SYORIPTN)) {
                return C_SeihowebsousasyaKbn.DIRTNBSYNN;
            }

        }else if (caller == HbSeihoWebSekMosTest_execPostForm.class) {
            if (TESTPATTERN4.equals(SYORIPTN)) {
                return C_SeihowebsousasyaKbn.DIRTNBSYNN;
            }

        }

        return super.getSeihowebUserKbn(pWsBzWebserviceReqParamBean, pAAtukaikojinCd);
    }

    @Override
    public String convDairiten(WsBzWebserviceReqParamBean pWsBzWebserviceReqParamBean, String pConvDrtencd) {

        if (caller == HbSeihoWebSekMosTest_execPostForm2.class) {
            return "1200399";
        }
        return super.convDairiten(pWsBzWebserviceReqParamBean, pConvDrtencd);
    }

    @Override
    public String convAddressToDairiten(WsHbSeihoWebSekMosInputBean pWsHbSeihoWebSekMosInputBean, String pConvDrtencd) {

        if (caller == HbSeihoWebSekMosTest_execPostForm2.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return "1999999";
            }

            if (TESTPATTERN2.equals(SYORIPTN)) {
                return "5100001";
            }

        }
        return super.convAddressToDairiten(pWsHbSeihoWebSekMosInputBean, pConvDrtencd);
    }

    @Override
    public C_SeihowebkengenKbn execChkDairitenKengen(WsBzWebserviceReqParamBean pWsBzWebserviceReqParamBean,
        List<BzGetAgInfoBean> pBzGetAgInfoBeanLstA,
        List<BzGetAgInfoBean> pBzGetAgInfoBeanLstB) {
        if (caller == HbSeihoWebMosSyoukaiTest_execPostForm2.class) {
            return C_SeihowebkengenKbn.ARI;
        }
        return super.execChkDairitenKengen(pWsBzWebserviceReqParamBean, pBzGetAgInfoBeanLstA, pBzGetAgInfoBeanLstB);
    }

}
