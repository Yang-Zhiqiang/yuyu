package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_BosyuuDrtenHoyuuKykTy;
import yuyu.def.db.meta.QZT_BosyuuDrtenHoyuuKykTy;
import yuyu.def.zdb.comparator.OrderZT_BosyuuDrtenHoyuuKykTy;

public class SortZT_BosyuuDrtenHoyuuKykTy {

    
    public List<ZT_BosyuuDrtenHoyuuKykTy> OrderZT_BosyuuDrtenHoyuuKykTyByPkAsc(List<ZT_BosyuuDrtenHoyuuKykTy> pEntity) {
        List<SortCondition<ZT_BosyuuDrtenHoyuuKykTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_BosyuuDrtenHoyuuKykTy()).ztysyonosyuban, SortOrder.ASC));
        List<ZT_BosyuuDrtenHoyuuKykTy> copyList = new ArrayList<ZT_BosyuuDrtenHoyuuKykTy>(pEntity);
        Collections.sort(copyList, new OrderZT_BosyuuDrtenHoyuuKykTy(orders));
        return copyList;
    }

    
    public List<ZT_BosyuuDrtenHoyuuKykTy> OrderZT_BosyuuDrtenHoyuuKykTyByPkDesc(List<ZT_BosyuuDrtenHoyuuKykTy> pEntity) {
        List<SortCondition<ZT_BosyuuDrtenHoyuuKykTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_BosyuuDrtenHoyuuKykTy()).ztysyonosyuban, SortOrder.DESC));
        List<ZT_BosyuuDrtenHoyuuKykTy> copyList = new ArrayList<ZT_BosyuuDrtenHoyuuKykTy>(pEntity);
        Collections.sort(copyList, new OrderZT_BosyuuDrtenHoyuuKykTy(orders));
        return copyList;
    }
}
