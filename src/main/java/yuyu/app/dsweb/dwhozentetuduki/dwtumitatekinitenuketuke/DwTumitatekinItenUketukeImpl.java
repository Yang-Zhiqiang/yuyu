package yuyu.app.dsweb.dwhozentetuduki.dwtumitatekinitenuketuke;

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
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.SaibanBiz;
import yuyu.common.biz.bzwebserviceaccesslogoutput.WebServiceAccesslogOutput;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.common.direct.dscommon.DsDB2Util;
import yuyu.common.direct.dscommon.DsTumitatekinItenCheck;
import yuyu.common.direct.dscommon.DsTumitatekinItenCheckResultBean;
import yuyu.common.dsweb.dwcommon.DwMessageCodeConstants;
import yuyu.def.MessageId;
import yuyu.def.biz.bean.param.WsBzWebserviceReqParamBean;
import yuyu.def.biz.bean.param.WsBzWebserviceResParamBean;
import yuyu.def.classification.C_AccessLogSyubetuKbn;
import yuyu.def.classification.C_DsKinouidKbn;
import yuyu.def.classification.C_DsTmttknitenchkkekkaKbn;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_TourokuRouteKbn;
import yuyu.def.classification.C_UktkJyoutaiKbn;
import yuyu.def.classification.C_UktkSyoriKbn;
import yuyu.def.db.entity.IT_KhHenkouUktk;
import yuyu.def.db.entity.MT_KhHenkouUktkYyk;
import yuyu.def.direct.manager.DirectDomManager;
import yuyu.def.dsweb.bean.webservice.WsDwTumitatekinItenUketukeInputBean;
import yuyu.def.dsweb.bean.webservice.WsDwTumitatekinItenUketukeOutputBean;
import yuyu.def.dsweb.configuration.YuyuDswebConfig;

/**
 * ＤＳ積立金移転受付サービスの実装クラスです。<br />
 */
public class DwTumitatekinItenUketukeImpl implements DwTumitatekinItenUketuke {

    @Inject
    private static Logger logger;

    @Inject
    private DirectDomManager directDomManager;

    @Inject
    private BaseUserInfo baseUserInfo;

    @Override
    public WsBzWebserviceResParamBean execPostFormPrepare(MultivaluedMap<String, String> pMap) {

        logger.info(MessageUtil.getMessage(MessageId.IBF0016, MessageUtil.getMessage(MessageId.INW1015)));

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean;

        try {
            wsBzWebserviceResParamBean = execPrepare(pMap);
        } catch (Exception throwable) {

            DsDB2Util dsDB2Util = SWAKInjector.getInstance(DsDB2Util.class);
            DsDB2Util.E_Result hanteiKekka = dsDB2Util.exec(throwable);
            String iwsDsmsgcd = "";

            if (DsDB2Util.E_Result.DEADLOCK.compareTo(hanteiKekka) == 0) {
                iwsDsmsgcd = DwMessageCodeConstants.IWSDSMSGCD_012203;
            }
            else if (DsDB2Util.E_Result.QUERY_TIMEOUT.compareTo(hanteiKekka) == 0) {
                iwsDsmsgcd = DwMessageCodeConstants.IWSDSMSGCD_012202;
            }
            else if (DsDB2Util.E_Result.OTHER.compareTo(hanteiKekka) == 0) {
                throw throwable;
            }

            WsDwTumitatekinItenUketukeOutputBean wsDwTumitatekinItenUketukeOutputBean =
                SWAKInjector.getInstance(WsDwTumitatekinItenUketukeOutputBean.class);
            wsDwTumitatekinItenUketukeOutputBean.setIwsDsmsgcd(iwsDsmsgcd);
            wsBzWebserviceResParamBean = SWAKInjector.getInstance(WsBzWebserviceResParamBean.class);
            wsBzWebserviceResParamBean.setGyoumuData(JSON.encode(wsDwTumitatekinItenUketukeOutputBean));
        } finally {
            logger.info(MessageUtil.getMessage(MessageId.IBF0017, MessageUtil.getMessage(MessageId.INW1015)));
        }

        return wsBzWebserviceResParamBean;
    }

