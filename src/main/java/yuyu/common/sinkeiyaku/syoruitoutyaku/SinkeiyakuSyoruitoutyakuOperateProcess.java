package yuyu.common.sinkeiyaku.syoruitoutyaku;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;

import jp.co.slcs.swak.bizinfr.exception.BizLogicException;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.common.biz.koutei.BzGetProcessSummary;
import yuyu.common.biz.koutei.BzGetProcessSummaryInBean;
import yuyu.common.biz.koutei.BzGetProcessSummaryOutBean;
import yuyu.common.biz.koutei.BzLockProcess;
import yuyu.common.biz.koutei.BzLockProcessOutBean;
import yuyu.common.biz.koutei.BzProcessForward;
import yuyu.common.biz.koutei.BzProcessForwardInBean;
import yuyu.common.biz.koutei.BzUnlockProcess;
import yuyu.common.biz.syoruitoutyaku.SyoruitoutyakuOperateProcess;
import yuyu.common.sinkeiyaku.koutei.SkHenkinRuleBean;
import yuyu.common.sinkeiyaku.koutei.SkHubiKaisyouRuleBean;
import yuyu.common.sinkeiyaku.koutei.SkInputKokutiRuleBean;
import yuyu.common.sinkeiyaku.koutei.SkInputMosRuleBean;
import yuyu.common.sinkeiyaku.koutei.SkKeiyakukakuninRuleBean;
import yuyu.common.sinkeiyaku.koutei.SkMainDairitenRuleBean;
import yuyu.common.sinkeiyaku.koutei.SkProcessCreate;
import yuyu.common.sinkeiyaku.koutei.SkProcessCreateInBean;
import yuyu.common.sinkeiyaku.koutei.SkTorikesiRuleBean;
import yuyu.common.sinkeiyaku.skcommon.ISkCommonKoumoku;
import yuyu.def.MessageId;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_HubikaisyoujoutaiKbn;
import yuyu.def.classification.C_KetteiKbn;
import yuyu.def.classification.C_KouteiLockKekkaKbn;
import yuyu.def.classification.C_Kouteikanristatus;
import yuyu.def.classification.C_KykkakjkKbn;
import yuyu.def.classification.C_MosUketukeKbn;
import yuyu.def.classification.C_MostenkenjyouKbn;
import yuyu.def.classification.C_SateijtKbn;
import yuyu.def.classification.C_SeirituKbn;
import yuyu.def.classification.C_SkkouteikanryouKbn;
import yuyu.def.classification.C_SntkhouKbn;
import yuyu.def.classification.C_SyorikekkaKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_VrfjkKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.db.entity.BT_GyoumuKouteiInfo;
import yuyu.def.db.entity.HT_Henkin;
import yuyu.def.db.entity.HT_MosKihon;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;

/**
 * 新契約 書類到着 新契約書類到着時工程操作処理
 */
public class SinkeiyakuSyoruitoutyakuOperateProcess extends SyoruitoutyakuOperateProcess {

    @Inject
    private BizDomManager bizDomManager;

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @Inject
    private static Logger logger;

    public SinkeiyakuSyoruitoutyakuOperateProcess() {
        super();
    }

    @Override
    public boolean hanteiToutyakuProcessForwardSyoruiCd(C_SyoruiCdKbn pSyoruiCdKbn) {
        return false;
    }

    @Override
    public String getSyoruitoutyakuNodeId() {
        return ISkCommonKoumoku.NODEID_MOUSIKOMISYOTORIKOMI;
    }

    @Override
    public void doujiSeikyuu(String pImageId, String pKouteiKanriId, C_SyoruiCdKbn pSyoruiCdKbn) {
    }

    @Override
    public void operateProcessForMultipleBranch(String pImageId, String pKouteiKanriId, C_SyoruiCdKbn pSyoruiCdKbn) {

        BzGetProcessSummary bzGetProcessSummary = SWAKInjector.getInstance(BzGetProcessSummary.class);
        BzGetProcessSummaryInBean bzGetProcessSummaryInBean = SWAKInjector.getInstance(BzGetProcessSummaryInBean.class);
        BzGetProcessSummaryOutBean mainProcessSummaryBean = null;
        String mainProcessMosNo = "";
        boolean mainProcessUmu = false;

        bzGetProcessSummaryInBean.setKouteiKanriId(pKouteiKanriId);
        bzGetProcessSummaryInBean.setKouteiKanriStatuss(C_Kouteikanristatus.SYORITYUU);

        List<BzGetProcessSummaryOutBean> bzGetProcessSummaryOutBeanLst = bzGetProcessSummary.exec(bzGetProcessSummaryInBean);

        if (bzGetProcessSummaryOutBeanLst.size() > 0) {
            mainProcessSummaryBean = bzGetProcessSummaryOutBeanLst.get(0);
            mainProcessMosNo = mainProcessSummaryBean.getMosNo();
            mainProcessUmu = true;
        }
        else {

            if (!C_SyoruiCdKbn.SK_HENKINIRAISYO.eq(pSyoruiCdKbn)) {
                return;
            }

            BT_GyoumuKouteiInfo gyoumuKouteiInfo = bizDomManager.getGyoumuKouteiInfo(pKouteiKanriId);

            if (gyoumuKouteiInfo == null) {
                return;
            }

            mainProcessMosNo = gyoumuKouteiInfo.getMosno();

            HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mainProcessMosNo);

            if (syoriCTL == null) {
                return;
            }

            bzGetProcessSummaryInBean = SWAKInjector.getInstance(BzGetProcessSummaryInBean.class);

            bzGetProcessSummaryInBean.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN);
            bzGetProcessSummaryInBean.setSyoNo(syoriCTL.getSyono());
            bzGetProcessSummaryOutBeanLst = bzGetProcessSummary.exec(bzGetProcessSummaryInBean);

            if (bzGetProcessSummaryOutBeanLst.isEmpty()) {
                return;
            }

