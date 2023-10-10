package yuyu.app.dsweb.dwnetservicesousin.dwmailaddresshenkou;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Set;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import javax.ws.rs.core.MultivaluedMap;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.util.message.MessageUtil;
import net.arnx.jsonic.JSON;

import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;

import yuyu.common.base.BaseUserInfo;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bzwebserviceaccesslogoutput.WebServiceAccesslogOutput;
import yuyu.common.direct.dscommon.DsDB2Util;
import yuyu.common.direct.dscommon.DsSaibanSyori;
import yuyu.common.direct.dscommon.DsTetudukiRirekiTableEdit;
import yuyu.common.direct.dscommon.DsTetudukiRirekiTableEditParamImpl;
import yuyu.common.direct.dscommon.TableMaintenanceUtil;
import yuyu.common.dsweb.dwcommon.DwMessageCodeConstants;
import yuyu.def.MessageId;
import yuyu.def.biz.bean.param.WsBzWebserviceReqParamBean;
import yuyu.def.biz.bean.param.WsBzWebserviceResParamBean;
import yuyu.def.classification.C_AccessLogSyubetuKbn;
import yuyu.def.classification.C_DsKinouidKbn;
import yuyu.def.classification.C_DsMailSousinJyoutaiKbn;
import yuyu.def.classification.C_DsMailSousinTeisiRiyuuKbn;
import yuyu.def.classification.C_DsMailTourokuJyoutaiKbn;
import yuyu.def.classification.C_DsSyoriKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.MT_BAK_DsKokyakuKanri;
import yuyu.def.db.entity.MT_DsKokyakuKanri;
import yuyu.def.db.entity.MT_DsMailAddress;
import yuyu.def.db.entity.MT_DsMailAddressSpiralYyk;
import yuyu.def.db.entity.MT_DsMailHaisinRireki;
import yuyu.def.direct.manager.DirectDomManager;
import yuyu.def.direct.sorter.SortMT_DsMailHaisinRireki;
import yuyu.def.dsweb.bean.webservice.WsDwMailaddressHenkouInputBean;
import yuyu.def.dsweb.bean.webservice.WsDwMailaddressHenkouOutputBean;
import yuyu.def.dsweb.configuration.YuyuDswebConfig;

/**
 * ダイレクトサービス（Ｗｅｂ） ネットサービス入力情報送信 メール変更
 */
public class DwMailAddressHenkouImpl implements DwMailAddressHenkou{

    @Inject
    private static Logger logger;

    @Inject
    private DirectDomManager directDomManager;

    @Inject
    private BaseUserInfo baseUserInfo;

    @Override
    public WsBzWebserviceResParamBean execPostFormForPrepare(MultivaluedMap<String, String> pMap) {

        logger.info(MessageUtil.getMessage(MessageId.IBF0016, MessageUtil.getMessage(MessageId.INW1009)));

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean;

        try {

            wsBzWebserviceResParamBean = prepareMain(pMap);

        } catch (Exception throwable) {
            DsDB2Util dsDB2Util = SWAKInjector.getInstance(DsDB2Util.class);

            DsDB2Util.E_Result result = dsDB2Util.exec(throwable);

            String iwsDsmsgcd = "";

            if (DsDB2Util.E_Result.DEADLOCK.compareTo(result) == 0) {
                iwsDsmsgcd = DwMessageCodeConstants.IWSDSMSGCD_009203;
            }
            else if (DsDB2Util.E_Result.QUERY_TIMEOUT.compareTo(result) == 0) {
                iwsDsmsgcd = DwMessageCodeConstants.IWSDSMSGCD_009202;
            }
            else if (DsDB2Util.E_Result.OTHER.compareTo(result) == 0) {
                throw throwable;
            }

            WsDwMailaddressHenkouOutputBean wsDwMailaddressHenkouOutputBean =
                    SWAKInjector.getInstance(WsDwMailaddressHenkouOutputBean.class);
            wsBzWebserviceResParamBean = SWAKInjector.getInstance(WsBzWebserviceResParamBean.class);
            wsDwMailaddressHenkouOutputBean.setIwsDsmsgcd(iwsDsmsgcd);
            wsBzWebserviceResParamBean.setGyoumuData(JSON.encode(wsDwMailaddressHenkouOutputBean));
        } finally {
            logger.info(MessageUtil.getMessage(MessageId.IBF0017, MessageUtil.getMessage(MessageId.INW1009)));
        }

        return wsBzWebserviceResParamBean;
    }

