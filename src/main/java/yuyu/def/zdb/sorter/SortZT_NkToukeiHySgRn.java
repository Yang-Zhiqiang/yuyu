package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_NkToukeiHySgRn;
import yuyu.def.db.meta.QZT_NkToukeiHySgRn;
import yuyu.def.zdb.comparator.OrderZT_NkToukeiHySgRn;

public class SortZT_NkToukeiHySgRn {

    
    public List<ZT_NkToukeiHySgRn> OrderZT_NkToukeiHySgRnByPkAsc(List<ZT_NkToukeiHySgRn> pEntity) {
        List<SortCondition<ZT_NkToukeiHySgRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_NkToukeiHySgRn()).zrnsequenceno, SortOrder.ASC));
        List<ZT_NkToukeiHySgRn> copyList = new ArrayList<ZT_NkToukeiHySgRn>(pEntity);
        Collections.sort(copyList, new OrderZT_NkToukeiHySgRn(orders));
        return copyList;
    }

    
    public List<ZT_NkToukeiHySgRn> OrderZT_NkToukeiHySgRnByPkDesc(List<ZT_NkToukeiHySgRn> pEntity) {
        List<SortCondition<ZT_NkToukeiHySgRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_NkToukeiHySgRn()).zrnsequenceno, SortOrder.DESC));
        List<ZT_NkToukeiHySgRn> copyList = new ArrayList<ZT_NkToukeiHySgRn>(pEntity);
        Collections.sort(copyList, new OrderZT_NkToukeiHySgRn(orders));
        return copyList;
    }
}
