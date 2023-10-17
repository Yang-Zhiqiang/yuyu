package yuyu.app.sinkeiyaku.skmaster.skdairitenkobetujyouhoutouroku;

import static yuyu.app.sinkeiyaku.skmaster.skdairitenkobetujyouhoutouroku.GenSkDairitenKobetuJyouhouTourokuConstants.*;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.bizinfr.exception.BizLogicException;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.util.message.MessageUtil;
import jp.co.slcs.swak.web.message.MessageManager;

import org.slf4j.Logger;

import yuyu.app.sinkeiyaku.skmaster.skdairitenkobetujyouhoutouroku.SkDairitenKobetuJyouhouTourokuConstants.E_SyoriKbn;
import yuyu.common.base.BaseUserInfo;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bzdairiten.BzChkAgYuukou;
import yuyu.common.biz.bzdairiten.BzGetAgInfo;
import yuyu.common.biz.bzdairiten.BzGetAgInfoBean;
import yuyu.common.sinkeiyaku.skcommon.GetSkChannelInfo;
import yuyu.def.MessageId;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_DiritenjyouhouKbn;
import yuyu.def.classification.C_DrtenRnrkhouKbn;
import yuyu.def.classification.C_SkeijimuKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.classification.C_YouhiblnkKbn;
import yuyu.def.db.entity.BM_Dairiten;
import yuyu.def.db.entity.HM_SkDairitenKobetuJyouhou;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;

/**
 * 代理店個別情報登録 のビジネスロジックです。
 */
public class SkDairitenKobetuJyouhouTourokuBizLogic {

    @SuppressWarnings("unused")
    @Inject
    private static Logger logger;

    @Inject
    private SkDairitenKobetuJyouhouTourokuUiBean uiBean;

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @Inject
    private BizDomManager bizDomManager;

    @Inject
    private BaseUserInfo baseUserInfo;

    @Inject
    private MessageManager messageManager;

    void init() {
    }

    void clear() {
    }

    void pushAddBL() {

        BizPropertyInitializer.initialize(uiBean);

        String oyadrtencd = uiBean.getDrtencd();
        String kinyuucd = uiBean.getBankcd();
        String drtencd = null;
        List<BzGetAgInfoBean> bzGetAgInfoBeanList = null;
        BzGetAgInfoBean bzGetAgInfoBean = null;
        HM_SkDairitenKobetuJyouhou skDairitenKobetuJyouhou = null;
        BM_Dairiten dairiten = null;

        checkForInputKey(oyadrtencd, kinyuucd);

        if (!BizUtil.isBlank(oyadrtencd)) {
            checkForDairiten(oyadrtencd);
            bzGetAgInfoBeanList = getDairitenInfo();
            if (bzGetAgInfoBeanList.size() == 0) {
                throw new BizLogicException(MessageId.EBA0030, "代理店情報");
            }
            for (BzGetAgInfoBean roopBzGetAgInfoBean : bzGetAgInfoBeanList) {
                if (C_DiritenjyouhouKbn.SHITEIOYA.eq(roopBzGetAgInfoBean.getDiritenJyouhouKbn())) {
                    if (!oyadrtencd.equals(roopBzGetAgInfoBean.getOyadrtenCd())) {
                        throw new BizLogicException(MessageId.EBA0030, "代理店情報");
                    }
                    else {
                        bzGetAgInfoBean = roopBzGetAgInfoBean;
                        break;
                    }
                }
            }

            skDairitenKobetuJyouhou = sinkeiyakuDomManager.getSkDairitenKobetuJyouhou(oyadrtencd);
        }
        else if (!BizUtil.isBlank(kinyuucd)) {
            dairiten = getDairiten().get(0);
            drtencd = dairiten.getOyadrtencd();

            skDairitenKobetuJyouhou = sinkeiyakuDomManager.getSkDairitenKobetuJyouhou(drtencd);
        }

        if (skDairitenKobetuJyouhou != null) {
            throw new BizLogicException(MessageId.EBA1030, "代理店個別情報");
        }

        if (bzGetAgInfoBean != null) {
            uiBean.setDrtencd(bzGetAgInfoBean.getOyadrtenCd());
            uiBean.setBankcd(bzGetAgInfoBean.getKinyuuCd());
            uiBean.setOyadrtennm(bzGetAgInfoBean.getKanjiDairitenNm());
        }
        else if (dairiten != null) {
            uiBean.setDrtencd(dairiten.getOyadrtencd());
            uiBean.setBankcd(dairiten.getKinyuucd());
            uiBean.setOyadrtennm(dairiten.getKanjidairitennm());
        }

        uiBean.setGamenSyoriKbn(E_SyoriKbn.NEW);
    }

