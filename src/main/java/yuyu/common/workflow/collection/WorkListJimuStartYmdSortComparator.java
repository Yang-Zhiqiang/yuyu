package yuyu.common.workflow.collection;

import java.util.Comparator;

import yuyu.common.biz.workflow.io.koutei.sub.ProcessSummaryBean;

/**
 * ProcessSummaryBeanを事務開始年月日（拡張パラメータ１１）でソートするためのコンパレータです。<br />
 * ソート条件は｛拡張パラメータ１１（昇順）｝です。
 */
public class WorkListJimuStartYmdSortComparator implements Comparator<ProcessSummaryBean> {

    @Override
    public int compare(ProcessSummaryBean o1, ProcessSummaryBean o2) {

        String day1 = o1.getExtparamBean().getExtparam11() == null ? "99999999999999999" : o1.getExtparamBean().getExtparam11();
        String day2 = o2.getExtparamBean().getExtparam11() == null ? "99999999999999999" : o2.getExtparamBean().getExtparam11();


        return day1.compareTo(day2);
    }
}
