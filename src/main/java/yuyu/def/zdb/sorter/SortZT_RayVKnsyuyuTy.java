package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_RayVKnsyuyuTy;
import yuyu.def.db.meta.QZT_RayVKnsyuyuTy;
import yuyu.def.zdb.comparator.OrderZT_RayVKnsyuyuTy;

public class SortZT_RayVKnsyuyuTy {

    
    public List<ZT_RayVKnsyuyuTy> OrderZT_RayVKnsyuyuTyByPkAsc(List<ZT_RayVKnsyuyuTy> pEntity) {
        List<SortCondition<ZT_RayVKnsyuyuTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_RayVKnsyuyuTy()).ztysequenceno, SortOrder.ASC));
        List<ZT_RayVKnsyuyuTy> copyList = new ArrayList<ZT_RayVKnsyuyuTy>(pEntity);
        Collections.sort(copyList, new OrderZT_RayVKnsyuyuTy(orders));
        return copyList;
    }

    
    public List<ZT_RayVKnsyuyuTy> OrderZT_RayVKnsyuyuTyByPkDesc(List<ZT_RayVKnsyuyuTy> pEntity) {
        List<SortCondition<ZT_RayVKnsyuyuTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_RayVKnsyuyuTy()).ztysequenceno, SortOrder.DESC));
        List<ZT_RayVKnsyuyuTy> copyList = new ArrayList<ZT_RayVKnsyuyuTy>(pEntity);
        Collections.sort(copyList, new OrderZT_RayVKnsyuyuTy(orders));
        return copyList;
    }
}
