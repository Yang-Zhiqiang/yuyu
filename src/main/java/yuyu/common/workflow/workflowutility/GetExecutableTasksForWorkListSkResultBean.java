package yuyu.common.workflow.workflowutility;

import java.util.ArrayList;
import java.util.List;

/**
 * 工程ワークリストタスク選択用実行可能タスク情報取得（新契約） の処理結果クラスです。<br />
 */
public class GetExecutableTasksForWorkListSkResultBean extends WorkListResultBean{

    public GetExecutableTasksForWorkListSkResultBean() {
    }

    private List<ExecutableTaskInfoBean> executableTaskInfoBeanList = new ArrayList<ExecutableTaskInfoBean>();

    public List<ExecutableTaskInfoBean> getExecutableTaskInfoBeanList() {
        return executableTaskInfoBeanList;
    }

    public void setExecutableTaskInfoBeanList(List<ExecutableTaskInfoBean> pExecutableTaskInfoBeanList) {
        executableTaskInfoBeanList = pExecutableTaskInfoBeanList;
    }
}
