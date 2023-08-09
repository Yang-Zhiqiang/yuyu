package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_TjHitsyyugkNplusQuartTy;
import yuyu.def.db.meta.QZT_TjHitsyyugkNplusQuartTy;
import yuyu.def.zdb.comparator.OrderZT_TjHitsyyugkNplusQuartTy;

public class SortZT_TjHitsyyugkNplusQuartTy {

    
    public List<ZT_TjHitsyyugkNplusQuartTy> OrderZT_TjHitsyyugkNplusQuartTyByPkAsc(List<ZT_TjHitsyyugkNplusQuartTy> pEntity) {
        List<SortCondition<ZT_TjHitsyyugkNplusQuartTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_TjHitsyyugkNplusQuartTy()).ztysequenceno, SortOrder.ASC));
        List<ZT_TjHitsyyugkNplusQuartTy> copyList = new ArrayList<ZT_TjHitsyyugkNplusQuartTy>(pEntity);
        Collections.sort(copyList, new OrderZT_TjHitsyyugkNplusQuartTy(orders));
        return copyList;
    }

    
    public List<ZT_TjHitsyyugkNplusQuartTy> OrderZT_TjHitsyyugkNplusQuartTyByPkDesc(List<ZT_TjHitsyyugkNplusQuartTy> pEntity) {
        List<SortCondition<ZT_TjHitsyyugkNplusQuartTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_TjHitsyyugkNplusQuartTy()).ztysequenceno, SortOrder.DESC));
        List<ZT_TjHitsyyugkNplusQuartTy> copyList = new ArrayList<ZT_TjHitsyyugkNplusQuartTy>(pEntity);
        Collections.sort(copyList, new OrderZT_TjHitsyyugkNplusQuartTy(orders));
        return copyList;
    }
}
