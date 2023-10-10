package yuyu.app.dsweb.dwhozentetuduki.dwmkhgkhenkouuketuke;

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

import yuyu.app.dsweb.dwhozentetuduki.dwmkhgkhenkouuketuke.dba.DwMkhgkHenkouUketukeDao;
import yuyu.app.dsweb.dwhozentetuduki.dwmkhgkhenkouuketuke.dba.KhHenkouUktkMkhgkHenkouInfoBean;
import yuyu.common.base.BaseUserInfo;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.SaibanBiz;
import yuyu.common.biz.bzwebserviceaccesslogoutput.WebServiceAccesslogOutput;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.common.direct.dscommon.CheckDsMkhgkHenkou;
import yuyu.common.direct.dscommon.DsDB2Util;
import yuyu.common.dsweb.dwcommon.DwMessageCodeConstants;
import yuyu.common.sinkeiyaku.skcommon.ConvertChannelcd;
import yuyu.common.sinkeiyaku.skcommon.SyouhinUtil;
import yuyu.def.MessageId;
import yuyu.def.biz.bean.param.WsBzWebserviceReqParamBean;
import yuyu.def.biz.bean.param.WsBzWebserviceResParamBean;
import yuyu.def.classification.C_AccessLogSyubetuKbn;
import yuyu.def.classification.C_Channelcd;
import yuyu.def.classification.C_CheckDsMkhgkHenkouKekkaKbn;
import yuyu.def.classification.C_DsKinouidKbn;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_KahiKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_TourokuRouteKbn;
import yuyu.def.classification.C_UktkJyoutaiKbn;
import yuyu.def.classification.C_UktkSyoriKbn;
import yuyu.def.db.entity.IT_KhHenkouUktk;
import yuyu.def.db.entity.IT_KhHenkouUktkMkhgkHnk;
import yuyu.def.db.entity.IT_KykDairiten;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSonotaTkyk;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.dsweb.bean.webservice.WsDwMkhgkHenkouUketukeInputBean;
import yuyu.def.dsweb.bean.webservice.WsDwMkhgkHenkouUketukeOutputBean;
import yuyu.def.hozen.manager.HozenDomManager;

/**
 * ＤＳ目標額変更受付サービスの実装クラスです。<br />
 */
public class DwMkhgkHenkouUketukeImpl implements DwMkhgkHenkouUketuke {

    @Inject
    private static Logger logger;

    @Inject
    private DwMkhgkHenkouUketukeDao dwMkhgkHenkouUketukeDao;

    @Inject
    private HozenDomManager hozenDomManager;

    @Inject
    private BaseUserInfo baseUserInfo;

    @Override
    public WsBzWebserviceResParamBean execPostFormInit(MultivaluedMap<String, String> pMap) {

        logger.info(MessageUtil.getMessage(MessageId.IBF0016, MessageUtil.getMessage(MessageId.INW1028)));

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean;

        try {

            wsBzWebserviceResParamBean = init(pMap);

        } catch (Exception throwable) {
            DsDB2Util dsDB2Util = SWAKInjector.getInstance(DsDB2Util.class);

            DsDB2Util.E_Result hanteiKekka = dsDB2Util.exec(throwable);

            String iwsDsmsgcd = "";

            if (DsDB2Util.E_Result.DEADLOCK.compareTo(hanteiKekka) == 0) {
                iwsDsmsgcd = DwMessageCodeConstants.IWSDSMSGCD_021202;
            }
            else if (DsDB2Util.E_Result.QUERY_TIMEOUT.compareTo(hanteiKekka) == 0) {
                iwsDsmsgcd = DwMessageCodeConstants.IWSDSMSGCD_021201;
            }
            else if (DsDB2Util.E_Result.OTHER.compareTo(hanteiKekka) == 0) {
                throw throwable;
            }

            WsDwMkhgkHenkouUketukeOutputBean dwMkhgkHenkouUketukeOutputBean =
                SWAKInjector.getInstance(WsDwMkhgkHenkouUketukeOutputBean.class);
            dwMkhgkHenkouUketukeOutputBean.setIwsDsmsgcd(iwsDsmsgcd);

            wsBzWebserviceResParamBean = SWAKInjector.getInstance(WsBzWebserviceResParamBean.class);

            wsBzWebserviceResParamBean.setGyoumuData(JSON.encode(dwMkhgkHenkouUketukeOutputBean));

        } finally {
            logger.info(MessageUtil.getMessage(MessageId.IBF0017, MessageUtil.getMessage(MessageId.INW1028)));
        }
        return wsBzWebserviceResParamBean;
    }

    @Override
    public WsBzWebserviceResParamBean execPostFormCheckUktk(MultivaluedMap<String, String> pMap) {

        logger.info(MessageUtil.getMessage(MessageId.IBF0016, MessageUtil.getMessage(MessageId.INW1028)));

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean;

        try {

            wsBzWebserviceResParamBean = checkUktk(pMap);

        } catch (Exception throwable) {
            DsDB2Util dsDB2Util = SWAKInjector.getInstance(DsDB2Util.class);

            DsDB2Util.E_Result hanteiKekka = dsDB2Util.exec(throwable);

            String iwsDsmsgcd = "";

            if (DsDB2Util.E_Result.DEADLOCK.compareTo(hanteiKekka) == 0) {
                iwsDsmsgcd = DwMessageCodeConstants.IWSDSMSGCD_021202;
            }
            else if (DsDB2Util.E_Result.QUERY_TIMEOUT.compareTo(hanteiKekka) == 0) {
                iwsDsmsgcd = DwMessageCodeConstants.IWSDSMSGCD_021201;
            }
            else if (DsDB2Util.E_Result.OTHER.compareTo(hanteiKekka) == 0) {
                throw throwable;
            }

            WsDwMkhgkHenkouUketukeOutputBean dwMkhgkHenkouUketukeOutputBean =
                SWAKInjector.getInstance(WsDwMkhgkHenkouUketukeOutputBean.class);
            dwMkhgkHenkouUketukeOutputBean.setIwsDsmsgcd(iwsDsmsgcd);

            wsBzWebserviceResParamBean = SWAKInjector.getInstance(WsBzWebserviceResParamBean.class);
            wsBzWebserviceResParamBean.setGyoumuData(JSON.encode(dwMkhgkHenkouUketukeOutputBean));

        } finally {
            logger.info(MessageUtil.getMessage(MessageId.IBF0017, MessageUtil.getMessage(MessageId.INW1028)));
        }
        return wsBzWebserviceResParamBean;
    }

