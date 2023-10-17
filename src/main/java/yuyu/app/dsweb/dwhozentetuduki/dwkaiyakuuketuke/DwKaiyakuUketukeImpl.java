package yuyu.app.dsweb.dwhozentetuduki.dwkaiyakuuketuke;

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
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.util.message.MessageUtil;
import net.arnx.jsonic.JSON;

import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;

import yuyu.app.dsweb.dwhozentetuduki.dwkaiyakuuketuke.dba.DwKaiyakuUketukeDao;
import yuyu.common.base.BaseUserInfo;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.GetKawaseRate;
import yuyu.common.biz.bzcommon.SaibanBiz;
import yuyu.common.biz.bzwebserviceaccesslogoutput.WebServiceAccesslogOutput;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.common.hozen.khcommon.KeisanCommonKaiyaku;
import yuyu.common.hozen.khcommon.KeisanKaiyakuBean;
import yuyu.common.hozen.khcommon.KeisanCommonKaiyakuOutBean;
import yuyu.common.direct.dscommon.CheckDsKaiyaku;
import yuyu.common.direct.dscommon.CheckDsKaiyakuResultBean;
import yuyu.common.direct.dscommon.CheckDsTorihikiService;
import yuyu.common.direct.dscommon.CheckSoukinyoukzResultBean;
import yuyu.common.direct.dscommon.DsDB2Util;
import yuyu.common.dsweb.dwcommon.DwMessageCodeConstants;
import yuyu.def.MessageId;
import yuyu.def.biz.bean.param.WsBzWebserviceReqParamBean;
import yuyu.def.biz.bean.param.WsBzWebserviceResParamBean;
import yuyu.def.classification.C_AccessLogSyubetuKbn;
import yuyu.def.classification.C_ChkkekkaKbn;
import yuyu.def.classification.C_DsKaiyakuchkkekkaKbn;
import yuyu.def.classification.C_DsKinouidKbn;
import yuyu.def.classification.C_DsSyouhnbunruiKbn;
import yuyu.def.classification.C_DsTrhkserviceRiyoujkKbn;
import yuyu.def.classification.C_EigyoubiHoseiKbn;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_InputShrhousiteiKbn;
import yuyu.def.classification.C_KawaserateSyuruiKbn;
import yuyu.def.classification.C_KawasetekiyoKbn;
import yuyu.def.classification.C_KawasetsryKbn;
import yuyu.def.classification.C_KouzasyuruiKbn;
import yuyu.def.classification.C_Kzdou;
import yuyu.def.classification.C_SoukinyoukzchkkekkaKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_TourokuRouteKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UktkJyoutaiKbn;
import yuyu.def.classification.C_UktkSyoriKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.db.entity.IT_KhHenkouUktk;
import yuyu.def.db.entity.IT_KhHenkouUktkKaiyaku;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSya;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.db.entity.MT_DsKokyakuKanri;
import yuyu.def.db.entity.MT_DsKokyakuKeiyaku;
import yuyu.def.db.entity.MT_DsSoukinyouKouza;
import yuyu.def.db.entity.MT_DsTorihikiServiceKanri;
import yuyu.def.db.entity.MT_KhHenkouUktkKaiyakuYyk;
import yuyu.def.db.entity.MT_KhHenkouUktkYyk;
import yuyu.def.direct.manager.DirectDomManager;
import yuyu.def.dsweb.bean.webservice.WsDwDsKaiyakuUktkInputBean;
import yuyu.def.dsweb.bean.webservice.WsDwDsKaiyakuUktkOutputBean;
import yuyu.def.dsweb.configuration.YuyuDswebConfig;
import yuyu.def.hozen.manager.HozenDomManager;

/**
 * ＤＳ解約受付サービスの実装クラスです。<br />
 */
public class DwKaiyakuUketukeImpl implements DwKaiyakuUketuke {

    private BizCurrency shrgkkeiyen = null;

    private BizCurrency kaiyakuhrkngkyen = null;

    private BizCurrency yendthnkhrgk = null;

    private BizCurrency gstszeigkyen = null;

    @Inject
    private static Logger logger;

    @Inject
    private DwKaiyakuUketukeDao dwKaiyakuUketukeDao;

    @Inject
    private HozenDomManager hozenDomManager;

    @Inject
    private DirectDomManager directDomManager;

    @Inject
    private BaseUserInfo baseUserInfo;

