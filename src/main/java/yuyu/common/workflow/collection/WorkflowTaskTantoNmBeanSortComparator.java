package yuyu.common.workflow.collection;

import java.util.Comparator;

import yuyu.common.workflow.workflowutility.TaskTantoNmBean;

/**
 * TaskTantoNmBean をソートするためのコンパレータです。<br />
 * ソート条件は｛証券番号の昇順、年金証書番号の昇順｝です。
 */
public class WorkflowTaskTantoNmBeanSortComparator implements Comparator<TaskTantoNmBean> {

    @Override
    public int compare(TaskTantoNmBean  o1, TaskTantoNmBean  o2) {

        String tntId1 = o1.getTantId() == null ? "" : o1.getTantId();
        String tntId2 = o2.getTantId() == null ? "" : o2.getTantId();

        if(tntId1.equals("")) {
            return -1;
        }
        if(tntId2.equals("")) {
            return 1;
        }

        return tntId1.compareTo(tntId2);
    }
}
