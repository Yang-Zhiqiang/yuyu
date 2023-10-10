package yuyu.app.dsweb.dwhozeninfo.dwgethozenkeiyakusyousai;

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

import yuyu.common.biz.bzwebserviceaccesslogoutput.WebServiceAccesslogOutput;
import yuyu.common.direct.dscommon.DsDB2Util;
import yuyu.common.direct.dscommon.DsGetKeiyakuSyousai;
import yuyu.common.direct.dscommon.DsKeiyakuSyousaiBean;
import yuyu.common.dsweb.dwcommon.DwMessageCodeConstants;
import yuyu.def.MessageId;
import yuyu.def.biz.bean.param.WsBzWebserviceReqParamBean;
import yuyu.def.biz.bean.param.WsBzWebserviceResParamBean;
import yuyu.def.classification.C_AccessLogSyubetuKbn;
import yuyu.def.dsweb.bean.webservice.WsDwGetHozenKeiyakuSyousaiInputBean;
import yuyu.def.dsweb.bean.webservice.WsDwGetHozenKeiyakuSyousaiOutputBean;

/**
 * 保全契約詳細取得サービスの実装クラスです。<br />
 */
public class DwGetHozenKeiyakuSyousaiImpl implements DwGetHozenKeiyakuSyousai {

    @Inject
    private static Logger logger;

    @Override
    public WsBzWebserviceResParamBean execPostForm(MultivaluedMap<String, String> pMap) {

        logger.info(MessageUtil.getMessage(MessageId.IBF0016, MessageUtil.getMessage(MessageId.INW1005)));

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean;

        try {

            wsBzWebserviceResParamBean = getDsKeiyakuSyousaiMain(pMap);

        } catch (Exception throwable) {
            DsDB2Util dsDB2Util = SWAKInjector.getInstance(DsDB2Util.class);

            DsDB2Util.E_Result result = dsDB2Util.exec(throwable);

            String iwsDsmsgcd = "";

            if (DsDB2Util.E_Result.DEADLOCK.compareTo(result) == 0) {
                iwsDsmsgcd = DwMessageCodeConstants.IWSDSMSGCD_005202;
            }
            else if (DsDB2Util.E_Result.QUERY_TIMEOUT.compareTo(result) == 0) {
                iwsDsmsgcd = DwMessageCodeConstants.IWSDSMSGCD_005201;
            }
            else if (DsDB2Util.E_Result.OTHER.compareTo(result) == 0) {
                throw throwable;
            }

            WsDwGetHozenKeiyakuSyousaiOutputBean wsDwGetHozenKeiyakuSyousaiOutputBean =
                SWAKInjector.getInstance(WsDwGetHozenKeiyakuSyousaiOutputBean.class);
            wsBzWebserviceResParamBean = SWAKInjector.getInstance(WsBzWebserviceResParamBean.class);
            wsDwGetHozenKeiyakuSyousaiOutputBean.setIwsDsmsgcd(iwsDsmsgcd);
            wsBzWebserviceResParamBean.setGyoumuData(JSON.encode(wsDwGetHozenKeiyakuSyousaiOutputBean));
        } finally {
            logger.info(MessageUtil.getMessage(MessageId.IBF0017, MessageUtil.getMessage(MessageId.INW1005)));
        }

        return wsBzWebserviceResParamBean;
    }

