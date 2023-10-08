package yuyu.app.dsweb.dwhozeninfo.dwgethozenhokenryohurikaekouzainfo;

import java.lang.reflect.InvocationTargetException;
import java.util.Set;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import javax.ws.rs.core.MultivaluedMap;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.util.message.MessageUtil;
import net.arnx.jsonic.JSON;

import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.BzGetBankData;
import yuyu.common.biz.bzcommon.BzGetBankDataBean;
import yuyu.common.biz.bzwebserviceaccesslogoutput.WebServiceAccesslogOutput;
import yuyu.common.direct.dscommon.DsDB2Util;
import yuyu.common.dsweb.dwcommon.DwMessageCodeConstants;
import yuyu.def.MessageId;
import yuyu.def.biz.bean.param.WsBzWebserviceReqParamBean;
import yuyu.def.biz.bean.param.WsBzWebserviceResParamBean;
import yuyu.def.classification.C_AccessLogSyubetuKbn;
import yuyu.def.classification.C_BankmasterUmuKbn;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.db.entity.IT_Kouza;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.dsweb.bean.webservice.WsDwGetHozenHokenryoHurikaeKouzaInfoInputBean;
import yuyu.def.dsweb.bean.webservice.WsDwGetHozenHokenryoHurikaeKouzaInfoOutputBean;
import yuyu.def.hozen.detacher.IT_KykKihonDetacher;
import yuyu.def.hozen.manager.HozenDomManager;

/**
 * 保全保険料振替口座情報取得サービスの実装クラスです。<br />
 */
public class DwGetHozenHokenryoHurikaeKouzaInfoImpl implements DwGetHozenHokenryoHurikaeKouzaInfo {

    private static final String DISP_KINNYUUKIKAN_CODE = "金融機関コード";

    private static final String DISP_SITEN_CODE = "支店コード";

    @Inject
    private static Logger logger;

    @Inject
    private HozenDomManager hozenDomManager;

    @Override
    public WsBzWebserviceResParamBean execPostForm(MultivaluedMap<String, String> pMap) {

        logger.info(MessageUtil.getMessage(MessageId.IBF0016, MessageUtil.getMessage(MessageId.INW1024)));

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean;

        try {

            wsBzWebserviceResParamBean = getHozenHokenryoHurikaeKouzaInfo(pMap);

        } catch (Exception throwable) {

            DsDB2Util dsDB2Util = SWAKInjector.getInstance(DsDB2Util.class);

            DsDB2Util.E_Result hanteiKekka = dsDB2Util.exec(throwable);

            String iwsDsmsgcd = "";

            if (DsDB2Util.E_Result.DEADLOCK.compareTo(hanteiKekka) == 0) {
                iwsDsmsgcd = DwMessageCodeConstants.IWSDSMSGCD_018203;
            }
            else if (DsDB2Util.E_Result.QUERY_TIMEOUT.compareTo(hanteiKekka) == 0) {
                iwsDsmsgcd = DwMessageCodeConstants.IWSDSMSGCD_018202;
            }
            else if (DsDB2Util.E_Result.OTHER.compareTo(hanteiKekka) == 0) {
                throw throwable;
            }

            WsDwGetHozenHokenryoHurikaeKouzaInfoOutputBean getHozenHokenryoHurikaeKouzaInfoOutputBean = SWAKInjector
                .getInstance(WsDwGetHozenHokenryoHurikaeKouzaInfoOutputBean.class);

            wsBzWebserviceResParamBean = SWAKInjector.getInstance(WsBzWebserviceResParamBean.class);

            getHozenHokenryoHurikaeKouzaInfoOutputBean.setIwsDsmsgcd(iwsDsmsgcd);

            wsBzWebserviceResParamBean.setGyoumuData(JSON.encode(getHozenHokenryoHurikaeKouzaInfoOutputBean));

        } finally {
            logger.info(MessageUtil.getMessage(MessageId.IBF0017, MessageUtil.getMessage(MessageId.INW1024)));
        }

        return wsBzWebserviceResParamBean;
    }

