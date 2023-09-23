package yuyu.common.hozen.khcommon;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.slf4j.Logger;

import yuyu.common.biz.koutei.BzGetProcessSummary;
import yuyu.common.biz.koutei.BzGetProcessSummaryInBean;
import yuyu.common.biz.koutei.BzGetProcessSummaryOutBean;
import yuyu.def.classification.C_Kouteikanristatus;
import yuyu.def.classification.C_UmuKbn;

/**
 * 契約保全 契約保全共通 契約保全工程開始チェック
 */
public class CheckProcessKaishi {

    @Inject
    private static Logger logger;

    private BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean = null;
    public CheckProcessKaishi() {
        super();
    }

    public C_UmuKbn exec(String pSyono, String pJimuTetuzukiCd) {

        logger.debug("▽ 契約保全工程開始チェック 開始");

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean = new BzGetProcessSummaryInBean();
        C_UmuKbn cUmuKbn = C_UmuKbn.NONE;

        C_Kouteikanristatus[] kouteikanristatuss = {C_Kouteikanristatus.SYORITYUU};

        bzGetProcessSummaryInBean.setSyoNo(pSyono);
        bzGetProcessSummaryInBean.setJimuTetuzukiCd(pJimuTetuzukiCd);
        bzGetProcessSummaryInBean.setKouteiKanriStatuss(kouteikanristatuss);

        BzGetProcessSummary bzGetProcessSummary = SWAKInjector.getInstance(BzGetProcessSummary.class);
        List<BzGetProcessSummaryOutBean> bzGetProcessSummaryOutBeanLst = bzGetProcessSummary
            .exec(bzGetProcessSummaryInBean);

        if (0 < bzGetProcessSummaryOutBeanLst.size()) {
            for (BzGetProcessSummaryOutBean processSummaryOutBean : bzGetProcessSummaryOutBeanLst) {
                if (processSummaryOutBean.getKouteEndYmd() == null) {
                    cUmuKbn = C_UmuKbn.ARI;
                    bzGetProcessSummaryOutBean = processSummaryOutBean;
                    break;
                }
            }
        }
        logger.debug("△ 契約保全工程開始チェック 終了");

        return cUmuKbn;
    }

    public BzGetProcessSummaryOutBean getBzGetProcessSummaryOutBean() {
        return bzGetProcessSummaryOutBean;
    }

}
