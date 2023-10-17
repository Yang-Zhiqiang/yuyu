package yuyu.app.dsweb.dwhozeninfo.dwgethozentrkkzkinfo;

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
import yuyu.common.direct.dscommon.DsGetKeiyakuCommon;
import yuyu.common.direct.dscommon.TrkKazokuBean;
import yuyu.common.dsweb.dwcommon.DwMessageCodeConstants;
import yuyu.common.hozen.khcommon.GetKhKykdrInfo;
import yuyu.common.hozen.khcommon.GetKhKykdrInfoBean;
import yuyu.def.MessageId;
import yuyu.def.biz.bean.param.WsBzWebserviceReqParamBean;
import yuyu.def.biz.bean.param.WsBzWebserviceResParamBean;
import yuyu.def.classification.C_AccessLogSyubetuKbn;
import yuyu.def.classification.C_KahiKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSonotaTkyk;
import yuyu.def.dsweb.bean.webservice.WsDwGetHozenTrkkzkInfoInputBean;
import yuyu.def.dsweb.bean.webservice.WsDwGetHozenTrkkzkInfoOutputBean;
import yuyu.def.hozen.manager.HozenDomManager;

/**
 * 保全登録家族情報取得サービスの実装クラスです。<br />
 */
public class DwGetHozenTrkkzkInfoImpl implements DwGetHozenTrkkzkInfo {

    @Inject
    private static Logger logger;

    @Inject
    private HozenDomManager hozenDomManager;

    @Override
    public WsBzWebserviceResParamBean execPostForm(MultivaluedMap<String, String> pMap) {

        logger.info(MessageUtil.getMessage(MessageId.IBF0016, MessageUtil.getMessage(MessageId.INW1027)));

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean;

        try {

            wsBzWebserviceResParamBean = getHozenTrkkzkInfoMain(pMap);

        } catch (Exception throwable) {

            DsDB2Util dsDB2Util = SWAKInjector.getInstance(DsDB2Util.class);

            DsDB2Util.E_Result result = dsDB2Util.exec(throwable);

            String dsmsgcd = "";

            if (DsDB2Util.E_Result.DEADLOCK.compareTo(result) == 0) {
                dsmsgcd = DwMessageCodeConstants.IWSDSMSGCD_020201;
            }
            else if (DsDB2Util.E_Result.QUERY_TIMEOUT.compareTo(result) == 0) {
                dsmsgcd = DwMessageCodeConstants.IWSDSMSGCD_020200;
            }
            else if (DsDB2Util.E_Result.OTHER.compareTo(result) == 0) {
                throw throwable;
            }

            WsDwGetHozenTrkkzkInfoOutputBean wsDwGetHozenTrkkzkInfoOutputBean =
                SWAKInjector.getInstance(WsDwGetHozenTrkkzkInfoOutputBean.class);
            wsBzWebserviceResParamBean = SWAKInjector.getInstance(WsBzWebserviceResParamBean.class);
            wsDwGetHozenTrkkzkInfoOutputBean.setIwsDsmsgcd(dsmsgcd);
            wsBzWebserviceResParamBean.setGyoumuData(JSON.encode(wsDwGetHozenTrkkzkInfoOutputBean));
        } finally {
            logger.info(MessageUtil.getMessage(MessageId.IBF0017, MessageUtil.getMessage(MessageId.INW1027)));
        }

        return wsBzWebserviceResParamBean;

    }

