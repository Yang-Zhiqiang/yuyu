package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_TjHitsyyugkNplusTwoTy;
import yuyu.def.db.meta.QZT_TjHitsyyugkNplusTwoTy;
import yuyu.def.zdb.comparator.OrderZT_TjHitsyyugkNplusTwoTy;

public class SortZT_TjHitsyyugkNplusTwoTy {

    
    public List<ZT_TjHitsyyugkNplusTwoTy> OrderZT_TjHitsyyugkNplusTwoTyByPkAsc(List<ZT_TjHitsyyugkNplusTwoTy> pEntity) {
        List<SortCondition<ZT_TjHitsyyugkNplusTwoTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_TjHitsyyugkNplusTwoTy()).ztysequenceno, SortOrder.ASC));
        List<ZT_TjHitsyyugkNplusTwoTy> copyList = new ArrayList<ZT_TjHitsyyugkNplusTwoTy>(pEntity);
        Collections.sort(copyList, new OrderZT_TjHitsyyugkNplusTwoTy(orders));
        return copyList;
    }

    
    public List<ZT_TjHitsyyugkNplusTwoTy> OrderZT_TjHitsyyugkNplusTwoTyByPkDesc(List<ZT_TjHitsyyugkNplusTwoTy> pEntity) {
        List<SortCondition<ZT_TjHitsyyugkNplusTwoTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_TjHitsyyugkNplusTwoTy()).ztysequenceno, SortOrder.DESC));
        List<ZT_TjHitsyyugkNplusTwoTy> copyList = new ArrayList<ZT_TjHitsyyugkNplusTwoTy>(pEntity);
        Collections.sort(copyList, new OrderZT_TjHitsyyugkNplusTwoTy(orders));
        return copyList;
    }
}
