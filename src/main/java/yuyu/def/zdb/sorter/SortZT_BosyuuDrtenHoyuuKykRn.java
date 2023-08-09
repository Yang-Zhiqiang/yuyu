package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_BosyuuDrtenHoyuuKykRn;
import yuyu.def.db.meta.QZT_BosyuuDrtenHoyuuKykRn;
import yuyu.def.zdb.comparator.OrderZT_BosyuuDrtenHoyuuKykRn;

public class SortZT_BosyuuDrtenHoyuuKykRn {

    
    public List<ZT_BosyuuDrtenHoyuuKykRn> OrderZT_BosyuuDrtenHoyuuKykRnByPkAsc(List<ZT_BosyuuDrtenHoyuuKykRn> pEntity) {
        List<SortCondition<ZT_BosyuuDrtenHoyuuKykRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_BosyuuDrtenHoyuuKykRn()).zrnsyonosyuban, SortOrder.ASC));
        List<ZT_BosyuuDrtenHoyuuKykRn> copyList = new ArrayList<ZT_BosyuuDrtenHoyuuKykRn>(pEntity);
        Collections.sort(copyList, new OrderZT_BosyuuDrtenHoyuuKykRn(orders));
        return copyList;
    }

    
    public List<ZT_BosyuuDrtenHoyuuKykRn> OrderZT_BosyuuDrtenHoyuuKykRnByPkDesc(List<ZT_BosyuuDrtenHoyuuKykRn> pEntity) {
        List<SortCondition<ZT_BosyuuDrtenHoyuuKykRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_BosyuuDrtenHoyuuKykRn()).zrnsyonosyuban, SortOrder.DESC));
        List<ZT_BosyuuDrtenHoyuuKykRn> copyList = new ArrayList<ZT_BosyuuDrtenHoyuuKykRn>(pEntity);
        Collections.sort(copyList, new OrderZT_BosyuuDrtenHoyuuKykRn(orders));
        return copyList;
    }
}
