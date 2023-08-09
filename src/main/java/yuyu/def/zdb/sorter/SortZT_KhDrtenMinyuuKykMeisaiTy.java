package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_KhDrtenMinyuuKykMeisaiTy;
import yuyu.def.db.meta.QZT_KhDrtenMinyuuKykMeisaiTy;
import yuyu.def.zdb.comparator.OrderZT_KhDrtenMinyuuKykMeisaiTy;

public class SortZT_KhDrtenMinyuuKykMeisaiTy {

    
    public List<ZT_KhDrtenMinyuuKykMeisaiTy> OrderZT_KhDrtenMinyuuKykMeisaiTyByPkAsc(List<ZT_KhDrtenMinyuuKykMeisaiTy> pEntity) {
        List<SortCondition<ZT_KhDrtenMinyuuKykMeisaiTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_KhDrtenMinyuuKykMeisaiTy()).ztysyoriymd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_KhDrtenMinyuuKykMeisaiTy()).ztybsydrtencd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_KhDrtenMinyuuKykMeisaiTy()).ztysyono, SortOrder.ASC));
        List<ZT_KhDrtenMinyuuKykMeisaiTy> copyList = new ArrayList<ZT_KhDrtenMinyuuKykMeisaiTy>(pEntity);
        Collections.sort(copyList, new OrderZT_KhDrtenMinyuuKykMeisaiTy(orders));
        return copyList;
    }

    
    public List<ZT_KhDrtenMinyuuKykMeisaiTy> OrderZT_KhDrtenMinyuuKykMeisaiTyByPkDesc(List<ZT_KhDrtenMinyuuKykMeisaiTy> pEntity) {
        List<SortCondition<ZT_KhDrtenMinyuuKykMeisaiTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_KhDrtenMinyuuKykMeisaiTy()).ztysyoriymd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_KhDrtenMinyuuKykMeisaiTy()).ztybsydrtencd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_KhDrtenMinyuuKykMeisaiTy()).ztysyono, SortOrder.DESC));
        List<ZT_KhDrtenMinyuuKykMeisaiTy> copyList = new ArrayList<ZT_KhDrtenMinyuuKykMeisaiTy>(pEntity);
        Collections.sort(copyList, new OrderZT_KhDrtenMinyuuKykMeisaiTy(orders));
        return copyList;
    }
}
