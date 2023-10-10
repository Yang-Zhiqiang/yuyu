package yuyu.app.bosyuu.hbsekmos.hbnyknkwsrate;

import javax.inject.Inject;
import javax.ws.rs.core.MultivaluedMap;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.CHolidayAdjustingMode;
import jp.co.slcs.swak.file.exception.CvtVdtException;
import jp.co.slcs.swak.file.util.FixedlengthConvertUtil;
import jp.co.slcs.swak.number.BizNumber;

import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.GetKawaseRate;
import yuyu.common.biz.bzcommon.RayConvertUtil;
import yuyu.common.biz.bzwebserviceaccesslogoutput.WebServiceAccesslogOutput;
import yuyu.def.biz.bean.param.WsBzWebserviceReqParamBean;
import yuyu.def.biz.bean.param.WsBzWebserviceResParamBean;
import yuyu.def.bosyuu.bean.webservice.WsHbNyknkwsrateInputBean;
import yuyu.def.bosyuu.bean.webservice.WsHbNyknkwsrateOutputBean;
import yuyu.def.classification.C_AccessLogSyubetuKbn;
import yuyu.def.classification.C_EigyoubiHoseiKbn;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_KawaserateSyuruiKbn;
import yuyu.def.classification.C_KawasetekiyoKbn;
import yuyu.def.classification.C_KawasetsryKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_YouhiKbn;

/**
 * 入金用為替レート照会サービスの実装クラスです。<br />
 */
public class HbNyknkwsrateImpl implements HbNyknkwsrate {

    private static final BizDate DATE_INIT = BizDate.valueOf("00000000");

    private static final BizNumber KWSRATE_INIT = BizNumber.valueOf(00000);

    private static final String ERRORKBN_KWSRATE_OK = "0";

    private static final String ERRORKBN_KWSRATE_ERR = "1";

    @Inject
    private static Logger logger;

