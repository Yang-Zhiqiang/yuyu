package yuyu.def.siharai.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.JM_Byoumei;
import yuyu.def.db.meta.QJM_Byoumei;
import yuyu.def.siharai.comparator.OrderJM_Byoumei;

public class SortJM_Byoumei {

    
    public List<JM_Byoumei> OrderJM_ByoumeiByPkAsc(List<JM_Byoumei> pEntity) {
        List<SortCondition<JM_Byoumei>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QJM_Byoumei()).byoumeitourokuno, SortOrder.ASC));
        List<JM_Byoumei> copyList = new ArrayList<JM_Byoumei>(pEntity);
        Collections.sort(copyList, new OrderJM_Byoumei(orders));
        return copyList;
    }

    
    public List<JM_Byoumei> OrderJM_ByoumeiByPkDesc(List<JM_Byoumei> pEntity) {
        List<SortCondition<JM_Byoumei>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QJM_Byoumei()).byoumeitourokuno, SortOrder.DESC));
        List<JM_Byoumei> copyList = new ArrayList<JM_Byoumei>(pEntity);
        Collections.sort(copyList, new OrderJM_Byoumei(orders));
        return copyList;
    }

}

