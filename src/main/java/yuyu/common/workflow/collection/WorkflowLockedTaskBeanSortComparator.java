package yuyu.common.workflow.collection;

import java.util.Comparator;

import yuyu.common.workflow.workflowutility.LockedTaskSummaryBean;

/**
 * LockedTaskSummaryBeanをソートするためのコンパレータです。<br />
 * ソート条件は｛申込番号の昇順、証券番号の昇順、年金証書番号の昇順｝です。
 */
public class WorkflowLockedTaskBeanSortComparator implements Comparator<LockedTaskSummaryBean> {

    @Override
    public int compare(LockedTaskSummaryBean o1, LockedTaskSummaryBean o2) {

        String mos1 = o1.getMosNo() == null ? "" : o1.getMosNo();
        String mos2 = o2.getMosNo() == null ? "" : o2.getMosNo();

        String syo1 = o1.getSyoNo() == null ? "" : o1.getSyoNo();
        String syo2 = o2.getSyoNo() == null ? "" : o2.getSyoNo();

        String nkSy1 = o1.getNkSysyNo() == null ? "" : o1.getNkSysyNo();
        String nkSy2 = o2.getNkSysyNo() == null ? "" : o2.getNkSysyNo();

        if (!mos1.equals(mos2)) {
            if (mos1.equals("")) {
                return -1;
            }
            if (mos2.equals("")) {
                return 1;
            }

            return mos1.compareTo(mos2);
        }
        else if (!syo1.equals(syo2)) {
            if (syo1.equals("")) {
                return -1;
            }
            if (syo2.equals("")) {
                return 1;
            }

            return syo1.compareTo(syo2);
        }
        else {
            if (nkSy1.equals("")) {
                return -1;
            }
            if (nkSy2.equals("")) {
                return 1;
            }

            return nkSy1.compareTo(nkSy2);
        }
    }
}
