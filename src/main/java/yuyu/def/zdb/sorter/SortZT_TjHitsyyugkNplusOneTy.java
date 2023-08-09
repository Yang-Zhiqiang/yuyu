package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_TjHitsyyugkNplusOneTy;
import yuyu.def.db.meta.QZT_TjHitsyyugkNplusOneTy;
import yuyu.def.zdb.comparator.OrderZT_TjHitsyyugkNplusOneTy;

public class SortZT_TjHitsyyugkNplusOneTy {

    
    public List<ZT_TjHitsyyugkNplusOneTy> OrderZT_TjHitsyyugkNplusOneTyByPkAsc(List<ZT_TjHitsyyugkNplusOneTy> pEntity) {
        List<SortCondition<ZT_TjHitsyyugkNplusOneTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_TjHitsyyugkNplusOneTy()).ztysequenceno, SortOrder.ASC));
        List<ZT_TjHitsyyugkNplusOneTy> copyList = new ArrayList<ZT_TjHitsyyugkNplusOneTy>(pEntity);
        Collections.sort(copyList, new OrderZT_TjHitsyyugkNplusOneTy(orders));
        return copyList;
    }

    
    public List<ZT_TjHitsyyugkNplusOneTy> OrderZT_TjHitsyyugkNplusOneTyByPkDesc(List<ZT_TjHitsyyugkNplusOneTy> pEntity) {
        List<SortCondition<ZT_TjHitsyyugkNplusOneTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_TjHitsyyugkNplusOneTy()).ztysequenceno, SortOrder.DESC));
        List<ZT_TjHitsyyugkNplusOneTy> copyList = new ArrayList<ZT_TjHitsyyugkNplusOneTy>(pEntity);
        Collections.sort(copyList, new OrderZT_TjHitsyyugkNplusOneTy(orders));
        return copyList;
    }
}
