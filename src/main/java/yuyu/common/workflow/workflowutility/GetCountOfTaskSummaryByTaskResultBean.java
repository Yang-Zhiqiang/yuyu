package yuyu.common.workflow.workflowutility;

import java.util.ArrayList;
import java.util.List;

/**
 * 処理残件数取得(事務手続・タスク指定) の処理結果クラスです。<br />
 */
public class GetCountOfTaskSummaryByTaskResultBean extends WorkListResultBean{

    public GetCountOfTaskSummaryByTaskResultBean() {
    }

    private List<CountOfTaskSummaryByTaskBean> countOfTaskSummaryBean = new ArrayList<CountOfTaskSummaryByTaskBean>();

    public List<CountOfTaskSummaryByTaskBean> getCountOfTaskSummaryBean() {
        return countOfTaskSummaryBean;
    }

    public void setCountOfTaskSummaryBean(List<CountOfTaskSummaryByTaskBean> pCountOfTaskSummaryBean) {
        countOfTaskSummaryBean = pCountOfTaskSummaryBean;
    }
}
