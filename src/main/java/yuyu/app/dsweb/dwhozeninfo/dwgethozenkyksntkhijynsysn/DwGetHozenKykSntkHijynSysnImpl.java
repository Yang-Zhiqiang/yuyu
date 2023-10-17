package yuyu.app.dsweb.dwhozeninfo.dwgethozenkyksntkhijynsysn;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import javax.ws.rs.core.MultivaluedMap;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.util.message.MessageUtil;
import net.arnx.jsonic.JSON;

import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bzcommon.GetKawaseRate;
import yuyu.common.biz.bzcommon.GetYoteiriritu;
import yuyu.common.biz.bzcommon.GetYoteirirituBean;
import yuyu.common.biz.bzcommon.KeisanGaikakanzan;
import yuyu.common.biz.bzwebserviceaccesslogoutput.WebServiceAccesslogOutput;
import yuyu.common.direct.dscommon.DsDB2Util;
import yuyu.common.direct.dscommon.DsGetKeiyakuCommon;
import yuyu.common.direct.dscommon.DsGetSeigyo;
import yuyu.common.direct.dscommon.DsSyouhinBean;
import yuyu.common.direct.dscommon.GamenSeigyoBean;
import yuyu.common.direct.dscommon.HihokensyaBean;
import yuyu.common.direct.dscommon.HokenKikanBean;
import yuyu.common.direct.dscommon.HosyouBean;
import yuyu.common.direct.dscommon.KeiyakuKihonBean;
import yuyu.common.direct.dscommon.KeiyakuUketorininBean;
import yuyu.common.direct.dscommon.KeiyakusyaBean;
import yuyu.common.direct.dscommon.SyoriKahiBean;
import yuyu.common.direct.dscommon.TokuyakuBean;
import yuyu.common.direct.dscommon.TrkKazokuBean;
import yuyu.common.dsweb.dwcommon.DwMessageCodeConstants;
import yuyu.common.hozen.ascommon.KeisanRsgaku;
import yuyu.common.hozen.ascommon.KeisanRsgakuConstants;
import yuyu.common.hozen.ascommon.KeisanRsgkOutBean;
import yuyu.common.hozen.ascommon.KeisanRsgkUtiwakeBean;
import yuyu.common.hozen.khcommon.KeisanCommonKaiyaku;
import yuyu.common.hozen.khcommon.KeisanCommonKaiyakuOutBean;
import yuyu.common.hozen.khcommon.KeisanKaiyakuBean;
import yuyu.common.hozen.khcommon.KeisanKihrkP;
import yuyu.common.siharai.sicommon.CalcHkShrKngk;
import yuyu.def.MessageId;
import yuyu.def.biz.bean.param.WsBzWebserviceReqParamBean;
import yuyu.def.biz.bean.param.WsBzWebserviceResParamBean;
import yuyu.def.classification.C_AccessLogSyubetuKbn;
import yuyu.def.classification.C_DsSyouhnbunruiKbn;
import yuyu.def.classification.C_EigyoubiHoseiKbn;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_HasuusyoriKbn;
import yuyu.def.classification.C_HokenkinsyuruiKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_KahiKbn;
import yuyu.def.classification.C_KawaserateSyuruiKbn;
import yuyu.def.classification.C_KawasetekiyoKbn;
import yuyu.def.classification.C_KawasetsryKbn;
import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_Nykkeiro;
import yuyu.def.classification.C_NyknaiyouKbn;
import yuyu.def.classification.C_SiinKbn;
import yuyu.def.classification.C_SyoriKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.db.entity.IT_AnsyuKihon;
import yuyu.def.db.entity.IT_KhTtdkRireki;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.db.entity.IT_NyknJissekiRireki;
import yuyu.def.db.entity.IT_Zennou;
import yuyu.def.dsweb.bean.webservice.WsDwGetHozenKykSntkHijynSysnInputBean;
import yuyu.def.dsweb.bean.webservice.WsDwGetHozenKykSntkHijynSysnOutputBean;
import yuyu.def.hozen.manager.HozenDomManager;

/**
 * 保全契約詳細取得（選択通貨建平準払終身）サービスの実装クラスです。<br />
 */
public class DwGetHozenKykSntkHijynSysnImpl implements DwGetHozenKykSntkHijynSysn {

    @Inject
    private static Logger logger;

    @Inject
    private HozenDomManager hozenDomManager;

    @Override
    public WsBzWebserviceResParamBean execPostForm(MultivaluedMap<String, String> pMap) {

        logger.info(MessageUtil.getMessage(MessageId.IBF0016, MessageUtil.getMessage(MessageId.INW1029)));

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean;

        try {

            wsBzWebserviceResParamBean = getHozenKykSntkHijynSysnMain(pMap);

        } catch (Exception throwable) {

            DsDB2Util dsDB2Util = SWAKInjector.getInstance(DsDB2Util.class);

            DsDB2Util.E_Result result = dsDB2Util.exec(throwable);

            String dsmsgcd = "";

            if (DsDB2Util.E_Result.DEADLOCK.compareTo(result) == 0) {
                dsmsgcd = DwMessageCodeConstants.IWSDSMSGCD_022210;
            }
            else if (DsDB2Util.E_Result.QUERY_TIMEOUT.compareTo(result) == 0) {
                dsmsgcd = DwMessageCodeConstants.IWSDSMSGCD_022209;
            }
            else if (DsDB2Util.E_Result.OTHER.compareTo(result) == 0) {
                throw throwable;
            }

            WsDwGetHozenKykSntkHijynSysnOutputBean wsDwGetHozenKykSntkHijynSysnOutputBean =
                SWAKInjector.getInstance(WsDwGetHozenKykSntkHijynSysnOutputBean.class);
            wsBzWebserviceResParamBean = SWAKInjector.getInstance(WsBzWebserviceResParamBean.class);

            wsDwGetHozenKykSntkHijynSysnOutputBean.setIwsDsmsgcd(dsmsgcd);

            wsBzWebserviceResParamBean.setGyoumuData(JSON.encode(wsDwGetHozenKykSntkHijynSysnOutputBean));

        } finally {

            logger.info(MessageUtil.getMessage(MessageId.IBF0017, MessageUtil.getMessage(MessageId.INW1029)));
        }

        return wsBzWebserviceResParamBean;
    }

