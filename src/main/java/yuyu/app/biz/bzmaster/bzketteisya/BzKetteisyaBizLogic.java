package yuyu.app.biz.bzmaster.bzketteisya;

import static yuyu.app.biz.bzmaster.bzketteisya.GenBzKetteisyaConstants.*;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.bizinfr.exception.BizLogicException;
import jp.co.slcs.swak.bizinfr.exception.ErrorMessageCollector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.util.message.MessageUtil;
import jp.co.slcs.swak.web.message.MessageManager;

import org.slf4j.Logger;

import yuyu.app.biz.bzmaster.bzketteisya.BzKetteisyaConstants.E_SyoriKbn;
import yuyu.common.base.BaseUserInfo;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.sinkeiyaku.skcommon.ISkCommonKoumoku;
import yuyu.def.MessageId;
import yuyu.def.classification.C_ImusateirankKbn;
import yuyu.def.classification.C_KnksateirankKbn;
import yuyu.def.classification.C_MostenkenRankKbn;
import yuyu.def.db.entity.HM_KetteiSya;
import yuyu.def.db.entity.HT_DakuhiKettei;
import yuyu.def.db.entity.HT_Tokunin;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;

/**
 * 決定者登録 のビジネスロジックです。
 */
public class BzKetteisyaBizLogic {

    @SuppressWarnings("unused")
    @Inject
    private static Logger logger;

    @Inject
    private BzKetteisyaUiBean uiBean;

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @Inject
    private MessageManager messageManager;

    @Inject
    private BaseUserInfo baseUserInfo;

    @Inject
    private ErrorMessageCollector errMessages;

    void init() {
    }

    void clear() {
    }

    void pushAddBL() {
        BizPropertyInitializer.initialize(uiBean);

        String ketteisyaCd = null;
        HM_KetteiSya ketteiSya = null;

        ketteisyaCd = uiBean.getKetsyacd();

        ketteiSya = sinkeiyakuDomManager.getKetteiSya(ketteisyaCd);

        if (ketteiSya != null) {
            throw new BizLogicException(MessageId.EHA0041,
                MessageUtil.getMessage(DDID_KEYINFO_KETSYACD.getErrorResourceKey()));

        }
        uiBean.setKnksateijygns(BizCurrency.optional());
        uiBean.setImusateijygns(BizCurrency.optional());
        uiBean.setGmsyorikbn(E_SyoriKbn.NEW);
    }

    void pushUpdBL() {
        BizPropertyInitializer.initialize(uiBean);
        doUpd();
        uiBean.setGmsyorikbn(E_SyoriKbn.UPD);
    }

    void pushDelBL() {
        BizPropertyInitializer.initialize(uiBean);
        doDel();
        uiBean.setGmsyorikbn(E_SyoriKbn.DEL);
        messageManager.addMessageId(MessageId.QAC0010);

    }

