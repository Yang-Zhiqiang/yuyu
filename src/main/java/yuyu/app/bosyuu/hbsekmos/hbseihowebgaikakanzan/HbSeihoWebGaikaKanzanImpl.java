package yuyu.app.bosyuu.hbsekmos.hbseihowebgaikakanzan;

import java.math.BigDecimal;

import javax.inject.Inject;
import javax.ws.rs.core.MultivaluedMap;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.file.exception.CvtVdtException;
import jp.co.slcs.swak.file.util.FixedlengthConvertUtil;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.number.currencytype.CurrencyType;

import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.GetKawaseRate;
import yuyu.common.biz.bzcommon.HenkanTuuka;
import yuyu.common.biz.bzcommon.KeisanGaikakanzan;
import yuyu.common.biz.bzcommon.RayConvertUtil;
import yuyu.common.biz.bzwebserviceaccesslogoutput.WebServiceAccesslogOutput;
import yuyu.common.sinkeiyaku.skcommon.EditSeihoWebRenkeiKoumoku;
import yuyu.def.biz.bean.param.WsBzWebserviceReqParamBean;
import yuyu.def.biz.bean.param.WsBzWebserviceResParamBean;
import yuyu.def.bosyuu.bean.webservice.WsHbSeihoWebGaikaKanzanInputBean;
import yuyu.def.bosyuu.bean.webservice.WsHbSeihoWebGaikaKanzanOutputBean;
import yuyu.def.classification.C_AccessLogSyubetuKbn;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_HasuusyoriKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_IkkatubaraiKbn;
import yuyu.def.classification.C_SysKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YouhiKbn;

/**
 * 生保Ｗｅｂ外貨換算サービスの実装クラスです。<br />
 */
public class HbSeihoWebGaikaKanzanImpl implements HbSeihoWebGaikaKanzan {

    private static final String ERRORKBN_SEIJOU= "0";

    private static final String ERRORKBN_ERROR = "1";

    @Inject
    private static Logger logger;

