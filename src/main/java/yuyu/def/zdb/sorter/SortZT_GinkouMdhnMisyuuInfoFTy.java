package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_GinkouMdhnMisyuuInfoFTy;
import yuyu.def.db.meta.QZT_GinkouMdhnMisyuuInfoFTy;
import yuyu.def.zdb.comparator.OrderZT_GinkouMdhnMisyuuInfoFTy;

public class SortZT_GinkouMdhnMisyuuInfoFTy {

    
    public List<ZT_GinkouMdhnMisyuuInfoFTy> OrderZT_GinkouMdhnMisyuuInfoFTyByPkAsc(List<ZT_GinkouMdhnMisyuuInfoFTy> pEntity) {
        List<SortCondition<ZT_GinkouMdhnMisyuuInfoFTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_GinkouMdhnMisyuuInfoFTy()).ztybsydrtencd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_GinkouMdhnMisyuuInfoFTy()).ztydatasakuseiymd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_GinkouMdhnMisyuuInfoFTy()).ztysyonosyuban, SortOrder.ASC));
        List<ZT_GinkouMdhnMisyuuInfoFTy> copyList = new ArrayList<ZT_GinkouMdhnMisyuuInfoFTy>(pEntity);
        Collections.sort(copyList, new OrderZT_GinkouMdhnMisyuuInfoFTy(orders));
        return copyList;
    }

    
    public List<ZT_GinkouMdhnMisyuuInfoFTy> OrderZT_GinkouMdhnMisyuuInfoFTyByPkDesc(List<ZT_GinkouMdhnMisyuuInfoFTy> pEntity) {
        List<SortCondition<ZT_GinkouMdhnMisyuuInfoFTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_GinkouMdhnMisyuuInfoFTy()).ztybsydrtencd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_GinkouMdhnMisyuuInfoFTy()).ztydatasakuseiymd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_GinkouMdhnMisyuuInfoFTy()).ztysyonosyuban, SortOrder.DESC));
        List<ZT_GinkouMdhnMisyuuInfoFTy> copyList = new ArrayList<ZT_GinkouMdhnMisyuuInfoFTy>(pEntity);
        Collections.sort(copyList, new OrderZT_GinkouMdhnMisyuuInfoFTy(orders));
        return copyList;
    }
}
