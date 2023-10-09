package yuyu.app.dsweb.dwninsyou.dwlogin;

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

import yuyu.common.base.BaseUserInfo;
import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bzcommon.RayConvertUtil;
import yuyu.common.biz.bzwebserviceaccesslogoutput.WebServiceAccesslogOutput;
import yuyu.common.direct.dscommon.CheckDsKaiyaku;
import yuyu.common.direct.dscommon.DsDB2Util;
import yuyu.common.direct.dscommon.HozenKeiyakuIdouJyoutaiSyutoku;
import yuyu.common.direct.dscommon.HozenKeiyakuIdouJyoutaiSyutokuBean;
import yuyu.common.dsweb.dwcommon.DwMessageCodeConstants;
import yuyu.common.hozen.khcommon.CheckYuuyokkngai;
import yuyu.def.MessageId;
import yuyu.def.biz.bean.param.WsBzWebserviceReqParamBean;
import yuyu.def.biz.bean.param.WsBzWebserviceResParamBean;
import yuyu.def.classification.C_AccessLogSyubetuKbn;
import yuyu.def.classification.C_BaitaiKbn;
import yuyu.def.classification.C_DsKinouidKbn;
import yuyu.def.classification.C_DsKokyakuJtKbn;
import yuyu.def.classification.C_DsTeisiRiyuuKbn;
import yuyu.def.classification.C_IdoutyuuHanteiKekkaKbn;
import yuyu.def.classification.C_PasswordJtKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YuukshantkekKbn;
import yuyu.def.db.entity.MT_DsHonninKakuninCd;
import yuyu.def.db.entity.MT_DsKokyakuKanri;
import yuyu.def.db.entity.MT_DsKokyakuKeiyaku;
import yuyu.def.db.entity.MT_DsLoginKanri;
import yuyu.def.direct.manager.DirectDomManager;
import yuyu.def.dsweb.bean.webservice.WsDwLoginInputBean;
import yuyu.def.dsweb.bean.webservice.WsDwLoginOutputBean;
import yuyu.def.dsweb.configuration.YuyuDswebConfig;

/**
 * ログイン認証サービスの実装クラスです。<br />
 */
public class DwLoginImpl implements DwLogin {

    @Inject
    private static Logger logger;

    @Inject
    private DirectDomManager directDomManager;

    @Inject
    private BaseUserInfo baseUserInfo;

    @Override
    public WsBzWebserviceResParamBean execPostForm(MultivaluedMap<String, String> pMap) {

        logger.info(MessageUtil.getMessage(MessageId.IBF0016, MessageUtil.getMessage(MessageId.INW1001)));

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean;

        try {
            wsBzWebserviceResParamBean = loginMain(pMap);
        } catch (Exception throwable) {
            DsDB2Util dsDB2Util = SWAKInjector.getInstance(DsDB2Util.class);

            DsDB2Util.E_Result result = dsDB2Util.exec(throwable);

            String iwsDsmsgcd = "";

            if (DsDB2Util.E_Result.DEADLOCK.compareTo(result) == 0) {
                iwsDsmsgcd = DwMessageCodeConstants.IWSDSMSGCD_001203;
            }
            else if (DsDB2Util.E_Result.QUERY_TIMEOUT.compareTo(result) == 0) {
                iwsDsmsgcd = DwMessageCodeConstants.IWSDSMSGCD_001202;
            }
            else if (DsDB2Util.E_Result.OTHER.compareTo(result) == 0) {
                throw throwable;
            }

            WsDwLoginOutputBean wsDwLoginOutputBean = SWAKInjector.getInstance(WsDwLoginOutputBean.class);
            wsBzWebserviceResParamBean = SWAKInjector.getInstance(WsBzWebserviceResParamBean.class);
            wsDwLoginOutputBean.setIwsDsmsgcd(iwsDsmsgcd);
            wsBzWebserviceResParamBean.setGyoumuData(JSON.encode(wsDwLoginOutputBean));
        } finally {
            logger.info(MessageUtil.getMessage(MessageId.IBF0017, MessageUtil.getMessage(MessageId.INW1001)));
        }

        return wsBzWebserviceResParamBean;
    }