    void pushKakuninBL() {
        checkZero();

        if (C_KnksateirankKbn.NONE.eq(uiBean.getKnksateirankkbn()) &&
            !uiBean.getKnksateijygns().isOptional() &&
            uiBean.getKnksateijygns().compareTo(BizCurrency.valueOf(0)) > 0) {
            throw new BizLogicException(MessageId.EHA1020,
                MessageUtil.getMessage(DDID_KETTEISYAINFO_KNKSATEIRANKKBN.getErrorResourceKey()),
                MessageUtil.getMessage(DDID_KETTEISYAINFO_KNKSATEIJYGNS.getErrorResourceKey()));
        }

        if (C_ImusateirankKbn.NONE.eq(uiBean.getImusateirankkbn()) &&
            !uiBean.getImusateijygns().isOptional() &&
            uiBean.getImusateijygns().compareTo(BizCurrency.valueOf(0)) > 0) {
            throw new BizLogicException(MessageId.EHA1020,
                MessageUtil.getMessage(DDID_KETTEISYAINFO_IMUSATEIRANKKBN.getErrorResourceKey()),
                MessageUtil.getMessage(DDID_KETTEISYAINFO_IMUSATEIJYGNS.getErrorResourceKey()));
        }

        if (!C_KnksateirankKbn.NONE.eq(uiBean.getKnksateirankkbn()) &&
            uiBean.getKnksateijygns().isOptional()) {
            throw new BizLogicException(MessageId.EBC0043,
                MessageUtil.getMessage(DDID_KETTEISYAINFO_KNKSATEIJYGNS.getErrorResourceKey()));
        }

        if (!C_ImusateirankKbn.NONE.eq(uiBean.getImusateirankkbn()) &&
            uiBean.getImusateijygns().isOptional()) {
            throw new BizLogicException(MessageId.EBC0043,
                MessageUtil.getMessage(DDID_KETTEISYAINFO_IMUSATEIJYGNS.getErrorResourceKey()));
        }

        if (C_ImusateirankKbn.NONE.eq(uiBean.getImusateirankkbn()) &&
            C_KnksateirankKbn.NONE.eq(uiBean.getKnksateirankkbn()) &&
            !BizUtil.isBlank(uiBean.getPalketsyacd())) {
            throw new BizLogicException(MessageId.EBC0007,
                MessageUtil.getMessage(DDID_KEYINFO_PALKETSYACD.getErrorResourceKey()));
        }

        if (BizUtil.isBlank(uiBean.getPalketsyacd()) &&
            (C_ImusateirankKbn.KANI_UW.eq(uiBean.getImusateirankkbn()) ||
                C_ImusateirankKbn.KANI_MD.eq(uiBean.getImusateirankkbn()) ||
                C_KnksateirankKbn.NIJIA.eq(uiBean.getKnksateirankkbn()) ||
                C_KnksateirankKbn.NIJIB.eq(uiBean.getKnksateirankkbn()))) {
            throw new BizLogicException(MessageId.EBC0043,
                MessageUtil.getMessage(DDID_KEYINFO_PALKETSYACD.getErrorResourceKey()));
        }

        if (!BizUtil.isBlank(uiBean.getPalketsyacd()) &&
            !(uiBean.getPalketsyacd().compareTo("01") >= 0 &&
            uiBean.getPalketsyacd().compareTo(ISkCommonKoumoku.PALKETSYACD_SISYAKETSYA) <= 0)) {
            throw new BizLogicException(MessageId.EHA1054,
                MessageUtil.getMessage(DDID_KEYINFO_PALKETSYACD.getErrorResourceKey()),
                MessageUtil.getMessage("01"),
                MessageUtil.getMessage(ISkCommonKoumoku.PALKETSYACD_SISYAKETSYA));
        }

        E_SyoriKbn syoriKbn = uiBean.getGmsyorikbn();

        if (syoriKbn == E_SyoriKbn.NEW) {
            messageManager.addMessageId(MessageId.QAC0008);
        }
        else if (syoriKbn == E_SyoriKbn.UPD) {
            messageManager.addMessageId(MessageId.QAC0009);
        }
    }

    @Transactional
    void pushkakuteiBL() {

        E_SyoriKbn syoriKbn = uiBean.getGmsyorikbn();

        if  (syoriKbn == E_SyoriKbn.NEW) {
            doInsertTable();
        }
        else if (syoriKbn == E_SyoriKbn.UPD) {
            doUpdateTable();
        }
        else if (syoriKbn == E_SyoriKbn.DEL)  {
            doDeleteTable();
        }

        messageManager.addMessageId(MessageId.IAC0009);
    }