    @Override
    public WsBzWebserviceResParamBean execPostFormUpdate(MultivaluedMap<String, String> pMap) {

        logger.info(MessageUtil.getMessage(MessageId.IBF0016, MessageUtil.getMessage(MessageId.INW1009)));

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean;

        try {

            wsBzWebserviceResParamBean = updateMain(pMap);

        } catch (Exception throwable) {
            DsDB2Util dsDB2Util = SWAKInjector.getInstance(DsDB2Util.class);

            DsDB2Util.E_Result result = dsDB2Util.exec(throwable);

            String iwsDsmsgcd = "";

            if (DsDB2Util.E_Result.DEADLOCK.compareTo(result) == 0) {
                iwsDsmsgcd = DwMessageCodeConstants.IWSDSMSGCD_009203;
            }
            else if (DsDB2Util.E_Result.QUERY_TIMEOUT.compareTo(result) == 0) {
                iwsDsmsgcd = DwMessageCodeConstants.IWSDSMSGCD_009202;
            }
            else if (DsDB2Util.E_Result.OTHER.compareTo(result) == 0) {
                throw throwable;
            }

            WsDwMailaddressHenkouOutputBean wsDwMailaddressHenkouOutputBean =
                    SWAKInjector.getInstance(WsDwMailaddressHenkouOutputBean.class);
            wsBzWebserviceResParamBean = SWAKInjector.getInstance(WsBzWebserviceResParamBean.class);
            wsDwMailaddressHenkouOutputBean.setIwsDsmsgcd(iwsDsmsgcd);
            wsBzWebserviceResParamBean.setGyoumuData(JSON.encode(wsDwMailaddressHenkouOutputBean));
        } finally {
            logger.info(MessageUtil.getMessage(MessageId.IBF0017, MessageUtil.getMessage(MessageId.INW1009)));
        }

        return wsBzWebserviceResParamBean;
    }

