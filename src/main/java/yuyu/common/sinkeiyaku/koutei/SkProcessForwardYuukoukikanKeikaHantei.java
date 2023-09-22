package yuyu.common.sinkeiyaku.koutei;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.slf4j.Logger;

import yuyu.common.biz.koutei.BzGetProcessSummary;
import yuyu.common.biz.koutei.BzGetProcessSummaryInBean;
import yuyu.common.biz.koutei.BzGetProcessSummaryOutBean;
import yuyu.common.biz.koutei.BzProcessForwardForBatch;
import yuyu.common.biz.koutei.BzProcessForwardForBatchInBean;
import yuyu.common.sinkeiyaku.skcommon.ISkCommonKoumoku;
import yuyu.def.classification.C_HubihassintnsKbn;
import yuyu.def.classification.C_HubikaisyoujoutaiKbn;
import yuyu.def.classification.C_ImusateijyouKbn;
import yuyu.def.classification.C_KetteiKbn;
import yuyu.def.classification.C_KnkysateijyouKbn;
import yuyu.def.classification.C_Kouteikanristatus;
import yuyu.def.classification.C_KykkakjkKbn;
import yuyu.def.classification.C_LincjkKbn;
import yuyu.def.classification.C_MosUketukeKbn;
import yuyu.def.classification.C_MostenkenjyouKbn;
import yuyu.def.classification.C_MostenkenyhKbn;
import yuyu.def.classification.C_SateijtKbn;
import yuyu.def.classification.C_SeirituKbn;
import yuyu.def.classification.C_SkkouteikanryouKbn;
import yuyu.def.classification.C_SntkhouKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_VrfjkKbn;

/**
 * 新契約 工程 新契約工程遷移（有効期間経過契約判定処理）
 */
public class SkProcessForwardYuukoukikanKeikaHantei {

    @Inject
    private static Logger logger;

    public SkProcessForwardYuukoukikanKeikaHantei() {
        super();
    }