    @Override
    public WsBzWebserviceResParamBean execPostFormCheckInput(MultivaluedMap<String, String> pMap) {

        logger.info(MessageUtil.getMessage(MessageId.IBF0016, MessageUtil.getMessage(MessageId.INW1028)));

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean;

        try {

            wsBzWebserviceResParamBean = checkInput(pMap);

        } catch (Exception throwable) {
            DsDB2Util dsDB2Util = SWAKInjector.getInstance(DsDB2Util.class);

            DsDB2Util.E_Result hanteiKekka = dsDB2Util.exec(throwable);

            String iwsDsmsgcd = "";

            if (DsDB2Util.E_Result.DEADLOCK.compareTo(hanteiKekka) == 0) {
                iwsDsmsgcd = DwMessageCodeConstants.IWSDSMSGCD_021202;
            }
            else if (DsDB2Util.E_Result.QUERY_TIMEOUT.compareTo(hanteiKekka) == 0) {
                iwsDsmsgcd = DwMessageCodeConstants.IWSDSMSGCD_021201;
            }
            else if (DsDB2Util.E_Result.OTHER.compareTo(hanteiKekka) == 0) {
                throw throwable;
            }

            WsDwMkhgkHenkouUketukeOutputBean dwMkhgkHenkouUketukeOutputBean = SWAKInjector
                .getInstance(WsDwMkhgkHenkouUketukeOutputBean.class);
            dwMkhgkHenkouUketukeOutputBean.setIwsDsmsgcd(iwsDsmsgcd);

            wsBzWebserviceResParamBean = SWAKInjector.getInstance(WsBzWebserviceResParamBean.class);
            wsBzWebserviceResParamBean.setGyoumuData(JSON.encode(dwMkhgkHenkouUketukeOutputBean));

        } finally {
            logger.info(MessageUtil.getMessage(MessageId.IBF0017, MessageUtil.getMessage(MessageId.INW1028)));
        }
        return wsBzWebserviceResParamBean;
    }

    @Override
    public WsBzWebserviceResParamBean execPostFormUpdate(MultivaluedMap<String, String> pMap) {

        logger.info(MessageUtil.getMessage(MessageId.IBF0016, MessageUtil.getMessage(MessageId.INW1028)));

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean;

        try {

            wsBzWebserviceResParamBean = updMkhgkHnkUktData(pMap);

        } catch (Exception throwable) {
            DsDB2Util dsDB2Util = SWAKInjector.getInstance(DsDB2Util.class);

            DsDB2Util.E_Result hanteiKekka = dsDB2Util.exec(throwable);

            String iwsDsmsgcd = "";

            if (DsDB2Util.E_Result.DEADLOCK.compareTo(hanteiKekka) == 0) {
                iwsDsmsgcd = DwMessageCodeConstants.IWSDSMSGCD_021202;
            }
            else if (DsDB2Util.E_Result.QUERY_TIMEOUT.compareTo(hanteiKekka) == 0) {
                iwsDsmsgcd = DwMessageCodeConstants.IWSDSMSGCD_021201;
            }
            else if (DsDB2Util.E_Result.OTHER.compareTo(hanteiKekka) == 0) {
                throw throwable;
            }

            WsDwMkhgkHenkouUketukeOutputBean dwMkhgkHenkouUketukeOutputBean = SWAKInjector
                .getInstance(WsDwMkhgkHenkouUketukeOutputBean.class);
            dwMkhgkHenkouUketukeOutputBean.setIwsDsmsgcd(iwsDsmsgcd);

            wsBzWebserviceResParamBean = SWAKInjector.getInstance(WsBzWebserviceResParamBean.class);
            wsBzWebserviceResParamBean.setGyoumuData(JSON.encode(dwMkhgkHenkouUketukeOutputBean));

        } finally {
            logger.info(MessageUtil.getMessage(MessageId.IBF0017, MessageUtil.getMessage(MessageId.INW1028)));
        }

        return wsBzWebserviceResParamBean;
    }

    @Transactional
    WsBzWebserviceResParamBean init(MultivaluedMap<String, String> pMap) {

        WsBzWebserviceReqParamBean wsBzWebserviceReqParamBean =
            SWAKInjector.getInstance(WsBzWebserviceReqParamBean.class);

        try {
            BeanUtils.populate(wsBzWebserviceReqParamBean, pMap);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);

        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }

        String gyoumuData = wsBzWebserviceReqParamBean.getGyoumuData();

        WsDwMkhgkHenkouUketukeInputBean dwMkhgkHenkouUketukeInputBean =
            JSON.decode(gyoumuData, WsDwMkhgkHenkouUketukeInputBean.class);

        WebServiceAccesslogOutput webServiceAccesslogOutput =
            SWAKInjector.getInstance(WebServiceAccesslogOutput.class);

        webServiceAccesslogOutput.exec(C_AccessLogSyubetuKbn.ACTION_BEGIN,
            wsBzWebserviceReqParamBean,
            dwMkhgkHenkouUketukeInputBean);

        WsDwMkhgkHenkouUketukeOutputBean dwMkhgkHenkouUketukeOutputBean =
            SWAKInjector.getInstance(WsDwMkhgkHenkouUketukeOutputBean.class);

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean =
            SWAKInjector.getInstance(WsBzWebserviceResParamBean.class);

        boolean hissuChkKekka = dwMkhgkHenkouUketukeInputBean.chkHissu();

        if (!hissuChkKekka) {

            dwMkhgkHenkouUketukeOutputBean.setIwsDsmsgcd(DwMessageCodeConstants.IWSDSMSGCD_021100);

            wsBzWebserviceResParamBean.setGyoumuData(JSON.encode(dwMkhgkHenkouUketukeOutputBean));
            return wsBzWebserviceResParamBean;
        }


        Validator validator = SWAKInjector.getInstance(Validator.class);

        Set<ConstraintViolation<WsDwMkhgkHenkouUketukeInputBean>> validatorChkKekkaSet =
            validator.validate(dwMkhgkHenkouUketukeInputBean);

        if (validatorChkKekkaSet.size() > 0) {
            dwMkhgkHenkouUketukeOutputBean.setIwsDsmsgcd(DwMessageCodeConstants.IWSDSMSGCD_021100);

            wsBzWebserviceResParamBean.setGyoumuData(JSON.encode(dwMkhgkHenkouUketukeOutputBean));
            return wsBzWebserviceResParamBean;
        }


        CheckDsMkhgkHenkou checkDsMkhgkHenkou = SWAKInjector.getInstance(CheckDsMkhgkHenkou.class);

