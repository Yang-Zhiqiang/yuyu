package yuyu.app.dsweb.dwninsyou.dwpasswordhenkou;

import java.lang.reflect.InvocationTargetException;
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
import yuyu.common.biz.bzcommon.RayConvertUtil;
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
import yuyu.def.classification.C_DsKokyakuJtKbn;
import yuyu.def.classification.C_DsKrHnnKakCdSetKbn;
import yuyu.def.classification.C_DsSyoriKbn;
import yuyu.def.classification.C_DsTeisiRiyuuKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.MT_BAK_DsKokyakuKanri;
import yuyu.def.db.entity.MT_DsHonninKakuninCd;
import yuyu.def.db.entity.MT_DsKokyakuKanri;
import yuyu.def.direct.manager.DirectDomManager;
import yuyu.def.dsweb.bean.webservice.WsDwPasswordHenkouInputBean;
import yuyu.def.dsweb.bean.webservice.WsDwPasswordHenkouOutputBean;

/**
 * パスワード変更サービスの実装クラスです。<br />
 */
public class DwPasswordHenkouImpl implements DwPasswordHenkou {

    @Inject
    private static Logger logger;

    @Inject
    private DirectDomManager directDomManager;

    @Inject
    private BaseUserInfo baseUserInfo;

    @Override
    public WsBzWebserviceResParamBean execPostForm(MultivaluedMap<String, String> pMap) {

        logger.info(MessageUtil.getMessage(MessageId.IBF0016, MessageUtil.getMessage(MessageId.INW1003)));

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean;

        try {
            wsBzWebserviceResParamBean = passwordHenkouMain(pMap);
        } catch (Exception throwable) {
            DsDB2Util dsDB2Util = SWAKInjector.getInstance(DsDB2Util.class);

            DsDB2Util.E_Result result = dsDB2Util.exec(throwable);

            String iwsDsmsgcd = "";

            if (DsDB2Util.E_Result.DEADLOCK.compareTo(result) == 0) {
                iwsDsmsgcd = DwMessageCodeConstants.IWSDSMSGCD_003203;
            }
            else if (DsDB2Util.E_Result.QUERY_TIMEOUT.compareTo(result) == 0) {
                iwsDsmsgcd = DwMessageCodeConstants.IWSDSMSGCD_003202;
            }
            else if (DsDB2Util.E_Result.OTHER.compareTo(result) == 0) {
                throw throwable;
            }

            WsDwPasswordHenkouOutputBean wsDwPasswordHenkouOutputBean = SWAKInjector.getInstance(WsDwPasswordHenkouOutputBean.class);
            wsBzWebserviceResParamBean = SWAKInjector.getInstance(WsBzWebserviceResParamBean.class);
            wsDwPasswordHenkouOutputBean.setIwsDsmsgcd(iwsDsmsgcd);
            wsBzWebserviceResParamBean.setGyoumuData(JSON.encode(wsDwPasswordHenkouOutputBean));
        } finally {
            logger.info(MessageUtil.getMessage(MessageId.IBF0017, MessageUtil.getMessage(MessageId.INW1003)));
        }

        return wsBzWebserviceResParamBean;
    }

    @Transactional
    WsBzWebserviceResParamBean passwordHenkouMain(MultivaluedMap<String, String> pMap) {

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

        WsDwPasswordHenkouInputBean wsDwPasswordHenkouInputBean = JSON.decode(gyoumuData, WsDwPasswordHenkouInputBean.class);

        WebServiceAccesslogOutput webServiceAccesslogOutput =
                SWAKInjector.getInstance(WebServiceAccesslogOutput.class);
        webServiceAccesslogOutput.exec(C_AccessLogSyubetuKbn.ACTION_BEGIN,
                wsBzWebserviceReqParamBean, wsDwPasswordHenkouInputBean);

        WsDwPasswordHenkouOutputBean wsDwPasswordHenkouOutputBean = SWAKInjector.getInstance(WsDwPasswordHenkouOutputBean.class);
        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = SWAKInjector.getInstance(WsBzWebserviceResParamBean.class);

        boolean hissuCheckKekka = wsDwPasswordHenkouInputBean.hissuCheck();

        if (!hissuCheckKekka) {
            wsDwPasswordHenkouOutputBean.setIwsDsmsgcd(DwMessageCodeConstants.IWSDSMSGCD_003100);

            wsBzWebserviceResParamBean.setGyoumuData(JSON.encode(wsDwPasswordHenkouOutputBean));

            return wsBzWebserviceResParamBean;
        }

        Validator validator = SWAKInjector.getInstance(Validator.class);
        Set<ConstraintViolation<WsDwPasswordHenkouInputBean>> chkKekkaSet = validator.validate(wsDwPasswordHenkouInputBean);

        if(chkKekkaSet.size() > 0){
            wsDwPasswordHenkouOutputBean.setIwsDsmsgcd(DwMessageCodeConstants.IWSDSMSGCD_003100);
            wsBzWebserviceResParamBean.setGyoumuData(JSON.encode(wsDwPasswordHenkouOutputBean));

            return wsBzWebserviceResParamBean;
        }

        RayConvertUtil.toValidString(wsDwPasswordHenkouInputBean);

        String iwsDsmsgcd = passwordHenkou(wsDwPasswordHenkouInputBean.getIwsDskokno(), wsDwPasswordHenkouInputBean.getIwsSclakatopassword());
        wsDwPasswordHenkouOutputBean.setIwsDsmsgcd(iwsDsmsgcd);

        wsBzWebserviceResParamBean.setGyoumuData(JSON.encode(wsDwPasswordHenkouOutputBean));

        return wsBzWebserviceResParamBean;
    }