    private void doUpd() {

        String ketteisyaCd = null;
        HM_KetteiSya ketteiSya = null;

        ketteisyaCd = uiBean.getKetsyacd();

        ketteiSya = sinkeiyakuDomManager.getKetteiSya(ketteisyaCd);

        if (ketteiSya == null) {
            throw new BizLogicException(MessageId.EBA0030,
                MessageUtil.getMessage(DDID_KEYINFO_KETSYACD.getErrorResourceKey()));
        }
        uiBean.setKetteiSya(ketteiSya);

        uiBean.setPalketsyacd(ketteiSya.getPalketsyacd());
        uiBean.setKetsyanm(ketteiSya.getKetsyanm());
        uiBean.setMostenkenrankkbn(ketteiSya.getMostenkenrankkbn());
        uiBean.setKnksateirankkbn(ketteiSya.getKnksateirankkbn());

        if (ketteiSya.getKnksateijygns().equalsValue(BizCurrency.valueOf(0))) {
            uiBean.setKnksateijygns(BizCurrency.optional());
        }
        else {
            uiBean.setKnksateijygns(ketteiSya.getKnksateijygns());
        }

        uiBean.setImusateirankkbn(ketteiSya.getImusateirankkbn());

        if (ketteiSya.getImusateijygns().equalsValue(BizCurrency.valueOf(0))) {
            uiBean.setImusateijygns(BizCurrency.optional());
        }
        else {
            uiBean.setImusateijygns(ketteiSya.getImusateijygns());
        }

    }

    private void doDel() {

        String ketteisyaCd = null;
        HM_KetteiSya ketteiSya = null;
        List<HT_DakuhiKettei> dakuhiKetteiLst = null;
        List<HT_Tokunin> tokuninLst = null;
        long mostenkenRrkCnt;
        long knksateiRrkCnt;
        long imusateiRrkCnt;

        ketteisyaCd = uiBean.getKetsyacd();

        ketteiSya = sinkeiyakuDomManager.getKetteiSya(ketteisyaCd);

        dakuhiKetteiLst = sinkeiyakuDomManager.getDakuhiKetteisByKetsyacd(ketteisyaCd);

        tokuninLst = sinkeiyakuDomManager.getTokuninsByKetsyacd(ketteisyaCd);

        mostenkenRrkCnt = sinkeiyakuDomManager.getMostenkenRirekiCountByKetsyacdTnsketsyacd(ketteisyaCd);

        knksateiRrkCnt = sinkeiyakuDomManager.getKnksateiRirekiCountByKetsyacdTnsketsyacd(ketteisyaCd);

        imusateiRrkCnt = sinkeiyakuDomManager.getImusateiRirekiCountByKetsyacdTnsketsyacd(ketteisyaCd);

        if (ketteiSya == null) {
            throw new BizLogicException(MessageId.EBA0030,
                MessageUtil.getMessage(DDID_KEYINFO_KETSYACD.getErrorResourceKey()));
        }
        else if (dakuhiKetteiLst.size() > 0) {
            throw new BizLogicException(MessageId.EHA0099,
                MessageUtil.getMessage(DDID_KEYINFO_KETSYACD.getErrorResourceKey()));
        }
        else if (tokuninLst.size() > 0) {
            throw new BizLogicException(MessageId.EHA0100,
                MessageUtil.getMessage(DDID_KEYINFO_KETSYACD.getErrorResourceKey()));
        }
        else if (mostenkenRrkCnt > 0) {
            throw new BizLogicException(MessageId.EHA1023,
                MessageUtil.getMessage(DDID_KEYINFO_KETSYACD.getErrorResourceKey()));
        }
        else if (knksateiRrkCnt > 0) {
            throw new BizLogicException(MessageId.EHA0317,
                MessageUtil.getMessage(DDID_KEYINFO_KETSYACD.getErrorResourceKey()));
        }
        else if (imusateiRrkCnt > 0) {
            throw new BizLogicException(MessageId.EHA0317,
                MessageUtil.getMessage(DDID_KEYINFO_KETSYACD.getErrorResourceKey()));
        }
        else {

            uiBean.setPalketsyacd(ketteiSya.getPalketsyacd());
            uiBean.setKetsyanm(ketteiSya.getKetsyanm());
            uiBean.setMostenkenrankkbn(ketteiSya.getMostenkenrankkbn());
            uiBean.setImusateirankkbn(ketteiSya.getImusateirankkbn());

            if (ketteiSya.getImusateijygns().equalsValue(BizCurrency.valueOf(0))) {
                uiBean.setImusateijygns(BizCurrency.optional());
            }
            else {
                uiBean.setImusateijygns(ketteiSya.getImusateijygns());
            }

            uiBean.setKnksateirankkbn(ketteiSya.getKnksateirankkbn());

            if (ketteiSya.getKnksateijygns().equalsValue(BizCurrency.valueOf(0))) {
                uiBean.setKnksateijygns(BizCurrency.optional());
            }
            else {
                uiBean.setKnksateijygns(ketteiSya.getKnksateijygns());
            }

            uiBean.setKetteiSya(ketteiSya);
        }
    }