    void pushUpdBL() {

        BizPropertyInitializer.initialize(uiBean);

        doUpdDel();

        uiBean.setGamenSyoriKbn(E_SyoriKbn.UPD);
    }

    void pushDelBL() {

        BizPropertyInitializer.initialize(uiBean);

        doUpdDel();

        uiBean.setGamenSyoriKbn(E_SyoriKbn.DEL);

        messageManager.addMessageId(MessageId.QAC0010);
    }

    void pushKakuninBL() {

        if (C_DrtenRnrkhouKbn.NIT.eq(uiBean.getDrtenRnrkhouKbn())) {
            GetSkChannelInfo getSkChannelInfo = SWAKInjector.getInstance(GetSkChannelInfo.class);
            getSkChannelInfo.exec(null, uiBean.getDrtencd());

            if (C_SkeijimuKbn.SHOP.eq(getSkChannelInfo.getSkeiJimuKbn())) {
                throw new BizLogicException(MessageId.EHA1103, C_DrtenRnrkhouKbn.NIT.getContent());
            }
        }

        if (C_YouhiKbn.YOU.eq(uiBean.getCifcdcheckyouhi())) {
            if (BizUtil.isBlank(uiBean.getCifcdsiteiketasuu())) {
                throw new BizLogicException(MessageId.EBC0045,
                    MessageUtil.getMessage(DDID_CIFCDINFO_CIFCDSITEIKETASUU.getErrorResourceKey()));
            }

            if (!(Integer.parseInt(uiBean.getCifcdsiteiketasuu()) >= 1 &&
                Integer.parseInt(uiBean.getCifcdsiteiketasuu()) <= 15)) {
                throw new BizLogicException(MessageId.EHA1054,
                    MessageUtil.getMessage(DDID_CIFCDINFO_CIFCDSITEIKETASUU.getErrorResourceKey()), "1", "15");
            }
        }
        else {
            if (!BizUtil.isBlank(uiBean.getCifcdsiteiketasuu())) {
                throw new BizLogicException(MessageId.EBA0108,
                    MessageUtil.getMessage(DDID_CIFCDINFO_CIFCDSITEIKETASUU.getErrorResourceKey()));
            }

            if (C_YouhiblnkKbn.YOU.eq(uiBean.getCifcdmaezeroumeyouhi())) {
                throw new BizLogicException(MessageId.EBA0108,
                    MessageUtil.getMessage(DDID_CIFCDINFO_CIFCDMAEZEROUMEYOUHI.getErrorResourceKey()));
            }
        }

        if (!BizUtil.isBlank(uiBean.getCifcdsiteiketasuu())) {
            uiBean.setCifcdsiteiketasuu(String.valueOf(Integer.parseInt(uiBean.getCifcdsiteiketasuu())));
        }

        E_SyoriKbn gamenSyoriKbn = uiBean.getGamenSyoriKbn();

        if (E_SyoriKbn.NEW.equals(gamenSyoriKbn)) {
            messageManager.addMessageId(MessageId.QAC0008);
        }
        else {
            messageManager.addMessageId(MessageId.QAC0009);
        }
    }

    @Transactional
    void pushKakuteiBL() {

        E_SyoriKbn gamenSyoriKbn = uiBean.getGamenSyoriKbn();

        if (E_SyoriKbn.NEW.equals(gamenSyoriKbn)) {
            doInsertTable();
        }
        else if (E_SyoriKbn.UPD.equals(gamenSyoriKbn)) {
            doUpdateTable();
        }
        else {
            doDeleteTable();
        }

        messageManager.addMessageId(MessageId.IAC0009);
    }

