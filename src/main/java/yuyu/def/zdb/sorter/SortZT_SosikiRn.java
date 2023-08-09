package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_SosikiRn;
import yuyu.def.db.meta.QZT_SosikiRn;
import yuyu.def.zdb.comparator.OrderZT_SosikiRn;

public class SortZT_SosikiRn {

    
    public List<ZT_SosikiRn> OrderZT_SosikiRnByPkAsc(List<ZT_SosikiRn> pEntity) {
        List<SortCondition<ZT_SosikiRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_SosikiRn()).zrnsosikicd, SortOrder.ASC));
        List<ZT_SosikiRn> copyList = new ArrayList<ZT_SosikiRn>(pEntity);
        Collections.sort(copyList, new OrderZT_SosikiRn(orders));
        return copyList;
    }

    
    public List<ZT_SosikiRn> OrderZT_SosikiRnByPkDesc(List<ZT_SosikiRn> pEntity) {
        List<SortCondition<ZT_SosikiRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_SosikiRn()).zrnsosikicd, SortOrder.DESC));
        List<ZT_SosikiRn> copyList = new ArrayList<ZT_SosikiRn>(pEntity);
        Collections.sort(copyList, new OrderZT_SosikiRn(orders));
        return copyList;
    }
}