    @Override
    public WsBzWebserviceResParamBean execPostFormUpdate(MultivaluedMap<String, String> pMap) {

        logger.info(MessageUtil.getMessage(MessageId.IBF0016, MessageUtil.getMessage(MessageId.INW1015)));

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean;
        try {
            wsBzWebserviceResParamBean = updateTmttknitenuktk(pMap);
        } catch (Exception throwable) {
            DsDB2Util dsDB2Util = SWAKInjector.getInstance(DsDB2Util.class);
            DsDB2Util.E_Result hanteiKekka = dsDB2Util.exec(throwable);
            String iwsDsmsgcd = "";

            if (DsDB2Util.E_Result.DEADLOCK.compareTo(hanteiKekka) == 0) {
                iwsDsmsgcd = DwMessageCodeConstants.IWSDSMSGCD_012203;
            }
            else if (DsDB2Util.E_Result.QUERY_TIMEOUT.compareTo(hanteiKekka) == 0) {
                iwsDsmsgcd = DwMessageCodeConstants.IWSDSMSGCD_012202;
            }
            else if (DsDB2Util.E_Result.OTHER.compareTo(hanteiKekka) == 0) {
                throw throwable;
            }

            WsDwTumitatekinItenUketukeOutputBean wsDwTumitatekinItenUketukeOutputBean =
                SWAKInjector.getInstance(WsDwTumitatekinItenUketukeOutputBean.class);
            wsDwTumitatekinItenUketukeOutputBean.setIwsDsmsgcd(iwsDsmsgcd);
            wsBzWebserviceResParamBean = SWAKInjector.getInstance(WsBzWebserviceResParamBean.class);
            wsBzWebserviceResParamBean.setGyoumuData(JSON.encode(wsDwTumitatekinItenUketukeOutputBean));
        } finally {
            logger.info(MessageUtil.getMessage(MessageId.IBF0017, MessageUtil.getMessage(MessageId.INW1015)));
        }

        return wsBzWebserviceResParamBean;
    }

    @Override
    public WsBzWebserviceResParamBean execPostFormKadouhantei(MultivaluedMap<String, String> pMap) {

        logger.info(MessageUtil.getMessage(MessageId.IBF0016, MessageUtil.getMessage(MessageId.INW1015)));

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = tmttknitenHanteiSyori(pMap);

        logger.info(MessageUtil.getMessage(MessageId.IBF0017, MessageUtil.getMessage(MessageId.INW1015)));

        return wsBzWebserviceResParamBean;
    }