        C_ErrorKbn errorKbn = checkDsMkhgkHenkou.chkMkhgkHnkSyoriKahi(dwMkhgkHenkouUketukeInputBean.getIwsSyono());
        C_CheckDsMkhgkHenkouKekkaKbn checkDsMkhgkHenkouKekkaKbn = checkDsMkhgkHenkou.getCheckDsMkhgkHenkouKekkaKbn();
        C_KahiKbn mkhgkHenkoukykKahiKbn = checkDsMkhgkHenkou.getMkhgkHenkoukykKahiKbn();

        if (C_ErrorKbn.ERROR.eq(errorKbn)) {

            if (C_CheckDsMkhgkHenkouKekkaKbn.KADOUZIKANGAI.eq(checkDsMkhgkHenkouKekkaKbn) ||
                C_CheckDsMkhgkHenkouKekkaKbn.TARGETTKYK.eq(checkDsMkhgkHenkouKekkaKbn) ||
                C_CheckDsMkhgkHenkouKekkaKbn.TEIKISHIHARAITKYK.eq(checkDsMkhgkHenkouKekkaKbn) ||
                C_CheckDsMkhgkHenkouKekkaKbn.KEIYAKUYMDMAE.eq(checkDsMkhgkHenkouKekkaKbn) ||
                C_CheckDsMkhgkHenkouKekkaKbn.DSDATAMAINTENANCE.eq(checkDsMkhgkHenkouKekkaKbn) ||
                C_CheckDsMkhgkHenkouKekkaKbn.MFHUSEIGOU.eq(checkDsMkhgkHenkouKekkaKbn)) {

                String msgcd = "";

                if (C_CheckDsMkhgkHenkouKekkaKbn.KADOUZIKANGAI.eq(checkDsMkhgkHenkouKekkaKbn)) {
                    msgcd = DwMessageCodeConstants.IWSDSMSGCD_021300;
                }
                else if (C_CheckDsMkhgkHenkouKekkaKbn.TARGETTKYK.eq(checkDsMkhgkHenkouKekkaKbn) ) {
                    msgcd = DwMessageCodeConstants.IWSDSMSGCD_021301;
                }
                else if (C_CheckDsMkhgkHenkouKekkaKbn.TEIKISHIHARAITKYK.eq(checkDsMkhgkHenkouKekkaKbn)) {
                    msgcd = DwMessageCodeConstants.IWSDSMSGCD_021307;
                }
                else if (C_CheckDsMkhgkHenkouKekkaKbn.KEIYAKUYMDMAE.eq(checkDsMkhgkHenkouKekkaKbn)) {
                    msgcd = DwMessageCodeConstants.IWSDSMSGCD_021303;
                }
                else if (C_CheckDsMkhgkHenkouKekkaKbn.DSDATAMAINTENANCE.eq(checkDsMkhgkHenkouKekkaKbn)) {
                    msgcd = DwMessageCodeConstants.IWSDSMSGCD_021304;
                }
                else if (C_CheckDsMkhgkHenkouKekkaKbn.MFHUSEIGOU.eq(checkDsMkhgkHenkouKekkaKbn)) {
                    msgcd = DwMessageCodeConstants.IWSDSMSGCD_021203;
                }

                dwMkhgkHenkouUketukeOutputBean.setIwsDsmsgcd(msgcd);
                dwMkhgkHenkouUketukeOutputBean.setIwsSyono(dwMkhgkHenkouUketukeInputBean.getIwsSyono());
                dwMkhgkHenkouUketukeOutputBean.setIwsMkhgkhnkkahikbn(mkhgkHenkoukykKahiKbn.getValue());

                wsBzWebserviceResParamBean.setGyoumuData(JSON.encode(dwMkhgkHenkouUketukeOutputBean));
                return wsBzWebserviceResParamBean;
            }

            throw new CommonBizAppException("ＤＳ目標額変更共通チェック結果が想定外の値です。" );
        }

        String iwsTtdktyuumkhgkwari = "";
        String iwsDispttdktyuumkhgkwari = "";
        String iwsDispmkhgkwari = "";

        List<KhHenkouUktkMkhgkHenkouInfoBean> khHnkUktMkhgkHnkInfoBeanLst =
            dwMkhgkHenkouUketukeDao.getKhHenkouUktkMkhgkHenkouInfoBySyono(dwMkhgkHenkouUketukeInputBean.getIwsSyono());

        if (khHnkUktMkhgkHnkInfoBeanLst.size() != 0) {
            KhHenkouUktkMkhgkHenkouInfoBean khHnkUktMkhgkHnkInfoBean = khHnkUktMkhgkHnkInfoBeanLst.get(0);

            String targettkmokuhyouti = String.valueOf(khHnkUktMkhgkHnkInfoBean.getTargettkmokuhyouti());

            iwsTtdktyuumkhgkwari = targettkmokuhyouti;

            if ("999".equals(targettkmokuhyouti)) {
                iwsDispttdktyuumkhgkwari = "（指定なしへ変更お手続き中）";
            }
            else {
                iwsDispttdktyuumkhgkwari = "（" + targettkmokuhyouti + "％へ変更お手続き中）";
            }
        }

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(dwMkhgkHenkouUketukeInputBean.getIwsSyono());
        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        if ("0".equals(String.valueOf(kykSonotaTkyk.getTargettkmokuhyouti()))) {
            iwsDispmkhgkwari = "指定なし";
        }
        else {
            IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU).get(0);
            int syohinHanteiKbn = SyouhinUtil.hantei(kykSyouhn.getSyouhncd());

