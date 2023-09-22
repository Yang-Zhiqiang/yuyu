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
import yuyu.def.classification.C_Kouteikanristatus;
import yuyu.def.classification.C_SkkinouModeIdKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.db.entity.HT_Henkin;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;

/**
 * 新契約 工程 新契約工程遷移（返金入力）
 */
public class SkProcessForwardHenkinNyuuryoku {

    @Inject
    private static Logger logger;

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    private String kouteiLockkeyMain;

    public SkProcessForwardHenkinNyuuryoku() {
        super();
    }

    public void setKouteiLockkeyMain(String pkouteiLockkeyMain) {
        kouteiLockkeyMain = pkouteiLockkeyMain;
    }

    public void exec(SkProcessForwardInBean pSkProcessForwardInBean) {

        logger.debug("▽ 新契約工程遷移（返金入力） 開始");

        BzGetProcessSummary bzGetProcessSummary = SWAKInjector.getInstance(BzGetProcessSummary.class);
        BzProcessForward bzProcessForward = SWAKInjector.getInstance(BzProcessForward.class);
        BzOutputProcessRecord bzOutputProcessRecord = SWAKInjector.getInstance(BzOutputProcessRecord.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(pSkProcessForwardInBean.getMosNo());

        List<HT_Henkin> henkinList = syoriCTL.getHenkinsByHnknsyoriymdNull();

        C_UmuKbn pkakinUmu = C_UmuKbn.NONE;

        if (henkinList.size() > 0) {

            pkakinUmu = C_UmuKbn.ARI;
        }
        else {
            pkakinUmu = C_UmuKbn.NONE;
        }

        if (C_SkkinouModeIdKbn.HENKINNYUURYOKU.getContent().equals(pSkProcessForwardInBean.getTskNm())) {

            BzGetProcessSummaryInBean bzGetProcessSummaryInBean = SWAKInjector
                .getInstance(BzGetProcessSummaryInBean.class);

            SkHenkinRuleBean skHenkinRuleBean = SWAKInjector.getInstance(SkHenkinRuleBean.class);

            BzProcessForwardInBean bzProcessForwardInBean = SWAKInjector.getInstance(BzProcessForwardInBean.class);

            bzGetProcessSummaryInBean.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKHENKIN);
            bzGetProcessSummaryInBean.setKouteiKanriStatuss(C_Kouteikanristatus.SYORITYUU);
            bzGetProcessSummaryInBean.setMosNo(pSkProcessForwardInBean.getMosNo());

            List<BzGetProcessSummaryOutBean> bzGetProcessSummaryOutBeanList = bzGetProcessSummary
                .exec(bzGetProcessSummaryInBean);

            if (bzGetProcessSummaryOutBeanList.size() > 0) {

                BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean = bzGetProcessSummaryOutBeanList.get(0);

                skHenkinRuleBean.setNyknnrkUmu(C_UmuKbn.getContentByValue(
                    C_UmuKbn.PATTERN_DEFAULT,
                    String.valueOf(syoriCTL.getNyknnrkumu())));
                skHenkinRuleBean.setPkakinUmu(C_UmuKbn.getContentByValue(
                    C_UmuKbn.PATTERN_DEFAULT,
                    String.valueOf(pkakinUmu)));

                bzProcessForwardInBean.setKouteiKanriId(bzGetProcessSummaryOutBean.getKouteiKanriId());
                bzProcessForwardInBean.setJimuTetuzukiCd(bzGetProcessSummaryOutBean.getJimuTetuzukiCd());
                bzProcessForwardInBean.setKouteiLockKey(pSkProcessForwardInBean.getKouteiLockkey());
                bzProcessForwardInBean.setSyoriComment(pSkProcessForwardInBean.getSyoriComment());
                bzProcessForwardInBean.setIwfApiRuleBean(skHenkinRuleBean);
                bzProcessForwardInBean.setSyorikekkaKbn(pSkProcessForwardInBean.getSyorikekkaKbn());
                bzProcessForwardInBean.setProcessRecordOutYouhiKbn(C_YouhiKbn.HUYOU);

                bzProcessForward.exec(bzProcessForwardInBean);
            }

        }

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean = SWAKInjector.getInstance(BzGetProcessSummaryInBean.class);

        bzGetProcessSummaryInBean.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN);
        bzGetProcessSummaryInBean.setKouteiKanriStatuss(C_Kouteikanristatus.SYORITYUU);
        bzGetProcessSummaryInBean.setMosNo(pSkProcessForwardInBean.getMosNo());

        List<BzGetProcessSummaryOutBean> bzGetProcessSummaryOutBeanList = bzGetProcessSummary
            .exec(bzGetProcessSummaryInBean);

        if (bzGetProcessSummaryOutBeanList.size() != 0) {
            BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean = bzGetProcessSummaryOutBeanList.get(0);

            bzOutputProcessRecord.exec(bzGetProcessSummaryOutBean.getKouteiKanriId(),
                bzGetProcessSummaryOutBean.getJimuTetuzukiCd(),
                pSkProcessForwardInBean.getSyoriComment(),
                pSkProcessForwardInBean.getTskNm(),
                pSkProcessForwardInBean.getSyorikekkaKbn());

            SkProcessForwardMoschkExec skProcessForwardMoschkExec = SWAKInjector.getInstance(SkProcessForwardMoschkExec.class);

            if (kouteiLockkeyMain != null && kouteiLockkeyMain.length() != 0) {
                pSkProcessForwardInBean.setKouteiLockkey(kouteiLockkeyMain);
            }

            skProcessForwardMoschkExec.exec(pSkProcessForwardInBean);

        }
        else {
            bzGetProcessSummaryInBean = SWAKInjector.getInstance(BzGetProcessSummaryInBean.class);

            bzGetProcessSummaryInBean.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN);
            bzGetProcessSummaryInBean.setSyoNo(syoriCTL.getSyono());
            bzGetProcessSummaryOutBeanList = bzGetProcessSummary.exec(bzGetProcessSummaryInBean);

            if (bzGetProcessSummaryOutBeanList.size() != 0) {
                BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean = bzGetProcessSummaryOutBeanList.get(0);

                bzOutputProcessRecord.exec(bzGetProcessSummaryOutBean.getKouteiKanriId(),
                    bzGetProcessSummaryOutBean.getJimuTetuzukiCd(),
                    pSkProcessForwardInBean.getSyoriComment(),
                    pSkProcessForwardInBean.getTskNm(),
                    pSkProcessForwardInBean.getSyorikekkaKbn());
            }
        }

        logger.debug("△ 新契約工程遷移（返金入力） 終了");
    }

}
