package yuyu.def.siharai.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.JT_Outai;
import yuyu.def.db.meta.QJT_Outai;
import yuyu.def.siharai.comparator.OrderJT_Outai;

public class SortJT_Outai {

    
    public List<JT_Outai> OrderJT_OutaiByPkAsc(List<JT_Outai> pEntity) {
        List<SortCondition<JT_Outai>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QJT_Outai()).syono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QJT_Outai()).renno, SortOrder.ASC));
        List<JT_Outai> copyList = new ArrayList<JT_Outai>(pEntity);
        Collections.sort(copyList, new OrderJT_Outai(orders));
        return copyList;
    }

    
    public List<JT_Outai> OrderJT_OutaiByPkDesc(List<JT_Outai> pEntity) {
        List<SortCondition<JT_Outai>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QJT_Outai()).syono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QJT_Outai()).renno, SortOrder.DESC));
        List<JT_Outai> copyList = new ArrayList<JT_Outai>(pEntity);
        Collections.sort(copyList, new OrderJT_Outai(orders));
        return copyList;
    }

}

