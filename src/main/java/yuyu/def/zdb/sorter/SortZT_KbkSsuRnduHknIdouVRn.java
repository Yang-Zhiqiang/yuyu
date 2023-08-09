package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_KbkSsuRnduHknIdouVRn;
import yuyu.def.db.meta.QZT_KbkSsuRnduHknIdouVRn;
import yuyu.def.zdb.comparator.OrderZT_KbkSsuRnduHknIdouVRn;

public class SortZT_KbkSsuRnduHknIdouVRn {

    
    public List<ZT_KbkSsuRnduHknIdouVRn> OrderZT_KbkSsuRnduHknIdouVRnByPkAsc(List<ZT_KbkSsuRnduHknIdouVRn> pEntity) {
        List<SortCondition<ZT_KbkSsuRnduHknIdouVRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_KbkSsuRnduHknIdouVRn()).zrnsequenceno, SortOrder.ASC));
        List<ZT_KbkSsuRnduHknIdouVRn> copyList = new ArrayList<ZT_KbkSsuRnduHknIdouVRn>(pEntity);
        Collections.sort(copyList, new OrderZT_KbkSsuRnduHknIdouVRn(orders));
        return copyList;
    }

    
    public List<ZT_KbkSsuRnduHknIdouVRn> OrderZT_KbkSsuRnduHknIdouVRnByPkDesc(List<ZT_KbkSsuRnduHknIdouVRn> pEntity) {
        List<SortCondition<ZT_KbkSsuRnduHknIdouVRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_KbkSsuRnduHknIdouVRn()).zrnsequenceno, SortOrder.DESC));
        List<ZT_KbkSsuRnduHknIdouVRn> copyList = new ArrayList<ZT_KbkSsuRnduHknIdouVRn>(pEntity);
        Collections.sort(copyList, new OrderZT_KbkSsuRnduHknIdouVRn(orders));
        return copyList;
    }
}
