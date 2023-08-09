package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_SbRituRendouRn;
import yuyu.def.db.meta.QZT_SbRituRendouRn;
import yuyu.def.zdb.comparator.OrderZT_SbRituRendouRn;

public class SortZT_SbRituRendouRn {

    
    public List<ZT_SbRituRendouRn> OrderZT_SbRituRendouRnByPkAsc(List<ZT_SbRituRendouRn> pEntity) {
        List<SortCondition<ZT_SbRituRendouRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_SbRituRendouRn()).zrndatakanrino, SortOrder.ASC));
        List<ZT_SbRituRendouRn> copyList = new ArrayList<ZT_SbRituRendouRn>(pEntity);
        Collections.sort(copyList, new OrderZT_SbRituRendouRn(orders));
        return copyList;
    }

    
    public List<ZT_SbRituRendouRn> OrderZT_SbRituRendouRnByPkDesc(List<ZT_SbRituRendouRn> pEntity) {
        List<SortCondition<ZT_SbRituRendouRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_SbRituRendouRn()).zrndatakanrino, SortOrder.DESC));
        List<ZT_SbRituRendouRn> copyList = new ArrayList<ZT_SbRituRendouRn>(pEntity);
        Collections.sort(copyList, new OrderZT_SbRituRendouRn(orders));
        return copyList;
    }
}
