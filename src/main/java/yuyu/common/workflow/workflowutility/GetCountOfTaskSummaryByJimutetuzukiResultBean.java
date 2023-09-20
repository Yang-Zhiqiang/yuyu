package yuyu.common.workflow.workflowutility;

import java.util.ArrayList;
import java.util.List;

/**
 * 処理残件数取得(事務手続指定) の処理結果クラスです。<br />
 */
public class GetCountOfTaskSummaryByJimutetuzukiResultBean extends WorkListResultBean{

    public GetCountOfTaskSummaryByJimutetuzukiResultBean() {
    }

    private List<CountOfTaskSummaryByJimutetuzukiBean> countOfTaskSummaryBean = new ArrayList<CountOfTaskSummaryByJimutetuzukiBean>();

    public List<CountOfTaskSummaryByJimutetuzukiBean> getCountOfTaskSummaryBean() {
        return countOfTaskSummaryBean;
    }

    public void setCountOfTaskSummaryBean(List<CountOfTaskSummaryByJimutetuzukiBean> pCountOfTaskSummaryBean) {
        countOfTaskSummaryBean = pCountOfTaskSummaryBean;
    }
}
