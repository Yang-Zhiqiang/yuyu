package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_DrtenMisyuSkInfoDataTy;
import yuyu.def.db.meta.QZT_DrtenMisyuSkInfoDataTy;
import yuyu.def.zdb.comparator.OrderZT_DrtenMisyuSkInfoDataTy;

public class SortZT_DrtenMisyuSkInfoDataTy {

    
    public List<ZT_DrtenMisyuSkInfoDataTy> OrderZT_DrtenMisyuSkInfoDataTyByPkAsc(List<ZT_DrtenMisyuSkInfoDataTy> pEntity) {
        List<SortCondition<ZT_DrtenMisyuSkInfoDataTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_DrtenMisyuSkInfoDataTy()).ztysyono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_DrtenMisyuSkInfoDataTy()).ztybsydrtencd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_DrtenMisyuSkInfoDataTy()).ztyhanteiymd, SortOrder.ASC));
        List<ZT_DrtenMisyuSkInfoDataTy> copyList = new ArrayList<ZT_DrtenMisyuSkInfoDataTy>(pEntity);
        Collections.sort(copyList, new OrderZT_DrtenMisyuSkInfoDataTy(orders));
        return copyList;
    }

    
    public List<ZT_DrtenMisyuSkInfoDataTy> OrderZT_DrtenMisyuSkInfoDataTyByPkDesc(List<ZT_DrtenMisyuSkInfoDataTy> pEntity) {
        List<SortCondition<ZT_DrtenMisyuSkInfoDataTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_DrtenMisyuSkInfoDataTy()).ztysyono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_DrtenMisyuSkInfoDataTy()).ztybsydrtencd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_DrtenMisyuSkInfoDataTy()).ztyhanteiymd, SortOrder.DESC));
        List<ZT_DrtenMisyuSkInfoDataTy> copyList = new ArrayList<ZT_DrtenMisyuSkInfoDataTy>(pEntity);
        Collections.sort(copyList, new OrderZT_DrtenMisyuSkInfoDataTy(orders));
        return copyList;
    }
}