    @Transactional
    WsBzWebserviceResParamBean prepareMain(MultivaluedMap<String, String> pMap) {

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

        WsDwMailaddressHenkouInputBean getWsDwEmailHenkouInputBean = JSON.decode(gyoumuData, WsDwMailaddressHenkouInputBean.class);

        WebServiceAccesslogOutput webServiceAccesslogOutput =
                SWAKInjector.getInstance(WebServiceAccesslogOutput.class);
        webServiceAccesslogOutput.exec(C_AccessLogSyubetuKbn.ACTION_BEGIN,
                wsBzWebserviceReqParamBean, getWsDwEmailHenkouInputBean);

        WsDwMailaddressHenkouOutputBean wsDwMailaddressHenkouOutputBean = SWAKInjector.getInstance(WsDwMailaddressHenkouOutputBean.class);

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = SWAKInjector.getInstance(WsBzWebserviceResParamBean.class);

        boolean chkKekkaSet = getWsDwEmailHenkouInputBean.chkHissuInput();

        if (chkKekkaSet == false ) {

            wsDwMailaddressHenkouOutputBean.setIwsDsmsgcd(DwMessageCodeConstants.IWSDSMSGCD_009100);
            wsBzWebserviceResParamBean.setGyoumuData(JSON.encode(wsDwMailaddressHenkouOutputBean));

            return wsBzWebserviceResParamBean;
        }

        Validator validator = SWAKInjector.getInstance(Validator.class);
        Set<ConstraintViolation<WsDwMailaddressHenkouInputBean>> checkResult = validator.validate(getWsDwEmailHenkouInputBean);
        if (checkResult.size() > 0) {

            wsDwMailaddressHenkouOutputBean.setIwsDsmsgcd(DwMessageCodeConstants.IWSDSMSGCD_009100);
            wsBzWebserviceResParamBean.setGyoumuData(JSON.encode(wsDwMailaddressHenkouOutputBean));

            return wsBzWebserviceResParamBean;
        }

        MT_DsKokyakuKanri dsKokyakuKanri = directDomManager.getDsKokyakuKanri(getWsDwEmailHenkouInputBean.getIwsDskokno());

        MT_DsMailAddressSpiralYyk dsMailAddressSpiralYyk = dsKokyakuKanri.getDsMailAddressSpiralYykByDsdatasakuseiymdDsmailaddressrenban(BizDate.getSysDate(), 1);

        if (dsMailAddressSpiralYyk != null) {

            wsDwMailaddressHenkouOutputBean.setIwsDsmailaddressdbsyorikbn(dsMailAddressSpiralYyk.getDsmaildbsyorikbn().getValue());
        }

        MT_DsMailAddress dsMailAddress = dsKokyakuKanri.getDsMailAddressByDsmailaddressrenban(1);

        if (dsMailAddress == null) {

            wsDwMailaddressHenkouOutputBean.setIwsDsmsgcd(DwMessageCodeConstants.IWSDSMSGCD_009200);
        }
        else {

            wsDwMailaddressHenkouOutputBean.setIwsDssousinno(dsSousinNoSyutoku());
            wsDwMailaddressHenkouOutputBean.setIwsHaisinruleid1(YuyuDswebConfig.getInstance().getHaisinRuleId1());
            wsDwMailaddressHenkouOutputBean.setIwsDsmsgcd(DwMessageCodeConstants.IWSDSMSGCD_000000);
        }

        wsBzWebserviceResParamBean.setGyoumuData(JSON.encode(wsDwMailaddressHenkouOutputBean));

        return wsBzWebserviceResParamBean;
    }

    @Transactional
    WsBzWebserviceResParamBean updateMain(MultivaluedMap<String, String> pMap) {

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

        WsDwMailaddressHenkouInputBean getWsDwEmailHenkouInputBean = JSON.decode(gyoumuData, WsDwMailaddressHenkouInputBean.class);

        WebServiceAccesslogOutput webServiceAccesslogOutput =
                SWAKInjector.getInstance(WebServiceAccesslogOutput.class);
        webServiceAccesslogOutput.exec(C_AccessLogSyubetuKbn.ACTION_BEGIN,
                wsBzWebserviceReqParamBean, getWsDwEmailHenkouInputBean);

        WsDwMailaddressHenkouOutputBean wsDwMailaddressHenkouOutputBean = SWAKInjector.getInstance(WsDwMailaddressHenkouOutputBean.class);

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = SWAKInjector.getInstance(WsBzWebserviceResParamBean.class);

        String henkouSikiBetuKey = backup(getWsDwEmailHenkouInputBean.getIwsDskokno());

        try {
            mailInfoUpdate(getWsDwEmailHenkouInputBean);

        } catch (Exception e) {

            wsDwMailaddressHenkouOutputBean.setIwsDsmsgcd(DwMessageCodeConstants.IWSDSMSGCD_009201);
            wsBzWebserviceResParamBean.setGyoumuData(JSON.encode(wsDwMailaddressHenkouOutputBean));

            return wsBzWebserviceResParamBean;
        }

        DsTetudukiRirekiTableEdit dsTetudukiRirekiTableEdit = SWAKInjector.getInstance(DsTetudukiRirekiTableEdit.class);
        DsTetudukiRirekiTableEditParamImpl dsTetudukiRirekiTableEditParamImpl = SWAKInjector.getInstance(DsTetudukiRirekiTableEditParamImpl.class);
        AS_Kinou kinou = new AS_Kinou();

        kinou.setKinouId(C_DsKinouidKbn.MAILHENKOU.getValue());

        dsTetudukiRirekiTableEditParamImpl.setDskokno(getWsDwEmailHenkouInputBean.getIwsDskokno());
        dsTetudukiRirekiTableEditParamImpl.setHenkousikibetukey(henkouSikiBetuKey);
        dsTetudukiRirekiTableEditParamImpl.setSyoriYmd(BizDate.getSysDate());
        dsTetudukiRirekiTableEditParamImpl.setDssyorikbn(C_DsSyoriKbn.MAIL_HENKOU);
        dsTetudukiRirekiTableEditParamImpl.setHenkouRrkYouhi(C_YouhiKbn.YOU);

        dsTetudukiRirekiTableEdit.editDSTtdkRirekiTblWebService(dsTetudukiRirekiTableEditParamImpl, kinou);
        wsDwMailaddressHenkouOutputBean.setIwsDsmsgcd(DwMessageCodeConstants.IWSDSMSGCD_000000);

        wsBzWebserviceResParamBean.setGyoumuData(JSON.encode(wsDwMailaddressHenkouOutputBean));

        return wsBzWebserviceResParamBean;
    }

