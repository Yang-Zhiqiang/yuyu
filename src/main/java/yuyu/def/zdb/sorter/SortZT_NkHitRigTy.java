package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_NkHitRigTy;
import yuyu.def.db.meta.QZT_NkHitRigTy;
import yuyu.def.zdb.comparator.OrderZT_NkHitRigTy;

public class SortZT_NkHitRigTy {

    
    public List<ZT_NkHitRigTy> OrderZT_NkHitRigTyByPkAsc(List<ZT_NkHitRigTy> pEntity) {
        List<SortCondition<ZT_NkHitRigTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_NkHitRigTy()).ztynksyousyono, SortOrder.ASC));
        List<ZT_NkHitRigTy> copyList = new ArrayList<ZT_NkHitRigTy>(pEntity);
        Collections.sort(copyList, new OrderZT_NkHitRigTy(orders));
        return copyList;
    }

    
    public List<ZT_NkHitRigTy> OrderZT_NkHitRigTyByPkDesc(List<ZT_NkHitRigTy> pEntity) {
        List<SortCondition<ZT_NkHitRigTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_NkHitRigTy()).ztynksyousyono, SortOrder.DESC));
        List<ZT_NkHitRigTy> copyList = new ArrayList<ZT_NkHitRigTy>(pEntity);
        Collections.sort(copyList, new OrderZT_NkHitRigTy(orders));
        return copyList;
    }
}
