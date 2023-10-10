package yuyu.app.dsweb.dwhozeninfo.dwgethozenkiykgikitijinnkn;

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
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.util.message.MessageUtil;
import net.arnx.jsonic.JSON;

import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bzcommon.GetKawaseRate;
import yuyu.common.biz.bzcommon.KeisanGaikakanzan;
import yuyu.common.biz.bzcommon.SetNenrei;
import yuyu.common.biz.bzwebserviceaccesslogoutput.WebServiceAccesslogOutput;
import yuyu.common.direct.dscommon.DsDB2Util;
import yuyu.common.direct.dscommon.DsGetKeiyakuCommon;
import yuyu.common.direct.dscommon.DsGetSeigyo;
import yuyu.common.direct.dscommon.DsSyouhinBean;
import yuyu.common.direct.dscommon.DsTeirituTumitatekinKeisan;
import yuyu.common.direct.dscommon.DsTumitatekinItenCheck;
import yuyu.common.direct.dscommon.DsTumitatekinItenCheckResultBean;
import yuyu.common.direct.dscommon.GamenSeigyoBean;
import yuyu.common.direct.dscommon.HihokensyaBean;
import yuyu.common.direct.dscommon.HosyouBean;
import yuyu.common.direct.dscommon.KeiyakuKihonBean;
import yuyu.common.direct.dscommon.KeiyakuUketorininBean;
import yuyu.common.direct.dscommon.KeiyakusyaBean;
import yuyu.common.direct.dscommon.SyoriKahiBean;
import yuyu.common.direct.dscommon.TokuyakuBean;
import yuyu.common.direct.dscommon.TrkKazokuBean;
import yuyu.common.direct.dscommon.UketoriKouzaBean;
import yuyu.common.dsweb.dwcommon.DwMessageCodeConstants;
import yuyu.common.hozen.khcommon.SetOutoubi;
import yuyu.common.siharai.sicommon.CalcHkShrKngk;
import yuyu.common.siharai.sicommon.CalcHkShrKngkBean;
import yuyu.def.MessageId;
import yuyu.def.biz.bean.param.WsBzWebserviceReqParamBean;
import yuyu.def.biz.bean.param.WsBzWebserviceResParamBean;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_AccessLogSyubetuKbn;
import yuyu.def.classification.C_DsSyouhnbunruiKbn;
import yuyu.def.classification.C_DsTmttknitenchkkekkaKbn;
import yuyu.def.classification.C_EigyoubiHoseiKbn;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_HasuusyoriKbn;
import yuyu.def.classification.C_HokenkinsyuruiKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_KawaserateSyuruiKbn;
import yuyu.def.classification.C_KawasetekiyoKbn;
import yuyu.def.classification.C_KawasetsryKbn;
import yuyu.def.classification.C_KouzasyuruiKbn;
import yuyu.def.classification.C_Nenkinsyu;
import yuyu.def.classification.C_Nykkeiro;
import yuyu.def.classification.C_SiinKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_TmttknhaibunjyoutaiKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_TykzentykgoKbn;
import yuyu.def.classification.C_UktsyuKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YokinKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.db.entity.BM_SisuuKihon;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSonotaTkyk;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.db.entity.IT_NyknJissekiRireki;
import yuyu.def.dsweb.bean.webservice.WsDwGetHozenKiykGikItijiNnknInputBean;
import yuyu.def.dsweb.bean.webservice.WsDwGetHozenKiykGikItijiNnknOutputBean;
import yuyu.def.hozen.manager.HozenDomManager;

/**
 * 保全契約詳細取得（外貨建一時払年金）サービスの実装クラスです。<br />
 */
public class DwGetHozenKiykGikItijiNnknImpl implements DwGetHozenKiykGikItijiNnkn {

    @Inject
    private static Logger logger;

    @Inject
    private BizDomManager bizDomManager;

    @Inject
    private HozenDomManager hozenDomManager;

    @Override
    public WsBzWebserviceResParamBean execPostForm(MultivaluedMap<String, String> pMap) {

        logger.info(MessageUtil.getMessage(MessageId.IBF0016, MessageUtil.getMessage(MessageId.INW1014)));

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean;

        try {

            wsBzWebserviceResParamBean = getHozenKiykGikItijiNnknMain(pMap);

        } catch (Exception throwable) {
            DsDB2Util dsDB2Util = SWAKInjector.getInstance(DsDB2Util.class);

            DsDB2Util.E_Result result = dsDB2Util.exec(throwable);

            String iwsDsmsgcd = "";

            if (DsDB2Util.E_Result.DEADLOCK.compareTo(result) == 0) {
                iwsDsmsgcd = DwMessageCodeConstants.IWSDSMSGCD_011215;
            }
            else if (DsDB2Util.E_Result.QUERY_TIMEOUT.compareTo(result) == 0) {
                iwsDsmsgcd = DwMessageCodeConstants.IWSDSMSGCD_011214;
            }
            else if (DsDB2Util.E_Result.OTHER.compareTo(result) == 0) {
                throw throwable;
            }

            WsDwGetHozenKiykGikItijiNnknOutputBean getHzKykGikItijiNnknOutputBean =
                SWAKInjector.getInstance(WsDwGetHozenKiykGikItijiNnknOutputBean.class);
            wsBzWebserviceResParamBean = SWAKInjector.getInstance(WsBzWebserviceResParamBean.class);
            getHzKykGikItijiNnknOutputBean.setIwsDsmsgcd(iwsDsmsgcd);
            wsBzWebserviceResParamBean.setGyoumuData(JSON.encode(getHzKykGikItijiNnknOutputBean));

        } finally {
            logger.info(MessageUtil.getMessage(MessageId.IBF0017, MessageUtil.getMessage(MessageId.INW1014)));
        }

        return wsBzWebserviceResParamBean;
    }