    private String dsSousinNoSyutoku() {

        DsSaibanSyori dsSaibanSyori = SWAKInjector.getInstance(DsSaibanSyori.class);
        String dsSousinNoRenNo = dsSaibanSyori.saibanDsSousinNoRenban();

        StringBuilder stringBuilder = new StringBuilder();
        String dsSousinNo = null;
        String day = BizDate.getSysDate().toString().substring(2);
        String time = BizDate.getSysDateTimeMilli().toString().substring(8,12);

        stringBuilder.append(day);
        stringBuilder.append("T");
        stringBuilder.append(time);
        stringBuilder.append("N");
        stringBuilder.append(dsSousinNoRenNo);
        dsSousinNo = stringBuilder.toString();

        return dsSousinNo;
    }

    private String backup(String pDsKokyakuNo) {

        DsSaibanSyori dsSaibanSyori = SWAKInjector.getInstance(DsSaibanSyori.class);

        String dsHenkouSikiBetuKey = dsSaibanSyori.saibanDsHenkouSikibetukey();

        TableMaintenanceUtil tableMaintenanceUtil = SWAKInjector.getInstance(TableMaintenanceUtil.class);

        MT_BAK_DsKokyakuKanri dsKokyakuKanri = tableMaintenanceUtil.exec(pDsKokyakuNo, dsHenkouSikiBetuKey);

        directDomManager.insert(dsKokyakuKanri);

        return dsHenkouSikiBetuKey;
    }

