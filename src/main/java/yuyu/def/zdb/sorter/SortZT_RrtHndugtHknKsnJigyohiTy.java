package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_RrtHndugtHknKsnJigyohiTy;
import yuyu.def.db.meta.QZT_RrtHndugtHknKsnJigyohiTy;
import yuyu.def.zdb.comparator.OrderZT_RrtHndugtHknKsnJigyohiTy;

public class SortZT_RrtHndugtHknKsnJigyohiTy {

    
    public List<ZT_RrtHndugtHknKsnJigyohiTy> OrderZT_RrtHndugtHknKsnJigyohiTyByPkAsc(List<ZT_RrtHndugtHknKsnJigyohiTy> pEntity) {
        List<SortCondition<ZT_RrtHndugtHknKsnJigyohiTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_RrtHndugtHknKsnJigyohiTy()).ztysequenceno, SortOrder.ASC));
        List<ZT_RrtHndugtHknKsnJigyohiTy> copyList = new ArrayList<ZT_RrtHndugtHknKsnJigyohiTy>(pEntity);
        Collections.sort(copyList, new OrderZT_RrtHndugtHknKsnJigyohiTy(orders));
        return copyList;
    }

    
    public List<ZT_RrtHndugtHknKsnJigyohiTy> OrderZT_RrtHndugtHknKsnJigyohiTyByPkDesc(List<ZT_RrtHndugtHknKsnJigyohiTy> pEntity) {
        List<SortCondition<ZT_RrtHndugtHknKsnJigyohiTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_RrtHndugtHknKsnJigyohiTy()).ztysequenceno, SortOrder.DESC));
        List<ZT_RrtHndugtHknKsnJigyohiTy> copyList = new ArrayList<ZT_RrtHndugtHknKsnJigyohiTy>(pEntity);
        Collections.sort(copyList, new OrderZT_RrtHndugtHknKsnJigyohiTy(orders));
        return copyList;
    }
}
