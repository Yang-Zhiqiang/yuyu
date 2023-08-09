package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_NkToukeiKtyRn;
import yuyu.def.db.meta.QZT_NkToukeiKtyRn;
import yuyu.def.zdb.comparator.OrderZT_NkToukeiKtyRn;

public class SortZT_NkToukeiKtyRn {

    
    public List<ZT_NkToukeiKtyRn> OrderZT_NkToukeiKtyRnByPkAsc(List<ZT_NkToukeiKtyRn> pEntity) {
        List<SortCondition<ZT_NkToukeiKtyRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_NkToukeiKtyRn()).zrnsequenceno, SortOrder.ASC));
        List<ZT_NkToukeiKtyRn> copyList = new ArrayList<ZT_NkToukeiKtyRn>(pEntity);
        Collections.sort(copyList, new OrderZT_NkToukeiKtyRn(orders));
        return copyList;
    }

    
    public List<ZT_NkToukeiKtyRn> OrderZT_NkToukeiKtyRnByPkDesc(List<ZT_NkToukeiKtyRn> pEntity) {
        List<SortCondition<ZT_NkToukeiKtyRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_NkToukeiKtyRn()).zrnsequenceno, SortOrder.DESC));
        List<ZT_NkToukeiKtyRn> copyList = new ArrayList<ZT_NkToukeiKtyRn>(pEntity);
        Collections.sort(copyList, new OrderZT_NkToukeiKtyRn(orders));
        return copyList;
    }
}
