package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_KsnKbkSsuRnduHknJigyohiRn;
import yuyu.def.db.meta.QZT_KsnKbkSsuRnduHknJigyohiRn;
import yuyu.def.zdb.comparator.OrderZT_KsnKbkSsuRnduHknJigyohiRn;

public class SortZT_KsnKbkSsuRnduHknJigyohiRn {

    
    public List<ZT_KsnKbkSsuRnduHknJigyohiRn> OrderZT_KsnKbkSsuRnduHknJigyohiRnByPkAsc(List<ZT_KsnKbkSsuRnduHknJigyohiRn> pEntity) {
        List<SortCondition<ZT_KsnKbkSsuRnduHknJigyohiRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_KsnKbkSsuRnduHknJigyohiRn()).zrnsequenceno, SortOrder.ASC));
        List<ZT_KsnKbkSsuRnduHknJigyohiRn> copyList = new ArrayList<ZT_KsnKbkSsuRnduHknJigyohiRn>(pEntity);
        Collections.sort(copyList, new OrderZT_KsnKbkSsuRnduHknJigyohiRn(orders));
        return copyList;
    }

    
    public List<ZT_KsnKbkSsuRnduHknJigyohiRn> OrderZT_KsnKbkSsuRnduHknJigyohiRnByPkDesc(List<ZT_KsnKbkSsuRnduHknJigyohiRn> pEntity) {
        List<SortCondition<ZT_KsnKbkSsuRnduHknJigyohiRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_KsnKbkSsuRnduHknJigyohiRn()).zrnsequenceno, SortOrder.DESC));
        List<ZT_KsnKbkSsuRnduHknJigyohiRn> copyList = new ArrayList<ZT_KsnKbkSsuRnduHknJigyohiRn>(pEntity);
        Collections.sort(copyList, new OrderZT_KsnKbkSsuRnduHknJigyohiRn(orders));
        return copyList;
    }
}
