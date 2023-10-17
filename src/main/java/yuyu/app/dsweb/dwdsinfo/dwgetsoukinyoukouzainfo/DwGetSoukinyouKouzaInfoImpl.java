package yuyu.app.dsweb.dwdsinfo.dwgetsoukinyoukouzainfo;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
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

import yuyu.app.dsweb.dwdsinfo.dwgetsoukinyoukouzainfo.dba.DwGetSoukinyouKouzaInfoDao;
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
import yuyu.def.db.entity.MT_DsSoukinyouKouza;
import yuyu.def.dsweb.bean.webservice.WsDwGetSoukinyouKouzaInfoInputBean;
import yuyu.def.dsweb.bean.webservice.WsDwGetSoukinyouKouzaInfoOutputBean;

/**
 * ＤＳ送金用口座情報取得サービスの実装クラスです。<br />
 */
public class DwGetSoukinyouKouzaInfoImpl implements DwGetSoukinyouKouzaInfo {

    private static final String DISP_KINNYUUKIKAN_CODE = "金融機関コード";

    private static final String DISP_SITEN_CODE = "支店コード";

    @Inject
    private static Logger logger;

    @Inject
    private DwGetSoukinyouKouzaInfoDao dsSoukinyouKouzaInfoDao;

    @Override
    public WsBzWebserviceResParamBean execPostForm(MultivaluedMap<String, String> pMap) {

        logger.info(MessageUtil.getMessage(MessageId.IBF0016, MessageUtil.getMessage(MessageId.INW1013)));

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean;

        try {
            wsBzWebserviceResParamBean = getDsSoukinyouKouzaInfoMain(pMap);
        } catch (Exception throwable) {
            DsDB2Util dsDB2Util = SWAKInjector.getInstance(DsDB2Util.class);

            DsDB2Util.E_Result hanteiKekka = dsDB2Util.exec(throwable);

            String iwsDsmsgcd = "";

            if (DsDB2Util.E_Result.DEADLOCK.compareTo(hanteiKekka) == 0) {
                iwsDsmsgcd = DwMessageCodeConstants.IWSDSMSGCD_015203;
            }
            else if (DsDB2Util.E_Result.QUERY_TIMEOUT.compareTo(hanteiKekka) == 0) {
                iwsDsmsgcd = DwMessageCodeConstants.IWSDSMSGCD_015202;
            }
            else if (DsDB2Util.E_Result.OTHER.compareTo(hanteiKekka) == 0) {
                throw throwable;
            }

            WsDwGetSoukinyouKouzaInfoOutputBean dsSoukinyouKouzaInfoOutputBean = SWAKInjector
                .getInstance(WsDwGetSoukinyouKouzaInfoOutputBean.class);

            wsBzWebserviceResParamBean = SWAKInjector.getInstance(WsBzWebserviceResParamBean.class);

            dsSoukinyouKouzaInfoOutputBean.setIwsDsmsgcd(iwsDsmsgcd);

            wsBzWebserviceResParamBean.setGyoumuData(JSON.encode(dsSoukinyouKouzaInfoOutputBean));
        } finally {
            logger.info(MessageUtil.getMessage(MessageId.IBF0017, MessageUtil.getMessage(MessageId.INW1013)));
        }

        return wsBzWebserviceResParamBean;
    }

