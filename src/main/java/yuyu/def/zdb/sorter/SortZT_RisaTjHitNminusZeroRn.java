package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_RisaTjHitNminusZeroRn;
import yuyu.def.db.meta.QZT_RisaTjHitNminusZeroRn;
import yuyu.def.zdb.comparator.OrderZT_RisaTjHitNminusZeroRn;

public class SortZT_RisaTjHitNminusZeroRn {

    
    public List<ZT_RisaTjHitNminusZeroRn> OrderZT_RisaTjHitNminusZeroRnByPkAsc(List<ZT_RisaTjHitNminusZeroRn> pEntity) {
        List<SortCondition<ZT_RisaTjHitNminusZeroRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_RisaTjHitNminusZeroRn()).zrnsequenceno, SortOrder.ASC));
        List<ZT_RisaTjHitNminusZeroRn> copyList = new ArrayList<ZT_RisaTjHitNminusZeroRn>(pEntity);
        Collections.sort(copyList, new OrderZT_RisaTjHitNminusZeroRn(orders));
        return copyList;
    }

    
    public List<ZT_RisaTjHitNminusZeroRn> OrderZT_RisaTjHitNminusZeroRnByPkDesc(List<ZT_RisaTjHitNminusZeroRn> pEntity) {
        List<SortCondition<ZT_RisaTjHitNminusZeroRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_RisaTjHitNminusZeroRn()).zrnsequenceno, SortOrder.DESC));
        List<ZT_RisaTjHitNminusZeroRn> copyList = new ArrayList<ZT_RisaTjHitNminusZeroRn>(pEntity);
        Collections.sort(copyList, new OrderZT_RisaTjHitNminusZeroRn(orders));
        return copyList;
    }
}