    public void exec(List<SkProcessForwardForBatchInBean> pSkProcessForwardForBatchInBeanList) {

        logger.debug("▽ 新契約工程遷移（有効期間経過契約判定処理） 開始");

        List<BzProcessForwardForBatchInBean> bzProcessForwardForBatchInBeanList = new ArrayList<>();

        BzProcessForwardForBatchInBean bzProcessForwardForBatchInBean;

        BzGetProcessSummary bzGetProcessSummary = SWAKInjector.getInstance(BzGetProcessSummary.class);

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean;

        List<BzGetProcessSummaryOutBean> bzGetProcessSummaryOutBeanList = new ArrayList<>();

        BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean = SWAKInjector
            .getInstance(BzGetProcessSummaryOutBean.class);

        BzProcessForwardForBatch bzProcessForwardForBatch = SWAKInjector.getInstance(BzProcessForwardForBatch.class);

        SkMainDairitenRuleBean skMainDairitenRuleBean;
        SkInputKokutiRuleBean skInputKokutiRuleBean;
        SkTenkenRuleBean skTenkenRuleBean;
        SkKankyouRuleBean skKankyouRuleBean;
        SkImuRuleBean skImuRuleBean;
        SkHubiTourokuRuleBean skHubiTourokuRuleBean;
        SkHubiKaisyouRuleBean skHubiKaisyouRuleBean;
        SkKeiyakukakuninRuleBean skKeiyakukakuninRuleBean;
        SkTorikesiRuleBean skTorikesiRuleBean;

        C_MostenkenyhKbn mostenkenyhKbn = C_MostenkenyhKbn.NONE;
        C_UmuKbn hubitourokuUmu = C_UmuKbn.NONE;

        for (SkProcessForwardForBatchInBean skProcessForwardForBatchInBean : pSkProcessForwardForBatchInBeanList) {

            if (C_MostenkenyhKbn.YOU.eq(skProcessForwardForBatchInBean.getHtSyoriCTL().getMostenken1jiyhkbn()) ||
                C_MostenkenyhKbn.YOU.eq(skProcessForwardForBatchInBean.getHtSyoriCTL().getMostenken2jiyhkbn()) ) {

                mostenkenyhKbn = C_MostenkenyhKbn.YOU;
            }
            else {
                mostenkenyhKbn = C_MostenkenyhKbn.HUYOU;
            }

            hubitourokuUmu = skProcessForwardForBatchInBean.getSkHubiDetailUmu();

            bzGetProcessSummaryInBean = SWAKInjector.getInstance(BzGetProcessSummaryInBean.class);

            skMainDairitenRuleBean = SWAKInjector.getInstance(SkMainDairitenRuleBean.class);

            bzProcessForwardForBatchInBean = SWAKInjector.getInstance(BzProcessForwardForBatchInBean.class);

            bzGetProcessSummaryInBean.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN);
            bzGetProcessSummaryInBean.setKouteiKanriStatuss(C_Kouteikanristatus.SYORITYUU);
            bzGetProcessSummaryInBean.setMosNo(skProcessForwardForBatchInBean.getHtSyoriCTL().getMosno());

            bzGetProcessSummaryOutBeanList = bzGetProcessSummary.exec(bzGetProcessSummaryInBean);

            bzGetProcessSummaryOutBean = bzGetProcessSummaryOutBeanList.get(0);

            skMainDairitenRuleBean.setSkkouteikanryouKbn(C_SkkouteikanryouKbn.getContentByValue(
                C_SkkouteikanryouKbn.PATTERN_DEFAULT,
                String.valueOf(C_SkkouteikanryouKbn.SYORITYUU)));
            skMainDairitenRuleBean.setSeirituKbn(C_SeirituKbn.getContentByValue(
                C_SeirituKbn.PATTERN_DEFAULT,
                String.valueOf(skProcessForwardForBatchInBean.getHtSyoriCTL().getSeiritukbn())));
            skMainDairitenRuleBean.setMosnrkUmu(C_UmuKbn.getContentByValue(
                C_UmuKbn.PATTERN_DEFAULT,
                String.valueOf(skProcessForwardForBatchInBean.getHtSyoriCTL().getMosnrkumu())));
            skMainDairitenRuleBean.setSntkhouKbn(C_SntkhouKbn.getContentByValue(
                C_SntkhouKbn.PATTERN_DEFAULT,
                String.valueOf(skProcessForwardForBatchInBean.getHtSyoriCTL().getMosKihon().getSntkhoukbn())));
            skMainDairitenRuleBean.setKktnrkUmu(C_UmuKbn.getContentByValue(
                C_UmuKbn.PATTERN_DEFAULT,
                String.valueOf(skProcessForwardForBatchInBean.getHtSyoriCTL().getKktnrkumu())));
            skMainDairitenRuleBean.setKktnrkvrfjkKbn(C_VrfjkKbn.getContentByValue(
                C_VrfjkKbn.PATTERN_DEFAULT,
                String.valueOf(skProcessForwardForBatchInBean.getHtSyoriCTL().getKktnrkvrfjkkbn())));
            skMainDairitenRuleBean.setMostenkenjouKbn(C_MostenkenjyouKbn.getContentByValue(
                C_MostenkenjyouKbn.PATTERN_DEFAULT,
                String.valueOf(skProcessForwardForBatchInBean.getHtSyoriCTL().getMostenkenjoukbn())));
            skMainDairitenRuleBean.setKetteiKbn(C_KetteiKbn.getContentByValue(
                C_KetteiKbn.PATTERN_DEFAULT,
                String.valueOf(skProcessForwardForBatchInBean.getHtSyoriCTL().getKetteikbn())));
            skMainDairitenRuleBean.setSateijtKbn(C_SateijtKbn.getContentByValue(
                C_SateijtKbn.PATTERN_DEFAULT,
                String.valueOf(skProcessForwardForBatchInBean.getHtSyoriCTL().getSateijtkbn())));
            skMainDairitenRuleBean.setSrhhbKbn(C_UmuKbn.getContentByValue(
                C_UmuKbn.PATTERN_DEFAULT,
                String.valueOf(skProcessForwardForBatchInBean.getHtSyoriCTL().getSrhhbkbn())));

            bzProcessForwardForBatchInBean.setKouteiKanriId(bzGetProcessSummaryOutBean.getKouteiKanriId());
            bzProcessForwardForBatchInBean.setJimuTetuzukiCd(bzGetProcessSummaryOutBean.getJimuTetuzukiCd());
            bzProcessForwardForBatchInBean.setTaskNm(skProcessForwardForBatchInBean.getTskNm());
            bzProcessForwardForBatchInBean.setSyoriComment(skProcessForwardForBatchInBean.getSyoriComment());
            bzProcessForwardForBatchInBean.setIwfApiRuleBean(skMainDairitenRuleBean);

            bzProcessForwardForBatchInBeanList.add(bzProcessForwardForBatchInBean);

            bzGetProcessSummaryInBean = SWAKInjector.getInstance(BzGetProcessSummaryInBean.class);

            skInputKokutiRuleBean = SWAKInjector.getInstance(SkInputKokutiRuleBean.class);

            bzProcessForwardForBatchInBean = SWAKInjector.getInstance(BzProcessForwardForBatchInBean.class);

            bzGetProcessSummaryInBean.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKINPUTKOKUTI);
            bzGetProcessSummaryInBean.setKouteiKanriStatuss(C_Kouteikanristatus.SYORITYUU);
            bzGetProcessSummaryInBean.setMosNo(skProcessForwardForBatchInBean.getHtSyoriCTL().getMosno());

