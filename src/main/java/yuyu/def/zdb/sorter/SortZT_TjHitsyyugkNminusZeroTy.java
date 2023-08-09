package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_TjHitsyyugkNminusZeroTy;
import yuyu.def.db.meta.QZT_TjHitsyyugkNminusZeroTy;
import yuyu.def.zdb.comparator.OrderZT_TjHitsyyugkNminusZeroTy;

public class SortZT_TjHitsyyugkNminusZeroTy {

    
    public List<ZT_TjHitsyyugkNminusZeroTy> OrderZT_TjHitsyyugkNminusZeroTyByPkAsc(List<ZT_TjHitsyyugkNminusZeroTy> pEntity) {
        List<SortCondition<ZT_TjHitsyyugkNminusZeroTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_TjHitsyyugkNminusZeroTy()).ztysequenceno, SortOrder.ASC));
        List<ZT_TjHitsyyugkNminusZeroTy> copyList = new ArrayList<ZT_TjHitsyyugkNminusZeroTy>(pEntity);
        Collections.sort(copyList, new OrderZT_TjHitsyyugkNminusZeroTy(orders));
        return copyList;
    }

    
    public List<ZT_TjHitsyyugkNminusZeroTy> OrderZT_TjHitsyyugkNminusZeroTyByPkDesc(List<ZT_TjHitsyyugkNminusZeroTy> pEntity) {
        List<SortCondition<ZT_TjHitsyyugkNminusZeroTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_TjHitsyyugkNminusZeroTy()).ztysequenceno, SortOrder.DESC));
        List<ZT_TjHitsyyugkNminusZeroTy> copyList = new ArrayList<ZT_TjHitsyyugkNminusZeroTy>(pEntity);
        Collections.sort(copyList, new OrderZT_TjHitsyyugkNminusZeroTy(orders));
        return copyList;
    }
}
