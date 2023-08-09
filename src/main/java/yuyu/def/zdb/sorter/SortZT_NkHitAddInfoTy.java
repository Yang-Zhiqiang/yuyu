package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_NkHitAddInfoTy;
import yuyu.def.db.meta.QZT_NkHitAddInfoTy;
import yuyu.def.zdb.comparator.OrderZT_NkHitAddInfoTy;

public class SortZT_NkHitAddInfoTy {

    
    public List<ZT_NkHitAddInfoTy> OrderZT_NkHitAddInfoTyByPkAsc(List<ZT_NkHitAddInfoTy> pEntity) {
        List<SortCondition<ZT_NkHitAddInfoTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_NkHitAddInfoTy()).ztynksyousyono, SortOrder.ASC));
        List<ZT_NkHitAddInfoTy> copyList = new ArrayList<ZT_NkHitAddInfoTy>(pEntity);
        Collections.sort(copyList, new OrderZT_NkHitAddInfoTy(orders));
        return copyList;
    }

    
    public List<ZT_NkHitAddInfoTy> OrderZT_NkHitAddInfoTyByPkDesc(List<ZT_NkHitAddInfoTy> pEntity) {
        List<SortCondition<ZT_NkHitAddInfoTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_NkHitAddInfoTy()).ztynksyousyono, SortOrder.DESC));
        List<ZT_NkHitAddInfoTy> copyList = new ArrayList<ZT_NkHitAddInfoTy>(pEntity);
        Collections.sort(copyList, new OrderZT_NkHitAddInfoTy(orders));
        return copyList;
    }
}