    @Transactional
    WsBzWebserviceResParamBean getHozenTrkkzkInfoMain(MultivaluedMap<String, String> pMap) {

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

        WsDwGetHozenTrkkzkInfoInputBean wsDwGetHozenTrkkzkInfoInputBean =
            JSON.decode(gyoumuData, WsDwGetHozenTrkkzkInfoInputBean.class);

        WebServiceAccesslogOutput webServiceAccesslogOutput =
            SWAKInjector.getInstance(WebServiceAccesslogOutput.class);
        webServiceAccesslogOutput.exec(C_AccessLogSyubetuKbn.ACTION_BEGIN,
            wsBzWebserviceReqParamBean, wsDwGetHozenTrkkzkInfoInputBean);

        WsDwGetHozenTrkkzkInfoOutputBean wsDwGetHozenTrkkzkInfoOutputBean =
            SWAKInjector.getInstance(WsDwGetHozenTrkkzkInfoOutputBean.class);
        WsBzWebserviceResParamBean wsBzWebserviceResParamBean =
            SWAKInjector.getInstance(WsBzWebserviceResParamBean.class);

        boolean chkRet = wsDwGetHozenTrkkzkInfoInputBean.chkInput();
        if (!chkRet) {
            wsDwGetHozenTrkkzkInfoOutputBean.setIwsDsmsgcd(DwMessageCodeConstants.IWSDSMSGCD_020100);
            wsBzWebserviceResParamBean.setGyoumuData(JSON.encode(wsDwGetHozenTrkkzkInfoOutputBean));

            return wsBzWebserviceResParamBean;
        }

        Validator validator = SWAKInjector.getInstance(Validator.class);
        Set<ConstraintViolation<WsDwGetHozenTrkkzkInfoInputBean>> chkKekkaSet =
            validator.validate(wsDwGetHozenTrkkzkInfoInputBean);

        if (chkKekkaSet.size() > 0) {
            wsDwGetHozenTrkkzkInfoOutputBean.setIwsDsmsgcd(DwMessageCodeConstants.IWSDSMSGCD_020100);
            wsBzWebserviceResParamBean.setGyoumuData(JSON.encode(wsDwGetHozenTrkkzkInfoOutputBean));

            return wsBzWebserviceResParamBean;
        }

        wsDwGetHozenTrkkzkInfoOutputBean = getHozenTrkkzkInfo(wsDwGetHozenTrkkzkInfoInputBean.getIwsSyono());

        wsBzWebserviceResParamBean.setGyoumuData(JSON.encode(wsDwGetHozenTrkkzkInfoOutputBean));

        return wsBzWebserviceResParamBean;
    }