    @Override
    public WsBzWebserviceResParamBean execPostFormPrepare(MultivaluedMap<String, String> pMap) {

        logger.info(MessageUtil.getMessage(MessageId.IBF0016, MessageUtil.getMessage(MessageId.INW1011)));

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean;

        try {
            wsBzWebserviceResParamBean = prepare(pMap);
        } catch (Exception throwable) {
            DsDB2Util dsDB2Util = SWAKInjector.getInstance(DsDB2Util.class);

            DsDB2Util.E_Result hanteiKekka = dsDB2Util.exec(throwable);

            String iwsDsmsgcd = "";

            if (DsDB2Util.E_Result.DEADLOCK.compareTo(hanteiKekka) == 0) {
                iwsDsmsgcd = DwMessageCodeConstants.IWSDSMSGCD_013205;
            }
            else if (DsDB2Util.E_Result.QUERY_TIMEOUT.compareTo(hanteiKekka) == 0) {
                iwsDsmsgcd = DwMessageCodeConstants.IWSDSMSGCD_013204;
            }
            else if (DsDB2Util.E_Result.OTHER.compareTo(hanteiKekka) == 0) {
                throw throwable;
            }

            WsDwDsKaiyakuUktkOutputBean dsKaiyakuUktkOutputBean = SWAKInjector
                .getInstance(WsDwDsKaiyakuUktkOutputBean.class);

            wsBzWebserviceResParamBean = SWAKInjector.getInstance(WsBzWebserviceResParamBean.class);

            dsKaiyakuUktkOutputBean.setIwsDsmsgcd(iwsDsmsgcd);

            wsBzWebserviceResParamBean.setGyoumuData(JSON.encode(dsKaiyakuUktkOutputBean));
        } finally {
            logger.info(MessageUtil.getMessage(MessageId.IBF0017, MessageUtil.getMessage(MessageId.INW1011)));
        }

        return wsBzWebserviceResParamBean;
    }

    @Override
    public WsBzWebserviceResParamBean execPostFormUpdate(MultivaluedMap<String, String> pMap) {

        logger.info(MessageUtil.getMessage(MessageId.IBF0016, MessageUtil.getMessage(MessageId.INW1011)));

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean;

        try {
            wsBzWebserviceResParamBean = update(pMap);
        } catch (Exception throwable) {
            DsDB2Util dsDB2Util = SWAKInjector.getInstance(DsDB2Util.class);

            DsDB2Util.E_Result hanteiKekka = dsDB2Util.exec(throwable);

            String iwsDsmsgcd = "";

            if (DsDB2Util.E_Result.DEADLOCK.compareTo(hanteiKekka) == 0) {
                iwsDsmsgcd = DwMessageCodeConstants.IWSDSMSGCD_013205;
            }
            else if (DsDB2Util.E_Result.QUERY_TIMEOUT.compareTo(hanteiKekka) == 0) {
                iwsDsmsgcd = DwMessageCodeConstants.IWSDSMSGCD_013204;
            }
            else if (DsDB2Util.E_Result.OTHER.compareTo(hanteiKekka) == 0) {
                throw throwable;
            }

            WsDwDsKaiyakuUktkOutputBean dsKaiyakuUktkOutputBean = SWAKInjector
                .getInstance(WsDwDsKaiyakuUktkOutputBean.class);

            wsBzWebserviceResParamBean = SWAKInjector.getInstance(WsBzWebserviceResParamBean.class);

            dsKaiyakuUktkOutputBean.setIwsDsmsgcd(iwsDsmsgcd);

            wsBzWebserviceResParamBean.setGyoumuData(JSON.encode(dsKaiyakuUktkOutputBean));
        } finally {
            logger.info(MessageUtil.getMessage(MessageId.IBF0017, MessageUtil.getMessage(MessageId.INW1011)));
        }

        return wsBzWebserviceResParamBean;
    }

    @Override
    public WsBzWebserviceResParamBean execPostFormKadouhantei(MultivaluedMap<String, String> pMap) {

        logger.info(MessageUtil.getMessage(MessageId.IBF0016, MessageUtil.getMessage(MessageId.INW1011)));

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean;

        wsBzWebserviceResParamBean = kadouhantei(pMap);

        logger.info(MessageUtil.getMessage(MessageId.IBF0017, MessageUtil.getMessage(MessageId.INW1011)));

        return wsBzWebserviceResParamBean;
    }

