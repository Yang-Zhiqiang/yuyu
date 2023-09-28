package yuyu.common.biz.koutei;

import java.util.List;

import javax.inject.Inject;

import yuyu.def.classification.C_Kouteikanristatus;
import yuyu.def.classification.C_YouhiKbn;

/**
 * 業務共通 工程 業務共通工程終了
 */
public class BzEndProcess {

    @Inject
    private BzGetProcessSummary bzGetProcessSummary;

    @Inject
    private BzForceProcessForward bzForceProcessForward;

    @Inject
    private GetSyoriKokouteiInfo getSyoriKokouteiInfo;

    public BzEndProcess() {
        super();
    }

    public void exec(String pSyuKouteiKanriId, String pSyuJimuTetuzukiCd, String pKouteiLockKey,
        C_YouhiKbn pSyuKouteiEndYouhiKbn) {

        if (C_YouhiKbn.YOU.eq(pSyuKouteiEndYouhiKbn)) {
            BzGetProcessSummaryInBean bzGetProcessSummaryInBean = new BzGetProcessSummaryInBean();

            bzGetProcessSummaryInBean.setKouteiKanriId(pSyuKouteiKanriId);
            bzGetProcessSummaryInBean.setJimuTetuzukiCd(pSyuJimuTetuzukiCd);
            bzGetProcessSummaryInBean.setKouteiKanriStatuss(C_Kouteikanristatus.SYORITYUU);

            List<BzGetProcessSummaryOutBean> bzGetProcessSummaryOutBeanLst =
                bzGetProcessSummary.exec(bzGetProcessSummaryInBean);

            if (bzGetProcessSummaryOutBeanLst.size() == 0) {
            }
            else {
                bzForceProcessForward.exec(pSyuKouteiKanriId,
                    pSyuJimuTetuzukiCd,
                    BzIwfUtilConstants.NODEID_ENDNODE_DEFAULT,
                    pKouteiLockKey);
            }
        }

        List<GetSyoriKokouteiInfoOutBean> getSyoriKokouteiInfoOutBeanLst =
            getSyoriKokouteiInfo.exec(pSyuKouteiKanriId, pSyuJimuTetuzukiCd);

        for (GetSyoriKokouteiInfoOutBean getSyoriKokouteiInfoOutBean : getSyoriKokouteiInfoOutBeanLst) {

            bzForceProcessForward.exec(getSyoriKokouteiInfoOutBean.getSyoriKokouteikanriId(),
                getSyoriKokouteiInfoOutBean.getSyoriKokouteiJimutetuzukiCd(),
                BzIwfUtilConstants.NODEID_ENDNODE_DEFAULT,
                pKouteiLockKey);
        }
    }
}