            bzGetProcessSummaryOutBeanList = bzGetProcessSummary.exec(bzGetProcessSummaryInBean);

            bzGetProcessSummaryOutBean = bzGetProcessSummaryOutBeanList.get(0);

            skInputKokutiRuleBean.setSkkouteikanryouKbn(C_SkkouteikanryouKbn.getContentByValue(
                C_SkkouteikanryouKbn.PATTERN_DEFAULT,
                String.valueOf(C_SkkouteikanryouKbn.SYORITYUU)));
            skInputKokutiRuleBean.setSeirituKbn(C_SeirituKbn.getContentByValue(
                C_SeirituKbn.PATTERN_DEFAULT,
                String.valueOf(skProcessForwardForBatchInBean.getHtSyoriCTL().getSeiritukbn())));
            skInputKokutiRuleBean.setMosnrkUmu(C_UmuKbn.getContentByValue(
                C_UmuKbn.PATTERN_DEFAULT,
                String.valueOf(skProcessForwardForBatchInBean.getHtSyoriCTL().getMosnrkumu())));
            skInputKokutiRuleBean.setMosuketukeKbn(C_MosUketukeKbn.getContentByValue(
                C_MosUketukeKbn.PATTERN_DEFAULT,
                String.valueOf(skProcessForwardForBatchInBean.getHtSyoriCTL().getMosuketukekbn())));
            skInputKokutiRuleBean.setSntkhouKbn(C_SntkhouKbn.getContentByValue(
                C_SntkhouKbn.PATTERN_DEFAULT,
                String.valueOf(skProcessForwardForBatchInBean.getHtSyoriCTL().getMosKihon().getSntkhoukbn())));
            skInputKokutiRuleBean.setKktnrkvrfjkKbn(C_VrfjkKbn.getContentByValue(
                C_VrfjkKbn.PATTERN_DEFAULT,
                String.valueOf(skProcessForwardForBatchInBean.getHtSyoriCTL().getKktnrkvrfjkkbn())));

            bzProcessForwardForBatchInBean.setKouteiKanriId(bzGetProcessSummaryOutBean.getKouteiKanriId());
            bzProcessForwardForBatchInBean.setJimuTetuzukiCd(bzGetProcessSummaryOutBean.getJimuTetuzukiCd());
            bzProcessForwardForBatchInBean.setIwfApiRuleBean(skInputKokutiRuleBean);

            bzProcessForwardForBatchInBeanList.add(bzProcessForwardForBatchInBean);

            bzGetProcessSummaryInBean = SWAKInjector.getInstance(BzGetProcessSummaryInBean.class);

            skTenkenRuleBean = SWAKInjector.getInstance(SkTenkenRuleBean.class);

            bzProcessForwardForBatchInBean = SWAKInjector.getInstance(BzProcessForwardForBatchInBean.class);

