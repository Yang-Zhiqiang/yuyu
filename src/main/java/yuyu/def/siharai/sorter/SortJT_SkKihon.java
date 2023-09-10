package yuyu.def.siharai.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.JT_SkKihon;
import yuyu.def.db.meta.QJT_SkKihon;
import yuyu.def.siharai.comparator.OrderJT_SkKihon;

public class SortJT_SkKihon {

    
    public List<JT_SkKihon> OrderJT_SkKihonByPkAsc(List<JT_SkKihon> pEntity) {
        List<SortCondition<JT_SkKihon>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QJT_SkKihon()).skno, SortOrder.ASC));
        orders.add(new SortCondition<>((new QJT_SkKihon()).syono, SortOrder.ASC));
        List<JT_SkKihon> copyList = new ArrayList<JT_SkKihon>(pEntity);
        Collections.sort(copyList, new OrderJT_SkKihon(orders));
        return copyList;
    }

    
    public List<JT_SkKihon> OrderJT_SkKihonByPkDesc(List<JT_SkKihon> pEntity) {
        List<SortCondition<JT_SkKihon>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QJT_SkKihon()).skno, SortOrder.DESC));
        orders.add(new SortCondition<>((new QJT_SkKihon()).syono, SortOrder.DESC));
        List<JT_SkKihon> copyList = new ArrayList<JT_SkKihon>(pEntity);
        Collections.sort(copyList, new OrderJT_SkKihon(orders));
        return copyList;
    }

}