    private void checkForInputKey(String oyadrtencd, String kinyuucd) {

        if (BizUtil.isBlank(oyadrtencd) && BizUtil.isBlank(kinyuucd)) {
            throw new BizLogicException(MessageId.EBA0027, "親代理店コードまたは金融機関コード");
        }

        if (!BizUtil.isBlank(oyadrtencd) && !BizUtil.isBlank(kinyuucd)) {
            throw new BizLogicException(MessageId.EHA1031, "親代理店コードと金融機関コード");
        }
    }

    private void checkForDairiten(String drtencd) {

        BzChkAgYuukou bzChkAgYuukou = SWAKInjector.getInstance(BzChkAgYuukou.class);
        Boolean checkresult = bzChkAgYuukou.exec(drtencd, BizDate.getSysDate());
        if (!checkresult) {
            throw new BizLogicException(MessageId.EBA0030, "代理店情報");
        }
    }

    private List<BzGetAgInfoBean> getDairitenInfo() {

        String oyadrtencd = uiBean.getDrtencd();
        List<BzGetAgInfoBean> bzGetAgInfoBeanList = null;

        BzGetAgInfo bzGetAgInfo = SWAKInjector.getInstance(BzGetAgInfo.class);
        bzGetAgInfoBeanList = bzGetAgInfo.exec(oyadrtencd);

        return bzGetAgInfoBeanList;
    }

    private List<BM_Dairiten> getDairiten() {
        String kinyuucd = uiBean.getBankcd();
        List<BM_Dairiten> dairitenLst = null;

        dairitenLst = bizDomManager.getDairitensByKinyuucd(kinyuucd);
        if (dairitenLst.size() == 0) {
            throw new BizLogicException(MessageId.EBA0030, "代理店情報");
        }

        return dairitenLst;
    }

    private void doUpdDel() {

        String oyadrtencd = uiBean.getDrtencd();
        String kinyuucd = uiBean.getBankcd();
        String drtencd = null;
        List<BzGetAgInfoBean> bzGetAgInfoBeanList = null;
        HM_SkDairitenKobetuJyouhou skDairitenKobetuJyouhou = null;
        BM_Dairiten dairiten = null;

        checkForInputKey(oyadrtencd, kinyuucd);

        if (!BizUtil.isBlank(oyadrtencd)) {
            skDairitenKobetuJyouhou = sinkeiyakuDomManager.getSkDairitenKobetuJyouhou(oyadrtencd);
            if (skDairitenKobetuJyouhou == null) {
                throw new BizLogicException(MessageId.EBA0030, "代理店個別情報");
            }
            bzGetAgInfoBeanList = getDairitenInfo();

        }
        else {
            dairiten = getDairiten().get(0);
            drtencd = dairiten.getOyadrtencd();

            skDairitenKobetuJyouhou = sinkeiyakuDomManager.getSkDairitenKobetuJyouhou(drtencd);
            if (skDairitenKobetuJyouhou == null) {
                throw new BizLogicException(MessageId.EBA0030, "代理店個別情報");
            }

        }

        uiBean.setDrtencd(skDairitenKobetuJyouhou.getOyadrtencd());
        uiBean.setDrtenRnrkhouKbn(skDairitenKobetuJyouhou.getDrtenRnrkhouKbn());
        uiBean.setUtdskknnm1kj(skDairitenKobetuJyouhou.getUtdskknnm1kj());
        uiBean.setUtdskknnm2kj(skDairitenKobetuJyouhou.getUtdskknnm2kj());
        uiBean.setNykntratkikbn(skDairitenKobetuJyouhou.getNykntratkikbn());
        uiBean.setTrksskssouhukbn(skDairitenKobetuJyouhou.getTrksskssouhukbn());
        uiBean.setTkhjnkinyuucd(skDairitenKobetuJyouhou.getTkhjnkinyuucd());
        uiBean.setCifcdcheckyouhi(skDairitenKobetuJyouhou.getCifcdcheckyouhi());
        uiBean.setCifcdsiteiketasuu(skDairitenKobetuJyouhou.getCifcdsiteiketasuu());
        uiBean.setCifcdmaezeroumeyouhi(skDairitenKobetuJyouhou.getCifcdmaezeroumeyouhi());
        uiBean.setSkDairitenKobetuJyouhou(skDairitenKobetuJyouhou);

        if (bzGetAgInfoBeanList != null) {
            for (BzGetAgInfoBean bzGetAgInfoBean : bzGetAgInfoBeanList) {
                if (C_DiritenjyouhouKbn.SHITEIOYA.eq(bzGetAgInfoBean.getDiritenJyouhouKbn())) {
                    uiBean.setBankcd(bzGetAgInfoBean.getKinyuuCd());
                    uiBean.setOyadrtennm(bzGetAgInfoBean.getKanjiDairitenNm());
                }
            }
        }
        else {
            uiBean.setBankcd(dairiten.getKinyuucd());
            uiBean.setOyadrtennm(dairiten.getKanjidairitennm());
        }
    }