            if (syohinHanteiKbn == SyouhinUtil.GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR ||
                syohinHanteiKbn == SyouhinUtil.GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR_19) {
                iwsDispmkhgkwari = "基準金額の　" + kykSonotaTkyk.getTargettkmokuhyouti() + "　％";
            }
            else {
                iwsDispmkhgkwari = "円建基準金額の　" + kykSonotaTkyk.getTargettkmokuhyouti() + "　％";
            }
        }

        dwMkhgkHenkouUketukeOutputBean.setIwsDsmsgcd(DwMessageCodeConstants.IWSDSMSGCD_021000);
        dwMkhgkHenkouUketukeOutputBean.setIwsSyono(dwMkhgkHenkouUketukeInputBean.getIwsSyono());
        dwMkhgkHenkouUketukeOutputBean.setIwsMkhgkhnkkahikbn(mkhgkHenkoukykKahiKbn.getValue());
        dwMkhgkHenkouUketukeOutputBean.setIwsTtdktyuumkhgkwari(iwsTtdktyuumkhgkwari);
        dwMkhgkHenkouUketukeOutputBean.setIwsMkhgkwarihnkkanouhani(null);
        dwMkhgkHenkouUketukeOutputBean.setIwsDispmkhgkwari(iwsDispmkhgkwari);
        dwMkhgkHenkouUketukeOutputBean.setIwsDispttdktyuumkhgkwari(iwsDispttdktyuumkhgkwari);

        wsBzWebserviceResParamBean.setGyoumuData(JSON.encode(dwMkhgkHenkouUketukeOutputBean));
        return wsBzWebserviceResParamBean;
    }

    @Transactional
    WsBzWebserviceResParamBean checkUktk(MultivaluedMap<String, String> pMap) {

        WsBzWebserviceReqParamBean wsBzWebserviceReqParamBean =
            SWAKInjector.getInstance(WsBzWebserviceReqParamBean.class);

        try {
            BeanUtils.populate(wsBzWebserviceReqParamBean, pMap);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);

        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }

        String gyoumuData = wsBzWebserviceReqParamBean.getGyoumuData();

        WsDwMkhgkHenkouUketukeInputBean dwMkhgkHenkouUketukeInputBean =
            JSON.decode(gyoumuData, WsDwMkhgkHenkouUketukeInputBean.class);

        WebServiceAccesslogOutput webServiceAccesslogOutput =
            SWAKInjector.getInstance(WebServiceAccesslogOutput.class);

        webServiceAccesslogOutput.exec(C_AccessLogSyubetuKbn.ACTION_BEGIN,
            wsBzWebserviceReqParamBean,
            dwMkhgkHenkouUketukeInputBean);

        WsDwMkhgkHenkouUketukeOutputBean dwMkhgkHenkouUketukeOutputBean =
            SWAKInjector.getInstance(WsDwMkhgkHenkouUketukeOutputBean.class);

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean =
            SWAKInjector.getInstance(WsBzWebserviceResParamBean.class);

        boolean hissuChkKekka = dwMkhgkHenkouUketukeInputBean.chkHissu();

        if (!hissuChkKekka) {

            dwMkhgkHenkouUketukeOutputBean.setIwsDsmsgcd(DwMessageCodeConstants.IWSDSMSGCD_021100);

            wsBzWebserviceResParamBean.setGyoumuData(JSON.encode(dwMkhgkHenkouUketukeOutputBean));
            return wsBzWebserviceResParamBean;
        }


        Validator validator = SWAKInjector.getInstance(Validator.class);

        Set<ConstraintViolation<WsDwMkhgkHenkouUketukeInputBean>> validatorChkKekkaSet =
            validator.validate(dwMkhgkHenkouUketukeInputBean);

        if (validatorChkKekkaSet.size() > 0) {
            dwMkhgkHenkouUketukeOutputBean.setIwsDsmsgcd(DwMessageCodeConstants.IWSDSMSGCD_021100);

            wsBzWebserviceResParamBean.setGyoumuData(JSON.encode(dwMkhgkHenkouUketukeOutputBean));
            return wsBzWebserviceResParamBean;
        }


        CheckDsMkhgkHenkou checkDsMkhgkHenkou = SWAKInjector.getInstance(CheckDsMkhgkHenkou.class);

        C_ErrorKbn errorKbn = checkDsMkhgkHenkou.chkMkhgkHnkUktkNaiyou(dwMkhgkHenkouUketukeInputBean.getIwsSyono());
        C_CheckDsMkhgkHenkouKekkaKbn checkDsMkhgkHenkouKekkaKbn = checkDsMkhgkHenkou.getCheckDsMkhgkHenkouKekkaKbn();
        C_KahiKbn mkhgkHenkoukykKahiKbn = checkDsMkhgkHenkou.getMkhgkHenkoukykKahiKbn();

        if (C_ErrorKbn.ERROR.eq(errorKbn)) {

            if (C_CheckDsMkhgkHenkouKekkaKbn.KADOUZIKANGAI.eq(checkDsMkhgkHenkouKekkaKbn) ||
                C_CheckDsMkhgkHenkouKekkaKbn.TARGETTKYK.eq(checkDsMkhgkHenkouKekkaKbn) ||
                C_CheckDsMkhgkHenkouKekkaKbn.TEIKISHIHARAITKYK.eq(checkDsMkhgkHenkouKekkaKbn) ||
                C_CheckDsMkhgkHenkouKekkaKbn.KEIYAKUYMDMAE.eq(checkDsMkhgkHenkouKekkaKbn) ||
                C_CheckDsMkhgkHenkouKekkaKbn.DSDATAMAINTENANCE.eq(checkDsMkhgkHenkouKekkaKbn) ||
                C_CheckDsMkhgkHenkouKekkaKbn.MKHGKHNKKANOUKIKANGAI.eq(checkDsMkhgkHenkouKekkaKbn) ||
                C_CheckDsMkhgkHenkouKekkaKbn.HOZENYUUKOUJYOUTAI.eq(checkDsMkhgkHenkouKekkaKbn) ||
                C_CheckDsMkhgkHenkouKekkaKbn.TETUDUKITYUUI.eq(checkDsMkhgkHenkouKekkaKbn) ||
                C_CheckDsMkhgkHenkouKekkaKbn.MFHUSEIGOU.eq(checkDsMkhgkHenkouKekkaKbn)) {

                String msgcd = "";

                if (C_CheckDsMkhgkHenkouKekkaKbn.KADOUZIKANGAI.eq(checkDsMkhgkHenkouKekkaKbn)) {
                    msgcd = DwMessageCodeConstants.IWSDSMSGCD_021300;
                }
                else if (C_CheckDsMkhgkHenkouKekkaKbn.TARGETTKYK.eq(checkDsMkhgkHenkouKekkaKbn) ) {
                    msgcd = DwMessageCodeConstants.IWSDSMSGCD_021301;
                }
                else if (C_CheckDsMkhgkHenkouKekkaKbn.TEIKISHIHARAITKYK.eq(checkDsMkhgkHenkouKekkaKbn)) {
                    msgcd = DwMessageCodeConstants.IWSDSMSGCD_021307;
                }
                else if (C_CheckDsMkhgkHenkouKekkaKbn.KEIYAKUYMDMAE.eq(checkDsMkhgkHenkouKekkaKbn)) {
                    msgcd = DwMessageCodeConstants.IWSDSMSGCD_021303;
                }
                else if (C_CheckDsMkhgkHenkouKekkaKbn.DSDATAMAINTENANCE.eq(checkDsMkhgkHenkouKekkaKbn)) {
                    msgcd = DwMessageCodeConstants.IWSDSMSGCD_021304;
                }
                else if (C_CheckDsMkhgkHenkouKekkaKbn.MKHGKHNKKANOUKIKANGAI.eq(checkDsMkhgkHenkouKekkaKbn)) {
                    msgcd = DwMessageCodeConstants.IWSDSMSGCD_021302;
                }
                else if (C_CheckDsMkhgkHenkouKekkaKbn.HOZENYUUKOUJYOUTAI.eq(checkDsMkhgkHenkouKekkaKbn)) {
                    msgcd = DwMessageCodeConstants.IWSDSMSGCD_021305;
                }
                else if (C_CheckDsMkhgkHenkouKekkaKbn.TETUDUKITYUUI.eq(checkDsMkhgkHenkouKekkaKbn)){
                    msgcd = DwMessageCodeConstants.IWSDSMSGCD_021306;
                }
                else if (C_CheckDsMkhgkHenkouKekkaKbn.MFHUSEIGOU.eq(checkDsMkhgkHenkouKekkaKbn)) {
                    msgcd = DwMessageCodeConstants.IWSDSMSGCD_021203;
                }

                dwMkhgkHenkouUketukeOutputBean.setIwsDsmsgcd(msgcd);
                dwMkhgkHenkouUketukeOutputBean.setIwsSyono(dwMkhgkHenkouUketukeInputBean.getIwsSyono());
                dwMkhgkHenkouUketukeOutputBean.setIwsMkhgkhnkkahikbn(mkhgkHenkoukykKahiKbn.getValue());

                wsBzWebserviceResParamBean.setGyoumuData(JSON.encode(dwMkhgkHenkouUketukeOutputBean));
                return wsBzWebserviceResParamBean;
            }

            throw new CommonBizAppException("ＤＳ目標額変更共通チェック結果が想定外の値です。" );
        }


        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(dwMkhgkHenkouUketukeInputBean.getIwsSyono());
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU).get(0);

        IT_KykDairiten kykDairiten = kykKihon.getKykDairitenByDrtenrenno(1);

        ConvertChannelcd convertChannelcd = SWAKInjector.getInstance(ConvertChannelcd.class);
        C_Channelcd kiteiCheckChannelCd = convertChannelcd.exec(null, kykDairiten.getOyadrtencd());

        List<Integer> targettkmokuhyoutiLst =
            dwMkhgkHenkouUketukeDao.getChkTargetTkMokuhyoutisBySyouhncdSyusyouhnsdnoChannelcd(
                kykSyouhn.getSyouhncd(), kykSyouhn.getSyouhnsdno(), kiteiCheckChannelCd);

        if (targettkmokuhyoutiLst.size() == 0) {
            logger.info("ターゲット特約目標値チェックマスタ取得エラー");

            dwMkhgkHenkouUketukeOutputBean.setIwsDsmsgcd(DwMessageCodeConstants.IWSDSMSGCD_021203);

            wsBzWebserviceResParamBean.setGyoumuData(JSON.encode(dwMkhgkHenkouUketukeOutputBean));
            return wsBzWebserviceResParamBean;
        }

        String mkhgkwarihnkkanouhani = editTargettkmokuhyouti(targettkmokuhyoutiLst);

        dwMkhgkHenkouUketukeOutputBean.setIwsDsmsgcd(DwMessageCodeConstants.IWSDSMSGCD_021000);
        dwMkhgkHenkouUketukeOutputBean.setIwsSyono(dwMkhgkHenkouUketukeInputBean.getIwsSyono());
        dwMkhgkHenkouUketukeOutputBean.setIwsMkhgkhnkkahikbn(mkhgkHenkoukykKahiKbn.getValue());
        dwMkhgkHenkouUketukeOutputBean.setIwsMkhgkwarihnkkanouhani(mkhgkwarihnkkanouhani);

        wsBzWebserviceResParamBean.setGyoumuData(JSON.encode(dwMkhgkHenkouUketukeOutputBean));
        return wsBzWebserviceResParamBean;
    }

    @Transactional
    WsBzWebserviceResParamBean checkInput(MultivaluedMap<String, String> pMap) {

        WsBzWebserviceReqParamBean wsBzWebserviceReqParamBean =
            SWAKInjector.getInstance(WsBzWebserviceReqParamBean.class);

        try {
            BeanUtils.populate(wsBzWebserviceReqParamBean, pMap);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);

        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }

        String gyoumuData = wsBzWebserviceReqParamBean.getGyoumuData();

        WsDwMkhgkHenkouUketukeInputBean dwMkhgkHenkouUketukeInputBean =
            JSON.decode(gyoumuData, WsDwMkhgkHenkouUketukeInputBean.class);

        WebServiceAccesslogOutput webServiceAccesslogOutput =
            SWAKInjector.getInstance(WebServiceAccesslogOutput.class);

        webServiceAccesslogOutput.exec(C_AccessLogSyubetuKbn.ACTION_BEGIN,
            wsBzWebserviceReqParamBean,
            dwMkhgkHenkouUketukeInputBean);

        WsDwMkhgkHenkouUketukeOutputBean dwMkhgkHenkouUketukeOutputBean =
            SWAKInjector.getInstance(WsDwMkhgkHenkouUketukeOutputBean.class);

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean =
            SWAKInjector.getInstance(WsBzWebserviceResParamBean.class);

        boolean hissuChkKekka = dwMkhgkHenkouUketukeInputBean.chkHissu();

        if (!hissuChkKekka) {

            dwMkhgkHenkouUketukeOutputBean.setIwsDsmsgcd(DwMessageCodeConstants.IWSDSMSGCD_021100);

            wsBzWebserviceResParamBean.setGyoumuData(JSON.encode(dwMkhgkHenkouUketukeOutputBean));
            return wsBzWebserviceResParamBean;
        }

        hissuChkKekka = dwMkhgkHenkouUketukeInputBean.chkHissuMkhgkwari();

        if (!hissuChkKekka) {

            dwMkhgkHenkouUketukeOutputBean.setIwsDsmsgcd(DwMessageCodeConstants.IWSDSMSGCD_021100);

            wsBzWebserviceResParamBean.setGyoumuData(JSON.encode(dwMkhgkHenkouUketukeOutputBean));
            return wsBzWebserviceResParamBean;
        }


        Validator validator = SWAKInjector.getInstance(Validator.class);

        Set<ConstraintViolation<WsDwMkhgkHenkouUketukeInputBean>> validatorChkKekkaSet =
            validator.validate(dwMkhgkHenkouUketukeInputBean);

        if (validatorChkKekkaSet.size() > 0) {
            dwMkhgkHenkouUketukeOutputBean.setIwsDsmsgcd(DwMessageCodeConstants.IWSDSMSGCD_021100);

            wsBzWebserviceResParamBean.setGyoumuData(JSON.encode(dwMkhgkHenkouUketukeOutputBean));
            return wsBzWebserviceResParamBean;
        }


        CheckDsMkhgkHenkou checkDsMkhgkHenkou = SWAKInjector.getInstance(CheckDsMkhgkHenkou.class);

        C_ErrorKbn errorKbn = checkDsMkhgkHenkou.chkMkhgkHnkInputNaiyou(dwMkhgkHenkouUketukeInputBean.getIwsSyono(),
            Integer.valueOf(dwMkhgkHenkouUketukeInputBean.getIwsHenkougomkhgkwari()));
        C_CheckDsMkhgkHenkouKekkaKbn checkDsMkhgkHenkouKekkaKbn = checkDsMkhgkHenkou.getCheckDsMkhgkHenkouKekkaKbn();
        C_KahiKbn mkhgkHenkoukykKahiKbn = checkDsMkhgkHenkou.getMkhgkHenkoukykKahiKbn();

        if (C_ErrorKbn.ERROR.eq(errorKbn)) {

            if (C_CheckDsMkhgkHenkouKekkaKbn.KADOUZIKANGAI.eq(checkDsMkhgkHenkouKekkaKbn) ||
                C_CheckDsMkhgkHenkouKekkaKbn.MKHGKWARIGENZAIHENKOUNASHI.eq(checkDsMkhgkHenkouKekkaKbn) ||
                C_CheckDsMkhgkHenkouKekkaKbn.MKHGKWARITETUDUKITYUUHENKOUNASHI.eq(checkDsMkhgkHenkouKekkaKbn) ||
                C_CheckDsMkhgkHenkouKekkaKbn.MKHGKWARISEIGOUSEI.eq(checkDsMkhgkHenkouKekkaKbn) ||
                C_CheckDsMkhgkHenkouKekkaKbn.MFHUSEIGOU.eq(checkDsMkhgkHenkouKekkaKbn)) {

                String msgcd = "";

                if (C_CheckDsMkhgkHenkouKekkaKbn.KADOUZIKANGAI.eq(checkDsMkhgkHenkouKekkaKbn)) {
                    msgcd = DwMessageCodeConstants.IWSDSMSGCD_021300;
                }
                else if (C_CheckDsMkhgkHenkouKekkaKbn.MKHGKWARIGENZAIHENKOUNASHI.eq(checkDsMkhgkHenkouKekkaKbn) ) {
                    msgcd = DwMessageCodeConstants.IWSDSMSGCD_021102;
                }
                else if (C_CheckDsMkhgkHenkouKekkaKbn.MKHGKWARITETUDUKITYUUHENKOUNASHI.eq(checkDsMkhgkHenkouKekkaKbn)) {
                    msgcd = DwMessageCodeConstants.IWSDSMSGCD_021103;
                }
                else if (C_CheckDsMkhgkHenkouKekkaKbn.MKHGKWARISEIGOUSEI.eq(checkDsMkhgkHenkouKekkaKbn)) {
                    msgcd = DwMessageCodeConstants.IWSDSMSGCD_021101;
                }
                else if (C_CheckDsMkhgkHenkouKekkaKbn.MFHUSEIGOU.eq(checkDsMkhgkHenkouKekkaKbn)) {
                    msgcd = DwMessageCodeConstants.IWSDSMSGCD_021203;
                }

                dwMkhgkHenkouUketukeOutputBean.setIwsDsmsgcd(msgcd);
                dwMkhgkHenkouUketukeOutputBean.setIwsSyono(dwMkhgkHenkouUketukeInputBean.getIwsSyono());
                dwMkhgkHenkouUketukeOutputBean.setIwsMkhgkhnkkahikbn(mkhgkHenkoukykKahiKbn.getValue());

                wsBzWebserviceResParamBean.setGyoumuData(JSON.encode(dwMkhgkHenkouUketukeOutputBean));
                return wsBzWebserviceResParamBean;
            }

            throw new CommonBizAppException("ＤＳ目標額変更共通チェック結果が想定外の値です。" );
        }

        dwMkhgkHenkouUketukeOutputBean.setIwsDsmsgcd(DwMessageCodeConstants.IWSDSMSGCD_021000);
        dwMkhgkHenkouUketukeOutputBean.setIwsSyono(dwMkhgkHenkouUketukeInputBean.getIwsSyono());
        dwMkhgkHenkouUketukeOutputBean.setIwsMkhgkhnkkahikbn(mkhgkHenkoukykKahiKbn.getValue());

        wsBzWebserviceResParamBean.setGyoumuData(JSON.encode(dwMkhgkHenkouUketukeOutputBean));
        return wsBzWebserviceResParamBean;
    }

    @Transactional
    WsBzWebserviceResParamBean updMkhgkHnkUktData(MultivaluedMap<String, String> pMap) {

        WsBzWebserviceReqParamBean wsBzWebserviceReqParamBean =
            SWAKInjector.getInstance(WsBzWebserviceReqParamBean.class);

        try {
            BeanUtils.populate(wsBzWebserviceReqParamBean, pMap);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);

        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }

        String gyoumuData = wsBzWebserviceReqParamBean.getGyoumuData();

        WsDwMkhgkHenkouUketukeInputBean dwMkhgkHenkouUketukeInputBean =
            JSON.decode(gyoumuData, WsDwMkhgkHenkouUketukeInputBean.class);

        WebServiceAccesslogOutput webServiceAccesslogOutput =
            SWAKInjector.getInstance(WebServiceAccesslogOutput.class);

        webServiceAccesslogOutput.exec(C_AccessLogSyubetuKbn.ACTION_BEGIN,
            wsBzWebserviceReqParamBean,
            dwMkhgkHenkouUketukeInputBean);

        WsDwMkhgkHenkouUketukeOutputBean dwMkhgkHenkouUketukeOutputBean =
            SWAKInjector.getInstance(WsDwMkhgkHenkouUketukeOutputBean.class);

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean =
            SWAKInjector.getInstance(WsBzWebserviceResParamBean.class);

        boolean hissuChkKekka = dwMkhgkHenkouUketukeInputBean.chkHissu();

        if (!hissuChkKekka) {

            dwMkhgkHenkouUketukeOutputBean.setIwsDsmsgcd(DwMessageCodeConstants.IWSDSMSGCD_021100);

            wsBzWebserviceResParamBean.setGyoumuData(JSON.encode(dwMkhgkHenkouUketukeOutputBean));
            return wsBzWebserviceResParamBean;
        }

        hissuChkKekka = dwMkhgkHenkouUketukeInputBean.chkHissuMkhgkwari();

        if (!hissuChkKekka) {

            dwMkhgkHenkouUketukeOutputBean.setIwsDsmsgcd(DwMessageCodeConstants.IWSDSMSGCD_021100);

            wsBzWebserviceResParamBean.setGyoumuData(JSON.encode(dwMkhgkHenkouUketukeOutputBean));
            return wsBzWebserviceResParamBean;
        }


        Validator validator = SWAKInjector.getInstance(Validator.class);

        Set<ConstraintViolation<WsDwMkhgkHenkouUketukeInputBean>> validatorChkKekkaSet =
            validator.validate(dwMkhgkHenkouUketukeInputBean);

        if (validatorChkKekkaSet.size() > 0) {
            dwMkhgkHenkouUketukeOutputBean.setIwsDsmsgcd(DwMessageCodeConstants.IWSDSMSGCD_021100);

            wsBzWebserviceResParamBean.setGyoumuData(JSON.encode(dwMkhgkHenkouUketukeOutputBean));
            return wsBzWebserviceResParamBean;
        }


        CheckDsMkhgkHenkou checkDsMkhgkHenkou = SWAKInjector.getInstance(CheckDsMkhgkHenkou.class);

        C_ErrorKbn errorKbn = checkDsMkhgkHenkou.chkMkhgkHnkUktkDataUpd(dwMkhgkHenkouUketukeInputBean.getIwsSyono(),
            Integer.valueOf(dwMkhgkHenkouUketukeInputBean.getIwsHenkougomkhgkwari()));
        C_CheckDsMkhgkHenkouKekkaKbn checkDsMkhgkHenkouKekkaKbn = checkDsMkhgkHenkou.getCheckDsMkhgkHenkouKekkaKbn();
        C_KahiKbn mkhgkHenkoukykKahiKbn = checkDsMkhgkHenkou.getMkhgkHenkoukykKahiKbn();

        if (C_ErrorKbn.ERROR.eq(errorKbn)) {

            if (C_CheckDsMkhgkHenkouKekkaKbn.KADOUZIKANGAI.eq(checkDsMkhgkHenkouKekkaKbn) ||
                C_CheckDsMkhgkHenkouKekkaKbn.TARGETTKYK.eq(checkDsMkhgkHenkouKekkaKbn) ||
                C_CheckDsMkhgkHenkouKekkaKbn.TEIKISHIHARAITKYK.eq(checkDsMkhgkHenkouKekkaKbn) ||
                C_CheckDsMkhgkHenkouKekkaKbn.KEIYAKUYMDMAE.eq(checkDsMkhgkHenkouKekkaKbn) ||
                C_CheckDsMkhgkHenkouKekkaKbn.DSDATAMAINTENANCE.eq(checkDsMkhgkHenkouKekkaKbn) ||
                C_CheckDsMkhgkHenkouKekkaKbn.MKHGKHNKKANOUKIKANGAI.eq(checkDsMkhgkHenkouKekkaKbn) ||
                C_CheckDsMkhgkHenkouKekkaKbn.HOZENYUUKOUJYOUTAI.eq(checkDsMkhgkHenkouKekkaKbn) ||
                C_CheckDsMkhgkHenkouKekkaKbn.TETUDUKITYUUI.eq(checkDsMkhgkHenkouKekkaKbn) ||
                C_CheckDsMkhgkHenkouKekkaKbn.MKHGKWARISEIGOUSEI.eq(checkDsMkhgkHenkouKekkaKbn) ||
                C_CheckDsMkhgkHenkouKekkaKbn.MFHUSEIGOU.eq(checkDsMkhgkHenkouKekkaKbn)) {

                String msgcd = "";

                if (C_CheckDsMkhgkHenkouKekkaKbn.KADOUZIKANGAI.eq(checkDsMkhgkHenkouKekkaKbn)) {
                    msgcd = DwMessageCodeConstants.IWSDSMSGCD_021300;
                }
                else if (C_CheckDsMkhgkHenkouKekkaKbn.TARGETTKYK.eq(checkDsMkhgkHenkouKekkaKbn)) {
                    msgcd = DwMessageCodeConstants.IWSDSMSGCD_021301;
                }
                else if (C_CheckDsMkhgkHenkouKekkaKbn.TEIKISHIHARAITKYK.eq(checkDsMkhgkHenkouKekkaKbn)) {
                    msgcd = DwMessageCodeConstants.IWSDSMSGCD_021307;
                }
                else if (C_CheckDsMkhgkHenkouKekkaKbn.KEIYAKUYMDMAE.eq(checkDsMkhgkHenkouKekkaKbn)) {
                    msgcd = DwMessageCodeConstants.IWSDSMSGCD_021303;
                }
                else if (C_CheckDsMkhgkHenkouKekkaKbn.DSDATAMAINTENANCE.eq(checkDsMkhgkHenkouKekkaKbn)) {
                    msgcd = DwMessageCodeConstants.IWSDSMSGCD_021304;
                }
                else if (C_CheckDsMkhgkHenkouKekkaKbn.MKHGKHNKKANOUKIKANGAI.eq(checkDsMkhgkHenkouKekkaKbn)) {
                    msgcd = DwMessageCodeConstants.IWSDSMSGCD_021302;
                }
                else if ( C_CheckDsMkhgkHenkouKekkaKbn.HOZENYUUKOUJYOUTAI.eq(checkDsMkhgkHenkouKekkaKbn)) {
                    msgcd = DwMessageCodeConstants.IWSDSMSGCD_021305;
                }
                else if (C_CheckDsMkhgkHenkouKekkaKbn.TETUDUKITYUUI.eq(checkDsMkhgkHenkouKekkaKbn)) {
                    msgcd = DwMessageCodeConstants.IWSDSMSGCD_021306;
                }
                else if ( C_CheckDsMkhgkHenkouKekkaKbn.MKHGKWARISEIGOUSEI.eq(checkDsMkhgkHenkouKekkaKbn)) {
                    msgcd = DwMessageCodeConstants.IWSDSMSGCD_021101;
                }
                else if (C_CheckDsMkhgkHenkouKekkaKbn.MFHUSEIGOU.eq(checkDsMkhgkHenkouKekkaKbn)) {
                    msgcd = DwMessageCodeConstants.IWSDSMSGCD_021203;
                }

                dwMkhgkHenkouUketukeOutputBean.setIwsDsmsgcd(msgcd);
                dwMkhgkHenkouUketukeOutputBean.setIwsSyono(dwMkhgkHenkouUketukeInputBean.getIwsSyono());
                dwMkhgkHenkouUketukeOutputBean.setIwsMkhgkhnkkahikbn(mkhgkHenkoukykKahiKbn.getValue());

                wsBzWebserviceResParamBean.setGyoumuData(JSON.encode(dwMkhgkHenkouUketukeOutputBean));
                return wsBzWebserviceResParamBean;
            }

            throw new CommonBizAppException("ＤＳ目標額変更共通チェック結果が想定外の値です。" );
        }

        BizDate sysDate = BizDate.getSysDate();
        String sysDateTime = BizDate.getSysDateTimeMilli();

        List<KhHenkouUktkMkhgkHenkouInfoBean> khHnkUktMkhgkHnkInfoBeanLst =
            dwMkhgkHenkouUketukeDao.getKhHenkouUktkMkhgkHenkouInfoBySyono(dwMkhgkHenkouUketukeInputBean.getIwsSyono());

        if (khHnkUktMkhgkHnkInfoBeanLst.size() != 0) {
            KhHenkouUktkMkhgkHenkouInfoBean khHnkUktMkhgkHnkInfoBean = khHnkUktMkhgkHnkInfoBeanLst.get(0);

            Integer hozenhenkouuktkrenno = khHnkUktMkhgkHnkInfoBean.getHozenhenkouuktkrenno();

            IT_KhHenkouUktk khHenkouUktkUpd = hozenDomManager.getKhHenkouUktk(
                dwMkhgkHenkouUketukeInputBean.getIwsSyono(), hozenhenkouuktkrenno);

            khHenkouUktkUpd.setUktkjyoutaikbn(C_UktkJyoutaiKbn.TORIKESI);
            khHenkouUktkUpd.setGyoumuKousinKinou(C_DsKinouidKbn.MKHGKHENKOUUKETUKE.getValue());
            khHenkouUktkUpd.setGyoumuKousinsyaId(baseUserInfo.getUser().getUserId());
            khHenkouUktkUpd.setGyoumuKousinTime(sysDateTime);

            try {
                hozenDomManager.update(khHenkouUktkUpd);
            } catch (Exception e) {
                dwMkhgkHenkouUketukeOutputBean.setIwsDsmsgcd(DwMessageCodeConstants.IWSDSMSGCD_021200);
                dwMkhgkHenkouUketukeOutputBean.setIwsSyono(dwMkhgkHenkouUketukeInputBean.getIwsSyono());
                dwMkhgkHenkouUketukeOutputBean.setIwsMkhgkhnkkahikbn(mkhgkHenkoukykKahiKbn.getValue());

                wsBzWebserviceResParamBean.setGyoumuData(JSON.encode(dwMkhgkHenkouUketukeOutputBean));
                return wsBzWebserviceResParamBean;
            }
        }

        String hozenHenkouUktkrenNo = SaibanBiz.getHozenHenkouUktkrenNo(dwMkhgkHenkouUketukeInputBean.getIwsSyono());

        IT_KhHenkouUktk khHenkouUktkIns = new IT_KhHenkouUktk(
            dwMkhgkHenkouUketukeInputBean.getIwsSyono(), Integer.valueOf(hozenHenkouUktkrenNo));

        khHenkouUktkIns.setUktkymd(sysDate);
        khHenkouUktkIns.setTourokuroute(C_TourokuRouteKbn.DS);
        khHenkouUktkIns.setUktksyorikbn(C_UktkSyoriKbn.MKHGKHNK);
        khHenkouUktkIns.setKouryokuhasseiymd(sysDate);
        khHenkouUktkIns.setSyoriyoteiymd(sysDate);
        khHenkouUktkIns.setUktkjyoutaikbn(C_UktkJyoutaiKbn.MISYORI);
        khHenkouUktkIns.setGyoumuKousinKinou(C_DsKinouidKbn.MKHGKHENKOUUKETUKE.getValue());
        khHenkouUktkIns.setGyoumuKousinsyaId(baseUserInfo.getUser().getUserId());
        khHenkouUktkIns.setGyoumuKousinTime(sysDateTime);

        BizPropertyInitializer.initialize(khHenkouUktkIns);

        IT_KhHenkouUktkMkhgkHnk khHenkouUktkMkhgkHnk = khHenkouUktkIns.createKhHenkouUktkMkhgkHnk();

        khHenkouUktkMkhgkHnk.setTargettkmokuhyouti(
            Integer.valueOf(dwMkhgkHenkouUketukeInputBean.getIwsHenkougomkhgkwari()));
        khHenkouUktkMkhgkHnk.setGyoumuKousinKinou(C_DsKinouidKbn.MKHGKHENKOUUKETUKE.getValue());
        khHenkouUktkMkhgkHnk.setGyoumuKousinsyaId(baseUserInfo.getUser().getUserId());
        khHenkouUktkMkhgkHnk.setGyoumuKousinTime(sysDateTime);

        BizPropertyInitializer.initialize(khHenkouUktkMkhgkHnk);

        try {
            hozenDomManager.insert(khHenkouUktkIns);
        } catch (Exception e) {
            dwMkhgkHenkouUketukeOutputBean.setIwsDsmsgcd(DwMessageCodeConstants.IWSDSMSGCD_021200);
            dwMkhgkHenkouUketukeOutputBean.setIwsSyono(dwMkhgkHenkouUketukeInputBean.getIwsSyono());
            dwMkhgkHenkouUketukeOutputBean.setIwsMkhgkhnkkahikbn(mkhgkHenkoukykKahiKbn.getValue());

            wsBzWebserviceResParamBean.setGyoumuData(JSON.encode(dwMkhgkHenkouUketukeOutputBean));
            return wsBzWebserviceResParamBean;
        }

        dwMkhgkHenkouUketukeOutputBean.setIwsDsmsgcd(DwMessageCodeConstants.IWSDSMSGCD_021000);
        dwMkhgkHenkouUketukeOutputBean.setIwsSyono(dwMkhgkHenkouUketukeInputBean.getIwsSyono());
        dwMkhgkHenkouUketukeOutputBean.setIwsMkhgkhnkkahikbn(mkhgkHenkoukykKahiKbn.getValue());

        wsBzWebserviceResParamBean.setGyoumuData(JSON.encode(dwMkhgkHenkouUketukeOutputBean));
        return wsBzWebserviceResParamBean;
    }

    private String editTargettkmokuhyouti(List<Integer> pTargettkmokuhyoutiLst) {

        String str = "";
        boolean haifun = false;

        for (int targettkmokuhyouti : pTargettkmokuhyoutiLst) {

            if (!haifun) {
                str = String.valueOf(targettkmokuhyouti);
                haifun = true;
            }
            else {
                str = str + "-" + String.valueOf(targettkmokuhyouti);
            }
        }

        return str;
    }
}