    @Transactional
    WsBzWebserviceResParamBean prepare(MultivaluedMap<String, String> pMap) {

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

        WsDwDsKaiyakuUktkInputBean dsKaiyakuUktkInputBean =
            JSON.decode(gyoumuData, WsDwDsKaiyakuUktkInputBean.class);

        WebServiceAccesslogOutput webServiceAccesslogOutput =
            SWAKInjector.getInstance(WebServiceAccesslogOutput.class);

        webServiceAccesslogOutput.exec(C_AccessLogSyubetuKbn.ACTION_BEGIN,
            wsBzWebserviceReqParamBean,
            dsKaiyakuUktkInputBean);

        WsDwDsKaiyakuUktkOutputBean dsKaiyakuUktkOutputBean =
            SWAKInjector.getInstance(WsDwDsKaiyakuUktkOutputBean.class);

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean =
            SWAKInjector.getInstance(WsBzWebserviceResParamBean.class);

        boolean hissuChkKekka = dsKaiyakuUktkInputBean.chkHissuInput();

        if (!hissuChkKekka) {
            dsKaiyakuUktkOutputBean.setIwsDsmsgcd(DwMessageCodeConstants.IWSDSMSGCD_013100);

            wsBzWebserviceResParamBean.setGyoumuData(JSON.encode(dsKaiyakuUktkOutputBean));

            return wsBzWebserviceResParamBean;
        }

        Validator validator = SWAKInjector.getInstance(Validator.class);

        Set<ConstraintViolation<WsDwDsKaiyakuUktkInputBean>> validatorChkKekkaSet =
            validator.validate(dsKaiyakuUktkInputBean);

        if (validatorChkKekkaSet.size() > 0) {
            dsKaiyakuUktkOutputBean.setIwsDsmsgcd(DwMessageCodeConstants.IWSDSMSGCD_013100);

            wsBzWebserviceResParamBean.setGyoumuData(JSON.encode(dsKaiyakuUktkOutputBean));

            return wsBzWebserviceResParamBean;
        }

        dsKaiyakuUktkOutputBean.setIwsDsmsgcd(hanteiDsKaiyakuUketukeKahi(dsKaiyakuUktkInputBean));

        if(DwMessageCodeConstants.IWSDSMSGCD_013000.equals(dsKaiyakuUktkOutputBean.getIwsDsmsgcd())){
            dsKaiyakuUktkOutputBean.setIwsShrgkkeiyen(shrgkkeiyen.toString());
            dsKaiyakuUktkOutputBean.setIwsKaiyakuhryen(kaiyakuhrkngkyen.toString());
            dsKaiyakuUktkOutputBean.setIwsYendthnkhr(yendthnkhrgk.toString());
            dsKaiyakuUktkOutputBean.setIwsGstszeigkyen(gstszeigkyen.toString());

        }

        wsBzWebserviceResParamBean.setGyoumuData(JSON.encode(dsKaiyakuUktkOutputBean));

        return wsBzWebserviceResParamBean;
    }