    @Transactional
    WsBzWebserviceResParamBean loginMain(MultivaluedMap<String, String> pMap) {
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

        WsDwLoginInputBean wsDwLoginInputBean = JSON.decode(gyoumuData, WsDwLoginInputBean.class);

        WebServiceAccesslogOutput webServiceAccesslogOutput =
            SWAKInjector.getInstance(WebServiceAccesslogOutput.class);
        webServiceAccesslogOutput.exec(C_AccessLogSyubetuKbn.ACTION_BEGIN,
            wsBzWebserviceReqParamBean, wsDwLoginInputBean);

        WsDwLoginOutputBean wsDwLoginOutputBean = SWAKInjector.getInstance(WsDwLoginOutputBean.class);

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = SWAKInjector.getInstance(WsBzWebserviceResParamBean.class);

        boolean hissuChkKekka = wsDwLoginInputBean.chkHissuInput();

        if (!hissuChkKekka) {
            wsDwLoginOutputBean.setIwsDsmsgcd(DwMessageCodeConstants.IWSDSMSGCD_001100);

            wsBzWebserviceResParamBean.setGyoumuData(JSON.encode(wsDwLoginOutputBean));

            return wsBzWebserviceResParamBean;

        }

        Validator validator = SWAKInjector.getInstance(Validator.class);
        Set<ConstraintViolation<WsDwLoginInputBean>> chkKekkaSet = validator.validate(wsDwLoginInputBean);

        if(chkKekkaSet.size() > 0){
            wsDwLoginOutputBean.setIwsDsmsgcd(DwMessageCodeConstants.IWSDSMSGCD_001100);

            wsBzWebserviceResParamBean.setGyoumuData(JSON.encode(wsDwLoginOutputBean));

            return wsBzWebserviceResParamBean;
        }

        RayConvertUtil.toValidString(wsDwLoginInputBean);

        wsDwLoginOutputBean = loginAuthenticate(wsDwLoginInputBean.getIwsSyono(), wsDwLoginInputBean.getIwsPassword());

        wsBzWebserviceResParamBean.setGyoumuData(JSON.encode(wsDwLoginOutputBean));

        return wsBzWebserviceResParamBean;
    }