    private void doInsertTable() {
        String userID = null;
        String kostime = null;
        HM_KetteiSya ketteiSya = null;

        userID = baseUserInfo.getUserId();
        kostime = BizDate.getSysDateTimeMilli();

        ketteiSya = setKetteiSya();
        setSystemKoumoku(ketteiSya, userID, kostime);
        BizPropertyInitializer.initialize(ketteiSya);
        sinkeiyakuDomManager.insert(ketteiSya);
    }

    private void doUpdateTable() {
        String userID = null;
        String kostime = null;
        HM_KetteiSya ketteiSya = null;

        userID = baseUserInfo.getUserId();
        kostime = BizDate.getSysDateTimeMilli();

        ketteiSya = setKetteiSya();
        setSystemKoumoku(ketteiSya, userID, kostime);

        sinkeiyakuDomManager.update(ketteiSya);
    }

    private void doDeleteTable() {
        HM_KetteiSya ketteiSya = uiBean.getKetteiSya();

        sinkeiyakuDomManager.delete(ketteiSya);
    }

    private void setSystemKoumoku(HM_KetteiSya pKetteiSya, String pUserID, String pSysDate) {
        pKetteiSya.setGyoumuKousinsyaId(pUserID);
        pKetteiSya.setGyoumuKousinTime(pSysDate);
    }

    private HM_KetteiSya setKetteiSya() {

        HM_KetteiSya ketteiSya = null;
        String palketsyaCd = null;

        E_SyoriKbn syoriKbn = uiBean.getGmsyorikbn();

        if (syoriKbn == E_SyoriKbn.NEW) {
            ketteiSya = new HM_KetteiSya();
        }
        else {

            ketteiSya = uiBean.getKetteiSya();
        }

        palketsyaCd = uiBean.getPalketsyacd();
        if (BizUtil.isBlank(uiBean.getPalketsyacd()) &&
            !C_MostenkenRankKbn.NONE.eq(uiBean.getMostenkenrankkbn())) {
            if (syoriKbn == E_SyoriKbn.NEW || syoriKbn == E_SyoriKbn.UPD) {
                palketsyaCd = ISkCommonKoumoku.PALKETSYACD_SISYAKETSYA;
            }
        }

        ketteiSya.setKetsyacd(uiBean.getKetsyacd());
        ketteiSya.setPalketsyacd(palketsyaCd);
        ketteiSya.setKetsyanm(uiBean.getKetsyanm());
        ketteiSya.setMostenkenrankkbn(uiBean.getMostenkenrankkbn());
        ketteiSya.setKnksateirankkbn(uiBean.getKnksateirankkbn());
        ketteiSya.setKnksateijygns(uiBean.getKnksateijygns());
        ketteiSya.setImusateirankkbn(uiBean.getImusateirankkbn());
        ketteiSya.setImusateijygns(uiBean.getImusateijygns());
        return ketteiSya;
    }

    private void checkZero() {

        if (BizUtil.isZero(uiBean.getKnksateijygns())) {
            errMessages.addMessage(MessageId.EAV0019, DDID_KETTEISYAINFO_KNKSATEIJYGNS);
        }

        if (errMessages.exists()) {
            throw new BizLogicException(errMessages);
        }

        if (BizUtil.isZero(uiBean.getImusateijygns())) {
            errMessages.addMessage(MessageId.EAV0019, DDID_KETTEISYAINFO_IMUSATEIJYGNS);
        }

        if (errMessages.exists()) {
            throw new BizLogicException(errMessages);
        }
    }
}
