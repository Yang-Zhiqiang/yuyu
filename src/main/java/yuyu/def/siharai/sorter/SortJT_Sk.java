package yuyu.def.siharai.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.JT_Sk;
import yuyu.def.db.meta.QJT_Sk;
import yuyu.def.siharai.comparator.OrderJT_Sk;

public class SortJT_Sk {

    
    public List<JT_Sk> OrderJT_SkByPkAsc(List<JT_Sk> pEntity) {
        List<SortCondition<JT_Sk>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QJT_Sk()).skno, SortOrder.ASC));
        orders.add(new SortCondition<>((new QJT_Sk()).syono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QJT_Sk()).seikyuurirekino, SortOrder.ASC));
        List<JT_Sk> copyList = new ArrayList<JT_Sk>(pEntity);
        Collections.sort(copyList, new OrderJT_Sk(orders));
        return copyList;
    }

    
    public List<JT_Sk> OrderJT_SkByPkDesc(List<JT_Sk> pEntity) {
        List<SortCondition<JT_Sk>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QJT_Sk()).skno, SortOrder.DESC));
        orders.add(new SortCondition<>((new QJT_Sk()).syono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QJT_Sk()).seikyuurirekino, SortOrder.DESC));
        List<JT_Sk> copyList = new ArrayList<JT_Sk>(pEntity);
        Collections.sort(copyList, new OrderJT_Sk(orders));
        return copyList;
    }

}

