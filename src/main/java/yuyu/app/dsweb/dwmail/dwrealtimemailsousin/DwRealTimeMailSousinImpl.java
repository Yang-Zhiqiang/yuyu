package yuyu.app.dsweb.dwmail.dwrealtimemailsousin;

import java.lang.reflect.InvocationTargetException;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.core.MultivaluedMap;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateFormat;
import jp.co.slcs.swak.date.BizDateFormat.FillStyle;
import jp.co.slcs.swak.util.message.MessageUtil;
import net.arnx.jsonic.JSON;

import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;

import yuyu.app.dsweb.dwmail.dwrealtimemailsousin.dba.DwRealTimeMailSousinDao;
import yuyu.common.base.BaseUserInfo;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzwebserviceaccesslogoutput.WebServiceAccesslogOutput;
import yuyu.common.direct.dscommon.DsDB2Util;
import yuyu.common.direct.dscommon.DsSaibanSyori;
import yuyu.common.dsweb.dwcommon.DwMessageCodeConstants;
import yuyu.def.MessageId;
import yuyu.def.biz.bean.param.WsBzWebserviceReqParamBean;
import yuyu.def.biz.bean.param.WsBzWebserviceResParamBean;
import yuyu.def.classification.C_AccessLogSyubetuKbn;
import yuyu.def.classification.C_DsKinouidKbn;
import yuyu.def.classification.C_DsSousinMailSyubetuKbn;
import yuyu.def.db.entity.MT_DsKokyakuKanri;
import yuyu.def.db.entity.MT_DsMailHaisinRireki;
import yuyu.def.direct.manager.DirectDomManager;
import yuyu.def.dsweb.bean.webservice.WsDwRealTimeMailSousinInputBean;
import yuyu.def.dsweb.bean.webservice.WsDwRealTimeMailSousinOutputBean;

/**
 * ダイレクトサービス（Ｗｅｂ） メール ＤＳリアルタイムメール送信
 */
public class DwRealTimeMailSousinImpl implements DwRealTimeMailSousin{

    private static final int DS_MAIL_HAISIN_RENBAN_INIT = 1;

    @Inject
    private static Logger logger;

    @Inject
    private DirectDomManager directDomManager;

    @Inject
    private DwRealTimeMailSousinDao dwRealTimeMailSousinDao;

    @Inject
    private BaseUserInfo baseUserInfo;

    @Override
    public WsBzWebserviceResParamBean execPostFormPrepare(MultivaluedMap<String, String> pMap) {

        logger.info(MessageUtil.getMessage(MessageId.IBF0016, MessageUtil.getMessage(MessageId.INW1016)));

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean;

        try {

            wsBzWebserviceResParamBean = getDataInfo(pMap);

        } catch (Exception throwable) {
            DsDB2Util dsDB2Util = SWAKInjector.getInstance(DsDB2Util.class);

            DsDB2Util.E_Result result = dsDB2Util.exec(throwable);

            String iwsDsmsgcd = "";

            if (DsDB2Util.E_Result.DEADLOCK.compareTo(result) == 0) {
                iwsDsmsgcd = DwMessageCodeConstants.IWSDSMSGCD_016203;
            }
            else if (DsDB2Util.E_Result.QUERY_TIMEOUT.compareTo(result) == 0) {
                iwsDsmsgcd = DwMessageCodeConstants.IWSDSMSGCD_016202;
            }
            else if (DsDB2Util.E_Result.OTHER.compareTo(result) == 0) {
                throw throwable;
            }

            WsDwRealTimeMailSousinOutputBean wsDwRealTimeMailSousinOutputBean =
                SWAKInjector.getInstance(WsDwRealTimeMailSousinOutputBean.class);
            wsBzWebserviceResParamBean = SWAKInjector.getInstance(WsBzWebserviceResParamBean.class);
            wsDwRealTimeMailSousinOutputBean.setIwsDsmsgcd(iwsDsmsgcd);
            wsBzWebserviceResParamBean.setGyoumuData(JSON.encode(wsDwRealTimeMailSousinOutputBean));
        } finally {
            logger.info(MessageUtil.getMessage(MessageId.IBF0017, MessageUtil.getMessage(MessageId.INW1016)));
        }

        return wsBzWebserviceResParamBean;
    }

