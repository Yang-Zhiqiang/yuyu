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
import yuyu.def.classification.C_KetteiKbn;
import yuyu.def.classification.C_Kouteikanristatus;
import yuyu.def.classification.C_MostenkenjyouKbn;
import yuyu.def.classification.C_SateijtKbn;
import yuyu.def.classification.C_SeirituKbn;
import yuyu.def.classification.C_SkkouteikanryouKbn;
import yuyu.def.classification.C_SntkhouKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_VrfjkKbn;

/**
 * 新契約 工程 新契約工程遷移（振込入金処理）
 */
public class SkProcessForwardHurikomiNyuukin {

    @Inject
    private static Logger logger;

    public SkProcessForwardHurikomiNyuukin() {
        super();
    }

    public void exec(List<SkProcessForwardForBatchInBean> pSkProcessForwardForBatchInBeanList) {

        logger.debug("▽ 新契約工程遷移（振込入金処理） 開始");

        BzGetProcessSummary bzGetProcessSummary = SWAKInjector.getInstance(BzGetProcessSummary.class);

        List<BzProcessForwardForBatchInBean> bzProcessForwardForBatchInBeanList = new ArrayList<>();

        BzProcessForwardForBatchInBean bzProcessForwardForBatchInBean;

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean;

        SkMainDairitenRuleBean skMainDairitenRuleBean;

        List<BzGetProcessSummaryOutBean> bzGetProcessSummaryOutBeanList = new ArrayList<>();

        BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean = SWAKInjector
            .getInstance(BzGetProcessSummaryOutBean.class);

        SkProcessForwardMoschkExecBatch skProcessForwardMoschkExecBatch = SWAKInjector
            .getInstance(SkProcessForwardMoschkExecBatch.class);

        BzProcessForwardForBatch bzProcessForwardForBatch = SWAKInjector.getInstance(BzProcessForwardForBatch.class);

        for (SkProcessForwardForBatchInBean skProcessForwardForBatchInBean : pSkProcessForwardForBatchInBeanList) {

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

            List<BzProcessForwardForBatchInBean> resultList = skProcessForwardMoschkExecBatch
                .exec(skProcessForwardForBatchInBean);

            if (resultList != null && resultList.size() > 0) {

                bzProcessForwardForBatchInBeanList.addAll(resultList);
            }
        }

        bzProcessForwardForBatch.exec(bzProcessForwardForBatchInBeanList);

        logger.debug("△ 新契約工程遷移（振込入金処理） 終了");
    }

}