    @Override
    public WsBzWebserviceResParamBean execPostForm(MultivaluedMap<String, String> pMap) throws Exception {

        String errHukaMsg = "";

        try{
            logger.debug("▽ 入金用為替レート照会 開始");

            WsBzWebserviceReqParamBean wsBzWebserviceReqParamBean = SWAKInjector.getInstance(WsBzWebserviceReqParamBean.class);

            BeanUtils.populate(wsBzWebserviceReqParamBean, pMap);

            String gyoumuData = wsBzWebserviceReqParamBean.getGyoumuData();

            WsHbNyknkwsrateOutputBean wsHbNyknkwsrateOutputBean = SWAKInjector.getInstance(WsHbNyknkwsrateOutputBean.class);
            WsBzWebserviceResParamBean wsBzWebserviceResParamBean = SWAKInjector.getInstance(WsBzWebserviceResParamBean.class);
            WsHbNyknkwsrateInputBean wsHbNyknkwsrateInputBean;

            initOutputBean(wsHbNyknkwsrateOutputBean);

            try {
                wsHbNyknkwsrateInputBean = FixedlengthConvertUtil.stringToBeanForFixedlength(gyoumuData, WsHbNyknkwsrateInputBean.class);

            } catch (RuntimeException e) {

                if (e.getCause() != null && e.getCause() instanceof CvtVdtException) {

                    wsHbNyknkwsrateOutputBean.setIwsErrkbn(ERRORKBN_KWSRATE_ERR);

                    wsBzWebserviceResParamBean.setGyoumuData(
                        FixedlengthConvertUtil.beanToStringForFixedlength(wsHbNyknkwsrateOutputBean));

                    logger.debug("△ 入金用為替レート照会 終了");

                    return wsBzWebserviceResParamBean;
                }

                errHukaMsg = creatErrorMsg("入力値エラー" , wsBzWebserviceReqParamBean);
                throw e;
            }


            WebServiceAccesslogOutput webServiceAccesslogOutput =
                SWAKInjector.getInstance(WebServiceAccesslogOutput.class);
            webServiceAccesslogOutput.exec(
                C_AccessLogSyubetuKbn.ACTION_BEGIN, wsBzWebserviceReqParamBean, wsHbNyknkwsrateInputBean);


            RayConvertUtil.toValidString(wsHbNyknkwsrateInputBean);

            GetKawaseRate getKawaseRate = null;
            C_ErrorKbn errorKbn = null;
            int kawaseRateTrueKensu = 0;
            int kawaseRateErrKensu = 0;
            BizDate kwsrateKijyunymd = wsHbNyknkwsrateInputBean.getIwsKijyunymd();
            BizNumber shiteibiKawaserate = KWSRATE_INIT;

            for( int i = 0; i < 5; i++ ){

                if( i  != 0 ){
                    kwsrateKijyunymd = kwsrateKijyunymd.getPreviousDay();
                }
                kwsrateKijyunymd = kwsrateKijyunymd.getBusinessDay(CHolidayAdjustingMode.PREVIOUS );

                getKawaseRate = SWAKInjector.getInstance(GetKawaseRate.class);
                errorKbn = null;

                errorKbn = getKawaseRate.exec(
                    kwsrateKijyunymd,
                    C_KawaserateSyuruiKbn.KOUJIKAWASERATE,
                    C_Tuukasyu.USD,
                    C_Tuukasyu.JPY,
                    C_KawasetekiyoKbn.TTM,
                    C_KawasetsryKbn.NYUKINRATE,
                    C_EigyoubiHoseiKbn.BLNK,
                    C_YouhiKbn.HUYOU);

                kawaseRateTrueKensu ++;

                if (C_ErrorKbn.OK.eq(errorKbn)) {

                    shiteibiKawaserate = getKawaseRate.getKawaserate().multiply(100);
                }
                else {

                    shiteibiKawaserate = KWSRATE_INIT;
                    kawaseRateErrKensu++;
                }


                if( i == 0 ){
                    wsHbNyknkwsrateOutputBean.setIwsKwsratetekiymdusdjpy1(kwsrateKijyunymd);
                    wsHbNyknkwsrateOutputBean.setIwsKwsrateusdjpy1(shiteibiKawaserate);
                }
                else if( i == 1 ){
                    wsHbNyknkwsrateOutputBean.setIwsKwsratetekiymdusdjpy2(kwsrateKijyunymd);
                    wsHbNyknkwsrateOutputBean.setIwsKwsrateusdjpy2(shiteibiKawaserate);
                }
                else if( i == 2 ){
                    wsHbNyknkwsrateOutputBean.setIwsKwsratetekiymdusdjpy3(kwsrateKijyunymd);
                    wsHbNyknkwsrateOutputBean.setIwsKwsrateusdjpy3(shiteibiKawaserate);
                }
                else if( i == 3 ){
                    wsHbNyknkwsrateOutputBean.setIwsKwsratetekiymdusdjpy4(kwsrateKijyunymd);
                    wsHbNyknkwsrateOutputBean.setIwsKwsrateusdjpy4(shiteibiKawaserate);
                }
                else if( i == 4 ){
                    wsHbNyknkwsrateOutputBean.setIwsKwsratetekiymdusdjpy5(kwsrateKijyunymd);
                    wsHbNyknkwsrateOutputBean.setIwsKwsrateusdjpy5(shiteibiKawaserate);
                }



                getKawaseRate = SWAKInjector.getInstance(GetKawaseRate.class);
                errorKbn = null;

                errorKbn = getKawaseRate.exec(
                    kwsrateKijyunymd,
                    C_KawaserateSyuruiKbn.KOUJIKAWASERATE,
                    C_Tuukasyu.AUD,
                    C_Tuukasyu.JPY,
                    C_KawasetekiyoKbn.TTM,
                    C_KawasetsryKbn.NYUKINRATE,
                    C_EigyoubiHoseiKbn.BLNK,
                    C_YouhiKbn.HUYOU);

                kawaseRateTrueKensu ++;

                if (C_ErrorKbn.OK.eq(errorKbn)) {

                    shiteibiKawaserate = getKawaseRate.getKawaserate().multiply(100);
                }
                else {

                    shiteibiKawaserate = KWSRATE_INIT;
                    kawaseRateErrKensu++;
                }

                if( i == 0 ){
                    wsHbNyknkwsrateOutputBean.setIwsKwsratetekiymdaudjpy1(kwsrateKijyunymd);
                    wsHbNyknkwsrateOutputBean.setIwsKwsrateaudjpy1(shiteibiKawaserate);
                }
                else if( i == 1 ){
                    wsHbNyknkwsrateOutputBean.setIwsKwsratetekiymdaudjpy2(kwsrateKijyunymd);
                    wsHbNyknkwsrateOutputBean.setIwsKwsrateaudjpy2(shiteibiKawaserate);
                }
                else if( i == 2 ){
                    wsHbNyknkwsrateOutputBean.setIwsKwsratetekiymdaudjpy3(kwsrateKijyunymd);
                    wsHbNyknkwsrateOutputBean.setIwsKwsrateaudjpy3(shiteibiKawaserate);
                }
                else if( i == 3 ){
                    wsHbNyknkwsrateOutputBean.setIwsKwsratetekiymdaudjpy4(kwsrateKijyunymd);
                    wsHbNyknkwsrateOutputBean.setIwsKwsrateaudjpy4(shiteibiKawaserate);
                }
                else if( i == 4 ){
                    wsHbNyknkwsrateOutputBean.setIwsKwsratetekiymdaudjpy5(kwsrateKijyunymd);
                    wsHbNyknkwsrateOutputBean.setIwsKwsrateaudjpy5(shiteibiKawaserate);
                }

                getKawaseRate = SWAKInjector.getInstance(GetKawaseRate.class);
                errorKbn = null;

                errorKbn = getKawaseRate.exec(
                    kwsrateKijyunymd,
                    C_KawaserateSyuruiKbn.KOUJIKAWASERATE,
                    C_Tuukasyu.AUD,
                    C_Tuukasyu.USD,
                    C_KawasetekiyoKbn.TTM,
                    C_KawasetsryKbn.NYUKINRATE,
                    C_EigyoubiHoseiKbn.BLNK,
                    C_YouhiKbn.HUYOU);

                kawaseRateTrueKensu ++;

                if (C_ErrorKbn.OK.eq(errorKbn)) {

                    shiteibiKawaserate = getKawaseRate.getKawaserate().multiply(10000);
                }
                else {

                    shiteibiKawaserate = KWSRATE_INIT;
                    kawaseRateErrKensu++;
                }

                if( i == 0 ){
                    wsHbNyknkwsrateOutputBean.setIwsKwsratetekiymdaudusd1(kwsrateKijyunymd);
                    wsHbNyknkwsrateOutputBean.setIwsKwsrateaudusd1(shiteibiKawaserate);
                }
                else if( i == 1 ){
                    wsHbNyknkwsrateOutputBean.setIwsKwsratetekiymdaudusd2(kwsrateKijyunymd);
                    wsHbNyknkwsrateOutputBean.setIwsKwsrateaudusd2(shiteibiKawaserate);
                }
                else if( i == 2 ){
                    wsHbNyknkwsrateOutputBean.setIwsKwsratetekiymdaudusd3(kwsrateKijyunymd);
                    wsHbNyknkwsrateOutputBean.setIwsKwsrateaudusd3(shiteibiKawaserate);
                }
                else if( i == 3 ){
                    wsHbNyknkwsrateOutputBean.setIwsKwsratetekiymdaudusd4(kwsrateKijyunymd);
                    wsHbNyknkwsrateOutputBean.setIwsKwsrateaudusd4(shiteibiKawaserate);
                }
                else if( i == 4 ){
                    wsHbNyknkwsrateOutputBean.setIwsKwsratetekiymdaudusd5(kwsrateKijyunymd);
                    wsHbNyknkwsrateOutputBean.setIwsKwsrateaudusd5(shiteibiKawaserate);
                }

                getKawaseRate = SWAKInjector.getInstance(GetKawaseRate.class);
                errorKbn = null;

                errorKbn = getKawaseRate.exec(
                    kwsrateKijyunymd,
                    C_KawaserateSyuruiKbn.KOUJIKAWASERATE,
                    C_Tuukasyu.USD,
                    C_Tuukasyu.AUD,
                    C_KawasetekiyoKbn.TTM,
                    C_KawasetsryKbn.NYUKINRATE,
                    C_EigyoubiHoseiKbn.BLNK,
                    C_YouhiKbn.HUYOU);

                kawaseRateTrueKensu ++;

                if (C_ErrorKbn.OK.eq(errorKbn)) {

                    shiteibiKawaserate = getKawaseRate.getKawaserate().multiply(10000);
                }
                else {

                    shiteibiKawaserate = KWSRATE_INIT;
                    kawaseRateErrKensu++;
                }

                if( i == 0 ){
                    wsHbNyknkwsrateOutputBean.setIwsKwsratetekiymdusdaud1(kwsrateKijyunymd);
                    wsHbNyknkwsrateOutputBean.setIwsKwsrateusdaud1(shiteibiKawaserate);
                }
                else if( i == 1 ){
                    wsHbNyknkwsrateOutputBean.setIwsKwsratetekiymdusdaud2(kwsrateKijyunymd);
                    wsHbNyknkwsrateOutputBean.setIwsKwsrateusdaud2(shiteibiKawaserate);
                }
                else if( i == 2 ){
                    wsHbNyknkwsrateOutputBean.setIwsKwsratetekiymdusdaud3(kwsrateKijyunymd);
                    wsHbNyknkwsrateOutputBean.setIwsKwsrateusdaud3(shiteibiKawaserate);
                }
                else if( i == 3 ){
                    wsHbNyknkwsrateOutputBean.setIwsKwsratetekiymdusdaud4(kwsrateKijyunymd);
                    wsHbNyknkwsrateOutputBean.setIwsKwsrateusdaud4(shiteibiKawaserate);
                }
                else if( i == 4 ){
                    wsHbNyknkwsrateOutputBean.setIwsKwsratetekiymdusdaud5(kwsrateKijyunymd);
                    wsHbNyknkwsrateOutputBean.setIwsKwsrateusdaud5(shiteibiKawaserate);
                }

            }

            if(kawaseRateTrueKensu == kawaseRateErrKensu){
                wsHbNyknkwsrateOutputBean.setIwsErrkbn(ERRORKBN_KWSRATE_ERR);
                logger.error(creatErrorMsg("為替レートが取得できませんでした" , wsBzWebserviceReqParamBean));
            }

            logger.debug("WsHbNyknkwsrateOutputBean：" + wsHbNyknkwsrateOutputBean.toString());

            try {
                wsBzWebserviceResParamBean.setGyoumuData(
                    FixedlengthConvertUtil.beanToStringForFixedlength(wsHbNyknkwsrateOutputBean));
            } catch(Exception e) {

                errHukaMsg = creatErrorMsg("出力データエラー" , wsBzWebserviceReqParamBean);

                throw e;
            }

            logger.debug("△ 入金用為替レート照会 終了");

            return wsBzWebserviceResParamBean;
        }
        catch (Exception e) {

            logger.error(errHukaMsg, e);

            WsBzWebserviceResParamBean wsBzWebserviceResParamBean =
                SWAKInjector.getInstance(WsBzWebserviceResParamBean.class);
            WsHbNyknkwsrateOutputBean wsHbNyknkwsrateOutputBean =
                SWAKInjector.getInstance(WsHbNyknkwsrateOutputBean.class);

            initOutputBean(wsHbNyknkwsrateOutputBean);

            wsHbNyknkwsrateOutputBean.setIwsErrkbn(ERRORKBN_KWSRATE_ERR);

            wsBzWebserviceResParamBean.setGyoumuData(
                FixedlengthConvertUtil.beanToStringForFixedlength(wsHbNyknkwsrateOutputBean));

            return wsBzWebserviceResParamBean;
        }
    }

