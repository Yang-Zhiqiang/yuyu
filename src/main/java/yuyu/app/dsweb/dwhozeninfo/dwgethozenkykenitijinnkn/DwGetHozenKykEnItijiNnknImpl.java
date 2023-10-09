package yuyu.app.dsweb.dwhozeninfo.dwgethozenkykenitijinnkn;

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

import yuyu.common.biz.bzcommon.SetNenrei;
import yuyu.common.biz.bzwebserviceaccesslogoutput.WebServiceAccesslogOutput;
import yuyu.common.direct.dscommon.DsDB2Util;
import yuyu.common.direct.dscommon.DsGetKeiyakuCommon;
import yuyu.common.direct.dscommon.DsGetSeigyo;
import yuyu.common.direct.dscommon.DsSyouhinBean;
import yuyu.common.direct.dscommon.GamenSeigyoBean;
import yuyu.common.direct.dscommon.HihokensyaBean;
import yuyu.common.direct.dscommon.HosyouBean;
import yuyu.common.direct.dscommon.KeiyakuKihonBean;
import yuyu.common.direct.dscommon.KeiyakuUketorininBean;
import yuyu.common.direct.dscommon.KeiyakusyaBean;
import yuyu.common.direct.dscommon.SyoriKahiBean;
import yuyu.common.direct.dscommon.TokuyakuBean;
import yuyu.common.direct.dscommon.TrkKazokuBean;
import yuyu.common.dsweb.dwcommon.DwMessageCodeConstants;
import yuyu.common.siharai.sicommon.CalcHkShrKngk;
import yuyu.common.siharai.sicommon.CalcHkShrKngkBean;
import yuyu.def.MessageId;
import yuyu.def.biz.bean.param.WsBzWebserviceReqParamBean;
import yuyu.def.biz.bean.param.WsBzWebserviceResParamBean;
import yuyu.def.classification.C_AccessLogSyubetuKbn;
import yuyu.def.classification.C_DsSyouhnbunruiKbn;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_HokenkinsyuruiKbn;
import yuyu.def.classification.C_Nenkinsyu;
import yuyu.def.classification.C_SiinKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.dsweb.bean.webservice.WsDwGetHozenKykEnItijiNnknInputBean;
import yuyu.def.dsweb.bean.webservice.WsDwGetHozenKykEnItijiNnknOutputBean;
import yuyu.def.hozen.manager.HozenDomManager;

/**
 * 保全契約詳細取得（円建一時払年金）サービスの実装クラスです。<br />
 */
public class DwGetHozenKykEnItijiNnknImpl implements DwGetHozenKykEnItijiNnkn {

    @Inject
    private static Logger logger;

    @Inject
    private HozenDomManager hozenDomManager;

    @Override
    public WsBzWebserviceResParamBean execPostForm(MultivaluedMap<String, String> pMap) {

        logger.info(MessageUtil.getMessage(MessageId.IBF0016, MessageUtil.getMessage(MessageId.INW1026)));

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean;

        try {

            wsBzWebserviceResParamBean = getHozenKeiyakuEnItijiNnknMain(pMap);

        } catch (Exception throwable) {

            DsDB2Util dsDB2Util = SWAKInjector.getInstance(DsDB2Util.class);

            DsDB2Util.E_Result result = dsDB2Util.exec(throwable);

            String dsmsgcd = "";

            if (DsDB2Util.E_Result.DEADLOCK.compareTo(result) == 0) {
                dsmsgcd = DwMessageCodeConstants.IWSDSMSGCD_019212;
            }
            else if (DsDB2Util.E_Result.QUERY_TIMEOUT.compareTo(result) == 0) {
                dsmsgcd = DwMessageCodeConstants.IWSDSMSGCD_019211;
            }
            else if (DsDB2Util.E_Result.OTHER.compareTo(result) == 0) {
                throw throwable;
            }

            WsDwGetHozenKykEnItijiNnknOutputBean wsDwGetHozenKykEnItijiNnknOutputBean =
                SWAKInjector.getInstance(WsDwGetHozenKykEnItijiNnknOutputBean.class);
            wsBzWebserviceResParamBean = SWAKInjector.getInstance(WsBzWebserviceResParamBean.class);
            wsDwGetHozenKykEnItijiNnknOutputBean.setIwsDsmsgcd(dsmsgcd);
            wsBzWebserviceResParamBean.setGyoumuData(JSON.encode(wsDwGetHozenKykEnItijiNnknOutputBean));
        } finally {
            logger.info(MessageUtil.getMessage(MessageId.IBF0017, MessageUtil.getMessage(MessageId.INW1026)));
        }

        return wsBzWebserviceResParamBean;

    }

