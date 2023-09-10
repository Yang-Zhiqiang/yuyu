package yuyu.def.siharai.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.JT_MisyuupRendo;
import yuyu.def.db.meta.QJT_MisyuupRendo;
import yuyu.def.siharai.comparator.OrderJT_MisyuupRendo;

public class SortJT_MisyuupRendo {

    
    public List<JT_MisyuupRendo> OrderJT_MisyuupRendoByPkAsc(List<JT_MisyuupRendo> pEntity) {
        List<SortCondition<JT_MisyuupRendo>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QJT_MisyuupRendo()).syono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QJT_MisyuupRendo()).datarenno, SortOrder.ASC));
        List<JT_MisyuupRendo> copyList = new ArrayList<JT_MisyuupRendo>(pEntity);
        Collections.sort(copyList, new OrderJT_MisyuupRendo(orders));
        return copyList;
    }

    
    public List<JT_MisyuupRendo> OrderJT_MisyuupRendoByPkDesc(List<JT_MisyuupRendo> pEntity) {
        List<SortCondition<JT_MisyuupRendo>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QJT_MisyuupRendo()).syono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QJT_MisyuupRendo()).datarenno, SortOrder.DESC));
        List<JT_MisyuupRendo> copyList = new ArrayList<JT_MisyuupRendo>(pEntity);
        Collections.sort(copyList, new OrderJT_MisyuupRendo(orders));
        return copyList;
    }

}

