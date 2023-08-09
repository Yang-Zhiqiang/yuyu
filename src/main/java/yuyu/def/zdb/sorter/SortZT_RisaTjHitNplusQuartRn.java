package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_RisaTjHitNplusQuartRn;
import yuyu.def.db.meta.QZT_RisaTjHitNplusQuartRn;
import yuyu.def.zdb.comparator.OrderZT_RisaTjHitNplusQuartRn;

public class SortZT_RisaTjHitNplusQuartRn {

    
    public List<ZT_RisaTjHitNplusQuartRn> OrderZT_RisaTjHitNplusQuartRnByPkAsc(List<ZT_RisaTjHitNplusQuartRn> pEntity) {
        List<SortCondition<ZT_RisaTjHitNplusQuartRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_RisaTjHitNplusQuartRn()).zrnsequenceno, SortOrder.ASC));
        List<ZT_RisaTjHitNplusQuartRn> copyList = new ArrayList<ZT_RisaTjHitNplusQuartRn>(pEntity);
        Collections.sort(copyList, new OrderZT_RisaTjHitNplusQuartRn(orders));
        return copyList;
    }

    
    public List<ZT_RisaTjHitNplusQuartRn> OrderZT_RisaTjHitNplusQuartRnByPkDesc(List<ZT_RisaTjHitNplusQuartRn> pEntity) {
        List<SortCondition<ZT_RisaTjHitNplusQuartRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_RisaTjHitNplusQuartRn()).zrnsequenceno, SortOrder.DESC));
        List<ZT_RisaTjHitNplusQuartRn> copyList = new ArrayList<ZT_RisaTjHitNplusQuartRn>(pEntity);
        Collections.sort(copyList, new OrderZT_RisaTjHitNplusQuartRn(orders));
        return copyList;
    }
}