    private void mailInfoUpdate(WsDwMailaddressHenkouInputBean pWsDwEmailHenkouInputBean) {

        BizDate sysDate = BizDate.getSysDate();
        String sysDateTimeMilli = BizDate.getSysDateTimeMilli();
        int dsMailHaisinRenban = 0;

        MT_DsKokyakuKanri dsKokyakuKanri = directDomManager.getDsKokyakuKanri(pWsDwEmailHenkouInputBean.getIwsDskokno());

        MT_DsMailAddress dsMailAddress = dsKokyakuKanri.getDsMailAddressByDsmailaddressrenban(1);

        MT_DsMailAddressSpiralYyk dsMailAddressSpiralYyk =
                dsKokyakuKanri.getDsMailAddressSpiralYykByDsdatasakuseiymdDsmailaddressrenban(sysDate, 1);

        if (!BizUtil.isBlank(pWsDwEmailHenkouInputBean.getIwsDsmailaddress())) {

            List<MT_DsMailHaisinRireki> dsMailHaisinRirekiLst = dsKokyakuKanri.getDsMailHaisinRirekisByDsdatasakuseiymd(sysDate);

            SortMT_DsMailHaisinRireki sortMT_DsMailHaisinRireki = SWAKInjector.getInstance(SortMT_DsMailHaisinRireki.class);

            dsMailHaisinRirekiLst = sortMT_DsMailHaisinRireki.OrderMT_DsMailHaisinRirekiByPkDesc(dsMailHaisinRirekiLst);

            if (dsMailHaisinRirekiLst.size() != 0) {

                dsMailHaisinRenban = dsMailHaisinRirekiLst.get(0).getDsmailhaisinrenban() + 1;
            }
            else {

                dsMailHaisinRenban = 1;
            }
        }

        if (!BizUtil.isBlank(pWsDwEmailHenkouInputBean.getIwsDsmailaddress())) {

            dsMailAddress.setDsmailtourokujyoutaikbn(C_DsMailTourokuJyoutaiKbn.TOUROKU);
            dsMailAddress.setDsmailaddress(pWsDwEmailHenkouInputBean.getIwsDsmailaddress());
            dsMailAddress.setDsmailsousinjyoutaikbn(C_DsMailSousinJyoutaiKbn.YUUKOU);
            dsMailAddress.setDsmailsousintisrykbn(C_DsMailSousinTeisiRiyuuKbn.BLNK);
            dsMailAddress.setDskousinymdtime(sysDateTimeMilli);
            dsMailAddress.setGyoumuKousinKinou(C_DsKinouidKbn.MAILHENKOU.getValue());
            dsMailAddress.setGyoumuKousinsyaId(baseUserInfo.getUserId());
            dsMailAddress.setGyoumuKousinTime(sysDateTimeMilli);
        }
        else {

            dsMailAddress.setDsmailtourokujyoutaikbn(C_DsMailTourokuJyoutaiKbn.SAKUJYO);
            dsMailAddress.setDsmailaddress(pWsDwEmailHenkouInputBean.getIwsDsmailaddress());
            dsMailAddress.setDsmailsousinjyoutaikbn(C_DsMailSousinJyoutaiKbn.BLNK);
            dsMailAddress.setDsmailsousintisrykbn(C_DsMailSousinTeisiRiyuuKbn.BLNK);
            dsMailAddress.setDskousinymdtime(sysDateTimeMilli);
            dsMailAddress.setGyoumuKousinKinou(C_DsKinouidKbn.MAILHENKOU.getValue());
            dsMailAddress.setGyoumuKousinsyaId(baseUserInfo.getUserId());
            dsMailAddress.setGyoumuKousinTime(sysDateTimeMilli);
        }

        if (dsMailAddressSpiralYyk != null) {

            List<MT_DsMailAddressSpiralYyk> dsMailAddressSpiralYykLst = dsKokyakuKanri.getDsMailAddressSpiralYyks();

            dsMailAddressSpiralYykLst.remove(dsMailAddressSpiralYyk);
        }

        if (!BizUtil.isBlank(pWsDwEmailHenkouInputBean.getIwsDsmailaddress())) {

            MT_DsMailHaisinRireki dsMailHaisinRireki = dsKokyakuKanri.createDsMailHaisinRireki();

            dsMailHaisinRireki.setDsdatasakuseiymd(sysDate);
            dsMailHaisinRireki.setDsmailhaisinrenban(dsMailHaisinRenban);
            dsMailHaisinRireki.setHaisinjidsmailaddress(pWsDwEmailHenkouInputBean.getIwsDsmailaddress());
            dsMailHaisinRireki.setDssousinno(pWsDwEmailHenkouInputBean.getIwsDssousinno());
            dsMailHaisinRireki.setGyoumuKousinKinou(C_DsKinouidKbn.MAILHENKOU.getValue());
            dsMailHaisinRireki.setGyoumuKousinsyaId(baseUserInfo.getUserId());
            dsMailHaisinRireki.setGyoumuKousinTime(sysDateTimeMilli);

            BizPropertyInitializer.initialize(dsMailHaisinRireki);
        }

        directDomManager.update(dsKokyakuKanri);
    }
}