    @Transactional
    WsBzWebserviceResParamBean update(MultivaluedMap<String, String> pMap) {

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

        WsDwDsKaiyakuUktkInputBean dsKaiyakuUktkInputBean =
            JSON.decode(gyoumuData, WsDwDsKaiyakuUktkInputBean.class);

        WebServiceAccesslogOutput webServiceAccesslogOutput =
            SWAKInjector.getInstance(WebServiceAccesslogOutput.class);

        webServiceAccesslogOutput.exec(C_AccessLogSyubetuKbn.ACTION_BEGIN,
            wsBzWebserviceReqParamBean,
            dsKaiyakuUktkInputBean);

        WsDwDsKaiyakuUktkOutputBean dsKaiyakuUktkOutputBean =
            SWAKInjector.getInstance(WsDwDsKaiyakuUktkOutputBean.class);

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean =
            SWAKInjector.getInstance(WsBzWebserviceResParamBean.class);

        boolean hissuChkKekka = dsKaiyakuUktkInputBean.chkHissuInput();

        if (!hissuChkKekka) {
            dsKaiyakuUktkOutputBean.setIwsDsmsgcd(DwMessageCodeConstants.IWSDSMSGCD_013100);

            wsBzWebserviceResParamBean.setGyoumuData(JSON.encode(dsKaiyakuUktkOutputBean));

            return wsBzWebserviceResParamBean;
        }

        Validator validator = SWAKInjector.getInstance(Validator.class);

        Set<ConstraintViolation<WsDwDsKaiyakuUktkInputBean>> validatorChkKekkaSet =
            validator.validate(dsKaiyakuUktkInputBean);

        if (validatorChkKekkaSet.size() > 0) {
            dsKaiyakuUktkOutputBean.setIwsDsmsgcd(DwMessageCodeConstants.IWSDSMSGCD_013100);

            wsBzWebserviceResParamBean.setGyoumuData(JSON.encode(dsKaiyakuUktkOutputBean));

            return wsBzWebserviceResParamBean;
        }

        String hanteiDsKaiyakuUketukeKahiKekka = hanteiDsKaiyakuUketukeKahi(dsKaiyakuUktkInputBean);

        if (!DwMessageCodeConstants.IWSDSMSGCD_013000.equals(hanteiDsKaiyakuUketukeKahiKekka)) {

            dsKaiyakuUktkOutputBean.setIwsDsmsgcd(hanteiDsKaiyakuUketukeKahiKekka);

            wsBzWebserviceResParamBean.setGyoumuData(JSON.encode(dsKaiyakuUktkOutputBean));

            return wsBzWebserviceResParamBean;
        }

        MT_DsSoukinyouKouza mtDsSoukinyouKouza = dwKaiyakuUketukeDao.
            getDsSoukinyouKouzaByDskoknoSyonoKouzaSyuruiKbn(dsKaiyakuUktkInputBean.getIwsDskokno(),
                dsKaiyakuUktkInputBean.getIwsSyono(),
                C_KouzasyuruiKbn.YENKOUZA);

        if (!String.valueOf(mtDsSoukinyouKouza.getVersion()).equals(dsKaiyakuUktkInputBean.getIwsVersion())) {

            dsKaiyakuUktkOutputBean.setIwsDsmsgcd(DwMessageCodeConstants.IWSDSMSGCD_013018);

            wsBzWebserviceResParamBean.setGyoumuData(JSON.encode(dsKaiyakuUktkOutputBean));

            return wsBzWebserviceResParamBean;
        }

        String hozenHenkouUktkrenNo = SaibanBiz.getHozenHenkouUktkrenNo(dsKaiyakuUktkInputBean.getIwsSyono());

        BizDate sysDate = BizDate.getSysDate();
        String sysDateTime = BizDate.getSysDateTimeMilli();
        String kinouId = C_DsKinouidKbn.DSKAIYAKUUKETUKE.getValue();

        IT_KykKihon itKykKihon = hozenDomManager.getKykKihon(dsKaiyakuUktkInputBean.getIwsSyono());

        List<IT_KykSyouhn> itKykSyouhns = itKykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        IT_KykSyouhn itKykSyouhn = itKykSyouhns.get(0);

        MT_DsKokyakuKanri mtDsKokyakuKanri = dwKaiyakuUketukeDao
            .getDsKokyakuKanriByDskoknoYuukoutorihikityuu(dsKaiyakuUktkInputBean.getIwsDskokno());

        if (Integer.parseInt(sysDateTime.substring(8, sysDateTime.length())) <
            Integer.parseInt(YuyuDswebConfig.getInstance().getYakanJobKadouKaisiTime())) {

            IT_KhHenkouUktk itKhHenkouUktk = new IT_KhHenkouUktk(dsKaiyakuUktkInputBean.getIwsSyono(),
                Integer.parseInt(hozenHenkouUktkrenNo));

            itKhHenkouUktk.setUktkymd(sysDate);
            itKhHenkouUktk.setTourokuroute(C_TourokuRouteKbn.DS);
            itKhHenkouUktk.setUktksyorikbn(C_UktkSyoriKbn.KAIYAKU);
            itKhHenkouUktk.setKouryokuhasseiymd(sysDate);
            itKhHenkouUktk.setSyoriyoteiymd(sysDate);
            itKhHenkouUktk.setUktkjyoutaikbn(C_UktkJyoutaiKbn.MISYORI);
            itKhHenkouUktk.setGyoumuKousinKinou(kinouId);
            itKhHenkouUktk.setGyoumuKousinsyaId(baseUserInfo.getUser().getUserId());
            itKhHenkouUktk.setGyoumuKousinTime(sysDateTime);

            BizPropertyInitializer.initialize(itKhHenkouUktk);

            IT_KhHenkouUktkKaiyaku itKhHenkouUktkKaiyaku = itKhHenkouUktk.createKhHenkouUktkKaiyaku();

            itKhHenkouUktkKaiyaku.setInputshrhousiteikbn(C_InputShrhousiteiKbn.FBSOUKIN);
            if (C_UmuKbn.ARI.eq(itKykSyouhn.getSyouhnZokusei().getYenshrtktekiumu())) {
                itKhHenkouUktkKaiyaku.setYenshrtkhkumu(C_UmuKbn.ARI);
            }
            else {
                itKhHenkouUktkKaiyaku.setYenshrtkhkumu(C_UmuKbn.NONE);
            }
            itKhHenkouUktkKaiyaku.setBankcd(mtDsSoukinyouKouza.getBankcd());
            itKhHenkouUktkKaiyaku.setSitencd(mtDsSoukinyouKouza.getSitencd());
            itKhHenkouUktkKaiyaku.setYokinkbn(mtDsSoukinyouKouza.getYokinkbn());
            itKhHenkouUktkKaiyaku.setKouzano(mtDsSoukinyouKouza.getKouzano());
            itKhHenkouUktkKaiyaku.setKzdoukbn(mtDsSoukinyouKouza.getKzdoukbn());
            if (C_Kzdou.DOUITU.eq(itKhHenkouUktkKaiyaku.getKzdoukbn())) {
                itKhHenkouUktkKaiyaku.setKzmeiginmkn(mtDsKokyakuKanri.getDskokyakunmkn());
            }
            else {
                itKhHenkouUktkKaiyaku.setKzmeiginmkn(mtDsSoukinyouKouza.getKzmeiginmkn());
            }
            itKhHenkouUktkKaiyaku.setGyoumuKousinKinou(kinouId);
            itKhHenkouUktkKaiyaku.setGyoumuKousinsyaId(baseUserInfo.getUser().getUserId());
            itKhHenkouUktkKaiyaku.setGyoumuKousinTime(sysDateTime);

            BizPropertyInitializer.initialize(itKhHenkouUktkKaiyaku);

            try {
                directDomManager.insert(itKhHenkouUktk);
            } catch (Exception e) {
                dsKaiyakuUktkOutputBean.setIwsDsmsgcd(DwMessageCodeConstants.IWSDSMSGCD_013202);

                wsBzWebserviceResParamBean.setGyoumuData(JSON.encode(dsKaiyakuUktkOutputBean));

                return wsBzWebserviceResParamBean;
            }
        }
        else {
            MT_KhHenkouUktkYyk mtKhHenkouUktkYyk = new MT_KhHenkouUktkYyk(
                dsKaiyakuUktkInputBean.getIwsSyono(), Integer.parseInt(hozenHenkouUktkrenNo));

            mtKhHenkouUktkYyk.setUktkymd(sysDate);
            mtKhHenkouUktkYyk.setTourokuroute(C_TourokuRouteKbn.DS);
            mtKhHenkouUktkYyk.setUktksyorikbn(C_UktkSyoriKbn.KAIYAKU);
            mtKhHenkouUktkYyk.setKouryokuhasseiymd(sysDate);
            mtKhHenkouUktkYyk.setSyoriyoteiymd(sysDate.addBusinessDays(1));
            mtKhHenkouUktkYyk.setUktkjyoutaikbn(C_UktkJyoutaiKbn.MISYORI);
            mtKhHenkouUktkYyk.setGyoumuKousinKinou(kinouId);
            mtKhHenkouUktkYyk.setGyoumuKousinsyaId(baseUserInfo.getUser().getUserId());
            mtKhHenkouUktkYyk.setGyoumuKousinTime(sysDateTime);

            BizPropertyInitializer.initialize(mtKhHenkouUktkYyk);

            MT_KhHenkouUktkKaiyakuYyk mtKhHenkouUktkKaiyakuYyk = mtKhHenkouUktkYyk.createKhHenkouUktkKaiyakuYyk();

            mtKhHenkouUktkKaiyakuYyk.setInputshrhousiteikbn(C_InputShrhousiteiKbn.FBSOUKIN);
            if (C_UmuKbn.ARI.eq(itKykSyouhn.getSyouhnZokusei().getYenshrtktekiumu())) {
                mtKhHenkouUktkKaiyakuYyk.setYenshrtkhkumu(C_UmuKbn.ARI);
            }
            else {
                mtKhHenkouUktkKaiyakuYyk.setYenshrtkhkumu(C_UmuKbn.NONE);
            }
            mtKhHenkouUktkKaiyakuYyk.setBankcd(mtDsSoukinyouKouza.getBankcd());
            mtKhHenkouUktkKaiyakuYyk.setSitencd(mtDsSoukinyouKouza.getSitencd());
            mtKhHenkouUktkKaiyakuYyk.setYokinkbn(mtDsSoukinyouKouza.getYokinkbn());
            mtKhHenkouUktkKaiyakuYyk.setKouzano(mtDsSoukinyouKouza.getKouzano());
            mtKhHenkouUktkKaiyakuYyk.setKzdoukbn(mtDsSoukinyouKouza.getKzdoukbn());
            if (C_Kzdou.DOUITU.eq(mtKhHenkouUktkKaiyakuYyk.getKzdoukbn())) {
                mtKhHenkouUktkKaiyakuYyk.setKzmeiginmkn(mtDsKokyakuKanri.getDskokyakunmkn());
            }
            else {
                mtKhHenkouUktkKaiyakuYyk.setKzmeiginmkn(mtDsSoukinyouKouza.getKzmeiginmkn());
            }
            mtKhHenkouUktkKaiyakuYyk.setGyoumuKousinKinou(kinouId);
            mtKhHenkouUktkKaiyakuYyk.setGyoumuKousinsyaId(baseUserInfo.getUser().getUserId());
            mtKhHenkouUktkKaiyakuYyk.setGyoumuKousinTime(sysDateTime);

            BizPropertyInitializer.initialize(mtKhHenkouUktkKaiyakuYyk);

            try {
                directDomManager.insert(mtKhHenkouUktkYyk);
            } catch (Exception e) {
                dsKaiyakuUktkOutputBean.setIwsDsmsgcd(DwMessageCodeConstants.IWSDSMSGCD_013203);

                wsBzWebserviceResParamBean.setGyoumuData(JSON.encode(dsKaiyakuUktkOutputBean));

                return wsBzWebserviceResParamBean;
            }
        }

        dsKaiyakuUktkOutputBean.setIwsDsmsgcd(DwMessageCodeConstants.IWSDSMSGCD_013000);

        wsBzWebserviceResParamBean.setGyoumuData(JSON.encode(dsKaiyakuUktkOutputBean));

        return wsBzWebserviceResParamBean;
    }

