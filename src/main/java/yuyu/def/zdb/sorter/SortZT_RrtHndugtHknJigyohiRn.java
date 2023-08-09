package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_RrtHndugtHknJigyohiRn;
import yuyu.def.db.meta.QZT_RrtHndugtHknJigyohiRn;
import yuyu.def.zdb.comparator.OrderZT_RrtHndugtHknJigyohiRn;

public class SortZT_RrtHndugtHknJigyohiRn {

    
    public List<ZT_RrtHndugtHknJigyohiRn> OrderZT_RrtHndugtHknJigyohiRnByPkAsc(List<ZT_RrtHndugtHknJigyohiRn> pEntity) {
        List<SortCondition<ZT_RrtHndugtHknJigyohiRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_RrtHndugtHknJigyohiRn()).zrnsequenceno, SortOrder.ASC));
        List<ZT_RrtHndugtHknJigyohiRn> copyList = new ArrayList<ZT_RrtHndugtHknJigyohiRn>(pEntity);
        Collections.sort(copyList, new OrderZT_RrtHndugtHknJigyohiRn(orders));
        return copyList;
    }

    
    public List<ZT_RrtHndugtHknJigyohiRn> OrderZT_RrtHndugtHknJigyohiRnByPkDesc(List<ZT_RrtHndugtHknJigyohiRn> pEntity) {
        List<SortCondition<ZT_RrtHndugtHknJigyohiRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_RrtHndugtHknJigyohiRn()).zrnsequenceno, SortOrder.DESC));
        List<ZT_RrtHndugtHknJigyohiRn> copyList = new ArrayList<ZT_RrtHndugtHknJigyohiRn>(pEntity);
        Collections.sort(copyList, new OrderZT_RrtHndugtHknJigyohiRn(orders));
        return copyList;
    }
}
