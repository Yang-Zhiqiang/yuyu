package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_AuthoriKekkaTr;
import yuyu.def.db.meta.QZT_AuthoriKekkaTr;
import yuyu.def.zdb.comparator.OrderZT_AuthoriKekkaTr;

public class SortZT_AuthoriKekkaTr {

    
    public List<ZT_AuthoriKekkaTr> OrderZT_AuthoriKekkaTrByPkAsc(List<ZT_AuthoriKekkaTr> pEntity) {
        List<SortCondition<ZT_AuthoriKekkaTr>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_AuthoriKekkaTr()).ztrrenno7, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_AuthoriKekkaTr()).ztrcreditkessaiyouno, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_AuthoriKekkaTr()).ztrdatajyusinymd, SortOrder.ASC));
        List<ZT_AuthoriKekkaTr> copyList = new ArrayList<ZT_AuthoriKekkaTr>(pEntity);
        Collections.sort(copyList, new OrderZT_AuthoriKekkaTr(orders));
        return copyList;
    }

    
    public List<ZT_AuthoriKekkaTr> OrderZT_AuthoriKekkaTrByPkDesc(List<ZT_AuthoriKekkaTr> pEntity) {
        List<SortCondition<ZT_AuthoriKekkaTr>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_AuthoriKekkaTr()).ztrrenno7, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_AuthoriKekkaTr()).ztrcreditkessaiyouno, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_AuthoriKekkaTr()).ztrdatajyusinymd, SortOrder.DESC));
        List<ZT_AuthoriKekkaTr> copyList = new ArrayList<ZT_AuthoriKekkaTr>(pEntity);
        Collections.sort(copyList, new OrderZT_AuthoriKekkaTr(orders));
        return copyList;
    }
}