    @Transactional
    WsBzWebserviceResParamBean getDsSoukinyouKouzaInfoMain(MultivaluedMap<String, String> pMap) {

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

        WsDwGetSoukinyouKouzaInfoInputBean dsSoukinyouKouzaInfoInputBean =
            JSON.decode(gyoumuData, WsDwGetSoukinyouKouzaInfoInputBean.class);

        WebServiceAccesslogOutput webServiceAccesslogOutput =
            SWAKInjector.getInstance(WebServiceAccesslogOutput.class);

        webServiceAccesslogOutput.exec(C_AccessLogSyubetuKbn.ACTION_BEGIN,
            wsBzWebserviceReqParamBean,
            dsSoukinyouKouzaInfoInputBean);

        WsDwGetSoukinyouKouzaInfoOutputBean dsSoukinyouKouzaInfoOutputBean =
            SWAKInjector.getInstance(WsDwGetSoukinyouKouzaInfoOutputBean.class);

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean =
            SWAKInjector.getInstance(WsBzWebserviceResParamBean.class);

        boolean hissuChkKekka = dsSoukinyouKouzaInfoInputBean.chkHissuInput();

        if (!hissuChkKekka) {
            dsSoukinyouKouzaInfoOutputBean.setIwsDsmsgcd(DwMessageCodeConstants.IWSDSMSGCD_015100);
            wsBzWebserviceResParamBean.setGyoumuData(JSON.encode(dsSoukinyouKouzaInfoOutputBean));
            return wsBzWebserviceResParamBean;
        }

        Validator validator = SWAKInjector.getInstance(Validator.class);

        Set<ConstraintViolation<WsDwGetSoukinyouKouzaInfoInputBean>> validatorChkKekkaSet =
            validator.validate(dsSoukinyouKouzaInfoInputBean);

        if (validatorChkKekkaSet.size() > 0) {
            dsSoukinyouKouzaInfoOutputBean.setIwsDsmsgcd(DwMessageCodeConstants.IWSDSMSGCD_015100);
            wsBzWebserviceResParamBean.setGyoumuData(JSON.encode(dsSoukinyouKouzaInfoOutputBean));
            return wsBzWebserviceResParamBean;
        }

        List<MT_DsSoukinyouKouza> mtDsSoukinyouKouzas =
            dsSoukinyouKouzaInfoDao.getDsSoukinyouKouzasByDskoknoSyono(dsSoukinyouKouzaInfoInputBean.getIwsDskokno(),
                dsSoukinyouKouzaInfoInputBean.getIwsSyono());

        mtDsSoukinyouKouzas = dsSoukinyouKouzaInfoDao.detachDsSoukinyouKouza(mtDsSoukinyouKouzas);

        if (mtDsSoukinyouKouzas.size() == 0) {
            dsSoukinyouKouzaInfoOutputBean.setIwsDsmsgcd(DwMessageCodeConstants.IWSDSMSGCD_015200);
            wsBzWebserviceResParamBean.setGyoumuData(JSON.encode(dsSoukinyouKouzaInfoOutputBean));
            return wsBzWebserviceResParamBean;
        }

        MT_DsSoukinyouKouza mtDsSoukinyouKouza = mtDsSoukinyouKouzas.get(0);

        BzGetBankData bzGetBankData = SWAKInjector.getInstance(BzGetBankData.class);

        String wkBankCd = "";
        String wkSitenCd = "";

        BzGetBankDataBean bzGetBankDataBean = bzGetBankData.
            exec(mtDsSoukinyouKouza.getBankcd(), mtDsSoukinyouKouza.getSitencd());

        if (C_BankmasterUmuKbn.ARI.eq(bzGetBankDataBean.getBankmasterUmuKbn())) {

            if (mtDsSoukinyouKouza.getBankcd().equals("9900")) {
                wkBankCd = bzGetBankDataBean.getBankNmKj();
                wkSitenCd = "";
            } else {
                wkBankCd = bzGetBankDataBean.getBankNmKj();
                wkSitenCd = bzGetBankDataBean.getSitenNmKj();
            }

        } else {

            wkBankCd = DISP_KINNYUUKIKAN_CODE + mtDsSoukinyouKouza.getBankcd();
            wkSitenCd = DISP_SITEN_CODE + mtDsSoukinyouKouza.getSitencd();
        }

        dsSoukinyouKouzaInfoOutputBean.setIwsDsmsgcd(DwMessageCodeConstants.IWSDSMSGCD_015000);
        dsSoukinyouKouzaInfoOutputBean.setIwsBankcd(mtDsSoukinyouKouza.getBankcd());
        dsSoukinyouKouzaInfoOutputBean.setIwsSitencd(mtDsSoukinyouKouza.getSitencd());
        dsSoukinyouKouzaInfoOutputBean.setIwsBanknmkj(wkBankCd);
        dsSoukinyouKouzaInfoOutputBean.setIwsSitennmkj(wkSitenCd);
        dsSoukinyouKouzaInfoOutputBean.setIwsYokinsyumoku(mtDsSoukinyouKouza.getYokinkbn().getValue());
        dsSoukinyouKouzaInfoOutputBean.setIwsKouzano(mtDsSoukinyouKouza.getKouzano());
        dsSoukinyouKouzaInfoOutputBean.setIwsKzdoukbn(mtDsSoukinyouKouza.getKzdoukbn().getValue());
        dsSoukinyouKouzaInfoOutputBean.setIwsKzmeiginmkn(mtDsSoukinyouKouza.getKzmeiginmkn());
        dsSoukinyouKouzaInfoOutputBean.setIwsVersion(String.valueOf(mtDsSoukinyouKouza.getVersion()));

        wsBzWebserviceResParamBean.setGyoumuData(JSON.encode(dsSoukinyouKouzaInfoOutputBean));
        return wsBzWebserviceResParamBean;
    }
}
