package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_KbkSsuRnduHknJigyohiRn;
import yuyu.def.db.meta.QZT_KbkSsuRnduHknJigyohiRn;
import yuyu.def.zdb.comparator.OrderZT_KbkSsuRnduHknJigyohiRn;

public class SortZT_KbkSsuRnduHknJigyohiRn {

    
    public List<ZT_KbkSsuRnduHknJigyohiRn> OrderZT_KbkSsuRnduHknJigyohiRnByPkAsc(List<ZT_KbkSsuRnduHknJigyohiRn> pEntity) {
        List<SortCondition<ZT_KbkSsuRnduHknJigyohiRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_KbkSsuRnduHknJigyohiRn()).zrnsequenceno, SortOrder.ASC));
        List<ZT_KbkSsuRnduHknJigyohiRn> copyList = new ArrayList<ZT_KbkSsuRnduHknJigyohiRn>(pEntity);
        Collections.sort(copyList, new OrderZT_KbkSsuRnduHknJigyohiRn(orders));
        return copyList;
    }

    
    public List<ZT_KbkSsuRnduHknJigyohiRn> OrderZT_KbkSsuRnduHknJigyohiRnByPkDesc(List<ZT_KbkSsuRnduHknJigyohiRn> pEntity) {
        List<SortCondition<ZT_KbkSsuRnduHknJigyohiRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_KbkSsuRnduHknJigyohiRn()).zrnsequenceno, SortOrder.DESC));
        List<ZT_KbkSsuRnduHknJigyohiRn> copyList = new ArrayList<ZT_KbkSsuRnduHknJigyohiRn>(pEntity);
        Collections.sort(copyList, new OrderZT_KbkSsuRnduHknJigyohiRn(orders));
        return copyList;
    }
}
