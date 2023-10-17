package yuyu.app.dsweb.dwhozeninfo.dwgethozenkiykgikhijynnnkn;

import java.lang.reflect.InvocationTargetException;
import java.math.RoundingMode;
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
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.number.currencytype.CurrencyType;
import jp.co.slcs.swak.util.message.MessageUtil;
import net.arnx.jsonic.JSON;

import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.GetKawaseRate;
import yuyu.common.biz.bzcommon.GetYoteiriritu;
import yuyu.common.biz.bzcommon.GetYoteirirituBean;
import yuyu.common.biz.bzcommon.HenkanTuuka;
import yuyu.common.biz.bzcommon.KeisanAzukariGanrikin;
import yuyu.common.biz.bzcommon.KeisanGaikakanzan;
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
import yuyu.common.hozen.khcommon.KeisanCommonKaiyaku;
import yuyu.common.hozen.khcommon.KeisanCommonKaiyakuOutBean;
import yuyu.common.hozen.khcommon.KeisanHrrtksnHrkPGkgk;
import yuyu.common.hozen.khcommon.KeisanIkkatuNyuukinGkBean;
import yuyu.common.hozen.khcommon.KeisanIkkatuNyuukinGkSyouhnBean;
import yuyu.common.hozen.khcommon.KeisanKaiyakuBean;
import yuyu.common.hozen.khcommon.KeisanTukiIkkatuNyuukinGk;
import yuyu.common.hozen.khcommon.KeisanVHeijyun;
import yuyu.common.hozen.khcommon.KeisanVHeijyunBean;
import yuyu.common.siharai.sicommon.CalcHkShrKngk;
import yuyu.common.sinkeiyaku.skcommon.EditNenkinKoumokuUtil;
import yuyu.def.MessageId;
import yuyu.def.biz.bean.param.WsBzWebserviceReqParamBean;
import yuyu.def.biz.bean.param.WsBzWebserviceResParamBean;
import yuyu.def.classification.C_AccessLogSyubetuKbn;
import yuyu.def.classification.C_DsSyouhnbunruiKbn;
import yuyu.def.classification.C_EigyoubiHoseiKbn;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_HasuusyoriKbn;
import yuyu.def.classification.C_HokenkinsyuruiKbn;
import yuyu.def.classification.C_KahiKbn;
import yuyu.def.classification.C_KawaserateSyuruiKbn;
import yuyu.def.classification.C_KawasetekiyoKbn;
import yuyu.def.classification.C_KawasetsryKbn;
import yuyu.def.classification.C_KhSisanSyuruiKbn;
import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_Nenkinsyu;
import yuyu.def.classification.C_Nykkeiro;
import yuyu.def.classification.C_NyknaiyouKbn;
import yuyu.def.classification.C_SiinKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_TkiktbrisyuruiKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.IT_AnsyuKihon;
import yuyu.def.db.entity.IT_HokenryouTmttkn;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSonotaTkyk;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.db.entity.IT_NyknJissekiRireki;
import yuyu.def.db.entity.IT_Zennou;
import yuyu.def.dsweb.bean.webservice.WsDwGetHozenKiykGikHijynNnknInputBean;
import yuyu.def.dsweb.bean.webservice.WsDwGetHozenKiykGikHijynNnknOutputBean;
import yuyu.def.hozen.manager.HozenDomManager;

import com.google.common.collect.Lists;

/**
 * 保全契約詳細取得（外貨建平準払年金）サービスの実装クラスです。<br />
 *
 */
public class DwGetHozenKiykGikHijynNnknImpl implements DwGetHozenKiykGikHijynNnkn {

    public static final int MAX_INT_VALUE_TMTTKNTAISYOUYM = 219912;

    @Inject
    private static Logger logger;

    @Inject
    private HozenDomManager hozenDomManager;

    @Override
    public WsBzWebserviceResParamBean execPostForm(MultivaluedMap<String, String> pMap) {

        logger.info(MessageUtil.getMessage(MessageId.IBF0016, MessageUtil.getMessage(MessageId.INW1025)));

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean;

        try {

            wsBzWebserviceResParamBean = getHozenKiykGikHijynNnknMain(pMap);

        } catch (Exception throwable) {

            DsDB2Util dsDB2Util = SWAKInjector.getInstance(DsDB2Util.class);

            DsDB2Util.E_Result result = dsDB2Util.exec(throwable);

            String dsmsgcd = "";

            if (DsDB2Util.E_Result.DEADLOCK.compareTo(result) == 0) {

                dsmsgcd = DwMessageCodeConstants.IWSDSMSGCD_017217;

            }
            else if (DsDB2Util.E_Result.QUERY_TIMEOUT.compareTo(result) == 0) {

                dsmsgcd = DwMessageCodeConstants.IWSDSMSGCD_017216;

            }
            else if (DsDB2Util.E_Result.OTHER.compareTo(result) == 0) {

                throw throwable;

            }

            WsDwGetHozenKiykGikHijynNnknOutputBean getHzKykGikHijynNnknOutputBean =
                SWAKInjector.getInstance(WsDwGetHozenKiykGikHijynNnknOutputBean.class);

            wsBzWebserviceResParamBean = SWAKInjector.getInstance(WsBzWebserviceResParamBean.class);

            getHzKykGikHijynNnknOutputBean.setIwsDsmsgcd(dsmsgcd);

            wsBzWebserviceResParamBean.setGyoumuData(JSON.encode(getHzKykGikHijynNnknOutputBean));

        } finally {

            logger.info(MessageUtil.getMessage(MessageId.IBF0017, MessageUtil.getMessage(MessageId.INW1025)));

        }

        return wsBzWebserviceResParamBean;
    }

