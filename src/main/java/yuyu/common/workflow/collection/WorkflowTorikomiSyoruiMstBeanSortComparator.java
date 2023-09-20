package yuyu.common.workflow.collection;

import java.util.Comparator;

import yuyu.common.workflow.workflowutility.TorikomiSyoruiMstBean;

/**
 * TorikomiSyoruiMstBean をソートするためのコンパレータです。<br />
 * ソート条件は｛取込書類コードの昇順｝です。
 */
public class WorkflowTorikomiSyoruiMstBeanSortComparator implements Comparator<TorikomiSyoruiMstBean> {

    @Override
    public int compare(TorikomiSyoruiMstBean o1, TorikomiSyoruiMstBean o2) {

        String syoruiCd1 = o1.getSyoruiCd() == null ? "" : o1.getSyoruiCd();
        String syoruiCd2 = o2.getSyoruiCd() == null ? "" : o2.getSyoruiCd() ;

        if (!syoruiCd1.equals(syoruiCd2)){
            if (syoruiCd1.equals((""))) {
                return -1;
            }
            if (syoruiCd2.equals("")) {
                return 1;
            }
            return syoruiCd1.compareTo(syoruiCd2);
        }
        return syoruiCd2.compareTo(syoruiCd1);

    }

}