    @Transactional
    WsBzWebserviceResParamBean getDsKeiyakuSyousaiMain(MultivaluedMap<String, String> pMap) {

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

        WsDwGetHozenKeiyakuSyousaiInputBean getHzKykSyousaiInputBean =
            JSON.decode(gyoumuData, WsDwGetHozenKeiyakuSyousaiInputBean.class);


        WebServiceAccesslogOutput webServiceAccesslogOutput =
            SWAKInjector.getInstance(WebServiceAccesslogOutput.class);
        webServiceAccesslogOutput.exec(C_AccessLogSyubetuKbn.ACTION_BEGIN,
            wsBzWebserviceReqParamBean, getHzKykSyousaiInputBean);

        WsDwGetHozenKeiyakuSyousaiOutputBean getHzKykSyousaiOutputBean =
            SWAKInjector.getInstance(WsDwGetHozenKeiyakuSyousaiOutputBean.class);
        WsBzWebserviceResParamBean wsBzWebserviceResParamBean =
            SWAKInjector.getInstance(WsBzWebserviceResParamBean.class);

        boolean chkRet = getHzKykSyousaiInputBean.chkInput();
        if (!chkRet) {
            getHzKykSyousaiOutputBean.setIwsDsmsgcd(DwMessageCodeConstants.IWSDSMSGCD_005100);
            wsBzWebserviceResParamBean.setGyoumuData(JSON.encode(getHzKykSyousaiOutputBean));

            return wsBzWebserviceResParamBean;
        }

        Validator validator = SWAKInjector.getInstance(Validator.class);
        Set<ConstraintViolation<WsDwGetHozenKeiyakuSyousaiInputBean>> chkKekkaSet =
            validator.validate(getHzKykSyousaiInputBean);

        if (chkKekkaSet.size() > 0) {
            getHzKykSyousaiOutputBean.setIwsDsmsgcd(DwMessageCodeConstants.IWSDSMSGCD_005100);
            wsBzWebserviceResParamBean.setGyoumuData(JSON.encode(getHzKykSyousaiOutputBean));

            return wsBzWebserviceResParamBean;
        }

        getHzKykSyousaiOutputBean = getDsKeiyakuSyousai(getHzKykSyousaiInputBean.getIwsSyono());

        wsBzWebserviceResParamBean.setGyoumuData(JSON.encode(getHzKykSyousaiOutputBean));

        return wsBzWebserviceResParamBean;
    }

