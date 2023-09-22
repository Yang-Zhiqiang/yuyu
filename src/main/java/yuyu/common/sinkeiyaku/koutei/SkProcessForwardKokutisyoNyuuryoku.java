package yuyu.common.sinkeiyaku.koutei;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.slf4j.Logger;

import yuyu.common.biz.koutei.BzGetProcessSummary;
import yuyu.common.biz.koutei.BzGetProcessSummaryInBean;
import yuyu.common.biz.koutei.BzGetProcessSummaryOutBean;
import yuyu.common.biz.koutei.BzOutputProcessRecord;
import yuyu.common.biz.koutei.BzProcessForward;
import yuyu.common.biz.koutei.BzProcessForwardInBean;
import yuyu.common.sinkeiyaku.skcommon.ISkCommonKoumoku;
import yuyu.def.classification.C_KetteiKbn;
import yuyu.def.classification.C_Kouteikanristatus;
import yuyu.def.classification.C_MosUketukeKbn;
import yuyu.def.classification.C_MostenkenjyouKbn;
import yuyu.def.classification.C_SateijtKbn;
import yuyu.def.classification.C_SeirituKbn;
import yuyu.def.classification.C_SkkinouModeIdKbn;
import yuyu.def.classification.C_SkkouteikanryouKbn;
import yuyu.def.classification.C_SntkhouKbn;
import yuyu.def.classification.C_SyorikekkaKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_VrfjkKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.db.entity.HT_MosKihon;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;

/**
 * 新契約 工程 新契約工程遷移（告知書入力）
 */
public class SkProcessForwardKokutisyoNyuuryoku {

    @Inject
    private static Logger logger;

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    public SkProcessForwardKokutisyoNyuuryoku() {
        super();
    }

