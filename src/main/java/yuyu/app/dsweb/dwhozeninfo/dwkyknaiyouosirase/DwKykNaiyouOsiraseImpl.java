package yuyu.app.dsweb.dwhozeninfo.dwkyknaiyouosirase;

import javax.inject.Inject;
import javax.ws.rs.core.MultivaluedMap;

import jp.co.slcs.swak.core.inject.SWAKInjector;
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
import yuyu.def.classification.C_AccessLogSyubetuKbn;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.dsweb.bean.webservice.WsDwKykNaiyouOsiraseOutInputBean;
import yuyu.def.dsweb.bean.webservice.WsDwKykNaiyouOsiraseOutOutputBean;
import yuyu.infr.report.DBAOutputReport;

/**
 * ＤＳご契約内容のお知らせサービスの実装クラスです。<br />
 */
public class DwKykNaiyouOsiraseImpl implements DwKykNaiyouOsirase {

    @Inject
    private static Logger logger;

    private static final int YOBIDASIMOTOKBN_SEIHOWEB = 2;

    @Override
    public WsBzWebserviceResParamBean execPostForm(MultivaluedMap<String, String> pMap) throws Exception {

        try {

            logger.debug("▽ ＤＳご契約内容のお知らせ　開始");

            WsBzWebserviceResParamBean wsBzWebserviceResParamBean =
                SWAKInjector.getInstance(WsBzWebserviceResParamBean.class);
            WsDwKykNaiyouOsiraseOutOutputBean kykNaiyouOsiraseOutOutputBean =
                SWAKInjector.getInstance(WsDwKykNaiyouOsiraseOutOutputBean.class);

            WsBzWebserviceReqParamBean wsBzWebserviceReqParamBean =
                SWAKInjector.getInstance(WsBzWebserviceReqParamBean.class);

            BeanUtils.populate(wsBzWebserviceReqParamBean, pMap);

            String gyoumuData = wsBzWebserviceReqParamBean.getGyoumuData();

            WsDwKykNaiyouOsiraseOutInputBean kykNaiyouOsiraseOutInputBean;

            kykNaiyouOsiraseOutInputBean =
                FixedlengthConvertUtil.stringToBeanForFixedlength(gyoumuData, WsDwKykNaiyouOsiraseOutInputBean.class);

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

                logger.debug("△ ＤＳご契約内容のお知らせ　終了");

                return wsBzWebserviceResParamBean;
            }

            DBAOutputReport dBAOutputReport = SWAKInjector.getInstance(DBAOutputReport.class);

            String[] tyouhyouKeys = new String[] {kykNaiyouOsiraseiSks.getTyouhyouKey()};

            byte[] pdfBytes = dBAOutputReport.getPdfImages(tyouhyouKeys);

            String pdfData = Base64.encodeBase64String(pdfBytes);

            kykNaiyouOsiraseOutOutputBean.setIwsErrkbn("0");
            kykNaiyouOsiraseOutOutputBean.setIwsErrormsgv60("");
            kykNaiyouOsiraseOutOutputBean.setIwsTanmatutyouhyoucd("");
            kykNaiyouOsiraseOutOutputBean.setIwsPdfdata(pdfData);

            wsBzWebserviceResParamBean.setGyoumuData(
                FixedlengthConvertUtil.beanToStringForFixedlength(kykNaiyouOsiraseOutOutputBean));

            logger.debug("△ ＤＳご契約内容のお知らせ　終了");

            return wsBzWebserviceResParamBean;

        }
        catch (Exception e) {

            logger.debug("△ ＤＳご契約内容のお知らせ　終了");

            WsBzWebserviceResParamBean wsBzWebserviceResParamBean =
                SWAKInjector.getInstance(WsBzWebserviceResParamBean.class);
            WsDwKykNaiyouOsiraseOutOutputBean kykNaiyouOsiraseOutOutputBean =
                SWAKInjector.getInstance(WsDwKykNaiyouOsiraseOutOutputBean.class);

            kykNaiyouOsiraseOutOutputBean.setIwsErrkbn("1");
            kykNaiyouOsiraseOutOutputBean.setIwsErrormsgv60(MessageUtil.getMessage(MessageId.EGC1002));

            wsBzWebserviceResParamBean.setGyoumuData(
                FixedlengthConvertUtil.beanToStringForFixedlength(kykNaiyouOsiraseOutOutputBean));

            return wsBzWebserviceResParamBean;
        }
    }
}
