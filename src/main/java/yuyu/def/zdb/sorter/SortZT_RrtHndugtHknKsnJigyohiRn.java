package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_RrtHndugtHknKsnJigyohiRn;
import yuyu.def.db.meta.QZT_RrtHndugtHknKsnJigyohiRn;
import yuyu.def.zdb.comparator.OrderZT_RrtHndugtHknKsnJigyohiRn;

public class SortZT_RrtHndugtHknKsnJigyohiRn {

    
    public List<ZT_RrtHndugtHknKsnJigyohiRn> OrderZT_RrtHndugtHknKsnJigyohiRnByPkAsc(List<ZT_RrtHndugtHknKsnJigyohiRn> pEntity) {
        List<SortCondition<ZT_RrtHndugtHknKsnJigyohiRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_RrtHndugtHknKsnJigyohiRn()).zrnsequenceno, SortOrder.ASC));
        List<ZT_RrtHndugtHknKsnJigyohiRn> copyList = new ArrayList<ZT_RrtHndugtHknKsnJigyohiRn>(pEntity);
        Collections.sort(copyList, new OrderZT_RrtHndugtHknKsnJigyohiRn(orders));
        return copyList;
    }

    
    public List<ZT_RrtHndugtHknKsnJigyohiRn> OrderZT_RrtHndugtHknKsnJigyohiRnByPkDesc(List<ZT_RrtHndugtHknKsnJigyohiRn> pEntity) {
        List<SortCondition<ZT_RrtHndugtHknKsnJigyohiRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_RrtHndugtHknKsnJigyohiRn()).zrnsequenceno, SortOrder.DESC));
        List<ZT_RrtHndugtHknKsnJigyohiRn> copyList = new ArrayList<ZT_RrtHndugtHknKsnJigyohiRn>(pEntity);
        Collections.sort(copyList, new OrderZT_RrtHndugtHknKsnJigyohiRn(orders));
        return copyList;
    }
}
