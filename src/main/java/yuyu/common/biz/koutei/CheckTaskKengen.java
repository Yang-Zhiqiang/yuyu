package yuyu.common.biz.koutei;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import yuyu.common.biz.workflow.IwfKouteiClient;
import yuyu.common.biz.workflow.io.koutei.GetExecutableTasksInBean;
import yuyu.common.biz.workflow.io.koutei.GetExecutableTasksOutBean;
import yuyu.common.biz.workflow.io.koutei.sub.ExecutableTaskInfoBean;
import yuyu.def.MessageId;

/**
 * 業務共通 工程 タスク権限チェック
 */
public class CheckTaskKengen {

    private final String CHECKTASKKENGEN = "タスク権限チェック";

    private final String GETEXECUTABLETASKS = "実行可能タスク情報取得";

    private final String GETCOUNT_NONE = "0";

    @Inject
    private IwfKouteiClient iwfKouteiClient;

    public CheckTaskKengen() {
        super();
    }


    public boolean exec(String pUserId, String pJimuTetuzukiCd, String pTaskId) {

        GetExecutableTasksInBean getExecutableTasksInBean = new GetExecutableTasksInBean();

        getExecutableTasksInBean.setAccountid(pUserId);

        getExecutableTasksInBean.seKensuuSyutokuYouhi(GETCOUNT_NONE);

        GetExecutableTasksOutBean getExecutableTasksOutBean = iwfKouteiClient.execGetExecutableTasks(getExecutableTasksInBean);

        List<ExecutableTaskInfoBean> executableTaskInfoBeanList;

        if (BzIwfUtilConstants.API_RESULTCD_OK.equals(getExecutableTasksOutBean.getKekkastatus())) {

            executableTaskInfoBeanList = getExecutableTasksOutBean.getExecutableTaskInfos();
        }
        else {
            throw new BizAppException(MessageId.EBS0007,
                CHECKTASKKENGEN,
                GETEXECUTABLETASKS,
                getExecutableTasksOutBean.getSyousaimsgcd());
        }

        for (ExecutableTaskInfoBean executableTaskInfoBean : executableTaskInfoBeanList) {

            if (executableTaskInfoBean.getFlowId().equals(pJimuTetuzukiCd) &&
                executableTaskInfoBean.getNodeName().equals(pTaskId))  {

                return true;
            }
        }

        return false;
    }
}