    @Transactional
    private WsBzWebserviceResParamBean execPrepare(MultivaluedMap<String, String> pMap) {

        WsBzWebserviceReqParamBean wsBzWebserviceReqParamBean = SWAKInjector.getInstance(WsBzWebserviceReqParamBean.class);

        try {
            BeanUtils.populate(wsBzWebserviceReqParamBean, pMap);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }

        String gyoumuData = wsBzWebserviceReqParamBean.getGyoumuData();
        WsDwTumitatekinItenUketukeInputBean wsDwTumitatekinItenUketukeInputBean = JSON.decode(gyoumuData,
            WsDwTumitatekinItenUketukeInputBean.class);
        WebServiceAccesslogOutput webServiceAccesslogOutput = SWAKInjector.getInstance(WebServiceAccesslogOutput.class);
        webServiceAccesslogOutput.exec(C_AccessLogSyubetuKbn.ACTION_BEGIN,
            wsBzWebserviceReqParamBean,
            wsDwTumitatekinItenUketukeInputBean);

        WsDwTumitatekinItenUketukeOutputBean wsDwTumitatekinItenUketukeOutputBean =
            SWAKInjector.getInstance(WsDwTumitatekinItenUketukeOutputBean.class);

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean =
            SWAKInjector.getInstance(WsBzWebserviceResParamBean.class);

        boolean chkHissuKekka = wsDwTumitatekinItenUketukeInputBean.chkHissuInput();

        if (!chkHissuKekka) {
            wsDwTumitatekinItenUketukeOutputBean.setIwsDsmsgcd(DwMessageCodeConstants.IWSDSMSGCD_012100);
            wsBzWebserviceResParamBean.setGyoumuData(JSON.encode(wsDwTumitatekinItenUketukeOutputBean));

            return wsBzWebserviceResParamBean;
        }

        Validator validator = SWAKInjector.getInstance(Validator.class);

        Set<ConstraintViolation<WsDwTumitatekinItenUketukeInputBean>> validatorChkKekkaSet =
            validator.validate(wsDwTumitatekinItenUketukeInputBean);

        if (validatorChkKekkaSet.size() > 0) {
            wsDwTumitatekinItenUketukeOutputBean.setIwsDsmsgcd(DwMessageCodeConstants.IWSDSMSGCD_012100);
            wsBzWebserviceResParamBean.setGyoumuData(JSON.encode(wsDwTumitatekinItenUketukeOutputBean));

            return wsBzWebserviceResParamBean;
        }

        DsTumitatekinItenCheck dsTumitatekinItenCheck = SWAKInjector.getInstance(DsTumitatekinItenCheck.class);
        DsTumitatekinItenCheckResultBean dsTumitatekinItenCheckResultBean = dsTumitatekinItenCheck.checkTumitatekinIten(
            wsDwTumitatekinItenUketukeInputBean.getIwsSyono(),
            BizDate.getSysDate(),
            BizDate.valueOf(wsDwTumitatekinItenUketukeInputBean.getIwsTumitatekinitenyoteibi()));

        if (C_ErrorKbn.ERROR.eq(dsTumitatekinItenCheckResultBean.getErrorKbn())) {

            String iwsDsmsgcd = hanteiDsTumitatekinItenUketukeKahi(dsTumitatekinItenCheckResultBean.getErrorKbn(),
                dsTumitatekinItenCheckResultBean.getDsTmttknitenchkkekkaKbn());
            wsDwTumitatekinItenUketukeOutputBean.setIwsDsmsgcd(iwsDsmsgcd);
            wsBzWebserviceResParamBean.setGyoumuData(JSON.encode(wsDwTumitatekinItenUketukeOutputBean));

            return wsBzWebserviceResParamBean;
        }

        wsDwTumitatekinItenUketukeOutputBean.setIwsDsmsgcd(DwMessageCodeConstants.IWSDSMSGCD_012000);
        wsBzWebserviceResParamBean.setGyoumuData(JSON.encode(wsDwTumitatekinItenUketukeOutputBean));

        return wsBzWebserviceResParamBean;
    }

