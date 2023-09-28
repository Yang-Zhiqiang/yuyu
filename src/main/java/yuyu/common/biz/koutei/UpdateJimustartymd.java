package yuyu.common.biz.koutei;

import javax.inject.Inject;

import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import yuyu.common.base.BaseUserInfo;
import yuyu.common.biz.workflow.IwfKouteiClient;
import yuyu.common.biz.workflow.io.koutei.ProcessUpdateInBean;
import yuyu.common.biz.workflow.io.koutei.ProcessUpdateOutBean;
import yuyu.common.workflowcore.core.webservice.common.WSExtParam;
import yuyu.def.MessageId;

/**
 * 業務共通 工程 事務開始日更新
 */
public class UpdateJimustartymd {

    @Inject
    private IwfKouteiClient iwfKouteiClient;

    @Inject
    private BaseUserInfo baseUserInfo;

    public UpdateJimustartymd() {
        super();
    }

    public void exec(String pJimuTetuzukiCd, String pKouteiKanriId, String pKouteiLockKey, String pJimuStartYmd) {

        ProcessUpdateInBean processUpdateInBean = new ProcessUpdateInBean();

        processUpdateInBean.setGyoumukey(pKouteiKanriId);
        processUpdateInBean.setFlowid(pJimuTetuzukiCd);
        processUpdateInBean.setAccountid(baseUserInfo.getUserId());
        processUpdateInBean.setLockkey(pKouteiLockKey);
        WSExtParam extParam = new WSExtParam();
        extParam.setValues(pJimuStartYmd);
        processUpdateInBean.setExtParam11(extParam);

        ProcessUpdateOutBean processUpdateOutBean = iwfKouteiClient.execProcessUpdate(processUpdateInBean);

        String kekkaStatus = processUpdateOutBean.getKekkastatus();
        String syousaiMsgCd = processUpdateOutBean.getSyousaimsgcd();

        if (BzIwfUtilConstants.API_RESULTCD_OK.equals(kekkaStatus)) {
        }
        else {
            throw new BizAppException(
                    MessageId.EBS0007, "事務開始日更新", "工程情報更新", syousaiMsgCd);
        }
    }
}
