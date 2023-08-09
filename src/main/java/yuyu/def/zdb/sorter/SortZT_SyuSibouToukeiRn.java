package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_SyuSibouToukeiRn;
import yuyu.def.db.meta.QZT_SyuSibouToukeiRn;
import yuyu.def.zdb.comparator.OrderZT_SyuSibouToukeiRn;

public class SortZT_SyuSibouToukeiRn {

    
    public List<ZT_SyuSibouToukeiRn> OrderZT_SyuSibouToukeiRnByPkAsc(List<ZT_SyuSibouToukeiRn> pEntity) {
        List<SortCondition<ZT_SyuSibouToukeiRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_SyuSibouToukeiRn()).zrnsyono, SortOrder.ASC));
        List<ZT_SyuSibouToukeiRn> copyList = new ArrayList<ZT_SyuSibouToukeiRn>(pEntity);
        Collections.sort(copyList, new OrderZT_SyuSibouToukeiRn(orders));
        return copyList;
    }

    
    public List<ZT_SyuSibouToukeiRn> OrderZT_SyuSibouToukeiRnByPkDesc(List<ZT_SyuSibouToukeiRn> pEntity) {
        List<SortCondition<ZT_SyuSibouToukeiRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_SyuSibouToukeiRn()).zrnsyono, SortOrder.DESC));
        List<ZT_SyuSibouToukeiRn> copyList = new ArrayList<ZT_SyuSibouToukeiRn>(pEntity);
        Collections.sort(copyList, new OrderZT_SyuSibouToukeiRn(orders));
        return copyList;
    }
}
