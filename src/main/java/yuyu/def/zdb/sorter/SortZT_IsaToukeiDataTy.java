package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_IsaToukeiDataTy;
import yuyu.def.db.meta.QZT_IsaToukeiDataTy;
import yuyu.def.zdb.comparator.OrderZT_IsaToukeiDataTy;

public class SortZT_IsaToukeiDataTy {

    
    public List<ZT_IsaToukeiDataTy> OrderZT_IsaToukeiDataTyByPkAsc(List<ZT_IsaToukeiDataTy> pEntity) {
        List<SortCondition<ZT_IsaToukeiDataTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_IsaToukeiDataTy()).ztymosno, SortOrder.ASC));
        List<ZT_IsaToukeiDataTy> copyList = new ArrayList<ZT_IsaToukeiDataTy>(pEntity);
        Collections.sort(copyList, new OrderZT_IsaToukeiDataTy(orders));
        return copyList;
    }

    
    public List<ZT_IsaToukeiDataTy> OrderZT_IsaToukeiDataTyByPkDesc(List<ZT_IsaToukeiDataTy> pEntity) {
        List<SortCondition<ZT_IsaToukeiDataTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_IsaToukeiDataTy()).ztymosno, SortOrder.DESC));
        List<ZT_IsaToukeiDataTy> copyList = new ArrayList<ZT_IsaToukeiDataTy>(pEntity);
        Collections.sort(copyList, new OrderZT_IsaToukeiDataTy(orders));
        return copyList;
    }
}