    @Transactional
    WsBzWebserviceResParamBean getHozenKiykGikHijynNnknMain(MultivaluedMap<String, String> pMap) {

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

        WsDwGetHozenKiykGikHijynNnknInputBean getHzKykGikHijynNnknInputBean =
            JSON.decode(gyoumuData, WsDwGetHozenKiykGikHijynNnknInputBean.class);

        WebServiceAccesslogOutput webServiceAccesslogOutput =
            SWAKInjector.getInstance(WebServiceAccesslogOutput.class);

        webServiceAccesslogOutput.exec(
            C_AccessLogSyubetuKbn.ACTION_BEGIN,
            wsBzWebserviceReqParamBean,
            getHzKykGikHijynNnknInputBean
            );

        WsDwGetHozenKiykGikHijynNnknOutputBean getHzKykGikHijynNnknOutputBean =
            SWAKInjector.getInstance(WsDwGetHozenKiykGikHijynNnknOutputBean.class);

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean =
            SWAKInjector.getInstance(WsBzWebserviceResParamBean.class);

        boolean chkRet = getHzKykGikHijynNnknInputBean.chkInput();

        if (!chkRet) {

            getHzKykGikHijynNnknOutputBean.setIwsDsmsgcd(DwMessageCodeConstants.IWSDSMSGCD_017100);

            wsBzWebserviceResParamBean.setGyoumuData(JSON.encode(getHzKykGikHijynNnknOutputBean));

            return wsBzWebserviceResParamBean;

        }

        Validator validator = SWAKInjector.getInstance(Validator.class);

        Set<ConstraintViolation<WsDwGetHozenKiykGikHijynNnknInputBean>> chkKekkaSet =
            validator.validate(getHzKykGikHijynNnknInputBean);

        if (chkKekkaSet.size() > 0) {

            getHzKykGikHijynNnknOutputBean.setIwsDsmsgcd(DwMessageCodeConstants.IWSDSMSGCD_017100);

            wsBzWebserviceResParamBean.setGyoumuData(JSON.encode(getHzKykGikHijynNnknOutputBean));

            return wsBzWebserviceResParamBean;

        }

        getHzKykGikHijynNnknOutputBean = getHozenKiykGikHijynNnkn(getHzKykGikHijynNnknInputBean.getIwsSyono());

        wsBzWebserviceResParamBean.setGyoumuData(JSON.encode(getHzKykGikHijynNnknOutputBean));

        return wsBzWebserviceResParamBean;

    }

