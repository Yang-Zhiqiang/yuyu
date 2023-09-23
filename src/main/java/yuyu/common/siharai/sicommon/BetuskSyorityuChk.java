package yuyu.common.siharai.sicommon;

import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.koutei.BzGetProcessSummary;
import yuyu.common.biz.koutei.BzGetProcessSummaryInBean;
import yuyu.common.biz.koutei.BzGetProcessSummaryOutBean;
import yuyu.def.classification.C_Kouteikanristatus;
import yuyu.def.classification.C_UmuKbn;

/**
 * 保険金給付金支払 保険金給付金支払共通 別請求処理中チェック
 */
public class BetuskSyorityuChk {

    @Inject
    private static Logger logger;

    private String wmJimutetuzukinm;

    private String wmNodenm;

    public BetuskSyorityuChk() {
        super();
    }

    public boolean exec(String pSyno, String pSkno) {

        logger.debug("▽ 別請求処理中チェック 開始");

        boolean result = true;
        BzGetProcessSummaryInBean bzGetProcessSummaryInBean = SWAKInjector.getInstance(BzGetProcessSummaryInBean.class);
        BzGetProcessSummary bzGetProcessSummary = SWAKInjector.getInstance(BzGetProcessSummary.class);

        bzGetProcessSummaryInBean.setSyoNo(pSyno);
        bzGetProcessSummaryInBean.setKouteiKanriStatuss(C_Kouteikanristatus.SYORITYUU);
        bzGetProcessSummaryInBean.setSubSystemId(TeisuuSiharai.SUBSYSTEMID_SIHARAI);
        bzGetProcessSummaryInBean.setSyukouteiSiborikomiUmu(C_UmuKbn.ARI);

        List<BzGetProcessSummaryOutBean> bzGetProcessSummaryOutBeanLst = bzGetProcessSummary
            .exec(bzGetProcessSummaryInBean);

        List<String> taskIdLst = Arrays.asList(TeisuuSiharai.TASKID_BETUSKSYRTYUUWARNINGSETTEIS);

        for (BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean : bzGetProcessSummaryOutBeanLst) {
            if (!BizUtil.isBlank(pSkno)) {
                if (pSkno.equals(bzGetProcessSummaryOutBean.getSkNo())) {
                    continue;
                }
            }
            if (taskIdLst.contains(bzGetProcessSummaryOutBean.getNowNodoId())) {
                wmJimutetuzukinm = bzGetProcessSummaryOutBean.getJimuTetuzukiNm();
                wmNodenm = bzGetProcessSummaryOutBean.getNowNodoNm();
                result = false;
                logger.debug("△ 別請求処理中チェック 終了");
                return result;
            }
        }

        logger.debug("△ 別請求処理中チェック 終了");

        return result;
    }

    public String getWmJimutetuzukinm() {
        return wmJimutetuzukinm;
    }

    public String getWmNodenm() {
        return wmNodenm;
    }
}