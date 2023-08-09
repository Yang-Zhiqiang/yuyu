package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_SntkInfoHaneiKekkaTr;
import yuyu.def.db.meta.QZT_SntkInfoHaneiKekkaTr;
import yuyu.def.zdb.comparator.OrderZT_SntkInfoHaneiKekkaTr;

public class SortZT_SntkInfoHaneiKekkaTr {

    
    public List<ZT_SntkInfoHaneiKekkaTr> OrderZT_SntkInfoHaneiKekkaTrByPkAsc(List<ZT_SntkInfoHaneiKekkaTr> pEntity) {
        List<SortCondition<ZT_SntkInfoHaneiKekkaTr>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_SntkInfoHaneiKekkaTr()).ztrsntkinfono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_SntkInfoHaneiKekkaTr()).ztrrenno, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_SntkInfoHaneiKekkaTr()).ztrsntkinfotourokusyskbn, SortOrder.ASC));
        List<ZT_SntkInfoHaneiKekkaTr> copyList = new ArrayList<ZT_SntkInfoHaneiKekkaTr>(pEntity);
        Collections.sort(copyList, new OrderZT_SntkInfoHaneiKekkaTr(orders));
        return copyList;
    }

    
    public List<ZT_SntkInfoHaneiKekkaTr> OrderZT_SntkInfoHaneiKekkaTrByPkDesc(List<ZT_SntkInfoHaneiKekkaTr> pEntity) {
        List<SortCondition<ZT_SntkInfoHaneiKekkaTr>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_SntkInfoHaneiKekkaTr()).ztrsntkinfono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_SntkInfoHaneiKekkaTr()).ztrrenno, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_SntkInfoHaneiKekkaTr()).ztrsntkinfotourokusyskbn, SortOrder.DESC));
        List<ZT_SntkInfoHaneiKekkaTr> copyList = new ArrayList<ZT_SntkInfoHaneiKekkaTr>(pEntity);
        Collections.sort(copyList, new OrderZT_SntkInfoHaneiKekkaTr(orders));
        return copyList;
    }
}