    @Transactional
    WsBzWebserviceResParamBean kadouhantei(MultivaluedMap<String, String> pMap) {

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

        WsDwDsKaiyakuUktkInputBean dsKaiyakuUktkInputBean =
            JSON.decode(gyoumuData, WsDwDsKaiyakuUktkInputBean.class);

        WebServiceAccesslogOutput webServiceAccesslogOutput =
            SWAKInjector.getInstance(WebServiceAccesslogOutput.class);

        webServiceAccesslogOutput.exec(C_AccessLogSyubetuKbn.ACTION_BEGIN,
            wsBzWebserviceReqParamBean,
            dsKaiyakuUktkInputBean);

        WsDwDsKaiyakuUktkOutputBean dsKaiyakuUktkOutputBean =
            SWAKInjector.getInstance(WsDwDsKaiyakuUktkOutputBean.class);

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean =
            SWAKInjector.getInstance(WsBzWebserviceResParamBean.class);

        boolean dskaiyakuTimeFlg = false;
        BizDate sysDate = BizDate.getSysDate();
        String sysDateTime = BizDate.getSysDateTimeMilli();

        if (Integer.parseInt(sysDateTime.substring(8, sysDateTime.length())) <
            Integer.parseInt(YuyuDswebConfig.getInstance().getKaiyakuServiceKadouKaisiTime())) {
            dskaiyakuTimeFlg = true;
        }

        if (sysDate.isHoliday()) {
            dskaiyakuTimeFlg = true;
        }

        if (dskaiyakuTimeFlg) {
            dsKaiyakuUktkOutputBean.setIwsDsmsgcd(DwMessageCodeConstants.IWSDSMSGCD_013014);
        }
        else {
            dsKaiyakuUktkOutputBean.setIwsDsmsgcd(DwMessageCodeConstants.IWSDSMSGCD_013000);
        }

        wsBzWebserviceResParamBean.setGyoumuData(JSON.encode(dsKaiyakuUktkOutputBean));

        return wsBzWebserviceResParamBean;
    }

