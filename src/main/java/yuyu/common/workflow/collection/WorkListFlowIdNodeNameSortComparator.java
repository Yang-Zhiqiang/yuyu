package yuyu.common.workflow.collection;

import java.util.Comparator;

import yuyu.common.biz.workflow.io.koutei.sub.ExecutableTaskInfoBean;

/**
 * 工程ワークリスト フローID、ノード名のソートクラスです。
 * 実行可能タスク件数取得(工程指定)出力Beanリストを、フローID、ノード名の昇順にソートします。
 */
public class WorkListFlowIdNodeNameSortComparator implements Comparator<ExecutableTaskInfoBean> {


    @Override
    public int compare(ExecutableTaskInfoBean executableTaskInfo1, ExecutableTaskInfoBean executableTaskInfo2) {

        String flowId1 = executableTaskInfo1.getFlowId() == null ? "" : executableTaskInfo1.getFlowId();
        String flowId2 = executableTaskInfo2.getFlowId() == null ? "" : executableTaskInfo2.getFlowId();

        String nodeName1 = executableTaskInfo1.getNodeName() == null ? "" : executableTaskInfo1.getNodeName();
        String nodeName2 = executableTaskInfo2.getNodeName() == null ? "" : executableTaskInfo2.getNodeName();

        if (!flowId1.equals(flowId2)) {
            if (flowId1.equals("")) {
                return -1;
            }
            if (flowId2.equals("")) {
                return 1;
            }

            return flowId1.compareTo(flowId2);
        }
        if (nodeName1.equals("")) {
            return -1;
        }
        if (nodeName2.equals("")) {
            return 1;
        }
        return nodeName1.compareTo(nodeName2);

    }


}
