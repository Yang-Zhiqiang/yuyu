package yuyu.def.siharai.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.JT_SiUkt;
import yuyu.def.db.meta.QJT_SiUkt;
import yuyu.def.siharai.comparator.OrderJT_SiUkt;

public class SortJT_SiUkt {

    
    public List<JT_SiUkt> OrderJT_SiUktByPkAsc(List<JT_SiUkt> pEntity) {
        List<SortCondition<JT_SiUkt>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QJT_SiUkt()).syono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QJT_SiUkt()).hkuktsyu, SortOrder.ASC));
        orders.add(new SortCondition<>((new QJT_SiUkt()).uktsyurenno, SortOrder.ASC));
        List<JT_SiUkt> copyList = new ArrayList<JT_SiUkt>(pEntity);
        Collections.sort(copyList, new OrderJT_SiUkt(orders));
        return copyList;
    }

    
    public List<JT_SiUkt> OrderJT_SiUktByPkDesc(List<JT_SiUkt> pEntity) {
        List<SortCondition<JT_SiUkt>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QJT_SiUkt()).syono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QJT_SiUkt()).hkuktsyu, SortOrder.DESC));
        orders.add(new SortCondition<>((new QJT_SiUkt()).uktsyurenno, SortOrder.DESC));
        List<JT_SiUkt> copyList = new ArrayList<JT_SiUkt>(pEntity);
        Collections.sort(copyList, new OrderJT_SiUkt(orders));
        return copyList;
    }

}

