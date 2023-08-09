package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_TjHitsyyugkNminusZeroRn;
import yuyu.def.db.meta.QZT_TjHitsyyugkNminusZeroRn;
import yuyu.def.zdb.comparator.OrderZT_TjHitsyyugkNminusZeroRn;

public class SortZT_TjHitsyyugkNminusZeroRn {

    
    public List<ZT_TjHitsyyugkNminusZeroRn> OrderZT_TjHitsyyugkNminusZeroRnByPkAsc(List<ZT_TjHitsyyugkNminusZeroRn> pEntity) {
        List<SortCondition<ZT_TjHitsyyugkNminusZeroRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_TjHitsyyugkNminusZeroRn()).zrnsequenceno, SortOrder.ASC));
        List<ZT_TjHitsyyugkNminusZeroRn> copyList = new ArrayList<ZT_TjHitsyyugkNminusZeroRn>(pEntity);
        Collections.sort(copyList, new OrderZT_TjHitsyyugkNminusZeroRn(orders));
        return copyList;
    }

    
    public List<ZT_TjHitsyyugkNminusZeroRn> OrderZT_TjHitsyyugkNminusZeroRnByPkDesc(List<ZT_TjHitsyyugkNminusZeroRn> pEntity) {
        List<SortCondition<ZT_TjHitsyyugkNminusZeroRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_TjHitsyyugkNminusZeroRn()).zrnsequenceno, SortOrder.DESC));
        List<ZT_TjHitsyyugkNminusZeroRn> copyList = new ArrayList<ZT_TjHitsyyugkNminusZeroRn>(pEntity);
        Collections.sort(copyList, new OrderZT_TjHitsyyugkNminusZeroRn(orders));
        return copyList;
    }
}