    @Transactional
    WsBzWebserviceResParamBean getHozenKykSntkHijynSysnMain(MultivaluedMap<String, String> pMap) {

        WsBzWebserviceReqParamBean wsBzWebserviceReqParamBean = SWAKInjector.getInstance(WsBzWebserviceReqParamBean.class);

        try {
            BeanUtils.populate(wsBzWebserviceReqParamBean, pMap);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }

        String gyoumuData = wsBzWebserviceReqParamBean.getGyoumuData();

        WsDwGetHozenKykSntkHijynSysnInputBean wsDwGetHozenKykSntkHijynSysnInputBean =
            JSON.decode(gyoumuData, WsDwGetHozenKykSntkHijynSysnInputBean.class);

        WebServiceAccesslogOutput webServiceAccesslogOutput =
            SWAKInjector.getInstance(WebServiceAccesslogOutput.class);

        webServiceAccesslogOutput.exec(C_AccessLogSyubetuKbn.ACTION_BEGIN, wsBzWebserviceReqParamBean,
            wsDwGetHozenKykSntkHijynSysnInputBean);

        WsDwGetHozenKykSntkHijynSysnOutputBean wsDwGetHozenKykSntkHijynSysnOutputBean =
            SWAKInjector.getInstance(WsDwGetHozenKykSntkHijynSysnOutputBean.class);
        WsBzWebserviceResParamBean wsBzWebserviceResParamBean =
            SWAKInjector.getInstance(WsBzWebserviceResParamBean.class);

        boolean chkRet = wsDwGetHozenKykSntkHijynSysnInputBean.chkInput();

        if (!chkRet) {
            wsDwGetHozenKykSntkHijynSysnOutputBean.setIwsDsmsgcd(DwMessageCodeConstants.IWSDSMSGCD_022100);
            wsBzWebserviceResParamBean.setGyoumuData(JSON.encode(wsDwGetHozenKykSntkHijynSysnOutputBean));

            return wsBzWebserviceResParamBean;
        }

        Validator validator = SWAKInjector.getInstance(Validator.class);
        Set<ConstraintViolation<WsDwGetHozenKykSntkHijynSysnInputBean>> chkKekkaSet =
            validator.validate(wsDwGetHozenKykSntkHijynSysnInputBean);

        if (chkKekkaSet.size() > 0) {
            wsDwGetHozenKykSntkHijynSysnOutputBean.setIwsDsmsgcd(DwMessageCodeConstants.IWSDSMSGCD_022100);
            wsBzWebserviceResParamBean.setGyoumuData(JSON.encode(wsDwGetHozenKykSntkHijynSysnOutputBean));

            return wsBzWebserviceResParamBean;
        }

        wsDwGetHozenKykSntkHijynSysnOutputBean = getHozenKykSntkHijynSysn(wsDwGetHozenKykSntkHijynSysnInputBean.getIwsSyono());

        wsBzWebserviceResParamBean.setGyoumuData(JSON.encode(wsDwGetHozenKykSntkHijynSysnOutputBean));

        return wsBzWebserviceResParamBean;
    }

