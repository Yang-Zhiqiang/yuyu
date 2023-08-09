package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_TjHitsyyugkNplusQuartRn;
import yuyu.def.db.meta.QZT_TjHitsyyugkNplusQuartRn;
import yuyu.def.zdb.comparator.OrderZT_TjHitsyyugkNplusQuartRn;

public class SortZT_TjHitsyyugkNplusQuartRn {

    
    public List<ZT_TjHitsyyugkNplusQuartRn> OrderZT_TjHitsyyugkNplusQuartRnByPkAsc(List<ZT_TjHitsyyugkNplusQuartRn> pEntity) {
        List<SortCondition<ZT_TjHitsyyugkNplusQuartRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_TjHitsyyugkNplusQuartRn()).zrnsequenceno, SortOrder.ASC));
        List<ZT_TjHitsyyugkNplusQuartRn> copyList = new ArrayList<ZT_TjHitsyyugkNplusQuartRn>(pEntity);
        Collections.sort(copyList, new OrderZT_TjHitsyyugkNplusQuartRn(orders));
        return copyList;
    }

    
    public List<ZT_TjHitsyyugkNplusQuartRn> OrderZT_TjHitsyyugkNplusQuartRnByPkDesc(List<ZT_TjHitsyyugkNplusQuartRn> pEntity) {
        List<SortCondition<ZT_TjHitsyyugkNplusQuartRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_TjHitsyyugkNplusQuartRn()).zrnsequenceno, SortOrder.DESC));
        List<ZT_TjHitsyyugkNplusQuartRn> copyList = new ArrayList<ZT_TjHitsyyugkNplusQuartRn>(pEntity);
        Collections.sort(copyList, new OrderZT_TjHitsyyugkNplusQuartRn(orders));
        return copyList;
    }
}