    @Transactional
    WsBzWebserviceResParamBean getHozenKeiyakuEnItijiNnknMain(MultivaluedMap<String, String> pMap) {

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

        WsDwGetHozenKykEnItijiNnknInputBean WsDwGetHozenKeiyakuEnItijiNenkinInputBean =
            JSON.decode(gyoumuData, WsDwGetHozenKykEnItijiNnknInputBean.class);

        WebServiceAccesslogOutput webServiceAccesslogOutput =
            SWAKInjector.getInstance(WebServiceAccesslogOutput.class);
        webServiceAccesslogOutput.exec(C_AccessLogSyubetuKbn.ACTION_BEGIN,
            wsBzWebserviceReqParamBean, WsDwGetHozenKeiyakuEnItijiNenkinInputBean);

        WsDwGetHozenKykEnItijiNnknOutputBean wsDwGetHozenKykEnItijiNnknOutputBean =
            SWAKInjector.getInstance(WsDwGetHozenKykEnItijiNnknOutputBean.class);
        WsBzWebserviceResParamBean wsBzWebserviceResParamBean =
            SWAKInjector.getInstance(WsBzWebserviceResParamBean.class);

        boolean chkRet = WsDwGetHozenKeiyakuEnItijiNenkinInputBean.chkInput();
        if (!chkRet) {
            wsDwGetHozenKykEnItijiNnknOutputBean.setIwsDsmsgcd(DwMessageCodeConstants.IWSDSMSGCD_019100);
            wsBzWebserviceResParamBean.setGyoumuData(JSON.encode(wsDwGetHozenKykEnItijiNnknOutputBean));

            return wsBzWebserviceResParamBean;
        }

        Validator validator = SWAKInjector.getInstance(Validator.class);
        Set<ConstraintViolation<WsDwGetHozenKykEnItijiNnknInputBean>> chkKekkaSet =
            validator.validate(WsDwGetHozenKeiyakuEnItijiNenkinInputBean);

        if (chkKekkaSet.size() > 0) {
            wsDwGetHozenKykEnItijiNnknOutputBean.setIwsDsmsgcd(DwMessageCodeConstants.IWSDSMSGCD_019100);
            wsBzWebserviceResParamBean.setGyoumuData(JSON.encode(wsDwGetHozenKykEnItijiNnknOutputBean));

            return wsBzWebserviceResParamBean;
        }

        wsDwGetHozenKykEnItijiNnknOutputBean = getHozenKeiyakuEnItijiNnkn(
            WsDwGetHozenKeiyakuEnItijiNenkinInputBean.getIwsSyono());

        wsBzWebserviceResParamBean.setGyoumuData(JSON.encode(wsDwGetHozenKykEnItijiNnknOutputBean));

        return wsBzWebserviceResParamBean;
    }