    private WsDwGetHozenKykSntkHijynSysnOutputBean getHozenKykSntkHijynSysn(String pSyoNo) {

        WsDwGetHozenKykSntkHijynSysnOutputBean wsDwGetHozenKykSntkHijynSysnOutputBean =
            SWAKInjector.getInstance(WsDwGetHozenKykSntkHijynSysnOutputBean.class);

        DsGetKeiyakuCommon dsGetKeiyakuCommon = SWAKInjector.getInstance(DsGetKeiyakuCommon.class);

        KeiyakuKihonBean keiyakuKihonBean = dsGetKeiyakuCommon.getKykKihon(pSyoNo);

        if (C_ErrorKbn.ERROR.eq(keiyakuKihonBean.getErrorKbn())) {

            wsDwGetHozenKykSntkHijynSysnOutputBean.setIwsDsmsgcd(DwMessageCodeConstants.IWSDSMSGCD_022200);

            return wsDwGetHozenKykSntkHijynSysnOutputBean;
        }

        KeiyakusyaBean keiyakusyaBean = dsGetKeiyakuCommon.getKykSya(pSyoNo);
        if (C_ErrorKbn.ERROR.eq(keiyakusyaBean.getErrorKbn())) {

            wsDwGetHozenKykSntkHijynSysnOutputBean.setIwsDsmsgcd(DwMessageCodeConstants.IWSDSMSGCD_022201);

            return wsDwGetHozenKykSntkHijynSysnOutputBean;

        }

        HihokensyaBean hihokensyaBean = dsGetKeiyakuCommon.getHhknSya(pSyoNo);
        if (C_ErrorKbn.ERROR.eq(hihokensyaBean.getErrorKbn())) {

            wsDwGetHozenKykSntkHijynSysnOutputBean.setIwsDsmsgcd(DwMessageCodeConstants.IWSDSMSGCD_022202);

            return wsDwGetHozenKykSntkHijynSysnOutputBean;

        }

        KeiyakuUketorininBean keiyakuUketorininBean = dsGetKeiyakuCommon.getKykUkt(pSyoNo);
        TrkKazokuBean trkKazokuBean = dsGetKeiyakuCommon.getTrkKazoku(pSyoNo);
        HokenKikanBean hokenKikanBean = dsGetKeiyakuCommon.getHokenKikan(pSyoNo);

        DsGetSeigyo dsGetSeigyo = SWAKInjector.getInstance(DsGetSeigyo.class);

        DsSyouhinBean dsSyouhinBean = SWAKInjector.getInstance(DsSyouhinBean.class);
        dsSyouhinBean.setSyoNo(pSyoNo);
        dsSyouhinBean.setDsSyouhnbunruiKbn(C_DsSyouhnbunruiKbn.SNTKDTHIJYNBRSYSN);

        GamenSeigyoBean gamenSeigyoBean = dsGetSeigyo.getGamenSeigyo(dsSyouhinBean);
        if (C_ErrorKbn.ERROR.eq(gamenSeigyoBean.getErrorKbn())) {

            wsDwGetHozenKykSntkHijynSysnOutputBean.setIwsDsmsgcd(DwMessageCodeConstants.IWSDSMSGCD_022203);

            return wsDwGetHozenKykSntkHijynSysnOutputBean;
        }

        HosyouBean hosyouBean = dsGetSeigyo.getHosyou(dsSyouhinBean);
        if (C_ErrorKbn.ERROR.eq(hosyouBean.getErrorKbn())) {

            wsDwGetHozenKykSntkHijynSysnOutputBean.setIwsDsmsgcd(DwMessageCodeConstants.IWSDSMSGCD_022204);

            return wsDwGetHozenKykSntkHijynSysnOutputBean;
        }

        TokuyakuBean tokuyakuBean = dsGetSeigyo.getTokuyaku(dsSyouhinBean);
        if (C_ErrorKbn.ERROR.eq(tokuyakuBean.getErrorKbn())) {

            wsDwGetHozenKykSntkHijynSysnOutputBean.setIwsDsmsgcd(DwMessageCodeConstants.IWSDSMSGCD_022205);

            return wsDwGetHozenKykSntkHijynSysnOutputBean;

        }

        SyoriKahiBean syoriKahiBean = dsGetSeigyo.getSyoriKahi(dsSyouhinBean);
        if (C_ErrorKbn.ERROR.eq(syoriKahiBean.getErrorKbn())) {

            wsDwGetHozenKykSntkHijynSysnOutputBean.setIwsDsmsgcd(DwMessageCodeConstants.IWSDSMSGCD_022206);

            return wsDwGetHozenKykSntkHijynSysnOutputBean;
        }

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(pSyoNo);

        if (kykKihon == null) {

            wsDwGetHozenKykSntkHijynSysnOutputBean.setIwsDsmsgcd(DwMessageCodeConstants.IWSDSMSGCD_022200);

            return wsDwGetHozenKykSntkHijynSysnOutputBean;
        }

        List<IT_KykSyouhn> kykSyouhnList = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        if (kykSyouhnList == null || kykSyouhnList.size() == 0) {

            wsDwGetHozenKykSntkHijynSysnOutputBean.setIwsDsmsgcd(DwMessageCodeConstants.IWSDSMSGCD_022200);

            return wsDwGetHozenKykSntkHijynSysnOutputBean;
        }

        IT_KykSyouhn kykSyouhn = kykSyouhnList.get(0);

        List<IT_NyknJissekiRireki> nyknJissekiRirekiLst = kykKihon.getNyknJissekiRirekisByNykkeiro(C_Nykkeiro.SKEI);

        if (nyknJissekiRirekiLst == null || nyknJissekiRirekiLst.size() == 0) {

            wsDwGetHozenKykSntkHijynSysnOutputBean.setIwsDsmsgcd(DwMessageCodeConstants.IWSDSMSGCD_022207);

            return wsDwGetHozenKykSntkHijynSysnOutputBean;
        }

        IT_NyknJissekiRireki nyknJissekiRireki = nyknJissekiRirekiLst.get(0);

        IT_AnsyuKihon ansyuKihon = hozenDomManager.getAnsyuKihon(pSyoNo);

        if (ansyuKihon == null) {

            wsDwGetHozenKykSntkHijynSysnOutputBean.setIwsDsmsgcd(DwMessageCodeConstants.IWSDSMSGCD_022208);

            return wsDwGetHozenKykSntkHijynSysnOutputBean;
        }

        C_UmuKbn zennouUmu = null;
        IT_Zennou zennou = new IT_Zennou();

        List<IT_Zennou> zennouList = ansyuKihon.getZennous();

        if (zennouList != null && zennouList.size() != 0 && C_Kykjyoutai.ZENNOU.eq(kykSyouhn.getKykjyoutai())) {

            zennouUmu = C_UmuKbn.ARI;

            zennou = zennouList.get(0);
        }
        else {

            zennouUmu = C_UmuKbn.NONE;
        }

        C_KahiKbn hrkmPGkGkKeisanKahiKbn = C_KahiKbn.HUKA;
        C_UmuKbn gengkUmu = C_UmuKbn.NONE;
        C_UmuKbn seiymdseitsUmu = C_UmuKbn.NONE;
        C_UmuKbn kaisuuhnkUmu = C_UmuKbn.NONE;

        List<IT_KhTtdkRireki> gengkList = kykKihon.getKhTtdkRirekisByGyoumuKousinKinou("khgengaku");

        if (gengkList.size() != 0) {

            gengkUmu = C_UmuKbn.ARI;
        }

        List<IT_KhTtdkRireki> seiymdseitsList = kykKihon.getKhTtdkRirekisByGyoumuKousinKinou("khseinengappiseiteisei");

        if (seiymdseitsList.size() != 0) {

            seiymdseitsUmu = C_UmuKbn.ARI;
        }

        List<IT_KhTtdkRireki> haraikatahnkList = kykKihon.getKhTtdkRirekisByGyoumuKousinKinou("khharaikatahenkou");

        for (IT_KhTtdkRireki khTtdkRireki : haraikatahnkList) {
            if (!C_SyoriKbn.KOUZAHENKOU.eq(khTtdkRireki.getSyorikbn())) {

                kaisuuhnkUmu = C_UmuKbn.ARI;
            }
        }

        if (C_UmuKbn.NONE.eq(gengkUmu) &&
            C_UmuKbn.NONE.eq(seiymdseitsUmu) &&
            C_UmuKbn.NONE.eq(kaisuuhnkUmu)) {

            hrkmPGkGkKeisanKahiKbn = C_KahiKbn.KA;
        }

        String hrkKaisuu = "";

        if (C_Hrkkaisuu.NEN.eq(kykKihon.getHrkkaisuu()) && C_Kykjyoutai.ZENNOU.eq(kykSyouhn.getKykjyoutai())) {

            hrkKaisuu = kykKihon.getHrkkaisuu().getContent() + "（" + "全期前納" + "）";
        }
        else {

            hrkKaisuu = kykKihon.getHrkkaisuu().getContent();
        }

        GetKawaseRate getKawaseRate = SWAKInjector.getInstance(GetKawaseRate.class);

        BizDate sysDate = BizDate.getSysDate();

        C_ErrorKbn getKawaseRateSakuseiErrorKbn = getKawaseRate.exec(
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

        if (C_ErrorKbn.OK.eq(getKawaseRateSakuseiErrorKbn)) {

            kawaseRateSakusei = getKawaseRate.getKawaserate();
            kawaseRateKjYmdSakusei = getKawaseRate.getKwsrateKjYmd();
        }

        C_ErrorKbn getGaikaShrKawaseRateSakuseiErrorKbn = getKawaseRate.exec(
            sysDate,
            C_KawaserateSyuruiKbn.KOUJIKAWASERATE,
            kykSyouhn.getKyktuukasyu(),
            C_Tuukasyu.JPY,
            C_KawasetekiyoKbn.TTM,
            C_KawasetsryKbn.NYUKINRATE,
            C_EigyoubiHoseiKbn.BLNK,
            C_YouhiKbn.YOU);

        BizNumber gaikaShrKawaseRateSakusei = null;

        if (C_ErrorKbn.OK.eq(getGaikaShrKawaseRateSakuseiErrorKbn)) {

            gaikaShrKawaseRateSakusei = getKawaseRate.getKawaserate();
        }

        GetYoteirirituBean getYoteirirituBean = SWAKInjector.getInstance(GetYoteirirituBean.class);

        getYoteirirituBean.setSyouhncd(kykSyouhn.getSyouhncd());
        getYoteirirituBean.setKykymd(kykSyouhn.getKykymd());
        getYoteirirituBean.setTuukasyu(keiyakuKihonBean.getKykTuukasyu());

        GetYoteiriritu getYoteiriritu = SWAKInjector.getInstance(GetYoteiriritu.class);

        C_ErrorKbn getYoteirirituErrorKbn = getYoteiriritu.exec(getYoteirirituBean);
        BizNumber yoteiriritu = BizNumber.ZERO;

        if (C_ErrorKbn.OK.eq(getYoteirirituErrorKbn)) {

            yoteiriritu = getYoteiriritu.getYoteiriritu().multiply(100);
        }

        CalcHkShrKngk calcHkShrKngk = SWAKInjector.getInstance(CalcHkShrKngk.class);
        KeisanGaikakanzan keisanGaikakanzan = SWAKInjector.getInstance(KeisanGaikakanzan.class);
        BizCurrency sbhknkngkGaika = BizCurrency.valueOf(0);
        BizCurrency sbhknkngkYen = BizCurrency.valueOf(0);

        C_ErrorKbn calcHkShrKngkErrorKbn = calcHkShrKngk.execByKeisanWExt(
            pSyoNo,
            sysDate,
            C_SiinKbn.SP,
            C_HokenkinsyuruiKbn.SBHOKENKIN,
            kykKihon.getSdpdkbn(),
            kykKihon.getHrkkeiro());

        if (C_ErrorKbn.OK.eq(calcHkShrKngkErrorKbn)) {
            if (!C_Tuukasyu.JPY.eq(keiyakuKihonBean.getKykTuukasyu())) {

                sbhknkngkGaika = calcHkShrKngk.getCalcHkShrKngkBean().getSibousGk();

                if (C_ErrorKbn.OK.eq(getKawaseRateSakuseiErrorKbn)) {

                    sbhknkngkYen = keisanGaikakanzan.exec(
                        C_Tuukasyu.JPY,
                        sbhknkngkGaika,
                        kawaseRateSakusei,
                        C_HasuusyoriKbn.AGE);
                }
                else {

                    sbhknkngkYen = null;
                }
            }
            else {

                sbhknkngkYen = calcHkShrKngk.getCalcHkShrKngkBean().getSibousGk();
            }
        }
        else {

            sbhknkngkGaika = null;
            sbhknkngkYen =  null;
        }

        KeisanKaiyakuBean keisanKaiyakuBean = SWAKInjector.getInstance(KeisanKaiyakuBean.class);

        keisanKaiyakuBean.setSyoruiukeymd(sysDate);
        keisanKaiyakuBean.setKaiykymd(sysDate);
        keisanKaiyakuBean.setYenshrkwsrate(kawaseRateSakusei);
        keisanKaiyakuBean.setGkshrkwsrate(gaikaShrKawaseRateSakusei);

        KeisanCommonKaiyaku keisanCommonKaiyaku = SWAKInjector.getInstance(KeisanCommonKaiyaku.class);

        C_ErrorKbn keisanCommonKaiyakuErrorKbn = keisanCommonKaiyaku.keisanKaiyakuseisankin(
            KeisanCommonKaiyaku.KINOUBUNRUI_DRCTSERVICE,
            kykKihon,
            sysDate,
            keisanKaiyakuBean
            );

        KeisanCommonKaiyakuOutBean keisanCommonKaiyakuOutBean = keisanCommonKaiyaku.getKeisanCommonKaiyakuOutBean();

        BizCurrency kaiyakujShrgkYen = BizCurrency.valueOf(0);
        BizCurrency kaiyakujShrgkGaika = BizCurrency.valueOf(0);
        BizCurrency kaiyakuhrYen = BizCurrency.valueOf(0);
        BizCurrency kaiyakuhrGaika = BizCurrency.valueOf(0);
        BizCurrency zennouzndkYen = BizCurrency.valueOf(0);
        BizCurrency zennouzndkGaika = BizCurrency.valueOf(0);
        BizCurrency sonotaShrkngkYen = BizCurrency.valueOf(0);
        BizCurrency sonotaShrkngkGaika = BizCurrency.valueOf(0);

        if (C_ErrorKbn.OK.eq(keisanCommonKaiyakuErrorKbn)) {
            if (!C_Tuukasyu.JPY.eq(keiyakuKihonBean.getKykTuukasyu())) {

                kaiyakujShrgkGaika = keisanCommonKaiyakuOutBean.getShrgkkeigk();
                kaiyakuhrGaika =keisanCommonKaiyakuOutBean.getKaiyakuHr();
                zennouzndkGaika = keisanCommonKaiyakuOutBean.getZennouseisankGk();
                sonotaShrkngkGaika = kaiyakujShrgkGaika.subtract(kaiyakuhrGaika).subtract(zennouzndkGaika);

                if (C_ErrorKbn.OK.eq(getKawaseRateSakuseiErrorKbn)) {

                    kaiyakujShrgkYen = keisanCommonKaiyakuOutBean.getShrgkkeiYen();
                    kaiyakuhrYen = keisanCommonKaiyakuOutBean.getKaiyakuHrYen();

                    if (zennouzndkGaika.compareTo(BizCurrency.valueOf(0, zennouzndkGaika.getType())) > 0) {

                        zennouzndkYen = keisanGaikakanzan.exec(
                            C_Tuukasyu.JPY,
                            zennouzndkGaika,
                            kawaseRateSakusei,
                            C_HasuusyoriKbn.AGE);
                    }

                    sonotaShrkngkYen = kaiyakujShrgkYen.subtract(kaiyakuhrYen).subtract(zennouzndkYen);
                }
                else {

                    kaiyakujShrgkYen = null;
                    kaiyakuhrYen = null;

                    if (zennouzndkGaika.compareTo(BizCurrency.valueOf(0, zennouzndkGaika.getType())) > 0) {

                        zennouzndkYen = null;
                    }

                    if (sonotaShrkngkGaika.compareTo(BizCurrency.valueOf(0, sonotaShrkngkGaika.getType())) > 0) {

                        sonotaShrkngkYen = null;
                    }
                }

                if (C_ErrorKbn.ERROR.eq(getGaikaShrKawaseRateSakuseiErrorKbn)) {

                    kaiyakujShrgkGaika = null;
                    sonotaShrkngkGaika = null;
                }
            }
            else {

                kaiyakujShrgkYen = keisanCommonKaiyakuOutBean.getShrgkkeiYen();
                kaiyakuhrYen = keisanCommonKaiyakuOutBean.getKaiyakuHrYen();
                zennouzndkYen = keisanCommonKaiyakuOutBean.getZennouseisankYen();
                sonotaShrkngkYen = kaiyakujShrgkYen.subtract(kaiyakuhrYen).subtract(zennouzndkYen);
            }
        }
        else {

            kaiyakujShrgkYen = null;
            kaiyakujShrgkGaika = null;
            kaiyakuhrYen = null;
            kaiyakuhrGaika = null;
            zennouzndkYen = null;
            zennouzndkGaika = null;
            sonotaShrkngkYen = null;
            sonotaShrkngkGaika = null;
        }

        C_KahiKbn yenhrkgkHyoujikahi = C_KahiKbn.KA;
        C_ErrorKbn rskngkksnkekkaKbn = C_ErrorKbn.OK;
        BizDateYM jkirsYmd = null;

        if (C_Tuukasyu.JPY.eq(kykSyouhn.getKyktuukasyu()) ||
            C_UmuKbn.ARI.eq(zennouUmu)) {

            yenhrkgkHyoujikahi = C_KahiKbn.HUKA;
        }
        else {
            if (BizDateUtil.compareYm(sysDate.getBizDateYM(), ansyuKihon.getJkipjytym()) == BizDateUtil.COMPARE_GREATER) {

                if (C_Hrkkaisuu.NEN.eq(kykKihon.getHrkkaisuu())) {

                    jkirsYmd = ansyuKihon.getJkipjytym().addYears(1);
                    yenhrkgkHyoujikahi = C_KahiKbn.HUKA;
                }
                else if (C_Hrkkaisuu.HALFY.eq(kykKihon.getHrkkaisuu())) {

                    jkirsYmd = ansyuKihon.getJkipjytym().addMonths(6);
                    yenhrkgkHyoujikahi = C_KahiKbn.HUKA;
                }
                else {

                    jkirsYmd = sysDate.getBizDateYM();
                    yenhrkgkHyoujikahi = C_KahiKbn.KA;
                }
            }
            else if (BizDateUtil.compareYm(sysDate.getBizDateYM(), ansyuKihon.getJkipjytym()) == BizDateUtil.COMPARE_EQUAL) {

                jkirsYmd = sysDate.getBizDateYM();
                yenhrkgkHyoujikahi = C_KahiKbn.KA;
            }
            else {

                jkirsYmd = ansyuKihon.getJkipjytym();
                yenhrkgkHyoujikahi = C_KahiKbn.HUKA;
            }
        }

        BizCurrency yenkansanHokenryou = BizCurrency.valueOf(0);
        BizDate yenknsnkijyunYmd = null;
        BizNumber hokenryoukktiKwsrate = BizNumber.valueOf(0);
        int jyuutouNensuu = 0;
        int jyuutouTukisuu = 0;
        List<String> errorCd = new ArrayList<String>();

        if (C_Hrkkaisuu.NEN.eq(kykKihon.getHrkkaisuu())) {

            jyuutouNensuu = 1;
        }
        else {

            jyuutouNensuu = 0;
        }

        if (C_Hrkkaisuu.HALFY.eq(kykKihon.getHrkkaisuu())) {

            jyuutouTukisuu = 6;
        }
        else {
            if (C_Hrkkaisuu.TUKI.eq(kykKihon.getHrkkaisuu())) {

                jyuutouTukisuu = 1;
            }
            else {

                jyuutouTukisuu = 0;
            }
        }

        if (C_KahiKbn.KA.eq(yenhrkgkHyoujikahi)) {

            KeisanRsgaku keisanRsgaku = SWAKInjector.getInstance(KeisanRsgaku.class);

            rskngkksnkekkaKbn = keisanRsgaku.exec(
                kykKihon,
                C_Nykkeiro.OTHER,
                C_NyknaiyouKbn.KEIZOKUP,
                sysDate,
                sysDate.getBizDateYM(),
                jyuutouNensuu,
                jyuutouTukisuu);

            errorCd = keisanRsgaku.getErrorCd();
            KeisanRsgkOutBean keisanRsgkUtiwakeBean = keisanRsgaku.getKeisanRsgkOutBean();

            if (C_ErrorKbn.OK.eq(rskngkksnkekkaKbn)) {

                List<KeisanRsgkUtiwakeBean> keisanRsgkUtiwakeBeanList = keisanRsgkUtiwakeBean.getKeisanRsgkUtiwakeBeanLst();
                yenkansanHokenryou = keisanRsgkUtiwakeBeanList.get(0).getRsgaku();
                yenknsnkijyunYmd = keisanRsgkUtiwakeBeanList.get(0).getRyosyukwsratekjymd();
                hokenryoukktiKwsrate = keisanRsgkUtiwakeBeanList.get(0).getRyosyukwsrate();
            }
            else {

                yenkansanHokenryou = null;
                hokenryoukktiKwsrate = null;

                if (errorCd.contains(KeisanRsgakuConstants.ERRCD_HRKKWSRATEKJYMD_ERR) ||
                    errorCd.contains(KeisanRsgakuConstants.ERRCD_KAWASERATESYUTOKUERR)) {

                    yenhrkgkHyoujikahi = C_KahiKbn.HUKA;
                }
            }
        }

        BizCurrency kihrkmpstgkYen = BizCurrency.valueOf(0);
        BizCurrency kihrkmpstgkGaika = BizCurrency.valueOf(0);
        C_ErrorKbn keisanKihrkPErrorKbn = C_ErrorKbn.OK;

        if (C_KahiKbn.KA.eq(hrkmPGkGkKeisanKahiKbn)) {

            KeisanKihrkP keisanKihrkP = SWAKInjector.getInstance(KeisanKihrkP.class);

            keisanKihrkPErrorKbn = keisanKihrkP.exec(pSyoNo, kykSyouhn.getKyktuukasyu());

            if (C_ErrorKbn.OK.eq(keisanKihrkPErrorKbn)) {

                kihrkmpstgkYen = keisanKihrkP.getYenKihrkP();
                kihrkmpstgkGaika = keisanKihrkP.getKihrkP();
            }
            else {

                kihrkmpstgkYen = null;
                kihrkmpstgkGaika = null;
            }
        }
        else {

            kihrkmpstgkYen = null;
            kihrkmpstgkGaika = null;
        }

        BizCurrency kykznnP = BizCurrency.valueOf(0);
        String kykznnprsyTuukasyu = null;
        BizCurrency kykznnyenhrkGk = BizCurrency.valueOf(0);

        if (C_UmuKbn.ARI.eq(zennouUmu)) {

            kykznnP = zennou.getZennounyuukinkgk().add(zennou.getZennoujihrkp());
            kykznnprsyTuukasyu = zennou.getRstuukasyu().getValue();

            if (!C_Tuukasyu.JPY.eq(keiyakuKihonBean.getKykTuukasyu()) && C_Tuukasyu.JPY.eq(zennou.getRstuukasyu())) {

                kykznnyenhrkGk = zennou.getZennounyuukinkgkrstk().add(nyknJissekiRireki.getRsgaku());
            }
        }

        C_ErrorKbn kngkksnKekkakbn = C_ErrorKbn.OK;

        if (C_ErrorKbn.ERROR.eq(calcHkShrKngkErrorKbn) ||
            C_ErrorKbn.ERROR.eq(keisanCommonKaiyakuErrorKbn) ||
            C_ErrorKbn.ERROR.eq(keisanKihrkPErrorKbn)) {

            kngkksnKekkakbn = C_ErrorKbn.ERROR;
        }
        else {

            kngkksnKekkakbn = C_ErrorKbn.OK;
        }

        wsDwGetHozenKykSntkHijynSysnOutputBean.setIwsDsmsgcd(DwMessageCodeConstants.IWSDSMSGCD_022000);
        wsDwGetHozenKykSntkHijynSysnOutputBean.setIwsSyono(pSyoNo);
        wsDwGetHozenKykSntkHijynSysnOutputBean.setIwsAisyoumei(keiyakuKihonBean.getAisyoumeiKbn().getContent());
        wsDwGetHozenKykSntkHijynSysnOutputBean.setIwsSyouhnnm(keiyakuKihonBean.getSyouhnNm());
        wsDwGetHozenKykSntkHijynSysnOutputBean.setIwsKykymdstr(dateToStr(keiyakuKihonBean.getKykYmd()));
        wsDwGetHozenKykSntkHijynSysnOutputBean.setIwsKyktuukasyu(keiyakuKihonBean.getKykTuukasyu().getValue());
        wsDwGetHozenKykSntkHijynSysnOutputBean.setIwsSakuseikijyunymdstr(dateToStr(keiyakuKihonBean.getSakuseiKijyunYmd()));
        wsDwGetHozenKykSntkHijynSysnOutputBean.setIwsKyknmkn(keiyakusyaBean.getKykNmKn());
        wsDwGetHozenKykSntkHijynSysnOutputBean.setIwsKyknmkj(keiyakusyaBean.getKykNmKj());
        wsDwGetHozenKykSntkHijynSysnOutputBean.setIwsKykseiymdstr(dateToStr(keiyakusyaBean.getKykseiYmd()));
        wsDwGetHozenKykSntkHijynSysnOutputBean.setIwsKyksei(keiyakusyaBean.getKyksei().getValue());
        wsDwGetHozenKykSntkHijynSysnOutputBean.setIwsHhknnmkn(hihokensyaBean.getHhknNmKn());
        wsDwGetHozenKykSntkHijynSysnOutputBean.setIwsHhknseiymdstr(dateToStr(hihokensyaBean.getHhknseiYmd()));
        wsDwGetHozenKykSntkHijynSysnOutputBean.setIwsSbuktnin(String.valueOf(keiyakuUketorininBean.getSbuktnin()));
        wsDwGetHozenKykSntkHijynSysnOutputBean.setIwsUktmidasikbn1(keiyakuUketorininBean.getUktsyuKbn1().getValue());
        wsDwGetHozenKykSntkHijynSysnOutputBean.setIwsUktkbn1str(keiyakuUketorininBean.getGkdtKoktuutiUktKbn1().getValue());
        wsDwGetHozenKykSntkHijynSysnOutputBean.setIwsUktsimei1(keiyakuUketorininBean.getUktNm1());
        wsDwGetHozenKykSntkHijynSysnOutputBean.setIwsUktmidasikbn2(keiyakuUketorininBean.getUktsyuKbn2().getValue());
        wsDwGetHozenKykSntkHijynSysnOutputBean.setIwsUktkbn2str(keiyakuUketorininBean.getGkdtKoktuutiUktKbn2().getValue());
        wsDwGetHozenKykSntkHijynSysnOutputBean.setIwsUktsimei2(keiyakuUketorininBean.getUktNm2());
        wsDwGetHozenKykSntkHijynSysnOutputBean.setIwsUktmidasikbn3(keiyakuUketorininBean.getUktsyuKbn3().getValue());
        wsDwGetHozenKykSntkHijynSysnOutputBean.setIwsUktkbn3str(keiyakuUketorininBean.getGkdtKoktuutiUktKbn3().getValue());
        wsDwGetHozenKykSntkHijynSysnOutputBean.setIwsUktsimei3(keiyakuUketorininBean.getUktNm3());
        wsDwGetHozenKykSntkHijynSysnOutputBean.setIwsUktmidasikbn4(keiyakuUketorininBean.getUktsyuKbn4().getValue());
        wsDwGetHozenKykSntkHijynSysnOutputBean.setIwsUktkbn4str(keiyakuUketorininBean.getGkdtKoktuutiUktKbn4().getValue());
        wsDwGetHozenKykSntkHijynSysnOutputBean.setIwsUktsimei4(keiyakuUketorininBean.getUktNm4());
        wsDwGetHozenKykSntkHijynSysnOutputBean.setIwsUktmidasikbn5(keiyakuUketorininBean.getUktsyuKbn5().getValue());
        wsDwGetHozenKykSntkHijynSysnOutputBean.setIwsUktkbn5str(keiyakuUketorininBean.getGkdtKoktuutiUktKbn5().getValue());
        wsDwGetHozenKykSntkHijynSysnOutputBean.setIwsUktsimei5(keiyakuUketorininBean.getUktNm5());
        wsDwGetHozenKykSntkHijynSysnOutputBean.setIwsUktmidasikbn6(keiyakuUketorininBean.getUktsyuKbn6().getValue());
        wsDwGetHozenKykSntkHijynSysnOutputBean.setIwsUktkbn6str(keiyakuUketorininBean.getGkdtKoktuutiUktKbn6().getValue());
        wsDwGetHozenKykSntkHijynSysnOutputBean.setIwsUktsimei6(keiyakuUketorininBean.getUktNm6());
        wsDwGetHozenKykSntkHijynSysnOutputBean.setIwsUktmidasikbn7(keiyakuUketorininBean.getUktsyuKbn7().getValue());
        wsDwGetHozenKykSntkHijynSysnOutputBean.setIwsUktkbn7str(keiyakuUketorininBean.getGkdtKoktuutiUktKbn7().getValue());
        wsDwGetHozenKykSntkHijynSysnOutputBean.setIwsUktsimei7(keiyakuUketorininBean.getUktNm7());
        wsDwGetHozenKykSntkHijynSysnOutputBean.setIwsUktmidasikbn8(keiyakuUketorininBean.getUktsyuKbn8().getValue());
        wsDwGetHozenKykSntkHijynSysnOutputBean.setIwsUktkbn8str(keiyakuUketorininBean.getGkdtKoktuutiUktKbn8().getValue());
        wsDwGetHozenKykSntkHijynSysnOutputBean.setIwsUktsimei8(keiyakuUketorininBean.getUktNm8());
        wsDwGetHozenKykSntkHijynSysnOutputBean.setIwsUktmidasikbn9(keiyakuUketorininBean.getUktsyuKbn9().getValue());
        wsDwGetHozenKykSntkHijynSysnOutputBean.setIwsUktkbn9str(keiyakuUketorininBean.getGkdtKoktuutiUktKbn9().getValue());
        wsDwGetHozenKykSntkHijynSysnOutputBean.setIwsUktsimei9(keiyakuUketorininBean.getUktNm9());
        wsDwGetHozenKykSntkHijynSysnOutputBean.setIwsUktmidasikbn10(keiyakuUketorininBean.getUktsyuKbn10().getValue());
        wsDwGetHozenKykSntkHijynSysnOutputBean.setIwsUktkbn10str(keiyakuUketorininBean.getGkdtKoktuutiUktKbn10().getValue());
        wsDwGetHozenKykSntkHijynSysnOutputBean.setIwsUktsimei10(keiyakuUketorininBean.getUktNm10());
        wsDwGetHozenKykSntkHijynSysnOutputBean.setIwsTrkkzknmkn1(trkKazokuBean.getTrkkzknmKn1());
        wsDwGetHozenKykSntkHijynSysnOutputBean.setIwsTrkkzknmkn2(trkKazokuBean.getTrkkzknmKn2());
        wsDwGetHozenKykSntkHijynSysnOutputBean.setIwsTutakinumukbn(gamenSeigyoBean.getTutakinUmukbn().getValue());
        wsDwGetHozenKykSntkHijynSysnOutputBean.setIwsKaiyakuhrsuiiumukbn(gamenSeigyoBean.getKaiyakuHrsuiiUmuKbn().getValue());
        wsDwGetHozenKykSntkHijynSysnOutputBean.setIwsHknkknkaisiymd1str(dateToStr(hokenKikanBean.getHknkknkaisiymd1()));
        wsDwGetHozenKykSntkHijynSysnOutputBean.setIwsHknkknmanryouymd1str(dateToStr(hokenKikanBean.getHknkknmanryouymd1()));
        wsDwGetHozenKykSntkHijynSysnOutputBean.setIwsHknkkn1(String.valueOf(hokenKikanBean.getDai1hknkkn()));
        wsDwGetHozenKykSntkHijynSysnOutputBean.setIwsHknkknkaisiymd2str(dateToStr(hokenKikanBean.getHknkknkaisiymd2()));
        wsDwGetHozenKykSntkHijynSysnOutputBean.setIwsSbhsyumukbn(hosyouBean.getSbHsyUmuKbn().getValue());
        wsDwGetHozenKykSntkHijynSysnOutputBean.setIwsKghsyumukbn(hosyouBean.getKgHsyUmukbn().getValue());
        wsDwGetHozenKykSntkHijynSysnOutputBean.setIwsIryhsyumukbn(hosyouBean.getIryHsyUmukbn().getValue());
        wsDwGetHozenKykSntkHijynSysnOutputBean.setIwsRougohsyumukbn(hosyouBean.getRougoHsyUmukbn().getValue());
        wsDwGetHozenKykSntkHijynSysnOutputBean.setIwsKykdrtkhkumu(tokuyakuBean.getKykdrTkykhukaumu().getValue());
        wsDwGetHozenKykSntkHijynSysnOutputBean.setIwsStdrsktkyhkumu(tokuyakuBean.getStdrskTkyhkumu().getValue());
        wsDwGetHozenKykSntkHijynSysnOutputBean.setIwsJyudkaigomehrtkhkumu(tokuyakuBean.getJyudKaigoMeharaiTkhukaumu().getValue());
        wsDwGetHozenKykSntkHijynSysnOutputBean.setIwsYennykntkhkumu(tokuyakuBean.getYenNyknThkumu().getValue());
        wsDwGetHozenKykSntkHijynSysnOutputBean.setIwsKjsmsaihakkoukahikbn(syoriKahiBean.getKjsmSaihakkouKahiKbn().getValue());
        wsDwGetHozenKykSntkHijynSysnOutputBean.setIwsKykmeigihnkkahikbn(syoriKahiBean.getKykMeigihnkKahiKbn().getValue());
        wsDwGetHozenKykSntkHijynSysnOutputBean.setIwsSyoukensaihkkahikbn(syoriKahiBean.getSyoukenSaihkKahiKbn().getValue());
        wsDwGetHozenKykSntkHijynSysnOutputBean.setIwsStdrsktkytthkkahikbn(syoriKahiBean.getStdrskTkyTthkKahiKbn().getValue());
        wsDwGetHozenKykSntkHijynSysnOutputBean.setIwsTargettkhkkahikbn(syoriKahiBean.getTargetTkhkKahiKbn().getValue());
        wsDwGetHozenKykSntkHijynSysnOutputBean.setIwsKykniyusyoukaikahikbn(syoriKahiBean.getKykNiyuSyoukaiKahiKbn().getValue());
        wsDwGetHozenKykSntkHijynSysnOutputBean.setIwsTumitatekinitenkahikbn(syoriKahiBean.getTumitatekinItenKahiKbn().getValue());
        wsDwGetHozenKykSntkHijynSysnOutputBean.setIwsDskaiyakukahikbn(syoriKahiBean.getDsKaiyakuKahiKbn().getValue());
        wsDwGetHozenKykSntkHijynSysnOutputBean.setIwsAdrhenkoukahikbn(syoriKahiBean.getAdrHenkouKahiKbn().getValue());
        wsDwGetHozenKykSntkHijynSysnOutputBean.setIwsPhrkhouhenkoukahikbn(syoriKahiBean.getPhrkhouHenkouKahiKbn().getValue());
        wsDwGetHozenKykSntkHijynSysnOutputBean.setIwsHrkkaisuu(hrkKaisuu);
        wsDwGetHozenKykSntkHijynSysnOutputBean.setIwsHrkkeiro(kykKihon.getHrkkeiro().getContent());
        wsDwGetHozenKykSntkHijynSysnOutputBean.setIwsHrkkkn(String.valueOf(kykSyouhn.getHrkkkn()));
        wsDwGetHozenKykSntkHijynSysnOutputBean.setIwsYoteiriritu(BizUtil.num(String.valueOf(yoteiriritu),
            BizUtil.ZERO_FILL_LAST_ONLY, 3, BizUtil.ZERO_FILL, 2));
        wsDwGetHozenKykSntkHijynSysnOutputBean.setIwsZennouumu(zennouUmu.getValue());
        wsDwGetHozenKykSntkHijynSysnOutputBean.setIwsHokenryou(currencyToStr(kykSyouhn.getHokenryou()));
        wsDwGetHozenKykSntkHijynSysnOutputBean.setIwsKihonhokenkngk(currencyToStr(kykSyouhn.getKihons()));
        wsDwGetHozenKykSntkHijynSysnOutputBean.setIwsKykznnp(currencyToStr(kykznnP));
        wsDwGetHozenKykSntkHijynSysnOutputBean.setIwsKykznnprsytuukasyu(kykznnprsyTuukasyu);
        wsDwGetHozenKykSntkHijynSysnOutputBean.setIwsKykznnyenhrkgk(currencyToStr(kykznnyenhrkGk));
        wsDwGetHozenKykSntkHijynSysnOutputBean.setIwsYenhrkgkhyoujikahi(yenhrkgkHyoujikahi.getValue());
        wsDwGetHozenKykSntkHijynSysnOutputBean.setIwsYenkansanhokenryou(currencyToStr(yenkansanHokenryou));
        wsDwGetHozenKykSntkHijynSysnOutputBean.setIwsJkirsymd(dateToStr(jkirsYmd));
        wsDwGetHozenKykSntkHijynSysnOutputBean.setIwsYenknsnkijyunymd(dateToStr(yenknsnkijyunYmd));
        wsDwGetHozenKykSntkHijynSysnOutputBean.setIwsHokenryoukktikwsrate(numberToStr(hokenryoukktiKwsrate));
        wsDwGetHozenKykSntkHijynSysnOutputBean.setIwsKwsratekijyunymdsakusei(dateToStr(kawaseRateKjYmdSakusei));
        wsDwGetHozenKykSntkHijynSysnOutputBean.setIwsSksikijyunymdkawaserate(numberToStr(kawaseRateSakusei));
        wsDwGetHozenKykSntkHijynSysnOutputBean.setIwsSibohknkngkyen(currencyToStr(sbhknkngkYen));
        wsDwGetHozenKykSntkHijynSysnOutputBean.setIwsSibohknkngkgaika(currencyToStr(sbhknkngkGaika));
        wsDwGetHozenKykSntkHijynSysnOutputBean.setIwsKaiyakujshrgkyen(currencyToStr(kaiyakujShrgkYen));
        wsDwGetHozenKykSntkHijynSysnOutputBean.setIwsKaiyakujshrgkgaika(currencyToStr(kaiyakujShrgkGaika));
        wsDwGetHozenKykSntkHijynSysnOutputBean.setIwsKaiyakuhryen(currencyToStr(kaiyakuhrYen));
        wsDwGetHozenKykSntkHijynSysnOutputBean.setIwsKaiyakuhrgaika(currencyToStr(kaiyakuhrGaika));
        wsDwGetHozenKykSntkHijynSysnOutputBean.setIwsZennouzndkyen(currencyToStr(zennouzndkYen));
        wsDwGetHozenKykSntkHijynSysnOutputBean.setIwsZennouzndkgaika(currencyToStr(zennouzndkGaika));
        wsDwGetHozenKykSntkHijynSysnOutputBean.setIwsSonotasiharaikingakuyen(currencyToStr(sonotaShrkngkYen));
        wsDwGetHozenKykSntkHijynSysnOutputBean.setIwsSonotasiharaikingakugk(currencyToStr(sonotaShrkngkGaika));
        wsDwGetHozenKykSntkHijynSysnOutputBean.setIwsKihrkmpstgkyen(currencyToStr(kihrkmpstgkYen));
        wsDwGetHozenKykSntkHijynSysnOutputBean.setIwsKihrkmpstgkgaika(currencyToStr(kihrkmpstgkGaika));
        wsDwGetHozenKykSntkHijynSysnOutputBean.setIwsRsytuukasyu(nyknJissekiRireki.getRstuukasyu().getValue());
        wsDwGetHozenKykSntkHijynSysnOutputBean.setIwsKngkksnkekkakbn(kngkksnKekkakbn.getValue());
        wsDwGetHozenKykSntkHijynSysnOutputBean.setIwsRskngkksnkekkakbn(rskngkksnkekkaKbn.getValue());
        wsDwGetHozenKykSntkHijynSysnOutputBean.setIwsHrkpgkeiksnkhkbn(hrkmPGkGkKeisanKahiKbn.getValue());
        wsDwGetHozenKykSntkHijynSysnOutputBean.setIwsYakkanbunsyono(keiyakuKihonBean.getYakkanBunsyoNo());


        return wsDwGetHozenKykSntkHijynSysnOutputBean;
    }

    private String dateToStr(BizDate pDate) {

        if (pDate == null) {

            return null;
        }

        return pDate.toString();

    }

    private String dateToStr(BizDateYM pDateYM) {

        if (pDateYM == null) {

            return null;
        }

        return pDateYM.toString();

    }

    private String currencyToStr(BizCurrency pCurrency) {

        if (pCurrency == null) {

            return null;
        }

        return pCurrency.toAdsoluteString();

    }

    private String numberToStr(BizNumber pNumber) {

        if (pNumber == null) {

            return null;

        }

        return pNumber.toString();

    }
}
