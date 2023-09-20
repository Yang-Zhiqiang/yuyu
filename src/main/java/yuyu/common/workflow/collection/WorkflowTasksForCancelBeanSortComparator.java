package yuyu.common.workflow.collection;

import java.util.Comparator;

import yuyu.common.workflow.workflowutility.TaskForCancelBean;

/**
 * TaskForCancelBeanをソートするためのコンパレータです。<br />
 * ソート条件は｛工程開始日の昇順｝です。
 */
public class WorkflowTasksForCancelBeanSortComparator implements Comparator<TaskForCancelBean> {

    @Override
    public int compare(TaskForCancelBean o1, TaskForCancelBean o2) {

        String day1 = o1.getKouteiKaisiYmd() == null ? "99999999" : o1.getKouteiKaisiYmd();
        String day2 = o2.getKouteiKaisiYmd() == null ? "99999999" : o2.getKouteiKaisiYmd();


        return day1.compareTo(day2);
    }
}
