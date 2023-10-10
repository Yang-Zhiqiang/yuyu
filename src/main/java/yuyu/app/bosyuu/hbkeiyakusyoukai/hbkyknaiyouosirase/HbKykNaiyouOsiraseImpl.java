package yuyu.app.bosyuu.hbkeiyakusyoukai.hbkyknaiyouosirase;

import javax.inject.Inject;
import javax.ws.rs.core.MultivaluedMap;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.file.exception.CvtVdtException;
import jp.co.slcs.swak.file.util.FixedlengthConvertUtil;
import jp.co.slcs.swak.util.message.MessageUtil;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;

import yuyu.common.biz.bzwebserviceaccesslogoutput.WebServiceAccesslogOutput;
import yuyu.common.hozen.khcommon.KhAddKoumokuSetteiBean;
import yuyu.common.hozen.khcommon.KykNaiyouOsiraseiSks;
import yuyu.def.MessageId;
import yuyu.def.biz.bean.param.WsBzWebserviceReqParamBean;
import yuyu.def.biz.bean.param.WsBzWebserviceResParamBean;
import yuyu.def.bosyuu.bean.webservice.WsHbKykNaiyouOsiraseOutInputBean;
import yuyu.def.bosyuu.bean.webservice.WsHbKykNaiyouOsiraseOutOutputBean;
import yuyu.def.classification.C_AccessLogSyubetuKbn;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.infr.report.DBAOutputReport;

/**
 * 生保Ｗｅｂご契約内容のお知らせサービスの実装クラスです。<br />
 */
public class HbKykNaiyouOsiraseImpl implements HbKykNaiyouOsirase {

    @Inject
    private static Logger logger;

    private static final int YOBIDASIMOTOKBN_SEIHOWEB = 2;

    private static final String ERRORMESSAGE1 =
        "誤った証券番号が入力されています。正しい証券番号を確認のうえ、再度照会ください。";

    @Override
    public WsBzWebserviceResParamBean exec(MultivaluedMap<String, String> pMap) throws Exception {

        try {

            logger.debug("▽ 生保Ｗｅｂご契約内容のお知らせ　開始");

            WsHbKykNaiyouOsiraseOutOutputBean kykNaiyouOsiraseOutOutputBean =
                SWAKInjector.getInstance(WsHbKykNaiyouOsiraseOutOutputBean.class);
            WsBzWebserviceResParamBean wsBzWebserviceResParamBean =
                SWAKInjector.getInstance(WsBzWebserviceResParamBean.class);

            WsBzWebserviceReqParamBean wsBzWebserviceReqParamBean =
                SWAKInjector.getInstance(WsBzWebserviceReqParamBean.class);

            BeanUtils.populate(wsBzWebserviceReqParamBean, pMap);

            String gyoumuData = wsBzWebserviceReqParamBean.getGyoumuData();

            WsHbKykNaiyouOsiraseOutInputBean kykNaiyouOsiraseOutInputBean;
            try {

                kykNaiyouOsiraseOutInputBean =
                    FixedlengthConvertUtil.stringToBeanForFixedlength(gyoumuData, WsHbKykNaiyouOsiraseOutInputBean.class);

            }
            catch (RuntimeException e) {

                if (e.getCause() != null && e.getCause() instanceof CvtVdtException) {

                    logger.debug("△ 生保Ｗｅｂご契約内容のお知らせ　終了");

                    kykNaiyouOsiraseOutOutputBean.setIwsErrkbn("1");
                    kykNaiyouOsiraseOutOutputBean.setIwsErrormsgv60(ERRORMESSAGE1);

                    wsBzWebserviceResParamBean.setGyoumuData(
                        FixedlengthConvertUtil.beanToStringForFixedlength(kykNaiyouOsiraseOutOutputBean));

                    return wsBzWebserviceResParamBean;
                }

                throw e;
            }

            WebServiceAccesslogOutput webServiceAccesslogOutput =
                SWAKInjector.getInstance(WebServiceAccesslogOutput.class);

            webServiceAccesslogOutput.exec(C_AccessLogSyubetuKbn.ACTION_BEGIN, wsBzWebserviceReqParamBean, kykNaiyouOsiraseOutInputBean);

            KykNaiyouOsiraseiSks kykNaiyouOsiraseiSks = SWAKInjector.getInstance(KykNaiyouOsiraseiSks.class);

            KhAddKoumokuSetteiBean addKoumokuSetteiBean = SWAKInjector.getInstance(KhAddKoumokuSetteiBean.class);

            C_ErrorKbn errorKbn = kykNaiyouOsiraseiSks.exec(
                kykNaiyouOsiraseOutInputBean.getIwsSyono11keta(),
                YOBIDASIMOTOKBN_SEIHOWEB,
                addKoumokuSetteiBean);

            if (C_ErrorKbn.ERROR.eq(errorKbn)) {

                kykNaiyouOsiraseOutOutputBean.setIwsErrkbn("1");
                kykNaiyouOsiraseOutOutputBean.setIwsErrormsgv60(kykNaiyouOsiraseiSks.getErrorMsg());
                kykNaiyouOsiraseOutOutputBean.setIwsTanmatutyouhyoucd("");
                kykNaiyouOsiraseOutOutputBean.setIwsPdfdata("");

                wsBzWebserviceResParamBean.setGyoumuData(
                    FixedlengthConvertUtil.beanToStringForFixedlength(kykNaiyouOsiraseOutOutputBean));

                logger.debug("△ 生保Ｗｅｂご契約内容のお知らせ　終了");

                return wsBzWebserviceResParamBean;
            }

            DBAOutputReport dBAOutputReport = SWAKInjector.getInstance(DBAOutputReport.class);

            String[] tyouhyouKeys = new String[] {kykNaiyouOsiraseiSks.getTyouhyouKey() };

            byte[] pdfBytes = dBAOutputReport.getPdfImages(tyouhyouKeys);

            String pdfData = Base64.encodeBase64String(pdfBytes);

            kykNaiyouOsiraseOutOutputBean.setIwsErrkbn("0");
            kykNaiyouOsiraseOutOutputBean.setIwsErrormsgv60("");
            kykNaiyouOsiraseOutOutputBean.setIwsTanmatutyouhyoucd("");
            kykNaiyouOsiraseOutOutputBean.setIwsPdfdata(pdfData);
            wsBzWebserviceResParamBean.setGyoumuData(
                FixedlengthConvertUtil.beanToStringForFixedlength(kykNaiyouOsiraseOutOutputBean));

            logger.debug("△ 生保Ｗｅｂご契約内容のお知らせ　終了");

            return wsBzWebserviceResParamBean;

        }
        catch (Exception e) {

            logger.debug("△ 生保Ｗｅｂご契約内容のお知らせ　終了");

            WsHbKykNaiyouOsiraseOutOutputBean keiyakuSyoukaiWebServiceOutputBean =
                SWAKInjector.getInstance(WsHbKykNaiyouOsiraseOutOutputBean.class);
            WsBzWebserviceResParamBean wsBzWebserviceResParamBean =
                SWAKInjector.getInstance(WsBzWebserviceResParamBean.class);

            keiyakuSyoukaiWebServiceOutputBean.setIwsErrkbn("1");
            keiyakuSyoukaiWebServiceOutputBean.setIwsErrormsgv60(MessageUtil.getMessage(MessageId.EGC1002));

            wsBzWebserviceResParamBean.setGyoumuData(
                FixedlengthConvertUtil.beanToStringForFixedlength(keiyakuSyoukaiWebServiceOutputBean));

            return wsBzWebserviceResParamBean;
        }
    }
}
