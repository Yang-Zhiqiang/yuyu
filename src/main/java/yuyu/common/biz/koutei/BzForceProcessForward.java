package yuyu.common.biz.koutei;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import yuyu.common.base.BaseUserInfo;
import yuyu.common.biz.workflow.IwfKouteiClient;
import yuyu.common.biz.workflow.io.koutei.ForceProcessForwardInBean;
import yuyu.common.biz.workflow.io.koutei.ForceProcessForwardOutBean;
import yuyu.def.MessageId;

/**
 * 業務共通 工程 業務共通強制工程遷移
 */
public class BzForceProcessForward {

    @Inject
    private BzGetProcessSummary bzGetProcessSummary;

    @Inject
    private IwfKouteiClient iwfKouteiClient;

    @Inject
    private BaseUserInfo baseUserInfo;

    public BzForceProcessForward() {
        super();
    }

    public void exec(String pKouteiKanriId, String pJimuTetuzukiCd, String pDestnodeId, String pKouteiLockKey) {

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean = new BzGetProcessSummaryInBean();

        bzGetProcessSummaryInBean.setKouteiKanriId(pKouteiKanriId);
        bzGetProcessSummaryInBean.setJimuTetuzukiCd(pJimuTetuzukiCd);

        List<BzGetProcessSummaryOutBean> bzGetProcessSummaryOutBeanLst =
            bzGetProcessSummary.exec(bzGetProcessSummaryInBean);

        BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean = bzGetProcessSummaryOutBeanLst.get(0);

        if (bzGetProcessSummaryOutBean.getNowNodoId().equals(pDestnodeId)) {
            return;
        }

        ForceProcessForwardInBean forceProcessForwardInBean = new ForceProcessForwardInBean();

        forceProcessForwardInBean.setGyoumukey(pKouteiKanriId);
        forceProcessForwardInBean.setFlowid(pJimuTetuzukiCd);
        forceProcessForwardInBean.setAccountid(baseUserInfo.getUserId());
        forceProcessForwardInBean.setSrcnodename(bzGetProcessSummaryOutBean.getNowNodoId());
        forceProcessForwardInBean.setDestnodename(pDestnodeId);
        forceProcessForwardInBean.setLockkey(pKouteiLockKey);

        ForceProcessForwardOutBean forceProcessForwardOutBean =
            iwfKouteiClient.execForceProcessForward(forceProcessForwardInBean);

        String kekkaStatus = forceProcessForwardOutBean.getKekkastatus();
        String syousaiMsgCd = forceProcessForwardOutBean.getSyousaimsgcd();

        if (BzIwfUtilConstants.API_RESULTCD_OK.equals(kekkaStatus)) {
        }
        else {
            throw new BizAppException(
                MessageId.EBS0007, "業務共通強制工程遷移", "強制工程遷移", syousaiMsgCd);
        }
    }
}
