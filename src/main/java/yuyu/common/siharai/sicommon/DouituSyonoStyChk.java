package yuyu.common.siharai.sicommon;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.slf4j.Logger;

import yuyu.common.biz.koutei.BzGetProcessSummary;
import yuyu.common.biz.koutei.BzGetProcessSummaryInBean;
import yuyu.common.biz.koutei.BzGetProcessSummaryOutBean;
import yuyu.def.classification.C_Kouteikanristatus;

/**
 * 保険金給付金支払 保険金給付金支払共通 同一証券番号進捗チェック
 */
public class DouituSyonoStyChk {
    @Inject
    private static Logger logger;

    public DouituSyonoStyChk() {
        super();
    }

    public boolean exec(String pSyoNo,
        String pJimuTetuzukiCd, C_Kouteikanristatus[] pKouteiKanriStatus) {
        logger.debug("▽ 同一証券番号進捗チェック 開始");
        boolean result = true;
        BzGetProcessSummaryInBean processSummaryInBean = SWAKInjector.getInstance(BzGetProcessSummaryInBean.class);
        BzGetProcessSummary processSummary = SWAKInjector.getInstance(BzGetProcessSummary.class);
        processSummaryInBean.setJimuTetuzukiCd(pJimuTetuzukiCd);
        processSummaryInBean.setSyoNo(pSyoNo);
        processSummaryInBean.setKouteiKanriStatuss(pKouteiKanriStatus);
        List<BzGetProcessSummaryOutBean> processSummaryOutBeans = processSummary.exec(processSummaryInBean);
        if (processSummaryOutBeans.size() > 0) {
            result = false;
        }
        logger.debug("△ 同一証券番号進捗チェック 終了");
        return result;
    }
}