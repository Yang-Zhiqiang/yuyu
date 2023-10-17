package yuyu.app.dsweb.dwhozeninfo.dwgethozenkeiyakuenitijisyusin;

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
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;
import jp.co.slcs.swak.util.message.MessageUtil;
import net.arnx.jsonic.JSON;

import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;

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
import yuyu.def.classification.C_Siharaijyoutaikbn;
import yuyu.def.classification.C_SiinKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.IT_KhHenreikin;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.dsweb.bean.webservice.WsDwGetHozenKeiyakuEnItijiSyusinInputBean;
import yuyu.def.dsweb.bean.webservice.WsDwGetHozenKeiyakuEnItijiSyusinOutputBean;
import yuyu.def.hozen.manager.HozenDomManager;

/**
 * 保全契約詳細取得（円建一時払終身）サービスの実装クラスです。<br />
 */
public class DwGetHozenKeiyakuEnItijiSyusinImpl implements DwGetHozenKeiyakuEnItijiSyusin {

    @Inject
    private static Logger logger;

    @Inject
    private HozenDomManager hozenDomManager;

    @Override
    public WsBzWebserviceResParamBean execPostForm(MultivaluedMap<String, String> pMap) {

        logger.info(MessageUtil.getMessage(MessageId.IBF0016, MessageUtil.getMessage(MessageId.INW1010)));

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean;

        try {

            wsBzWebserviceResParamBean = getHozenKeiyakuEnItijiSyusin(pMap);

        } catch (Exception throwable) {

            DsDB2Util dsDB2Util = SWAKInjector.getInstance(DsDB2Util.class);

            DsDB2Util.E_Result result = dsDB2Util.exec(throwable);

            String dsmsgcd = "";

            if (DsDB2Util.E_Result.DEADLOCK.compareTo(result) == 0) {
                dsmsgcd = DwMessageCodeConstants.IWSDSMSGCD_010213;
            }
            else if (DsDB2Util.E_Result.QUERY_TIMEOUT.compareTo(result) == 0) {
                dsmsgcd = DwMessageCodeConstants.IWSDSMSGCD_010212;
            }
            else if (DsDB2Util.E_Result.OTHER.compareTo(result) == 0) {
                throw throwable;
            }

            WsDwGetHozenKeiyakuEnItijiSyusinOutputBean wsDwGetHozenKeiyakuEnItijiSyusinOutputBean =
                SWAKInjector.getInstance(WsDwGetHozenKeiyakuEnItijiSyusinOutputBean.class);
            wsBzWebserviceResParamBean = SWAKInjector.getInstance(WsBzWebserviceResParamBean.class);
            wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.setIwsDsmsgcd(dsmsgcd);
            wsBzWebserviceResParamBean.setGyoumuData(JSON.encode(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean));
        } finally {
            logger.info(MessageUtil.getMessage(MessageId.IBF0017, MessageUtil.getMessage(MessageId.INW1010)));
        }

        return wsBzWebserviceResParamBean;

    }

    @Transactional
    WsBzWebserviceResParamBean getHozenKeiyakuEnItijiSyusin(MultivaluedMap<String, String> pMap) {

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

        WsDwGetHozenKeiyakuEnItijiSyusinInputBean wsDwGetHozenKeiyakuEnItijiSyusinInputBean =
            JSON.decode(gyoumuData, WsDwGetHozenKeiyakuEnItijiSyusinInputBean.class);

        WebServiceAccesslogOutput webServiceAccesslogOutput =
            SWAKInjector.getInstance(WebServiceAccesslogOutput.class);
        webServiceAccesslogOutput.exec(C_AccessLogSyubetuKbn.ACTION_BEGIN,
            wsBzWebserviceReqParamBean, wsDwGetHozenKeiyakuEnItijiSyusinInputBean);

        WsDwGetHozenKeiyakuEnItijiSyusinOutputBean wsDwGetHozenKeiyakuEnItijiSyusinOutputBean =
            SWAKInjector.getInstance(WsDwGetHozenKeiyakuEnItijiSyusinOutputBean.class);
        WsBzWebserviceResParamBean wsBzWebserviceResParamBean =
            SWAKInjector.getInstance(WsBzWebserviceResParamBean.class);

        boolean chkRet = wsDwGetHozenKeiyakuEnItijiSyusinInputBean.chkInput();
        if (!chkRet) {
            wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.setIwsDsmsgcd(DwMessageCodeConstants.IWSDSMSGCD_010100);
            wsBzWebserviceResParamBean.setGyoumuData(JSON.encode(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean));

            return wsBzWebserviceResParamBean;
        }

        Validator validator = SWAKInjector.getInstance(Validator.class);
        Set<ConstraintViolation<WsDwGetHozenKeiyakuEnItijiSyusinInputBean>> chkKekkaSet =
            validator.validate(wsDwGetHozenKeiyakuEnItijiSyusinInputBean);

        if (chkKekkaSet.size() > 0) {
            wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.setIwsDsmsgcd(DwMessageCodeConstants.IWSDSMSGCD_010100);
            wsBzWebserviceResParamBean.setGyoumuData(JSON.encode(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean));

            return wsBzWebserviceResParamBean;
        }

        wsDwGetHozenKeiyakuEnItijiSyusinOutputBean = getHozenKeiyakuEnItijiSyusin(
            wsDwGetHozenKeiyakuEnItijiSyusinInputBean.getIwsSyono());

        wsBzWebserviceResParamBean.setGyoumuData(JSON.encode(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean));

        return wsBzWebserviceResParamBean;
    }