    public void exec(SkProcessForwardInBean pSkProcessForwardInBean) {

        logger.debug("▽ 新契約工程遷移（告知書入力） 開始");

        BzGetProcessSummary bzGetProcessSummary = SWAKInjector.getInstance(BzGetProcessSummary.class);
        BzProcessForward bzProcessForward = SWAKInjector.getInstance(BzProcessForward.class);
        BzOutputProcessRecord bzOutputProcessRecord = SWAKInjector.getInstance(BzOutputProcessRecord.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(pSkProcessForwardInBean.getMosNo());

        HT_MosKihon mosKihon = syoriCTL.getMosKihon();

        if (C_SkkinouModeIdKbn.KOKUTISYO_1JI.getContent().equals(pSkProcessForwardInBean.getTskNm()) ||
            C_SkkinouModeIdKbn.KOKUTISYO_2JI.getContent().equals(pSkProcessForwardInBean.getTskNm()) ||
            C_SkkinouModeIdKbn.KOKUTISYO_3JI.getContent().equals(pSkProcessForwardInBean.getTskNm())) {

            BzGetProcessSummaryInBean bzGetProcessSummaryInBean = SWAKInjector
                .getInstance(BzGetProcessSummaryInBean.class);

            SkMainDairitenRuleBean skMainDairitenRuleBean = SWAKInjector.getInstance(SkMainDairitenRuleBean.class);

            BzProcessForwardInBean bzProcessForwardInBean = SWAKInjector.getInstance(BzProcessForwardInBean.class);

            bzGetProcessSummaryInBean.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN);
            bzGetProcessSummaryInBean.setKouteiKanriStatuss(C_Kouteikanristatus.SYORITYUU);
            bzGetProcessSummaryInBean.setMosNo(pSkProcessForwardInBean.getMosNo());

            List<BzGetProcessSummaryOutBean> bzGetProcessSummaryOutBeanList = bzGetProcessSummary
                .exec(bzGetProcessSummaryInBean);

            BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean = bzGetProcessSummaryOutBeanList.get(0);

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
                String.valueOf(mosKihon.getSntkhoukbn())));
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
                String.valueOf(syoriCTL.getSrhhbkbn())));

            bzProcessForwardInBean.setKouteiKanriId(bzGetProcessSummaryOutBean.getKouteiKanriId());
            bzProcessForwardInBean.setJimuTetuzukiCd(bzGetProcessSummaryOutBean.getJimuTetuzukiCd());
            bzProcessForwardInBean.setKouteiLockKey(pSkProcessForwardInBean.getKouteiLockkey());
            bzProcessForwardInBean.setIwfApiRuleBean(skMainDairitenRuleBean);
            bzProcessForwardInBean.setSyorikekkaKbn(C_SyorikekkaKbn.BLNK);
            bzProcessForwardInBean.setProcessRecordOutYouhiKbn(C_YouhiKbn.HUYOU);

            bzProcessForward.exec(bzProcessForwardInBean);

            bzGetProcessSummaryInBean = SWAKInjector.getInstance(BzGetProcessSummaryInBean.class);

            SkInputKokutiRuleBean skInputKokutiRuleBean = SWAKInjector.getInstance(SkInputKokutiRuleBean.class);

            bzProcessForwardInBean = SWAKInjector.getInstance(BzProcessForwardInBean.class);

            bzGetProcessSummaryInBean.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKINPUTKOKUTI);
            bzGetProcessSummaryInBean.setKouteiKanriStatuss(C_Kouteikanristatus.SYORITYUU);
            bzGetProcessSummaryInBean.setMosNo(pSkProcessForwardInBean.getMosNo());

            bzGetProcessSummaryOutBeanList = bzGetProcessSummary.exec(bzGetProcessSummaryInBean);

            bzGetProcessSummaryOutBean = bzGetProcessSummaryOutBeanList.get(0);

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
                String.valueOf(mosKihon.getSntkhoukbn())));
            skInputKokutiRuleBean.setKktnrkvrfjkKbn(C_VrfjkKbn.getContentByValue(
                C_VrfjkKbn.PATTERN_DEFAULT,
                String.valueOf(syoriCTL.getKktnrkvrfjkkbn())));

            bzProcessForwardInBean.setKouteiKanriId(bzGetProcessSummaryOutBean.getKouteiKanriId());
            bzProcessForwardInBean.setJimuTetuzukiCd(bzGetProcessSummaryOutBean.getJimuTetuzukiCd());
            bzProcessForwardInBean.setKouteiLockKey(pSkProcessForwardInBean.getKouteiLockkey());
            bzProcessForwardInBean.setIwfApiRuleBean(skInputKokutiRuleBean);
            bzProcessForwardInBean.setSyorikekkaKbn(pSkProcessForwardInBean.getSyorikekkaKbn());
            bzProcessForwardInBean.setProcessRecordOutYouhiKbn(C_YouhiKbn.HUYOU);

            bzProcessForward.exec(bzProcessForwardInBean);

            bzGetProcessSummaryInBean = SWAKInjector.getInstance(BzGetProcessSummaryInBean.class);

            SkTenkenRuleBean skTenkenRuleBean = SWAKInjector.getInstance(SkTenkenRuleBean.class);

            bzProcessForwardInBean = SWAKInjector.getInstance(BzProcessForwardInBean.class);

            bzGetProcessSummaryInBean.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKTENKEN);
            bzGetProcessSummaryInBean.setKouteiKanriStatuss(C_Kouteikanristatus.SYORITYUU);
            bzGetProcessSummaryInBean.setMosNo(pSkProcessForwardInBean.getMosNo());

            bzGetProcessSummaryOutBeanList = bzGetProcessSummary.exec(bzGetProcessSummaryInBean);

            bzGetProcessSummaryOutBean = bzGetProcessSummaryOutBeanList.get(0);

            skTenkenRuleBean.setSkkouteikanryouKbn(C_SkkouteikanryouKbn.getContentByValue(
                C_SkkouteikanryouKbn.PATTERN_DEFAULT,
                String.valueOf(C_SkkouteikanryouKbn.SYORITYUU)));
            skTenkenRuleBean.setSeirituKbn(C_SeirituKbn.getContentByValue(
                C_SeirituKbn.PATTERN_DEFAULT,
                String.valueOf(syoriCTL.getSeiritukbn())));
            skTenkenRuleBean.setMosnrkUmu(C_UmuKbn.getContentByValue(
                C_UmuKbn.PATTERN_DEFAULT,
                String.valueOf(syoriCTL.getMosnrkumu())));
            skTenkenRuleBean.setSntkhouKbn(C_SntkhouKbn.getContentByValue(
                C_SntkhouKbn.PATTERN_DEFAULT,
                String.valueOf(mosKihon.getSntkhoukbn())));
            skTenkenRuleBean.setKktnrkUmu(C_UmuKbn.getContentByValue(
                C_UmuKbn.PATTERN_DEFAULT,
                String.valueOf(syoriCTL.getKktnrkumu())));
            skTenkenRuleBean.setKktnrkvrfjkKbn(C_VrfjkKbn.getContentByValue(
                C_VrfjkKbn.PATTERN_DEFAULT,
                String.valueOf(syoriCTL.getKktnrkvrfjkkbn())));
            skTenkenRuleBean.setMostenkenjouKbn(C_MostenkenjyouKbn.getContentByValue(
                C_MostenkenjyouKbn.PATTERN_DEFAULT,
                String.valueOf(syoriCTL.getMostenkenjoukbn())));

            bzProcessForwardInBean.setKouteiKanriId(bzGetProcessSummaryOutBean.getKouteiKanriId());
            bzProcessForwardInBean.setJimuTetuzukiCd(bzGetProcessSummaryOutBean.getJimuTetuzukiCd());
            bzProcessForwardInBean.setKouteiLockKey(pSkProcessForwardInBean.getKouteiLockkey());
            bzProcessForwardInBean.setIwfApiRuleBean(skTenkenRuleBean);
            bzProcessForwardInBean.setSyorikekkaKbn(C_SyorikekkaKbn.BLNK);
            bzProcessForwardInBean.setProcessRecordOutYouhiKbn(C_YouhiKbn.HUYOU);

            bzProcessForward.exec(bzProcessForwardInBean);
        }
        else if (C_SkkinouModeIdKbn.KOKUTISYO_UPD.getContent().equals(pSkProcessForwardInBean.getTskNm())) {

            SkProcessForwardTeisei skProcessForwardTeisei = SWAKInjector.getInstance(SkProcessForwardTeisei.class);

            skProcessForwardTeisei.exec(pSkProcessForwardInBean);
        }

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean = SWAKInjector.getInstance(BzGetProcessSummaryInBean.class);

        bzGetProcessSummaryInBean.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN);
        bzGetProcessSummaryInBean.setKouteiKanriStatuss(C_Kouteikanristatus.SYORITYUU);
        bzGetProcessSummaryInBean.setMosNo(pSkProcessForwardInBean.getMosNo());

        List<BzGetProcessSummaryOutBean> bzGetProcessSummaryOutBeanList = bzGetProcessSummary
            .exec(bzGetProcessSummaryInBean);

        BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean = bzGetProcessSummaryOutBeanList.get(0);

        bzOutputProcessRecord.exec(bzGetProcessSummaryOutBean.getKouteiKanriId(),
            bzGetProcessSummaryOutBean.getJimuTetuzukiCd(),
            pSkProcessForwardInBean.getSyoriComment(),
            pSkProcessForwardInBean.getTskNm(),
            pSkProcessForwardInBean.getSyorikekkaKbn());

        logger.debug("△ 新契約工程遷移（告知書入力） 終了");
    }

}
