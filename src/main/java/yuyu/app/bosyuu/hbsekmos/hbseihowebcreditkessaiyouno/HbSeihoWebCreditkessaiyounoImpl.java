package yuyu.app.bosyuu.hbsekmos.hbseihowebcreditkessaiyouno;

import javax.inject.Inject;
import javax.ws.rs.core.MultivaluedMap;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.file.exception.CvtVdtException;
import jp.co.slcs.swak.file.util.FixedlengthConvertUtil;

import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;

import yuyu.common.biz.bzwebserviceaccesslogoutput.WebServiceAccesslogOutput;
import yuyu.common.bosyuu.hbcommon.HbSeihoWebHanteiKengen;
import yuyu.common.hozen.khcommon.SaibanCreditKessaiyouNo;
import yuyu.def.biz.bean.param.WsBzWebserviceReqParamBean;
import yuyu.def.biz.bean.param.WsBzWebserviceResParamBean;
import yuyu.def.bosyuu.bean.webservice.WsHbSeihoWebCreditkessaiyounoInputBean;
import yuyu.def.bosyuu.bean.webservice.WsHbSeihoWebCreditkessaiyounoOutputBean;
import yuyu.def.classification.C_AccessLogSyubetuKbn;
import yuyu.def.classification.C_CreditCardKeySyuruiKbn;
import yuyu.def.classification.C_SeihowebkengenKbn;

import com.google.common.base.Strings;

/**
 * 生保Ｗｅｂクレジットカード決済用番号取得サービスの実装クラスです。<br />
 */
public class HbSeihoWebCreditkessaiyounoImpl implements HbSeihoWebCreditkessaiyouno {

    private static final String ERRORKBN_CREDITKESSAIYOUNO_OK = "0";

    private static final String ERRORKBN_CREDITKESSAIYOUNO_NONE = "1";

    @Inject
    private static Logger logger;