            bzGetProcessSummaryInBean.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKTENKEN);
            bzGetProcessSummaryInBean.setKouteiKanriStatuss(C_Kouteikanristatus.SYORITYUU);
            bzGetProcessSummaryInBean.setMosNo(skProcessForwardForBatchInBean.getHtSyoriCTL().getMosno());

            bzGetProcessSummaryOutBeanList = bzGetProcessSummary.exec(bzGetProcessSummaryInBean);

            bzGetProcessSummaryOutBean = bzGetProcessSummaryOutBeanList.get(0);

            skTenkenRuleBean.setSkkouteikanryouKbn(C_SkkouteikanryouKbn.getContentByValue(
                C_SkkouteikanryouKbn.PATTERN_DEFAULT,
                String.valueOf(C_SkkouteikanryouKbn.SYORITYUU)));
            skTenkenRuleBean.setSeirituKbn(C_SeirituKbn.getContentByValue(
                C_SeirituKbn.PATTERN_DEFAULT,
                String.valueOf(skProcessForwardForBatchInBean.getHtSyoriCTL().getSeiritukbn())));
            skTenkenRuleBean.setMosnrkUmu(C_UmuKbn.getContentByValue(
                C_UmuKbn.PATTERN_DEFAULT,
                String.valueOf(skProcessForwardForBatchInBean.getHtSyoriCTL().getMosnrkumu())));
            skTenkenRuleBean.setSntkhouKbn(C_SntkhouKbn.getContentByValue(
                C_SntkhouKbn.PATTERN_DEFAULT,
                String.valueOf(skProcessForwardForBatchInBean.getHtSyoriCTL().getMosKihon().getSntkhoukbn())));
            skTenkenRuleBean.setKktnrkUmu(C_UmuKbn.getContentByValue(
                C_UmuKbn.PATTERN_DEFAULT,
                String.valueOf(skProcessForwardForBatchInBean.getHtSyoriCTL().getKktnrkumu())));
            skTenkenRuleBean.setKktnrkvrfjkKbn(C_VrfjkKbn.getContentByValue(
                C_VrfjkKbn.PATTERN_DEFAULT,
                String.valueOf(skProcessForwardForBatchInBean.getHtSyoriCTL().getKktnrkvrfjkkbn())));
            skTenkenRuleBean.setMostenkenjouKbn(C_MostenkenjyouKbn.getContentByValue(
                C_MostenkenjyouKbn.PATTERN_DEFAULT,
                String.valueOf(skProcessForwardForBatchInBean.getHtSyoriCTL().getMostenkenjoukbn())));

            bzProcessForwardForBatchInBean.setKouteiKanriId(bzGetProcessSummaryOutBean.getKouteiKanriId());
            bzProcessForwardForBatchInBean.setJimuTetuzukiCd(bzGetProcessSummaryOutBean.getJimuTetuzukiCd());
            bzProcessForwardForBatchInBean.setIwfApiRuleBean(skTenkenRuleBean);

            bzProcessForwardForBatchInBeanList.add(bzProcessForwardForBatchInBean);

            bzGetProcessSummaryInBean = SWAKInjector.getInstance(BzGetProcessSummaryInBean.class);

            skKankyouRuleBean = SWAKInjector.getInstance(SkKankyouRuleBean.class);

            bzProcessForwardForBatchInBean = SWAKInjector.getInstance(BzProcessForwardForBatchInBean.class);

            bzGetProcessSummaryInBean.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKKANKYOU);
            bzGetProcessSummaryInBean.setKouteiKanriStatuss(C_Kouteikanristatus.SYORITYUU);
            bzGetProcessSummaryInBean.setMosNo(skProcessForwardForBatchInBean.getHtSyoriCTL().getMosno());

            bzGetProcessSummaryOutBeanList = bzGetProcessSummary.exec(bzGetProcessSummaryInBean);

            bzGetProcessSummaryOutBean = bzGetProcessSummaryOutBeanList.get(0);

            skKankyouRuleBean.setSkkouteikanryouKbn(C_SkkouteikanryouKbn.getContentByValue(
                C_SkkouteikanryouKbn.PATTERN_DEFAULT,
                String.valueOf(C_SkkouteikanryouKbn.SYORITYUU)));
            skKankyouRuleBean.setSeirituKbn(C_SeirituKbn.getContentByValue(
                C_SeirituKbn.PATTERN_DEFAULT,
                String.valueOf(skProcessForwardForBatchInBean.getHtSyoriCTL().getSeiritukbn())));
            skKankyouRuleBean.setMostenkenyhKbn(C_MostenkenyhKbn.getContentByValue(
                C_MostenkenyhKbn.PATTERN_DEFAULT,
                String.valueOf(mostenkenyhKbn)));
            skKankyouRuleBean.setMostenkenjouKbn(C_MostenkenjyouKbn.getContentByValue(
                C_MostenkenjyouKbn.PATTERN_DEFAULT,
                String.valueOf(skProcessForwardForBatchInBean.getHtSyoriCTL().getMostenkenjoukbn())));
            skKankyouRuleBean.setKnkysateijyouKbn(C_KnkysateijyouKbn.getContentByValue(
                C_KnkysateijyouKbn.PATTERN_DEFAULT,
                String.valueOf(skProcessForwardForBatchInBean.getHtSyoriCTL().getKnkysateijyoukbn())));
            skKankyouRuleBean.setKthhbKbn(C_UmuKbn.getContentByValue(
                C_UmuKbn.PATTERN_DEFAULT,
                String.valueOf(skProcessForwardForBatchInBean.getHtSyoriCTL().getKthhbkbn())));
            skKankyouRuleBean.setLincjkKbn(C_LincjkKbn.getContentByValue(
                C_LincjkKbn.PATTERN_DEFAULT,
                String.valueOf(skProcessForwardForBatchInBean.getHtSyoriCTL().getLincjkkbn())));

            bzProcessForwardForBatchInBean.setKouteiKanriId(bzGetProcessSummaryOutBean.getKouteiKanriId());
            bzProcessForwardForBatchInBean.setJimuTetuzukiCd(bzGetProcessSummaryOutBean.getJimuTetuzukiCd());
            bzProcessForwardForBatchInBean.setIwfApiRuleBean(skKankyouRuleBean);

            bzProcessForwardForBatchInBeanList.add(bzProcessForwardForBatchInBean);

            bzGetProcessSummaryInBean = SWAKInjector.getInstance(BzGetProcessSummaryInBean.class);

            skImuRuleBean = SWAKInjector.getInstance(SkImuRuleBean.class);

            bzProcessForwardForBatchInBean = SWAKInjector.getInstance(BzProcessForwardForBatchInBean.class);

            bzGetProcessSummaryInBean.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKIMU);
            bzGetProcessSummaryInBean.setKouteiKanriStatuss(C_Kouteikanristatus.SYORITYUU);
            bzGetProcessSummaryInBean.setMosNo(skProcessForwardForBatchInBean.getHtSyoriCTL().getMosno());

            bzGetProcessSummaryOutBeanList = bzGetProcessSummary.exec(bzGetProcessSummaryInBean);

            bzGetProcessSummaryOutBean = bzGetProcessSummaryOutBeanList.get(0);

            skImuRuleBean.setSkkouteikanryouKbn(C_SkkouteikanryouKbn.getContentByValue(
                C_SkkouteikanryouKbn.PATTERN_DEFAULT,
                String.valueOf(C_SkkouteikanryouKbn.SYORITYUU)));
            skImuRuleBean.setSeirituKbn(C_SeirituKbn.getContentByValue(
                C_SeirituKbn.PATTERN_DEFAULT,
                String.valueOf(skProcessForwardForBatchInBean.getHtSyoriCTL().getSeiritukbn())));
            skImuRuleBean.setMostenkenyhKbn(C_MostenkenyhKbn.getContentByValue(
                C_MostenkenyhKbn.PATTERN_DEFAULT,
                String.valueOf(mostenkenyhKbn)));
            skImuRuleBean.setMostenkenjouKbn(C_MostenkenjyouKbn.getContentByValue(
                C_MostenkenjyouKbn.PATTERN_DEFAULT,
                String.valueOf(skProcessForwardForBatchInBean.getHtSyoriCTL().getMostenkenjoukbn())));
            skImuRuleBean.setImusateijyouKbn(C_ImusateijyouKbn.getContentByValue(
                C_ImusateijyouKbn.PATTERN_DEFAULT,
                String.valueOf(skProcessForwardForBatchInBean.getHtSyoriCTL().getImusateijyoukbn())));
            skImuRuleBean.setKthhbKbn(C_UmuKbn.getContentByValue(
                C_UmuKbn.PATTERN_DEFAULT,
                String.valueOf(skProcessForwardForBatchInBean.getHtSyoriCTL().getKthhbkbn())));

            bzProcessForwardForBatchInBean.setKouteiKanriId(bzGetProcessSummaryOutBean.getKouteiKanriId());
            bzProcessForwardForBatchInBean.setJimuTetuzukiCd(bzGetProcessSummaryOutBean.getJimuTetuzukiCd());
            bzProcessForwardForBatchInBean.setIwfApiRuleBean(skImuRuleBean);

            bzProcessForwardForBatchInBeanList.add(bzProcessForwardForBatchInBean);

            bzGetProcessSummaryInBean = SWAKInjector.getInstance(BzGetProcessSummaryInBean.class);

            skHubiTourokuRuleBean = SWAKInjector.getInstance(SkHubiTourokuRuleBean.class);

            bzProcessForwardForBatchInBean = SWAKInjector.getInstance(BzProcessForwardForBatchInBean.class);

            bzGetProcessSummaryInBean.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKHUBITOUROKU);
            bzGetProcessSummaryInBean.setKouteiKanriStatuss(C_Kouteikanristatus.SYORITYUU);
            bzGetProcessSummaryInBean.setMosNo(skProcessForwardForBatchInBean.getHtSyoriCTL().getMosno());

            bzGetProcessSummaryOutBeanList = bzGetProcessSummary.exec(bzGetProcessSummaryInBean);

            bzGetProcessSummaryOutBean = bzGetProcessSummaryOutBeanList.get(0);

            skHubiTourokuRuleBean.setSkkouteikanryouKbn(C_SkkouteikanryouKbn.getContentByValue(
                C_SkkouteikanryouKbn.PATTERN_DEFAULT,
                String.valueOf(C_SkkouteikanryouKbn.SYORITYUU)));
            skHubiTourokuRuleBean.setSeirituKbn(C_SeirituKbn.getContentByValue(
                C_SeirituKbn.PATTERN_DEFAULT,
                String.valueOf(skProcessForwardForBatchInBean.getHtSyoriCTL().getSeiritukbn())));
            skHubiTourokuRuleBean.setMostenkenyhKbn(C_MostenkenyhKbn.getContentByValue(
                C_MostenkenyhKbn.PATTERN_DEFAULT,
                String.valueOf(mostenkenyhKbn)));
            skHubiTourokuRuleBean.setMostenkenjouKbn(C_MostenkenjyouKbn.getContentByValue(
                C_MostenkenjyouKbn.PATTERN_DEFAULT,
                String.valueOf(skProcessForwardForBatchInBean.getHtSyoriCTL().getMostenkenjoukbn())));
            skHubiTourokuRuleBean.setMihassinhubiUmu(C_UmuKbn.getContentByValue(
                C_UmuKbn.PATTERN_DEFAULT,
                String.valueOf(skProcessForwardForBatchInBean.getHtSyoriCTL().getMihassinhubiumu())));
            skHubiTourokuRuleBean.setHubihassintnsUmu(C_HubihassintnsKbn.getContentByValue(
                C_HubihassintnsKbn.PATTERN_DEFAULT,
                String.valueOf(C_HubihassintnsKbn.BLNK)));
            skHubiTourokuRuleBean.setHubitourokuUmu(C_UmuKbn.getContentByValue(
                C_UmuKbn.PATTERN_DEFAULT,
                String.valueOf(hubitourokuUmu)));
            skHubiTourokuRuleBean.setKthhbKbn(C_UmuKbn.getContentByValue(
                C_UmuKbn.PATTERN_DEFAULT,
                String.valueOf(skProcessForwardForBatchInBean.getHtSyoriCTL().getKthhbkbn())));

            bzProcessForwardForBatchInBean.setKouteiKanriId(bzGetProcessSummaryOutBean.getKouteiKanriId());
            bzProcessForwardForBatchInBean.setJimuTetuzukiCd(bzGetProcessSummaryOutBean.getJimuTetuzukiCd());
            bzProcessForwardForBatchInBean.setIwfApiRuleBean(skHubiTourokuRuleBean);

            bzProcessForwardForBatchInBeanList.add(bzProcessForwardForBatchInBean);

            bzGetProcessSummaryInBean = SWAKInjector.getInstance(BzGetProcessSummaryInBean.class);

            skHubiKaisyouRuleBean = SWAKInjector.getInstance(SkHubiKaisyouRuleBean.class);

            bzProcessForwardForBatchInBean = SWAKInjector.getInstance(BzProcessForwardForBatchInBean.class);

            bzGetProcessSummaryInBean.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKHUBIKAISYOU);
            bzGetProcessSummaryInBean.setKouteiKanriStatuss(C_Kouteikanristatus.SYORITYUU);
            bzGetProcessSummaryInBean.setMosNo(skProcessForwardForBatchInBean.getHtSyoriCTL().getMosno());

            bzGetProcessSummaryOutBeanList = bzGetProcessSummary.exec(bzGetProcessSummaryInBean);

            if (bzGetProcessSummaryOutBeanList.size() > 0) {

                bzGetProcessSummaryOutBean = bzGetProcessSummaryOutBeanList.get(0);

                skHubiKaisyouRuleBean.setSkkouteikanryouKbn(C_SkkouteikanryouKbn.getContentByValue(
                    C_SkkouteikanryouKbn.PATTERN_DEFAULT,
                    String.valueOf(C_SkkouteikanryouKbn.SYORITYUU)));
                skHubiKaisyouRuleBean.setSeirituKbn(C_SeirituKbn.getContentByValue(
                    C_SeirituKbn.PATTERN_DEFAULT,
                    String.valueOf(skProcessForwardForBatchInBean.getHtSyoriCTL().getSeiritukbn())));
                skHubiKaisyouRuleBean.setHubikaisyoujoutaiKbn(C_HubikaisyoujoutaiKbn.getContentByValue(
                    C_HubikaisyoujoutaiKbn.PATTERN_DEFAULT,
                    String.valueOf(skProcessForwardForBatchInBean.getHtSyoriCTL().getHubikaisyoujoutaikbn())));

                bzProcessForwardForBatchInBean.setKouteiKanriId(bzGetProcessSummaryOutBean.getKouteiKanriId());
                bzProcessForwardForBatchInBean.setJimuTetuzukiCd(bzGetProcessSummaryOutBean.getJimuTetuzukiCd());
                bzProcessForwardForBatchInBean.setIwfApiRuleBean(skHubiKaisyouRuleBean);

                bzProcessForwardForBatchInBeanList.add(bzProcessForwardForBatchInBean);
            }

            bzGetProcessSummaryInBean = SWAKInjector.getInstance(BzGetProcessSummaryInBean.class);

            skKeiyakukakuninRuleBean = SWAKInjector.getInstance(SkKeiyakukakuninRuleBean.class);

            bzProcessForwardForBatchInBean = SWAKInjector.getInstance(BzProcessForwardForBatchInBean.class);

            bzGetProcessSummaryInBean.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKKEIYAKUKAKUNIN);
            bzGetProcessSummaryInBean.setKouteiKanriStatuss(C_Kouteikanristatus.SYORITYUU);
            bzGetProcessSummaryInBean.setMosNo(skProcessForwardForBatchInBean.getHtSyoriCTL().getMosno());

            bzGetProcessSummaryOutBeanList = bzGetProcessSummary.exec(bzGetProcessSummaryInBean);

            if (bzGetProcessSummaryOutBeanList.size() > 0) {

                bzGetProcessSummaryOutBean = bzGetProcessSummaryOutBeanList.get(0);

                skKeiyakukakuninRuleBean.setSkkouteikanryouKbn(C_SkkouteikanryouKbn.getContentByValue(
                    C_SkkouteikanryouKbn.PATTERN_DEFAULT,
                    String.valueOf(C_SkkouteikanryouKbn.SYORITYUU)));
                skKeiyakukakuninRuleBean.setSeirituKbn(C_SeirituKbn.getContentByValue(
                    C_SeirituKbn.PATTERN_DEFAULT,
                    String.valueOf(skProcessForwardForBatchInBean.getHtSyoriCTL().getSeiritukbn())));
                skKeiyakukakuninRuleBean.setKetteiKbn(C_KetteiKbn.getContentByValue(
                    C_KetteiKbn.PATTERN_DEFAULT,
                    String.valueOf(skProcessForwardForBatchInBean.getHtSyoriCTL().getKetteikbn())));
                skKeiyakukakuninRuleBean.setKykkakjkKbn(C_KykkakjkKbn.getContentByValue(
                    C_KykkakjkKbn.PATTERN_DEFAULT,
                    String.valueOf(skProcessForwardForBatchInBean.getHtSyoriCTL().getKykkakjkkbn())));

                bzProcessForwardForBatchInBean.setKouteiKanriId(bzGetProcessSummaryOutBean.getKouteiKanriId());
                bzProcessForwardForBatchInBean.setJimuTetuzukiCd(bzGetProcessSummaryOutBean.getJimuTetuzukiCd());
                bzProcessForwardForBatchInBean.setIwfApiRuleBean(skKeiyakukakuninRuleBean);

                bzProcessForwardForBatchInBeanList.add(bzProcessForwardForBatchInBean);
            }

            bzGetProcessSummaryInBean = SWAKInjector.getInstance(BzGetProcessSummaryInBean.class);

            skTorikesiRuleBean = SWAKInjector.getInstance(SkTorikesiRuleBean.class);

            bzProcessForwardForBatchInBean = SWAKInjector.getInstance(BzProcessForwardForBatchInBean.class);

            bzGetProcessSummaryInBean.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKTORIKESI);
            bzGetProcessSummaryInBean.setKouteiKanriStatuss(C_Kouteikanristatus.SYORITYUU);
            bzGetProcessSummaryInBean.setMosNo(skProcessForwardForBatchInBean.getHtSyoriCTL().getMosno());

            bzGetProcessSummaryOutBeanList = bzGetProcessSummary.exec(bzGetProcessSummaryInBean);

            if (bzGetProcessSummaryOutBeanList.size() > 0) {

                bzGetProcessSummaryOutBean = bzGetProcessSummaryOutBeanList.get(0);

                skTorikesiRuleBean.setSkkouteikanryouKbn(C_SkkouteikanryouKbn.getContentByValue(
                    C_SkkouteikanryouKbn.PATTERN_DEFAULT,
                    String.valueOf(C_SkkouteikanryouKbn.SYORITYUU)));
                skTorikesiRuleBean.setSeirituKbn(C_SeirituKbn.getContentByValue(
                    C_SeirituKbn.PATTERN_DEFAULT,
                    String.valueOf(skProcessForwardForBatchInBean.getHtSyoriCTL().getSeiritukbn())));
                skTorikesiRuleBean.setMosnrkUmu(C_UmuKbn.getContentByValue(
                    C_UmuKbn.PATTERN_DEFAULT,
                    String.valueOf(skProcessForwardForBatchInBean.getHtSyoriCTL().getMosnrkumu())));

                bzProcessForwardForBatchInBean.setKouteiKanriId(bzGetProcessSummaryOutBean.getKouteiKanriId());
                bzProcessForwardForBatchInBean.setJimuTetuzukiCd(bzGetProcessSummaryOutBean.getJimuTetuzukiCd());
                bzProcessForwardForBatchInBean.setIwfApiRuleBean(skTorikesiRuleBean);

                bzProcessForwardForBatchInBeanList.add(bzProcessForwardForBatchInBean);
            }

        }

        bzProcessForwardForBatch.exec(bzProcessForwardForBatchInBeanList);

        logger.debug("△ 新契約工程遷移（有効期間経過契約判定処理） 終了");
    }
}
