package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_DrtenMinyuKykDtlSyokaiTy;
import yuyu.def.db.meta.QZT_DrtenMinyuKykDtlSyokaiTy;
import yuyu.def.zdb.comparator.OrderZT_DrtenMinyuKykDtlSyokaiTy;

public class SortZT_DrtenMinyuKykDtlSyokaiTy {

    
    public List<ZT_DrtenMinyuKykDtlSyokaiTy> OrderZT_DrtenMinyuKykDtlSyokaiTyByPkAsc(List<ZT_DrtenMinyuKykDtlSyokaiTy> pEntity) {
        List<SortCondition<ZT_DrtenMinyuKykDtlSyokaiTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_DrtenMinyuKykDtlSyokaiTy()).ztysakuseiym, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_DrtenMinyuKykDtlSyokaiTy()).ztybsydrtencd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_DrtenMinyuKykDtlSyokaiTy()).ztytntusycd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_DrtenMinyuKykDtlSyokaiTy()).ztysyono, SortOrder.ASC));
        List<ZT_DrtenMinyuKykDtlSyokaiTy> copyList = new ArrayList<ZT_DrtenMinyuKykDtlSyokaiTy>(pEntity);
        Collections.sort(copyList, new OrderZT_DrtenMinyuKykDtlSyokaiTy(orders));
        return copyList;
    }

    
    public List<ZT_DrtenMinyuKykDtlSyokaiTy> OrderZT_DrtenMinyuKykDtlSyokaiTyByPkDesc(List<ZT_DrtenMinyuKykDtlSyokaiTy> pEntity) {
        List<SortCondition<ZT_DrtenMinyuKykDtlSyokaiTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_DrtenMinyuKykDtlSyokaiTy()).ztysakuseiym, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_DrtenMinyuKykDtlSyokaiTy()).ztybsydrtencd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_DrtenMinyuKykDtlSyokaiTy()).ztytntusycd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_DrtenMinyuKykDtlSyokaiTy()).ztysyono, SortOrder.DESC));
        List<ZT_DrtenMinyuKykDtlSyokaiTy> copyList = new ArrayList<ZT_DrtenMinyuKykDtlSyokaiTy>(pEntity);
        Collections.sort(copyList, new OrderZT_DrtenMinyuKykDtlSyokaiTy(orders));
        return copyList;
    }
}
