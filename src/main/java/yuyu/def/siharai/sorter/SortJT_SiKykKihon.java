package yuyu.def.siharai.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.JT_SiKykKihon;
import yuyu.def.db.meta.QJT_SiKykKihon;
import yuyu.def.siharai.comparator.OrderJT_SiKykKihon;

public class SortJT_SiKykKihon {

    
    public List<JT_SiKykKihon> OrderJT_SiKykKihonByPkAsc(List<JT_SiKykKihon> pEntity) {
        List<SortCondition<JT_SiKykKihon>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QJT_SiKykKihon()).syono, SortOrder.ASC));
        List<JT_SiKykKihon> copyList = new ArrayList<JT_SiKykKihon>(pEntity);
        Collections.sort(copyList, new OrderJT_SiKykKihon(orders));
        return copyList;
    }

    
    public List<JT_SiKykKihon> OrderJT_SiKykKihonByPkDesc(List<JT_SiKykKihon> pEntity) {
        List<SortCondition<JT_SiKykKihon>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QJT_SiKykKihon()).syono, SortOrder.DESC));
        List<JT_SiKykKihon> copyList = new ArrayList<JT_SiKykKihon>(pEntity);
        Collections.sort(copyList, new OrderJT_SiKykKihon(orders));
        return copyList;
    }

}