    @Override
    public WsBzWebserviceResParamBean execPostForm(MultivaluedMap<String, String> pMap) throws Exception {

        String errHukaMsg = "";

        try {
            logger.debug("▽ 生保Ｗｅｂクレジットカード決済用番号取得 開始");

            WsBzWebserviceReqParamBean wsBzWebserviceReqParamBean = SWAKInjector.getInstance(WsBzWebserviceReqParamBean.class);
            WsBzWebserviceResParamBean wsBzWebserviceResParamBean = SWAKInjector.getInstance(WsBzWebserviceResParamBean.class);
            WsHbSeihoWebCreditkessaiyounoInputBean wsHbSeihoWebCreditkessaiyounoInputBean =
                SWAKInjector.getInstance(WsHbSeihoWebCreditkessaiyounoInputBean.class);

            BeanUtils.populate(wsBzWebserviceReqParamBean, pMap);

            String gyoumuData = wsBzWebserviceReqParamBean.getGyoumuData();

            WsHbSeihoWebCreditkessaiyounoOutputBean wsHbSeihoWebCreditkessaiyounoOutputBean = initOutputBean();

            try {
                wsHbSeihoWebCreditkessaiyounoInputBean =
                    FixedlengthConvertUtil.stringToBeanForFixedlength(gyoumuData, WsHbSeihoWebCreditkessaiyounoInputBean.class);

            } catch (RuntimeException e) {

                if (e.getCause() != null && e.getCause() instanceof CvtVdtException) {

                    logger.debug("△ 生保Ｗｅｂクレジットカード決済用番号取得 入力値エラー");

                    wsHbSeihoWebCreditkessaiyounoOutputBean.setIwsErrkbn(ERRORKBN_CREDITKESSAIYOUNO_NONE);

                    paddingOutputBean(wsHbSeihoWebCreditkessaiyounoOutputBean);

                    logger.debug("WsHbSeihoWebCreditkessaiyounoOutputBean:"+ wsHbSeihoWebCreditkessaiyounoOutputBean.toString());


                    wsBzWebserviceResParamBean.setGyoumuData(
                        FixedlengthConvertUtil.beanToStringForFixedlength(wsHbSeihoWebCreditkessaiyounoOutputBean));

                    logger.debug("△ 生保Ｗｅｂクレジットカード決済用番号取得 終了");

                    return wsBzWebserviceResParamBean;
                }

                errHukaMsg = creatErrorMsg("入力値エラー" , wsBzWebserviceReqParamBean);
                throw e;
            }

            WebServiceAccesslogOutput webServiceAccesslogOutput =
                SWAKInjector.getInstance(WebServiceAccesslogOutput.class);
            webServiceAccesslogOutput.exec(
                C_AccessLogSyubetuKbn.ACTION_BEGIN, wsBzWebserviceReqParamBean, wsHbSeihoWebCreditkessaiyounoInputBean);

            HbSeihoWebHanteiKengen hbSeihoWebHanteiKengen = SWAKInjector.getInstance(HbSeihoWebHanteiKengen.class);
            C_SeihowebkengenKbn seihowebkengenKbn= hbSeihoWebHanteiKengen.execChkTanmatuKengen(wsBzWebserviceReqParamBean);

            if (C_SeihowebkengenKbn.TANMATUERROR.eq(seihowebkengenKbn) || C_SeihowebkengenKbn.SIYOUSHAERROR.eq(seihowebkengenKbn)) {
                if (C_SeihowebkengenKbn.TANMATUERROR.eq(seihowebkengenKbn)) {
                    logger.debug("△ 生保Ｗｅｂクレジットカード決済用番号取得 端末権限エラー");
                }
                else {
                    logger.debug("△ 生保Ｗｅｂクレジットカード決済用番号取得 使用者権限エラー");
                }

                wsHbSeihoWebCreditkessaiyounoOutputBean.setIwsErrkbn(ERRORKBN_CREDITKESSAIYOUNO_NONE);

                paddingOutputBean(wsHbSeihoWebCreditkessaiyounoOutputBean);

                logger.debug("WsHbSeihoWebCreditkessaiyounoOutputBean:"+ wsHbSeihoWebCreditkessaiyounoOutputBean.toString());


                wsBzWebserviceResParamBean.setGyoumuData(
                    FixedlengthConvertUtil.beanToStringForFixedlength(wsHbSeihoWebCreditkessaiyounoOutputBean));

                logger.debug("△ 生保Ｗｅｂクレジットカード決済用番号取得 終了");

                return wsBzWebserviceResParamBean;
            }

            SaibanCreditKessaiyouNo saibanCreditKessaiyouNo = SWAKInjector.getInstance(SaibanCreditKessaiyouNo.class);
            String creditkessaiyouno = "";
            try {

                creditkessaiyouno = saibanCreditKessaiyouNo.exec(C_CreditCardKeySyuruiKbn.MOSNO, wsHbSeihoWebCreditkessaiyounoInputBean.getIwsMosno());
            } catch(Exception e) {

                errHukaMsg = creatErrorMsg("クレジットカード決済用番号採番エラー" , wsBzWebserviceReqParamBean);

                throw e;
            }

            wsHbSeihoWebCreditkessaiyounoOutputBean.setIwsErrkbn(ERRORKBN_CREDITKESSAIYOUNO_OK);
            wsHbSeihoWebCreditkessaiyounoOutputBean.setIwsCreditkessaiyouno(creditkessaiyouno);

            paddingOutputBean(wsHbSeihoWebCreditkessaiyounoOutputBean);

            logger.debug("WsHbSeihoWebCreditkessaiyounoOutputBean:"+ wsHbSeihoWebCreditkessaiyounoOutputBean.toString());

            wsBzWebserviceResParamBean.setGyoumuData(
                FixedlengthConvertUtil.beanToStringForFixedlength(wsHbSeihoWebCreditkessaiyounoOutputBean));

            logger.debug("△ 生保Ｗｅｂクレジットカード決済用番号取得 終了");

            return wsBzWebserviceResParamBean;
        }
        catch (Exception e) {

            logger.error(errHukaMsg, e);

            WsBzWebserviceResParamBean wsBzWebserviceResParamBean = SWAKInjector.getInstance(WsBzWebserviceResParamBean.class);
            WsHbSeihoWebCreditkessaiyounoOutputBean wsHbSeihoWebCreditkessaiyounoOutputBean = initOutputBean();

            wsHbSeihoWebCreditkessaiyounoOutputBean.setIwsErrkbn(ERRORKBN_CREDITKESSAIYOUNO_NONE);

            paddingOutputBean(wsHbSeihoWebCreditkessaiyounoOutputBean);

            logger.debug("WsHbSeihoWebCreditkessaiyounoOutputBean:"+ wsHbSeihoWebCreditkessaiyounoOutputBean.toString());

            wsBzWebserviceResParamBean.setGyoumuData(
                FixedlengthConvertUtil.beanToStringForFixedlength(wsHbSeihoWebCreditkessaiyounoOutputBean));

            logger.debug("△ 生保Ｗｅｂクレジットカード決済用番号取得 終了");

            return wsBzWebserviceResParamBean;

        }
    }

    private WsHbSeihoWebCreditkessaiyounoOutputBean initOutputBean() {

        WsHbSeihoWebCreditkessaiyounoOutputBean wsHbSeihoWebCreditkessaiyounoOutputBean =
            SWAKInjector.getInstance(WsHbSeihoWebCreditkessaiyounoOutputBean.class);

        wsHbSeihoWebCreditkessaiyounoOutputBean.setIwsErrkbn(null);
        wsHbSeihoWebCreditkessaiyounoOutputBean.setIwsCreditkessaiyouno("");

        return wsHbSeihoWebCreditkessaiyounoOutputBean;
    }

    private void paddingOutputBean(WsHbSeihoWebCreditkessaiyounoOutputBean pWsHbSeihoWebCreditkessaiyounoOutputBean) {

        pWsHbSeihoWebCreditkessaiyounoOutputBean.setIwsCreditkessaiyouno(
            Strings.padEnd(pWsHbSeihoWebCreditkessaiyounoOutputBean.getIwsCreditkessaiyouno(), 26, '0'));

    }

    private String creatErrorMsg(
        String pSyoriNm,
        WsBzWebserviceReqParamBean pWsBzWebserviceReqParamBean) {

        String errUserMsg = pSyoriNm.concat(":【オペレータＩＤ ＝ ")
            .concat(pWsBzWebserviceReqParamBean.getOperatorId())
            .concat(", 事務単位コード ＝ ")
            .concat(pWsBzWebserviceReqParamBean.getOrgCode() + "】 ");

        return errUserMsg;
    }


}
