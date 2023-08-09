package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_DairitenRn;
import yuyu.def.db.meta.QZT_DairitenRn;
import yuyu.def.zdb.comparator.OrderZT_DairitenRn;

public class SortZT_DairitenRn {

    
    public List<ZT_DairitenRn> OrderZT_DairitenRnByPkAsc(List<ZT_DairitenRn> pEntity) {
        List<SortCondition<ZT_DairitenRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_DairitenRn()).zrndairitencd, SortOrder.ASC));
        List<ZT_DairitenRn> copyList = new ArrayList<ZT_DairitenRn>(pEntity);
        Collections.sort(copyList, new OrderZT_DairitenRn(orders));
        return copyList;
    }

    
    public List<ZT_DairitenRn> OrderZT_DairitenRnByPkDesc(List<ZT_DairitenRn> pEntity) {
        List<SortCondition<ZT_DairitenRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_DairitenRn()).zrndairitencd, SortOrder.DESC));
        List<ZT_DairitenRn> copyList = new ArrayList<ZT_DairitenRn>(pEntity);
        Collections.sort(copyList, new OrderZT_DairitenRn(orders));
        return copyList;
    }
}