    private WsDwGetHozenKykEnItijiNnknOutputBean getHozenKeiyakuEnItijiNnkn(String pSyoNo) {

        WsDwGetHozenKykEnItijiNnknOutputBean wsDwGetHozenKykEnItijiNnknOutputBean = SWAKInjector
            .getInstance(WsDwGetHozenKykEnItijiNnknOutputBean.class);

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(pSyoNo);

        if (kykKihon == null) {

            wsDwGetHozenKykEnItijiNnknOutputBean.setIwsDsmsgcd(DwMessageCodeConstants.IWSDSMSGCD_019200);
            return wsDwGetHozenKykEnItijiNnknOutputBean;
        }

        DsGetKeiyakuCommon dsGetKeiyakuCommon = SWAKInjector.getInstance(DsGetKeiyakuCommon.class);

        KeiyakuKihonBean keiyakuKihonBean = dsGetKeiyakuCommon.getKykKihon(pSyoNo);
        if (C_ErrorKbn.ERROR.eq(keiyakuKihonBean.getErrorKbn())) {

            wsDwGetHozenKykEnItijiNnknOutputBean.setIwsDsmsgcd(DwMessageCodeConstants.IWSDSMSGCD_019201);
            return wsDwGetHozenKykEnItijiNnknOutputBean;

        }

        KeiyakusyaBean keiyakusyaBean = dsGetKeiyakuCommon.getKykSya(pSyoNo);
        if (C_ErrorKbn.ERROR.eq(keiyakusyaBean.getErrorKbn())) {

            wsDwGetHozenKykEnItijiNnknOutputBean.setIwsDsmsgcd(DwMessageCodeConstants.IWSDSMSGCD_019202);
            return wsDwGetHozenKykEnItijiNnknOutputBean;

        }

        HihokensyaBean hihokensyaBean = dsGetKeiyakuCommon.getHhknSya(pSyoNo);
        if (C_ErrorKbn.ERROR.eq(hihokensyaBean.getErrorKbn())) {

            wsDwGetHozenKykEnItijiNnknOutputBean.setIwsDsmsgcd(DwMessageCodeConstants.IWSDSMSGCD_019203);
            return wsDwGetHozenKykEnItijiNnknOutputBean;

        }

        KeiyakuUketorininBean keiyakuUketorininBean = dsGetKeiyakuCommon.getKykUkt(pSyoNo);
        if (C_ErrorKbn.ERROR.eq(keiyakuUketorininBean.getErrorKbn())) {

            wsDwGetHozenKykEnItijiNnknOutputBean.setIwsDsmsgcd(DwMessageCodeConstants.IWSDSMSGCD_019204);
            return wsDwGetHozenKykEnItijiNnknOutputBean;

        }

        TrkKazokuBean trkKazokuBean = dsGetKeiyakuCommon.getTrkKazoku(pSyoNo);

        DsGetSeigyo dsGetSeigyo = SWAKInjector.getInstance(DsGetSeigyo.class);

        DsSyouhinBean dsSyouhinBean = SWAKInjector.getInstance(DsSyouhinBean.class);
        dsSyouhinBean.setSyoNo(pSyoNo);
        dsSyouhinBean.setDsSyouhnbunruiKbn(C_DsSyouhnbunruiKbn.YENDTITIJIBRNK);

        GamenSeigyoBean gamenSeigyoBean = dsGetSeigyo.getGamenSeigyo(dsSyouhinBean);
        if (C_ErrorKbn.ERROR.eq(gamenSeigyoBean.getErrorKbn())) {

            wsDwGetHozenKykEnItijiNnknOutputBean.setIwsDsmsgcd(DwMessageCodeConstants.IWSDSMSGCD_019205);
            return wsDwGetHozenKykEnItijiNnknOutputBean;

        }

        HosyouBean hosyouBean = dsGetSeigyo.getHosyou(dsSyouhinBean);
        if (C_ErrorKbn.ERROR.eq(hosyouBean.getErrorKbn())) {

            wsDwGetHozenKykEnItijiNnknOutputBean.setIwsDsmsgcd(DwMessageCodeConstants.IWSDSMSGCD_019206);
            return wsDwGetHozenKykEnItijiNnknOutputBean;

        }

        TokuyakuBean tokuyakuBean = dsGetSeigyo.getTokuyaku(dsSyouhinBean);
        if (C_ErrorKbn.ERROR.eq(tokuyakuBean.getErrorKbn())) {

            wsDwGetHozenKykEnItijiNnknOutputBean.setIwsDsmsgcd(DwMessageCodeConstants.IWSDSMSGCD_019207);
            return wsDwGetHozenKykEnItijiNnknOutputBean;

        }

        SyoriKahiBean syoriKahiBean = dsGetSeigyo.getSyoriKahi(dsSyouhinBean);
        if (C_ErrorKbn.ERROR.eq(syoriKahiBean.getErrorKbn())) {

            wsDwGetHozenKykEnItijiNnknOutputBean.setIwsDsmsgcd(DwMessageCodeConstants.IWSDSMSGCD_019208);
            return wsDwGetHozenKykEnItijiNnknOutputBean;

        }

        List<IT_KykSyouhn> kykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        if (kykSyouhnLst == null || kykSyouhnLst.size() == 0) {

            wsDwGetHozenKykEnItijiNnknOutputBean.setIwsDsmsgcd(DwMessageCodeConstants.IWSDSMSGCD_019209);
            return wsDwGetHozenKykEnItijiNnknOutputBean;

        }

        IT_KykSyouhn kykSyouhn = kykSyouhnLst.get(0);
        BM_SyouhnZokusei syouhnZokusei = kykSyouhn.getSyouhnZokusei();
        if (syouhnZokusei == null) {

            wsDwGetHozenKykEnItijiNnknOutputBean.setIwsDsmsgcd(DwMessageCodeConstants.IWSDSMSGCD_019210);
            return wsDwGetHozenKykEnItijiNnknOutputBean;

        }

        CalcHkShrKngk calcHkShrKngk = SWAKInjector.getInstance(CalcHkShrKngk.class);
        BizDate sysDate = BizDate.getSysDate();

        C_ErrorKbn errorKbn = calcHkShrKngk.execByKeisanWExt(
            kykKihon.getSyono(),
            sysDate,
            C_SiinKbn.SP,
            C_HokenkinsyuruiKbn.SBHOKENKIN,
            kykKihon.getSdpdkbn(),
            kykKihon.getHrkkeiro());

        CalcHkShrKngkBean calcHkShrKngkBean = calcHkShrKngk.getCalcHkShrKngkBean();

        BizCurrency ptumitaTekinEn = BizCurrency.valueOf(0);
        BizCurrency kaiyakuhrkngakyen = BizCurrency.valueOf(0);
        BizCurrency sbhkyhkngkyen = BizCurrency.valueOf(0);


        if (C_ErrorKbn.OK.eq(errorKbn)) {
            ptumitaTekinEn = calcHkShrKngkBean.getTmttKnGk();
            kaiyakuhrkngakyen = calcHkShrKngkBean.getKaiyakuhenreiknGk();
            sbhkyhkngkyen = calcHkShrKngkBean.getSibousGk();

        }

        String nenkinSyu = "";

        if (C_Nenkinsyu.KAKUTEINENKIN.eq(kykSyouhn.getNksyukbn())) {

            nenkinSyu = kykSyouhn.getNenkinkkn() + "年" + kykSyouhn.getNksyukbn().getContent();
        }

        else if (C_Nenkinsyu.SGKHSYSYSNNENKIN.eq(kykSyouhn.getNksyukbn())) {

            nenkinSyu = kykSyouhn.getNksyukbn().getContent();
        }

        int hhknStartnen = 0;

        SetNenrei setNenrei = SWAKInjector.getInstance(SetNenrei.class);

        hhknStartnen = setNenrei.exec(
            kykSyouhn.getHknkknmanryouymd(),
            hihokensyaBean.getHhknseiYmd()
            );

        wsDwGetHozenKykEnItijiNnknOutputBean.setIwsDsmsgcd(DwMessageCodeConstants.IWSDSMSGCD_019000);
        wsDwGetHozenKykEnItijiNnknOutputBean.setIwsSyono(pSyoNo);
        wsDwGetHozenKykEnItijiNnknOutputBean.setIwsAisyoumei(keiyakuKihonBean.getAisyoumeiKbn().getContent());
        wsDwGetHozenKykEnItijiNnknOutputBean.setIwsSyouhnnm(keiyakuKihonBean.getSyouhnNm());
        wsDwGetHozenKykEnItijiNnknOutputBean.setIwsKykymdstr(dateToStr(keiyakuKihonBean.getKykYmd()));
        wsDwGetHozenKykEnItijiNnknOutputBean.setIwsKyktuukasyu(keiyakuKihonBean.getKykTuukasyu().getValue());
        wsDwGetHozenKykEnItijiNnknOutputBean.setIwsSakuseikijyunymdstr(dateToStr(keiyakuKihonBean.getSakuseiKijyunYmd()));
        wsDwGetHozenKykEnItijiNnknOutputBean.setIwsKyknmkn(keiyakusyaBean.getKykNmKn());
        wsDwGetHozenKykEnItijiNnknOutputBean.setIwsKyknmkj(keiyakusyaBean.getKykNmKj());
        wsDwGetHozenKykEnItijiNnknOutputBean.setIwsKykseiymdstr(dateToStr(keiyakusyaBean.getKykseiYmd()));
        wsDwGetHozenKykEnItijiNnknOutputBean.setIwsKyksei(keiyakusyaBean.getKyksei().getValue());
        wsDwGetHozenKykEnItijiNnknOutputBean.setIwsHhknnmkn(hihokensyaBean.getHhknNmKn());
        wsDwGetHozenKykEnItijiNnknOutputBean.setIwsHhknseiymdstr(dateToStr(hihokensyaBean.getHhknseiYmd()));
        wsDwGetHozenKykEnItijiNnknOutputBean.setIwsSbuktnin(String.valueOf(keiyakuUketorininBean.getSbuktnin()));
        wsDwGetHozenKykEnItijiNnknOutputBean.setIwsUktmidasikbn1(keiyakuUketorininBean.getUktsyuKbn1().getValue());
        wsDwGetHozenKykEnItijiNnknOutputBean.setIwsUktkbn1str(keiyakuUketorininBean.getGkdtKoktuutiUktKbn1().getValue());
        wsDwGetHozenKykEnItijiNnknOutputBean.setIwsUktsimei1(keiyakuUketorininBean.getUktNm1());
        wsDwGetHozenKykEnItijiNnknOutputBean.setIwsUktmidasikbn2(keiyakuUketorininBean.getUktsyuKbn2().getValue());
        wsDwGetHozenKykEnItijiNnknOutputBean.setIwsUktkbn2str(keiyakuUketorininBean.getGkdtKoktuutiUktKbn2().getValue());
        wsDwGetHozenKykEnItijiNnknOutputBean.setIwsUktsimei2(keiyakuUketorininBean.getUktNm2());
        wsDwGetHozenKykEnItijiNnknOutputBean.setIwsUktmidasikbn3(keiyakuUketorininBean.getUktsyuKbn3().getValue());
        wsDwGetHozenKykEnItijiNnknOutputBean.setIwsUktkbn3str(keiyakuUketorininBean.getGkdtKoktuutiUktKbn3().getValue());
        wsDwGetHozenKykEnItijiNnknOutputBean.setIwsUktsimei3(keiyakuUketorininBean.getUktNm3());
        wsDwGetHozenKykEnItijiNnknOutputBean.setIwsUktmidasikbn4(keiyakuUketorininBean.getUktsyuKbn4().getValue());
        wsDwGetHozenKykEnItijiNnknOutputBean.setIwsUktkbn4str(keiyakuUketorininBean.getGkdtKoktuutiUktKbn4().getValue());
        wsDwGetHozenKykEnItijiNnknOutputBean.setIwsUktsimei4(keiyakuUketorininBean.getUktNm4());
        wsDwGetHozenKykEnItijiNnknOutputBean.setIwsUktmidasikbn5(keiyakuUketorininBean.getUktsyuKbn5().getValue());
        wsDwGetHozenKykEnItijiNnknOutputBean.setIwsUktkbn5str(keiyakuUketorininBean.getGkdtKoktuutiUktKbn5().getValue());
        wsDwGetHozenKykEnItijiNnknOutputBean.setIwsUktsimei5(keiyakuUketorininBean.getUktNm5());
        wsDwGetHozenKykEnItijiNnknOutputBean.setIwsUktmidasikbn6(keiyakuUketorininBean.getUktsyuKbn6().getValue());
        wsDwGetHozenKykEnItijiNnknOutputBean.setIwsUktkbn6str(keiyakuUketorininBean.getGkdtKoktuutiUktKbn6().getValue());
        wsDwGetHozenKykEnItijiNnknOutputBean.setIwsUktsimei6(keiyakuUketorininBean.getUktNm6());
        wsDwGetHozenKykEnItijiNnknOutputBean.setIwsUktmidasikbn7(keiyakuUketorininBean.getUktsyuKbn7().getValue());
        wsDwGetHozenKykEnItijiNnknOutputBean.setIwsUktkbn7str(keiyakuUketorininBean.getGkdtKoktuutiUktKbn7().getValue());
        wsDwGetHozenKykEnItijiNnknOutputBean.setIwsUktsimei7(keiyakuUketorininBean.getUktNm7());
        wsDwGetHozenKykEnItijiNnknOutputBean.setIwsUktmidasikbn8(keiyakuUketorininBean.getUktsyuKbn8().getValue());
        wsDwGetHozenKykEnItijiNnknOutputBean.setIwsUktkbn8str(keiyakuUketorininBean.getGkdtKoktuutiUktKbn8().getValue());
        wsDwGetHozenKykEnItijiNnknOutputBean.setIwsUktsimei8(keiyakuUketorininBean.getUktNm8());
        wsDwGetHozenKykEnItijiNnknOutputBean.setIwsUktmidasikbn9(keiyakuUketorininBean.getUktsyuKbn9().getValue());
        wsDwGetHozenKykEnItijiNnknOutputBean.setIwsUktkbn9str(keiyakuUketorininBean.getGkdtKoktuutiUktKbn9().getValue());
        wsDwGetHozenKykEnItijiNnknOutputBean.setIwsUktsimei9(keiyakuUketorininBean.getUktNm9());
        wsDwGetHozenKykEnItijiNnknOutputBean.setIwsUktmidasikbn10(keiyakuUketorininBean.getUktsyuKbn10().getValue());
        wsDwGetHozenKykEnItijiNnknOutputBean.setIwsUktkbn10str(keiyakuUketorininBean.getGkdtKoktuutiUktKbn10().getValue());
        wsDwGetHozenKykEnItijiNnknOutputBean.setIwsUktsimei10(keiyakuUketorininBean.getUktNm10());
        wsDwGetHozenKykEnItijiNnknOutputBean.setIwsTrkkzknmkn1(trkKazokuBean.getTrkkzknmKn1());
        wsDwGetHozenKykEnItijiNnknOutputBean.setIwsTrkkzknmkn2(trkKazokuBean.getTrkkzknmKn2());
        wsDwGetHozenKykEnItijiNnknOutputBean.setIwsTutakinumukbn(gamenSeigyoBean.getTutakinUmukbn().getValue());
        wsDwGetHozenKykEnItijiNnknOutputBean.setIwsSbhsyumukbn(hosyouBean.getSbHsyUmuKbn().getValue());
        wsDwGetHozenKykEnItijiNnknOutputBean.setIwsKghsyumukbn(hosyouBean.getKgHsyUmukbn().getValue());
        wsDwGetHozenKykEnItijiNnknOutputBean.setIwsIryhsyumukbn(hosyouBean.getIryHsyUmukbn().getValue());
        wsDwGetHozenKykEnItijiNnknOutputBean.setIwsRougohsyumukbn(hosyouBean.getRougoHsyUmukbn().getValue());
        wsDwGetHozenKykEnItijiNnknOutputBean.setIwsKykdrtkhkumu(tokuyakuBean.getKykdrTkykhukaumu().getValue());
        wsDwGetHozenKykEnItijiNnknOutputBean.setIwsStdrsktkyhkumu(tokuyakuBean.getStdrskTkyhkumu().getValue());
        wsDwGetHozenKykEnItijiNnknOutputBean.setIwsKjsmsaihakkoukahikbn(syoriKahiBean.getKjsmSaihakkouKahiKbn().getValue());
        wsDwGetHozenKykEnItijiNnknOutputBean.setIwsKykmeigihnkkahikbn(syoriKahiBean.getKykMeigihnkKahiKbn().getValue());
        wsDwGetHozenKykEnItijiNnknOutputBean.setIwsSyoukensaihkkahikbn(syoriKahiBean.getSyoukenSaihkKahiKbn().getValue());
        wsDwGetHozenKykEnItijiNnknOutputBean.setIwsStdrsktkytthkkahikbn(syoriKahiBean.getStdrskTkyTthkKahiKbn().getValue());
        wsDwGetHozenKykEnItijiNnknOutputBean.setIwsTargettkhkkahikbn(syoriKahiBean.getTargetTkhkKahiKbn().getValue());
        wsDwGetHozenKykEnItijiNnknOutputBean.setIwsKykniyusyoukaikahikbn(syoriKahiBean.getKykNiyuSyoukaiKahiKbn().getValue());
        wsDwGetHozenKykEnItijiNnknOutputBean.setIwsTumitatekinitenkahikbn(syoriKahiBean.getTumitatekinItenKahiKbn().getValue());
        wsDwGetHozenKykEnItijiNnknOutputBean.setIwsDskaiyakukahikbn(syoriKahiBean.getDsKaiyakuKahiKbn().getValue());
        wsDwGetHozenKykEnItijiNnknOutputBean.setIwsAdrhenkoukahikbn(syoriKahiBean.getAdrHenkouKahiKbn().getValue());
        wsDwGetHozenKykEnItijiNnknOutputBean.setIwsPhrkhouhenkoukahikbn(syoriKahiBean.getPhrkhouHenkouKahiKbn().getValue());
        wsDwGetHozenKykEnItijiNnknOutputBean.setIwsNenkinsyustr(nenkinSyu);
        wsDwGetHozenKykEnItijiNnknOutputBean.setIwsNenkinstartymd(dateToStr(kykSyouhn.getHknkknmanryouymd()));
        wsDwGetHozenKykEnItijiNnknOutputBean.setIwsNenkinstartnen(String.valueOf(hhknStartnen));
        wsDwGetHozenKykEnItijiNnknOutputBean.setIwsKijyunkingaku(kykSyouhn.getKihons().toAdsoluteString());
        wsDwGetHozenKykEnItijiNnknOutputBean.setIwsTumitateriritustr(kykSyouhn.getTumitateriritu().multiply(100).toString());
        wsDwGetHozenKykEnItijiNnknOutputBean.setIwsKaiyakuhryen(kaiyakuhrkngakyen.toAdsoluteString());
        wsDwGetHozenKykEnItijiNnknOutputBean.setIwsSbkyhgkyen(sbhkyhkngkyen.toAdsoluteString());
        wsDwGetHozenKykEnItijiNnknOutputBean.setIwsPtumitatekngkyen(ptumitaTekinEn.toAdsoluteString());
        wsDwGetHozenKykEnItijiNnknOutputBean.setIwsYendtitijibrnkhkhnkymd(dateToStr(kykSyouhn.getYendthnkymd()));
        wsDwGetHozenKykEnItijiNnknOutputBean.setIwsYakkanbunsyono(keiyakuKihonBean.getYakkanBunsyoNo());

        return wsDwGetHozenKykEnItijiNnknOutputBean;
    }

    private String dateToStr(BizDate pDate) {

        if (pDate == null) {
            return null;
        }

        return pDate.toString();
    }
}
