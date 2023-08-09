package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_NkToukeiRigRn;
import yuyu.def.db.meta.QZT_NkToukeiRigRn;
import yuyu.def.zdb.comparator.OrderZT_NkToukeiRigRn;

public class SortZT_NkToukeiRigRn {

    
    public List<ZT_NkToukeiRigRn> OrderZT_NkToukeiRigRnByPkAsc(List<ZT_NkToukeiRigRn> pEntity) {
        List<SortCondition<ZT_NkToukeiRigRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_NkToukeiRigRn()).zrnsequenceno, SortOrder.ASC));
        List<ZT_NkToukeiRigRn> copyList = new ArrayList<ZT_NkToukeiRigRn>(pEntity);
        Collections.sort(copyList, new OrderZT_NkToukeiRigRn(orders));
        return copyList;
    }

    
    public List<ZT_NkToukeiRigRn> OrderZT_NkToukeiRigRnByPkDesc(List<ZT_NkToukeiRigRn> pEntity) {
        List<SortCondition<ZT_NkToukeiRigRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_NkToukeiRigRn()).zrnsequenceno, SortOrder.DESC));
        List<ZT_NkToukeiRigRn> copyList = new ArrayList<ZT_NkToukeiRigRn>(pEntity);
        Collections.sort(copyList, new OrderZT_NkToukeiRigRn(orders));
        return copyList;
    }
}
