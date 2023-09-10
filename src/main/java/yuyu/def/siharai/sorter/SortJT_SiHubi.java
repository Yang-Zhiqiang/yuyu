package yuyu.def.siharai.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.JT_SiHubi;
import yuyu.def.db.meta.QJT_SiHubi;
import yuyu.def.siharai.comparator.OrderJT_SiHubi;

public class SortJT_SiHubi {

    
    public List<JT_SiHubi> OrderJT_SiHubiByPkAsc(List<JT_SiHubi> pEntity) {
        List<SortCondition<JT_SiHubi>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QJT_SiHubi()).hubisikibetukey, SortOrder.ASC));
        List<JT_SiHubi> copyList = new ArrayList<JT_SiHubi>(pEntity);
        Collections.sort(copyList, new OrderJT_SiHubi(orders));
        return copyList;
    }

    
    public List<JT_SiHubi> OrderJT_SiHubiByPkDesc(List<JT_SiHubi> pEntity) {
        List<SortCondition<JT_SiHubi>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QJT_SiHubi()).hubisikibetukey, SortOrder.DESC));
        List<JT_SiHubi> copyList = new ArrayList<JT_SiHubi>(pEntity);
        Collections.sort(copyList, new OrderJT_SiHubi(orders));
        return copyList;
    }

}