    private WsDwGetHozenKeiyakuEnItijiSyusinOutputBean getHozenKeiyakuEnItijiSyusin(String pSyoNo) {

        WsDwGetHozenKeiyakuEnItijiSyusinOutputBean wsDwGetHozenKeiyakuEnItijiSyusinOutputBean = SWAKInjector
            .getInstance(WsDwGetHozenKeiyakuEnItijiSyusinOutputBean.class);

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(pSyoNo);

        if (kykKihon == null) {

            wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.setIwsDsmsgcd(DwMessageCodeConstants.IWSDSMSGCD_010200);
            return wsDwGetHozenKeiyakuEnItijiSyusinOutputBean;
        }

        DsGetKeiyakuCommon dsGetKeiyakuCommon = SWAKInjector.getInstance(DsGetKeiyakuCommon.class);

        KeiyakuKihonBean keiyakuKihonBean = dsGetKeiyakuCommon.getKykKihon(pSyoNo);
        if (C_ErrorKbn.ERROR.eq(keiyakuKihonBean.getErrorKbn())) {

            wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.setIwsDsmsgcd(DwMessageCodeConstants.IWSDSMSGCD_010201);
            return wsDwGetHozenKeiyakuEnItijiSyusinOutputBean;

        }

        KeiyakusyaBean keiyakusyaBean = dsGetKeiyakuCommon.getKykSya(pSyoNo);
        if (C_ErrorKbn.ERROR.eq(keiyakusyaBean.getErrorKbn())) {

            wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.setIwsDsmsgcd(DwMessageCodeConstants.IWSDSMSGCD_010202);
            return wsDwGetHozenKeiyakuEnItijiSyusinOutputBean;

        }

        HihokensyaBean hihokensyaBean = dsGetKeiyakuCommon.getHhknSya(pSyoNo);
        if (C_ErrorKbn.ERROR.eq(hihokensyaBean.getErrorKbn())) {

            wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.setIwsDsmsgcd(DwMessageCodeConstants.IWSDSMSGCD_010203);
            return wsDwGetHozenKeiyakuEnItijiSyusinOutputBean;

        }

        KeiyakuUketorininBean keiyakuUketorininBean = dsGetKeiyakuCommon.getKykUkt(pSyoNo);
        if (C_ErrorKbn.ERROR.eq(keiyakuUketorininBean.getErrorKbn())) {

            wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.setIwsDsmsgcd(DwMessageCodeConstants.IWSDSMSGCD_010204);
            return wsDwGetHozenKeiyakuEnItijiSyusinOutputBean;

        }

        TrkKazokuBean trkKazokuBean = dsGetKeiyakuCommon.getTrkKazoku(pSyoNo);

        DsGetSeigyo dsGetSeigyo = SWAKInjector.getInstance(DsGetSeigyo.class);

        DsSyouhinBean dsSyouhinBean = SWAKInjector.getInstance(DsSyouhinBean.class);
        dsSyouhinBean.setSyoNo(pSyoNo);
        dsSyouhinBean.setDsSyouhnbunruiKbn(C_DsSyouhnbunruiKbn.YENDTITIJIBRSYSN);

        GamenSeigyoBean gamenSeigyoBean = dsGetSeigyo.getGamenSeigyo(dsSyouhinBean);
        if (C_ErrorKbn.ERROR.eq(gamenSeigyoBean.getErrorKbn())) {

            wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.setIwsDsmsgcd(DwMessageCodeConstants.IWSDSMSGCD_010205);
            return wsDwGetHozenKeiyakuEnItijiSyusinOutputBean;

        }

        HosyouBean hosyouBean = dsGetSeigyo.getHosyou(dsSyouhinBean);
        if (C_ErrorKbn.ERROR.eq(hosyouBean.getErrorKbn())) {

            wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.setIwsDsmsgcd(DwMessageCodeConstants.IWSDSMSGCD_010206);
            return wsDwGetHozenKeiyakuEnItijiSyusinOutputBean;

        }

        TokuyakuBean tokuyakuBean = dsGetSeigyo.getTokuyaku(dsSyouhinBean);
        if (C_ErrorKbn.ERROR.eq(tokuyakuBean.getErrorKbn())) {

            wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.setIwsDsmsgcd(DwMessageCodeConstants.IWSDSMSGCD_010207);
            return wsDwGetHozenKeiyakuEnItijiSyusinOutputBean;

        }

        SyoriKahiBean syoriKahiBean = dsGetSeigyo.getSyoriKahi(dsSyouhinBean);
        if (C_ErrorKbn.ERROR.eq(syoriKahiBean.getErrorKbn())) {

            wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.setIwsDsmsgcd(DwMessageCodeConstants.IWSDSMSGCD_010208);
            return wsDwGetHozenKeiyakuEnItijiSyusinOutputBean;

        }

        List<IT_KykSyouhn> kykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        if (kykSyouhnLst.size() == 0) {

            wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.setIwsDsmsgcd(DwMessageCodeConstants.IWSDSMSGCD_010209);
            return wsDwGetHozenKeiyakuEnItijiSyusinOutputBean;

        }

        IT_KykSyouhn kykSyouhn = kykSyouhnLst.get(0);
        BM_SyouhnZokusei syouhnZokusei = kykSyouhn.getSyouhnZokusei();
        if (syouhnZokusei == null) {

            wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.setIwsDsmsgcd(DwMessageCodeConstants.IWSDSMSGCD_010210);
            return wsDwGetHozenKeiyakuEnItijiSyusinOutputBean;

        }

        BizCurrency yendtItijibrSysnHkHnkHr = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
        C_Siharaijyoutaikbn hrSiharaiJyoutaiKbn = C_Siharaijyoutaikbn.BLNK;
        List<IT_KhHenreikin> khHenreikinLst = hozenDomManager.getKhHenreikinYendtMbrsBySyono(pSyoNo);
        if (kykSyouhn.getYendthnkymd() != null) {

            if (khHenreikinLst.size() != 0) {
                IT_KhHenreikin khHenreikin = hozenDomManager.getKhHenreikinYendtMbrsBySyono(pSyoNo).get(0);
                yendtItijibrSysnHkHnkHr = khHenreikin.getHenreikingk();
                hrSiharaiJyoutaiKbn = khHenreikin.getHrsiharaijyoutaikbn();
            }

        }
        else {

            if (khHenreikinLst.size() == 0) {
                wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.setIwsDsmsgcd(DwMessageCodeConstants.IWSDSMSGCD_010211);
                return wsDwGetHozenKeiyakuEnItijiSyusinOutputBean;
            }

        }

        CalcHkShrKngk calcHkShrKngk = SWAKInjector.getInstance(CalcHkShrKngk.class);
        C_ErrorKbn errorKbn = calcHkShrKngk.execByKeisanWExt(
            kykKihon.getSyono(),
            BizDate.getSysDate(),
            C_SiinKbn.SP,
            C_HokenkinsyuruiKbn.SBHOKENKIN,
            kykKihon.getSdpdkbn(),
            kykKihon.getHrkkeiro());

        BizCurrency kaiyakuhrkngakyen = BizCurrency.valueOf(0);
        BizCurrency sbhknkngkyen = BizCurrency.valueOf(0);

        if (C_ErrorKbn.OK.eq(errorKbn)) {
            CalcHkShrKngkBean calcHkShrKngkBean = calcHkShrKngk.getCalcHkShrKngkBean();
            kaiyakuhrkngakyen = calcHkShrKngkBean.getKaiyakuhenreiknGk();
            sbhknkngkyen = calcHkShrKngkBean.getSibousGk();
        }

        wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.setIwsDsmsgcd(DwMessageCodeConstants.IWSDSMSGCD_010000);
        wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.setIwsSyono(pSyoNo);
        wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.setIwsAisyoumei(keiyakuKihonBean.getAisyoumeiKbn().getContent());
        wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.setIwsSyouhnnm(keiyakuKihonBean.getSyouhnNm());
        wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.setIwsKykymdstr(dateToStr(keiyakuKihonBean.getKykYmd()));
        wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.setIwsKyktuukasyu(keiyakuKihonBean.getKykTuukasyu().getValue());
        wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.setIwsSakuseikijyunymdstr(dateToStr(keiyakuKihonBean.getSakuseiKijyunYmd()));
        wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.setIwsKyknmkn(keiyakusyaBean.getKykNmKn());
        wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.setIwsKyknmkj(keiyakusyaBean.getKykNmKj());
        wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.setIwsKykseiymdstr(dateToStr(keiyakusyaBean.getKykseiYmd()));
        wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.setIwsKyksei(keiyakusyaBean.getKyksei().getValue());
        wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.setIwsHhknnmkn(hihokensyaBean.getHhknNmKn());
        wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.setIwsHhknseiymdstr(dateToStr(hihokensyaBean.getHhknseiYmd()));
        wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.setIwsSbuktnin(String.valueOf(keiyakuUketorininBean.getSbuktnin()));
        wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.setIwsUktmidasikbn1(keiyakuUketorininBean.getUktsyuKbn1().getValue());
        wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.setIwsUktkbn1str(keiyakuUketorininBean.getGkdtKoktuutiUktKbn1().getValue());
        wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.setIwsUktsimei1(keiyakuUketorininBean.getUktNm1());
        wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.setIwsUktmidasikbn2(keiyakuUketorininBean.getUktsyuKbn2().getValue());
        wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.setIwsUktkbn2str(keiyakuUketorininBean.getGkdtKoktuutiUktKbn2().getValue());
        wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.setIwsUktsimei2(keiyakuUketorininBean.getUktNm2());
        wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.setIwsUktmidasikbn3(keiyakuUketorininBean.getUktsyuKbn3().getValue());
        wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.setIwsUktkbn3str(keiyakuUketorininBean.getGkdtKoktuutiUktKbn3().getValue());
        wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.setIwsUktsimei3(keiyakuUketorininBean.getUktNm3());
        wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.setIwsUktmidasikbn4(keiyakuUketorininBean.getUktsyuKbn4().getValue());
        wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.setIwsUktkbn4str(keiyakuUketorininBean.getGkdtKoktuutiUktKbn4().getValue());
        wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.setIwsUktsimei4(keiyakuUketorininBean.getUktNm4());
        wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.setIwsUktmidasikbn5(keiyakuUketorininBean.getUktsyuKbn5().getValue());
        wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.setIwsUktkbn5str(keiyakuUketorininBean.getGkdtKoktuutiUktKbn5().getValue());
        wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.setIwsUktsimei5(keiyakuUketorininBean.getUktNm5());
        wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.setIwsUktmidasikbn6(keiyakuUketorininBean.getUktsyuKbn6().getValue());
        wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.setIwsUktkbn6str(keiyakuUketorininBean.getGkdtKoktuutiUktKbn6().getValue());
        wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.setIwsUktsimei6(keiyakuUketorininBean.getUktNm6());
        wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.setIwsUktmidasikbn7(keiyakuUketorininBean.getUktsyuKbn7().getValue());
        wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.setIwsUktkbn7str(keiyakuUketorininBean.getGkdtKoktuutiUktKbn7().getValue());
        wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.setIwsUktsimei7(keiyakuUketorininBean.getUktNm7());
        wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.setIwsUktmidasikbn8(keiyakuUketorininBean.getUktsyuKbn8().getValue());
        wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.setIwsUktkbn8str(keiyakuUketorininBean.getGkdtKoktuutiUktKbn8().getValue());
        wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.setIwsUktsimei8(keiyakuUketorininBean.getUktNm8());
        wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.setIwsUktmidasikbn9(keiyakuUketorininBean.getUktsyuKbn9().getValue());
        wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.setIwsUktkbn9str(keiyakuUketorininBean.getGkdtKoktuutiUktKbn9().getValue());
        wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.setIwsUktsimei9(keiyakuUketorininBean.getUktNm9());
        wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.setIwsUktmidasikbn10(keiyakuUketorininBean.getUktsyuKbn10().getValue());
        wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.setIwsUktkbn10str(keiyakuUketorininBean.getGkdtKoktuutiUktKbn10().getValue());
        wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.setIwsUktsimei10(keiyakuUketorininBean.getUktNm10());
        wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.setIwsTrkkzknmkn1(trkKazokuBean.getTrkkzknmKn1());
        wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.setIwsTrkkzknmkn2(trkKazokuBean.getTrkkzknmKn2());
        wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.setIwsTutakinumukbn(gamenSeigyoBean.getTutakinUmukbn().getValue());
        wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.setIwsSbhsyumukbn(hosyouBean.getSbHsyUmuKbn().getValue());
        wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.setIwsKghsyumukbn(hosyouBean.getKgHsyUmukbn().getValue());
        wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.setIwsIryhsyumukbn(hosyouBean.getIryHsyUmukbn().getValue());
        wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.setIwsRougohsyumukbn(hosyouBean.getRougoHsyUmukbn().getValue());
        wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.setIwsKykdrtkhkumu(tokuyakuBean.getKykdrTkykhukaumu().getValue());
        wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.setIwsStdrsktkyhkumu(tokuyakuBean.getStdrskTkyhkumu().getValue());
        wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.setIwsYennykntkhkumu(tokuyakuBean.getYenNyknThkumu().getValue());
        wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.setIwsGaikanykntkhkumu(tokuyakuBean.getGaikaNyknTkhkumu().getValue());
        wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.setIwsTargettkhkumu(tokuyakuBean.getTargetTkhkumu().getValue());
        wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.setIwsSyksbyensitihsyutyhkumu(tokuyakuBean.getInitSbjiYenSitiHsyTkhukaumu().getValue());
        wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.setIwsJyudkaigomehrtkhkumu(tokuyakuBean.getJyudKaigoMeharaiTkhukaumu().getValue());
        wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.setIwsZeiseitkkktkykhukaumu(tokuyakuBean.getZeiseiTkkkTkykhukaumu().getValue());
        wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.setIwsKjsmsaihakkoukahikbn(syoriKahiBean.getKjsmSaihakkouKahiKbn().getValue());
        wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.setIwsKykmeigihnkkahikbn(syoriKahiBean.getKykMeigihnkKahiKbn().getValue());
        wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.setIwsSyoukensaihkkahikbn(syoriKahiBean.getSyoukenSaihkKahiKbn().getValue());
        wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.setIwsStdrsktkytthkkahikbn(syoriKahiBean.getStdrskTkyTthkKahiKbn().getValue());
        wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.setIwsTargettkhkkahikbn(syoriKahiBean.getTargetTkhkKahiKbn().getValue());
        wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.setIwsKykniyusyoukaikahikbn(syoriKahiBean.getKykNiyuSyoukaiKahiKbn().getValue());
        wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.setIwsTumitatekinitenkahikbn(syoriKahiBean.getTumitatekinItenKahiKbn().getValue());
        wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.setIwsDskaiyakukahikbn(syoriKahiBean.getDsKaiyakuKahiKbn().getValue());
        wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.setIwsAdrhenkoukahikbn(syoriKahiBean.getAdrHenkouKahiKbn().getValue());
        wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.setIwsPhrkhouhenkoukahikbn(syoriKahiBean.getPhrkhouHenkouKahiKbn().getValue());
        wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.setIwsKaiyakuhryen(kaiyakuhrkngakyen.toAdsoluteString());
        wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.setIwsSibohknkngkyen(sbhknkngkyen.toAdsoluteString());
        wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.setIwsYendtitijibrsysnhkhnkymd(dateToStr(kykSyouhn.getYendthnkymd()));
        wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.setIwsYendtitijibrsysnhkhnkhr(yendtItijibrSysnHkHnkHr.toAdsoluteString());
        wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.setIwsHrsiharaijyoutaikbn(hrSiharaiJyoutaiKbn.getValue());
        wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.setIwsYakkanbunsyono(keiyakuKihonBean.getYakkanBunsyoNo());

        return wsDwGetHozenKeiyakuEnItijiSyusinOutputBean;
    }

    private String dateToStr(BizDate pDate) {

        if (pDate == null) {
            return null;
        }

        return pDate.toString();
    }
}
