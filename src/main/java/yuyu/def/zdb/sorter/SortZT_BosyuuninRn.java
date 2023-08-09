package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_BosyuuninRn;
import yuyu.def.db.meta.QZT_BosyuuninRn;
import yuyu.def.zdb.comparator.OrderZT_BosyuuninRn;

public class SortZT_BosyuuninRn {

    
    public List<ZT_BosyuuninRn> OrderZT_BosyuuninRnByPkAsc(List<ZT_BosyuuninRn> pEntity) {
        List<SortCondition<ZT_BosyuuninRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_BosyuuninRn()).zrnbosyuunincd, SortOrder.ASC));
        List<ZT_BosyuuninRn> copyList = new ArrayList<ZT_BosyuuninRn>(pEntity);
        Collections.sort(copyList, new OrderZT_BosyuuninRn(orders));
        return copyList;
    }

    
    public List<ZT_BosyuuninRn> OrderZT_BosyuuninRnByPkDesc(List<ZT_BosyuuninRn> pEntity) {
        List<SortCondition<ZT_BosyuuninRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_BosyuuninRn()).zrnbosyuunincd, SortOrder.DESC));
        List<ZT_BosyuuninRn> copyList = new ArrayList<ZT_BosyuuninRn>(pEntity);
        Collections.sort(copyList, new OrderZT_BosyuuninRn(orders));
        return copyList;
    }
}
