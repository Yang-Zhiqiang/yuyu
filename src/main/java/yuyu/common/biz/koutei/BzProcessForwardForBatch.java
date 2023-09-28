package yuyu.common.biz.koutei;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import yuyu.common.base.BaseUserInfo;
import yuyu.common.biz.workflow.IwfKouteiClient;
import yuyu.common.biz.workflow.io.koutei.ProcessForwardForBatchInBean;
import yuyu.common.biz.workflow.io.koutei.ProcessForwardForBatchOutBean;
import yuyu.common.biz.workflow.io.koutei.sub.ProcessForwardForBatchBean;
import yuyu.def.MessageId;
import yuyu.def.classification.C_SyorikekkaKbn;

/**
 * 業務共通 工程 業務共通工程遷移（バッチ用）
 */
public class BzProcessForwardForBatch {

    @Inject
    private IwfKouteiClient iwfKouteiClient;

    @Inject
    private BaseUserInfo baseUserInfo;

    public BzProcessForwardForBatch() {
        super();
    }

    public void exec(List<BzProcessForwardForBatchInBean> pBzProcessForwardForBatchInBeanLst) {

        List<Map<String, String>> extInfoLst = new ArrayList<>();
        Map<String, String> extInfoMp = new HashMap<>();
        List<ProcessForwardForBatchBean> processForwardForBatchBeanLst = new ArrayList<>();

        extInfoMp.put(BzIwfUtilConstants.API_EXTINFO_KEY_SYORIKEKKAKBN, C_SyorikekkaKbn.KANRYOU.getValue());
        extInfoLst.add(extInfoMp);

        for (BzProcessForwardForBatchInBean bzProcessForwardForBatchInBean : pBzProcessForwardForBatchInBeanLst) {

            ProcessForwardForBatchBean processForwardForBatchBean = new ProcessForwardForBatchBean();

            processForwardForBatchBean.setGyoumukey(bzProcessForwardForBatchInBean.getKouteiKanriId());
            processForwardForBatchBean.setFlowid(bzProcessForwardForBatchInBean.getJimuTetuzukiCd());
            processForwardForBatchBean.setRuleCondition(bzProcessForwardForBatchInBean.getIwfApiRuleBean());
            processForwardForBatchBean.setExtInfo(extInfoLst);
            processForwardForBatchBean.setRirekiTaskName(bzProcessForwardForBatchInBean.getTaskNm());
            processForwardForBatchBean.setRirekiTaskMessage(bzProcessForwardForBatchInBean.getSyoriComment());

            processForwardForBatchBeanLst.add(processForwardForBatchBean);
        }

        if (processForwardForBatchBeanLst.size() != 0) {
            ProcessForwardForBatchInBean processForwardForBatchInBean = new ProcessForwardForBatchInBean();

            processForwardForBatchInBean.setAccountid(baseUserInfo.getUserId());
            processForwardForBatchInBean.setRirekiYouhi(BzIwfUtilConstants.API_SYORIKBN_RIREKISAKUSEIYOU);
            processForwardForBatchInBean.setProcessForwardForBatchBeanList(processForwardForBatchBeanLst);

            ProcessForwardForBatchOutBean processForwardForBatchOutBean = iwfKouteiClient
                .execProcessForwardForBatch(processForwardForBatchInBean);

            String kekkaStatus = processForwardForBatchOutBean.getKekkastatus();
            String syousaiMsgCd = processForwardForBatchOutBean.getSyousaimsgcd();

            if (BzIwfUtilConstants.API_RESULTCD_OK.equals(kekkaStatus)) {
            }
            else {
                throw new BizAppException(
                    MessageId.EBS0007, "業務共通工程遷移（バッチ用）", "工程遷移（バッチ用）", syousaiMsgCd);
            }
        }
    }
}
