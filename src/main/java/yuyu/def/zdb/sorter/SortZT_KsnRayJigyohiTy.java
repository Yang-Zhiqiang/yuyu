package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_KsnRayJigyohiTy;
import yuyu.def.db.meta.QZT_KsnRayJigyohiTy;
import yuyu.def.zdb.comparator.OrderZT_KsnRayJigyohiTy;

public class SortZT_KsnRayJigyohiTy {

    
    public List<ZT_KsnRayJigyohiTy> OrderZT_KsnRayJigyohiTyByPkAsc(List<ZT_KsnRayJigyohiTy> pEntity) {
        List<SortCondition<ZT_KsnRayJigyohiTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_KsnRayJigyohiTy()).ztysequenceno, SortOrder.ASC));
        List<ZT_KsnRayJigyohiTy> copyList = new ArrayList<ZT_KsnRayJigyohiTy>(pEntity);
        Collections.sort(copyList, new OrderZT_KsnRayJigyohiTy(orders));
        return copyList;
    }

    
    public List<ZT_KsnRayJigyohiTy> OrderZT_KsnRayJigyohiTyByPkDesc(List<ZT_KsnRayJigyohiTy> pEntity) {
        List<SortCondition<ZT_KsnRayJigyohiTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_KsnRayJigyohiTy()).ztysequenceno, SortOrder.DESC));
        List<ZT_KsnRayJigyohiTy> copyList = new ArrayList<ZT_KsnRayJigyohiTy>(pEntity);
        Collections.sort(copyList, new OrderZT_KsnRayJigyohiTy(orders));
        return copyList;
    }
}
