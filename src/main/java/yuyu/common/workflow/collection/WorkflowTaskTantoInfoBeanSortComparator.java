package yuyu.common.workflow.collection;

import java.util.Comparator;

import yuyu.common.workflow.workflowutility.TaskTantoInfoBean;

/**
 * TaskTantoInfoBean をソートするためのコンパレータです。<br />
 * ソート条件は｛事務開始日の昇順｝です。
 */
public class WorkflowTaskTantoInfoBeanSortComparator implements Comparator<TaskTantoInfoBean> {

    @Override
    public int compare(TaskTantoInfoBean  o1, TaskTantoInfoBean  o2) {

        String jsd1 = o1.getJimuStartYmd() == null ? "99999999999999999" : o1.getJimuStartYmd();
        String jsd2 = o2.getJimuStartYmd() == null ? "99999999999999999" : o2.getJimuStartYmd();

        return jsd1.compareTo(jsd2);
    }
}
