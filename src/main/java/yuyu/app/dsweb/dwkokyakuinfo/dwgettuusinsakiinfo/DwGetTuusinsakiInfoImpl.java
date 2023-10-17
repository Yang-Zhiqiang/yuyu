package yuyu.app.dsweb.dwkokyakuinfo.dwgettuusinsakiinfo;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Set;

import javax.inject.Inject;
import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import javax.ws.rs.core.MultivaluedMap;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.util.message.MessageUtil;
import net.arnx.jsonic.JSON;

import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.RayConvertUtil;
import yuyu.common.biz.bzwebserviceaccesslogoutput.WebServiceAccesslogOutput;
import yuyu.common.direct.dscommon.DsDB2Util;
import yuyu.common.dsweb.dwcommon.DwMessageCodeConstants;
import yuyu.def.MessageId;
import yuyu.def.biz.bean.param.WsBzWebserviceReqParamBean;
import yuyu.def.biz.bean.param.WsBzWebserviceResParamBean;
import yuyu.def.classification.C_AccessLogSyubetuKbn;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSya;
import yuyu.def.db.entity.MT_DsKokyakuKanri;
import yuyu.def.db.entity.MT_DsMailAddress;
import yuyu.def.direct.detacher.MT_DsKokyakuKanriDetacher;
import yuyu.def.direct.manager.DirectDomManager;
import yuyu.def.dsweb.bean.webservice.WsDwGetTuusinsakiInfoInputBean;
import yuyu.def.dsweb.bean.webservice.WsDwGetTuusinsakiInfoOutputBean;
import yuyu.def.hozen.detacher.IT_KykKihonDetacher;
import yuyu.def.hozen.manager.HozenDomManager;

/**
 * 顧客通信先情報取得サービスの実装クラスです。<br />
 */
public class DwGetTuusinsakiInfoImpl implements DwGetTuusinsakiInfo {

    @Inject
    private static Logger logger;

    @Inject
    private HozenDomManager hozenDomManager;

    @Inject
    private DirectDomManager directDomManager;

    @Override
    public WsBzWebserviceResParamBean execPostForm(MultivaluedMap<String, String> pMap) {

        logger.info(MessageUtil.getMessage(MessageId.IBF0016, MessageUtil.getMessage(MessageId.INW1006)));

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean;

        try {

            wsBzWebserviceResParamBean = getTuusinsakiInfoMain(pMap);

        } catch (Exception throwable) {
            DsDB2Util dsDB2Util = SWAKInjector.getInstance(DsDB2Util.class);

            DsDB2Util.E_Result result = dsDB2Util.exec(throwable);

            String iwsDsmsgcd = "";

            if (DsDB2Util.E_Result.DEADLOCK.compareTo(result) == 0) {
                iwsDsmsgcd = DwMessageCodeConstants.IWSDSMSGCD_006205;
            }
            else if (DsDB2Util.E_Result.QUERY_TIMEOUT.compareTo(result) == 0) {
                iwsDsmsgcd = DwMessageCodeConstants.IWSDSMSGCD_006204;
            }
            else if (DsDB2Util.E_Result.OTHER.compareTo(result) == 0) {
                throw throwable;
            }

            WsDwGetTuusinsakiInfoOutputBean wsDwGetTuusinsakiInfoOutputBean =
                    SWAKInjector.getInstance(WsDwGetTuusinsakiInfoOutputBean.class);
            wsBzWebserviceResParamBean = SWAKInjector.getInstance(WsBzWebserviceResParamBean.class);
            wsDwGetTuusinsakiInfoOutputBean.setIwsDsmsgcd(iwsDsmsgcd);
            wsBzWebserviceResParamBean.setGyoumuData(JSON.encode(wsDwGetTuusinsakiInfoOutputBean));
        } finally {
            logger.info(MessageUtil.getMessage(MessageId.IBF0017, MessageUtil.getMessage(MessageId.INW1006)));
        }

        return wsBzWebserviceResParamBean;
    }