    private void doInsertTable() {

        String sousasyacd = baseUserInfo.getUserId();
        BizDate sysDate = BizDate.getSysDate();
        String kostime = BizDate.getSysDateTimeMilli();
        HM_SkDairitenKobetuJyouhou skDairitenKobetuJyouhou = setDairitenKobetuJyouhou(sysDate);

        setSystemKoumoku(skDairitenKobetuJyouhou, sousasyacd, kostime);

        BizPropertyInitializer.initialize(skDairitenKobetuJyouhou);

        sinkeiyakuDomManager.insert(skDairitenKobetuJyouhou);
    }

    private void doUpdateTable() {

        String sousasyacd = baseUserInfo.getUserId();
        BizDate sysDate = BizDate.getSysDate();
        String kostime = BizDate.getSysDateTimeMilli();
        HM_SkDairitenKobetuJyouhou skDairitenKobetuJyouhou = setDairitenKobetuJyouhou(sysDate);

        setSystemKoumoku(skDairitenKobetuJyouhou, sousasyacd, kostime);

        sinkeiyakuDomManager.update(skDairitenKobetuJyouhou);
    }

    private void doDeleteTable() {

        HM_SkDairitenKobetuJyouhou skDairitenKobetuJyouhou = uiBean.getSkDairitenKobetuJyouhou();

        sinkeiyakuDomManager.delete(skDairitenKobetuJyouhou);
    }

    private HM_SkDairitenKobetuJyouhou setDairitenKobetuJyouhou(BizDate sysDate) {

        HM_SkDairitenKobetuJyouhou skDairitenKobetuJyouhou = null;
        E_SyoriKbn gamenSyoriKbn = uiBean.getGamenSyoriKbn();

        if (E_SyoriKbn.NEW.equals(gamenSyoriKbn)) {
            skDairitenKobetuJyouhou = new HM_SkDairitenKobetuJyouhou();
        }
        else {
            skDairitenKobetuJyouhou = uiBean.getSkDairitenKobetuJyouhou();
        }

        skDairitenKobetuJyouhou.setOyadrtencd(uiBean.getDrtencd());
        skDairitenKobetuJyouhou.setDrtenRnrkhouKbn(uiBean.getDrtenRnrkhouKbn());
        skDairitenKobetuJyouhou.setUtdskknnm1kj(uiBean.getUtdskknnm1kj());
        skDairitenKobetuJyouhou.setUtdskknnm2kj(uiBean.getUtdskknnm2kj());
        skDairitenKobetuJyouhou.setNykntratkikbn(uiBean.getNykntratkikbn());
        skDairitenKobetuJyouhou.setTrksskssouhukbn(uiBean.getTrksskssouhukbn());
        skDairitenKobetuJyouhou.setTkhjnkinyuucd(uiBean.getTkhjnkinyuucd());
        skDairitenKobetuJyouhou.setCifcdcheckyouhi(uiBean.getCifcdcheckyouhi());
        skDairitenKobetuJyouhou.setCifcdsiteiketasuu(uiBean.getCifcdsiteiketasuu());
        skDairitenKobetuJyouhou.setCifcdmaezeroumeyouhi(uiBean.getCifcdmaezeroumeyouhi());
        skDairitenKobetuJyouhou.setKosymd(sysDate);

        return skDairitenKobetuJyouhou;
    }

    private void setSystemKoumoku(HM_SkDairitenKobetuJyouhou skDairitenKobetuJyouhou, String sousasyacd, String systime) {

        skDairitenKobetuJyouhou.setGyoumuKousinsyaId(sousasyacd);
        skDairitenKobetuJyouhou.setGyoumuKousinTime(systime);
    }
}
