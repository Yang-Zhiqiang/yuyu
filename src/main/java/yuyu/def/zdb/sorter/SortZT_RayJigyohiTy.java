package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_RayJigyohiTy;
import yuyu.def.db.meta.QZT_RayJigyohiTy;
import yuyu.def.zdb.comparator.OrderZT_RayJigyohiTy;

public class SortZT_RayJigyohiTy {

    
    public List<ZT_RayJigyohiTy> OrderZT_RayJigyohiTyByPkAsc(List<ZT_RayJigyohiTy> pEntity) {
        List<SortCondition<ZT_RayJigyohiTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_RayJigyohiTy()).ztysequenceno, SortOrder.ASC));
        List<ZT_RayJigyohiTy> copyList = new ArrayList<ZT_RayJigyohiTy>(pEntity);
        Collections.sort(copyList, new OrderZT_RayJigyohiTy(orders));
        return copyList;
    }

    
    public List<ZT_RayJigyohiTy> OrderZT_RayJigyohiTyByPkDesc(List<ZT_RayJigyohiTy> pEntity) {
        List<SortCondition<ZT_RayJigyohiTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_RayJigyohiTy()).ztysequenceno, SortOrder.DESC));
        List<ZT_RayJigyohiTy> copyList = new ArrayList<ZT_RayJigyohiTy>(pEntity);
        Collections.sort(copyList, new OrderZT_RayJigyohiTy(orders));
        return copyList;
    }
}
