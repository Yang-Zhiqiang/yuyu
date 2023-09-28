package yuyu.common.biz.koutei;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import yuyu.common.base.BaseUserInfo;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.workflow.IwfKouteiClient;
import yuyu.common.biz.workflow.io.koutei.StartTaskInBean;
import yuyu.common.biz.workflow.io.koutei.StartTaskOutBean;
import yuyu.def.MessageId;
import yuyu.def.classification.C_TskStartKekkaKbn;

/**
 * 業務共通 工程 業務共通タスク開始
 */
public class BzTaskStart {

    @Inject
    private BaseUserInfo baseUserInfo;

    @Inject
    private BzGetProcessSummary bzGetProcessSummary;

    @Inject
    private IwfKouteiClient iwfKouteiClient;

    public BzTaskStart() {
        super();
    }

    public C_TskStartKekkaKbn exec(String pKouteiKanriId,
            String pJimuTetuzukiCd, String pTaskId, String pKouteiLockKey) {

        return exec(pKouteiKanriId, pJimuTetuzukiCd, pTaskId, pKouteiLockKey, baseUserInfo.getUserId());
    }

    public C_TskStartKekkaKbn exec(String pKouteiKanriId,
            String pJimuTetuzukiCd, String pTaskId, String pKouteiLockKey, String pUserId) {

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean = new BzGetProcessSummaryInBean();
        bzGetProcessSummaryInBean.setKouteiKanriId(pKouteiKanriId);
        bzGetProcessSummaryInBean.setJimuTetuzukiCd(pJimuTetuzukiCd);
        bzGetProcessSummaryInBean.setTaskIds(new String[]{pTaskId});

        List<BzGetProcessSummaryOutBean> bzGetProcessSummaryOutBeanLst =
                bzGetProcessSummary.exec(bzGetProcessSummaryInBean);

        if (bzGetProcessSummaryOutBeanLst.size() ==0) {
            return C_TskStartKekkaKbn.HUKA_STARTTSKNONE;
        }

        String nowTantId = bzGetProcessSummaryOutBeanLst.get(0).getNowTantId();

        if (BizUtil.isBlank(nowTantId)) {

            StartTaskInBean startTaskInBean = new StartTaskInBean();

            startTaskInBean.setGyoumukey(pKouteiKanriId);
            startTaskInBean.setFlowid(pJimuTetuzukiCd);
            startTaskInBean.setAccountid(pUserId);
            startTaskInBean.setTaskname(pTaskId);
            startTaskInBean.setLockkey(pKouteiLockKey);

            StartTaskOutBean startTaskOutBean = iwfKouteiClient.execStartTask(startTaskInBean);

            String kekkaStatus = startTaskOutBean.getKekkastatus();
            String syousaiMsgCd = startTaskOutBean.getSyousaimsgcd();

            if (BzIwfUtilConstants.API_RESULTCD_OK.equals(kekkaStatus)) {
            }
            else {
                throw new BizAppException(
                        MessageId.EBS0007, "業務共通工程タスク開始", "タスク開始", syousaiMsgCd);
            }

            return C_TskStartKekkaKbn.SEIJYOU;
        }
        else if (nowTantId.equals(pUserId)) {
            return C_TskStartKekkaKbn.SEIJYOU;
        }
        else {
            return C_TskStartKekkaKbn.HUKA_TATANTOUWARIATEZUMI;
        }
    }
}
