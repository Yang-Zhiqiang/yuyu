package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_YuseiMinyuKykDtlSyokaiTy;
import yuyu.def.db.meta.QZT_YuseiMinyuKykDtlSyokaiTy;
import yuyu.def.zdb.comparator.OrderZT_YuseiMinyuKykDtlSyokaiTy;

public class SortZT_YuseiMinyuKykDtlSyokaiTy {

    
    public List<ZT_YuseiMinyuKykDtlSyokaiTy> OrderZT_YuseiMinyuKykDtlSyokaiTyByPkAsc(List<ZT_YuseiMinyuKykDtlSyokaiTy> pEntity) {
        List<SortCondition<ZT_YuseiMinyuKykDtlSyokaiTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_YuseiMinyuKykDtlSyokaiTy()).ztysakuseiym, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_YuseiMinyuKykDtlSyokaiTy()).ztybsydrtencd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_YuseiMinyuKykDtlSyokaiTy()).ztytntusycd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_YuseiMinyuKykDtlSyokaiTy()).ztysyono, SortOrder.ASC));
        List<ZT_YuseiMinyuKykDtlSyokaiTy> copyList = new ArrayList<ZT_YuseiMinyuKykDtlSyokaiTy>(pEntity);
        Collections.sort(copyList, new OrderZT_YuseiMinyuKykDtlSyokaiTy(orders));
        return copyList;
    }

    
    public List<ZT_YuseiMinyuKykDtlSyokaiTy> OrderZT_YuseiMinyuKykDtlSyokaiTyByPkDesc(List<ZT_YuseiMinyuKykDtlSyokaiTy> pEntity) {
        List<SortCondition<ZT_YuseiMinyuKykDtlSyokaiTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_YuseiMinyuKykDtlSyokaiTy()).ztysakuseiym, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_YuseiMinyuKykDtlSyokaiTy()).ztybsydrtencd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_YuseiMinyuKykDtlSyokaiTy()).ztytntusycd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_YuseiMinyuKykDtlSyokaiTy()).ztysyono, SortOrder.DESC));
        List<ZT_YuseiMinyuKykDtlSyokaiTy> copyList = new ArrayList<ZT_YuseiMinyuKykDtlSyokaiTy>(pEntity);
        Collections.sort(copyList, new OrderZT_YuseiMinyuKykDtlSyokaiTy(orders));
        return copyList;
    }
}
