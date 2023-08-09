package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_SyainMeiboTy;
import yuyu.def.db.meta.QZT_SyainMeiboTy;
import yuyu.def.zdb.comparator.OrderZT_SyainMeiboTy;

public class SortZT_SyainMeiboTy {

    
    public List<ZT_SyainMeiboTy> OrderZT_SyainMeiboTyByPkAsc(List<ZT_SyainMeiboTy> pEntity) {
        List<SortCondition<ZT_SyainMeiboTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_SyainMeiboTy()).ztysyono, SortOrder.ASC));
        List<ZT_SyainMeiboTy> copyList = new ArrayList<ZT_SyainMeiboTy>(pEntity);
        Collections.sort(copyList, new OrderZT_SyainMeiboTy(orders));
        return copyList;
    }

    
    public List<ZT_SyainMeiboTy> OrderZT_SyainMeiboTyByPkDesc(List<ZT_SyainMeiboTy> pEntity) {
        List<SortCondition<ZT_SyainMeiboTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_SyainMeiboTy()).ztysyono, SortOrder.DESC));
        List<ZT_SyainMeiboTy> copyList = new ArrayList<ZT_SyainMeiboTy>(pEntity);
        Collections.sort(copyList, new OrderZT_SyainMeiboTy(orders));
        return copyList;
    }
}
