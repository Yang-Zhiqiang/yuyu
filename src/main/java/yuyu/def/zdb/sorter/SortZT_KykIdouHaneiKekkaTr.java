package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_KykIdouHaneiKekkaTr;
import yuyu.def.db.meta.QZT_KykIdouHaneiKekkaTr;
import yuyu.def.zdb.comparator.OrderZT_KykIdouHaneiKekkaTr;

public class SortZT_KykIdouHaneiKekkaTr {

    
    public List<ZT_KykIdouHaneiKekkaTr> OrderZT_KykIdouHaneiKekkaTrByPkAsc(List<ZT_KykIdouHaneiKekkaTr> pEntity) {
        List<SortCondition<ZT_KykIdouHaneiKekkaTr>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_KykIdouHaneiKekkaTr()).ztrhuho2kyknokbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_KykIdouHaneiKekkaTr()).ztrhuho2kykno, SortOrder.ASC));
        List<ZT_KykIdouHaneiKekkaTr> copyList = new ArrayList<ZT_KykIdouHaneiKekkaTr>(pEntity);
        Collections.sort(copyList, new OrderZT_KykIdouHaneiKekkaTr(orders));
        return copyList;
    }

    
    public List<ZT_KykIdouHaneiKekkaTr> OrderZT_KykIdouHaneiKekkaTrByPkDesc(List<ZT_KykIdouHaneiKekkaTr> pEntity) {
        List<SortCondition<ZT_KykIdouHaneiKekkaTr>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_KykIdouHaneiKekkaTr()).ztrhuho2kyknokbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_KykIdouHaneiKekkaTr()).ztrhuho2kykno, SortOrder.DESC));
        List<ZT_KykIdouHaneiKekkaTr> copyList = new ArrayList<ZT_KykIdouHaneiKekkaTr>(pEntity);
        Collections.sort(copyList, new OrderZT_KykIdouHaneiKekkaTr(orders));
        return copyList;
    }
}