    @Transactional
    WsBzWebserviceResParamBean updateTmttknitenuktk(MultivaluedMap<String, String> pMap) {

        WsBzWebserviceReqParamBean wsBzWebserviceReqParamBean = SWAKInjector.getInstance(WsBzWebserviceReqParamBean.class);

        try {
            BeanUtils.populate(wsBzWebserviceReqParamBean, pMap);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }

        String gyoumuData = wsBzWebserviceReqParamBean.getGyoumuData();
        WsDwTumitatekinItenUketukeInputBean wsDwTumitatekinItenUketukeInputBean =
            JSON.decode(gyoumuData, WsDwTumitatekinItenUketukeInputBean.class);
        WebServiceAccesslogOutput webServiceAccesslogOutput =
            SWAKInjector.getInstance(WebServiceAccesslogOutput.class);
        webServiceAccesslogOutput.exec(C_AccessLogSyubetuKbn.ACTION_BEGIN,
            wsBzWebserviceReqParamBean,
            wsDwTumitatekinItenUketukeInputBean);

        WsDwTumitatekinItenUketukeOutputBean wsDwTumitatekinItenUketukeOutputBean =
            SWAKInjector.getInstance(WsDwTumitatekinItenUketukeOutputBean.class);

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean =
            SWAKInjector.getInstance(WsBzWebserviceResParamBean.class);

        boolean chkHissuKekka = wsDwTumitatekinItenUketukeInputBean.chkHissuInput();

        if (!chkHissuKekka) {
            wsDwTumitatekinItenUketukeOutputBean.setIwsDsmsgcd(DwMessageCodeConstants.IWSDSMSGCD_012100);
            wsBzWebserviceResParamBean.setGyoumuData(JSON.encode(wsDwTumitatekinItenUketukeOutputBean));

            return wsBzWebserviceResParamBean;
        }

        Validator validator = SWAKInjector.getInstance(Validator.class);
        Set<ConstraintViolation<WsDwTumitatekinItenUketukeInputBean>> validatorChkKekkaSet =
            validator.validate(wsDwTumitatekinItenUketukeInputBean);
        if (validatorChkKekkaSet.size() > 0) {
            wsDwTumitatekinItenUketukeOutputBean.setIwsDsmsgcd(DwMessageCodeConstants.IWSDSMSGCD_012100);
            wsBzWebserviceResParamBean.setGyoumuData(JSON.encode(wsDwTumitatekinItenUketukeOutputBean));

            return wsBzWebserviceResParamBean;
        }

        DsTumitatekinItenCheck dsTumitatekinItenCheck = SWAKInjector.getInstance(DsTumitatekinItenCheck.class);
        DsTumitatekinItenCheckResultBean dsTumitatekinItenCheckResultBean = dsTumitatekinItenCheck.checkTumitatekinIten(
            wsDwTumitatekinItenUketukeInputBean.getIwsSyono(),
            BizDate.getSysDate(),
            BizDate.valueOf(wsDwTumitatekinItenUketukeInputBean.getIwsTumitatekinitenyoteibi()));

        if (C_ErrorKbn.ERROR.eq(dsTumitatekinItenCheckResultBean.getErrorKbn())) {

            String iwsDsmsgcd = hanteiDsTumitatekinItenUketukeKahi(dsTumitatekinItenCheckResultBean.getErrorKbn(),
                dsTumitatekinItenCheckResultBean.getDsTmttknitenchkkekkaKbn());
            wsDwTumitatekinItenUketukeOutputBean.setIwsDsmsgcd(iwsDsmsgcd);
            wsBzWebserviceResParamBean.setGyoumuData(JSON.encode(wsDwTumitatekinItenUketukeOutputBean));

            return wsBzWebserviceResParamBean;
        }

        String hozenHenkouUktkrenNo = SaibanBiz.getHozenHenkouUktkrenNo(wsDwTumitatekinItenUketukeInputBean.getIwsSyono());
        BizDate sysDate = BizDate.getSysDate();
        String sysDateTime = BizDate.getSysDateTimeMilli();
        String kinouId = C_DsKinouidKbn.DSTUMITATEKINITENUKETUKE.getValue();
        if (Integer.parseInt(sysDateTime.substring(8, sysDateTime.length())) <
            Integer.parseInt(YuyuDswebConfig.getInstance().getYakanJobKadouKaisiTime())) {

            IT_KhHenkouUktk itKhHenkouUktk = new IT_KhHenkouUktk(wsDwTumitatekinItenUketukeInputBean.getIwsSyono(),
                Integer.valueOf(hozenHenkouUktkrenNo));

            itKhHenkouUktk.setUktkymd(sysDate);
            itKhHenkouUktk.setTourokuroute(C_TourokuRouteKbn.DS);
            itKhHenkouUktk.setUktksyorikbn(C_UktkSyoriKbn.TMTTKNITEN);
            itKhHenkouUktk.setKouryokuhasseiymd(BizDate.valueOf(wsDwTumitatekinItenUketukeInputBean.getIwsTumitatekinitenyoteibi()));
            itKhHenkouUktk.setSyoriyoteiymd(BizDate.valueOf(
                wsDwTumitatekinItenUketukeInputBean.getIwsTumitatekinitenyoteibi()).addBusinessDays(-1));
            itKhHenkouUktk.setUktkjyoutaikbn(C_UktkJyoutaiKbn.MISYORI);
            itKhHenkouUktk.setGyoumuKousinKinou(kinouId);
            itKhHenkouUktk.setGyoumuKousinsyaId(baseUserInfo.getUserId());
            itKhHenkouUktk.setGyoumuKousinTime(sysDateTime);

            BizPropertyInitializer.initialize(itKhHenkouUktk);

            try {
                directDomManager.insert(itKhHenkouUktk);
            } catch (Exception e) {
                wsDwTumitatekinItenUketukeOutputBean.setIwsDsmsgcd(DwMessageCodeConstants.IWSDSMSGCD_012200);
                wsBzWebserviceResParamBean.setGyoumuData(JSON.encode(wsDwTumitatekinItenUketukeOutputBean));

                return wsBzWebserviceResParamBean;
            }
        }
        else {
            MT_KhHenkouUktkYyk mtKhHenkouUktkYyk = new MT_KhHenkouUktkYyk(
                wsDwTumitatekinItenUketukeInputBean.getIwsSyono(),Integer.valueOf(hozenHenkouUktkrenNo));

            mtKhHenkouUktkYyk.setUktkymd(sysDate);
            mtKhHenkouUktkYyk.setTourokuroute(C_TourokuRouteKbn.DS);
            mtKhHenkouUktkYyk.setUktksyorikbn(C_UktkSyoriKbn.TMTTKNITEN);
            mtKhHenkouUktkYyk.setKouryokuhasseiymd(BizDate.valueOf(wsDwTumitatekinItenUketukeInputBean.getIwsTumitatekinitenyoteibi()));
            mtKhHenkouUktkYyk.setSyoriyoteiymd(BizDate.valueOf(
                wsDwTumitatekinItenUketukeInputBean.getIwsTumitatekinitenyoteibi()).addBusinessDays(-1));
            mtKhHenkouUktkYyk.setUktkjyoutaikbn(C_UktkJyoutaiKbn.MISYORI);
            mtKhHenkouUktkYyk.setGyoumuKousinKinou(kinouId);
            mtKhHenkouUktkYyk.setGyoumuKousinsyaId(baseUserInfo.getUserId());
            mtKhHenkouUktkYyk.setGyoumuKousinTime(sysDateTime);

            BizPropertyInitializer.initialize(mtKhHenkouUktkYyk);

            try {
                directDomManager.insert(mtKhHenkouUktkYyk);
            } catch (Exception e) {
                wsDwTumitatekinItenUketukeOutputBean.setIwsDsmsgcd(DwMessageCodeConstants.IWSDSMSGCD_012201);
                wsBzWebserviceResParamBean.setGyoumuData(JSON.encode(wsDwTumitatekinItenUketukeOutputBean));

                return wsBzWebserviceResParamBean;
            }
        }

        wsDwTumitatekinItenUketukeOutputBean.setIwsDsmsgcd(DwMessageCodeConstants.IWSDSMSGCD_012000);
        wsBzWebserviceResParamBean.setGyoumuData(JSON.encode(wsDwTumitatekinItenUketukeOutputBean));

        return wsBzWebserviceResParamBean;
    }

