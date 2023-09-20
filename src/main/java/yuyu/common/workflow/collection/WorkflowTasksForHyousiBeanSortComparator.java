package yuyu.common.workflow.collection;

import java.util.Comparator;

import yuyu.common.workflow.workflowutility.TaskSummaryForHyousiBean;

/**
 * TaskSummaryForHyousiBeanをソートするためのコンパレータです。<br />
 * ソート条件は｛工程開始年月日の降順｝です。
 */
public class WorkflowTasksForHyousiBeanSortComparator implements Comparator<TaskSummaryForHyousiBean> {

    @Override
    public int compare(TaskSummaryForHyousiBean o1, TaskSummaryForHyousiBean o2) {

        String day1 = o1.getKouteiKaisiYmd() == null ? "99999999" : o1.getKouteiKaisiYmd();
        String day2 = o2.getKouteiKaisiYmd() == null ? "99999999" : o2.getKouteiKaisiYmd();


        if ("".equals(day1)) {
            return -1;
        }
        if ("".equals(day2)) {
            return 1;
        }

        return day2.compareTo(day1);
    }
}
