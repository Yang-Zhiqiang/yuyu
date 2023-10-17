package yuyu.app.siharai.sisatei.sisinsatyuuisetei;

import static yuyu.app.siharai.sisatei.sisinsatyuuisetei.GenSiSinsaTyuuiSeteiConstants.*;
import static yuyu.app.siharai.sisatei.sisinsatyuuisetei.SiSinsaTyuuiSeteiConstants.*;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.bizinfr.exception.BizLogicException;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.util.message.MessageUtil;
import jp.co.slcs.swak.web.message.MessageManager;

import org.slf4j.Logger;

import yuyu.common.base.BaseUserInfo;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bzcommon.BzGetSousasyaSyozokuSosikiData;
import yuyu.common.biz.bzcommon.BzGetSousasyaSyozokuSosikiDataBean;
import yuyu.common.siharai.kyk.KeiyakuInfoSyutoku;
import yuyu.common.siharai.kyk.KeiyakuPrm;
import yuyu.common.siharai.sicommon.SiKinouModeSettei;
import yuyu.def.MessageId;
import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.classification.C_NayoseYouhi;
import yuyu.def.classification.C_SetteiKbn;
import yuyu.def.classification.C_YuukousyoumetuKbn;
import yuyu.def.db.entity.AM_User;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.JT_SiKykKihon;
import yuyu.def.db.entity.JT_SinsaTyuui;
import yuyu.def.siharai.manager.SiharaiDomManager;
import yuyu.infr.kinoumode.KinouMode;

/**
 * 審査注意設定 のビジネスロジックです。
 */
public class SiSinsaTyuuiSeteiBizLogic {

    @SuppressWarnings("unused")
    @Inject
    private static Logger logger;

    @Inject
    private SiSinsaTyuuiSeteiUiBean uiBean;

    @Inject
    private SiharaiDomManager siharaiDomManager;

    @Inject
    private BaseDomManager baseDomManager;

    @Inject
    private KinouMode kinouMode;

    @Inject
    private AS_Kinou kinou;

    @Inject
    private BaseUserInfo baseUserInfo;

    @Inject
    private MessageManager messageManager;

    void init() {
    }

    void clear() {
    }

    String ketteiBtnOnClick() {

        BizPropertyInitializer.initialize(uiBean);

        SiKinouModeSettei siKinouModeSettei = SWAKInjector.getInstance(SiKinouModeSettei.class);
        siKinouModeSettei.exec();

        KeiyakuInfoSyutoku keiyakuInfoSyutoku = SWAKInjector.getInstance(KeiyakuInfoSyutoku.class);
        KeiyakuPrm keiyakuPrm = SWAKInjector.getInstance(KeiyakuPrm.class);
        keiyakuPrm.setSyono(uiBean.getSyono());
        keiyakuPrm.setINayoseyh(C_NayoseYouhi.HUYOU);
        keiyakuInfoSyutoku.getInfos(keiyakuPrm);
        List<JT_SiKykKihon> siKykKihonLst = keiyakuInfoSyutoku.getKykKihons();
        if (siKykKihonLst.get(0) == null) {
            throw new BizLogicException(MessageId.EBA0024, MessageUtil.getMessage(MessageId.IJW1001));
        }

        JT_SinsaTyuui sinsaTyuui = siharaiDomManager.getSinsaTyuui(uiBean.getSyono());

        if (sinsaTyuui != null) {
            String userId = sinsaTyuui.getGyoumuKousinsyaId();
            AM_User userInfo = baseDomManager.getUser(userId);
            if (userInfo != null) {
                uiBean.setSinsatyuuisetnm(userInfo.getUserNm());
            }
            uiBean.setSosikinm(sinsaTyuui.getSosikinm());
            uiBean.setSinsatyuui(sinsaTyuui.getSinsatyuui());
        }
        else {
            BzGetSousasyaSyozokuSosikiData bzGetSousasyaSyozokuSosikiData = SWAKInjector.getInstance(
                BzGetSousasyaSyozokuSosikiData.class);
            BzGetSousasyaSyozokuSosikiDataBean bzGetSousasyaSyozokuSosikiDataBean = bzGetSousasyaSyozokuSosikiData.exec(
                baseUserInfo.getUserId());
            if (bzGetSousasyaSyozokuSosikiDataBean != null) {
                uiBean.setSosikinm(bzGetSousasyaSyozokuSosikiDataBean.getKanjisosikinm20());
            }
            uiBean.setSinsatyuuisetnm(baseUserInfo.getUserNm());
        }
        uiBean.setSinsatyuuisetkbn(C_SetteiKbn.SETTEI);

        uiBean.setSinsaTyuui(sinsaTyuui);

        if (!C_YuukousyoumetuKbn.YUUKOU.eq(siKykKihonLst.get(0).getYuukousyoumetukbn())) {
            messageManager.addConversationMessageId(INPUT_WARNINF, MessageId.WJA0024);
        }

        return FORWARDNAME_INPUTCONTENTS;
    }

