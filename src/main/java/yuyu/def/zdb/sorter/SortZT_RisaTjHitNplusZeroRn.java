package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_RisaTjHitNplusZeroRn;
import yuyu.def.db.meta.QZT_RisaTjHitNplusZeroRn;
import yuyu.def.zdb.comparator.OrderZT_RisaTjHitNplusZeroRn;

public class SortZT_RisaTjHitNplusZeroRn {

    
    public List<ZT_RisaTjHitNplusZeroRn> OrderZT_RisaTjHitNplusZeroRnByPkAsc(List<ZT_RisaTjHitNplusZeroRn> pEntity) {
        List<SortCondition<ZT_RisaTjHitNplusZeroRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_RisaTjHitNplusZeroRn()).zrnsequenceno, SortOrder.ASC));
        List<ZT_RisaTjHitNplusZeroRn> copyList = new ArrayList<ZT_RisaTjHitNplusZeroRn>(pEntity);
        Collections.sort(copyList, new OrderZT_RisaTjHitNplusZeroRn(orders));
        return copyList;
    }

    
    public List<ZT_RisaTjHitNplusZeroRn> OrderZT_RisaTjHitNplusZeroRnByPkDesc(List<ZT_RisaTjHitNplusZeroRn> pEntity) {
        List<SortCondition<ZT_RisaTjHitNplusZeroRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_RisaTjHitNplusZeroRn()).zrnsequenceno, SortOrder.DESC));
        List<ZT_RisaTjHitNplusZeroRn> copyList = new ArrayList<ZT_RisaTjHitNplusZeroRn>(pEntity);
        Collections.sort(copyList, new OrderZT_RisaTjHitNplusZeroRn(orders));
        return copyList;
    }
}