    @Override
    public WsBzWebserviceResParamBean execPostForm(MultivaluedMap<String, String> pMap) throws Exception {

        String errHukaMsg = "";

        try {
            logger.debug("▽ 生保Ｗｅｂ外貨換算 開始");

            WsBzWebserviceReqParamBean wsBzWebserviceReqParamBean = SWAKInjector.getInstance(WsBzWebserviceReqParamBean.class);

            BeanUtils.populate(wsBzWebserviceReqParamBean, pMap);

            String gyoumuData = wsBzWebserviceReqParamBean.getGyoumuData();

            WsHbSeihoWebGaikaKanzanOutputBean wsHbSeihoWebGaikaKanzanOutputBean = SWAKInjector.getInstance(WsHbSeihoWebGaikaKanzanOutputBean.class);
            WsBzWebserviceResParamBean wsBzWebserviceResParamBean = SWAKInjector.getInstance(WsBzWebserviceResParamBean.class);

            initOutputBean(wsHbSeihoWebGaikaKanzanOutputBean);

            WsHbSeihoWebGaikaKanzanInputBean wsHbSeihoWebGaikaKanzanInputBean;
            try {
                wsHbSeihoWebGaikaKanzanInputBean = FixedlengthConvertUtil.stringToBeanForFixedlength(gyoumuData, WsHbSeihoWebGaikaKanzanInputBean.class);

            } catch (RuntimeException e) {

                if (e.getCause() != null && e.getCause() instanceof CvtVdtException) {

                    wsHbSeihoWebGaikaKanzanOutputBean.setIwsErrkbn(ERRORKBN_ERROR);

                    wsBzWebserviceResParamBean.setGyoumuData(
                        FixedlengthConvertUtil.beanToStringForFixedlength(wsHbSeihoWebGaikaKanzanOutputBean));

                    logger.debug("△ 生保Ｗｅｂ外貨換算 終了");

                    return wsBzWebserviceResParamBean;
                }

                errHukaMsg = creatErrorMsg("入力値エラー" , wsBzWebserviceReqParamBean);
                throw e;
            }

            WebServiceAccesslogOutput webServiceAccesslogOutput =
                SWAKInjector.getInstance(WebServiceAccesslogOutput.class);
            webServiceAccesslogOutput.exec(
                C_AccessLogSyubetuKbn.ACTION_BEGIN, wsBzWebserviceReqParamBean, wsHbSeihoWebGaikaKanzanInputBean);

            EditSeihoWebRenkeiKoumoku editSeihoWebRenkeiKoumoku = SWAKInjector.getInstance(EditSeihoWebRenkeiKoumoku.class);
            HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);

            C_Tuukasyu kykTuukasyu = editSeihoWebRenkeiKoumoku.tuukasyuHenkan(
                wsHbSeihoWebGaikaKanzanInputBean.getIwsKyktuukakbn());

            CurrencyType kyktuukaType = henkanTuuka.henkanTuukaKbnToType(kykTuukasyu);

            C_Tuukasyu hrkTuukasyu = editSeihoWebRenkeiKoumoku.tuukasyuHenkan(
                wsHbSeihoWebGaikaKanzanInputBean.getIwsHrktuukakbn());

            CurrencyType hrktuukaType = henkanTuuka.henkanTuukaKbnToType(hrkTuukasyu);

            C_Hrkkaisuu hrkkaisuu = editSeihoWebRenkeiKoumoku.hrkkaisuuHenkan(
                wsHbSeihoWebGaikaKanzanInputBean.getIwsHaraikomikaisuukbn());

            BizCurrency knsnmaeP = null;

            BizCurrency knsnmaeZennouP = null;

            if ("1".equals(wsHbSeihoWebGaikaKanzanInputBean.getIwsKinoukbn())) {

                if (C_Tuukasyu.JPY.eq(hrkTuukasyu)) {

                    knsnmaeP = BizCurrency.valueOf(new BigDecimal(
                        wsHbSeihoWebGaikaKanzanInputBean.getIwsKnsnmaeyenp().toString()), hrktuukaType);

                    knsnmaeZennouP = BizCurrency.valueOf(BigDecimal.ZERO, hrktuukaType);
                }
                else {

                    knsnmaeP = BizCurrency.valueOf(new BigDecimal(
                        wsHbSeihoWebGaikaKanzanInputBean.getIwsKnsnmaegkp().divide(100).toString()), hrktuukaType);

                    knsnmaeZennouP = BizCurrency.valueOf(BigDecimal.ZERO, hrktuukaType);
                }
            }
            else {

                if (C_Tuukasyu.JPY.eq(kykTuukasyu)) {

                    knsnmaeP = BizCurrency.valueOf(new BigDecimal(
                        wsHbSeihoWebGaikaKanzanInputBean.getIwsKnsnmaeyenp().toString()), kyktuukaType);

                    knsnmaeZennouP = BizCurrency.valueOf(BigDecimal.ZERO, kyktuukaType);
                }
                else {

                    knsnmaeP = BizCurrency.valueOf(new BigDecimal(
                        wsHbSeihoWebGaikaKanzanInputBean.getIwsKnsnmaegkp().divide(100).toString()), kyktuukaType);

                    knsnmaeZennouP = BizCurrency.valueOf(new BigDecimal(
                        wsHbSeihoWebGaikaKanzanInputBean.getIwsKnsnmaegkzennoup().divide(100).toString()), kyktuukaType);
                }
            }
            BizDate kijyunYmd = wsHbSeihoWebGaikaKanzanInputBean.getIwsKijyunymd();

            C_UmuKbn zennouMousideUmu = C_UmuKbn.NONE;

            if ("1".equals(wsHbSeihoWebGaikaKanzanInputBean.getIwsZennouhyouji())) {

                zennouMousideUmu = C_UmuKbn.ARI;
            }

            RayConvertUtil.toValidString(wsHbSeihoWebGaikaKanzanInputBean);

            GetKawaseRate getKawaseRate = SWAKInjector.getInstance(GetKawaseRate.class);
            C_ErrorKbn errorKbn = getKawaseRate.execFstPNyuukin(kijyunYmd, kykTuukasyu, hrkTuukasyu,
                C_YouhiKbn.HUYOU, hrkkaisuu, C_SysKbn.SKEI, zennouMousideUmu, C_IkkatubaraiKbn.BLNK );

            if (C_ErrorKbn.OK.eq(errorKbn)) {

                wsHbSeihoWebGaikaKanzanOutputBean.setIwsKnsnkwsratetekiymd(getKawaseRate.getKwsrateKjYmd());

                if (C_Tuukasyu.JPY.eq(hrkTuukasyu)) {

                    wsHbSeihoWebGaikaKanzanOutputBean.setIwsKnsnkawaserate(getKawaseRate.getKawaserate().multiply(100));
                }
                else {

                    wsHbSeihoWebGaikaKanzanOutputBean.setIwsKnsnkawaserate(getKawaseRate.getKawaserate().multiply(10000));
                }
                KeisanGaikakanzan keisanGaikakanzan = SWAKInjector.getInstance(KeisanGaikakanzan.class);

                if ("1".equals(wsHbSeihoWebGaikaKanzanInputBean.getIwsKinoukbn())) {

                    BizCurrency kanzanGaku = keisanGaikakanzan.execDivide(kykTuukasyu, knsnmaeP,
                        getKawaseRate.getKawaserate(), C_HasuusyoriKbn.AGE);

                    if (C_Tuukasyu.JPY.eq(kykTuukasyu)) {

                        wsHbSeihoWebGaikaKanzanOutputBean.setIwsKnsngoyenp(BizNumber.valueOf(kanzanGaku));
                    }
                    else {

                        wsHbSeihoWebGaikaKanzanOutputBean.setIwsKnsngogkp(BizNumber.valueOf(kanzanGaku.multiply(100)));
                    }
                }
                else {

                    BizCurrency knsngoP = keisanGaikakanzan.exec(hrkTuukasyu, knsnmaeP, getKawaseRate.getKawaserate(),
                        C_HasuusyoriKbn.SUTE);

                    BizCurrency knsngoZennouP = BizCurrency.valueOf(BigDecimal.ZERO, hrktuukaType);

                    if (C_UmuKbn.ARI.eq(zennouMousideUmu)){

                        knsngoZennouP = keisanGaikakanzan.exec(hrkTuukasyu, (knsnmaeZennouP.subtract(knsnmaeP)),
                            getKawaseRate.getKawaserate(), C_HasuusyoriKbn.SUTE);
                    }

                    if (C_Tuukasyu.JPY.eq(hrkTuukasyu)) {

                        wsHbSeihoWebGaikaKanzanOutputBean.setIwsKnsngoyenp(BizNumber.valueOf(knsngoP.add(knsngoZennouP)));
                    }
                    else {

                        wsHbSeihoWebGaikaKanzanOutputBean.setIwsKnsngogkp(BizNumber.valueOf(knsngoP.add(knsngoZennouP)
                            .multiply(100)));
                    }
                }
            }
            else {

                wsHbSeihoWebGaikaKanzanOutputBean.setIwsErrkbn(ERRORKBN_ERROR);
            }

            logger.debug("WsHbSeihoWebGaikaKanzanOutputBean：" + wsHbSeihoWebGaikaKanzanOutputBean.toString());

            try {
                wsBzWebserviceResParamBean.setGyoumuData(
                    FixedlengthConvertUtil.beanToStringForFixedlength(wsHbSeihoWebGaikaKanzanOutputBean));
            } catch(Exception e) {

                errHukaMsg = creatErrorMsg("出力データエラー" , wsBzWebserviceReqParamBean);

                throw e;
            }

            logger.debug("△ 生保Ｗｅｂ外貨換算 終了");
            return wsBzWebserviceResParamBean;
        }
        catch (Exception e) {
            logger.error(errHukaMsg, e);

            WsBzWebserviceResParamBean wsBzWebserviceResParamBean = SWAKInjector.getInstance(WsBzWebserviceResParamBean.class);
            WsHbSeihoWebGaikaKanzanOutputBean wsHbSeihoWebGaikaKanzanOutputBean =
                SWAKInjector.getInstance(WsHbSeihoWebGaikaKanzanOutputBean.class);

            initOutputBean(wsHbSeihoWebGaikaKanzanOutputBean);

            wsHbSeihoWebGaikaKanzanOutputBean.setIwsErrkbn(ERRORKBN_ERROR);

            wsBzWebserviceResParamBean.setGyoumuData(
                FixedlengthConvertUtil.beanToStringForFixedlength(wsHbSeihoWebGaikaKanzanOutputBean));

            return wsBzWebserviceResParamBean;
        }
    }

    private void initOutputBean(WsHbSeihoWebGaikaKanzanOutputBean pWsHbSeihoWebGaikaKanzanOutputBean) {

        pWsHbSeihoWebGaikaKanzanOutputBean.setIwsErrkbn(ERRORKBN_SEIJOU);
        pWsHbSeihoWebGaikaKanzanOutputBean.setIwsKnsnkwsratetekiymd(BizDate.valueOf(00000000));
        pWsHbSeihoWebGaikaKanzanOutputBean.setIwsKnsnkawaserate(BizNumber.ZERO);
        pWsHbSeihoWebGaikaKanzanOutputBean.setIwsKnsngoyenp(BizNumber.ZERO);
        pWsHbSeihoWebGaikaKanzanOutputBean.setIwsKnsngogkp(BizNumber.ZERO);
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