    private WsDwGetHozenKeiyakuSyousaiOutputBean getDsKeiyakuSyousai(String pSyono) {

        WsDwGetHozenKeiyakuSyousaiOutputBean hzKykSyousaiOutBean =
            SWAKInjector.getInstance(WsDwGetHozenKeiyakuSyousaiOutputBean.class);

        DsGetKeiyakuSyousai dsGetKeiyakuSyousai = SWAKInjector.getInstance(DsGetKeiyakuSyousai.class);
        DsKeiyakuSyousaiBean dsKeiyakuSyousaiBean = dsGetKeiyakuSyousai.exec(pSyono);

        if (dsKeiyakuSyousaiBean == null) {
            hzKykSyousaiOutBean.setIwsDsmsgcd(DwMessageCodeConstants.IWSDSMSGCD_005200);

            return hzKykSyousaiOutBean;
        }

        hzKykSyousaiOutBean.setIwsDsmsgcd(DwMessageCodeConstants.IWSDSMSGCD_005000);
        hzKykSyousaiOutBean.setIwsSyono(dsKeiyakuSyousaiBean.getSyono());
        hzKykSyousaiOutBean.setIwsSyouhnnm(dsKeiyakuSyousaiBean.getSyouhnnm());
        hzKykSyousaiOutBean.setIwsHhknnmkn(dsKeiyakuSyousaiBean.getHhknnmkn());
        hzKykSyousaiOutBean.setIwsHhknseiymdstr(dateToStr(dsKeiyakuSyousaiBean.getHhknseiYmd()));
        hzKykSyousaiOutBean.setIwsKykymdstr(dateToStr(dsKeiyakuSyousaiBean.getKykymd()));
        hzKykSyousaiOutBean.setIwsTutakinumukbn(dsKeiyakuSyousaiBean.getTutakinUmukbn().getValue());
        hzKykSyousaiOutBean.setIwsSbhsyumukbn(dsKeiyakuSyousaiBean.getSbhsyUmukbn().getValue());
        hzKykSyousaiOutBean.setIwsKghsyumukbn(dsKeiyakuSyousaiBean.getKghsyUmukbn().getValue());
        hzKykSyousaiOutBean.setIwsIryhsyumukbn(dsKeiyakuSyousaiBean.getIryhsyUmukbn().getValue());
        hzKykSyousaiOutBean.setIwsRougohsyumukbn(dsKeiyakuSyousaiBean.getRougohsyUmukbn().getValue());
        hzKykSyousaiOutBean.setIwsSakuseikijyunymdstr(dateToStr(dsKeiyakuSyousaiBean.getSakuseiKijyunymd()));
        hzKykSyousaiOutBean.setIwsSksikijyunymdkawaserate(dsKeiyakuSyousaiBean.getSksiKijyunymdKawaseRate().toString());
        hzKykSyousaiOutBean.setIwsKwsratekijyunymdsakusei(dateToStr(dsKeiyakuSyousaiBean.getKwsrateKijyunymdSakusei()));
        hzKykSyousaiOutBean.setIwsPtumitatekngkyen(dsKeiyakuSyousaiBean.getPtumitaTekinYen().toAdsoluteString());
        hzKykSyousaiOutBean.setIwsPtumitatekngkgaika(dsKeiyakuSyousaiBean.getPtumitaTekinKyktuuka().toAdsoluteString());
        hzKykSyousaiOutBean.setIwsKyktuukasyu(dsKeiyakuSyousaiBean.getKyktuukasyu().getValue());
        hzKykSyousaiOutBean.setIwsRsytuukasyu(dsKeiyakuSyousaiBean.getRstuukasyu().getValue());
        hzKykSyousaiOutBean.setIwsKaiyakuhryen(dsKeiyakuSyousaiBean.getKaiyakuHrkeiYen().toAdsoluteString());
        hzKykSyousaiOutBean.setIwsKaiyakuhrgaika(dsKeiyakuSyousaiBean.getKaiyakuHrkeiKyktuuka().toAdsoluteString());
        hzKykSyousaiOutBean.setIwsKaiyakuhrsuiiumukbn(dsKeiyakuSyousaiBean.getKaiyakuhrsuiiUmukbn().getValue());
        hzKykSyousaiOutBean.setIwsAisyoumei(dsKeiyakuSyousaiBean.getAisyoumei());
        hzKykSyousaiOutBean.setIwsKyknmkn(dsKeiyakuSyousaiBean.getKyknmkn());
        hzKykSyousaiOutBean.setIwsKyknmkj(dsKeiyakuSyousaiBean.getKyknmkj());
        hzKykSyousaiOutBean.setIwsKykseiymdstr(dateToStr(dsKeiyakuSyousaiBean.getKykseiymd()));
        hzKykSyousaiOutBean.setIwsKyksei(dsKeiyakuSyousaiBean.getKyksei().getValue());
        hzKykSyousaiOutBean.setIwsSbuktnin(String.valueOf(dsKeiyakuSyousaiBean.getSbuktnin()));
        hzKykSyousaiOutBean.setIwsUktmidasikbn1(dsKeiyakuSyousaiBean.getUktmidasikbn1().getValue());
        hzKykSyousaiOutBean.setIwsUktkbn1str(dsKeiyakuSyousaiBean.getUktkbn1().getValue());
        hzKykSyousaiOutBean.setIwsUktsimei1(dsKeiyakuSyousaiBean.getUktnm1());
        hzKykSyousaiOutBean.setIwsUktmidasikbn2(dsKeiyakuSyousaiBean.getUktmidasikbn2().getValue());
        hzKykSyousaiOutBean.setIwsUktkbn2str(dsKeiyakuSyousaiBean.getUktkbn2().getValue());
        hzKykSyousaiOutBean.setIwsUktsimei2(dsKeiyakuSyousaiBean.getUktnm2());
        hzKykSyousaiOutBean.setIwsUktmidasikbn3(dsKeiyakuSyousaiBean.getUktmidasikbn3().getValue());
        hzKykSyousaiOutBean.setIwsUktkbn3str(dsKeiyakuSyousaiBean.getUktkbn3().getValue());
        hzKykSyousaiOutBean.setIwsUktsimei3(dsKeiyakuSyousaiBean.getUktnm3());
        hzKykSyousaiOutBean.setIwsUktmidasikbn4(dsKeiyakuSyousaiBean.getUktmidasikbn4().getValue());
        hzKykSyousaiOutBean.setIwsUktkbn4str(dsKeiyakuSyousaiBean.getUktkbn4().getValue());
        hzKykSyousaiOutBean.setIwsUktsimei4(dsKeiyakuSyousaiBean.getUktnm4());
        hzKykSyousaiOutBean.setIwsUktmidasikbn5(dsKeiyakuSyousaiBean.getUktmidasikbn5().getValue());
        hzKykSyousaiOutBean.setIwsUktkbn5str(dsKeiyakuSyousaiBean.getUktkbn5().getValue());
        hzKykSyousaiOutBean.setIwsUktsimei5(dsKeiyakuSyousaiBean.getUktnm5());
        hzKykSyousaiOutBean.setIwsUktmidasikbn6(dsKeiyakuSyousaiBean.getUktmidasikbn6().getValue());
        hzKykSyousaiOutBean.setIwsUktkbn6str(dsKeiyakuSyousaiBean.getUktkbn6().getValue());
        hzKykSyousaiOutBean.setIwsUktsimei6(dsKeiyakuSyousaiBean.getUktnm6());
        hzKykSyousaiOutBean.setIwsUktmidasikbn7(dsKeiyakuSyousaiBean.getUktmidasikbn7().getValue());
        hzKykSyousaiOutBean.setIwsUktkbn7str(dsKeiyakuSyousaiBean.getUktkbn7().getValue());
        hzKykSyousaiOutBean.setIwsUktsimei7(dsKeiyakuSyousaiBean.getUktnm7());
        hzKykSyousaiOutBean.setIwsUktmidasikbn8(dsKeiyakuSyousaiBean.getUktmidasikbn8().getValue());
        hzKykSyousaiOutBean.setIwsUktkbn8str(dsKeiyakuSyousaiBean.getUktkbn8().getValue());
        hzKykSyousaiOutBean.setIwsUktsimei8(dsKeiyakuSyousaiBean.getUktnm8());
        hzKykSyousaiOutBean.setIwsUktmidasikbn9(dsKeiyakuSyousaiBean.getUktmidasikbn9().getValue());
        hzKykSyousaiOutBean.setIwsUktkbn9str(dsKeiyakuSyousaiBean.getUktkbn9().getValue());
        hzKykSyousaiOutBean.setIwsUktsimei9(dsKeiyakuSyousaiBean.getUktnm9());
        hzKykSyousaiOutBean.setIwsUktmidasikbn10(dsKeiyakuSyousaiBean.getUktmidasikbn10().getValue());
        hzKykSyousaiOutBean.setIwsUktkbn10str(dsKeiyakuSyousaiBean.getUktkbn10().getValue());
        hzKykSyousaiOutBean.setIwsUktsimei10(dsKeiyakuSyousaiBean.getUktnm10());
        hzKykSyousaiOutBean.setIwsTrkkzknmkn1(dsKeiyakuSyousaiBean.getTrkKzknmkn1());
        hzKykSyousaiOutBean.setIwsTrkkzknmkn2(dsKeiyakuSyousaiBean.getTrkKzknmkn2());
        hzKykSyousaiOutBean.setIwsHknkknkaisiymd1str(dateToStr(dsKeiyakuSyousaiBean.getHknkknKaisiymd1()));
        hzKykSyousaiOutBean.setIwsHknkknmanryouymd1str(dateToStr(dsKeiyakuSyousaiBean.getHknkknManryouymd1()));
        hzKykSyousaiOutBean.setIwsHknkkn1(String.valueOf(dsKeiyakuSyousaiBean.getDai1Hknkkn()));
        hzKykSyousaiOutBean.setIwsHknkknkaisiymd2str(dateToStr(dsKeiyakuSyousaiBean.getHknkknKaisiymd2()));
        hzKykSyousaiOutBean.setIwsHknkknmanryouymd2str(dateToStr(dsKeiyakuSyousaiBean.getHknkknManryouymd2()));
        hzKykSyousaiOutBean.setIwsHknkkn2(String.valueOf(dsKeiyakuSyousaiBean.getDai2Hknkkn()));
        hzKykSyousaiOutBean.setIwsHknkknkaisiymd3str(dateToStr(dsKeiyakuSyousaiBean.getHknkknKaisiymd3()));
        hzKykSyousaiOutBean.setIwsHknkknmanryouymd3str(dateToStr(dsKeiyakuSyousaiBean.getHknkknManryouymd3()));
        hzKykSyousaiOutBean.setIwsKykdrtkhkumu(dsKeiyakuSyousaiBean.getKykdrtkykhukaUmu().getValue());
        hzKykSyousaiOutBean.setIwsStdrsktkyhkumu(dsKeiyakuSyousaiBean.getStdrsktkyhkUmu().getValue());
        hzKykSyousaiOutBean.setIwsYennykntkhkumu(dsKeiyakuSyousaiBean.getYennykntkhkUmu().getValue());
        hzKykSyousaiOutBean.setIwsGaikanykntkhkumu(dsKeiyakuSyousaiBean.getGaikanykntkhkUmu().getValue());
        hzKykSyousaiOutBean.setIwsTargettkhkumu(dsKeiyakuSyousaiBean.getTargettkhkUmu().getValue());
        hzKykSyousaiOutBean.setIwsSyksbyensitihsyutyhkumu(dsKeiyakuSyousaiBean.getInitsbjiyenSitihsytkhukaUmu().getValue());
        hzKykSyousaiOutBean.setIwsJyudkaigomehrtkhkumu(dsKeiyakuSyousaiBean.getJyudkaigomeharaiTkhukaUmu().getValue());
        hzKykSyousaiOutBean.setIwsZeiseitkkktkykhukaumu(dsKeiyakuSyousaiBean.getZeiseitkkkTkykhukaUmu().getValue());
        hzKykSyousaiOutBean.setIwsRsymdkawaserate(dsKeiyakuSyousaiBean.getRyymdJitenkwsRate().toString());
        hzKykSyousaiOutBean.setIwsRsymdkawaseratestigi(dsKeiyakuSyousaiBean.getRyymdJitenkwsRateStigi().toString());
        hzKykSyousaiOutBean.setIwsKwsratekijyunymdrs(dateToStr(dsKeiyakuSyousaiBean.getKwsrateKijyunymdRy()));
        hzKykSyousaiOutBean.setIwsKwsratekijyunymdrsstigi(dateToStr(dsKeiyakuSyousaiBean.getKwsrateKijyunymdRyStigi()));
        hzKykSyousaiOutBean.setIwsRsgakuyen(dsKeiyakuSyousaiBean.getRsgakuYen().toAdsoluteString());
        hzKykSyousaiOutBean.setIwsRsgakustigi(dsKeiyakuSyousaiBean.getRsgakuStigi().toAdsoluteString());
        hzKykSyousaiOutBean.setIwsKijyunkingaku(dsKeiyakuSyousaiBean.getKijyunKingaku().toAdsoluteString());
        hzKykSyousaiOutBean.setIwsItijibrprsyen(dsKeiyakuSyousaiBean.getItijibrpRsYen().toAdsoluteString());
        hzKykSyousaiOutBean.setIwsItijibrpgaika(dsKeiyakuSyousaiBean.getItijibrpKyktuuka().toAdsoluteString());
        hzKykSyousaiOutBean.setIwsItijibrprsgaika(dsKeiyakuSyousaiBean.getItijibrpRsKyktuuka().toAdsoluteString());
        hzKykSyousaiOutBean.setIwsKihonhokenkngkgaika(dsKeiyakuSyousaiBean.getKihonHokenkngk().toAdsoluteString());
        hzKykSyousaiOutBean.setIwsMkhgkwari(String.valueOf(dsKeiyakuSyousaiBean.getMkhgkWari()));
        hzKykSyousaiOutBean.setIwsSibohknkngkyen(dsKeiyakuSyousaiBean.getSibohknkngkYen().toAdsoluteString());
        hzKykSyousaiOutBean.setIwsSibohknkngkgaika(dsKeiyakuSyousaiBean.getSibohknkngkKyktuuka().toAdsoluteString());
        hzKykSyousaiOutBean.setIwsSgsbhknkngkyen(dsKeiyakuSyousaiBean.getSgsbhknkngkYen().toAdsoluteString());
        hzKykSyousaiOutBean.setIwsSgsbhknkngkkgaika(dsKeiyakuSyousaiBean.getSgsbhknkngkKyktuuka().toAdsoluteString());
        hzKykSyousaiOutBean.setIwsSgsbhknkngkhyoujiumu(dsKeiyakuSyousaiBean.getSgsbhknkngkhyoujiUmu().getValue());
        hzKykSyousaiOutBean.setIwsKjsmsaihakkoukahikbn(dsKeiyakuSyousaiBean.getKjsmsaihakkouKahikbn().getValue());
        hzKykSyousaiOutBean.setIwsKykmeigihnkkahikbn(dsKeiyakuSyousaiBean.getKykmeigihnkKahikbn().getValue());
        hzKykSyousaiOutBean.setIwsSyoukensaihkkahikbn(dsKeiyakuSyousaiBean.getSyoukensaihkKahikbn().getValue());
        hzKykSyousaiOutBean.setIwsStdrsktkytthkkahikbn(dsKeiyakuSyousaiBean.getStdrsktkytthkKahikbn().getValue());
        hzKykSyousaiOutBean.setIwsTargettkhkkahikbn(dsKeiyakuSyousaiBean.getTargettkhkKahikbn().getValue());
        hzKykSyousaiOutBean.setIwsHokenkngkksnkekkakbn(dsKeiyakuSyousaiBean.getHokenkngkksnkekkaKbn().getValue());
        hzKykSyousaiOutBean.setIwsKykniyusyoukaikahikbn(dsKeiyakuSyousaiBean.getKykniyusyoukaiKahikbn().getValue());
        hzKykSyousaiOutBean.setIwsTumitatekinitenkahikbn(dsKeiyakuSyousaiBean.getTumitatekinitenKahikbn().getValue());
        hzKykSyousaiOutBean.setIwsDskaiyakukahikbn(dsKeiyakuSyousaiBean.getDskaiyakuKahikbn().getValue());
        hzKykSyousaiOutBean.setIwsAdrhenkoukahikbn(dsKeiyakuSyousaiBean.getAdrhenkouKahikbn().getValue());
        hzKykSyousaiOutBean.setIwsPhrkhouhenkoukahikbn(dsKeiyakuSyousaiBean.getPhrkhouhenkouKahikbn().getValue());
        hzKykSyousaiOutBean.setIwsHknkkn3hyoujiumu(dsKeiyakuSyousaiBean.getDai3HknkknhyoujiUmu().getValue());
        hzKykSyousaiOutBean.setIwsYakkanbunsyono(dsKeiyakuSyousaiBean.getYakkanBunsyoNo());
        hzKykSyousaiOutBean.setIwsYoteiriritu(dsKeiyakuSyousaiBean.getYoteiRiritu());
        hzKykSyousaiOutBean.setIwsTumitateriritustr(dsKeiyakuSyousaiBean.getTumitateRiritu());
        hzKykSyousaiOutBean.setIwsLoadinghnkgtmttrrt(dsKeiyakuSyousaiBean.getLoadinghnkgtmttrrt());

        return hzKykSyousaiOutBean;
    }

    private String dateToStr(BizDate pDate) {

        if (pDate == null) {
            return null;
        }

        return pDate.toString();
    }
}
