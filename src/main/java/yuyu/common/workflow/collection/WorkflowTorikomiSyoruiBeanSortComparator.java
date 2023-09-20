package yuyu.common.workflow.collection;

import java.util.Comparator;

import yuyu.common.workflowcore.core.webservice.provide.imagekanri.gettorikomisyoruimst.WSGetTorikomiSyoruiMstResponse.TorikomiSyoruiBean;

/**
 * TorikomiSyoruiBean をソートするためのコンパレータです。<br />
 * ソート条件は｛取込書類コードの昇順｝です。
 */
public class WorkflowTorikomiSyoruiBeanSortComparator implements Comparator<TorikomiSyoruiBean> {

    @Override
    public int compare(TorikomiSyoruiBean  o1, TorikomiSyoruiBean  o2) {

        String syoruiCd1 = o1.getTorikomisyoruicd() == null ? "" : o1.getTorikomisyoruicd();
        String syoruiCd2 = o2.getTorikomisyoruicd() == null ? "" : o2.getTorikomisyoruicd();

        if(syoruiCd1.equals("")) {
            return -1;
        }
        if(syoruiCd2.equals("")) {
            return 1;
        }

        return syoruiCd1.compareTo(syoruiCd2);
    }
}
