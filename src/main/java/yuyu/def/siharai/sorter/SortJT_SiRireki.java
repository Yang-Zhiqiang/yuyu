package yuyu.def.siharai.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.JT_SiRireki;
import yuyu.def.db.meta.QJT_SiRireki;
import yuyu.def.siharai.comparator.OrderJT_SiRireki;

public class SortJT_SiRireki {

    
    public List<JT_SiRireki> OrderJT_SiRirekiByPkAsc(List<JT_SiRireki> pEntity) {
        List<SortCondition<JT_SiRireki>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QJT_SiRireki()).skno, SortOrder.ASC));
        orders.add(new SortCondition<>((new QJT_SiRireki()).syono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QJT_SiRireki()).shrsikibetukey, SortOrder.ASC));
        List<JT_SiRireki> copyList = new ArrayList<JT_SiRireki>(pEntity);
        Collections.sort(copyList, new OrderJT_SiRireki(orders));
        return copyList;
    }

    
    public List<JT_SiRireki> OrderJT_SiRirekiByPkDesc(List<JT_SiRireki> pEntity) {
        List<SortCondition<JT_SiRireki>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QJT_SiRireki()).skno, SortOrder.DESC));
        orders.add(new SortCondition<>((new QJT_SiRireki()).syono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QJT_SiRireki()).shrsikibetukey, SortOrder.DESC));
        List<JT_SiRireki> copyList = new ArrayList<JT_SiRireki>(pEntity);
        Collections.sort(copyList, new OrderJT_SiRireki(orders));
        return copyList;
    }

}

