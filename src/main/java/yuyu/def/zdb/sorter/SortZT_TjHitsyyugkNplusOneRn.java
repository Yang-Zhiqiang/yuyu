package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_TjHitsyyugkNplusOneRn;
import yuyu.def.db.meta.QZT_TjHitsyyugkNplusOneRn;
import yuyu.def.zdb.comparator.OrderZT_TjHitsyyugkNplusOneRn;

public class SortZT_TjHitsyyugkNplusOneRn {

    
    public List<ZT_TjHitsyyugkNplusOneRn> OrderZT_TjHitsyyugkNplusOneRnByPkAsc(List<ZT_TjHitsyyugkNplusOneRn> pEntity) {
        List<SortCondition<ZT_TjHitsyyugkNplusOneRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_TjHitsyyugkNplusOneRn()).zrnsequenceno, SortOrder.ASC));
        List<ZT_TjHitsyyugkNplusOneRn> copyList = new ArrayList<ZT_TjHitsyyugkNplusOneRn>(pEntity);
        Collections.sort(copyList, new OrderZT_TjHitsyyugkNplusOneRn(orders));
        return copyList;
    }

    
    public List<ZT_TjHitsyyugkNplusOneRn> OrderZT_TjHitsyyugkNplusOneRnByPkDesc(List<ZT_TjHitsyyugkNplusOneRn> pEntity) {
        List<SortCondition<ZT_TjHitsyyugkNplusOneRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_TjHitsyyugkNplusOneRn()).zrnsequenceno, SortOrder.DESC));
        List<ZT_TjHitsyyugkNplusOneRn> copyList = new ArrayList<ZT_TjHitsyyugkNplusOneRn>(pEntity);
        Collections.sort(copyList, new OrderZT_TjHitsyyugkNplusOneRn(orders));
        return copyList;
    }
}
