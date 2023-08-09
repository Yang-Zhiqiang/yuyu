package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_NkHitKtyTy;
import yuyu.def.db.meta.QZT_NkHitKtyTy;
import yuyu.def.zdb.comparator.OrderZT_NkHitKtyTy;

public class SortZT_NkHitKtyTy {

    
    public List<ZT_NkHitKtyTy> OrderZT_NkHitKtyTyByPkAsc(List<ZT_NkHitKtyTy> pEntity) {
        List<SortCondition<ZT_NkHitKtyTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_NkHitKtyTy()).ztynksyousyono, SortOrder.ASC));
        List<ZT_NkHitKtyTy> copyList = new ArrayList<ZT_NkHitKtyTy>(pEntity);
        Collections.sort(copyList, new OrderZT_NkHitKtyTy(orders));
        return copyList;
    }

    
    public List<ZT_NkHitKtyTy> OrderZT_NkHitKtyTyByPkDesc(List<ZT_NkHitKtyTy> pEntity) {
        List<SortCondition<ZT_NkHitKtyTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_NkHitKtyTy()).ztynksyousyono, SortOrder.DESC));
        List<ZT_NkHitKtyTy> copyList = new ArrayList<ZT_NkHitKtyTy>(pEntity);
        Collections.sort(copyList, new OrderZT_NkHitKtyTy(orders));
        return copyList;
    }
}
