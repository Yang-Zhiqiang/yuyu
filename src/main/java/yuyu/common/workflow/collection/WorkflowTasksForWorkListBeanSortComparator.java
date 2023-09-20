package yuyu.common.workflow.collection;

import java.util.Comparator;

import yuyu.common.workflow.workflowutility.TaskSummaryForWorkListBean;

/**
 * TaskSummaryForWorkListBeanをソートするためのコンパレータです。<br />
 * ソート条件は｛事務開始年月日（昇順）｝です。
 */
public class WorkflowTasksForWorkListBeanSortComparator implements Comparator<TaskSummaryForWorkListBean> {

    @Override
    public int compare(TaskSummaryForWorkListBean o1, TaskSummaryForWorkListBean o2) {

        String day1 = o1.getJimuStartYmd() == null ? "99999999999999999" : o1.getJimuStartYmd();
        String day2 = o2.getJimuStartYmd() == null ? "99999999999999999" : o2.getJimuStartYmd();


        return day1.compareTo(day2);
    }
}
