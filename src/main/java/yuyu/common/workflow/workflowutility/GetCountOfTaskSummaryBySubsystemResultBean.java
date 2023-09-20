package yuyu.common.workflow.workflowutility;

import java.util.ArrayList;
import java.util.List;

/**
 * 処理残件数取得(サブシステム・ユーザーID指定) の処理結果クラスです。<br />
 */
public class GetCountOfTaskSummaryBySubsystemResultBean extends WorkListResultBean{

    public GetCountOfTaskSummaryBySubsystemResultBean() {
    }

    private List<CountOfTaskSummaryBySubsystemBean> countOfTaskSummaryBean = new ArrayList<CountOfTaskSummaryBySubsystemBean>();

    public List<CountOfTaskSummaryBySubsystemBean> getCountOfTaskSummaryBean() {
        return countOfTaskSummaryBean;
    }

    public void setCountOfTaskSummaryBean(List<CountOfTaskSummaryBySubsystemBean> pCountOfTaskSummaryBean) {
        countOfTaskSummaryBean = pCountOfTaskSummaryBean;
    }
}