    @Transactional
    WsBzWebserviceResParamBean tmttknitenHanteiSyori(MultivaluedMap<String, String> pMap) {

        WsBzWebserviceReqParamBean wsBzWebserviceReqParamBean = SWAKInjector.getInstance(WsBzWebserviceReqParamBean.class);

        try {
            BeanUtils.populate(wsBzWebserviceReqParamBean, pMap);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }

        String gyoumuData = wsBzWebserviceReqParamBean.getGyoumuData();
        WsDwTumitatekinItenUketukeInputBean wsDwTumitatekinItenUketukeInputBean =
            JSON.decode(gyoumuData, WsDwTumitatekinItenUketukeInputBean.class);
        WebServiceAccesslogOutput webServiceAccesslogOutput =
            SWAKInjector.getInstance(WebServiceAccesslogOutput.class);
        webServiceAccesslogOutput.exec(C_AccessLogSyubetuKbn.ACTION_BEGIN,
            wsBzWebserviceReqParamBean,
            wsDwTumitatekinItenUketukeInputBean);

        WsDwTumitatekinItenUketukeOutputBean wsDwTumitatekinItenUketukeOutputBean =
            SWAKInjector.getInstance(WsDwTumitatekinItenUketukeOutputBean.class);

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean =
            SWAKInjector.getInstance(WsBzWebserviceResParamBean.class);

        BizDate sysDate = BizDate.getSysDate();
        if (sysDate.isHoliday()) {
            wsDwTumitatekinItenUketukeOutputBean.setIwsDsmsgcd(DwMessageCodeConstants.IWSDSMSGCD_012300);
            wsBzWebserviceResParamBean.setGyoumuData(JSON.encode(wsDwTumitatekinItenUketukeOutputBean));

            return wsBzWebserviceResParamBean;
        }

        wsDwTumitatekinItenUketukeOutputBean.setIwsDsmsgcd(DwMessageCodeConstants.IWSDSMSGCD_012000);
        wsBzWebserviceResParamBean.setGyoumuData(JSON.encode(wsDwTumitatekinItenUketukeOutputBean));

        return wsBzWebserviceResParamBean;
    }

