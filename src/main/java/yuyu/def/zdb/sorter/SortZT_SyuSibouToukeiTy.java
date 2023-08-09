package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_SyuSibouToukeiTy;
import yuyu.def.db.meta.QZT_SyuSibouToukeiTy;
import yuyu.def.zdb.comparator.OrderZT_SyuSibouToukeiTy;

public class SortZT_SyuSibouToukeiTy {

    
    public List<ZT_SyuSibouToukeiTy> OrderZT_SyuSibouToukeiTyByPkAsc(List<ZT_SyuSibouToukeiTy> pEntity) {
        List<SortCondition<ZT_SyuSibouToukeiTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_SyuSibouToukeiTy()).ztysyono, SortOrder.ASC));
        List<ZT_SyuSibouToukeiTy> copyList = new ArrayList<ZT_SyuSibouToukeiTy>(pEntity);
        Collections.sort(copyList, new OrderZT_SyuSibouToukeiTy(orders));
        return copyList;
    }

    
    public List<ZT_SyuSibouToukeiTy> OrderZT_SyuSibouToukeiTyByPkDesc(List<ZT_SyuSibouToukeiTy> pEntity) {
        List<SortCondition<ZT_SyuSibouToukeiTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_SyuSibouToukeiTy()).ztysyono, SortOrder.DESC));
        List<ZT_SyuSibouToukeiTy> copyList = new ArrayList<ZT_SyuSibouToukeiTy>(pEntity);
        Collections.sort(copyList, new OrderZT_SyuSibouToukeiTy(orders));
        return copyList;
    }
}
