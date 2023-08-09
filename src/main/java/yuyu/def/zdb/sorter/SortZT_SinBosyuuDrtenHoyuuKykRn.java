package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_SinBosyuuDrtenHoyuuKykRn;
import yuyu.def.db.meta.QZT_SinBosyuuDrtenHoyuuKykRn;
import yuyu.def.zdb.comparator.OrderZT_SinBosyuuDrtenHoyuuKykRn;

public class SortZT_SinBosyuuDrtenHoyuuKykRn {

    
    public List<ZT_SinBosyuuDrtenHoyuuKykRn> OrderZT_SinBosyuuDrtenHoyuuKykRnByPkAsc(List<ZT_SinBosyuuDrtenHoyuuKykRn> pEntity) {
        List<SortCondition<ZT_SinBosyuuDrtenHoyuuKykRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_SinBosyuuDrtenHoyuuKykRn()).zrnsyono, SortOrder.ASC));
        List<ZT_SinBosyuuDrtenHoyuuKykRn> copyList = new ArrayList<ZT_SinBosyuuDrtenHoyuuKykRn>(pEntity);
        Collections.sort(copyList, new OrderZT_SinBosyuuDrtenHoyuuKykRn(orders));
        return copyList;
    }

    
    public List<ZT_SinBosyuuDrtenHoyuuKykRn> OrderZT_SinBosyuuDrtenHoyuuKykRnByPkDesc(List<ZT_SinBosyuuDrtenHoyuuKykRn> pEntity) {
        List<SortCondition<ZT_SinBosyuuDrtenHoyuuKykRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_SinBosyuuDrtenHoyuuKykRn()).zrnsyono, SortOrder.DESC));
        List<ZT_SinBosyuuDrtenHoyuuKykRn> copyList = new ArrayList<ZT_SinBosyuuDrtenHoyuuKykRn>(pEntity);
        Collections.sort(copyList, new OrderZT_SinBosyuuDrtenHoyuuKykRn(orders));
        return copyList;
    }
}