package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_HnsyScrMeigiTy;
import yuyu.def.db.meta.QZT_HnsyScrMeigiTy;
import yuyu.def.zdb.comparator.OrderZT_HnsyScrMeigiTy;

public class SortZT_HnsyScrMeigiTy {

    
    public List<ZT_HnsyScrMeigiTy> OrderZT_HnsyScrMeigiTyByPkAsc(List<ZT_HnsyScrMeigiTy> pEntity) {
        List<SortCondition<ZT_HnsyScrMeigiTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_HnsyScrMeigiTy()).ztytaisyounmkn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_HnsyScrMeigiTy()).ztytaisyounmkj, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_HnsyScrMeigiTy()).ztytaisyouseiymd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_HnsyScrMeigiTy()).ztynayosetaisyousegkbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_HnsyScrMeigiTy()).ztysyono, SortOrder.ASC));
        List<ZT_HnsyScrMeigiTy> copyList = new ArrayList<ZT_HnsyScrMeigiTy>(pEntity);
        Collections.sort(copyList, new OrderZT_HnsyScrMeigiTy(orders));
        return copyList;
    }

    
    public List<ZT_HnsyScrMeigiTy> OrderZT_HnsyScrMeigiTyByPkDesc(List<ZT_HnsyScrMeigiTy> pEntity) {
        List<SortCondition<ZT_HnsyScrMeigiTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_HnsyScrMeigiTy()).ztytaisyounmkn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_HnsyScrMeigiTy()).ztytaisyounmkj, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_HnsyScrMeigiTy()).ztytaisyouseiymd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_HnsyScrMeigiTy()).ztynayosetaisyousegkbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_HnsyScrMeigiTy()).ztysyono, SortOrder.DESC));
        List<ZT_HnsyScrMeigiTy> copyList = new ArrayList<ZT_HnsyScrMeigiTy>(pEntity);
        Collections.sort(copyList, new OrderZT_HnsyScrMeigiTy(orders));
        return copyList;
    }
}
