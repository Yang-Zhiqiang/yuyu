package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_RrtHndugtHknJigyohiTy;
import yuyu.def.db.meta.QZT_RrtHndugtHknJigyohiTy;
import yuyu.def.zdb.comparator.OrderZT_RrtHndugtHknJigyohiTy;

public class SortZT_RrtHndugtHknJigyohiTy {

    
    public List<ZT_RrtHndugtHknJigyohiTy> OrderZT_RrtHndugtHknJigyohiTyByPkAsc(List<ZT_RrtHndugtHknJigyohiTy> pEntity) {
        List<SortCondition<ZT_RrtHndugtHknJigyohiTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_RrtHndugtHknJigyohiTy()).ztysequenceno, SortOrder.ASC));
        List<ZT_RrtHndugtHknJigyohiTy> copyList = new ArrayList<ZT_RrtHndugtHknJigyohiTy>(pEntity);
        Collections.sort(copyList, new OrderZT_RrtHndugtHknJigyohiTy(orders));
        return copyList;
    }

    
    public List<ZT_RrtHndugtHknJigyohiTy> OrderZT_RrtHndugtHknJigyohiTyByPkDesc(List<ZT_RrtHndugtHknJigyohiTy> pEntity) {
        List<SortCondition<ZT_RrtHndugtHknJigyohiTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_RrtHndugtHknJigyohiTy()).ztysequenceno, SortOrder.DESC));
        List<ZT_RrtHndugtHknJigyohiTy> copyList = new ArrayList<ZT_RrtHndugtHknJigyohiTy>(pEntity);
        Collections.sort(copyList, new OrderZT_RrtHndugtHknJigyohiTy(orders));
        return copyList;
    }
}
