package yuyu.common.workflow.collection;

import java.util.Comparator;

import yuyu.common.workflow.workflowutility.TorikomiSyoruiMstSortBean;

/**
 * TorikomiSyoruiMstSortBean をソートするためのコンパレータです。<br />
 * ソート条件は｛ソート番号の昇順｝です。
 */
public class WorkflowTorikomiSyoruiMstSortBeanSortComparator implements Comparator<TorikomiSyoruiMstSortBean> {

    @Override
    public int compare(TorikomiSyoruiMstSortBean o1, TorikomiSyoruiMstSortBean o2) {

        int sortNo1 = o1.getSortNo() == null ? 0 : o1.getSortNo();
        int sortNo2 = o2.getSortNo() == null ? 0 : o2.getSortNo();

        if (sortNo1 != sortNo2){
            if (sortNo1 == 0) {
                return -1;
            }
            if (sortNo2 == 0) {
                return 1;
            }
            if (sortNo1 > sortNo2) {
                return 1;
            }
            return -1;
        }
        return 0;
    }
}
