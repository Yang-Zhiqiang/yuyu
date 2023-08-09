package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_NkBikinTy;
import yuyu.def.db.meta.QZT_NkBikinTy;
import yuyu.def.zdb.comparator.OrderZT_NkBikinTy;

public class SortZT_NkBikinTy {

    
    public List<ZT_NkBikinTy> OrderZT_NkBikinTyByPkAsc(List<ZT_NkBikinTy> pEntity) {
        List<SortCondition<ZT_NkBikinTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_NkBikinTy()).ztynksyousyono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_NkBikinTy()).ztyshiharaihasseiymd, SortOrder.ASC));
        List<ZT_NkBikinTy> copyList = new ArrayList<ZT_NkBikinTy>(pEntity);
        Collections.sort(copyList, new OrderZT_NkBikinTy(orders));
        return copyList;
    }

    
    public List<ZT_NkBikinTy> OrderZT_NkBikinTyByPkDesc(List<ZT_NkBikinTy> pEntity) {
        List<SortCondition<ZT_NkBikinTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_NkBikinTy()).ztynksyousyono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_NkBikinTy()).ztyshiharaihasseiymd, SortOrder.DESC));
        List<ZT_NkBikinTy> copyList = new ArrayList<ZT_NkBikinTy>(pEntity);
        Collections.sort(copyList, new OrderZT_NkBikinTy(orders));
        return copyList;
    }
}