    private String hanteiDsTumitatekinItenUketukeKahi(C_ErrorKbn pErrorKbn, C_DsTmttknitenchkkekkaKbn pDsTmttknitenchkkekkaKbn) {

        String iwsDsmsgcd = "";
        if (C_ErrorKbn.ERROR.eq(pErrorKbn)) {

            if (C_DsTmttknitenchkkekkaKbn.TRATKITISYSYOUHN.eq(pDsTmttknitenchkkekkaKbn)) {
                iwsDsmsgcd = DwMessageCodeConstants.IWSDSMSGCD_012302;
            }
            else if (C_DsTmttknitenchkkekkaKbn.TEIRITUTUMITATE.eq(pDsTmttknitenchkkekkaKbn)) {
                iwsDsmsgcd = DwMessageCodeConstants.IWSDSMSGCD_012304;
            }
            else if (C_DsTmttknitenchkkekkaKbn.KYKYMDMITOURAI.eq(pDsTmttknitenchkkekkaKbn)) {
                iwsDsmsgcd = DwMessageCodeConstants.IWSDSMSGCD_012301;
            }
            else if (C_DsTmttknitenchkkekkaKbn.SAISYUUHOKENNENDO.eq(pDsTmttknitenchkkekkaKbn)) {
                iwsDsmsgcd = DwMessageCodeConstants.IWSDSMSGCD_012305;
            }
            else if (C_DsTmttknitenchkkekkaKbn.UKTKKKN.eq(pDsTmttknitenchkkekkaKbn)) {
                iwsDsmsgcd = DwMessageCodeConstants.IWSDSMSGCD_012303;
            }
            else if (C_DsTmttknitenchkkekkaKbn.TMTTKNITENUKTKUMU.eq(pDsTmttknitenchkkekkaKbn)) {
                iwsDsmsgcd = DwMessageCodeConstants.IWSDSMSGCD_012306;
            }
            else if (C_DsTmttknitenchkkekkaKbn.HOZENJYOUTAI.eq(pDsTmttknitenchkkekkaKbn)) {
                iwsDsmsgcd = DwMessageCodeConstants.IWSDSMSGCD_012307;
            }
            else if (C_DsTmttknitenchkkekkaKbn.TETUDUKITYUUI.eq(pDsTmttknitenchkkekkaKbn)) {
                iwsDsmsgcd = DwMessageCodeConstants.IWSDSMSGCD_012308;
            }
            else {
                throw new CommonBizAppException("ＤＳ積立金移転共通チェック結果が想定外の値です。");
            }
        }

        return iwsDsmsgcd;
    }

}
