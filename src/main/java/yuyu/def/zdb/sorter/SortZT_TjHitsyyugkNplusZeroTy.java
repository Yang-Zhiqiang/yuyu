package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_TjHitsyyugkNplusZeroTy;
import yuyu.def.db.meta.QZT_TjHitsyyugkNplusZeroTy;
import yuyu.def.zdb.comparator.OrderZT_TjHitsyyugkNplusZeroTy;

public class SortZT_TjHitsyyugkNplusZeroTy {

    
    public List<ZT_TjHitsyyugkNplusZeroTy> OrderZT_TjHitsyyugkNplusZeroTyByPkAsc(List<ZT_TjHitsyyugkNplusZeroTy> pEntity) {
        List<SortCondition<ZT_TjHitsyyugkNplusZeroTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_TjHitsyyugkNplusZeroTy()).ztysequenceno, SortOrder.ASC));
        List<ZT_TjHitsyyugkNplusZeroTy> copyList = new ArrayList<ZT_TjHitsyyugkNplusZeroTy>(pEntity);
        Collections.sort(copyList, new OrderZT_TjHitsyyugkNplusZeroTy(orders));
        return copyList;
    }

    
    public List<ZT_TjHitsyyugkNplusZeroTy> OrderZT_TjHitsyyugkNplusZeroTyByPkDesc(List<ZT_TjHitsyyugkNplusZeroTy> pEntity) {
        List<SortCondition<ZT_TjHitsyyugkNplusZeroTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_TjHitsyyugkNplusZeroTy()).ztysequenceno, SortOrder.DESC));
        List<ZT_TjHitsyyugkNplusZeroTy> copyList = new ArrayList<ZT_TjHitsyyugkNplusZeroTy>(pEntity);
        Collections.sort(copyList, new OrderZT_TjHitsyyugkNplusZeroTy(orders));
        return copyList;
    }
}