    @Override
    public WsBzWebserviceResParamBean execPostFormUpdate(MultivaluedMap<String, String> pMap) {

        logger.info(MessageUtil.getMessage(MessageId.IBF0016, MessageUtil.getMessage(MessageId.INW1016)));

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean;

        try {

            wsBzWebserviceResParamBean = insertSousinRireki(pMap);

        } catch (Exception throwable) {
            DsDB2Util dsDB2Util = SWAKInjector.getInstance(DsDB2Util.class);

            DsDB2Util.E_Result result = dsDB2Util.exec(throwable);

            String iwsDsmsgcd = "";

            if (DsDB2Util.E_Result.DEADLOCK.compareTo(result) == 0) {
                iwsDsmsgcd = DwMessageCodeConstants.IWSDSMSGCD_016203;
            }
            else if (DsDB2Util.E_Result.QUERY_TIMEOUT.compareTo(result) == 0) {
                iwsDsmsgcd = DwMessageCodeConstants.IWSDSMSGCD_016202;
            }
            else if (DsDB2Util.E_Result.OTHER.compareTo(result) == 0) {
                throw throwable;
            }

            WsDwRealTimeMailSousinOutputBean wsDwRealTimeMailSousinOutputBean =
                SWAKInjector.getInstance(WsDwRealTimeMailSousinOutputBean.class);
            wsBzWebserviceResParamBean = SWAKInjector.getInstance(WsBzWebserviceResParamBean.class);
            wsDwRealTimeMailSousinOutputBean.setIwsDsmsgcd(iwsDsmsgcd);
            wsBzWebserviceResParamBean.setGyoumuData(JSON.encode(wsDwRealTimeMailSousinOutputBean));
        } finally {
            logger.info(MessageUtil.getMessage(MessageId.IBF0017, MessageUtil.getMessage(MessageId.INW1016)));
        }

        return wsBzWebserviceResParamBean;
    }

    @Transactional
    WsBzWebserviceResParamBean getDataInfo(MultivaluedMap<String, String> pMap) {

        WsBzWebserviceReqParamBean wsBzWebserviceReqParamBean = SWAKInjector.getInstance(WsBzWebserviceReqParamBean.class);

        try {
            BeanUtils.populate(wsBzWebserviceReqParamBean, pMap);

        }
        catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }

        String gyoumuData = wsBzWebserviceReqParamBean.getGyoumuData();

        WsDwRealTimeMailSousinInputBean getWsDwRealTimeMailSousinInputBean = JSON.decode(gyoumuData, WsDwRealTimeMailSousinInputBean.class);

        WebServiceAccesslogOutput webServiceAccesslogOutput =
            SWAKInjector.getInstance(WebServiceAccesslogOutput.class);
        webServiceAccesslogOutput.exec(C_AccessLogSyubetuKbn.ACTION_BEGIN,
            wsBzWebserviceReqParamBean, getWsDwRealTimeMailSousinInputBean);

        WsDwRealTimeMailSousinOutputBean wsDwRealTimeMailSousinOutputBean = SWAKInjector.getInstance(WsDwRealTimeMailSousinOutputBean.class);

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = SWAKInjector.getInstance(WsBzWebserviceResParamBean.class);

        BizDate sysDate = BizDate.getSysDate();

        wsDwRealTimeMailSousinOutputBean.setIwsSousinymd(new BizDateFormat("yyyy-MM-dd", FillStyle.Zero)
        .format(sysDate));

        wsDwRealTimeMailSousinOutputBean.setIwsSakujyoymd(new BizDateFormat("yyyy-MM-dd", FillStyle.Zero)
        .format(sysDate. addBusinessDays(2)));

        wsDwRealTimeMailSousinOutputBean.setIwsDssousinno(dsSousinNoSyutoku(sysDate));

        wsDwRealTimeMailSousinOutputBean.setIwsDsmsgcd(DwMessageCodeConstants.IWSDSMSGCD_016000);

        wsBzWebserviceResParamBean.setGyoumuData(JSON.encode(wsDwRealTimeMailSousinOutputBean));

