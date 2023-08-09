package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_DairitenGtmtZndkTy;
import yuyu.def.db.meta.QZT_DairitenGtmtZndkTy;
import yuyu.def.zdb.comparator.OrderZT_DairitenGtmtZndkTy;

public class SortZT_DairitenGtmtZndkTy {

    
    public List<ZT_DairitenGtmtZndkTy> OrderZT_DairitenGtmtZndkTyByPkAsc(List<ZT_DairitenGtmtZndkTy> pEntity) {
        List<SortCondition<ZT_DairitenGtmtZndkTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_DairitenGtmtZndkTy()).ztydatakijyunymd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_DairitenGtmtZndkTy()).ztysyono, SortOrder.ASC));
        List<ZT_DairitenGtmtZndkTy> copyList = new ArrayList<ZT_DairitenGtmtZndkTy>(pEntity);
        Collections.sort(copyList, new OrderZT_DairitenGtmtZndkTy(orders));
        return copyList;
    }

    
    public List<ZT_DairitenGtmtZndkTy> OrderZT_DairitenGtmtZndkTyByPkDesc(List<ZT_DairitenGtmtZndkTy> pEntity) {
        List<SortCondition<ZT_DairitenGtmtZndkTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_DairitenGtmtZndkTy()).ztydatakijyunymd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_DairitenGtmtZndkTy()).ztysyono, SortOrder.DESC));
        List<ZT_DairitenGtmtZndkTy> copyList = new ArrayList<ZT_DairitenGtmtZndkTy>(pEntity);
        Collections.sort(copyList, new OrderZT_DairitenGtmtZndkTy(orders));
        return copyList;
    }
}