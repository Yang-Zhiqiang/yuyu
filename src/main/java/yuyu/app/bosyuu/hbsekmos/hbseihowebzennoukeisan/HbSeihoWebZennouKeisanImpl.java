package yuyu.app.bosyuu.hbsekmos.hbseihowebzennoukeisan;

import java.math.BigDecimal;

import javax.inject.Inject;
import javax.ws.rs.core.MultivaluedMap;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.file.exception.CvtVdtException;
import jp.co.slcs.swak.file.util.FixedlengthConvertUtil;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.number.currencytype.CurrencyType;

import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.HenkanTuuka;
import yuyu.common.biz.bzcommon.RayConvertUtil;
import yuyu.common.biz.bzwebserviceaccesslogoutput.WebServiceAccesslogOutput;
import yuyu.common.hozen.ascommon.KeisanZennouNyuukinGk2;
import yuyu.common.sinkeiyaku.skcommon.EditSeihoWebRenkeiKoumoku;
import yuyu.def.biz.bean.param.WsBzWebserviceReqParamBean;
import yuyu.def.biz.bean.param.WsBzWebserviceResParamBean;
import yuyu.def.bosyuu.bean.webservice.WsHbSeihoWebZennouKeisanInputBean;
import yuyu.def.bosyuu.bean.webservice.WsHbSeihoWebZennouKeisanOutputBean;
import yuyu.def.classification.C_AccessLogSyubetuKbn;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_Tuukasyu;

/**
 * 生保Ｗｅｂ前納保険料計算サービスの実装クラスです。<br />
 */
public class HbSeihoWebZennouKeisanImpl implements HbSeihoWebZennouKeisan {

    private static final String SEIJOU = "0";

    private static final String ZENNOUKEISANERROR = "1";

    @Inject
    private static Logger logger;