    @Transactional
    WsBzWebserviceResParamBean getHozenKiykGikItijiNnknMain(MultivaluedMap<String, String> pMap) {

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

        WsDwGetHozenKiykGikItijiNnknInputBean getHzKykGikItijiNnknInputBean =
            JSON.decode(gyoumuData, WsDwGetHozenKiykGikItijiNnknInputBean.class);

        WebServiceAccesslogOutput webServiceAccesslogOutput =
            SWAKInjector.getInstance(WebServiceAccesslogOutput.class);
        webServiceAccesslogOutput.exec(C_AccessLogSyubetuKbn.ACTION_BEGIN,
            wsBzWebserviceReqParamBean, getHzKykGikItijiNnknInputBean);

        WsDwGetHozenKiykGikItijiNnknOutputBean getHzKykGikItijiNnknOutputBean =
            SWAKInjector.getInstance(WsDwGetHozenKiykGikItijiNnknOutputBean.class);
        WsBzWebserviceResParamBean wsBzWebserviceResParamBean =
            SWAKInjector.getInstance(WsBzWebserviceResParamBean.class);

        boolean chkRet = getHzKykGikItijiNnknInputBean.chkInput();

        if (!chkRet) {
            getHzKykGikItijiNnknOutputBean.setIwsDsmsgcd(DwMessageCodeConstants.IWSDSMSGCD_011100);
            wsBzWebserviceResParamBean.setGyoumuData(JSON.encode(getHzKykGikItijiNnknOutputBean));

            return wsBzWebserviceResParamBean;
        }

        Validator validator = SWAKInjector.getInstance(Validator.class);

        Set<ConstraintViolation<WsDwGetHozenKiykGikItijiNnknInputBean>> chkKekkaSet =
            validator.validate(getHzKykGikItijiNnknInputBean);

        if (chkKekkaSet.size() > 0) {
            getHzKykGikItijiNnknOutputBean.setIwsDsmsgcd(DwMessageCodeConstants.IWSDSMSGCD_011100);
            wsBzWebserviceResParamBean.setGyoumuData(JSON.encode(getHzKykGikItijiNnknOutputBean));

            return wsBzWebserviceResParamBean;
        }

        getHzKykGikItijiNnknOutputBean = getDsKeiyakuSyousaiGikItijiNnkn(getHzKykGikItijiNnknInputBean.getIwsSyono());

        wsBzWebserviceResParamBean.setGyoumuData(JSON.encode(getHzKykGikItijiNnknOutputBean));

        return wsBzWebserviceResParamBean;
    }

