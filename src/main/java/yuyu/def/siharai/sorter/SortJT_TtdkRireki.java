package yuyu.def.siharai.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.JT_TtdkRireki;
import yuyu.def.db.meta.QJT_TtdkRireki;
import yuyu.def.siharai.comparator.OrderJT_TtdkRireki;

public class SortJT_TtdkRireki {

    
    public List<JT_TtdkRireki> OrderJT_TtdkRirekiByPkAsc(List<JT_TtdkRireki> pEntity) {
        List<SortCondition<JT_TtdkRireki>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QJT_TtdkRireki()).skno, SortOrder.ASC));
        orders.add(new SortCondition<>((new QJT_TtdkRireki()).syono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QJT_TtdkRireki()).ttdkrrkskbtkey, SortOrder.ASC));
        List<JT_TtdkRireki> copyList = new ArrayList<JT_TtdkRireki>(pEntity);
        Collections.sort(copyList, new OrderJT_TtdkRireki(orders));
        return copyList;
    }

    
    public List<JT_TtdkRireki> OrderJT_TtdkRirekiByPkDesc(List<JT_TtdkRireki> pEntity) {
        List<SortCondition<JT_TtdkRireki>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QJT_TtdkRireki()).skno, SortOrder.DESC));
        orders.add(new SortCondition<>((new QJT_TtdkRireki()).syono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QJT_TtdkRireki()).ttdkrrkskbtkey, SortOrder.DESC));
        List<JT_TtdkRireki> copyList = new ArrayList<JT_TtdkRireki>(pEntity);
        Collections.sort(copyList, new OrderJT_TtdkRireki(orders));
        return copyList;
    }
    
    public List<JT_TtdkRireki> OrderJT_TtdkRirekiByGyoumuKousinTimeDesc(List<JT_TtdkRireki> pEntity) {
        List<SortCondition<JT_TtdkRireki>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QJT_TtdkRireki()).gyoumuKousinTime, SortOrder.DESC));
        List<JT_TtdkRireki> copyList = new ArrayList<JT_TtdkRireki>(pEntity);
        Collections.sort(copyList, new OrderJT_TtdkRireki(orders));
        return copyList;
    }


}

