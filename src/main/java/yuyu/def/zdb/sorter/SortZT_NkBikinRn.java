package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_NkBikinRn;
import yuyu.def.db.meta.QZT_NkBikinRn;
import yuyu.def.zdb.comparator.OrderZT_NkBikinRn;

public class SortZT_NkBikinRn {

    
    public List<ZT_NkBikinRn> OrderZT_NkBikinRnByPkAsc(List<ZT_NkBikinRn> pEntity) {
        List<SortCondition<ZT_NkBikinRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_NkBikinRn()).zrnnksyousyono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_NkBikinRn()).zrnshiharaihasseiymd, SortOrder.ASC));
        List<ZT_NkBikinRn> copyList = new ArrayList<ZT_NkBikinRn>(pEntity);
        Collections.sort(copyList, new OrderZT_NkBikinRn(orders));
        return copyList;
    }

    
    public List<ZT_NkBikinRn> OrderZT_NkBikinRnByPkDesc(List<ZT_NkBikinRn> pEntity) {
        List<SortCondition<ZT_NkBikinRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_NkBikinRn()).zrnnksyousyono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_NkBikinRn()).zrnshiharaihasseiymd, SortOrder.DESC));
        List<ZT_NkBikinRn> copyList = new ArrayList<ZT_NkBikinRn>(pEntity);
        Collections.sort(copyList, new OrderZT_NkBikinRn(orders));
        return copyList;
    }
}