    private String passwordHenkou(String pDskokno, String pPassword){

        String iwsDsmsgcd = "";

        MT_DsKokyakuKanri mtDsKokyakuKanri = directDomManager.getDsKokyakuKanri(pDskokno);

        if (mtDsKokyakuKanri == null) {
            iwsDsmsgcd = DwMessageCodeConstants.IWSDSMSGCD_003200;
            return iwsDsmsgcd;
        }

        MT_DsHonninKakuninCd mtDsHonninKakuninCd = mtDsKokyakuKanri.getDsHonninKakuninCd();

        DsSaibanSyori dsSaibanSyori = SWAKInjector.getInstance(DsSaibanSyori.class);

        String dsHenkousikibetukey = dsSaibanSyori.saibanDsHenkouSikibetukey();

        TableMaintenanceUtil tableMaintenanceUtil = SWAKInjector.getInstance(TableMaintenanceUtil.class);

        MT_BAK_DsKokyakuKanri bakDsKokyakuKanri = tableMaintenanceUtil.exec(pDskokno, dsHenkousikibetukey);

        directDomManager.insert(bakDsKokyakuKanri);

        String kinouId     = C_DsKinouidKbn.PASSWORDHENKOU.getValue();
        String userId      = baseUserInfo.getUserId();
        BizDate sysDate    = BizDate.getSysDate();
        String sysDateTime = BizDate.getSysDateTimeMilli();

        mtDsKokyakuKanri.setDskokyakujtkbn(C_DsKokyakuJtKbn.YUUKOU);
        mtDsKokyakuKanri.setDsteisiriyuukbn(C_DsTeisiRiyuuKbn.BLANK);
        mtDsKokyakuKanri.setDskokyakumukouymd(null);
        mtDsKokyakuKanri.setGyoumuKousinKinou(kinouId);
        mtDsKokyakuKanri.setGyoumuKousinsyaId(userId);
        mtDsKokyakuKanri.setGyoumuKousinTime(sysDateTime);

        mtDsHonninKakuninCd.setDskrhnnkakcd("");
        mtDsHonninKakuninCd.setDskrhnnkakcdsetkbn(C_DsKrHnnKakCdSetKbn.BLANK);
        mtDsHonninKakuninCd.setDskrhnnkakcdsetymd(null);
        mtDsHonninKakuninCd.setDskrhnnkakcdyuukouymd(null);
        mtDsHonninKakuninCd.setDshnnkakcd(pPassword);
        mtDsHonninKakuninCd.setDshnnkakcdsetymd(sysDate);
        mtDsHonninKakuninCd.setGyoumuKousinKinou(kinouId);
        mtDsHonninKakuninCd.setGyoumuKousinsyaId(userId);
        mtDsHonninKakuninCd.setGyoumuKousinTime(sysDateTime);

        try {
            directDomManager.update(mtDsKokyakuKanri);
        } catch (Exception e) {
            iwsDsmsgcd = DwMessageCodeConstants.IWSDSMSGCD_003201;
            return iwsDsmsgcd;
        }

        DsTetudukiRirekiTableEdit dsTetudukiRirekiTableEdit =
                SWAKInjector.getInstance(DsTetudukiRirekiTableEdit.class);

        DsTetudukiRirekiTableEditParamImpl dsEditTtdkRirekiTblParam =
                SWAKInjector.getInstance(DsTetudukiRirekiTableEditParamImpl.class);

        AS_Kinou kinou = new AS_Kinou();
        kinou.setKinouId(C_DsKinouidKbn.PASSWORDHENKOU.getValue());

        dsEditTtdkRirekiTblParam.setDskokno(pDskokno);
        dsEditTtdkRirekiTblParam.setHenkousikibetukey(dsHenkousikibetukey);
        dsEditTtdkRirekiTblParam.setSyoriYmd(sysDate);
        dsEditTtdkRirekiTblParam.setDssyorikbn(C_DsSyoriKbn.PASSWORD_HENKOU);
        dsEditTtdkRirekiTblParam.setHenkouRrkYouhi(C_YouhiKbn.YOU);
        dsTetudukiRirekiTableEdit.editDSTtdkRirekiTblWebService(dsEditTtdkRirekiTblParam, kinou);

        iwsDsmsgcd = DwMessageCodeConstants.IWSDSMSGCD_000000;

        return iwsDsmsgcd;
    }

}
