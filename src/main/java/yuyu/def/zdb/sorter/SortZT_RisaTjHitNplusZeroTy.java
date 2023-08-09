package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_RisaTjHitNplusZeroTy;
import yuyu.def.db.meta.QZT_RisaTjHitNplusZeroTy;
import yuyu.def.zdb.comparator.OrderZT_RisaTjHitNplusZeroTy;

public class SortZT_RisaTjHitNplusZeroTy {

    
    public List<ZT_RisaTjHitNplusZeroTy> OrderZT_RisaTjHitNplusZeroTyByPkAsc(List<ZT_RisaTjHitNplusZeroTy> pEntity) {
        List<SortCondition<ZT_RisaTjHitNplusZeroTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_RisaTjHitNplusZeroTy()).ztysequenceno, SortOrder.ASC));
        List<ZT_RisaTjHitNplusZeroTy> copyList = new ArrayList<ZT_RisaTjHitNplusZeroTy>(pEntity);
        Collections.sort(copyList, new OrderZT_RisaTjHitNplusZeroTy(orders));
        return copyList;
    }

    
    public List<ZT_RisaTjHitNplusZeroTy> OrderZT_RisaTjHitNplusZeroTyByPkDesc(List<ZT_RisaTjHitNplusZeroTy> pEntity) {
        List<SortCondition<ZT_RisaTjHitNplusZeroTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_RisaTjHitNplusZeroTy()).ztysequenceno, SortOrder.DESC));
        List<ZT_RisaTjHitNplusZeroTy> copyList = new ArrayList<ZT_RisaTjHitNplusZeroTy>(pEntity);
        Collections.sort(copyList, new OrderZT_RisaTjHitNplusZeroTy(orders));
        return copyList;
    }
}