            mainProcessSummaryBean = bzGetProcessSummaryOutBeanLst.get(0);
            mainProcessMosNo = mainProcessSummaryBean.getMosNo();
            mainProcessUmu = false;
        }

        if (!ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN.equals(mainProcessSummaryBean.getJimuTetuzukiCd())
            && !ISkCommonKoumoku.JIMUTETUZUKICD_SKHENKIN.equals(mainProcessSummaryBean.getJimuTetuzukiCd())) {
            bzGetProcessSummary = SWAKInjector.getInstance(BzGetProcessSummary.class);
            bzGetProcessSummaryInBean = SWAKInjector.getInstance(BzGetProcessSummaryInBean.class);

            bzGetProcessSummaryInBean.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN);
            bzGetProcessSummaryInBean.setKouteiKanriStatuss(C_Kouteikanristatus.SYORITYUU);
            bzGetProcessSummaryInBean.setMosNo(mainProcessMosNo);

            bzGetProcessSummaryOutBeanLst = bzGetProcessSummary.exec(bzGetProcessSummaryInBean);

            if (bzGetProcessSummaryOutBeanLst.size() > 0) {
                mainProcessSummaryBean = bzGetProcessSummaryOutBeanLst.get(0);
                mainProcessMosNo = mainProcessSummaryBean.getMosNo();
            }
            else {
                return;
            }
        }

        if (C_SyoruiCdKbn.SK_HUBITUUTI.eq(pSyoruiCdKbn)) {
            bzGetProcessSummary = SWAKInjector.getInstance(BzGetProcessSummary.class);
            bzGetProcessSummaryInBean = SWAKInjector.getInstance(BzGetProcessSummaryInBean.class);
            bzGetProcessSummaryInBean.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKHUBIKAISYOU);
            bzGetProcessSummaryInBean.setKouteiKanriStatuss(C_Kouteikanristatus.SYORITYUU);
            bzGetProcessSummaryInBean.setMosNo(mainProcessMosNo);

            bzGetProcessSummaryOutBeanLst = bzGetProcessSummary.exec(bzGetProcessSummaryInBean);

            if (bzGetProcessSummaryOutBeanLst.size() == 0) {
                throw new BizLogicException(MessageId.EHC1054, "新契約不備解消", pSyoruiCdKbn.getContent());
            }
        }
        else if (C_SyoruiCdKbn.SK_KYKKAKUNINIRAISYO.eq(pSyoruiCdKbn)) {
            bzGetProcessSummary = SWAKInjector.getInstance(BzGetProcessSummary.class);
            bzGetProcessSummaryInBean = SWAKInjector.getInstance(BzGetProcessSummaryInBean.class);
            bzGetProcessSummaryInBean.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKKEIYAKUKAKUNIN);
            bzGetProcessSummaryInBean.setKouteiKanriStatuss(C_Kouteikanristatus.SYORITYUU);
            bzGetProcessSummaryInBean.setMosNo(mainProcessMosNo);

            bzGetProcessSummaryOutBeanLst = bzGetProcessSummary.exec(bzGetProcessSummaryInBean);

            if (bzGetProcessSummaryOutBeanLst.size() == 0) {
                throw new BizLogicException(MessageId.EHC1054, "契約確認", pSyoruiCdKbn.getContent());
            }
        }

        BzLockProcess bzLockProcess = SWAKInjector.getInstance(BzLockProcess.class);
        BzLockProcessOutBean bzLockProcessOutBean = SWAKInjector.getInstance(BzLockProcessOutBean.class);

        if (mainProcessUmu) {

            bzLockProcessOutBean = bzLockProcess.exec(
                mainProcessSummaryBean.getKouteiKanriId(), mainProcessSummaryBean.getJimuTetuzukiCd());

            if (C_KouteiLockKekkaKbn.SUCCESS.eq(bzLockProcessOutBean.getKouteiLockKekkaKbn())) {
            }
            else {
                throw new BizLogicException(MessageId.EBA0110);
            }
        }

        if ((C_SyoruiCdKbn.SK_MOSSYO.eq(pSyoruiCdKbn) ||
            C_SyoruiCdKbn.SK_KOKUSYO.eq(pSyoruiCdKbn) ||
            C_SyoruiCdKbn.SK_TORIHOUSYO.eq(pSyoruiCdKbn) ||
            C_SyoruiCdKbn.SK_IKOUKAKSYO.eq(pSyoruiCdKbn)) &&
            C_MosUketukeKbn.PAPERLESS.eq(mainProcessSummaryBean.getMosUketukeKbn())) {

            logger.warn(
                MessageUtil.getMessage(MessageId.EHF1014, mainProcessSummaryBean.getMosNo(), "申込受付区分相違"));
        }

        bzGetProcessSummary = SWAKInjector.getInstance(BzGetProcessSummary.class);
        bzGetProcessSummaryInBean = SWAKInjector.getInstance(BzGetProcessSummaryInBean.class);

        HT_SyoriCTL syoriCTL = null;
        BzProcessForward bzProcessForward = SWAKInjector.getInstance(BzProcessForward.class);
        BzProcessForwardInBean bzProcessForwardInBean = SWAKInjector.getInstance(BzProcessForwardInBean.class);
        BzGetProcessSummaryOutBean syoruiSummaryBean = null;

        syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mainProcessMosNo);

        if (C_SyoruiCdKbn.SK_MOSSYO.eq(pSyoruiCdKbn) ||
            C_SyoruiCdKbn.SK_KOKUSYO.eq(pSyoruiCdKbn)) {
            SkMainDairitenRuleBean skMainDairitenRuleBean = SWAKInjector.getInstance(SkMainDairitenRuleBean.class);

            if (syoriCTL == null) {
                skMainDairitenRuleBean.setSkkouteikanryouKbn(C_SkkouteikanryouKbn.getContentByValue(
                    C_SkkouteikanryouKbn.PATTERN_DEFAULT,
                    String.valueOf(C_SkkouteikanryouKbn.SYORITYUU)));
                skMainDairitenRuleBean.setSeirituKbn(C_SeirituKbn.getContentByValue(
                    C_SeirituKbn.PATTERN_DEFAULT,
                    String.valueOf(C_SeirituKbn.NONE)));
                skMainDairitenRuleBean.setMosnrkUmu(C_UmuKbn.getContentByValue(
                    C_UmuKbn.PATTERN_DEFAULT,
                    String.valueOf(C_UmuKbn.NONE)));
                skMainDairitenRuleBean.setSntkhouKbn(C_SntkhouKbn.getContentByValue(
                    C_SntkhouKbn.PATTERN_DEFAULT,
                    String.valueOf(C_SntkhouKbn.KKT)));
                skMainDairitenRuleBean.setKktnrkUmu(C_UmuKbn.getContentByValue(
                    C_UmuKbn.PATTERN_DEFAULT,
                    String.valueOf(C_UmuKbn.NONE)));
                skMainDairitenRuleBean.setKktnrkvrfjkKbn(C_VrfjkKbn.getContentByValue(
                    C_VrfjkKbn.PATTERN_DEFAULT,
                    String.valueOf(C_VrfjkKbn.TSHN_MIJISSI)));
                skMainDairitenRuleBean.setMostenkenjouKbn(C_MostenkenjyouKbn.getContentByValue(
                    C_MostenkenjyouKbn.PATTERN_DEFAULT,
                    String.valueOf(C_MostenkenjyouKbn.NONE)));
                skMainDairitenRuleBean.setKetteiKbn(C_KetteiKbn.getContentByValue(
                    C_KetteiKbn.PATTERN_DEFAULT,
                    String.valueOf(C_KetteiKbn.NONE)));
                skMainDairitenRuleBean.setSateijtKbn(C_SateijtKbn.getContentByValue(
                    C_SateijtKbn.PATTERN_DEFAULT,
                    String.valueOf(C_SateijtKbn.SATEI_TYUU)));
                skMainDairitenRuleBean.setSrhhbKbn(C_UmuKbn.getContentByValue(
                    C_UmuKbn.PATTERN_DEFAULT,
                    String.valueOf(C_UmuKbn.NONE)));
            }
            else {
                HT_MosKihon mosKihon = syoriCTL.getMosKihon();
                C_SntkhouKbn sntkhouKbn = null;

                if (mosKihon == null) {
                    sntkhouKbn = C_SntkhouKbn.KKT;
                }
                else {
                    sntkhouKbn = mosKihon.getSntkhoukbn();
                }

                skMainDairitenRuleBean.setSkkouteikanryouKbn(C_SkkouteikanryouKbn.getContentByValue(
                    C_SkkouteikanryouKbn.PATTERN_DEFAULT,
                    String.valueOf(C_SkkouteikanryouKbn.SYORITYUU)));
                skMainDairitenRuleBean.setSeirituKbn(C_SeirituKbn.getContentByValue(
                    C_SeirituKbn.PATTERN_DEFAULT,
                    String.valueOf(syoriCTL.getSeiritukbn())));
                skMainDairitenRuleBean.setMosnrkUmu(C_UmuKbn.getContentByValue(
                    C_UmuKbn.PATTERN_DEFAULT,
                    String.valueOf(syoriCTL.getMosnrkumu())));
                skMainDairitenRuleBean.setSntkhouKbn(C_SntkhouKbn.getContentByValue(
                    C_SntkhouKbn.PATTERN_DEFAULT,
                    String.valueOf(sntkhouKbn)));
                skMainDairitenRuleBean.setKktnrkUmu(C_UmuKbn.getContentByValue(
                    C_UmuKbn.PATTERN_DEFAULT,
                    String.valueOf(syoriCTL.getKktnrkumu())));
                skMainDairitenRuleBean.setKktnrkvrfjkKbn(C_VrfjkKbn.getContentByValue(
                    C_VrfjkKbn.PATTERN_DEFAULT,
                    String.valueOf(syoriCTL.getKktnrkvrfjkkbn())));
                skMainDairitenRuleBean.setMostenkenjouKbn(C_MostenkenjyouKbn.getContentByValue(
                    C_MostenkenjyouKbn.PATTERN_DEFAULT,
                    String.valueOf(syoriCTL.getMostenkenjoukbn())));
                skMainDairitenRuleBean.setKetteiKbn(C_KetteiKbn.getContentByValue(
                    C_KetteiKbn.PATTERN_DEFAULT,
                    String.valueOf(syoriCTL.getKetteikbn())));
                skMainDairitenRuleBean.setSateijtKbn(C_SateijtKbn.getContentByValue(
                    C_SateijtKbn.PATTERN_DEFAULT,
                    String.valueOf(syoriCTL.getSateijtkbn())));
                skMainDairitenRuleBean.setSrhhbKbn(C_UmuKbn.getContentByValue(
                    C_UmuKbn.PATTERN_DEFAULT,
                    String.valueOf(C_UmuKbn.NONE)));
            }

            bzProcessForwardInBean.setKouteiKanriId(mainProcessSummaryBean.getKouteiKanriId());
            bzProcessForwardInBean.setJimuTetuzukiCd(mainProcessSummaryBean.getJimuTetuzukiCd());
            bzProcessForwardInBean.setKouteiLockKey(bzLockProcessOutBean.getKouteiLockKey());
            bzProcessForwardInBean.setIwfApiRuleBean(skMainDairitenRuleBean);
            bzProcessForwardInBean.setSyorikekkaKbn(C_SyorikekkaKbn.KANRYOU);
            bzProcessForwardInBean.setProcessRecordOutYouhiKbn(C_YouhiKbn.HUYOU);

            bzProcessForward.exec(bzProcessForwardInBean);
        }

        if (C_SyoruiCdKbn.SK_MOSSYO.eq(pSyoruiCdKbn)) {
            bzGetProcessSummaryInBean.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKINPUTMOS);
            bzGetProcessSummaryInBean.setKouteiKanriStatuss(C_Kouteikanristatus.SYORITYUU);
            bzGetProcessSummaryInBean.setMosNo(mainProcessMosNo);

            syoruiSummaryBean = bzGetProcessSummary.exec(bzGetProcessSummaryInBean).get(0);

            if (ISkCommonKoumoku.NODEID_KOUTEIKAISI.equals(syoruiSummaryBean.getNowNodoId())) {
                SkInputMosRuleBean skInputMosRuleBean = SWAKInjector.getInstance(SkInputMosRuleBean.class);
                if (syoriCTL == null) {
                    skInputMosRuleBean.setSkkouteikanryouKbn(C_SkkouteikanryouKbn.getContentByValue(
                        C_SkkouteikanryouKbn.PATTERN_DEFAULT,
                        String.valueOf(C_SkkouteikanryouKbn.SYORITYUU)));
                    skInputMosRuleBean.setMosuketukeKbn(C_MosUketukeKbn.getContentByValue(
                        C_MosUketukeKbn.PATTERN_DEFAULT,
                        String.valueOf(syoruiSummaryBean.getMosUketukeKbn())));
                    skInputMosRuleBean.setMosnrkvrfjkKbn(C_VrfjkKbn.getContentByValue(
                        C_VrfjkKbn.PATTERN_DEFAULT,
                        String.valueOf(C_VrfjkKbn.TSHN_MIJISSI)));
                }
                else {
                    skInputMosRuleBean.setSkkouteikanryouKbn(C_SkkouteikanryouKbn.getContentByValue(
                        C_SkkouteikanryouKbn.PATTERN_DEFAULT,
                        String.valueOf(C_SkkouteikanryouKbn.SYORITYUU)));
                    skInputMosRuleBean.setMosuketukeKbn(C_MosUketukeKbn.getContentByValue(
                        C_MosUketukeKbn.PATTERN_DEFAULT,
                        String.valueOf(syoriCTL.getMosuketukekbn())));
                    skInputMosRuleBean.setMosnrkvrfjkKbn(C_VrfjkKbn.getContentByValue(
                        C_VrfjkKbn.PATTERN_DEFAULT,
                        String.valueOf(syoriCTL.getMosnrkvrfjkkbn())));
                }

                bzProcessForwardInBean.setKouteiKanriId(syoruiSummaryBean.getKouteiKanriId());
                bzProcessForwardInBean.setJimuTetuzukiCd(syoruiSummaryBean.getJimuTetuzukiCd());
                bzProcessForwardInBean.setKouteiLockKey(bzLockProcessOutBean.getKouteiLockKey());
                bzProcessForwardInBean.setIwfApiRuleBean(skInputMosRuleBean);
                bzProcessForwardInBean.setSyorikekkaKbn(C_SyorikekkaKbn.KANRYOU);
                bzProcessForwardInBean.setProcessRecordOutYouhiKbn(C_YouhiKbn.HUYOU);

                bzProcessForward.exec(bzProcessForwardInBean);
            }
        }
        else if (C_SyoruiCdKbn.SK_KOKUSYO.eq(pSyoruiCdKbn)) {
            bzGetProcessSummaryInBean.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKINPUTKOKUTI);
            bzGetProcessSummaryInBean.setKouteiKanriStatuss(C_Kouteikanristatus.SYORITYUU);
            bzGetProcessSummaryInBean.setMosNo(mainProcessMosNo);

            syoruiSummaryBean = bzGetProcessSummary.exec(bzGetProcessSummaryInBean).get(0);

            if (ISkCommonKoumoku.NODEID_KOUTEIKAISI.equals(syoruiSummaryBean.getNowNodoId())
                || ISkCommonKoumoku.NODEID_KOUTEIKANRYOU.equals(syoruiSummaryBean.getNowNodoId())) {
                syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mainProcessMosNo);

                SkInputKokutiRuleBean skInputKokutiRuleBean = SWAKInjector.getInstance(SkInputKokutiRuleBean.class);
                if (syoriCTL == null) {
                    skInputKokutiRuleBean.setSkkouteikanryouKbn(C_SkkouteikanryouKbn.getContentByValue(
                        C_SkkouteikanryouKbn.PATTERN_DEFAULT,
                        String.valueOf(C_SkkouteikanryouKbn.SYORITYUU)));
                    skInputKokutiRuleBean.setSeirituKbn(C_SeirituKbn.getContentByValue(
                        C_SeirituKbn.PATTERN_DEFAULT,
                        String.valueOf(C_SeirituKbn.NONE)));
                    skInputKokutiRuleBean.setMosnrkUmu(C_UmuKbn.getContentByValue(
                        C_UmuKbn.PATTERN_DEFAULT,
                        String.valueOf(C_UmuKbn.NONE)));
                    skInputKokutiRuleBean.setMosuketukeKbn(C_MosUketukeKbn.getContentByValue(
                        C_MosUketukeKbn.PATTERN_DEFAULT,
                        String.valueOf(syoruiSummaryBean.getMosUketukeKbn())));
                    skInputKokutiRuleBean.setSntkhouKbn(C_SntkhouKbn.getContentByValue(
                        C_SntkhouKbn.PATTERN_DEFAULT,
                        String.valueOf(C_SntkhouKbn.KKT)));
                    skInputKokutiRuleBean.setKktnrkvrfjkKbn(C_VrfjkKbn.getContentByValue(
                        C_VrfjkKbn.PATTERN_DEFAULT,
                        String.valueOf(C_VrfjkKbn.TSHN_MIJISSI)));
                }
                else {
                    HT_MosKihon mosKihon = syoriCTL.getMosKihon();
                    C_SntkhouKbn sntkhouKbn = null;

                    if (mosKihon == null) {
                        sntkhouKbn = C_SntkhouKbn.KKT;
                    }
                    else {
                        sntkhouKbn = mosKihon.getSntkhoukbn();
                    }

                    skInputKokutiRuleBean.setSkkouteikanryouKbn(C_SkkouteikanryouKbn.getContentByValue(
                        C_SkkouteikanryouKbn.PATTERN_DEFAULT,
                        String.valueOf(C_SkkouteikanryouKbn.SYORITYUU)));
                    skInputKokutiRuleBean.setSeirituKbn(C_SeirituKbn.getContentByValue(
                        C_SeirituKbn.PATTERN_DEFAULT,
                        String.valueOf(syoriCTL.getSeiritukbn())));
                    skInputKokutiRuleBean.setMosnrkUmu(C_UmuKbn.getContentByValue(
                        C_UmuKbn.PATTERN_DEFAULT,
                        String.valueOf(syoriCTL.getMosnrkumu())));
                    skInputKokutiRuleBean.setMosuketukeKbn(C_MosUketukeKbn.getContentByValue(
                        C_MosUketukeKbn.PATTERN_DEFAULT,
                        String.valueOf(syoriCTL.getMosuketukekbn())));
                    skInputKokutiRuleBean.setSntkhouKbn(C_SntkhouKbn.getContentByValue(
                        C_SntkhouKbn.PATTERN_DEFAULT,
                        String.valueOf(sntkhouKbn)));
                    skInputKokutiRuleBean.setKktnrkvrfjkKbn(C_VrfjkKbn.getContentByValue(
                        C_VrfjkKbn.PATTERN_DEFAULT,
                        String.valueOf(syoriCTL.getKktnrkvrfjkkbn())));
                }

                bzProcessForwardInBean.setKouteiKanriId(syoruiSummaryBean.getKouteiKanriId());
                bzProcessForwardInBean.setJimuTetuzukiCd(syoruiSummaryBean.getJimuTetuzukiCd());
                bzProcessForwardInBean.setKouteiLockKey(bzLockProcessOutBean.getKouteiLockKey());
                bzProcessForwardInBean.setIwfApiRuleBean(skInputKokutiRuleBean);
                bzProcessForwardInBean.setSyorikekkaKbn(C_SyorikekkaKbn.KANRYOU);
                bzProcessForwardInBean.setProcessRecordOutYouhiKbn(C_YouhiKbn.HUYOU);

                bzProcessForward.exec(bzProcessForwardInBean);
            }
        }
        else if (C_SyoruiCdKbn.SK_HUBITUUTI.eq(pSyoruiCdKbn)) {
            bzGetProcessSummaryInBean.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKHUBIKAISYOU);
            bzGetProcessSummaryInBean.setKouteiKanriStatuss(C_Kouteikanristatus.SYORITYUU);
            bzGetProcessSummaryInBean.setMosNo(mainProcessMosNo);

            bzGetProcessSummaryOutBeanLst = bzGetProcessSummary.exec(bzGetProcessSummaryInBean);

            if (bzGetProcessSummaryOutBeanLst.size() != 0) {
                syoruiSummaryBean = bzGetProcessSummaryOutBeanLst.get(0);

                C_HubikaisyoujoutaiKbn hubikaisyoujoutaiKbn = C_HubikaisyoujoutaiKbn.HUBIKAISYOUMATI;
                C_SeirituKbn seirituKbn = C_SeirituKbn.NONE;

                if (syoriCTL != null) {
                    if (C_HubikaisyoujoutaiKbn.HUBIKAITOUMATI.eq(syoriCTL.getHubikaisyoujoutaikbn())) {

                        syoriCTL.setHubikaisyoujoutaikbn(C_HubikaisyoujoutaiKbn.HUBIKAISYOUMATI);

                        sinkeiyakuDomManager.update(syoriCTL);
                    }

                    hubikaisyoujoutaiKbn = syoriCTL.getHubikaisyoujoutaikbn();
                    seirituKbn = syoriCTL.getSeiritukbn();
                }

                if (ISkCommonKoumoku.NODEID_SKHUBIKAITOUMATI.equals(syoruiSummaryBean.getNowNodoId())
                    || ISkCommonKoumoku.NODEID_KOUTEIKANRYOU.equals(syoruiSummaryBean.getNowNodoId())) {
                    SkHubiKaisyouRuleBean skHubiKaisyouRuleBean = SWAKInjector.getInstance(SkHubiKaisyouRuleBean.class);

                    skHubiKaisyouRuleBean.setSkkouteikanryouKbn(C_SkkouteikanryouKbn.getContentByValue(
                        C_SkkouteikanryouKbn.PATTERN_DEFAULT,
                        String.valueOf(C_SkkouteikanryouKbn.SYORITYUU)));
                    skHubiKaisyouRuleBean.setSeirituKbn(C_SeirituKbn.getContentByValue(
                        C_SeirituKbn.PATTERN_DEFAULT,
                        String.valueOf(seirituKbn)));
                    skHubiKaisyouRuleBean.setHubikaisyoujoutaiKbn(C_HubikaisyoujoutaiKbn.getContentByValue(
                        C_HubikaisyoujoutaiKbn.PATTERN_DEFAULT,
                        String.valueOf(hubikaisyoujoutaiKbn)));

                    bzProcessForwardInBean.setKouteiKanriId(syoruiSummaryBean.getKouteiKanriId());
                    bzProcessForwardInBean.setJimuTetuzukiCd(syoruiSummaryBean.getJimuTetuzukiCd());
                    bzProcessForwardInBean.setKouteiLockKey(bzLockProcessOutBean.getKouteiLockKey());
                    bzProcessForwardInBean.setIwfApiRuleBean(skHubiKaisyouRuleBean);
                    bzProcessForwardInBean.setSyorikekkaKbn(C_SyorikekkaKbn.KANRYOU);
                    bzProcessForwardInBean.setProcessRecordOutYouhiKbn(C_YouhiKbn.HUYOU);

                    bzProcessForward.exec(bzProcessForwardInBean);
                }
            }
            else {

                BzUnlockProcess bzUnlockProcess = SWAKInjector.getInstance(BzUnlockProcess.class);

                bzUnlockProcess.exec(mainProcessSummaryBean.getKouteiKanriId(),
                    mainProcessSummaryBean.getJimuTetuzukiCd(),
                    bzLockProcessOutBean.getKouteiLockKey());

                throw new BizLogicException(MessageId.EHC1054, "新契約不備解消", pSyoruiCdKbn.getContent());

            }
        }
        else if (C_SyoruiCdKbn.SK_KYKKAKUNINIRAISYO.eq(pSyoruiCdKbn)) {
            bzGetProcessSummaryInBean.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKKEIYAKUKAKUNIN);
            bzGetProcessSummaryInBean.setKouteiKanriStatuss(C_Kouteikanristatus.SYORITYUU);
            bzGetProcessSummaryInBean.setMosNo(mainProcessMosNo);

            bzGetProcessSummaryOutBeanLst = bzGetProcessSummary.exec(bzGetProcessSummaryInBean);

            if (bzGetProcessSummaryOutBeanLst.size() != 0) {
                syoruiSummaryBean = bzGetProcessSummaryOutBeanLst.get(0);

                if (ISkCommonKoumoku.NODEID_KOUTEIKAISI.equals(syoruiSummaryBean.getNowNodoId()) ||
                    ISkCommonKoumoku.NODEID_KOUTEIKANRYOU.equals(syoruiSummaryBean.getNowNodoId())) {
                    SkKeiyakukakuninRuleBean skKeiyakukakuninRuleBean = SWAKInjector.getInstance(SkKeiyakukakuninRuleBean.class);

                    C_SeirituKbn seirituKbn = C_SeirituKbn.NONE;
                    C_KetteiKbn ketteiKbn = C_KetteiKbn.NONE;
                    C_KykkakjkKbn kykkakjkKbn = C_KykkakjkKbn.KETMAE_KAKUNIN;

                    if (syoriCTL != null) {
                        seirituKbn = syoriCTL.getSeiritukbn();
                        ketteiKbn = syoriCTL.getKetteikbn();
                        kykkakjkKbn = syoriCTL.getKykkakjkkbn();
                    }

                    skKeiyakukakuninRuleBean.setSkkouteikanryouKbn(C_SkkouteikanryouKbn.getContentByValue(
                        C_SkkouteikanryouKbn.PATTERN_DEFAULT,
                        String.valueOf(C_SkkouteikanryouKbn.SYORITYUU)));
                    skKeiyakukakuninRuleBean.setSeirituKbn(C_SeirituKbn.getContentByValue(
                        C_SeirituKbn.PATTERN_DEFAULT,
                        String.valueOf(seirituKbn)));
                    skKeiyakukakuninRuleBean.setKetteiKbn(C_KetteiKbn.getContentByValue(
                        C_KetteiKbn.PATTERN_DEFAULT,
                        String.valueOf(ketteiKbn)));
                    skKeiyakukakuninRuleBean.setKykkakjkKbn(C_KykkakjkKbn.getContentByValue(
                        C_KykkakjkKbn.PATTERN_DEFAULT,
                        String.valueOf(kykkakjkKbn)));

                    bzProcessForwardInBean.setKouteiKanriId(syoruiSummaryBean.getKouteiKanriId());
                    bzProcessForwardInBean.setJimuTetuzukiCd(syoruiSummaryBean.getJimuTetuzukiCd());
                    bzProcessForwardInBean.setKouteiLockKey(bzLockProcessOutBean.getKouteiLockKey());
                    bzProcessForwardInBean.setIwfApiRuleBean(skKeiyakukakuninRuleBean);
                    bzProcessForwardInBean.setSyorikekkaKbn(C_SyorikekkaKbn.KANRYOU);
                    bzProcessForwardInBean.setProcessRecordOutYouhiKbn(C_YouhiKbn.HUYOU);

                    bzProcessForward.exec(bzProcessForwardInBean);
                }
            }
            else {

                BzUnlockProcess bzUnlockProcess = SWAKInjector.getInstance(BzUnlockProcess.class);

                bzUnlockProcess.exec(mainProcessSummaryBean.getKouteiKanriId(),
                    mainProcessSummaryBean.getJimuTetuzukiCd(),
                    bzLockProcessOutBean.getKouteiLockKey());

                throw new BizLogicException(MessageId.EHC1054, "契約確認", pSyoruiCdKbn.getContent());

            }
        }
        else if (C_SyoruiCdKbn.SK_TRKSSEIKYU.eq(pSyoruiCdKbn)) {
            bzGetProcessSummaryInBean.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKTORIKESI);
            bzGetProcessSummaryInBean.setKouteiKanriStatuss(C_Kouteikanristatus.SYORITYUU);
            bzGetProcessSummaryInBean.setMosNo(mainProcessMosNo);

            bzGetProcessSummaryOutBeanLst = bzGetProcessSummary.exec(bzGetProcessSummaryInBean);

            if (bzGetProcessSummaryOutBeanLst.size() != 0) {
                syoruiSummaryBean = bzGetProcessSummaryOutBeanLst.get(0);

                if (ISkCommonKoumoku.NODEID_KOUTEIKAISI.equals(syoruiSummaryBean.getNowNodoId()) ||
                    ISkCommonKoumoku.NODEID_KOUTEIKANRYOU.equals(syoruiSummaryBean.getNowNodoId())) {
                    SkTorikesiRuleBean skTorikesiRuleBean = SWAKInjector.getInstance(SkTorikesiRuleBean.class);

                    C_SeirituKbn seirituKbn = C_SeirituKbn.NONE;
                    C_UmuKbn mosnrkumu = C_UmuKbn.NONE;

                    if (syoriCTL != null) {
                        seirituKbn = syoriCTL.getSeiritukbn();
                        mosnrkumu = syoriCTL.getMosnrkumu();
                    }

                    skTorikesiRuleBean.setSkkouteikanryouKbn(C_SkkouteikanryouKbn.getContentByValue(
                        C_SkkouteikanryouKbn.PATTERN_DEFAULT,
                        String.valueOf(C_SkkouteikanryouKbn.SYORITYUU)));
                    skTorikesiRuleBean.setSeirituKbn(C_SeirituKbn.getContentByValue(
                        C_SeirituKbn.PATTERN_DEFAULT,
                        String.valueOf(seirituKbn)));
                    skTorikesiRuleBean.setMosnrkUmu(C_UmuKbn.getContentByValue(
                        C_UmuKbn.PATTERN_DEFAULT,
                        String.valueOf(mosnrkumu)));

                    bzProcessForwardInBean.setKouteiKanriId(syoruiSummaryBean.getKouteiKanriId());
                    bzProcessForwardInBean.setJimuTetuzukiCd(syoruiSummaryBean.getJimuTetuzukiCd());
                    bzProcessForwardInBean.setKouteiLockKey(bzLockProcessOutBean.getKouteiLockKey());
                    bzProcessForwardInBean.setIwfApiRuleBean(skTorikesiRuleBean);
                    bzProcessForwardInBean.setSyorikekkaKbn(C_SyorikekkaKbn.KANRYOU);
                    bzProcessForwardInBean.setProcessRecordOutYouhiKbn(C_YouhiKbn.HUYOU);

                    bzProcessForward.exec(bzProcessForwardInBean);
                }
            }
            else {

                SkProcessCreateInBean skProcessCreateInBean = new SkProcessCreateInBean();
                SkProcessCreate skProcessCreate = SWAKInjector.getInstance(SkProcessCreate.class);

                skProcessCreateInBean.setSkeiJimuKbn(mainProcessSummaryBean.getSkeijimuKbn());
                skProcessCreateInBean.setMosUketukeKbn(mainProcessSummaryBean.getMosUketukeKbn());
                skProcessCreateInBean.setHknSyuruiNo(mainProcessSummaryBean.getHknsyuruiNo());
                skProcessCreateInBean.setDairitenCd1(mainProcessSummaryBean.getDairitencd1());
                skProcessCreateInBean.setDairitenCd2(mainProcessSummaryBean.getDairitencd2());
                skProcessCreateInBean.setJimuyouCd(mainProcessSummaryBean.getJimuyoucd());
                skProcessCreateInBean.setJmycdMisetteiKbn(mainProcessSummaryBean.getJmycdMisetteiKbn());
                skProcessCreateInBean.setDoujimosUmu(mainProcessSummaryBean.getDoujimosumu());
                skProcessCreateInBean.setMosYmd(mainProcessSummaryBean.getMosymd());
                skProcessCreateInBean.setJimuStartYmd(mainProcessSummaryBean.getJimuStartYmdTime());
                skProcessCreateInBean.setSyoNo(mainProcessSummaryBean.getSyoNo());
                skProcessCreateInBean.setMosNo(mainProcessSummaryBean.getMosNo());
                skProcessCreateInBean.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKTORIKESI);

                skProcessCreate.exec(skProcessCreateInBean);

                bzGetProcessSummaryInBean.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKTORIKESI);
                bzGetProcessSummaryInBean.setKouteiKanriStatuss(C_Kouteikanristatus.SYORITYUU);
                bzGetProcessSummaryInBean.setMosNo(mainProcessMosNo);

                bzGetProcessSummaryOutBeanLst = bzGetProcessSummary.exec(bzGetProcessSummaryInBean);

                if (bzGetProcessSummaryOutBeanLst.size() > 0) {
                    syoruiSummaryBean = bzGetProcessSummaryOutBeanLst.get(0);

                    SkTorikesiRuleBean skTorikesiRuleBean = SWAKInjector.getInstance(SkTorikesiRuleBean.class);

                    C_SeirituKbn seirituKbn = C_SeirituKbn.NONE;
                    C_UmuKbn mosnrkumu = C_UmuKbn.NONE;

                    if (syoriCTL != null) {
                        seirituKbn = syoriCTL.getSeiritukbn();
                        mosnrkumu = syoriCTL.getMosnrkumu();
                    }

                    if (C_UmuKbn.ARI.eq(mosnrkumu)) {
                        skTorikesiRuleBean.setSkkouteikanryouKbn(C_SkkouteikanryouKbn.getContentByValue(
                            C_SkkouteikanryouKbn.PATTERN_DEFAULT,
                            String.valueOf(C_SkkouteikanryouKbn.SYORITYUU)));
                        skTorikesiRuleBean.setSeirituKbn(C_SeirituKbn.getContentByValue(
                            C_SeirituKbn.PATTERN_DEFAULT,
                            String.valueOf(seirituKbn)));
                        skTorikesiRuleBean.setMosnrkUmu(C_UmuKbn.getContentByValue(
                            C_UmuKbn.PATTERN_DEFAULT,
                            String.valueOf(mosnrkumu)));

                        BzLockProcessOutBean bzLockProcessOutBeanTorikesi =
                            bzLockProcess.exec(syoruiSummaryBean.getKouteiKanriId(),
                                syoruiSummaryBean.getJimuTetuzukiCd());

                        if (C_KouteiLockKekkaKbn.SUCCESS.eq(bzLockProcessOutBeanTorikesi.getKouteiLockKekkaKbn())) {
                        }
                        else {
                            throw new BizLogicException(MessageId.EBA0110);
                        }

                        bzProcessForwardInBean.setKouteiKanriId(syoruiSummaryBean.getKouteiKanriId());
                        bzProcessForwardInBean.setJimuTetuzukiCd(syoruiSummaryBean.getJimuTetuzukiCd());
                        bzProcessForwardInBean.setKouteiLockKey(bzLockProcessOutBeanTorikesi.getKouteiLockKey());
                        bzProcessForwardInBean.setIwfApiRuleBean(skTorikesiRuleBean);
                        bzProcessForwardInBean.setSyorikekkaKbn(C_SyorikekkaKbn.KANRYOU);
                        bzProcessForwardInBean.setProcessRecordOutYouhiKbn(C_YouhiKbn.HUYOU);

                        bzProcessForward.exec(bzProcessForwardInBean);

                        BzUnlockProcess bzUnlockProcess = SWAKInjector.getInstance(BzUnlockProcess.class);
                        bzUnlockProcess.exec(syoruiSummaryBean.getKouteiKanriId(),
                            syoruiSummaryBean.getJimuTetuzukiCd(),
                            bzLockProcessOutBeanTorikesi.getKouteiLockKey());
                    }
                }
            }
        }
        else if (C_SyoruiCdKbn.SK_HENKINIRAISYO.eq(pSyoruiCdKbn)) {
            bzGetProcessSummaryInBean.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKHENKIN);
            bzGetProcessSummaryInBean.setKouteiKanriStatuss(C_Kouteikanristatus.SYORITYUU);
            bzGetProcessSummaryInBean.setMosNo(mainProcessMosNo);

            bzGetProcessSummaryOutBeanLst = bzGetProcessSummary.exec(bzGetProcessSummaryInBean);

            if (bzGetProcessSummaryOutBeanLst.size() != 0) {
                syoruiSummaryBean = bzGetProcessSummaryOutBeanLst.get(0);

                if (ISkCommonKoumoku.NODEID_KOUTEIKAISI.equals(syoruiSummaryBean.getNowNodoId())) {
                    C_UmuKbn pkakinUmu = C_UmuKbn.NONE;
                    C_UmuKbn nyuukinUmu = C_UmuKbn.NONE;

                    if (syoriCTL != null) {

                        List<HT_Henkin> henkinLst = syoriCTL.getHenkinsByHnknsyoriymdNull();

                        if (henkinLst.size() == 0) {
                            pkakinUmu = C_UmuKbn.NONE;
                        }
                        else {
                            pkakinUmu = C_UmuKbn.ARI;
                        }

                        nyuukinUmu = syoriCTL.getNyknnrkumu();
                    }

                    if (C_UmuKbn.ARI.eq(pkakinUmu) && C_UmuKbn.ARI.eq(nyuukinUmu)) {

                        SkHenkinRuleBean skHenkinRuleBean = SWAKInjector.getInstance(SkHenkinRuleBean.class);

                        skHenkinRuleBean.setNyknnrkUmu(C_UmuKbn.getContentByValue(
                            C_UmuKbn.PATTERN_DEFAULT,
                            String.valueOf(nyuukinUmu)));
                        skHenkinRuleBean.setPkakinUmu(C_UmuKbn.getContentByValue(
                            C_UmuKbn.PATTERN_DEFAULT,
                            String.valueOf(pkakinUmu)));

                        BzLockProcessOutBean bzLockProcessOutBeanHenkin =
                            bzLockProcess.exec(syoruiSummaryBean.getKouteiKanriId(),
                                syoruiSummaryBean.getJimuTetuzukiCd());

                        if (C_KouteiLockKekkaKbn.SUCCESS.eq(bzLockProcessOutBeanHenkin.getKouteiLockKekkaKbn())) {
                        }
                        else {
                            throw new BizLogicException(MessageId.EBA0110);
                        }

                        bzProcessForwardInBean.setKouteiKanriId(syoruiSummaryBean.getKouteiKanriId());
                        bzProcessForwardInBean.setJimuTetuzukiCd(syoruiSummaryBean.getJimuTetuzukiCd());
                        bzProcessForwardInBean.setKouteiLockKey(bzLockProcessOutBeanHenkin.getKouteiLockKey());
                        bzProcessForwardInBean.setIwfApiRuleBean(skHenkinRuleBean);
                        bzProcessForwardInBean.setSyorikekkaKbn(C_SyorikekkaKbn.KANRYOU);
                        bzProcessForwardInBean.setProcessRecordOutYouhiKbn(C_YouhiKbn.HUYOU);

                        bzProcessForward.exec(bzProcessForwardInBean);

                        BzUnlockProcess bzUnlockProcess = SWAKInjector.getInstance(BzUnlockProcess.class);
                        bzUnlockProcess.exec(syoruiSummaryBean.getKouteiKanriId(),
                            syoruiSummaryBean.getJimuTetuzukiCd(),
                            bzLockProcessOutBeanHenkin.getKouteiLockKey());
                    }
                }
            }
            else {

                SkProcessCreateInBean skProcessCreateInBean = new SkProcessCreateInBean();
                SkProcessCreate skProcessCreate = SWAKInjector.getInstance(SkProcessCreate.class);

                skProcessCreateInBean.setSkeiJimuKbn(mainProcessSummaryBean.getSkeijimuKbn());
                skProcessCreateInBean.setMosUketukeKbn(mainProcessSummaryBean.getMosUketukeKbn());
                skProcessCreateInBean.setHknSyuruiNo(mainProcessSummaryBean.getHknsyuruiNo());
                skProcessCreateInBean.setDairitenCd1(mainProcessSummaryBean.getDairitencd1());
                skProcessCreateInBean.setDairitenCd2(mainProcessSummaryBean.getDairitencd2());
                skProcessCreateInBean.setJimuyouCd(mainProcessSummaryBean.getJimuyoucd());
                skProcessCreateInBean.setJmycdMisetteiKbn(mainProcessSummaryBean.getJmycdMisetteiKbn());
                skProcessCreateInBean.setDoujimosUmu(mainProcessSummaryBean.getDoujimosumu());
                skProcessCreateInBean.setMosYmd(mainProcessSummaryBean.getMosymd());
                skProcessCreateInBean.setJimuStartYmd(mainProcessSummaryBean.getJimuStartYmdTime());
                skProcessCreateInBean.setSyoNo(mainProcessSummaryBean.getSyoNo());
                skProcessCreateInBean.setMosNo(mainProcessSummaryBean.getMosNo());
                skProcessCreateInBean.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKHENKIN);

                skProcessCreate.exec(skProcessCreateInBean);

                bzGetProcessSummaryInBean.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKHENKIN);
                bzGetProcessSummaryInBean.setKouteiKanriStatuss(C_Kouteikanristatus.SYORITYUU);
                bzGetProcessSummaryInBean.setMosNo(mainProcessMosNo);

                bzGetProcessSummaryOutBeanLst = bzGetProcessSummary.exec(bzGetProcessSummaryInBean);

                if (bzGetProcessSummaryOutBeanLst.size() > 0) {
                    syoruiSummaryBean = bzGetProcessSummaryOutBeanLst.get(0);

                    C_UmuKbn pkakinUmu = C_UmuKbn.NONE;
                    C_UmuKbn nyuukinUmu = C_UmuKbn.NONE;

                    if (syoriCTL != null) {

                        List<HT_Henkin> henkinLst = syoriCTL.getHenkinsByHnknsyoriymdNull();

                        if (henkinLst.size() == 0) {
                            pkakinUmu = C_UmuKbn.NONE;
                        }
                        else {
                            pkakinUmu = C_UmuKbn.ARI;
                        }

                        nyuukinUmu = syoriCTL.getNyknnrkumu();
                    }

                    if (C_UmuKbn.ARI.eq(pkakinUmu) && C_UmuKbn.ARI.eq(nyuukinUmu)) {
                        SkHenkinRuleBean skHenkinRuleBean = SWAKInjector.getInstance(SkHenkinRuleBean.class);

                        skHenkinRuleBean.setNyknnrkUmu(C_UmuKbn.getContentByValue(
                            C_UmuKbn.PATTERN_DEFAULT,
                            String.valueOf(nyuukinUmu)));
                        skHenkinRuleBean.setPkakinUmu(C_UmuKbn.getContentByValue(
                            C_UmuKbn.PATTERN_DEFAULT,
                            String.valueOf(pkakinUmu)));

                        BzLockProcessOutBean bzLockProcessOutBeanHenkin =
                            bzLockProcess.exec(syoruiSummaryBean.getKouteiKanriId(),
                                syoruiSummaryBean.getJimuTetuzukiCd());

                        if (C_KouteiLockKekkaKbn.SUCCESS.eq(bzLockProcessOutBeanHenkin.getKouteiLockKekkaKbn())) {
                        }
                        else {
                            throw new BizLogicException(MessageId.EBA0110);
                        }

                        bzProcessForwardInBean.setKouteiKanriId(syoruiSummaryBean.getKouteiKanriId());
                        bzProcessForwardInBean.setJimuTetuzukiCd(syoruiSummaryBean.getJimuTetuzukiCd());
                        bzProcessForwardInBean.setKouteiLockKey(bzLockProcessOutBeanHenkin.getKouteiLockKey());
                        bzProcessForwardInBean.setIwfApiRuleBean(skHenkinRuleBean);
                        bzProcessForwardInBean.setSyorikekkaKbn(C_SyorikekkaKbn.KANRYOU);
                        bzProcessForwardInBean.setProcessRecordOutYouhiKbn(C_YouhiKbn.HUYOU);

                        bzProcessForward.exec(bzProcessForwardInBean);

                        BzUnlockProcess bzUnlockProcess = SWAKInjector.getInstance(BzUnlockProcess.class);
                        bzUnlockProcess.exec(syoruiSummaryBean.getKouteiKanriId(),
                            syoruiSummaryBean.getJimuTetuzukiCd(),
                            bzLockProcessOutBeanHenkin.getKouteiLockKey());
                    }
                }
            }
        }

        BzUnlockProcess bzUnlockProcess = SWAKInjector.getInstance(BzUnlockProcess.class);
        bzUnlockProcess.exec(mainProcessSummaryBean.getKouteiKanriId(),
            mainProcessSummaryBean.getJimuTetuzukiCd(),
            bzLockProcessOutBean.getKouteiLockKey());
    }
}