    private WsDwGetHozenKiykGikItijiNnknOutputBean getDsKeiyakuSyousaiGikItijiNnkn(String pSyono) {

        WsDwGetHozenKiykGikItijiNnknOutputBean getHzKykGikItijiNnknOutputBean =
            SWAKInjector.getInstance(WsDwGetHozenKiykGikItijiNnknOutputBean.class);

        DsGetKeiyakuCommon dsGetKeiyakuCommon = SWAKInjector.getInstance(DsGetKeiyakuCommon.class);

        KeiyakuKihonBean keiyakuKihonBean = dsGetKeiyakuCommon.getKykKihon(pSyono);

        if (C_ErrorKbn.ERROR.eq(keiyakuKihonBean.getErrorKbn())) {

            getHzKykGikItijiNnknOutputBean.setIwsDsmsgcd(DwMessageCodeConstants.IWSDSMSGCD_011201);

            return getHzKykGikItijiNnknOutputBean;
        }

        KeiyakusyaBean keiyakusyaBean = dsGetKeiyakuCommon.getKykSya(pSyono);

        if (C_ErrorKbn.ERROR.eq(keiyakusyaBean.getErrorKbn())) {

            getHzKykGikItijiNnknOutputBean.setIwsDsmsgcd(DwMessageCodeConstants.IWSDSMSGCD_011202);

            return getHzKykGikItijiNnknOutputBean;
        }

        HihokensyaBean hihokensyaBean = dsGetKeiyakuCommon.getHhknSya(pSyono);

        if (C_ErrorKbn.ERROR.eq(hihokensyaBean.getErrorKbn())) {

            getHzKykGikItijiNnknOutputBean.setIwsDsmsgcd(DwMessageCodeConstants.IWSDSMSGCD_011203);

            return getHzKykGikItijiNnknOutputBean;
        }

        KeiyakuUketorininBean keiyakuUketorininBean = dsGetKeiyakuCommon.getKykUkt(pSyono);

        if (C_ErrorKbn.ERROR.eq(keiyakuUketorininBean.getErrorKbn())) {

            getHzKykGikItijiNnknOutputBean.setIwsDsmsgcd(DwMessageCodeConstants.IWSDSMSGCD_011204);

            return getHzKykGikItijiNnknOutputBean;
        }

        TrkKazokuBean trkKazokuBean = dsGetKeiyakuCommon.getTrkKazoku(pSyono);

        DsSyouhinBean dsSyouhinBean = SWAKInjector.getInstance(DsSyouhinBean.class);

        dsSyouhinBean.setSyoNo(pSyono);
        dsSyouhinBean.setDsSyouhnbunruiKbn(C_DsSyouhnbunruiKbn.GKDTITIJIBRNK);

        DsGetSeigyo dsGetSeigyo = SWAKInjector.getInstance(DsGetSeigyo.class);

        GamenSeigyoBean gamenSeigyoBean = dsGetSeigyo.getGamenSeigyo(dsSyouhinBean);

        if (C_ErrorKbn.ERROR.eq(gamenSeigyoBean.getErrorKbn())) {

            getHzKykGikItijiNnknOutputBean.setIwsDsmsgcd(DwMessageCodeConstants.IWSDSMSGCD_011205);

            return getHzKykGikItijiNnknOutputBean;
        }

        HosyouBean hosyouBean = dsGetSeigyo.getHosyou(dsSyouhinBean);

        if (C_ErrorKbn.ERROR.eq(hosyouBean.getErrorKbn())) {

            getHzKykGikItijiNnknOutputBean.setIwsDsmsgcd(DwMessageCodeConstants.IWSDSMSGCD_011206);

            return getHzKykGikItijiNnknOutputBean;
        }

        TokuyakuBean tokuyakuBean = dsGetSeigyo.getTokuyaku(dsSyouhinBean);

        if (C_ErrorKbn.ERROR.eq(tokuyakuBean.getErrorKbn())) {

            getHzKykGikItijiNnknOutputBean.setIwsDsmsgcd(DwMessageCodeConstants.IWSDSMSGCD_011207);

            return getHzKykGikItijiNnknOutputBean;
        }

        SyoriKahiBean syoriKahiBean = dsGetSeigyo.getSyoriKahi(dsSyouhinBean);

        if (C_ErrorKbn.ERROR.eq(syoriKahiBean.getErrorKbn())) {

            getHzKykGikItijiNnknOutputBean.setIwsDsmsgcd(DwMessageCodeConstants.IWSDSMSGCD_011208);

            return getHzKykGikItijiNnknOutputBean;
        }

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(pSyono);

        if (kykKihon == null) {

            getHzKykGikItijiNnknOutputBean.setIwsDsmsgcd(DwMessageCodeConstants.IWSDSMSGCD_011200);

            return getHzKykGikItijiNnknOutputBean;
        }

        List<IT_KykSyouhn> kykSyouhnList = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        if (kykSyouhnList == null || kykSyouhnList.size() == 0) {

            getHzKykGikItijiNnknOutputBean.setIwsDsmsgcd(DwMessageCodeConstants.IWSDSMSGCD_011209);

            return getHzKykGikItijiNnknOutputBean;
        }

        IT_KykSyouhn kykSyouhn = kykSyouhnList.get(0);

        BM_SyouhnZokusei syouhnZokusei = kykSyouhn.getSyouhnZokusei();

        if (syouhnZokusei == null) {

            getHzKykGikItijiNnknOutputBean.setIwsDsmsgcd(DwMessageCodeConstants.IWSDSMSGCD_011210);

            return getHzKykGikItijiNnknOutputBean;
        }

        List<IT_NyknJissekiRireki> nyknJissekiRirekiLst = kykKihon.getNyknJissekiRirekisByNykkeiro(C_Nykkeiro.SKEI);

        if (nyknJissekiRirekiLst == null || nyknJissekiRirekiLst.size() == 0) {

            getHzKykGikItijiNnknOutputBean.setIwsDsmsgcd(DwMessageCodeConstants.IWSDSMSGCD_011211);

            return getHzKykGikItijiNnknOutputBean;
        }

        IT_NyknJissekiRireki nyknJissekiRireki = nyknJissekiRirekiLst.get(0);

        IT_KykSonotaTkyk kykSonotaTkyk = null;

        try {
            kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        } catch (EntityNotFoundException entityNotFoundException){
        }

        if (kykSonotaTkyk == null) {

            getHzKykGikItijiNnknOutputBean.setIwsDsmsgcd(DwMessageCodeConstants.IWSDSMSGCD_011212);

            return getHzKykGikItijiNnknOutputBean;
        }

        BM_SisuuKihon sisuuKihon = bizDomManager.getSisuuKihon(kykSyouhn.getSisuukbn());

        if (sisuuKihon == null) {

            getHzKykGikItijiNnknOutputBean.setIwsDsmsgcd(DwMessageCodeConstants.IWSDSMSGCD_011213);

            return getHzKykGikItijiNnknOutputBean;
        }


        GetKawaseRate getKawaseRate = SWAKInjector.getInstance(GetKawaseRate.class);

        BizDate sysDate = BizDate.getSysDate();

        C_ErrorKbn getKawaseRateErrorKbnSakusei = getKawaseRate.exec(
            sysDate,
            C_KawaserateSyuruiKbn.KOUJIKAWASERATE,
            kykSyouhn.getKyktuukasyu(),
            C_Tuukasyu.JPY,
            C_KawasetekiyoKbn.TTM,
            C_KawasetsryKbn.SYUKKINRATE,
            C_EigyoubiHoseiKbn.BLNK,
            C_YouhiKbn.YOU);

        BizNumber kawaseRateSakusei = BizNumber.ZERO;
        BizDate kawaseRateKjYmdSakusei = null;

        if (C_ErrorKbn.OK.eq(getKawaseRateErrorKbnSakusei)) {

            kawaseRateSakusei = getKawaseRate.getKawaserate();
            kawaseRateKjYmdSakusei = getKawaseRate.getKwsrateKjYmd();
        }

        C_ErrorKbn getKawaseRateErrorKbnRy = getKawaseRate.exec(
            nyknJissekiRireki.getRyosyuymd(),
            C_KawaserateSyuruiKbn.KOUJIKAWASERATE,
            kykSyouhn.getKyktuukasyu(),
            C_Tuukasyu.JPY,
            C_KawasetekiyoKbn.TTM,
            C_KawasetsryKbn.NYUKINRATE,
            C_EigyoubiHoseiKbn.YOKUEIGYOUBI,
            C_YouhiKbn.HUYOU);

        BizNumber kawaseRateRy = BizNumber.ZERO;
        BizDate kawaseRateKjYmdRy = null;

        if (C_ErrorKbn.OK.eq(getKawaseRateErrorKbnRy)) {

            kawaseRateRy = getKawaseRate.getKawaserate();
            kawaseRateKjYmdRy = getKawaseRate.getKwsrateKjYmd();
        }


        BizNumber kwsrateRyymdjitenStigi = BizNumber.ZERO;
        BizDate kwsrateKjYmdRyymdjitenStigi = null;

        if (C_UmuKbn.ARI.eq(kykSonotaTkyk.getGaikanykntkhkumu())) {

            kwsrateRyymdjitenStigi = nyknJissekiRireki.getRyosyukwsrate();
            kwsrateKjYmdRyymdjitenStigi = nyknJissekiRireki.getRyosyukwsratekjymd();
        }


        CalcHkShrKngk calcHkShrKngk = SWAKInjector.getInstance(CalcHkShrKngk.class);

        C_ErrorKbn keisanWExt = calcHkShrKngk.execByKeisanWExt(
            pSyono,
            sysDate,
            C_SiinKbn.SP,
            C_HokenkinsyuruiKbn.SBHOKENKIN,
            kykKihon.getSdpdkbn(),
            kykKihon.getHrkkeiro());

        CalcHkShrKngkBean calcHkShrKngkBean = calcHkShrKngk.getCalcHkShrKngkBean();

        BizCurrency ptumitaTekinKyktuuka = BizCurrency.valueOf(0);

        BizCurrency kaiyakuHrkeiKyktuuka = BizCurrency.valueOf(0);

        BizCurrency sibohknkngkKyktuuka = BizCurrency.valueOf(0);

        BizCurrency pTmttkngkyKyktuukaTiritu = BizCurrency.valueOf(0);

        BizCurrency pTmttkngkyKyktuukaSisuu = BizCurrency.valueOf(0);

        if (C_ErrorKbn.OK.eq(keisanWExt)) {

            ptumitaTekinKyktuuka = calcHkShrKngkBean.getTmttKnGk();

            kaiyakuHrkeiKyktuuka = calcHkShrKngkBean.getKaiyakuhenreiknGk();

            sibohknkngkKyktuuka = calcHkShrKngkBean.getSibousGk();

            pTmttkngkyKyktuukaTiritu = calcHkShrKngkBean.getTeirituTmttkngk();

            pTmttkngkyKyktuukaSisuu = calcHkShrKngkBean.getSisuurendouTmttkngk();
        }


        BizCurrency ptumitaTekinEn = BizCurrency.valueOf(0);

        BizCurrency kaiyakuHrkeiEn = BizCurrency.valueOf(0);

        BizCurrency sibohknkngkEn = BizCurrency.valueOf(0);

        BizCurrency pTmttkngkyEnTiritu = BizCurrency.valueOf(0);

        BizCurrency pTmttkngkyEnSisuu = BizCurrency.valueOf(0);

        if (C_ErrorKbn.OK.eq(keisanWExt)) {

            KeisanGaikakanzan keisanGaikakanzan = SWAKInjector.getInstance(KeisanGaikakanzan.class);

            ptumitaTekinEn = keisanGaikakanzan.exec(
                C_Tuukasyu.JPY,
                ptumitaTekinKyktuuka,
                kawaseRateSakusei,
                C_HasuusyoriKbn.AGE);

            kaiyakuHrkeiEn = keisanGaikakanzan.exec(
                C_Tuukasyu.JPY,
                kaiyakuHrkeiKyktuuka,
                kawaseRateSakusei,
                C_HasuusyoriKbn.AGE);

            sibohknkngkEn = keisanGaikakanzan.exec(
                C_Tuukasyu.JPY,
                sibohknkngkKyktuuka,
                kawaseRateSakusei,
                C_HasuusyoriKbn.AGE);

            pTmttkngkyEnTiritu = keisanGaikakanzan.exec(
                C_Tuukasyu.JPY,
                pTmttkngkyKyktuukaTiritu,
                kawaseRateSakusei,
                C_HasuusyoriKbn.AGE);

            pTmttkngkyEnSisuu = keisanGaikakanzan.exec(
                C_Tuukasyu.JPY,
                pTmttkngkyKyktuukaSisuu,
                kawaseRateSakusei,
                C_HasuusyoriKbn.AGE);
        }


        BizCurrency rsgakuYen = BizCurrency.valueOf(0);

        if (C_UmuKbn.ARI.eq(kykSonotaTkyk.getYennykntkhkumu())) {

            rsgakuYen = nyknJissekiRireki.getRsgaku();
        }

        BizCurrency rsgakuStigi = BizCurrency.valueOf(0);

        if (C_UmuKbn.ARI.eq(kykSonotaTkyk.getGaikanykntkhkumu())) {

            rsgakuStigi = nyknJissekiRireki.getRsgaku();
        }

        Integer mkhgkWari = Integer.valueOf(0);

        if (C_UmuKbn.ARI.eq(kykSonotaTkyk.getTargettkhkumu())) {

            mkhgkWari = kykSonotaTkyk.getTargettkmokuhyouti();
        }

        BizCurrency endtKijyungk = BizCurrency.valueOf(0);

        if (C_ErrorKbn.OK.eq(getKawaseRateErrorKbnRy)) {

            if (C_UmuKbn.ARI.eq(kykSonotaTkyk.getTargettkhkumu())) {

                endtKijyungk = kykSonotaTkyk.getTargettkykkijyungk();
            }
        }


        String nnenkinSyu = "";

        if (C_Nenkinsyu.KAKUTEINENKIN.eq(kykSyouhn.getNksyukbn())) {

            nnenkinSyu = kykSyouhn.getNenkinkkn() + "年" + kykSyouhn.getNksyukbn().getContent();
        }

        else if (C_Nenkinsyu.SGKHSYSYSNNENKIN.eq(kykSyouhn.getNksyukbn())) {

            nnenkinSyu = kykSyouhn.getNksyukbn().getContent();
        }


        int hhknStartnen = 0;

        SetNenrei setNenrei = SWAKInjector.getInstance(SetNenrei.class);

        hhknStartnen = setNenrei.exec(
            kykSyouhn.getHknkknmanryouymd(),
            hihokensyaBean.getHhknseiYmd()
            );


        BizNumber haibunwariteiritu = BizNumber.ZERO;

        BizNumber haibunwarisisuu = BizNumber.ZERO;

        if (C_TmttknhaibunjyoutaiKbn.TEIRITU_ONLY.eq(kykSyouhn.getTmttknhaibunjyoutai())) {

            haibunwariteiritu = BizNumber.valueOf(100);
        }

        else if (C_TmttknhaibunjyoutaiKbn.SISUU_ONLY.eq(kykSyouhn.getTmttknhaibunjyoutai())) {

            haibunwarisisuu = BizNumber.valueOf(100);
        }

        else {

            haibunwariteiritu = BizNumber.valueOf(100).subtract(kykSyouhn.getKykjisisuurendourate());

            haibunwarisisuu = kykSyouhn.getKykjisisuurendourate();

        }


        BizDate tumitatekinitenyoteibi = null;

        SetOutoubi setOutoubi = SWAKInjector.getInstance(SetOutoubi.class);

        tumitatekinitenyoteibi = setOutoubi.exec(
            C_TykzentykgoKbn.TYKGO,
            keiyakuKihonBean.getKykYmd(),
            C_Hrkkaisuu.NEN,
            sysDate);


        DsTumitatekinItenCheck dsTumitatekinItenCheck = SWAKInjector.getInstance(DsTumitatekinItenCheck.class);

        C_UmuKbn tmttknItnTtdkUmuKbn = dsTumitatekinItenCheck.checkDsTumitatekinItenUketukeUmu(pSyono);

        BizCurrency syourainkgnsGaika = null;
        C_ErrorKbn syrnkgnshyjchkrsltKbn = C_ErrorKbn.OK;

        DsTumitatekinItenCheckResultBean dsTumitatekinItenCheckResultBean = dsTumitatekinItenCheck.checkTumitatekinIten(
            pSyono, sysDate, tumitatekinitenyoteibi);

        C_DsTmttknitenchkkekkaKbn dsTmttknitenchkkekkaKbn = dsTumitatekinItenCheckResultBean.getDsTmttknitenchkkekkaKbn();

        if (C_DsTmttknitenchkkekkaKbn.BLNK.eq(dsTmttknitenchkkekkaKbn) ||
            C_DsTmttknitenchkkekkaKbn.HOZENJYOUTAI.eq(dsTmttknitenchkkekkaKbn) ||
            C_DsTmttknitenchkkekkaKbn.TETUDUKITYUUI.eq(dsTmttknitenchkkekkaKbn)) {

            syrnkgnshyjchkrsltKbn = C_ErrorKbn.OK;
        }
        else {

            syrnkgnshyjchkrsltKbn = C_ErrorKbn.ERROR;
        }

        if (C_ErrorKbn.OK.eq(syrnkgnshyjchkrsltKbn)) {

            DsTeirituTumitatekinKeisan dsTeirituTumitatekinKeisan = SWAKInjector.getInstance(DsTeirituTumitatekinKeisan.class);

            C_ErrorKbn errorKbn = dsTeirituTumitatekinKeisan.keisanNkGnsGk(pSyono, sysDate, kykSyouhn, kykSonotaTkyk);

            if (C_ErrorKbn.OK.eq(errorKbn)) {

                syourainkgnsGaika = dsTeirituTumitatekinKeisan.getNkGnsGk();
            }
        }


        BizNumber tumitateriritu = BizNumber.ZERO;

        if (kykSyouhn.getTumitateriritu() != null) {

            tumitateriritu = kykSyouhn.getTumitateriritu().multiply(100);

        }


        BizNumber setteibairitu = BizNumber.ZERO;

        if (kykSyouhn.getSetteibairitu() != null) {

            setteibairitu = kykSyouhn.getSetteibairitu();

        }


        BizNumber tmttknzkrtjygn = BizNumber.ZERO;

        if (kykSyouhn.getTmttknzoukaritujygn() != null) {

            tmttknzkrtjygn = kykSyouhn.getTmttknzoukaritujygn().multiply(100);

        }


        BizNumber rendouRitu = BizNumber.ZERO;

        if (kykSyouhn.getRendouritu() != null) {

            rendouRitu = kykSyouhn.getRendouritu().multiply(100);
        }


        BizCurrency teikishrKin = BizCurrency.valueOf(0);
        C_Tuukasyu teikishrkinshrTuukasyu = C_Tuukasyu.JPY;

        //        if (C_UmuKbn.ARI.eq(kykSonotaTkyk.getTeikishrtkykhukaumu())) {
        //
        //            KeisanTeikishrkin keisanTeikishrkin = SWAKInjector.getInstance(KeisanTeikishrkin.class);
        //
        //            keisanTeikishrkin.exec(kykSyouhn.getKihons(), kykSyouhn.getTeikishrritu());
        //            teikishrKin = keisanTeikishrkin.getTeikishrkin();
        //            teikishrkinshrTuukasyu = kykSonotaTkyk.getTeikishrkinshrtuukasyu();
        //        }

        C_KouzasyuruiKbn kzsyuruikbnTkskz = C_KouzasyuruiKbn.BLNK;
        String bankcdTkskz = "";
        String sitencdTkskz = "";
        String banknmkjTkskz = "";
        String sitennmkjTkskz = "";
        C_YokinKbn yokinkbnTkskz = C_YokinKbn.BLNK;
        String kouzanoTkskz = "";
        String kzmeiginmknTkskz = "";

        C_ErrorKbn uketoriKouzaErrorKbn = dsGetKeiyakuCommon.getUketoriKouza(pSyono);

        if (C_ErrorKbn.OK.eq(uketoriKouzaErrorKbn)) {

            List<UketoriKouzaBean> uketoriKouzaBeanList = dsGetKeiyakuCommon.getUketoriKouzaBeanList();

            for (UketoriKouzaBean uketoriKouzaBean : uketoriKouzaBeanList) {

                C_UktsyuKbn uktsyuKbn = uketoriKouzaBean.getUktsyuKbn();

                if (C_UktsyuKbn.TKSHKUKT.eq(uktsyuKbn)) {

                    kzsyuruikbnTkskz = uketoriKouzaBean.getKzsyuruiKbn();
                    bankcdTkskz = uketoriKouzaBean.getBankCd();
                    sitencdTkskz = uketoriKouzaBean.getSitenCd();
                    banknmkjTkskz = uketoriKouzaBean.getBankNmkj();
                    sitennmkjTkskz = uketoriKouzaBean.getSitenNmkj();
                    yokinkbnTkskz = uketoriKouzaBean.getYokinKbn();
                    kouzanoTkskz= uketoriKouzaBean.getKouzaNo();
                    kzmeiginmknTkskz = uketoriKouzaBean.getKzmeigiNmkn();
                }
            }
        }


        getHzKykGikItijiNnknOutputBean.setIwsDsmsgcd(DwMessageCodeConstants.IWSDSMSGCD_011000);

        getHzKykGikItijiNnknOutputBean.setIwsSyono(pSyono);

        getHzKykGikItijiNnknOutputBean.setIwsAisyoumei(keiyakuKihonBean.getAisyoumeiKbn().getContent());

        getHzKykGikItijiNnknOutputBean.setIwsSyouhnnm(keiyakuKihonBean.getSyouhnNm());

        getHzKykGikItijiNnknOutputBean.setIwsKykymdstr(dateToStr(keiyakuKihonBean.getKykYmd()));

        getHzKykGikItijiNnknOutputBean.setIwsKyktuukasyu(keiyakuKihonBean.getKykTuukasyu().getValue());

        getHzKykGikItijiNnknOutputBean.setIwsSakuseikijyunymdstr(dateToStr(keiyakuKihonBean.getSakuseiKijyunYmd()));

        getHzKykGikItijiNnknOutputBean.setIwsKyknmkn(keiyakusyaBean.getKykNmKn());

        getHzKykGikItijiNnknOutputBean.setIwsKyknmkj(keiyakusyaBean.getKykNmKj());

        getHzKykGikItijiNnknOutputBean.setIwsKykseiymdstr(dateToStr(keiyakusyaBean.getKykseiYmd()));

        getHzKykGikItijiNnknOutputBean.setIwsKyksei(keiyakusyaBean.getKyksei().getValue());

        getHzKykGikItijiNnknOutputBean.setIwsHhknnmkn(hihokensyaBean.getHhknNmKn());

        getHzKykGikItijiNnknOutputBean.setIwsHhknseiymdstr(dateToStr(hihokensyaBean.getHhknseiYmd()));

        getHzKykGikItijiNnknOutputBean.setIwsSbuktnin(String.valueOf(keiyakuUketorininBean.getSbuktnin()));

        getHzKykGikItijiNnknOutputBean.setIwsUktmidasikbn1(keiyakuUketorininBean.getUktsyuKbn1().getValue());

        getHzKykGikItijiNnknOutputBean.setIwsUktkbn1str(keiyakuUketorininBean.getGkdtKoktuutiUktKbn1().getValue());

        getHzKykGikItijiNnknOutputBean.setIwsUktsimei1(keiyakuUketorininBean.getUktNm1());

        getHzKykGikItijiNnknOutputBean.setIwsUktmidasikbn2(keiyakuUketorininBean.getUktsyuKbn2().getValue());

        getHzKykGikItijiNnknOutputBean.setIwsUktkbn2str(keiyakuUketorininBean.getGkdtKoktuutiUktKbn2().getValue());

        getHzKykGikItijiNnknOutputBean.setIwsUktsimei2(keiyakuUketorininBean.getUktNm2());

        getHzKykGikItijiNnknOutputBean.setIwsUktmidasikbn3(keiyakuUketorininBean.getUktsyuKbn3().getValue());

        getHzKykGikItijiNnknOutputBean.setIwsUktkbn3str(keiyakuUketorininBean.getGkdtKoktuutiUktKbn3().getValue());

        getHzKykGikItijiNnknOutputBean.setIwsUktsimei3(keiyakuUketorininBean.getUktNm3());

        getHzKykGikItijiNnknOutputBean.setIwsUktmidasikbn4(keiyakuUketorininBean.getUktsyuKbn4().getValue());

        getHzKykGikItijiNnknOutputBean.setIwsUktkbn4str(keiyakuUketorininBean.getGkdtKoktuutiUktKbn4().getValue());

        getHzKykGikItijiNnknOutputBean.setIwsUktsimei4(keiyakuUketorininBean.getUktNm4());

        getHzKykGikItijiNnknOutputBean.setIwsUktmidasikbn5(keiyakuUketorininBean.getUktsyuKbn5().getValue());

        getHzKykGikItijiNnknOutputBean.setIwsUktkbn5str(keiyakuUketorininBean.getGkdtKoktuutiUktKbn5().getValue());

        getHzKykGikItijiNnknOutputBean.setIwsUktsimei5(keiyakuUketorininBean.getUktNm5());

        getHzKykGikItijiNnknOutputBean.setIwsUktmidasikbn6(keiyakuUketorininBean.getUktsyuKbn6().getValue());

        getHzKykGikItijiNnknOutputBean.setIwsUktkbn6str(keiyakuUketorininBean.getGkdtKoktuutiUktKbn6().getValue());

        getHzKykGikItijiNnknOutputBean.setIwsUktsimei6(keiyakuUketorininBean.getUktNm6());

        getHzKykGikItijiNnknOutputBean.setIwsUktmidasikbn7(keiyakuUketorininBean.getUktsyuKbn7().getValue());

        getHzKykGikItijiNnknOutputBean.setIwsUktkbn7str(keiyakuUketorininBean.getGkdtKoktuutiUktKbn7().getValue());

        getHzKykGikItijiNnknOutputBean.setIwsUktsimei7(keiyakuUketorininBean.getUktNm7());

        getHzKykGikItijiNnknOutputBean.setIwsUktmidasikbn8(keiyakuUketorininBean.getUktsyuKbn8().getValue());

        getHzKykGikItijiNnknOutputBean.setIwsUktkbn8str(keiyakuUketorininBean.getGkdtKoktuutiUktKbn8().getValue());

        getHzKykGikItijiNnknOutputBean.setIwsUktsimei8(keiyakuUketorininBean.getUktNm8());

        getHzKykGikItijiNnknOutputBean.setIwsUktmidasikbn9(keiyakuUketorininBean.getUktsyuKbn9().getValue());

        getHzKykGikItijiNnknOutputBean.setIwsUktkbn9str(keiyakuUketorininBean.getGkdtKoktuutiUktKbn9().getValue());

        getHzKykGikItijiNnknOutputBean.setIwsUktsimei9(keiyakuUketorininBean.getUktNm9());

        getHzKykGikItijiNnknOutputBean.setIwsUktmidasikbn10(keiyakuUketorininBean.getUktsyuKbn10().getValue());

        getHzKykGikItijiNnknOutputBean.setIwsUktkbn10str(keiyakuUketorininBean.getGkdtKoktuutiUktKbn10().getValue());

        getHzKykGikItijiNnknOutputBean.setIwsUktsimei10(keiyakuUketorininBean.getUktNm10());

        getHzKykGikItijiNnknOutputBean.setIwsTrkkzknmkn1(trkKazokuBean.getTrkkzknmKn1());

        getHzKykGikItijiNnknOutputBean.setIwsTrkkzknmkn2(trkKazokuBean.getTrkkzknmKn2());

        getHzKykGikItijiNnknOutputBean.setIwsTutakinumukbn(gamenSeigyoBean.getTutakinUmukbn().getValue());

        getHzKykGikItijiNnknOutputBean.setIwsKaiyakuhrsuiiumukbn(gamenSeigyoBean.getKaiyakuHrsuiiUmuKbn().getValue());

        getHzKykGikItijiNnknOutputBean.setIwsSbhsyumukbn(hosyouBean.getSbHsyUmuKbn().getValue());

        getHzKykGikItijiNnknOutputBean.setIwsKghsyumukbn(hosyouBean.getKgHsyUmukbn().getValue());

        getHzKykGikItijiNnknOutputBean.setIwsIryhsyumukbn(hosyouBean.getIryHsyUmukbn().getValue());

        getHzKykGikItijiNnknOutputBean.setIwsRougohsyumukbn(hosyouBean.getRougoHsyUmukbn().getValue());

        getHzKykGikItijiNnknOutputBean.setIwsKykdrtkhkumu(tokuyakuBean.getKykdrTkykhukaumu().getValue());

        getHzKykGikItijiNnknOutputBean.setIwsStdrsktkyhkumu(tokuyakuBean.getStdrskTkyhkumu().getValue());

        getHzKykGikItijiNnknOutputBean.setIwsYennykntkhkumu(tokuyakuBean.getYenNyknThkumu().getValue());

        getHzKykGikItijiNnknOutputBean.setIwsGaikanykntkhkumu(tokuyakuBean.getGaikaNyknTkhkumu().getValue());

        getHzKykGikItijiNnknOutputBean.setIwsTargettkhkumu(tokuyakuBean.getTargetTkhkumu().getValue());

        getHzKykGikItijiNnknOutputBean.setIwsSyksbyensitihsyutyhkumu(
            tokuyakuBean.getInitSbjiYenSitiHsyTkhukaumu().getValue());

        getHzKykGikItijiNnknOutputBean.setIwsJyudkaigomehrtkhkumu(
            tokuyakuBean.getJyudKaigoMeharaiTkhukaumu().getValue());

        getHzKykGikItijiNnknOutputBean.setIwsZeiseitkkktkykhukaumu(tokuyakuBean.getZeiseiTkkkTkykhukaumu().getValue());

        getHzKykGikItijiNnknOutputBean.setIwsKjsmsaihakkoukahikbn(syoriKahiBean.getKjsmSaihakkouKahiKbn().getValue());

        getHzKykGikItijiNnknOutputBean.setIwsKykmeigihnkkahikbn(syoriKahiBean.getKykMeigihnkKahiKbn().getValue());

        getHzKykGikItijiNnknOutputBean.setIwsSyoukensaihkkahikbn(syoriKahiBean.getSyoukenSaihkKahiKbn().getValue());

        getHzKykGikItijiNnknOutputBean.setIwsStdrsktkytthkkahikbn(syoriKahiBean.getStdrskTkyTthkKahiKbn().getValue());

        getHzKykGikItijiNnknOutputBean.setIwsTargettkhkkahikbn(syoriKahiBean.getTargetTkhkKahiKbn().getValue());

        getHzKykGikItijiNnknOutputBean.setIwsKykniyusyoukaikahikbn(syoriKahiBean.getKykNiyuSyoukaiKahiKbn()
            .getValue());

        getHzKykGikItijiNnknOutputBean.setIwsTumitatekinitenkahikbn(
            syoriKahiBean.getTumitatekinItenKahiKbn().getValue());

        getHzKykGikItijiNnknOutputBean.setIwsDskaiyakukahikbn(syoriKahiBean.getDsKaiyakuKahiKbn().getValue());

        getHzKykGikItijiNnknOutputBean.setIwsAdrhenkoukahikbn(syoriKahiBean.getAdrHenkouKahiKbn().getValue());

        getHzKykGikItijiNnknOutputBean.setIwsPhrkhouhenkoukahikbn(syoriKahiBean.getPhrkhouHenkouKahiKbn().getValue());

        getHzKykGikItijiNnknOutputBean.setIwsSksikijyunymdkawaserate(kawaseRateSakusei.toString());

        getHzKykGikItijiNnknOutputBean.setIwsKwsratekijyunymdsakusei(dateToStr(kawaseRateKjYmdSakusei));

        getHzKykGikItijiNnknOutputBean.setIwsRsytuukasyu(nyknJissekiRireki.getRstuukasyu().getValue());

        getHzKykGikItijiNnknOutputBean.setIwsRsymdkawaserate(kawaseRateRy.toString());

        getHzKykGikItijiNnknOutputBean.setIwsRsymdkawaseratestigi(kwsrateRyymdjitenStigi.toString());

        getHzKykGikItijiNnknOutputBean.setIwsKwsratekijyunymdrs(dateToStr(kawaseRateKjYmdRy));

        getHzKykGikItijiNnknOutputBean.setIwsKwsratekijyunymdrsstigi(dateToStr(kwsrateKjYmdRyymdjitenStigi));

        getHzKykGikItijiNnknOutputBean.setIwsRsgakuyen(rsgakuYen.toAdsoluteString());

        getHzKykGikItijiNnknOutputBean.setIwsRsgakustigi(rsgakuStigi.toAdsoluteString());

        getHzKykGikItijiNnknOutputBean.setIwsKijyunkingaku(endtKijyungk.toAdsoluteString());

        getHzKykGikItijiNnknOutputBean.setIwsItijibrprsgaika(nyknJissekiRireki.getHrkp().toAdsoluteString());

        getHzKykGikItijiNnknOutputBean.setIwsMkhgkwari(mkhgkWari.toString());

        getHzKykGikItijiNnknOutputBean.setIwsHokenkngkksnkekkakbn(keisanWExt.getValue());

        getHzKykGikItijiNnknOutputBean.setIwsSueokikknstr(kykSyouhn.getHknkkn().toString());

        getHzKykGikItijiNnknOutputBean.setIwsNenkinsyustr(nnenkinSyu);

        getHzKykGikItijiNnknOutputBean.setIwsNenkinkkn(kykSyouhn.getNenkinkkn().toString());

        getHzKykGikItijiNnknOutputBean.setIwsNenkinstartymd(dateToStr(kykSyouhn.getHknkknmanryouymd()));

        getHzKykGikItijiNnknOutputBean.setIwsNenkinstartnen(String.valueOf(hhknStartnen));

        getHzKykGikItijiNnknOutputBean.setIwsKihonkyhgkgaika(kykSyouhn.getKihons().toAdsoluteString());

        getHzKykGikItijiNnknOutputBean.setIwsSbkyhgkyen(sibohknkngkEn.toAdsoluteString());

        getHzKykGikItijiNnknOutputBean.setIwsSbkyhgkgaika(sibohknkngkKyktuuka.toAdsoluteString());

        getHzKykGikItijiNnknOutputBean.setIwsPtumitatekngkyen(ptumitaTekinEn.toAdsoluteString());

        getHzKykGikItijiNnknOutputBean.setIwsPtumitatekngkgaika(ptumitaTekinKyktuuka.toAdsoluteString());

        getHzKykGikItijiNnknOutputBean.setIwsKaiyakuhryen(kaiyakuHrkeiEn.toAdsoluteString());

        getHzKykGikItijiNnknOutputBean.setIwsKaiyakuhrgaika(kaiyakuHrkeiKyktuuka.toAdsoluteString());

        getHzKykGikItijiNnknOutputBean.setIwsPtmttkngkyenteiritu(pTmttkngkyEnTiritu.toAdsoluteString());

        getHzKykGikItijiNnknOutputBean.setIwsPtmttkngkgaikateiritu(pTmttkngkyKyktuukaTiritu.toAdsoluteString());

        getHzKykGikItijiNnknOutputBean.setIwsHaibunwariteiritu(haibunwariteiritu.toString());

        getHzKykGikItijiNnknOutputBean.setIwsTumitateriritustr(BizUtil.num(String.valueOf(tumitateriritu),
            BizUtil.ZERO_FILL_LAST_ONLY, 3, BizUtil.ZERO_FILL, 2));

        getHzKykGikItijiNnknOutputBean.setIwsSisuusyu(sisuuKihon.getSisuunm());

        getHzKykGikItijiNnknOutputBean.setIwsPtmttkngkyensisuu(pTmttkngkyEnSisuu.toAdsoluteString());

        getHzKykGikItijiNnknOutputBean.setIwsPtmttkngkgaikasisuu(pTmttkngkyKyktuukaSisuu.toAdsoluteString());

        getHzKykGikItijiNnknOutputBean.setIwsHaibunwarisisuu(haibunwarisisuu.toString());

        getHzKykGikItijiNnknOutputBean.setIwsTmttknzkrt("");

        getHzKykGikItijiNnknOutputBean.setIwsSisuuupritu("");

        getHzKykGikItijiNnknOutputBean.setIwsSetteibairitustr(BizUtil.num(String.valueOf(setteibairitu),
            BizUtil.ZERO_FILL_LAST_ONLY, 1, BizUtil.ZERO_FILL, 2));

        getHzKykGikItijiNnknOutputBean.setIwsTumitatekinitenyoteibi(dateToStr(tumitatekinitenyoteibi));

        getHzKykGikItijiNnknOutputBean.setIwsTmttknitnttdkumukbn(tmttknItnTtdkUmuKbn.getValue());

        getHzKykGikItijiNnknOutputBean.setIwsTmttknzkrtjygnstr(BizUtil.num(String.valueOf(tmttknzkrtjygn),
            BizUtil.ZERO_FILL_LAST_ONLY, 3, BizUtil.ZERO_FILL, 2));

        getHzKykGikItijiNnknOutputBean.setIwsYakkanbunsyono(keiyakuKihonBean.getYakkanBunsyoNo());

        getHzKykGikItijiNnknOutputBean.setIwsRendouritustr(BizUtil.num(String.valueOf(rendouRitu),
            BizUtil.ZERO_FILL_LAST_ONLY, 3, BizUtil.ZERO_FILL, 2));

        getHzKykGikItijiNnknOutputBean.setIwsTeikishrtkykhukaumu(tokuyakuBean.getTeikiShrTkykhukaumu().getValue());

        getHzKykGikItijiNnknOutputBean.setIwsTeikisiharaikin(teikishrKin.toAdsoluteString());

        getHzKykGikItijiNnknOutputBean.setIwsTeikishrkinshrtuukasyu(teikishrkinshrTuukasyu.getValue());

        getHzKykGikItijiNnknOutputBean.setIwsKzsyuruikbn(kzsyuruikbnTkskz.getValue());

        getHzKykGikItijiNnknOutputBean.setIwsBankcd(bankcdTkskz);

        getHzKykGikItijiNnknOutputBean.setIwsSitencd(sitencdTkskz);

        getHzKykGikItijiNnknOutputBean.setIwsBanknmkj(banknmkjTkskz);

        getHzKykGikItijiNnknOutputBean.setIwsSitennmkj(sitennmkjTkskz);

        getHzKykGikItijiNnknOutputBean.setIwsYokinkbn(yokinkbnTkskz.getValue());

        getHzKykGikItijiNnknOutputBean.setIwsKouzano(kouzanoTkskz);

        getHzKykGikItijiNnknOutputBean.setIwsKzmeiginmkn(kzmeiginmknTkskz);

        getHzKykGikItijiNnknOutputBean.setIwsSyrnkgnshyjchkrsltkbn(syrnkgnshyjchkrsltKbn.getValue());

        getHzKykGikItijiNnknOutputBean.setIwsSyourainkgnsgaika(currencyToStr(syourainkgnsGaika));

        return getHzKykGikItijiNnknOutputBean;
    }

    private String dateToStr(BizDate pDate) {

        if (pDate == null) {
            return null;
        }

        return pDate.toString();
    }

    private String currencyToStr(BizCurrency pCurrency) {

        if (pCurrency == null) {

            return null;
        }

        return pCurrency.toAdsoluteString();
    }
}
