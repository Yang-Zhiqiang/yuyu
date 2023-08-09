package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_RayKimatuVTy;
import yuyu.def.db.meta.QZT_RayKimatuVTy;
import yuyu.def.zdb.comparator.OrderZT_RayKimatuVTy;

public class SortZT_RayKimatuVTy {

    
    public List<ZT_RayKimatuVTy> OrderZT_RayKimatuVTyByPkAsc(List<ZT_RayKimatuVTy> pEntity) {
        List<SortCondition<ZT_RayKimatuVTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_RayKimatuVTy()).ztysequenceno, SortOrder.ASC));
        List<ZT_RayKimatuVTy> copyList = new ArrayList<ZT_RayKimatuVTy>(pEntity);
        Collections.sort(copyList, new OrderZT_RayKimatuVTy(orders));
        return copyList;
    }

    
    public List<ZT_RayKimatuVTy> OrderZT_RayKimatuVTyByPkDesc(List<ZT_RayKimatuVTy> pEntity) {
        List<SortCondition<ZT_RayKimatuVTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_RayKimatuVTy()).ztysequenceno, SortOrder.DESC));
        List<ZT_RayKimatuVTy> copyList = new ArrayList<ZT_RayKimatuVTy>(pEntity);
        Collections.sort(copyList, new OrderZT_RayKimatuVTy(orders));
        return copyList;
    }
}