    private String hanteiDsKaiyakuUketukeKahi(WsDwDsKaiyakuUktkInputBean pInputBean) {

        MT_DsKokyakuKanri mtDsKokyakuKanri =
            dwKaiyakuUketukeDao.getDsKokyakuKanriByDskoknoYuukoutorihikityuu(pInputBean.getIwsDskokno());

        if (mtDsKokyakuKanri == null) {
            return DwMessageCodeConstants.IWSDSMSGCD_013200;
        }

        IT_KykKihon itKykKihon = hozenDomManager.getKykKihon(pInputBean.getIwsSyono());

        if (itKykKihon == null) {
            return DwMessageCodeConstants.IWSDSMSGCD_013201;
        }

        IT_KykSya itKykSya = itKykKihon.getKykSya();

        List<IT_KykSyouhn> itKykSyouhns = itKykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        IT_KykSyouhn itKykSyouhn = itKykSyouhns.get(0);

        BizDate sysDate = BizDate.getSysDate();

        GetKawaseRate getKawaseRate = SWAKInjector.getInstance(GetKawaseRate.class);

        C_ErrorKbn errorKbn = getKawaseRate.exec(sysDate,
            C_KawaserateSyuruiKbn.KOUJIKAWASERATE,
            itKykSyouhn.getKyktuukasyu(),
            C_Tuukasyu.JPY,
            C_KawasetekiyoKbn.TTM,
            C_KawasetsryKbn.SYUKKINRATE,
            C_EigyoubiHoseiKbn.BLNK,
            C_YouhiKbn.HUYOU);

        if (!itKykSyouhn.getKyktuukasyu().getValue().equals(pInputBean.getIwsShrtuukasyu())) {

            if (C_ErrorKbn.ERROR.eq(errorKbn)) {
                return DwMessageCodeConstants.IWSDSMSGCD_013007;
            }
        }

        KeisanCommonKaiyaku keisanCommonKaiyaku = SWAKInjector.getInstance(KeisanCommonKaiyaku.class);
        KeisanKaiyakuBean keisanKaiyakuBean = new KeisanKaiyakuBean();
        KeisanCommonKaiyakuOutBean keisanCommonKaiyakuOutBean = new KeisanCommonKaiyakuOutBean();

        keisanKaiyakuBean.setSyoruiukeymd(BizDate.getSysDate());
        keisanKaiyakuBean.setKaiykymd(BizDate.getSysDate());
        keisanKaiyakuBean.setYenshrkwsrate(getKawaseRate.getKawaserate());

        C_ErrorKbn keisanCommonKaiyakuerrorKbn = keisanCommonKaiyaku.keisanKaiyakuseisankin(
            KeisanCommonKaiyaku.KINOUBUNRUI_DRCTSERVICE,
            itKykKihon,
            BizDate.getSysDate(),
            keisanKaiyakuBean);

        if(C_ErrorKbn.ERROR.eq(keisanCommonKaiyakuerrorKbn)){
            return DwMessageCodeConstants.IWSDSMSGCD_013019;
        }

        keisanCommonKaiyakuOutBean = keisanCommonKaiyaku.getKeisanCommonKaiyakuOutBean();

        shrgkkeiyen = keisanCommonKaiyakuOutBean.getShrgkkeiYen();
        yendthnkhrgk = keisanCommonKaiyakuOutBean.getYendthnkkaiyakuhr();
        gstszeigkyen = keisanCommonKaiyakuOutBean.getJpygstszeigk();

        if (C_Tuukasyu.JPY.eq(itKykSyouhn.getKyktuukasyu())) {

            kaiyakuhrkngkyen = keisanCommonKaiyakuOutBean.getKaiyakuHrYen();
        }
        else{

            kaiyakuhrkngkyen = keisanCommonKaiyakuOutBean.getKaiyakuhrgoukeiYen();
        }

        CheckDsKaiyaku checkDsKaiyaku = SWAKInjector.getInstance(CheckDsKaiyaku.class);

        CheckDsKaiyakuResultBean checkDsKaiyakuResultBean = checkDsKaiyaku.kaiyakukytChk(
            pInputBean.getIwsSyono(),
            sysDate,
            shrgkkeiyen,
            C_DsSyouhnbunruiKbn.valueOf(pInputBean.getIwsDssyouhnbunruikbn()));

        if (C_ErrorKbn.ERROR.eq(checkDsKaiyakuResultBean.getErrorKbn())) {

            C_DsKaiyakuchkkekkaKbn dsKaiyakuchkkekkaKbn = checkDsKaiyakuResultBean.getDsKaiyakuchkkekkaKbn();

            if (C_DsKaiyakuchkkekkaKbn.HOZENJYOUTAI.eq(dsKaiyakuchkkekkaKbn)) {
                return DwMessageCodeConstants.IWSDSMSGCD_013001;
            }
            else if (C_DsKaiyakuchkkekkaKbn.TETUDUKITYUUI.eq(dsKaiyakuchkkekkaKbn)) {
                return DwMessageCodeConstants.IWSDSMSGCD_013002;
            }
            else if (C_DsKaiyakuchkkekkaKbn.SITIKENSETTEI.eq(dsKaiyakuchkkekkaKbn)) {
                return DwMessageCodeConstants.IWSDSMSGCD_013016;
            }
            else if (C_DsKaiyakuchkkekkaKbn.YENDATEHENKOUMAE.eq(dsKaiyakuchkkekkaKbn)) {
                return DwMessageCodeConstants.IWSDSMSGCD_013015;
            }
            else if (C_DsKaiyakuchkkekkaKbn.SAKIYMDHENKOU.eq(dsKaiyakuchkkekkaKbn)) {
                return DwMessageCodeConstants.IWSDSMSGCD_013003;
            }
            else if (C_DsKaiyakuchkkekkaKbn.KYKYMDMAE.eq(dsKaiyakuchkkekkaKbn)) {
                return DwMessageCodeConstants.IWSDSMSGCD_013004;
            }
            else if (C_DsKaiyakuchkkekkaKbn.HAITOUKIN.eq(dsKaiyakuchkkekkaKbn)) {
                return DwMessageCodeConstants.IWSDSMSGCD_013024;
            }
            else if (C_DsKaiyakuchkkekkaKbn.MFHUSEIGOU.eq(dsKaiyakuchkkekkaKbn)) {
                return DwMessageCodeConstants.IWSDSMSGCD_013020;
            }
            else if (C_DsKaiyakuchkkekkaKbn.MIHANEIHAITOUKIN.eq(dsKaiyakuchkkekkaKbn)) {
                return DwMessageCodeConstants.IWSDSMSGCD_013021;
            }
            else if (C_DsKaiyakuchkkekkaKbn.HAITOUKINHANEIYMDSONZAI.eq(dsKaiyakuchkkekkaKbn)) {
                return DwMessageCodeConstants.IWSDSMSGCD_013022;
            }
            else if (C_DsKaiyakuchkkekkaKbn.MIHANEITUMITATEKIN.eq(dsKaiyakuchkkekkaKbn)) {
                return DwMessageCodeConstants.IWSDSMSGCD_013025;
            }
            else if (C_DsKaiyakuchkkekkaKbn.ZENNOUMIJYUUTOU.eq(dsKaiyakuchkkekkaKbn)) {
                return DwMessageCodeConstants.IWSDSMSGCD_013026;
            }
            else if (C_DsKaiyakuchkkekkaKbn.SOUKINJYOUGEN.eq(dsKaiyakuchkkekkaKbn)) {
                return DwMessageCodeConstants.IWSDSMSGCD_013005;
            }
            else if (C_DsKaiyakuchkkekkaKbn.HARAIKOMIYUYOKIKAN.eq(dsKaiyakuchkkekkaKbn)) {
                return DwMessageCodeConstants.IWSDSMSGCD_013023;
            }
            else {
                throw new CommonBizAppException("ＤＳ解約共通チェック結果が想定外の値です。");
            }
        }

        MT_DsKokyakuKanri mtDsKokyakuKanriSoukin = directDomManager.getDsKokyakuKanri(pInputBean.getIwsDskokno());

        MT_DsKokyakuKeiyaku mtDsKokyakuKeiyaku =
            mtDsKokyakuKanriSoukin.getDsKokyakuKeiyakuBySyono(pInputBean.getIwsSyono());

        MT_DsTorihikiServiceKanri mtDsTorihikiServiceKanri = mtDsKokyakuKeiyaku.getDsTorihikiServiceKanri();

        if (mtDsTorihikiServiceKanri == null) {
            return DwMessageCodeConstants.IWSDSMSGCD_013008;
        }
        else if (C_DsTrhkserviceRiyoujkKbn.RIYOU_HUKA.eq(mtDsTorihikiServiceKanri.getDstrhkserviceriyoujkkbn())) {
            return DwMessageCodeConstants.IWSDSMSGCD_013009;
        }

        MT_DsSoukinyouKouza mtDsSoukinyouKouza = dwKaiyakuUketukeDao.
            getDsSoukinyouKouzaByDskoknoSyonoKouzaSyuruiKbn(
                pInputBean.getIwsDskokno(),
                pInputBean.getIwsSyono(),
                C_KouzasyuruiKbn.YENKOUZA);

        if(mtDsSoukinyouKouza == null){
            return DwMessageCodeConstants.IWSDSMSGCD_013206;
        }

        CheckDsTorihikiService checkDsTorihikiService = SWAKInjector.getInstance(CheckDsTorihikiService.class);

        CheckSoukinyoukzResultBean checkSoukinyoukzResultBean = checkDsTorihikiService.checkSoukinyoukz(
            C_Tuukasyu.valueOf(pInputBean.getIwsShrtuukasyu()),
            mtDsSoukinyouKouza.getBankcd(),
            mtDsSoukinyouKouza.getSitencd(),
            mtDsKokyakuKanri.getDskokyakunmkn(),
            mtDsSoukinyouKouza.getKzdoukbn(),
            itKykSya.getKyknmkn());

        if (C_ChkkekkaKbn.ERROR.eq(checkSoukinyoukzResultBean.getChkkekkaKbn())) {

            C_SoukinyoukzchkkekkaKbn soukinyoukzchkkekkaKbn = checkSoukinyoukzResultBean.getSoukinyoukzchkkekkaKbn();

            if (C_SoukinyoukzchkkekkaKbn.GINKOUMASTERSONZAI.eq(soukinyoukzchkkekkaKbn)) {
                return DwMessageCodeConstants.IWSDSMSGCD_013010;
            }
            else if (C_SoukinyoukzchkkekkaKbn.GINKOUYUUKOUHANTEI.eq(soukinyoukzchkkekkaKbn)) {
                return DwMessageCodeConstants.IWSDSMSGCD_013011;
            }
            else if (C_SoukinyoukzchkkekkaKbn.YUUTYOGINKOUSOUKINKAHI.eq(soukinyoukzchkkekkaKbn)) {
                return DwMessageCodeConstants.IWSDSMSGCD_013012;
            }
            else if (C_SoukinyoukzchkkekkaKbn.GAIKAKOUZASOUKINKAHI.eq(soukinyoukzchkkekkaKbn)) {
                return DwMessageCodeConstants.IWSDSMSGCD_013013;
            }
            else if (C_SoukinyoukzchkkekkaKbn.KOUZAMEIGININ.eq(soukinyoukzchkkekkaKbn)) {
                return DwMessageCodeConstants.IWSDSMSGCD_013017;
            }
            else {
                throw new CommonBizAppException("送金用口座正当性チェック結果が想定外の値です。");
            }
        }

        C_UmuKbn cUmuKbn = checkDsKaiyaku.kaiyakuUkeUmuChk(pInputBean.getIwsSyono());

        if (C_UmuKbn.ARI.eq(cUmuKbn)) {
            return DwMessageCodeConstants.IWSDSMSGCD_013006;
        }

        return DwMessageCodeConstants.IWSDSMSGCD_013000;
    }
}
