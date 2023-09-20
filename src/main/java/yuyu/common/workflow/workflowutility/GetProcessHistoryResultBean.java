package yuyu.common.workflow.workflowutility;

import java.util.ArrayList;
import java.util.List;

/**
 * 工程履歴取得 の処理結果クラスです。<br />
 */
public class GetProcessHistoryResultBean extends WorkListResultBean{

    public GetProcessHistoryResultBean() {
    }

    private List<ProcessHistoryBean> processHistoryBeanList = new ArrayList<ProcessHistoryBean>();

    public List<ProcessHistoryBean> getProcessHistoryBeanList() {
        return processHistoryBeanList;
    }

    public void setProcessHistoryBeanList(List<ProcessHistoryBean> pProcessHistoryBeanList) {
        processHistoryBeanList = pProcessHistoryBeanList;
    }
}