    @Override
    public WsBzWebserviceResParamBean execPostForm(MultivaluedMap<String, String> pMap) throws Exception {

        String errHukaMsg = "";

        try {

            logger.debug("▽ 生保Ｗｅｂ前納保険料計算 開始");

            WsBzWebserviceReqParamBean wsBzWebserviceReqParamBean = SWAKInjector.getInstance(WsBzWebserviceReqParamBean.class);
            WsHbSeihoWebZennouKeisanOutputBean wsHbSeihoWebZennouKeisanOutputBean = SWAKInjector.getInstance(WsHbSeihoWebZennouKeisanOutputBean.class);
            WsBzWebserviceResParamBean wsBzWebserviceResParamBean = SWAKInjector.getInstance(WsBzWebserviceResParamBean.class);

            BeanUtils.populate(wsBzWebserviceReqParamBean, pMap);

            String gyoumuData = wsBzWebserviceReqParamBean.getGyoumuData();

            initOutputBean(wsHbSeihoWebZennouKeisanOutputBean);

            WsHbSeihoWebZennouKeisanInputBean wsHbSeihoWebZennouKeisanInputBean;

            try {

                wsHbSeihoWebZennouKeisanInputBean = FixedlengthConvertUtil.stringToBeanForFixedlength(
                    gyoumuData, WsHbSeihoWebZennouKeisanInputBean.class);

            } catch (RuntimeException e) {

                if (e.getCause() != null && e.getCause() instanceof CvtVdtException) {

                    wsHbSeihoWebZennouKeisanOutputBean.setIwsErrkbn(ZENNOUKEISANERROR);

                    wsBzWebserviceResParamBean.setGyoumuData(
                        FixedlengthConvertUtil.beanToStringForFixedlength(wsHbSeihoWebZennouKeisanOutputBean));

                    logger.debug("△ 生保Ｗｅｂ前納保険料計算 終了");

                    return wsBzWebserviceResParamBean;
                }

                errHukaMsg = creatErrorMsg("入力値エラー" , wsBzWebserviceReqParamBean);
                throw e;
            }

            WebServiceAccesslogOutput webServiceAccesslogOutput =
                SWAKInjector.getInstance(WebServiceAccesslogOutput.class);
            webServiceAccesslogOutput.exec(
                C_AccessLogSyubetuKbn.ACTION_BEGIN, wsBzWebserviceReqParamBean, wsHbSeihoWebZennouKeisanInputBean);

            RayConvertUtil.toValidString(wsHbSeihoWebZennouKeisanInputBean);

            EditSeihoWebRenkeiKoumoku editSeihoWebRenkeiKoumoku = SWAKInjector.getInstance(EditSeihoWebRenkeiKoumoku.class);
            HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);

            C_Tuukasyu kykTuukasyu = editSeihoWebRenkeiKoumoku.tuukasyuHenkan(
                wsHbSeihoWebZennouKeisanInputBean.getIwsKyktuukakbn());

            CurrencyType kyktuukaType = henkanTuuka.henkanTuukaKbnToType(kykTuukasyu);

            BizCurrency zennoujihrkp;

            if (C_Tuukasyu.JPY.eq(kykTuukasyu)) {

                zennoujihrkp = BizCurrency.valueOf(new BigDecimal(wsHbSeihoWebZennouKeisanInputBean.getIwsYenfstp()
                    .toString()), kyktuukaType);
            }
            else {

                zennoujihrkp = BizCurrency.valueOf(new BigDecimal(wsHbSeihoWebZennouKeisanInputBean.getIwsGaikafstp()
                    .divide(100).toString()), kyktuukaType);
            }

            KeisanZennouNyuukinGk2 keisanZennouNyuukinGk2 = SWAKInjector.getInstance(KeisanZennouNyuukinGk2.class);

            C_ErrorKbn result = keisanZennouNyuukinGk2.execKeisanSinkeiyakuDoujiZennouNyuukinGk(
                wsHbSeihoWebZennouKeisanInputBean.getIwsKijyunymd(),
                zennoujihrkp,
                Integer.valueOf(wsHbSeihoWebZennouKeisanInputBean.getIwsZennoukkn()) - 1,
                null,
                null,
                null);

            BizCurrency yenznnpnotinc = BizCurrency.valueOf(0);
            BizCurrency yenznnpinclude = BizCurrency.valueOf(0);
            BizCurrency gaikaznnpnotinc = BizCurrency.valueOf(0);
            BizCurrency gaikaznnpinclude = BizCurrency.valueOf(0);

            String errorKbn;

            if (C_ErrorKbn.OK.eq(result)) {
                if (C_Tuukasyu.JPY.eq(kykTuukasyu)) {

                    yenznnpnotinc = keisanZennouNyuukinGk2.getZennouGenka();
                    yenznnpinclude = keisanZennouNyuukinGk2.getZennouNyuukinGk();
                }
                else {

                    gaikaznnpnotinc = keisanZennouNyuukinGk2.getZennouGenka().multiply(100);
                    gaikaznnpinclude = keisanZennouNyuukinGk2.getZennouNyuukinGk().multiply(100);
                }

                errorKbn = SEIJOU;
            }
            else {

                errorKbn = ZENNOUKEISANERROR;
            }

            wsHbSeihoWebZennouKeisanOutputBean.setIwsErrkbn(errorKbn);
            wsHbSeihoWebZennouKeisanOutputBean.setIwsYenznnpnotinc(BizNumber.valueOf(yenznnpnotinc));
            wsHbSeihoWebZennouKeisanOutputBean.setIwsYenznnpinclude(BizNumber.valueOf(yenznnpinclude));
            wsHbSeihoWebZennouKeisanOutputBean.setIwsGaikaznnpnotinc(BizNumber.valueOf(gaikaznnpnotinc));
            wsHbSeihoWebZennouKeisanOutputBean.setIwsGaikaznnpinclude(BizNumber.valueOf(gaikaznnpinclude));

            logger.debug("WsHbSeihoWebZennouKeisanOutputBean：" + wsHbSeihoWebZennouKeisanOutputBean.toString());

            try {

                wsBzWebserviceResParamBean.setGyoumuData(
                    FixedlengthConvertUtil.beanToStringForFixedlength(wsHbSeihoWebZennouKeisanOutputBean));
            } catch(Exception e) {

                errHukaMsg = creatErrorMsg("出力データエラー" , wsBzWebserviceReqParamBean);

                throw e;
            }

            logger.debug("△ 生保Ｗｅｂ前納保険料計算 終了");

            return wsBzWebserviceResParamBean;
        }
        catch (Exception e) {

            logger.error(errHukaMsg, e);

            WsBzWebserviceResParamBean wsBzWebserviceResParamBean = SWAKInjector.getInstance(WsBzWebserviceResParamBean.class);
            WsHbSeihoWebZennouKeisanOutputBean wsHbSeihoWebZennouKeisanOutputBean =
                SWAKInjector.getInstance(WsHbSeihoWebZennouKeisanOutputBean.class);

            initOutputBean(wsHbSeihoWebZennouKeisanOutputBean);

            wsHbSeihoWebZennouKeisanOutputBean.setIwsErrkbn(ZENNOUKEISANERROR);

            wsBzWebserviceResParamBean.setGyoumuData(
                FixedlengthConvertUtil.beanToStringForFixedlength(wsHbSeihoWebZennouKeisanOutputBean));

            return wsBzWebserviceResParamBean;
        }
    }

    private void initOutputBean(WsHbSeihoWebZennouKeisanOutputBean pWsHbSeihoWebZennouKeisanOutputBean) {

        pWsHbSeihoWebZennouKeisanOutputBean.setIwsErrkbn(SEIJOU);
        pWsHbSeihoWebZennouKeisanOutputBean.setIwsYenznnpnotinc(BizNumber.valueOf(0));
        pWsHbSeihoWebZennouKeisanOutputBean.setIwsYenznnpinclude(BizNumber.valueOf(0));
        pWsHbSeihoWebZennouKeisanOutputBean.setIwsGaikaznnpnotinc(BizNumber.valueOf(0));
        pWsHbSeihoWebZennouKeisanOutputBean.setIwsGaikaznnpinclude(BizNumber.valueOf(0));

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