    private void initOutputBean(WsHbNyknkwsrateOutputBean wsHbNyknkwsrateOutputBean) {

        wsHbNyknkwsrateOutputBean.setIwsKwsratetekiymdusdjpy1(DATE_INIT);
        wsHbNyknkwsrateOutputBean.setIwsKwsratetekiymdusdjpy2(DATE_INIT);
        wsHbNyknkwsrateOutputBean.setIwsKwsratetekiymdusdjpy3(DATE_INIT);
        wsHbNyknkwsrateOutputBean.setIwsKwsratetekiymdusdjpy4(DATE_INIT);
        wsHbNyknkwsrateOutputBean.setIwsKwsratetekiymdusdjpy5(DATE_INIT);
        wsHbNyknkwsrateOutputBean.setIwsKwsrateusdjpy1(KWSRATE_INIT);
        wsHbNyknkwsrateOutputBean.setIwsKwsrateusdjpy2(KWSRATE_INIT);
        wsHbNyknkwsrateOutputBean.setIwsKwsrateusdjpy3(KWSRATE_INIT);
        wsHbNyknkwsrateOutputBean.setIwsKwsrateusdjpy4(KWSRATE_INIT);
        wsHbNyknkwsrateOutputBean.setIwsKwsrateusdjpy5(KWSRATE_INIT);
        wsHbNyknkwsrateOutputBean.setIwsKwsratetekiymdeurjpy1(DATE_INIT);
        wsHbNyknkwsrateOutputBean.setIwsKwsratetekiymdeurjpy2(DATE_INIT);
        wsHbNyknkwsrateOutputBean.setIwsKwsratetekiymdeurjpy3(DATE_INIT);
        wsHbNyknkwsrateOutputBean.setIwsKwsratetekiymdeurjpy4(DATE_INIT);
        wsHbNyknkwsrateOutputBean.setIwsKwsratetekiymdeurjpy5(DATE_INIT);
        wsHbNyknkwsrateOutputBean.setIwsKwsrateeurjpy1(KWSRATE_INIT);
        wsHbNyknkwsrateOutputBean.setIwsKwsrateeurjpy2(KWSRATE_INIT);
        wsHbNyknkwsrateOutputBean.setIwsKwsrateeurjpy3(KWSRATE_INIT);
        wsHbNyknkwsrateOutputBean.setIwsKwsrateeurjpy4(KWSRATE_INIT);
        wsHbNyknkwsrateOutputBean.setIwsKwsrateeurjpy5(KWSRATE_INIT);
        wsHbNyknkwsrateOutputBean.setIwsKwsratetekiymdaudjpy1(DATE_INIT);
        wsHbNyknkwsrateOutputBean.setIwsKwsratetekiymdaudjpy2(DATE_INIT);
        wsHbNyknkwsrateOutputBean.setIwsKwsratetekiymdaudjpy3(DATE_INIT);
        wsHbNyknkwsrateOutputBean.setIwsKwsratetekiymdaudjpy4(DATE_INIT);
        wsHbNyknkwsrateOutputBean.setIwsKwsratetekiymdaudjpy5(DATE_INIT);
        wsHbNyknkwsrateOutputBean.setIwsKwsrateaudjpy1(KWSRATE_INIT);
        wsHbNyknkwsrateOutputBean.setIwsKwsrateaudjpy2(KWSRATE_INIT);
        wsHbNyknkwsrateOutputBean.setIwsKwsrateaudjpy3(KWSRATE_INIT);
        wsHbNyknkwsrateOutputBean.setIwsKwsrateaudjpy4(KWSRATE_INIT);
        wsHbNyknkwsrateOutputBean.setIwsKwsrateaudjpy5(KWSRATE_INIT);
        wsHbNyknkwsrateOutputBean.setIwsKwsratetekiymdeurusd1(DATE_INIT);
        wsHbNyknkwsrateOutputBean.setIwsKwsratetekiymdeurusd2(DATE_INIT);
        wsHbNyknkwsrateOutputBean.setIwsKwsratetekiymdeurusd3(DATE_INIT);
        wsHbNyknkwsrateOutputBean.setIwsKwsratetekiymdeurusd4(DATE_INIT);
        wsHbNyknkwsrateOutputBean.setIwsKwsratetekiymdeurusd5(DATE_INIT);
        wsHbNyknkwsrateOutputBean.setIwsKwsrateeurusd1(KWSRATE_INIT);
        wsHbNyknkwsrateOutputBean.setIwsKwsrateeurusd2(KWSRATE_INIT);
        wsHbNyknkwsrateOutputBean.setIwsKwsrateeurusd3(KWSRATE_INIT);
        wsHbNyknkwsrateOutputBean.setIwsKwsrateeurusd4(KWSRATE_INIT);
        wsHbNyknkwsrateOutputBean.setIwsKwsrateeurusd5(KWSRATE_INIT);
        wsHbNyknkwsrateOutputBean.setIwsKwsratetekiymdeuraud1(DATE_INIT);
        wsHbNyknkwsrateOutputBean.setIwsKwsratetekiymdeuraud2(DATE_INIT);
        wsHbNyknkwsrateOutputBean.setIwsKwsratetekiymdeuraud3(DATE_INIT);
        wsHbNyknkwsrateOutputBean.setIwsKwsratetekiymdeuraud4(DATE_INIT);
        wsHbNyknkwsrateOutputBean.setIwsKwsratetekiymdeuraud5(DATE_INIT);
        wsHbNyknkwsrateOutputBean.setIwsKwsrateeuraud1(KWSRATE_INIT);
        wsHbNyknkwsrateOutputBean.setIwsKwsrateeuraud2(KWSRATE_INIT);
        wsHbNyknkwsrateOutputBean.setIwsKwsrateeuraud3(KWSRATE_INIT);
        wsHbNyknkwsrateOutputBean.setIwsKwsrateeuraud4(KWSRATE_INIT);
        wsHbNyknkwsrateOutputBean.setIwsKwsrateeuraud5(KWSRATE_INIT);
        wsHbNyknkwsrateOutputBean.setIwsKwsratetekiymdaudusd1(DATE_INIT);
        wsHbNyknkwsrateOutputBean.setIwsKwsratetekiymdaudusd2(DATE_INIT);
        wsHbNyknkwsrateOutputBean.setIwsKwsratetekiymdaudusd3(DATE_INIT);
        wsHbNyknkwsrateOutputBean.setIwsKwsratetekiymdaudusd4(DATE_INIT);
        wsHbNyknkwsrateOutputBean.setIwsKwsratetekiymdaudusd5(DATE_INIT);
        wsHbNyknkwsrateOutputBean.setIwsKwsrateaudusd1(KWSRATE_INIT);
        wsHbNyknkwsrateOutputBean.setIwsKwsrateaudusd2(KWSRATE_INIT);
        wsHbNyknkwsrateOutputBean.setIwsKwsrateaudusd3(KWSRATE_INIT);
        wsHbNyknkwsrateOutputBean.setIwsKwsrateaudusd4(KWSRATE_INIT);
        wsHbNyknkwsrateOutputBean.setIwsKwsrateaudusd5(KWSRATE_INIT);
        wsHbNyknkwsrateOutputBean.setIwsKwsratetekiymdusdaud1(DATE_INIT);
        wsHbNyknkwsrateOutputBean.setIwsKwsratetekiymdusdaud2(DATE_INIT);
        wsHbNyknkwsrateOutputBean.setIwsKwsratetekiymdusdaud3(DATE_INIT);
        wsHbNyknkwsrateOutputBean.setIwsKwsratetekiymdusdaud4(DATE_INIT);
        wsHbNyknkwsrateOutputBean.setIwsKwsratetekiymdusdaud5(DATE_INIT);
        wsHbNyknkwsrateOutputBean.setIwsKwsrateusdaud1(KWSRATE_INIT);
        wsHbNyknkwsrateOutputBean.setIwsKwsrateusdaud2(KWSRATE_INIT);
        wsHbNyknkwsrateOutputBean.setIwsKwsrateusdaud3(KWSRATE_INIT);
        wsHbNyknkwsrateOutputBean.setIwsKwsrateusdaud4(KWSRATE_INIT);
        wsHbNyknkwsrateOutputBean.setIwsKwsrateusdaud5(KWSRATE_INIT);
        wsHbNyknkwsrateOutputBean.setIwsErrkbn(ERRORKBN_KWSRATE_OK);

    }

    private String creatErrorMsg(
        String syoriNm,
        WsBzWebserviceReqParamBean wsBzWebserviceReqParamBean) {

        String errUserMsg = syoriNm.concat(":【オペレータＩＤ ＝ ")
            .concat(wsBzWebserviceReqParamBean.getOperatorId())
            .concat(", 事務単位コード ＝ ")
            .concat(wsBzWebserviceReqParamBean.getOrgCode() + "】 ");

        return errUserMsg;
    }

}
