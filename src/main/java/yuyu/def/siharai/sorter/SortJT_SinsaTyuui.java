package yuyu.def.siharai.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.JT_SinsaTyuui;
import yuyu.def.db.meta.QJT_SinsaTyuui;
import yuyu.def.siharai.comparator.OrderJT_SinsaTyuui;

public class SortJT_SinsaTyuui {

    
    public List<JT_SinsaTyuui> OrderJT_SinsaTyuuiByPkAsc(List<JT_SinsaTyuui> pEntity) {
        List<SortCondition<JT_SinsaTyuui>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QJT_SinsaTyuui()).syono, SortOrder.ASC));
        List<JT_SinsaTyuui> copyList = new ArrayList<JT_SinsaTyuui>(pEntity);
        Collections.sort(copyList, new OrderJT_SinsaTyuui(orders));
        return copyList;
    }

    
    public List<JT_SinsaTyuui> OrderJT_SinsaTyuuiByPkDesc(List<JT_SinsaTyuui> pEntity) {
        List<SortCondition<JT_SinsaTyuui>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QJT_SinsaTyuui()).syono, SortOrder.DESC));
        List<JT_SinsaTyuui> copyList = new ArrayList<JT_SinsaTyuui>(pEntity);
        Collections.sort(copyList, new OrderJT_SinsaTyuui(orders));
        return copyList;
    }

}