    private WsDwGetHozenKiykGikHijynNnknOutputBean getHozenKiykGikHijynNnkn(String pSyono) {

        WsDwGetHozenKiykGikHijynNnknOutputBean getHzKykGikHijynNnknOutputBean =
            SWAKInjector.getInstance(WsDwGetHozenKiykGikHijynNnknOutputBean.class);

        DsGetKeiyakuCommon dsGetKeiyakuCommon = SWAKInjector.getInstance(DsGetKeiyakuCommon.class);

        KeiyakuKihonBean keiyakuKihonBean = dsGetKeiyakuCommon.getKykKihon(pSyono);

        if (C_ErrorKbn.ERROR.eq(keiyakuKihonBean.getErrorKbn())) {

            getHzKykGikHijynNnknOutputBean.setIwsDsmsgcd(DwMessageCodeConstants.IWSDSMSGCD_017201);

            return getHzKykGikHijynNnknOutputBean;

        }

        KeiyakusyaBean keiyakusyaBean = dsGetKeiyakuCommon.getKykSya(pSyono);

        if (C_ErrorKbn.ERROR.eq(keiyakusyaBean.getErrorKbn())) {

            getHzKykGikHijynNnknOutputBean.setIwsDsmsgcd(DwMessageCodeConstants.IWSDSMSGCD_017202);

            return getHzKykGikHijynNnknOutputBean;

        }

        HihokensyaBean hihokensyaBean = dsGetKeiyakuCommon.getHhknSya(pSyono);

        if (C_ErrorKbn.ERROR.eq(hihokensyaBean.getErrorKbn())) {

            getHzKykGikHijynNnknOutputBean.setIwsDsmsgcd(DwMessageCodeConstants.IWSDSMSGCD_017203);

            return getHzKykGikHijynNnknOutputBean;

        }

        KeiyakuUketorininBean keiyakuUketorininBean = dsGetKeiyakuCommon.getKykUkt(pSyono);

        if (C_ErrorKbn.ERROR.eq(keiyakuUketorininBean.getErrorKbn())) {

            getHzKykGikHijynNnknOutputBean.setIwsDsmsgcd(DwMessageCodeConstants.IWSDSMSGCD_017204);

            return getHzKykGikHijynNnknOutputBean;

        }

        TrkKazokuBean trkKazokuBean = dsGetKeiyakuCommon.getTrkKazoku(pSyono);

        DsSyouhinBean dsSyouhinBean = SWAKInjector.getInstance(DsSyouhinBean.class);

        dsSyouhinBean.setSyoNo(pSyono);
        dsSyouhinBean.setDsSyouhnbunruiKbn(C_DsSyouhnbunruiKbn.GKDTHIJYNBRNK);

        DsGetSeigyo dsGetSeigyo = SWAKInjector.getInstance(DsGetSeigyo.class);

        GamenSeigyoBean gamenSeigyoBean = dsGetSeigyo.getGamenSeigyo(dsSyouhinBean);

        if (C_ErrorKbn.ERROR.eq(gamenSeigyoBean.getErrorKbn())) {

            getHzKykGikHijynNnknOutputBean.setIwsDsmsgcd(DwMessageCodeConstants.IWSDSMSGCD_017205);

            return getHzKykGikHijynNnknOutputBean;

        }

        HosyouBean hosyouBean = dsGetSeigyo.getHosyou(dsSyouhinBean);

        if (C_ErrorKbn.ERROR.eq(hosyouBean.getErrorKbn())) {

            getHzKykGikHijynNnknOutputBean.setIwsDsmsgcd(DwMessageCodeConstants.IWSDSMSGCD_017206);

            return getHzKykGikHijynNnknOutputBean;

        }

        TokuyakuBean tokuyakuBean = dsGetSeigyo.getTokuyaku(dsSyouhinBean);

        if (C_ErrorKbn.ERROR.eq(tokuyakuBean.getErrorKbn())) {

            getHzKykGikHijynNnknOutputBean.setIwsDsmsgcd(DwMessageCodeConstants.IWSDSMSGCD_017207);

            return getHzKykGikHijynNnknOutputBean;

        }

        SyoriKahiBean syoriKahiBean = dsGetSeigyo.getSyoriKahi(dsSyouhinBean);

        if (C_ErrorKbn.ERROR.eq(syoriKahiBean.getErrorKbn())) {

            getHzKykGikHijynNnknOutputBean.setIwsDsmsgcd(DwMessageCodeConstants.IWSDSMSGCD_017208);

            return getHzKykGikHijynNnknOutputBean;

        }

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(pSyono);

        if (kykKihon == null) {

            getHzKykGikHijynNnknOutputBean.setIwsDsmsgcd(DwMessageCodeConstants.IWSDSMSGCD_017209);

            return getHzKykGikHijynNnknOutputBean;

        }

        List<IT_KykSyouhn> kykSyouhnList = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        if (kykSyouhnList == null || kykSyouhnList.size() == 0) {

            getHzKykGikHijynNnknOutputBean.setIwsDsmsgcd(DwMessageCodeConstants.IWSDSMSGCD_017210);

            return getHzKykGikHijynNnknOutputBean;

        }

        IT_KykSyouhn kykSyouhn = kykSyouhnList.get(0);

        BM_SyouhnZokusei syouhnZokusei = kykSyouhn.getSyouhnZokusei();

        if (syouhnZokusei == null) {

            getHzKykGikHijynNnknOutputBean.setIwsDsmsgcd(DwMessageCodeConstants.IWSDSMSGCD_017211);

            return getHzKykGikHijynNnknOutputBean;

        }

        List<IT_NyknJissekiRireki> nyknJissekiRirekiList = kykKihon.getNyknJissekiRirekisByNykkeiro(C_Nykkeiro.SKEI);

        if (nyknJissekiRirekiList == null || nyknJissekiRirekiList.size() == 0) {

            getHzKykGikHijynNnknOutputBean.setIwsDsmsgcd(DwMessageCodeConstants.IWSDSMSGCD_017212);

            return getHzKykGikHijynNnknOutputBean;

        }

        IT_NyknJissekiRireki nyknJissekiRireki = nyknJissekiRirekiList.get(0);

        IT_KykSonotaTkyk kykSonotaTkyk = null;

        try {

            kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        } catch (EntityNotFoundException entityNotFoundException) {
        }

        if (kykSonotaTkyk == null) {

            getHzKykGikHijynNnknOutputBean.setIwsDsmsgcd(DwMessageCodeConstants.IWSDSMSGCD_017213);

            return getHzKykGikHijynNnknOutputBean;

        }

        IT_AnsyuKihon ansyuKihon = hozenDomManager.getAnsyuKihon(pSyono);

        if (ansyuKihon == null) {

            getHzKykGikHijynNnknOutputBean.setIwsDsmsgcd(DwMessageCodeConstants.IWSDSMSGCD_017214);

            return getHzKykGikHijynNnknOutputBean;

        }

        List<IT_Zennou> zennouList = ansyuKihon.getZennous();

        C_UmuKbn zennouUmu = null;

        IT_Zennou zennou = null;

        if (zennouList != null && zennouList.size() != 0 && C_Kykjyoutai.ZENNOU.eq(kykSyouhn.getKykjyoutai())) {

            zennouUmu = C_UmuKbn.ARI;

            zennou = zennouList.get(0);

        }
        else {

            zennouUmu = C_UmuKbn.NONE;
        }

        String hrkkaisuu = "";

        if (C_TkiktbrisyuruiKbn.TEIKI_6MONTHS.eq(kykKihon.getTikiktbrisyuruikbn()) ||
            C_TkiktbrisyuruiKbn.TEIKI_12MONTHS.eq(kykKihon.getTikiktbrisyuruikbn())) {


            if (C_Kykjyoutai.ZENNOU.eq(kykSyouhn.getKykjyoutai())) {

                hrkkaisuu = kykKihon.getHrkkaisuu().getContent() +
                    "（全期前納・" + kykKihon.getTikiktbrisyuruikbn().getContent() + "）";

            }
            else {

                hrkkaisuu = kykKihon.getHrkkaisuu().getContent() +
                    "（" + kykKihon.getTikiktbrisyuruikbn().getContent() + "）";

            }
        }
        else {

            hrkkaisuu = kykKihon.getHrkkaisuu().getContent();

        }

        int nenkinstartnen = 0;

        SetNenrei setNenrei = SWAKInjector.getInstance(SetNenrei.class);

        nenkinstartnen = setNenrei.exec(
            kykSyouhn.getHknkknmanryouymd(),
            hihokensyaBean.getHhknseiYmd()
            );


        EditNenkinKoumokuUtil editNenkinKoumokuUtil = SWAKInjector.getInstance(EditNenkinKoumokuUtil.class);

        C_ErrorKbn editNenkinSueokikikanErrorKbn = editNenkinKoumokuUtil.editNenkinSueokikikan(
            kykSyouhn.getHknkkn(),
            kykSyouhn.getHknkknsmnkbn(),
            kykSyouhn.getHrkkkn(),
            kykSyouhn.getHrkkknsmnkbn(),
            kykSyouhn.getHhknnen()
            );

        Integer sueokikikan = 0;

        if (C_ErrorKbn.OK.eq(editNenkinSueokikikanErrorKbn)) {

            sueokikikan = editNenkinKoumokuUtil.getNenkinSueokikikan();

        }

        String nnenkinSyu = "";

        if (C_Nenkinsyu.KAKUTEINENKIN.eq(kykSyouhn.getNksyukbn())) {

            nnenkinSyu = kykSyouhn.getNenkinkkn() + "年" + kykSyouhn.getNksyukbn().getContent() + "（定額年金型）";

        }

        else if (C_Nenkinsyu.SGKHSYSYSNNENKIN.eq(kykSyouhn.getNksyukbn())) {

            nnenkinSyu = kykSyouhn.getNksyukbn().getContent();

        }

        else if (C_Nenkinsyu.KAKUTEIDAI1NENKINBAIGK.eq(kykSyouhn.getNksyukbn())) {

            nnenkinSyu = "5年" + kykSyouhn.getNksyukbn().getContent();

        }

        int jyuutoutukisuu = 0;

        if (C_TkiktbrisyuruiKbn.NONE.eq(kykKihon.getTikiktbrisyuruikbn())) {

            jyuutoutukisuu = 1;

        }
        if (C_TkiktbrisyuruiKbn.TEIKI_6MONTHS.eq(kykKihon.getTikiktbrisyuruikbn())) {

            jyuutoutukisuu = 6;

        }
        if (C_TkiktbrisyuruiKbn.TEIKI_12MONTHS.eq(kykKihon.getTikiktbrisyuruikbn())) {

            jyuutoutukisuu = 12;

        }

        List<KeisanIkkatuNyuukinGkSyouhnBean> keisanIkkatuNyuukinGkSyouhnBeanList = Lists.newArrayList();
        KeisanIkkatuNyuukinGkSyouhnBean KeisanIkkatuNyuukinGkSyouhnBean = SWAKInjector.getInstance(KeisanIkkatuNyuukinGkSyouhnBean.class);

        KeisanIkkatuNyuukinGkSyouhnBean.setSyouhnCd(kykSyouhn.getSyouhncd());
        KeisanIkkatuNyuukinGkSyouhnBean.setSyouhnsdNo(kykSyouhn.getSyouhnsdno());
        KeisanIkkatuNyuukinGkSyouhnBean.setRyouritusdNo(kykSyouhn.getRyouritusdno());
        KeisanIkkatuNyuukinGkSyouhnBean.setYoteiRiritu(BizNumber.valueOf(0));
        KeisanIkkatuNyuukinGkSyouhnBean.setHokenryou(kykSyouhn.getHokenryou());

        keisanIkkatuNyuukinGkSyouhnBeanList.add(KeisanIkkatuNyuukinGkSyouhnBean);

        KeisanIkkatuNyuukinGkBean keisanIkkatuNyuukinGkBean = SWAKInjector.getInstance(KeisanIkkatuNyuukinGkBean.class);

        keisanIkkatuNyuukinGkBean.setKeisanIkkatuNyuukinGkSyouhnBeanLst(keisanIkkatuNyuukinGkSyouhnBeanList);
        keisanIkkatuNyuukinGkBean.setJyuutoutuKisuu(jyuutoutukisuu);
        keisanIkkatuNyuukinGkBean.setTkiktbrisyuruiKbn(kykKihon.getTikiktbrisyuruikbn());
        keisanIkkatuNyuukinGkBean.setRstuukasyu(nyknJissekiRireki.getRstuukasyu());
        keisanIkkatuNyuukinGkBean.setNyknaiyouKbn(C_NyknaiyouKbn.BLNK);
        keisanIkkatuNyuukinGkBean.setNykkeiro(C_Nykkeiro.BLNK);
        keisanIkkatuNyuukinGkBean.setSyokaiprsYmd(null);
        keisanIkkatuNyuukinGkBean.setJyutoustartYm(null);

        KeisanTukiIkkatuNyuukinGk keisanTukiIkkatuNyuukinGk = SWAKInjector.getInstance(KeisanTukiIkkatuNyuukinGk.class);

        C_ErrorKbn keisanIkkatuNyuukinGkErrorKbn  =  keisanTukiIkkatuNyuukinGk.exec(keisanIkkatuNyuukinGkBean, false);

        BizCurrency rsgakuyentikiktbri = null;

        if (C_ErrorKbn.OK.eq(keisanIkkatuNyuukinGkErrorKbn)) {

            rsgakuyentikiktbri = keisanTukiIkkatuNyuukinGk.getIktnyknkgk();

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

        C_ErrorKbn getNyknKawaseRateErrorKbn = getKawaseRate.exec(
            sysDate,
            C_KawaserateSyuruiKbn.KOUJIKAWASERATE,
            kykSyouhn.getKyktuukasyu(),
            C_Tuukasyu.JPY,
            C_KawasetekiyoKbn.TTM,
            C_KawasetsryKbn.NYUKINRATE,
            C_EigyoubiHoseiKbn.BLNK,
            C_YouhiKbn.YOU);

        BizNumber nyknKawaseRate = BizNumber.ZERO;

        if (C_ErrorKbn.OK.eq(getNyknKawaseRateErrorKbn)) {

            nyknKawaseRate = getKawaseRate.getKawaserate();

        }



        GetYoteirirituBean getYoteirirituBean = SWAKInjector.getInstance(GetYoteirirituBean.class);

        getYoteirirituBean.setSyouhncd(kykSyouhn.getSyouhncd());
        getYoteirirituBean.setKijyunymd(sysDate);
        getYoteirirituBean.setSknnkaisiymd(kykSyouhn.getSknnkaisiymd());
        getYoteirirituBean.setKykymd(kykSyouhn.getKykymd());
        getYoteirirituBean.setHknkkn(kykSyouhn.getHknkkn());
        getYoteirirituBean.setHknkknsmnkbn(kykSyouhn.getHknkknsmnkbn());
        getYoteirirituBean.setHhknnen(kykSyouhn.getHhknnen());
        getYoteirirituBean.setSitihsyuriritu(syouhnZokusei.getYoteirirituminhosyouritu());

        BizNumber yoteiriritu = BizNumber.ZERO;

        GetYoteiriritu getYoteiriritu = SWAKInjector.getInstance(GetYoteiriritu.class);

        C_ErrorKbn getYoteirirituErrorKbn = getYoteiriritu.exec(getYoteirirituBean);

        if (C_ErrorKbn.OK.eq(getYoteirirituErrorKbn)) {

            yoteiriritu = getYoteiriritu.getYoteiriritu().multiply(100);

        }

        CalcHkShrKngk calcHkShrKngk = SWAKInjector.getInstance(CalcHkShrKngk.class);

        C_ErrorKbn calcHkShrKngkErrorKbn = calcHkShrKngk.execByKeisanWExt(
            pSyono,
            sysDate,
            C_SiinKbn.SP,
            C_HokenkinsyuruiKbn.SBHOKENKIN,
            kykKihon.getSdpdkbn(),
            kykKihon.getHrkkeiro());

        BizCurrency sbkyhgkKyktuuka = null;

        if (C_ErrorKbn.OK.eq(calcHkShrKngkErrorKbn)) {

            sbkyhgkKyktuuka = calcHkShrKngk.getCalcHkShrKngkBean().getSibousGk();

        }

        KeisanKaiyakuBean keisanKaiyakuBean = SWAKInjector.getInstance(KeisanKaiyakuBean.class);

        keisanKaiyakuBean.setSyoruiukeymd(sysDate);
        keisanKaiyakuBean.setKaiykymd(sysDate);
        keisanKaiyakuBean.setYenshrkwsrate(kawaseRateSakusei);

        KeisanCommonKaiyaku keisanCommonKaiyaku = SWAKInjector.getInstance(KeisanCommonKaiyaku.class);

        C_ErrorKbn keisanCommonKaiyakuErrorKbn = keisanCommonKaiyaku.keisanKaiyakuseisankin(
            KeisanCommonKaiyaku.KINOUBUNRUI_DRCTSERVICE,
            kykKihon,
            sysDate,
            keisanKaiyakuBean
            );

        BizCurrency kaiyakujShrgkYen = null;
        BizCurrency kaiyakuhrYen     = null;
        BizCurrency kaiyakuhrGaika   = null;
        BizCurrency zennouzndkYen    = null;
        BizCurrency sonotaShrkngkYen = null;

        if (C_ErrorKbn.OK.eq(keisanCommonKaiyakuErrorKbn)) {

            KeisanCommonKaiyakuOutBean keisanCommonKaiyakuOutBean =
                keisanCommonKaiyaku.getKeisanCommonKaiyakuOutBean();

            kaiyakujShrgkYen = keisanCommonKaiyakuOutBean.getShrgkkeiYen();
            kaiyakuhrYen     = keisanCommonKaiyakuOutBean.getKaiyakuhrgoukeiYen();
            kaiyakuhrGaika   = keisanCommonKaiyakuOutBean.getKaiyakuhrgoukeigk();
            zennouzndkYen    = keisanCommonKaiyakuOutBean.getZennouseisankYen();
            sonotaShrkngkYen = kaiyakujShrgkYen.subtract(kaiyakuhrYen).subtract(zennouzndkYen);

        }

        KeisanHrrtksnHrkPGkgk keisanHrrtksnHrkPGkgk = SWAKInjector.getInstance(KeisanHrrtksnHrkPGkgk.class);
        C_ErrorKbn keisanHrrtksnHrkPGkgkErrorKbn = C_ErrorKbn.ERROR;
        boolean keisanHrrtksnHrkPGkgkKeisanKahi = false;
        C_KahiKbn hrkmPGkGkKeisanKahiKbn = C_KahiKbn.HUKA;

        keisanHrrtksnHrkPGkgkErrorKbn = keisanHrrtksnHrkPGkgk.exec(pSyono) ;

        keisanHrrtksnHrkPGkgkKeisanKahi = keisanHrrtksnHrkPGkgk.getKeisanKahi();

        if(C_ErrorKbn.OK.eq(keisanHrrtksnHrkPGkgkErrorKbn) && keisanHrrtksnHrkPGkgkKeisanKahi){

            hrkmPGkGkKeisanKahiKbn = C_KahiKbn.KA;
        }


        BizCurrency kihrkmpstgkYen = null;
        BizCurrency syouraiHrkmpstgkYen = null;


        if(C_KahiKbn.KA.eq(hrkmPGkGkKeisanKahiKbn)){
            kihrkmpstgkYen = keisanHrrtksnHrkPGkgk.getKihrkmP();
            syouraiHrkmpstgkYen = keisanHrrtksnHrkPGkgk.getHrkmPSgkHknkkn();
        }

        BizNumber genzaiHrRitu = null;

        if (kaiyakujShrgkYen != null && kihrkmpstgkYen != null) {

            genzaiHrRitu = kaiyakujShrgkYen.divideBizCurrency(kihrkmpstgkYen, 2, RoundingMode.DOWN).multiply(100);
        }



        HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);
        CurrencyType currencyType = henkanTuuka.henkanTuukaKbnToType(kykSyouhn.getKyktuukasyu());
        BizDateYM tmttkntaisyouym = null;
        BizCurrency calckaisiYmjitenv = BizCurrency.valueOf(0, currencyType);
        BizCurrency calckaisiYmjitensump = BizCurrency.valueOf(0, currencyType);

        BizDateYM maxTmttkntaisyouym = BizDateYM.valueOf(MAX_INT_VALUE_TMTTKNTAISYOUYM);
        IT_HokenryouTmttkn hokenryouTmttkn = hozenDomManager.getHokenryouTmttknBySyonoTmttkntaisyouym(pSyono,maxTmttkntaisyouym);

        if (hokenryouTmttkn != null) {

            tmttkntaisyouym = hokenryouTmttkn.getTmttkntaisyouym();

            calckaisiYmjitenv = hokenryouTmttkn.getPtmttkngk();

            calckaisiYmjitensump = hokenryouTmttkn.getKihrkmpstgk();
        }

        BizCurrency syouraiNkgnsGaika = null;
        BizCurrency syouraiNkgnsYen = null;
        C_ErrorKbn keisanVHeijyunErrorKbn = C_ErrorKbn.ERROR;
        C_ErrorKbn azukariGanrikinErrorKbn = C_ErrorKbn.ERROR;
        KeisanGaikakanzan keisanGaikakanzan = SWAKInjector.getInstance(KeisanGaikakanzan.class);



        if (C_ErrorKbn.OK.eq(getNyknKawaseRateErrorKbn)) {

            KeisanVHeijyunBean keisanVHeijyunBean = SWAKInjector.getInstance(KeisanVHeijyunBean.class);

            keisanVHeijyunBean.setSyouhncd(kykSyouhn.getSyouhncd());
            keisanVHeijyunBean.setRyouritusdno(kykSyouhn.getRyouritusdno());
            keisanVHeijyunBean.setCalckijyunYm(kykSyouhn.getHknkknmanryouymd().getBizDateYM());
            keisanVHeijyunBean.setKykymd(kykSyouhn.getKykymd());
            keisanVHeijyunBean.setHokenryou(kykSyouhn.getHokenryou());
            keisanVHeijyunBean.setKyktuukasyu(kykSyouhn.getKyktuukasyu());
            keisanVHeijyunBean.setHhknsei(kykSyouhn.getHhknsei());
            keisanVHeijyunBean.setHhknnen(kykSyouhn.getHhknnen());
            keisanVHeijyunBean.setHknkkn(kykSyouhn.getHknkkn());
            keisanVHeijyunBean.setHknkknsmnkbn(kykSyouhn.getHknkknsmnkbn());
            keisanVHeijyunBean.setHrkkkn(kykSyouhn.getHrkkkn());
            keisanVHeijyunBean.setHrkkknsmnkbn(kykSyouhn.getHrkkknsmnkbn());
            keisanVHeijyunBean.setHrkkaisuu(kykKihon.getHrkkaisuu());
            keisanVHeijyunBean.setFstpryosyu(kykKihon.getFstpnyknymd());
            keisanVHeijyunBean.setSitihsyuriritu(kykSyouhn.getYoteirrthendohosyurrt());
            keisanVHeijyunBean.setTmttkntaisyouym(tmttkntaisyouym);
            keisanVHeijyunBean.setCalckaisiYmjitenv(calckaisiYmjitenv);
            keisanVHeijyunBean.setCalckaisiYmjitensump(calckaisiYmjitensump);
            keisanVHeijyunBean.setSisansyuruikbn(C_KhSisanSyuruiKbn.JISSEKI_SISAN);
            keisanVHeijyunBean.setSisansyoriYmd(sysDate);
            keisanVHeijyunBean.setSisanyoteiriritu(syouhnZokusei.getYoteirirituminhosyouritu());
            keisanVHeijyunBean.setSisankawaserate(nyknKawaseRate);

            KeisanVHeijyun keisanVHeijyun = SWAKInjector.getInstance(KeisanVHeijyun.class);
            KeisanAzukariGanrikin keisanAzukariGanrikin = SWAKInjector.getInstance(KeisanAzukariGanrikin.class);



            keisanVHeijyunErrorKbn = keisanVHeijyun.exec(keisanVHeijyunBean);
            azukariGanrikinErrorKbn = keisanAzukariGanrikin.exec(
                pSyono,
                kykSyouhn.getHknkknmanryouymd(),
                keiyakuKihonBean.getKykTuukasyu()
                );
            BizCurrency azukariGanrikinGaika = keisanAzukariGanrikin.getAzukariGanrikinKyktuuka();
            BizCurrency azukariGanrikinYen = keisanAzukariGanrikin.getAzukariGanrikinYen();
            BizCurrency gaikaPtmttkn = keisanVHeijyun.getV();

            if (C_ErrorKbn.OK.eq(keisanVHeijyunErrorKbn) && C_ErrorKbn.OK.eq(azukariGanrikinErrorKbn)) {

                BizCurrency azukariGanrikinGaikaKz = keisanGaikakanzan.execDivide(
                    kykSyouhn.getKyktuukasyu(),
                    azukariGanrikinYen,
                    nyknKawaseRate,
                    C_HasuusyoriKbn.AGE
                    );

                syouraiNkgnsGaika = azukariGanrikinGaika.add(gaikaPtmttkn).add(azukariGanrikinGaikaKz);


                BizCurrency kzgkGaika = azukariGanrikinGaika.add(gaikaPtmttkn);

                BizCurrency kzgkYen = keisanGaikakanzan.exec(
                    C_Tuukasyu.JPY,
                    kzgkGaika,
                    kawaseRateSakusei,
                    C_HasuusyoriKbn.AGE
                    );

                syouraiNkgnsYen = azukariGanrikinYen.add(kzgkYen);

            }
        }


        BizNumber syouraiHrRitu = null;

        if (syouraiNkgnsYen != null && syouraiHrkmpstgkYen != null) {

            syouraiHrRitu = syouraiNkgnsYen.divideBizCurrency(syouraiHrkmpstgkYen, 2, RoundingMode.DOWN).multiply(100);
        }


        BizCurrency sbkyhgkyen = null;

        if (C_ErrorKbn.OK.eq(calcHkShrKngkErrorKbn)) {

            sbkyhgkyen = keisanGaikakanzan.exec(
                C_Tuukasyu.JPY,
                sbkyhgkKyktuuka,
                kawaseRateSakusei,
                C_HasuusyoriKbn.AGE
                );
        }


        C_UmuKbn teikiikkatubaraiUmu = null;

        if (C_TkiktbrisyuruiKbn.TEIKI_6MONTHS.eq(kykKihon.getTikiktbrisyuruikbn()) ||
            C_TkiktbrisyuruiKbn.TEIKI_12MONTHS.eq(kykKihon.getTikiktbrisyuruikbn())) {

            teikiikkatubaraiUmu = C_UmuKbn.ARI;

        }
        else {
            teikiikkatubaraiUmu = C_UmuKbn.NONE;
        }

        BizCurrency zennoutikiktbriyenhrkgk = null;

        if (zennou != null && C_UmuKbn.ARI.eq(zennouUmu)) {

            zennoutikiktbriyenhrkgk = zennou.getZennounyuukinkgk().add(nyknJissekiRireki.getRsgaku());

        }

        C_ErrorKbn kngkksnkekkakbn = null;

        if (C_ErrorKbn.ERROR.eq(keisanIkkatuNyuukinGkErrorKbn)  ||
            C_ErrorKbn.ERROR.eq(calcHkShrKngkErrorKbn)          ||
            C_ErrorKbn.ERROR.eq(keisanCommonKaiyakuErrorKbn)    ||
            C_ErrorKbn.ERROR.eq(keisanHrrtksnHrkPGkgkErrorKbn)  ||
            C_ErrorKbn.ERROR.eq(keisanVHeijyunErrorKbn)         ||
            C_ErrorKbn.ERROR.eq(azukariGanrikinErrorKbn))
        {

            kngkksnkekkakbn = C_ErrorKbn.ERROR;

        }
        else {

            kngkksnkekkakbn = C_ErrorKbn.OK;

        }

        getHzKykGikHijynNnknOutputBean.setIwsDsmsgcd(DwMessageCodeConstants.IWSDSMSGCD_017000);

        getHzKykGikHijynNnknOutputBean.setIwsSyono(pSyono);

        getHzKykGikHijynNnknOutputBean.setIwsAisyoumei(keiyakuKihonBean.getAisyoumeiKbn().getContent());

        getHzKykGikHijynNnknOutputBean.setIwsSyouhnnm(keiyakuKihonBean.getSyouhnNm());

        getHzKykGikHijynNnknOutputBean.setIwsKykymdstr(dateToStr(keiyakuKihonBean.getKykYmd()));

        getHzKykGikHijynNnknOutputBean.setIwsKyktuukasyu(keiyakuKihonBean.getKykTuukasyu().getValue());

        getHzKykGikHijynNnknOutputBean.setIwsSakuseikijyunymdstr(dateToStr(keiyakuKihonBean.getSakuseiKijyunYmd()));

        getHzKykGikHijynNnknOutputBean.setIwsKyknmkn(keiyakusyaBean.getKykNmKn());

        getHzKykGikHijynNnknOutputBean.setIwsKyknmkj(keiyakusyaBean.getKykNmKj());

        getHzKykGikHijynNnknOutputBean.setIwsKykseiymdstr(dateToStr(keiyakusyaBean.getKykseiYmd()));

        getHzKykGikHijynNnknOutputBean.setIwsKyksei(keiyakusyaBean.getKyksei().getValue());

        getHzKykGikHijynNnknOutputBean.setIwsHhknnmkn(hihokensyaBean.getHhknNmKn());

        getHzKykGikHijynNnknOutputBean.setIwsHhknseiymdstr(dateToStr(hihokensyaBean.getHhknseiYmd()));

        getHzKykGikHijynNnknOutputBean.setIwsSbuktnin(String.valueOf(keiyakuUketorininBean.getSbuktnin()));

        getHzKykGikHijynNnknOutputBean.setIwsUktmidasikbn1(keiyakuUketorininBean.getUktsyuKbn1().getValue());

        getHzKykGikHijynNnknOutputBean.setIwsUktkbn1str(keiyakuUketorininBean.getGkdtKoktuutiUktKbn1().getValue());

        getHzKykGikHijynNnknOutputBean.setIwsUktsimei1(keiyakuUketorininBean.getUktNm1());

        getHzKykGikHijynNnknOutputBean.setIwsUktmidasikbn2(keiyakuUketorininBean.getUktsyuKbn2().getValue());

        getHzKykGikHijynNnknOutputBean.setIwsUktkbn2str(keiyakuUketorininBean.getGkdtKoktuutiUktKbn2().getValue());

        getHzKykGikHijynNnknOutputBean.setIwsUktsimei2(keiyakuUketorininBean.getUktNm2());

        getHzKykGikHijynNnknOutputBean.setIwsUktmidasikbn3(keiyakuUketorininBean.getUktsyuKbn3().getValue());

        getHzKykGikHijynNnknOutputBean.setIwsUktkbn3str(keiyakuUketorininBean.getGkdtKoktuutiUktKbn3().getValue());

        getHzKykGikHijynNnknOutputBean.setIwsUktsimei3(keiyakuUketorininBean.getUktNm3());

        getHzKykGikHijynNnknOutputBean.setIwsUktmidasikbn4(keiyakuUketorininBean.getUktsyuKbn4().getValue());

        getHzKykGikHijynNnknOutputBean.setIwsUktkbn4str(keiyakuUketorininBean.getGkdtKoktuutiUktKbn4().getValue());

        getHzKykGikHijynNnknOutputBean.setIwsUktsimei4(keiyakuUketorininBean.getUktNm4());

        getHzKykGikHijynNnknOutputBean.setIwsUktmidasikbn5(keiyakuUketorininBean.getUktsyuKbn5().getValue());

        getHzKykGikHijynNnknOutputBean.setIwsUktkbn5str(keiyakuUketorininBean.getGkdtKoktuutiUktKbn5().getValue());

        getHzKykGikHijynNnknOutputBean.setIwsUktsimei5(keiyakuUketorininBean.getUktNm5());

        getHzKykGikHijynNnknOutputBean.setIwsUktmidasikbn6(keiyakuUketorininBean.getUktsyuKbn6().getValue());

        getHzKykGikHijynNnknOutputBean.setIwsUktkbn6str(keiyakuUketorininBean.getGkdtKoktuutiUktKbn6().getValue());

        getHzKykGikHijynNnknOutputBean.setIwsUktsimei6(keiyakuUketorininBean.getUktNm6());

        getHzKykGikHijynNnknOutputBean.setIwsUktmidasikbn7(keiyakuUketorininBean.getUktsyuKbn7().getValue());

        getHzKykGikHijynNnknOutputBean.setIwsUktkbn7str(keiyakuUketorininBean.getGkdtKoktuutiUktKbn7().getValue());

        getHzKykGikHijynNnknOutputBean.setIwsUktsimei7(keiyakuUketorininBean.getUktNm7());

        getHzKykGikHijynNnknOutputBean.setIwsUktmidasikbn8(keiyakuUketorininBean.getUktsyuKbn8().getValue());

        getHzKykGikHijynNnknOutputBean.setIwsUktkbn8str(keiyakuUketorininBean.getGkdtKoktuutiUktKbn8().getValue());

        getHzKykGikHijynNnknOutputBean.setIwsUktsimei8(keiyakuUketorininBean.getUktNm8());

        getHzKykGikHijynNnknOutputBean.setIwsUktmidasikbn9(keiyakuUketorininBean.getUktsyuKbn9().getValue());

        getHzKykGikHijynNnknOutputBean.setIwsUktkbn9str(keiyakuUketorininBean.getGkdtKoktuutiUktKbn9().getValue());

        getHzKykGikHijynNnknOutputBean.setIwsUktsimei9(keiyakuUketorininBean.getUktNm9());

        getHzKykGikHijynNnknOutputBean.setIwsUktmidasikbn10(keiyakuUketorininBean.getUktsyuKbn10().getValue());

        getHzKykGikHijynNnknOutputBean.setIwsUktkbn10str(keiyakuUketorininBean.getGkdtKoktuutiUktKbn10().getValue());

        getHzKykGikHijynNnknOutputBean.setIwsUktsimei10(keiyakuUketorininBean.getUktNm10());

        getHzKykGikHijynNnknOutputBean.setIwsTrkkzknmkn1(trkKazokuBean.getTrkkzknmKn1());

        getHzKykGikHijynNnknOutputBean.setIwsTrkkzknmkn2(trkKazokuBean.getTrkkzknmKn2());

        getHzKykGikHijynNnknOutputBean.setIwsTutakinumukbn(gamenSeigyoBean.getTutakinUmukbn().getValue());

        getHzKykGikHijynNnknOutputBean.setIwsKaiyakuhrsuiiumukbn(gamenSeigyoBean.getKaiyakuHrsuiiUmuKbn().getValue());

        getHzKykGikHijynNnknOutputBean.setIwsSbhsyumukbn(hosyouBean.getSbHsyUmuKbn().getValue());

        getHzKykGikHijynNnknOutputBean.setIwsKghsyumukbn(hosyouBean.getKgHsyUmukbn().getValue());

        getHzKykGikHijynNnknOutputBean.setIwsIryhsyumukbn(hosyouBean.getIryHsyUmukbn().getValue());

        getHzKykGikHijynNnknOutputBean.setIwsRougohsyumukbn(hosyouBean.getRougoHsyUmukbn().getValue());

        getHzKykGikHijynNnknOutputBean.setIwsKykdrtkhkumu(tokuyakuBean.getKykdrTkykhukaumu().getValue());

        getHzKykGikHijynNnknOutputBean.setIwsStdrsktkyhkumu(tokuyakuBean.getStdrskTkyhkumu().getValue());

        getHzKykGikHijynNnknOutputBean.setIwsYennykntkhkumu(tokuyakuBean.getYenNyknThkumu().getValue());

        getHzKykGikHijynNnknOutputBean.setIwsGaikanykntkhkumu(tokuyakuBean.getGaikaNyknTkhkumu().getValue());

        getHzKykGikHijynNnknOutputBean.setIwsTargettkhkumu(tokuyakuBean.getTargetTkhkumu().getValue());

        getHzKykGikHijynNnknOutputBean.setIwsSyksbyensitihsyutyhkumu(
            tokuyakuBean.getInitSbjiYenSitiHsyTkhukaumu().getValue());

        getHzKykGikHijynNnknOutputBean.setIwsJyudkaigomehrtkhkumu(
            tokuyakuBean.getJyudKaigoMeharaiTkhukaumu().getValue());

        getHzKykGikHijynNnknOutputBean.setIwsZeiseitkkktkykhukaumu(
            tokuyakuBean.getZeiseiTkkkTkykhukaumu().getValue());

        getHzKykGikHijynNnknOutputBean.setIwsKjsmsaihakkoukahikbn(syoriKahiBean.getKjsmSaihakkouKahiKbn().getValue());

        getHzKykGikHijynNnknOutputBean.setIwsKykmeigihnkkahikbn(syoriKahiBean.getKykMeigihnkKahiKbn().getValue());

        getHzKykGikHijynNnknOutputBean.setIwsSyoukensaihkkahikbn(syoriKahiBean.getSyoukenSaihkKahiKbn().getValue());

        getHzKykGikHijynNnknOutputBean.setIwsStdrsktkytthkkahikbn(syoriKahiBean.getStdrskTkyTthkKahiKbn().getValue());

        getHzKykGikHijynNnknOutputBean.setIwsTargettkhkkahikbn(syoriKahiBean.getTargetTkhkKahiKbn().getValue());

        getHzKykGikHijynNnknOutputBean.setIwsKykniyusyoukaikahikbn(syoriKahiBean.getKykNiyuSyoukaiKahiKbn().getValue());

        getHzKykGikHijynNnknOutputBean.setIwsTumitatekinitenkahikbn(
            syoriKahiBean.getTumitatekinItenKahiKbn().getValue());

        getHzKykGikHijynNnknOutputBean.setIwsDskaiyakukahikbn(syoriKahiBean.getDsKaiyakuKahiKbn().getValue());

        getHzKykGikHijynNnknOutputBean.setIwsAdrhenkoukahikbn(syoriKahiBean.getAdrHenkouKahiKbn().getValue());

        getHzKykGikHijynNnknOutputBean.setIwsPhrkhouhenkoukahikbn(syoriKahiBean.getPhrkhouHenkouKahiKbn().getValue());

        getHzKykGikHijynNnknOutputBean.setIwsHrkkaisuu(hrkkaisuu);

        getHzKykGikHijynNnknOutputBean.setIwsHrkkeiro(kykKihon.getHrkkeiro().getContent());

        getHzKykGikHijynNnknOutputBean.setIwsHrkkkn(String.valueOf(kykSyouhn.getHrkkkn()));

        getHzKykGikHijynNnknOutputBean.setIwsNenkinstartymd(dateToStr(kykSyouhn.getHknkknmanryouymd()));

        getHzKykGikHijynNnknOutputBean.setIwsNenkinstartnen(String.valueOf(nenkinstartnen));

        getHzKykGikHijynNnknOutputBean.setIwsSueokikknstr(String.valueOf(sueokikikan));

        getHzKykGikHijynNnknOutputBean.setIwsNenkinsyustr(nnenkinSyu);

        getHzKykGikHijynNnknOutputBean.setIwsRsgakuyen(currencyToStr(kykKihon.getHrkp()));

        getHzKykGikHijynNnknOutputBean.setIwsTikiktbrisyuruikbn(kykKihon.getTikiktbrisyuruikbn().getContent());

        getHzKykGikHijynNnknOutputBean.setIwsRsgakuyentikiktbri(currencyToStr(rsgakuyentikiktbri));

        getHzKykGikHijynNnknOutputBean.setIwsZennoutikiktbriyenhrkgk(currencyToStr(zennoutikiktbriyenhrkgk));

        getHzKykGikHijynNnknOutputBean.setIwsYoteiriritu(numberToStr(yoteiriritu));

        getHzKykGikHijynNnknOutputBean.setIwsKwsratekijyunymdsakusei(dateToStr(kawaseRateKjYmdSakusei));

        getHzKykGikHijynNnknOutputBean.setIwsSksikijyunymdkawaserate(numberToStr(kawaseRateSakusei));

        getHzKykGikHijynNnknOutputBean.setIwsSbkyhgkyen(currencyToStr(sbkyhgkyen));

        getHzKykGikHijynNnknOutputBean.setIwsSbkyhgkgaika(currencyToStr(sbkyhgkKyktuuka));

        getHzKykGikHijynNnknOutputBean.setIwsKaiyakujshrgkyen(currencyToStr(kaiyakujShrgkYen));

        getHzKykGikHijynNnknOutputBean.setIwsKaiyakuhryen(currencyToStr(kaiyakuhrYen));

        getHzKykGikHijynNnknOutputBean.setIwsKaiyakuhrgaika(currencyToStr(kaiyakuhrGaika));

        getHzKykGikHijynNnknOutputBean.setIwsZennouzndkyen(currencyToStr(zennouzndkYen));

        getHzKykGikHijynNnknOutputBean.setIwsSonotasiharaikingakuyen(currencyToStr(sonotaShrkngkYen));

        getHzKykGikHijynNnknOutputBean.setIwsKihrkmpstgkyen(currencyToStr(kihrkmpstgkYen));

        getHzKykGikHijynNnknOutputBean.setIwsGenzainohrritu(numberToStr(genzaiHrRitu));

        getHzKykGikHijynNnknOutputBean.setIwsSyourainkgnsyen(currencyToStr(syouraiNkgnsYen));

        getHzKykGikHijynNnknOutputBean.setIwsSyourainkgnsgaika(currencyToStr(syouraiNkgnsGaika));

        getHzKykGikHijynNnknOutputBean.setIwsSyouraihrkmpstgkyen(currencyToStr(syouraiHrkmpstgkYen));

        getHzKykGikHijynNnknOutputBean.setIwsSyourainohrritu(numberToStr(syouraiHrRitu));

        getHzKykGikHijynNnknOutputBean.setIwsTeikiikkatubaraiumu(teikiikkatubaraiUmu.getValue());

        getHzKykGikHijynNnknOutputBean.setIwsZennouumu(zennouUmu.getValue());

        getHzKykGikHijynNnknOutputBean.setIwsKngkksnkekkakbn(kngkksnkekkakbn.getValue());

        getHzKykGikHijynNnknOutputBean.setIwsHrkpgkeiksnkhkbn(hrkmPGkGkKeisanKahiKbn.getValue());

        getHzKykGikHijynNnknOutputBean.setIwsYakkanbunsyono(keiyakuKihonBean.getYakkanBunsyoNo());

        return getHzKykGikHijynNnknOutputBean;

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

    private String numberToStr(BizNumber pNumber) {

        if (pNumber == null) {

            return null;

        }

        return pNumber.toString();

    }
}
