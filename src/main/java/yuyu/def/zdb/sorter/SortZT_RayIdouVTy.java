package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_RayIdouVTy;
import yuyu.def.db.meta.QZT_RayIdouVTy;
import yuyu.def.zdb.comparator.OrderZT_RayIdouVTy;

public class SortZT_RayIdouVTy {

    
    public List<ZT_RayIdouVTy> OrderZT_RayIdouVTyByPkAsc(List<ZT_RayIdouVTy> pEntity) {
        List<SortCondition<ZT_RayIdouVTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_RayIdouVTy()).ztysequenceno, SortOrder.ASC));
        List<ZT_RayIdouVTy> copyList = new ArrayList<ZT_RayIdouVTy>(pEntity);
        Collections.sort(copyList, new OrderZT_RayIdouVTy(orders));
        return copyList;
    }

    
    public List<ZT_RayIdouVTy> OrderZT_RayIdouVTyByPkDesc(List<ZT_RayIdouVTy> pEntity) {
        List<SortCondition<ZT_RayIdouVTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_RayIdouVTy()).ztysequenceno, SortOrder.DESC));
        List<ZT_RayIdouVTy> copyList = new ArrayList<ZT_RayIdouVTy>(pEntity);
        Collections.sort(copyList, new OrderZT_RayIdouVTy(orders));
        return copyList;
    }
}