    @Transactional
    WsBzWebserviceResParamBean getTuusinsakiInfoMain(MultivaluedMap<String, String> pMap) {

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

        WsDwGetTuusinsakiInfoInputBean wsDwGetTuusinsakiInfoInputBean = JSON.decode(gyoumuData, WsDwGetTuusinsakiInfoInputBean.class);

        WebServiceAccesslogOutput webServiceAccesslogOutput =
                SWAKInjector.getInstance(WebServiceAccesslogOutput.class);
        webServiceAccesslogOutput.exec(C_AccessLogSyubetuKbn.ACTION_BEGIN,
                wsBzWebserviceReqParamBean, wsDwGetTuusinsakiInfoInputBean);

        WsDwGetTuusinsakiInfoOutputBean wsDwGetTuusinsakiInfoOutputBean = SWAKInjector.getInstance(WsDwGetTuusinsakiInfoOutputBean.class);
        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = SWAKInjector.getInstance(WsBzWebserviceResParamBean.class);

        boolean chkRet = wsDwGetTuusinsakiInfoInputBean.chkInput();
        if (!chkRet) {
            wsDwGetTuusinsakiInfoOutputBean.setIwsDsmsgcd(DwMessageCodeConstants.IWSDSMSGCD_006100);

            wsBzWebserviceResParamBean.setGyoumuData(JSON.encode(wsDwGetTuusinsakiInfoOutputBean));

            return wsBzWebserviceResParamBean;
        }

        Validator validator = SWAKInjector.getInstance(Validator.class);
        Set<ConstraintViolation<WsDwGetTuusinsakiInfoInputBean>> chkKekkaSet = validator.validate(wsDwGetTuusinsakiInfoInputBean);

        if(chkKekkaSet.size() > 0){
            wsDwGetTuusinsakiInfoOutputBean.setIwsDsmsgcd(DwMessageCodeConstants.IWSDSMSGCD_006100);
            wsBzWebserviceResParamBean.setGyoumuData(JSON.encode(wsDwGetTuusinsakiInfoOutputBean));

            return wsBzWebserviceResParamBean;
        }

        RayConvertUtil.toValidString(wsDwGetTuusinsakiInfoInputBean);

        IT_KykKihon itKykKihon = hozenDomManager.getKykKihon(wsDwGetTuusinsakiInfoInputBean.getIwsSyono());
        IT_KykSya itKykSya = null;
        if (itKykKihon != null) {
            try {
                itKykKihon = IT_KykKihonDetacher.detachKykSyatouched(itKykKihon);
                itKykSya = itKykKihon.getKykSya();
            }
            catch (EntityNotFoundException e) {
            }
        }

        List<MT_DsKokyakuKanri> dsKokyakuKanriList = directDomManager
                .getDsKokyakuKanrisBySyonoDskykmukouhyj(wsDwGetTuusinsakiInfoInputBean.getIwsSyono());

        MT_DsKokyakuKanri dsKokyakuKanri = null;
        MT_DsMailAddress dsMailAddress = null;

        if (dsKokyakuKanriList.size() > 0) {
            dsKokyakuKanriList = MT_DsKokyakuKanriDetacher.detachDsMailAddresstouched(dsKokyakuKanriList);

            dsKokyakuKanri = dsKokyakuKanriList.get(0);

            List<MT_DsMailAddress>  dsMailAddressList = dsKokyakuKanri.getDsMailAddresss();

            if (dsMailAddressList.size() > 0) {
                dsMailAddress = dsMailAddressList.get(0);
            }

        }

        if (itKykKihon == null) {
            wsDwGetTuusinsakiInfoOutputBean.setIwsDsmsgcd(DwMessageCodeConstants.IWSDSMSGCD_006200);
        }
        else if (itKykSya == null) {
            wsDwGetTuusinsakiInfoOutputBean.setIwsDsmsgcd(DwMessageCodeConstants.IWSDSMSGCD_006201);
        }
        else if (dsKokyakuKanri == null) {
            wsDwGetTuusinsakiInfoOutputBean.setIwsDsmsgcd(DwMessageCodeConstants.IWSDSMSGCD_006202);
        }
        else if (dsMailAddress == null) {
            wsDwGetTuusinsakiInfoOutputBean.setIwsDsmsgcd(DwMessageCodeConstants.IWSDSMSGCD_006203);
        }
        else {

            wsDwGetTuusinsakiInfoOutputBean.setIwsDsmsgcd(DwMessageCodeConstants.IWSDSMSGCD_000000);
            wsDwGetTuusinsakiInfoOutputBean.setIwsTsinkokyno(itKykSya.getTsinyno());
            wsDwGetTuusinsakiInfoOutputBean.setIwsTsinadr1kj(itKykSya.getTsinadr1kj());
            wsDwGetTuusinsakiInfoOutputBean.setIwsTsinadr2kj(itKykSya.getTsinadr2kj());
            wsDwGetTuusinsakiInfoOutputBean.setIwsTsinadr3kj(itKykSya.getTsinadr3kj());
            wsDwGetTuusinsakiInfoOutputBean.setIwsTsintelno(itKykSya.getTsintelno());
            wsDwGetTuusinsakiInfoOutputBean.setIwsDai2tsintelno(itKykSya.getDai2tsintelno());
            wsDwGetTuusinsakiInfoOutputBean.setIwsDsmailaddress(dsMailAddress.getDsmailaddress());
            wsDwGetTuusinsakiInfoOutputBean.setIwsDsmailsousintisrykbn(dsMailAddress.getDsmailsousintisrykbn()
                    .getValue());
        }

        wsBzWebserviceResParamBean.setGyoumuData(JSON.encode(wsDwGetTuusinsakiInfoOutputBean));

        return wsBzWebserviceResParamBean;
    }
}