        return wsBzWebserviceResParamBean;
    }

    @Transactional
    WsBzWebserviceResParamBean insertSousinRireki(MultivaluedMap<String, String> pMap) {

        WsBzWebserviceReqParamBean wsBzWebserviceReqParamBean = SWAKInjector.getInstance(WsBzWebserviceReqParamBean.class);

        try {
            BeanUtils.populate(wsBzWebserviceReqParamBean, pMap);

        }
        catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }

        String gyoumuData = wsBzWebserviceReqParamBean.getGyoumuData();

        WsDwRealTimeMailSousinInputBean getWsDwRealTimeMailSousinInputBean = JSON.decode(gyoumuData, WsDwRealTimeMailSousinInputBean.class);

        WebServiceAccesslogOutput webServiceAccesslogOutput =
            SWAKInjector.getInstance(WebServiceAccesslogOutput.class);
        webServiceAccesslogOutput.exec(C_AccessLogSyubetuKbn.ACTION_BEGIN,
            wsBzWebserviceReqParamBean, getWsDwRealTimeMailSousinInputBean);

        WsDwRealTimeMailSousinOutputBean wsDwRealTimeMailSousinOutputBean = SWAKInjector.getInstance(WsDwRealTimeMailSousinOutputBean.class);

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = SWAKInjector.getInstance(WsBzWebserviceResParamBean.class);

        try {
            Integer dsMailHaisinRenNo =
                dwRealTimeMailSousinDao.getDsMailHaisinRirekiMaxDsMailHaisinRenNo(BizDate.getSysDate());

            if (dsMailHaisinRenNo != null) {

                dsMailHaisinRenNo++;
            }
            else {

                dsMailHaisinRenNo = DS_MAIL_HAISIN_RENBAN_INIT;
            }

            MT_DsKokyakuKanri dsKokyakuKanri = directDomManager.getDsKokyakuKanri(getWsDwRealTimeMailSousinInputBean.getIwsDskokno());

            MT_DsMailHaisinRireki dsMailHaisinRireki = dsKokyakuKanri.createDsMailHaisinRireki();

            dsMailHaisinRireki.setDsdatasakuseiymd(BizDate.getSysDate());
            dsMailHaisinRireki.setDsmailhaisinrenban(dsMailHaisinRenNo);
            dsMailHaisinRireki.setHaisinjidsmailaddress(getWsDwRealTimeMailSousinInputBean.getIwsDsmailaddress());
            dsMailHaisinRireki.setDssousinno(getWsDwRealTimeMailSousinInputBean.getIwsDssousinno());
            dsMailHaisinRireki.setDssousinmailsyubetukbn(
                C_DsSousinMailSyubetuKbn.valueOf(getWsDwRealTimeMailSousinInputBean.getIwsDssousinmailsyubetukbn()));
            dsMailHaisinRireki.setSyono(getWsDwRealTimeMailSousinInputBean.getIwsSyono());
            dsMailHaisinRireki.setGyoumuKousinKinou(C_DsKinouidKbn.DSREALTIMEMAILSOUSIN.getValue());
            dsMailHaisinRireki.setGyoumuKousinsyaId(baseUserInfo.getUserId());
            dsMailHaisinRireki.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

            BizPropertyInitializer.initialize(dsMailHaisinRireki);


        } catch (Exception e) {

            wsDwRealTimeMailSousinOutputBean.setIwsDsmsgcd(DwMessageCodeConstants.IWSDSMSGCD_016201);
            wsBzWebserviceResParamBean.setGyoumuData(JSON.encode(wsDwRealTimeMailSousinOutputBean));

            return wsBzWebserviceResParamBean;
        }

        wsDwRealTimeMailSousinOutputBean.setIwsDsmsgcd(DwMessageCodeConstants.IWSDSMSGCD_016000);

        wsBzWebserviceResParamBean.setGyoumuData(JSON.encode(wsDwRealTimeMailSousinOutputBean));

        return wsBzWebserviceResParamBean;
    }

    private String dsSousinNoSyutoku(BizDate pSaibanYmd) {

        DsSaibanSyori dsSaibanSyori = SWAKInjector.getInstance(DsSaibanSyori.class);

        String dsSousinNoRenNo = dsSaibanSyori.saibanRealTimeMailDsSousinNoRenban(pSaibanYmd.toString());

        StringBuilder dsSousinNoStringBuilder = new StringBuilder();
        String dsSousinNo = null;
        String day = BizDate.getSysDate().toString().substring(2);
        String time = BizDate.getSysDateTimeMilli().toString().substring(8,12);

        dsSousinNoStringBuilder.append(day);
        dsSousinNoStringBuilder.append("T");
        dsSousinNoStringBuilder.append(time);
        dsSousinNoStringBuilder.append("NR");
        dsSousinNoStringBuilder.append(dsSousinNoRenNo);
        dsSousinNo = dsSousinNoStringBuilder.toString();

        return dsSousinNo;
    }
}
