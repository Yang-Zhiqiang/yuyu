package yuyu.common.sinkeiyaku.koutei;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.slf4j.Logger;

import yuyu.common.biz.koutei.BzGetProcessSummary;
import yuyu.common.biz.koutei.BzGetProcessSummaryInBean;
import yuyu.common.biz.koutei.BzGetProcessSummaryOutBean;
import yuyu.common.biz.koutei.BzProcessForwardForBatchInBean;
import yuyu.common.sinkeiyaku.skcommon.ISkCommonKoumoku;
import yuyu.def.classification.C_HubihassintnsKbn;
import yuyu.def.classification.C_ImusateijyouKbn;
import yuyu.def.classification.C_KetteiKbn;
import yuyu.def.classification.C_KnkysateijyouKbn;
import yuyu.def.classification.C_Kouteikanristatus;
import yuyu.def.classification.C_LincjkKbn;
import yuyu.def.classification.C_MostenkenjyouKbn;
import yuyu.def.classification.C_MostenkenyhKbn;
import yuyu.def.classification.C_SateijtKbn;
import yuyu.def.classification.C_SeirituKbn;
import yuyu.def.classification.C_SkkouteikanryouKbn;
import yuyu.def.classification.C_SntkhouKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_VrfjkKbn;

/**
 * 新契約 工程 新契約工程遷移（決定保留不備）_バッチ用
 */
public class SkProcessForwardKetteiHoryuuHubiBatch {

    private final String SYORI_COMMENT = "決定保留不備が発生したため、申込点検（点検後不備）へ自動依頼します。";

    @Inject
    private static Logger logger;

    public SkProcessForwardKetteiHoryuuHubiBatch() {
        super();
    }

    public List<BzProcessForwardForBatchInBean> exec(SkProcessForwardForBatchInBean pSkProcessForwardForBatchInBean) {

        logger.debug("▽ 新契約工程遷移（決定保留不備）_バッチ用 開始");

        BzGetProcessSummary bzGetProcessSummary = SWAKInjector.getInstance(BzGetProcessSummary.class);

        List<BzProcessForwardForBatchInBean> bzProcessForwardForBatchInBeanList = new ArrayList<>();

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean = SWAKInjector.getInstance(BzGetProcessSummaryInBean.class);

        bzGetProcessSummaryInBean.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN);
        bzGetProcessSummaryInBean.setKouteiKanriStatuss(C_Kouteikanristatus.SYORITYUU);
        bzGetProcessSummaryInBean.setMosNo(pSkProcessForwardForBatchInBean.getHtSyoriCTL().getMosno());

        List<BzGetProcessSummaryOutBean> bzGetProcessSummaryOutBeanList = bzGetProcessSummary
            .exec(bzGetProcessSummaryInBean);

        if (bzGetProcessSummaryOutBeanList.size() == 0) {

            logger.debug("△ 新契約工程遷移（決定保留不備）_バッチ用 終了");

            return bzProcessForwardForBatchInBeanList;
        }

        BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean = bzGetProcessSummaryOutBeanList.get(0);

        if (ISkCommonKoumoku.NODEID_MOUSIKOMISYOTORIKOMI.equals(bzGetProcessSummaryOutBean.getNowNodoId()) ||
            ISkCommonKoumoku.NODEID_MOUSIKOMISYONYUURYOKU.equals(bzGetProcessSummaryOutBean.getNowNodoId()) ||
            ISkCommonKoumoku.NODEID_SYORUINYUURYOKU.equals(bzGetProcessSummaryOutBean.getNowNodoId()) ||
            ISkCommonKoumoku.NODEID_MOUSIKOMITENKEN.equals(bzGetProcessSummaryOutBean.getNowNodoId())) {

            logger.debug("△ 新契約工程遷移（決定保留不備）_バッチ用 終了");

            return bzProcessForwardForBatchInBeanList;
        }

        C_MostenkenyhKbn mostenkenyhKbn = C_MostenkenyhKbn.NONE;

        if (C_MostenkenyhKbn.YOU.eq(pSkProcessForwardForBatchInBean.getHtSyoriCTL().getMostenken1jiyhkbn()) ||
            C_MostenkenyhKbn.YOU.eq(pSkProcessForwardForBatchInBean.getHtSyoriCTL().getMostenken2jiyhkbn()) ) {

            mostenkenyhKbn = C_MostenkenyhKbn.YOU;
        }
        else {
            mostenkenyhKbn = C_MostenkenyhKbn.HUYOU;
        }

