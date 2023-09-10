package yuyu.def.siharai.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.JT_Mouside;
import yuyu.def.db.meta.QJT_Mouside;
import yuyu.def.siharai.comparator.OrderJT_Mouside;

public class SortJT_Mouside {

    
    public List<JT_Mouside> OrderJT_MousideByPkAsc(List<JT_Mouside> pEntity) {
        List<SortCondition<JT_Mouside>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QJT_Mouside()).skno, SortOrder.ASC));
        orders.add(new SortCondition<>((new QJT_Mouside()).syono, SortOrder.ASC));
        List<JT_Mouside> copyList = new ArrayList<JT_Mouside>(pEntity);
        Collections.sort(copyList, new OrderJT_Mouside(orders));
        return copyList;
    }

    
    public List<JT_Mouside> OrderJT_MousideByPkDesc(List<JT_Mouside> pEntity) {
        List<SortCondition<JT_Mouside>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QJT_Mouside()).skno, SortOrder.DESC));
        orders.add(new SortCondition<>((new QJT_Mouside()).syono, SortOrder.DESC));
        List<JT_Mouside> copyList = new ArrayList<JT_Mouside>(pEntity);
        Collections.sort(copyList, new OrderJT_Mouside(orders));
        return copyList;
    }

}

