package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_SinBosyuuDrtenHoyuuKykTy;
import yuyu.def.db.meta.QZT_SinBosyuuDrtenHoyuuKykTy;
import yuyu.def.zdb.comparator.OrderZT_SinBosyuuDrtenHoyuuKykTy;

public class SortZT_SinBosyuuDrtenHoyuuKykTy {

    
    public List<ZT_SinBosyuuDrtenHoyuuKykTy> OrderZT_SinBosyuuDrtenHoyuuKykTyByPkAsc(List<ZT_SinBosyuuDrtenHoyuuKykTy> pEntity) {
        List<SortCondition<ZT_SinBosyuuDrtenHoyuuKykTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_SinBosyuuDrtenHoyuuKykTy()).ztysyono, SortOrder.ASC));
        List<ZT_SinBosyuuDrtenHoyuuKykTy> copyList = new ArrayList<ZT_SinBosyuuDrtenHoyuuKykTy>(pEntity);
        Collections.sort(copyList, new OrderZT_SinBosyuuDrtenHoyuuKykTy(orders));
        return copyList;
    }

    
    public List<ZT_SinBosyuuDrtenHoyuuKykTy> OrderZT_SinBosyuuDrtenHoyuuKykTyByPkDesc(List<ZT_SinBosyuuDrtenHoyuuKykTy> pEntity) {
        List<SortCondition<ZT_SinBosyuuDrtenHoyuuKykTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_SinBosyuuDrtenHoyuuKykTy()).ztysyono, SortOrder.DESC));
        List<ZT_SinBosyuuDrtenHoyuuKykTy> copyList = new ArrayList<ZT_SinBosyuuDrtenHoyuuKykTy>(pEntity);
        Collections.sort(copyList, new OrderZT_SinBosyuuDrtenHoyuuKykTy(orders));
        return copyList;
    }
}