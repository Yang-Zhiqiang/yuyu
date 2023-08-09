package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_RisaTjHitNplusQuartTy;
import yuyu.def.db.meta.QZT_RisaTjHitNplusQuartTy;
import yuyu.def.zdb.comparator.OrderZT_RisaTjHitNplusQuartTy;

public class SortZT_RisaTjHitNplusQuartTy {

    
    public List<ZT_RisaTjHitNplusQuartTy> OrderZT_RisaTjHitNplusQuartTyByPkAsc(List<ZT_RisaTjHitNplusQuartTy> pEntity) {
        List<SortCondition<ZT_RisaTjHitNplusQuartTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_RisaTjHitNplusQuartTy()).ztysequenceno, SortOrder.ASC));
        List<ZT_RisaTjHitNplusQuartTy> copyList = new ArrayList<ZT_RisaTjHitNplusQuartTy>(pEntity);
        Collections.sort(copyList, new OrderZT_RisaTjHitNplusQuartTy(orders));
        return copyList;
    }

    
    public List<ZT_RisaTjHitNplusQuartTy> OrderZT_RisaTjHitNplusQuartTyByPkDesc(List<ZT_RisaTjHitNplusQuartTy> pEntity) {
        List<SortCondition<ZT_RisaTjHitNplusQuartTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_RisaTjHitNplusQuartTy()).ztysequenceno, SortOrder.DESC));
        List<ZT_RisaTjHitNplusQuartTy> copyList = new ArrayList<ZT_RisaTjHitNplusQuartTy>(pEntity);
        Collections.sort(copyList, new OrderZT_RisaTjHitNplusQuartTy(orders));
        return copyList;
    }
}