    private WsDwGetHozenTrkkzkInfoOutputBean getHozenTrkkzkInfo(String pSyoNo) {

        WsDwGetHozenTrkkzkInfoOutputBean wsDwGetHozenTrkkzkInfoOutputBean = SWAKInjector
            .getInstance(WsDwGetHozenTrkkzkInfoOutputBean.class);

        C_UmuKbn kykdrtkykhukaumu = C_UmuKbn.NONE;

        String kkdairinmKn = "";

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(pSyoNo);

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        if (C_UmuKbn.ARI.eq(kykSonotaTkyk.getKykdrtkykhukaumu())) {

            GetKhKykdrInfo getKhKykdrInfo = SWAKInjector.getInstance(GetKhKykdrInfo.class);

            GetKhKykdrInfoBean getKhKykdrInfoBean = getKhKykdrInfo.exec(kykKihon);

            kykdrtkykhukaumu = kykSonotaTkyk.getKykdrtkykhukaumu();

            kkdairinmKn = getKhKykdrInfoBean.getKkdairinmKn();
        }

        DsGetKeiyakuCommon dsGetKeiyakuCommon = SWAKInjector.getInstance(DsGetKeiyakuCommon.class);

        TrkKazokuBean trkKazokuBean = dsGetKeiyakuCommon.getTrkKazoku(pSyoNo);

        wsDwGetHozenTrkkzkInfoOutputBean.setIwsDsmsgcd(DwMessageCodeConstants.IWSDSMSGCD_020000);
        wsDwGetHozenTrkkzkInfoOutputBean.setIwsSyono(pSyoNo);
        wsDwGetHozenTrkkzkInfoOutputBean.setIwsKykdairinmkn(kkdairinmKn);
        wsDwGetHozenTrkkzkInfoOutputBean.setIwsKykdrtkhkumu(kykdrtkykhukaumu.getValue());
        wsDwGetHozenTrkkzkInfoOutputBean.setIwsKzktrkkykdrkahikbn(C_KahiKbn.KA.getValue());

        wsDwGetHozenTrkkzkInfoOutputBean.setIwsTrkkzkkbn1(trkKazokuBean.getTrkkzkKbn1().getValue());
        wsDwGetHozenTrkkzkInfoOutputBean.setIwsTrkkzkumu1(trkKazokuBean.getTrkkzkumuKbn1().getValue());
        wsDwGetHozenTrkkzkInfoOutputBean.setIwsTrkkzknmkn1(trkKazokuBean.getTrkkzknmKn1());
        wsDwGetHozenTrkkzkInfoOutputBean.setIwsTrkkzknmkj1(trkKazokuBean.getTrkkzknmKj1());
        wsDwGetHozenTrkkzkInfoOutputBean.setIwsTrkkzkseiymd1(dateToStr(trkKazokuBean.getTrkkzkseiYmd1()));
        wsDwGetHozenTrkkzkInfoOutputBean.setIwsTrkkzksei1((trkKazokuBean.getTrkkzkSei1().getValue()));
        wsDwGetHozenTrkkzkInfoOutputBean.setIwsTrkkzkseikj1((trkKazokuBean.getTrkkzkSei1().getContent()));
        wsDwGetHozenTrkkzkInfoOutputBean.setIwsTrkkzktdk1((trkKazokuBean.getTrkkzkTdk1().getValue()));
        wsDwGetHozenTrkkzkInfoOutputBean.setIwsTrkkzktdkkj1((trkKazokuBean.getTrkkzkTdk1().getContent()));
        wsDwGetHozenTrkkzkInfoOutputBean.setIwsTrkkzktsinkokyno1(trkKazokuBean.getTrkkzkYno1());
        wsDwGetHozenTrkkzkInfoOutputBean.setIwsTrkkzktsinadr1kj1(trkKazokuBean.getTrkkzkadr1Kj1());
        wsDwGetHozenTrkkzkInfoOutputBean.setIwsTrkkzktsinadr2kj1(trkKazokuBean.getTrkkzkadr2Kj1());
        wsDwGetHozenTrkkzkInfoOutputBean.setIwsTrkkzktsinadr3kj1(trkKazokuBean.getTrkkzkadr3Kj1());
        wsDwGetHozenTrkkzkInfoOutputBean.setIwsTrkkzktsintelno1(trkKazokuBean.getTrkkzkTelno1());
        wsDwGetHozenTrkkzkInfoOutputBean.setIwsGyoumukousintime1(trkKazokuBean.getGyoumuKousinTime1());

        wsDwGetHozenTrkkzkInfoOutputBean.setIwsTrkkzkkbn2(trkKazokuBean.getTrkkzkKbn2().getValue());
        wsDwGetHozenTrkkzkInfoOutputBean.setIwsTrkkzkumu2(trkKazokuBean.getTrkkzkumuKbn2().getValue());
        wsDwGetHozenTrkkzkInfoOutputBean.setIwsTrkkzknmkn2(trkKazokuBean.getTrkkzknmKn2());
        wsDwGetHozenTrkkzkInfoOutputBean.setIwsTrkkzknmkj2(trkKazokuBean.getTrkkzknmKj2());
        wsDwGetHozenTrkkzkInfoOutputBean.setIwsTrkkzkseiymd2(dateToStr(trkKazokuBean.getTrkkzkseiYmd2()));
        wsDwGetHozenTrkkzkInfoOutputBean.setIwsTrkkzksei2((trkKazokuBean.getTrkkzkSei2().getValue()));
        wsDwGetHozenTrkkzkInfoOutputBean.setIwsTrkkzkseikj2((trkKazokuBean.getTrkkzkSei2().getContent()));
        wsDwGetHozenTrkkzkInfoOutputBean.setIwsTrkkzktdk2((trkKazokuBean.getTrkkzkTdk2().getValue()));
        wsDwGetHozenTrkkzkInfoOutputBean.setIwsTrkkzktdkkj2((trkKazokuBean.getTrkkzkTdk2().getContent()));
        wsDwGetHozenTrkkzkInfoOutputBean.setIwsTrkkzktsinkokyno2(trkKazokuBean.getTrkkzkYno2());
        wsDwGetHozenTrkkzkInfoOutputBean.setIwsTrkkzktsinadr1kj2(trkKazokuBean.getTrkkzkadr1Kj2());
        wsDwGetHozenTrkkzkInfoOutputBean.setIwsTrkkzktsinadr2kj2(trkKazokuBean.getTrkkzkadr2Kj2());
        wsDwGetHozenTrkkzkInfoOutputBean.setIwsTrkkzktsinadr3kj2(trkKazokuBean.getTrkkzkadr3Kj2());
        wsDwGetHozenTrkkzkInfoOutputBean.setIwsTrkkzktsintelno2(trkKazokuBean.getTrkkzkTelno2());
        wsDwGetHozenTrkkzkInfoOutputBean.setIwsGyoumukousintime2(trkKazokuBean.getGyoumuKousinTime2());

        return wsDwGetHozenTrkkzkInfoOutputBean;
    }

    private String dateToStr(BizDate pDate) {

        if (pDate == null) {
            return null;
        }

        return pDate.toString();
    }
}