        SkMainDairitenRuleBean skMainDairitenRuleBean = SWAKInjector.getInstance(SkMainDairitenRuleBean.class);

        BzProcessForwardForBatchInBean bzProcessForwardForBatchInBean = SWAKInjector
            .getInstance(BzProcessForwardForBatchInBean.class);

        skMainDairitenRuleBean.setSkkouteikanryouKbn(C_SkkouteikanryouKbn.getContentByValue(
            C_SkkouteikanryouKbn.PATTERN_DEFAULT,
            String.valueOf(C_SkkouteikanryouKbn.SYORITYUU)));
        skMainDairitenRuleBean.setSeirituKbn(C_SeirituKbn.getContentByValue(
            C_SeirituKbn.PATTERN_DEFAULT,
            String.valueOf(pSkProcessForwardForBatchInBean.getHtSyoriCTL().getSeiritukbn())));
        skMainDairitenRuleBean.setMosnrkUmu(C_UmuKbn.getContentByValue(
            C_UmuKbn.PATTERN_DEFAULT,
            String.valueOf(pSkProcessForwardForBatchInBean.getHtSyoriCTL().getMosnrkumu())));
        skMainDairitenRuleBean.setSntkhouKbn(C_SntkhouKbn.getContentByValue(
            C_SntkhouKbn.PATTERN_DEFAULT,
            String.valueOf(pSkProcessForwardForBatchInBean.getHtSyoriCTL().getMosKihon().getSntkhoukbn())));
        skMainDairitenRuleBean.setKktnrkUmu(C_UmuKbn.getContentByValue(
            C_UmuKbn.PATTERN_DEFAULT,
            String.valueOf(pSkProcessForwardForBatchInBean.getHtSyoriCTL().getKktnrkumu())));
        skMainDairitenRuleBean.setKktnrkvrfjkKbn(C_VrfjkKbn.getContentByValue(
            C_VrfjkKbn.PATTERN_DEFAULT,
            String.valueOf(pSkProcessForwardForBatchInBean.getHtSyoriCTL().getKktnrkvrfjkkbn())));
        skMainDairitenRuleBean.setMostenkenjouKbn(C_MostenkenjyouKbn.getContentByValue(
            C_MostenkenjyouKbn.PATTERN_DEFAULT,
            String.valueOf(pSkProcessForwardForBatchInBean.getHtSyoriCTL().getMostenkenjoukbn())));
        skMainDairitenRuleBean.setKetteiKbn(C_KetteiKbn.getContentByValue(
            C_KetteiKbn.PATTERN_DEFAULT,
            String.valueOf(pSkProcessForwardForBatchInBean.getHtSyoriCTL().getKetteikbn())));
        skMainDairitenRuleBean.setSateijtKbn(C_SateijtKbn.getContentByValue(
            C_SateijtKbn.PATTERN_DEFAULT,
            String.valueOf(pSkProcessForwardForBatchInBean.getHtSyoriCTL().getSateijtkbn())));
        skMainDairitenRuleBean.setSrhhbKbn(C_UmuKbn.getContentByValue(
            C_UmuKbn.PATTERN_DEFAULT,
            String.valueOf(pSkProcessForwardForBatchInBean.getHtSyoriCTL().getSrhhbkbn())));

        bzProcessForwardForBatchInBean.setKouteiKanriId(bzGetProcessSummaryOutBean.getKouteiKanriId());
        bzProcessForwardForBatchInBean.setJimuTetuzukiCd(bzGetProcessSummaryOutBean.getJimuTetuzukiCd());
        bzProcessForwardForBatchInBean.setTaskNm(pSkProcessForwardForBatchInBean.getTskNm());
        bzProcessForwardForBatchInBean.setSyoriComment(SYORI_COMMENT);
        bzProcessForwardForBatchInBean.setIwfApiRuleBean(skMainDairitenRuleBean);

        bzProcessForwardForBatchInBeanList.add(bzProcessForwardForBatchInBean);

        bzProcessForwardForBatchInBean = SWAKInjector.getInstance(BzProcessForwardForBatchInBean.class);

        bzGetProcessSummaryInBean = SWAKInjector.getInstance(BzGetProcessSummaryInBean.class);

        SkTenkenRuleBean skTenkenRuleBean = SWAKInjector.getInstance(SkTenkenRuleBean.class);

