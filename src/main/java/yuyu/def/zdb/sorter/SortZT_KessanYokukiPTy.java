package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_KessanYokukiPTy;
import yuyu.def.db.meta.QZT_KessanYokukiPTy;
import yuyu.def.zdb.comparator.OrderZT_KessanYokukiPTy;

public class SortZT_KessanYokukiPTy {

    
    public List<ZT_KessanYokukiPTy> OrderZT_KessanYokukiPTyByPkAsc(List<ZT_KessanYokukiPTy> pEntity) {
        List<SortCondition<ZT_KessanYokukiPTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_KessanYokukiPTy()).ztykeijyouym, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_KessanYokukiPTy()).ztysyono, SortOrder.ASC));
        List<ZT_KessanYokukiPTy> copyList = new ArrayList<ZT_KessanYokukiPTy>(pEntity);
        Collections.sort(copyList, new OrderZT_KessanYokukiPTy(orders));
        return copyList;
    }

    
    public List<ZT_KessanYokukiPTy> OrderZT_KessanYokukiPTyByPkDesc(List<ZT_KessanYokukiPTy> pEntity) {
        List<SortCondition<ZT_KessanYokukiPTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_KessanYokukiPTy()).ztykeijyouym, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_KessanYokukiPTy()).ztysyono, SortOrder.DESC));
        List<ZT_KessanYokukiPTy> copyList = new ArrayList<ZT_KessanYokukiPTy>(pEntity);
        Collections.sort(copyList, new OrderZT_KessanYokukiPTy(orders));
        return copyList;
    }
}
