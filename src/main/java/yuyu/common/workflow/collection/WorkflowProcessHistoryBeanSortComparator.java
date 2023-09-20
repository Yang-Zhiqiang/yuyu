package yuyu.common.workflow.collection;

import java.util.Comparator;

import yuyu.common.workflow.workflowutility.ProcessHistoryBean;

/**
 * ProcessHistoryBeanをソートするためのコンパレータです。<br />
 * ソート条件は｛処理日時の降順｝です。
 */
public class WorkflowProcessHistoryBeanSortComparator implements Comparator<ProcessHistoryBean> {

    @Override
    public int compare(ProcessHistoryBean o1, ProcessHistoryBean o2) {

        String day1 = o1.getProcessYmdTime() == null ? "99999999999999" : o1.getProcessYmdTime();
        String day2 = o2.getProcessYmdTime() == null ? "99999999999999" : o2.getProcessYmdTime();


        return day2.compareTo(day1);
    }
}
