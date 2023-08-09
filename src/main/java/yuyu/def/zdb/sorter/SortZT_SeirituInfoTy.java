package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_SeirituInfoTy;
import yuyu.def.db.meta.QZT_SeirituInfoTy;
import yuyu.def.zdb.comparator.OrderZT_SeirituInfoTy;

public class SortZT_SeirituInfoTy {

    
    public List<ZT_SeirituInfoTy> OrderZT_SeirituInfoTyByPkAsc(List<ZT_SeirituInfoTy> pEntity) {
        List<SortCondition<ZT_SeirituInfoTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_SeirituInfoTy()).ztykijyunym, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_SeirituInfoTy()).ztysyono, SortOrder.ASC));
        List<ZT_SeirituInfoTy> copyList = new ArrayList<ZT_SeirituInfoTy>(pEntity);
        Collections.sort(copyList, new OrderZT_SeirituInfoTy(orders));
        return copyList;
    }

    
    public List<ZT_SeirituInfoTy> OrderZT_SeirituInfoTyByPkDesc(List<ZT_SeirituInfoTy> pEntity) {
        List<SortCondition<ZT_SeirituInfoTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_SeirituInfoTy()).ztykijyunym, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_SeirituInfoTy()).ztysyono, SortOrder.DESC));
        List<ZT_SeirituInfoTy> copyList = new ArrayList<ZT_SeirituInfoTy>(pEntity);
        Collections.sort(copyList, new OrderZT_SeirituInfoTy(orders));
        return copyList;
    }
}