    @Transactional
    WsBzWebserviceResParamBean getHozenHokenryoHurikaeKouzaInfo(MultivaluedMap<String, String> pMap) {

        WsBzWebserviceReqParamBean wsBzWebserviceReqParamBean = SWAKInjector
            .getInstance(WsBzWebserviceReqParamBean.class);

        try {
            BeanUtils.populate(wsBzWebserviceReqParamBean, pMap);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }

        String gyoumuData = wsBzWebserviceReqParamBean.getGyoumuData();

        WsDwGetHozenHokenryoHurikaeKouzaInfoInputBean getHozenHokenryoHurikaeKouzaInfoInputBean =
            JSON.decode(gyoumuData, WsDwGetHozenHokenryoHurikaeKouzaInfoInputBean.class);

        WebServiceAccesslogOutput webServiceAccesslogOutput =
            SWAKInjector.getInstance(WebServiceAccesslogOutput.class);

        webServiceAccesslogOutput.exec(C_AccessLogSyubetuKbn.ACTION_BEGIN,
            wsBzWebserviceReqParamBean,
            getHozenHokenryoHurikaeKouzaInfoInputBean);

        WsDwGetHozenHokenryoHurikaeKouzaInfoOutputBean getHozenHokenryoHurikaeKouzaInfoOutputBean =
            SWAKInjector.getInstance(WsDwGetHozenHokenryoHurikaeKouzaInfoOutputBean.class);

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean =
            SWAKInjector.getInstance(WsBzWebserviceResParamBean.class);

        boolean hissuChkKekka = getHozenHokenryoHurikaeKouzaInfoInputBean.chkInput();

        if (!hissuChkKekka) {
            getHozenHokenryoHurikaeKouzaInfoOutputBean.setIwsDsmsgcd(DwMessageCodeConstants.IWSDSMSGCD_018100);
            wsBzWebserviceResParamBean.setGyoumuData(JSON.encode(getHozenHokenryoHurikaeKouzaInfoOutputBean));
            return wsBzWebserviceResParamBean;
        }

        Validator validator = SWAKInjector.getInstance(Validator.class);

        Set<ConstraintViolation<WsDwGetHozenHokenryoHurikaeKouzaInfoInputBean>> validatorChkKekkaSet =
            validator.validate(getHozenHokenryoHurikaeKouzaInfoInputBean);

        if (validatorChkKekkaSet.size() > 0) {
            getHozenHokenryoHurikaeKouzaInfoOutputBean.setIwsDsmsgcd(DwMessageCodeConstants.IWSDSMSGCD_018100);
            wsBzWebserviceResParamBean.setGyoumuData(JSON.encode(getHozenHokenryoHurikaeKouzaInfoOutputBean));
            return wsBzWebserviceResParamBean;
        }

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(getHozenHokenryoHurikaeKouzaInfoInputBean.getIwsSyono());

        IT_Kouza kouza = kykKihon.getKouza();

        IT_KykKihonDetacher.detachKykKihontouched(kykKihon);

        C_Hrkkeiro nowhrkkirkbn = C_Hrkkeiro.BLNK;

        if (C_Hrkkeiro.CREDIT.eq(kykKihon.getHrkkeiro())) {

            nowhrkkirkbn = C_Hrkkeiro.CREDIT;
            getHozenHokenryoHurikaeKouzaInfoOutputBean.setIwsDsmsgcd(DwMessageCodeConstants.IWSDSMSGCD_018000);
            getHozenHokenryoHurikaeKouzaInfoOutputBean.setIwsNowhrkkirkbn(nowhrkkirkbn.getValue());
            wsBzWebserviceResParamBean.setGyoumuData(JSON.encode(getHozenHokenryoHurikaeKouzaInfoOutputBean));
            return wsBzWebserviceResParamBean;
        }

        nowhrkkirkbn = C_Hrkkeiro.KOUHURI;

        if (kouza == null) {

            getHozenHokenryoHurikaeKouzaInfoOutputBean.setIwsDsmsgcd(DwMessageCodeConstants.IWSDSMSGCD_018000);
            wsBzWebserviceResParamBean.setGyoumuData(JSON.encode(getHozenHokenryoHurikaeKouzaInfoOutputBean));
            return wsBzWebserviceResParamBean;
        }

        BzGetBankData bzGetBankData = SWAKInjector.getInstance(BzGetBankData.class);
        String wkBankCd = "";
        String wkSitenCd = "";

        BzGetBankDataBean bzGetBankDataBean = bzGetBankData.
            exec(kouza.getBankcd(), kouza.getSitencd());

        if (C_BankmasterUmuKbn.ARI.eq(bzGetBankDataBean.getBankmasterUmuKbn())) {

            if (kouza.getBankcd().equals("9900")) {
                wkBankCd = bzGetBankDataBean.getBankNmKj();
                wkSitenCd = "";
            } else {
                wkBankCd = bzGetBankDataBean.getBankNmKj();
                wkSitenCd = bzGetBankDataBean.getSitenNmKj();
            }
        } else {

            wkBankCd = DISP_KINNYUUKIKAN_CODE + kouza.getBankcd();
            wkSitenCd = DISP_SITEN_CODE + kouza.getSitencd();
        }

        getHozenHokenryoHurikaeKouzaInfoOutputBean.setIwsDsmsgcd(DwMessageCodeConstants.IWSDSMSGCD_018000);
        getHozenHokenryoHurikaeKouzaInfoOutputBean.setIwsBankcd(kouza.getBankcd());
        getHozenHokenryoHurikaeKouzaInfoOutputBean.setIwsSitencd(kouza.getSitencd());
        getHozenHokenryoHurikaeKouzaInfoOutputBean.setIwsBanknmkj(wkBankCd);
        getHozenHokenryoHurikaeKouzaInfoOutputBean.setIwsSitennmkj(wkSitenCd);
        getHozenHokenryoHurikaeKouzaInfoOutputBean.setIwsYokinsyumoku(kouza.getYokinkbn().getValue());
        getHozenHokenryoHurikaeKouzaInfoOutputBean.setIwsKouzano(kouza.getKouzano());
        getHozenHokenryoHurikaeKouzaInfoOutputBean.setIwsKzkykdoukbn(kouza.getKzkykdoukbn().getValue());
        getHozenHokenryoHurikaeKouzaInfoOutputBean.setIwsKzmeiginmkn(kouza.getKzmeiginmkn());
        getHozenHokenryoHurikaeKouzaInfoOutputBean.setIwsVersion(String.valueOf(kouza.getVersion()));
        getHozenHokenryoHurikaeKouzaInfoOutputBean.setIwsNowhrkkirkbn(nowhrkkirkbn.getValue());

        wsBzWebserviceResParamBean.setGyoumuData(JSON.encode(getHozenHokenryoHurikaeKouzaInfoOutputBean));
        return wsBzWebserviceResParamBean;
    }
}
