package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_DrtenSkKykDtlSyokaiTy;
import yuyu.def.db.meta.QZT_DrtenSkKykDtlSyokaiTy;
import yuyu.def.zdb.comparator.OrderZT_DrtenSkKykDtlSyokaiTy;

public class SortZT_DrtenSkKykDtlSyokaiTy {

    
    public List<ZT_DrtenSkKykDtlSyokaiTy> OrderZT_DrtenSkKykDtlSyokaiTyByPkAsc(List<ZT_DrtenSkKykDtlSyokaiTy> pEntity) {
        List<SortCondition<ZT_DrtenSkKykDtlSyokaiTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_DrtenSkKykDtlSyokaiTy()).ztysakuseiym, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_DrtenSkKykDtlSyokaiTy()).ztybsydrtencd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_DrtenSkKykDtlSyokaiTy()).ztytntusycd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_DrtenSkKykDtlSyokaiTy()).ztysyono, SortOrder.ASC));
        List<ZT_DrtenSkKykDtlSyokaiTy> copyList = new ArrayList<ZT_DrtenSkKykDtlSyokaiTy>(pEntity);
        Collections.sort(copyList, new OrderZT_DrtenSkKykDtlSyokaiTy(orders));
        return copyList;
    }

    
    public List<ZT_DrtenSkKykDtlSyokaiTy> OrderZT_DrtenSkKykDtlSyokaiTyByPkDesc(List<ZT_DrtenSkKykDtlSyokaiTy> pEntity) {
        List<SortCondition<ZT_DrtenSkKykDtlSyokaiTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_DrtenSkKykDtlSyokaiTy()).ztysakuseiym, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_DrtenSkKykDtlSyokaiTy()).ztybsydrtencd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_DrtenSkKykDtlSyokaiTy()).ztytntusycd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_DrtenSkKykDtlSyokaiTy()).ztysyono, SortOrder.DESC));
        List<ZT_DrtenSkKykDtlSyokaiTy> copyList = new ArrayList<ZT_DrtenSkKykDtlSyokaiTy>(pEntity);
        Collections.sort(copyList, new OrderZT_DrtenSkKykDtlSyokaiTy(orders));
        return copyList;
    }
}