    String modoruBtnByInputContentsOnClickBL() {

        messageManager.removeConversationMessage(INPUT_WARNINF);
        return FORWARDNAME_INIT;
    }

    String kakuninBtnOnClickBL() {

        if (C_SetteiKbn.SETTEI.eq(uiBean.getSinsatyuuisetkbn()) && BizUtil.isBlank(uiBean.getSinsatyuui())) {
            throw new BizLogicException(MessageId.EBC0043, MessageUtil.getMessage(DDID_SINSATYUUIINFO_SINSATYUUI.getErrorResourceKey()));
        }

        if (C_SetteiKbn.KAIJO.eq(uiBean.getSinsatyuuisetkbn()) && uiBean.getSinsaTyuui() == null) {
            throw new BizLogicException(MessageId.EJA1002);
        }

        if (C_SetteiKbn.SETTEI.eq(uiBean.getSinsatyuuisetkbn()) && uiBean.getSinsaTyuui() != null) {
            BzGetSousasyaSyozokuSosikiData bzGetSousasyaSyozokuSosikiData = SWAKInjector.getInstance(
                BzGetSousasyaSyozokuSosikiData.class);
            BzGetSousasyaSyozokuSosikiDataBean bzGetSousasyaSyozokuSosikiDataBean = bzGetSousasyaSyozokuSosikiData.exec(
                baseUserInfo.getUserId());
            if (bzGetSousasyaSyozokuSosikiDataBean == null) {
                uiBean.setSosikinm("");
            }
            else {
                uiBean.setSosikinm(bzGetSousasyaSyozokuSosikiDataBean.getKanjisosikinm20());
            }
            uiBean.setSinsatyuuisetnm(baseUserInfo.getUserNm());
        }

        messageManager.addMessageId(MessageId.QBA0001);

        return FORWARDNAME_CONFIRM;
    }

    String modoruBtnByConfirmOnClickBL() {

        if (uiBean.getSinsaTyuui() != null) {
            String userId = uiBean.getSinsaTyuui().getGyoumuKousinsyaId();
            AM_User userInfo = baseDomManager.getUser(userId);
            if (userInfo == null) {
                uiBean.setSinsatyuuisetnm("");
            }
            else {
                uiBean.setSinsatyuuisetnm(userInfo.getUserNm());
            }
            uiBean.setSosikinm(uiBean.getSinsaTyuui().getSosikinm());
        }

        return FORWARDNAME_INPUTCONTENTS;
    }

    @Transactional
    String kakuteiBtnOnClickBL() {

        if (C_SetteiKbn.SETTEI.eq(uiBean.getSinsatyuuisetkbn())) {
            if (uiBean.getSinsaTyuui() == null) {
                JT_SinsaTyuui sinsaTyuui = new JT_SinsaTyuui();
                setSinsaTyuui(sinsaTyuui);
                BizPropertyInitializer.initialize(sinsaTyuui);
                siharaiDomManager.insert(sinsaTyuui);
            }
            else {
                setSinsaTyuui(uiBean.getSinsaTyuui());
                siharaiDomManager.update(uiBean.getSinsaTyuui());
            }
        }
        else {
            siharaiDomManager.delete(uiBean.getSinsaTyuui());
        }

        messageManager.addMessageId(MessageId.IAC0009);

        return FORWARDNAME_RESULT;
    }

    private void setSinsaTyuui(JT_SinsaTyuui pSinsaTyuui) {

        pSinsaTyuui.setSyono(uiBean.getSyono());
        pSinsaTyuui.setSinsatyuui(uiBean.getSinsatyuui());
        pSinsaTyuui.setSosikinm(uiBean.getSosikinm());
        pSinsaTyuui.setKossyoricd(kinou.getKinouId());
        pSinsaTyuui.setKossyorisscd(kinouMode.getKinouMode());
        pSinsaTyuui.setGyoumuKousinsyaId(baseUserInfo.getUserId());
        pSinsaTyuui.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());
    }
}
