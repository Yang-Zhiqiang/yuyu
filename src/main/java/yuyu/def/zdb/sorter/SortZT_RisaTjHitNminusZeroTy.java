package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_RisaTjHitNminusZeroTy;
import yuyu.def.db.meta.QZT_RisaTjHitNminusZeroTy;
import yuyu.def.zdb.comparator.OrderZT_RisaTjHitNminusZeroTy;

public class SortZT_RisaTjHitNminusZeroTy {

    
    public List<ZT_RisaTjHitNminusZeroTy> OrderZT_RisaTjHitNminusZeroTyByPkAsc(List<ZT_RisaTjHitNminusZeroTy> pEntity) {
        List<SortCondition<ZT_RisaTjHitNminusZeroTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_RisaTjHitNminusZeroTy()).ztysequenceno, SortOrder.ASC));
        List<ZT_RisaTjHitNminusZeroTy> copyList = new ArrayList<ZT_RisaTjHitNminusZeroTy>(pEntity);
        Collections.sort(copyList, new OrderZT_RisaTjHitNminusZeroTy(orders));
        return copyList;
    }

    
    public List<ZT_RisaTjHitNminusZeroTy> OrderZT_RisaTjHitNminusZeroTyByPkDesc(List<ZT_RisaTjHitNminusZeroTy> pEntity) {
        List<SortCondition<ZT_RisaTjHitNminusZeroTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_RisaTjHitNminusZeroTy()).ztysequenceno, SortOrder.DESC));
        List<ZT_RisaTjHitNminusZeroTy> copyList = new ArrayList<ZT_RisaTjHitNminusZeroTy>(pEntity);
        Collections.sort(copyList, new OrderZT_RisaTjHitNminusZeroTy(orders));
        return copyList;
    }
}
