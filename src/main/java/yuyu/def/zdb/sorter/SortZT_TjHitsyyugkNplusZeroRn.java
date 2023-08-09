package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_TjHitsyyugkNplusZeroRn;
import yuyu.def.db.meta.QZT_TjHitsyyugkNplusZeroRn;
import yuyu.def.zdb.comparator.OrderZT_TjHitsyyugkNplusZeroRn;

public class SortZT_TjHitsyyugkNplusZeroRn {

    
    public List<ZT_TjHitsyyugkNplusZeroRn> OrderZT_TjHitsyyugkNplusZeroRnByPkAsc(List<ZT_TjHitsyyugkNplusZeroRn> pEntity) {
        List<SortCondition<ZT_TjHitsyyugkNplusZeroRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_TjHitsyyugkNplusZeroRn()).zrnsequenceno, SortOrder.ASC));
        List<ZT_TjHitsyyugkNplusZeroRn> copyList = new ArrayList<ZT_TjHitsyyugkNplusZeroRn>(pEntity);
        Collections.sort(copyList, new OrderZT_TjHitsyyugkNplusZeroRn(orders));
        return copyList;
    }

    
    public List<ZT_TjHitsyyugkNplusZeroRn> OrderZT_TjHitsyyugkNplusZeroRnByPkDesc(List<ZT_TjHitsyyugkNplusZeroRn> pEntity) {
        List<SortCondition<ZT_TjHitsyyugkNplusZeroRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_TjHitsyyugkNplusZeroRn()).zrnsequenceno, SortOrder.DESC));
        List<ZT_TjHitsyyugkNplusZeroRn> copyList = new ArrayList<ZT_TjHitsyyugkNplusZeroRn>(pEntity);
        Collections.sort(copyList, new OrderZT_TjHitsyyugkNplusZeroRn(orders));
        return copyList;
    }
}