        bzGetProcessSummaryInBean.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKTENKEN);
        bzGetProcessSummaryInBean.setKouteiKanriStatuss(C_Kouteikanristatus.SYORITYUU);
        bzGetProcessSummaryInBean.setMosNo(pSkProcessForwardForBatchInBean.getHtSyoriCTL().getMosno());

        bzGetProcessSummaryOutBeanList = bzGetProcessSummary.exec(bzGetProcessSummaryInBean);

        bzGetProcessSummaryOutBean = bzGetProcessSummaryOutBeanList.get(0);

        skTenkenRuleBean.setSkkouteikanryouKbn(C_SkkouteikanryouKbn.getContentByValue(
            C_SkkouteikanryouKbn.PATTERN_DEFAULT,
            String.valueOf(C_SkkouteikanryouKbn.SYORITYUU)));
        skTenkenRuleBean.setSeirituKbn(C_SeirituKbn.getContentByValue(
            C_SeirituKbn.PATTERN_DEFAULT,
            String.valueOf(pSkProcessForwardForBatchInBean.getHtSyoriCTL().getSeiritukbn())));
        skTenkenRuleBean.setMosnrkUmu(C_UmuKbn.getContentByValue(
            C_UmuKbn.PATTERN_DEFAULT,
            String.valueOf(pSkProcessForwardForBatchInBean.getHtSyoriCTL().getMosnrkumu())));
        skTenkenRuleBean.setSntkhouKbn(C_SntkhouKbn.getContentByValue(
            C_SntkhouKbn.PATTERN_DEFAULT,
            String.valueOf(pSkProcessForwardForBatchInBean.getHtSyoriCTL().getMosKihon().getSntkhoukbn())));
        skTenkenRuleBean.setKktnrkUmu(C_UmuKbn.getContentByValue(
            C_UmuKbn.PATTERN_DEFAULT,
            String.valueOf(pSkProcessForwardForBatchInBean.getHtSyoriCTL().getKktnrkumu())));
        skTenkenRuleBean.setKktnrkvrfjkKbn(C_VrfjkKbn.getContentByValue(
            C_VrfjkKbn.PATTERN_DEFAULT,
            String.valueOf(pSkProcessForwardForBatchInBean.getHtSyoriCTL().getKktnrkvrfjkkbn())));
        skTenkenRuleBean.setMostenkenjouKbn(C_MostenkenjyouKbn.getContentByValue(
            C_MostenkenjyouKbn.PATTERN_DEFAULT,
            String.valueOf(pSkProcessForwardForBatchInBean.getHtSyoriCTL().getMostenkenjoukbn())));

        bzProcessForwardForBatchInBean.setKouteiKanriId(bzGetProcessSummaryOutBean.getKouteiKanriId());
        bzProcessForwardForBatchInBean.setJimuTetuzukiCd(bzGetProcessSummaryOutBean.getJimuTetuzukiCd());
        bzProcessForwardForBatchInBean.setIwfApiRuleBean(skTenkenRuleBean);

        bzProcessForwardForBatchInBeanList.add(bzProcessForwardForBatchInBean);

        bzProcessForwardForBatchInBean = SWAKInjector.getInstance(BzProcessForwardForBatchInBean.class);

        bzGetProcessSummaryInBean = SWAKInjector.getInstance(BzGetProcessSummaryInBean.class);

        SkKankyouRuleBean skKankyouRuleBean = SWAKInjector.getInstance(SkKankyouRuleBean.class);

        bzGetProcessSummaryInBean.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKKANKYOU);
        bzGetProcessSummaryInBean.setKouteiKanriStatuss(C_Kouteikanristatus.SYORITYUU);
        bzGetProcessSummaryInBean.setMosNo(pSkProcessForwardForBatchInBean.getHtSyoriCTL().getMosno());

        bzGetProcessSummaryOutBeanList = bzGetProcessSummary.exec(bzGetProcessSummaryInBean);

        bzGetProcessSummaryOutBean = bzGetProcessSummaryOutBeanList.get(0);

        skKankyouRuleBean.setSkkouteikanryouKbn(C_SkkouteikanryouKbn.getContentByValue(
            C_SkkouteikanryouKbn.PATTERN_DEFAULT,
            String.valueOf(C_SkkouteikanryouKbn.SYORITYUU)));
        skKankyouRuleBean.setSeirituKbn(C_SeirituKbn.getContentByValue(
            C_SeirituKbn.PATTERN_DEFAULT,
            String.valueOf(pSkProcessForwardForBatchInBean.getHtSyoriCTL().getSeiritukbn())));
        skKankyouRuleBean.setMostenkenyhKbn(C_MostenkenyhKbn.getContentByValue(
            C_MostenkenyhKbn.PATTERN_DEFAULT,
            String.valueOf(mostenkenyhKbn)));
        skKankyouRuleBean.setMostenkenjouKbn(C_MostenkenjyouKbn.getContentByValue(
            C_MostenkenjyouKbn.PATTERN_DEFAULT,
            String.valueOf(pSkProcessForwardForBatchInBean.getHtSyoriCTL().getMostenkenjoukbn())));
        skKankyouRuleBean.setKnkysateijyouKbn(C_KnkysateijyouKbn.getContentByValue(
            C_KnkysateijyouKbn.PATTERN_DEFAULT,
            String.valueOf(pSkProcessForwardForBatchInBean.getHtSyoriCTL().getKnkysateijyoukbn())));
        skKankyouRuleBean.setKthhbKbn(C_UmuKbn.getContentByValue(
            C_UmuKbn.PATTERN_DEFAULT,
            String.valueOf(pSkProcessForwardForBatchInBean.getHtSyoriCTL().getKthhbkbn())));
        skKankyouRuleBean.setLincjkKbn(C_LincjkKbn.getContentByValue(
            C_LincjkKbn.PATTERN_DEFAULT,
            String.valueOf(pSkProcessForwardForBatchInBean.getHtSyoriCTL().getLincjkkbn())));

        bzProcessForwardForBatchInBean.setKouteiKanriId(bzGetProcessSummaryOutBean.getKouteiKanriId());
        bzProcessForwardForBatchInBean.setJimuTetuzukiCd(bzGetProcessSummaryOutBean.getJimuTetuzukiCd());
        bzProcessForwardForBatchInBean.setIwfApiRuleBean(skKankyouRuleBean);

        bzProcessForwardForBatchInBeanList.add(bzProcessForwardForBatchInBean);

        bzProcessForwardForBatchInBean = SWAKInjector.getInstance(BzProcessForwardForBatchInBean.class);

        bzGetProcessSummaryInBean = SWAKInjector.getInstance(BzGetProcessSummaryInBean.class);

        SkImuRuleBean skImuRuleBean = SWAKInjector.getInstance(SkImuRuleBean.class);

        bzGetProcessSummaryInBean.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKIMU);
        bzGetProcessSummaryInBean.setKouteiKanriStatuss(C_Kouteikanristatus.SYORITYUU);
        bzGetProcessSummaryInBean.setMosNo(pSkProcessForwardForBatchInBean.getHtSyoriCTL().getMosno());

        bzGetProcessSummaryOutBeanList = bzGetProcessSummary.exec(bzGetProcessSummaryInBean);

        bzGetProcessSummaryOutBean = bzGetProcessSummaryOutBeanList.get(0);

        skImuRuleBean.setSkkouteikanryouKbn(C_SkkouteikanryouKbn.getContentByValue(
            C_SkkouteikanryouKbn.PATTERN_DEFAULT,
            String.valueOf(C_SkkouteikanryouKbn.SYORITYUU)));
        skImuRuleBean.setSeirituKbn(C_SeirituKbn.getContentByValue(
            C_SeirituKbn.PATTERN_DEFAULT,
            String.valueOf(pSkProcessForwardForBatchInBean.getHtSyoriCTL().getSeiritukbn())));
        skImuRuleBean.setMostenkenyhKbn(C_MostenkenyhKbn.getContentByValue(
            C_MostenkenyhKbn.PATTERN_DEFAULT,
            String.valueOf(mostenkenyhKbn)));
        skImuRuleBean.setMostenkenjouKbn(C_MostenkenjyouKbn.getContentByValue(
            C_MostenkenjyouKbn.PATTERN_DEFAULT,
            String.valueOf(pSkProcessForwardForBatchInBean.getHtSyoriCTL().getMostenkenjoukbn())));
        skImuRuleBean.setImusateijyouKbn(C_ImusateijyouKbn.getContentByValue(
            C_ImusateijyouKbn.PATTERN_DEFAULT,
            String.valueOf(pSkProcessForwardForBatchInBean.getHtSyoriCTL().getImusateijyoukbn())));
        skImuRuleBean.setKthhbKbn(C_UmuKbn.getContentByValue(
            C_ImusateijyouKbn.PATTERN_DEFAULT,
            String.valueOf(pSkProcessForwardForBatchInBean.getHtSyoriCTL().getKthhbkbn())));

        bzProcessForwardForBatchInBean.setKouteiKanriId(bzGetProcessSummaryOutBean.getKouteiKanriId());
        bzProcessForwardForBatchInBean.setJimuTetuzukiCd(bzGetProcessSummaryOutBean.getJimuTetuzukiCd());
        bzProcessForwardForBatchInBean.setIwfApiRuleBean(skImuRuleBean);

        bzProcessForwardForBatchInBeanList.add(bzProcessForwardForBatchInBean);

        bzGetProcessSummaryInBean = SWAKInjector.getInstance(BzGetProcessSummaryInBean.class);

        SkHubiTourokuRuleBean skHubiTourokuRuleBean = SWAKInjector.getInstance(SkHubiTourokuRuleBean.class);

        bzProcessForwardForBatchInBean = SWAKInjector.getInstance(BzProcessForwardForBatchInBean.class);

        bzGetProcessSummaryInBean.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKHUBITOUROKU);
        bzGetProcessSummaryInBean.setKouteiKanriStatuss(C_Kouteikanristatus.SYORITYUU);
        bzGetProcessSummaryInBean.setMosNo(pSkProcessForwardForBatchInBean.getHtSyoriCTL().getMosno());

        bzGetProcessSummaryOutBeanList = bzGetProcessSummary.exec(bzGetProcessSummaryInBean);

        bzGetProcessSummaryOutBean = bzGetProcessSummaryOutBeanList.get(0);

        skHubiTourokuRuleBean.setSkkouteikanryouKbn(C_SkkouteikanryouKbn.getContentByValue(
            C_SkkouteikanryouKbn.PATTERN_DEFAULT,
            String.valueOf(C_SkkouteikanryouKbn.SYORITYUU)));
        skHubiTourokuRuleBean.setSeirituKbn(C_SeirituKbn.getContentByValue(
            C_SeirituKbn.PATTERN_DEFAULT,
            String.valueOf(pSkProcessForwardForBatchInBean.getHtSyoriCTL().getSeiritukbn())));
        skHubiTourokuRuleBean.setMostenkenyhKbn(C_MostenkenyhKbn.getContentByValue(
            C_MostenkenyhKbn.PATTERN_DEFAULT,
            String.valueOf(mostenkenyhKbn)));
        skHubiTourokuRuleBean.setMostenkenjouKbn(C_MostenkenjyouKbn.getContentByValue(
            C_MostenkenjyouKbn.PATTERN_DEFAULT,
            String.valueOf(pSkProcessForwardForBatchInBean.getHtSyoriCTL().getMostenkenjoukbn())));
        skHubiTourokuRuleBean.setMihassinhubiUmu(C_UmuKbn.getContentByValue(
            C_UmuKbn.PATTERN_DEFAULT,
            String.valueOf(pSkProcessForwardForBatchInBean.getHtSyoriCTL().getMihassinhubiumu())));
        skHubiTourokuRuleBean.setHubihassintnsUmu(C_HubihassintnsKbn.getContentByValue(
            C_HubihassintnsKbn.PATTERN_DEFAULT,
            String.valueOf(C_HubihassintnsKbn.BLNK)));
        skHubiTourokuRuleBean.setHubitourokuUmu(C_UmuKbn.getContentByValue(
            C_UmuKbn.PATTERN_DEFAULT,
            String.valueOf(pSkProcessForwardForBatchInBean.getSkHubiDetailUmu())));
        skHubiTourokuRuleBean.setKthhbKbn(C_UmuKbn.getContentByValue(
            C_UmuKbn.PATTERN_DEFAULT,
            String.valueOf(pSkProcessForwardForBatchInBean.getHtSyoriCTL().getKthhbkbn())));

        bzProcessForwardForBatchInBean.setKouteiKanriId(bzGetProcessSummaryOutBean.getKouteiKanriId());
        bzProcessForwardForBatchInBean.setJimuTetuzukiCd(bzGetProcessSummaryOutBean.getJimuTetuzukiCd());
        bzProcessForwardForBatchInBean.setIwfApiRuleBean(skHubiTourokuRuleBean);

        bzProcessForwardForBatchInBeanList.add(bzProcessForwardForBatchInBean);

        logger.debug("△ 新契約工程遷移（決定保留不備）_バッチ用 終了");

        return bzProcessForwardForBatchInBeanList;
    }

}
