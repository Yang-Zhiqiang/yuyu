package yuyu.def.siharai.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.JT_SibouKariuketsuke;
import yuyu.def.db.meta.QJT_SibouKariuketsuke;
import yuyu.def.siharai.comparator.OrderJT_SibouKariuketsuke;

public class SortJT_SibouKariuketsuke {

    
    public List<JT_SibouKariuketsuke> OrderJT_SibouKariuketsukeByPkAsc(List<JT_SibouKariuketsuke> pEntity) {
        List<SortCondition<JT_SibouKariuketsuke>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QJT_SibouKariuketsuke()).skno, SortOrder.ASC));
        orders.add(new SortCondition<>((new QJT_SibouKariuketsuke()).syono, SortOrder.ASC));
        List<JT_SibouKariuketsuke> copyList = new ArrayList<JT_SibouKariuketsuke>(pEntity);
        Collections.sort(copyList, new OrderJT_SibouKariuketsuke(orders));
        return copyList;
    }

    
    public List<JT_SibouKariuketsuke> OrderJT_SibouKariuketsukeByPkDesc(List<JT_SibouKariuketsuke> pEntity) {
        List<SortCondition<JT_SibouKariuketsuke>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QJT_SibouKariuketsuke()).skno, SortOrder.DESC));
        orders.add(new SortCondition<>((new QJT_SibouKariuketsuke()).syono, SortOrder.DESC));
        List<JT_SibouKariuketsuke> copyList = new ArrayList<JT_SibouKariuketsuke>(pEntity);
        Collections.sort(copyList, new OrderJT_SibouKariuketsuke(orders));
        return copyList;
    }

}

