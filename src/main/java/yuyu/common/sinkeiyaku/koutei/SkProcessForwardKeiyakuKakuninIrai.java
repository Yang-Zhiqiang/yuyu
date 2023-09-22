package yuyu.common.sinkeiyaku.koutei;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.slf4j.Logger;

import yuyu.common.biz.koutei.BzGetProcessSummary;
import yuyu.common.biz.koutei.BzGetProcessSummaryInBean;
import yuyu.common.biz.koutei.BzGetProcessSummaryOutBean;
import yuyu.common.biz.koutei.BzOutputProcessRecord;
import yuyu.common.sinkeiyaku.skcommon.ISkCommonKoumoku;
import yuyu.def.classification.C_Kouteikanristatus;
import yuyu.def.classification.C_SeirituKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;

/**
 * 新契約 工程 新契約工程遷移（契約確認依頼入力）
 */
public class SkProcessForwardKeiyakuKakuninIrai {

    @Inject
    private static Logger logger;

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    public SkProcessForwardKeiyakuKakuninIrai() {
        super();
    }

    public void exec(SkProcessForwardInBean pSkProcessForwardInBean) {

        logger.debug("▽ 新契約工程遷移（契約確認依頼入力） 開始");

        BzGetProcessSummary bzGetProcessSummary = SWAKInjector.getInstance(BzGetProcessSummary.class);
        BzOutputProcessRecord bzOutputProcessRecord = SWAKInjector.getInstance(BzOutputProcessRecord.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(pSkProcessForwardInBean.getMosNo());

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean = SWAKInjector.getInstance(BzGetProcessSummaryInBean.class);

        bzGetProcessSummaryInBean.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN);
        bzGetProcessSummaryInBean.setKouteiKanriStatuss(C_Kouteikanristatus.SYORITYUU);
        bzGetProcessSummaryInBean.setMosNo(pSkProcessForwardInBean.getMosNo());

        List<BzGetProcessSummaryOutBean> bzGetProcessSummaryOutBeanList = bzGetProcessSummary
            .exec(bzGetProcessSummaryInBean);

        if (bzGetProcessSummaryOutBeanList.size() > 0) {

            BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean = bzGetProcessSummaryOutBeanList.get(0);

            if (!C_SeirituKbn.SEIRITU.eq(bzGetProcessSummaryOutBean.getSeirituKbn())) {
                pSkProcessForwardInBean.setMoscheckrirekiyhKbn(C_YouhiKbn.YOU);

                SkProcessForwardMoschkExec skProcessForwardMoschkExec = SWAKInjector.getInstance(SkProcessForwardMoschkExec.class);

                skProcessForwardMoschkExec.exec(pSkProcessForwardInBean);
            }
            else {
                bzOutputProcessRecord.exec(bzGetProcessSummaryOutBean.getKouteiKanriId(),
                    bzGetProcessSummaryOutBean.getJimuTetuzukiCd(),
                    pSkProcessForwardInBean.getSyoriComment(),
                    pSkProcessForwardInBean.getTskNm(),
                    pSkProcessForwardInBean.getSyorikekkaKbn());
            }
        }
        else {

            bzGetProcessSummaryInBean = SWAKInjector.getInstance(BzGetProcessSummaryInBean.class);

            bzGetProcessSummaryInBean.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN);
            bzGetProcessSummaryInBean.setSyoNo(syoriCTL.getSyono());

            bzGetProcessSummaryOutBeanList = bzGetProcessSummary.exec(bzGetProcessSummaryInBean);

            if (bzGetProcessSummaryOutBeanList.size() > 0) {

                BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean = bzGetProcessSummaryOutBeanList.get(0);

                bzOutputProcessRecord.exec(bzGetProcessSummaryOutBean.getKouteiKanriId(),
                    bzGetProcessSummaryOutBean.getJimuTetuzukiCd(),
                    pSkProcessForwardInBean.getSyoriComment(),
                    pSkProcessForwardInBean.getTskNm(),
                    pSkProcessForwardInBean.getSyorikekkaKbn());
            }
        }

        logger.debug("△ 新契約工程遷移（契約確認依頼入力） 終了");
    }

}
