package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_NkHitKsnTy;
import yuyu.def.db.meta.QZT_NkHitKsnTy;
import yuyu.def.zdb.comparator.OrderZT_NkHitKsnTy;

public class SortZT_NkHitKsnTy {

    
    public List<ZT_NkHitKsnTy> OrderZT_NkHitKsnTyByPkAsc(List<ZT_NkHitKsnTy> pEntity) {
        List<SortCondition<ZT_NkHitKsnTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_NkHitKsnTy()).ztynksyousyono, SortOrder.ASC));
        List<ZT_NkHitKsnTy> copyList = new ArrayList<ZT_NkHitKsnTy>(pEntity);
        Collections.sort(copyList, new OrderZT_NkHitKsnTy(orders));
        return copyList;
    }

    
    public List<ZT_NkHitKsnTy> OrderZT_NkHitKsnTyByPkDesc(List<ZT_NkHitKsnTy> pEntity) {
        List<SortCondition<ZT_NkHitKsnTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_NkHitKsnTy()).ztynksyousyono, SortOrder.DESC));
        List<ZT_NkHitKsnTy> copyList = new ArrayList<ZT_NkHitKsnTy>(pEntity);
        Collections.sort(copyList, new OrderZT_NkHitKsnTy(orders));
        return copyList;
    }
}