    private WsDwLoginOutputBean loginAuthenticate(String pSyono, String pPassword){

        WsDwLoginOutputBean wsDwLoginOutputBean = SWAKInjector.getInstance(WsDwLoginOutputBean.class);

        String kinouId     = C_DsKinouidKbn.LOGIN.getValue();
        String userId      = baseUserInfo.getUserId();
        BizDate sysDate    = BizDate.getSysDate();
        String sysDateTime = BizDate.getSysDateTimeMilli();
        String sysTime     = sysDateTime.substring(8, 14);

        List<MT_DsKokyakuKeiyaku> mtDsKokyakuKeiyakuList = directDomManager.getDsKokyakuKeiyakusBySyonoDskykmukouhyjBlank(pSyono);

        if (mtDsKokyakuKeiyakuList.size() == 0) {
            wsDwLoginOutputBean.setIwsDsmsgcd(DwMessageCodeConstants.IWSDSMSGCD_001201);
            return wsDwLoginOutputBean;
        }

        MT_DsKokyakuKeiyaku  mtDsKokyakuKeiyaku  = mtDsKokyakuKeiyakuList.get(0);
        MT_DsKokyakuKanri    mtDsKokyakuKanri    = mtDsKokyakuKeiyaku.getDsKokyakuKanri();
        MT_DsHonninKakuninCd mtDsHonninKakuninCd = mtDsKokyakuKanri.getDsHonninKakuninCd();
        MT_DsLoginKanri      mtDsLoginKanri      = mtDsKokyakuKanri.getDsLoginKanri();

        C_PasswordJtKbn passwordJtKbn = C_PasswordJtKbn.BLANK;
        String saisinLoginYmd = "";
        String saisinLoginTime = "";

        if (!BizUtil.isBlank(mtDsHonninKakuninCd.getDshnnkakcd())) {
            passwordJtKbn = C_PasswordJtKbn.HON;
            saisinLoginYmd = mtDsLoginKanri.getSaisinloginymd().toString();
            saisinLoginTime = mtDsLoginKanri.getSaisinlogintime();
        }
        else if (!BizUtil.isBlank(mtDsHonninKakuninCd.getDskrhnnkakcd())) {
            passwordJtKbn = C_PasswordJtKbn.KARI;
            saisinLoginYmd = "";
            saisinLoginTime = "";        }
        else {
            wsDwLoginOutputBean.setIwsDsmsgcd(DwMessageCodeConstants.IWSDSMSGCD_001300);
            return wsDwLoginOutputBean;
        }

        if (C_PasswordJtKbn.HON.eq(passwordJtKbn)) {
            if (C_DsKokyakuJtKbn.YUUKOU.eq(mtDsKokyakuKanri.getDskokyakujtkbn())) {
            }
            else {
                if (C_DsTeisiRiyuuKbn.LOCK_OUT.eq(mtDsKokyakuKanri.getDsteisiriyuukbn())) {
                    wsDwLoginOutputBean.setIwsDsmsgcd(DwMessageCodeConstants.IWSDSMSGCD_001006);
                    return wsDwLoginOutputBean;
                }
                else {
                    wsDwLoginOutputBean.setIwsDsmsgcd(DwMessageCodeConstants.IWSDSMSGCD_001001);
                    return wsDwLoginOutputBean;
                }
            }
        }
        else if (C_PasswordJtKbn.KARI.eq(passwordJtKbn)) {
            if (C_DsKokyakuJtKbn.ITIJI_TEISI.eq(mtDsKokyakuKanri.getDskokyakujtkbn())
                && C_DsTeisiRiyuuKbn.PASSWORD_MITOUROKU.eq(mtDsKokyakuKanri.getDsteisiriyuukbn())) {
            }
            else {
                if (C_DsTeisiRiyuuKbn.LOCK_OUT.eq(mtDsKokyakuKanri.getDsteisiriyuukbn())) {
                    wsDwLoginOutputBean.setIwsDsmsgcd(DwMessageCodeConstants.IWSDSMSGCD_001006);
                    return wsDwLoginOutputBean;
                }
                else {
                    wsDwLoginOutputBean.setIwsDsmsgcd(DwMessageCodeConstants.IWSDSMSGCD_001002);
                    return wsDwLoginOutputBean;
                }
            }
        }

        HozenKeiyakuIdouJyoutaiSyutoku hozenKeiyakuIdouJyoutaiSyutoku = SWAKInjector.getInstance(HozenKeiyakuIdouJyoutaiSyutoku.class);

        CheckYuuyokkngai checkYuuyokkngai = SWAKInjector.getInstance(CheckYuuyokkngai.class);

        HozenKeiyakuIdouJyoutaiSyutokuBean hozenKeiyakuIdouJyoutaiSyutokuBean =
            hozenKeiyakuIdouJyoutaiSyutoku.hozenKeiyakuIdouJyoutaiSyutoku(pSyono);

        boolean checkYuuyokkngaiKekka = checkYuuyokkngai.exec(pSyono, BizDate.getSysDate());

        if (C_YuukshantkekKbn.OK.eq(hozenKeiyakuIdouJyoutaiSyutokuBean.getYuukouKbn())
            && C_IdoutyuuHanteiKekkaKbn.IDOUNASHI.eq(hozenKeiyakuIdouJyoutaiSyutokuBean.getIdoutyuuKbn())
            && checkYuuyokkngaiKekka) {
        }
        else {
            wsDwLoginOutputBean.setIwsDsmsgcd(DwMessageCodeConstants.IWSDSMSGCD_001003);
            return wsDwLoginOutputBean;
        }

        CheckDsKaiyaku checkDsKaiyaku = SWAKInjector.getInstance(CheckDsKaiyaku.class);

        C_UmuKbn dsKaiyakuUkeUmu = checkDsKaiyaku.kaiyakuUkeUmuChk(pSyono);

        if (C_UmuKbn.ARI.equals(dsKaiyakuUkeUmu)) {
            wsDwLoginOutputBean.setIwsDsmsgcd(DwMessageCodeConstants.IWSDSMSGCD_001008);
            return wsDwLoginOutputBean;
        }

        boolean countUpFlg      = false;
        boolean authenticateFlg = false;
        boolean lockoutFlg      = false;
        boolean kariPasswordAuthenticateFlg      = false;

        if (C_PasswordJtKbn.HON.eq(passwordJtKbn)) {
            if (mtDsHonninKakuninCd.getDshnnkakcd().equals(pPassword)) {
                authenticateFlg = true;
            }
            else {
                countUpFlg = true;
            }
        }

        else if (C_PasswordJtKbn.KARI.eq(passwordJtKbn)) {


            if (mtDsHonninKakuninCd.getDskrhnnkakcd().equals(pPassword)) {
                if (BizDateUtil.compareYmd(mtDsHonninKakuninCd.getDskrhnnkakcdyuukouymd(), sysDate) == BizDateUtil.COMPARE_LESSER) {
                    wsDwLoginOutputBean.setIwsDsmsgcd(DwMessageCodeConstants.IWSDSMSGCD_001005);
                    return wsDwLoginOutputBean;
                }

                authenticateFlg = true;
                kariPasswordAuthenticateFlg = true;
            }
            else {
                countUpFlg = true;
            }
        }

        int dsHnnKakCdErrorKaisuu = mtDsLoginKanri.getDshnnkakcderrorkaisuu();

        if (countUpFlg) {
            dsHnnKakCdErrorKaisuu = mtDsLoginKanri.getDshnnkakcderrorkaisuu() + 1;
            lockoutFlg = false;

            if (dsHnnKakCdErrorKaisuu >= YuyuDswebConfig.getInstance().getLockoutKiteiKaisuu()) {
                lockoutFlg = true;
            }
        }

        if (lockoutFlg) {
            mtDsKokyakuKanri.setDskokyakujtkbn(C_DsKokyakuJtKbn.ITIJI_TEISI);
            mtDsKokyakuKanri.setDsteisiriyuukbn(C_DsTeisiRiyuuKbn.LOCK_OUT);
            mtDsKokyakuKanri.setDskokyakumukouymd(sysDate);
            mtDsKokyakuKanri.setGyoumuKousinKinou(kinouId);
            mtDsKokyakuKanri.setGyoumuKousinsyaId(userId);
            mtDsKokyakuKanri.setGyoumuKousinTime(sysDateTime);
        }

        if (authenticateFlg) {
            if (C_PasswordJtKbn.HON.eq(passwordJtKbn)) {
                mtDsLoginKanri.setSaisinloginymd(sysDate);
                mtDsLoginKanri.setSaisinlogintime(sysTime);
                mtDsLoginKanri.setSaisinloginbaitaikbn(C_BaitaiKbn.PC);
                mtDsLoginKanri.setDshnnkakcderrorkaisuu(0);
                mtDsLoginKanri.setDskokyakunmerrorkaisuu(0);
                mtDsLoginKanri.setDskokyakuseiymderrorkaisuu(0);
                mtDsLoginKanri.setDskokyakutelnoerrorkaisuu(0);
                mtDsLoginKanri.setGyoumuKousinKinou(kinouId);
                mtDsLoginKanri.setGyoumuKousinsyaId(userId);
                mtDsLoginKanri.setGyoumuKousinTime(sysDateTime);
            }
            else if (C_PasswordJtKbn.KARI.eq(passwordJtKbn)) {
            }
        }
        else {
            mtDsLoginKanri.setDshnnkakcderrorkaisuu(dsHnnKakCdErrorKaisuu);
            mtDsLoginKanri.setGyoumuKousinKinou(kinouId);
            mtDsLoginKanri.setGyoumuKousinsyaId(userId);
            mtDsLoginKanri.setGyoumuKousinTime(sysDateTime);
        }

        if (!kariPasswordAuthenticateFlg) {
            try {
                directDomManager.update(mtDsKokyakuKanri);
            }catch (Exception e) {
                wsDwLoginOutputBean.setIwsDsmsgcd(DwMessageCodeConstants.IWSDSMSGCD_001200);
                return wsDwLoginOutputBean;
            }
        }

        if (lockoutFlg) {
            wsDwLoginOutputBean.setIwsDsmsgcd(DwMessageCodeConstants.IWSDSMSGCD_001007);
            wsDwLoginOutputBean.setIwsDskokno(mtDsKokyakuKanri.getDskokno());
            wsDwLoginOutputBean.setIwsPasswordjtkbn(passwordJtKbn.getValue());
            wsDwLoginOutputBean.setIwsSaisinloginymd("");
            wsDwLoginOutputBean.setIwsSaisinlogintime("");
            wsDwLoginOutputBean.setIwsFuho2serverymd("");
            wsDwLoginOutputBean.setIwsPassworderrorkaisuu(mtDsLoginKanri.getDshnnkakcderrorkaisuu().toString());
        }
        else if (countUpFlg) {
            wsDwLoginOutputBean.setIwsDsmsgcd(DwMessageCodeConstants.IWSDSMSGCD_001007);
            wsDwLoginOutputBean.setIwsDskokno(mtDsKokyakuKanri.getDskokno());
            wsDwLoginOutputBean.setIwsPasswordjtkbn(passwordJtKbn.getValue());
            wsDwLoginOutputBean.setIwsSaisinloginymd("");
            wsDwLoginOutputBean.setIwsSaisinlogintime("");
            wsDwLoginOutputBean.setIwsFuho2serverymd("");
            wsDwLoginOutputBean.setIwsPassworderrorkaisuu(mtDsLoginKanri.getDshnnkakcderrorkaisuu().toString());
        }
        else {
            wsDwLoginOutputBean.setIwsDsmsgcd(DwMessageCodeConstants.IWSDSMSGCD_001000);
            wsDwLoginOutputBean.setIwsDskokno(mtDsKokyakuKanri.getDskokno());
            wsDwLoginOutputBean.setIwsPasswordjtkbn(passwordJtKbn.getValue());
            wsDwLoginOutputBean.setIwsSaisinloginymd(saisinLoginYmd);
            wsDwLoginOutputBean.setIwsSaisinlogintime(saisinLoginTime);
            wsDwLoginOutputBean.setIwsFuho2serverymd(sysDate.toString());
            wsDwLoginOutputBean.setIwsPassworderrorkaisuu(mtDsLoginKanri.getDshnnkakcderrorkaisuu().toString());
        }

        return wsDwLoginOutputBean;
    }

}
