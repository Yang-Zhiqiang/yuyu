package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_KawaserateTr;
import yuyu.def.db.meta.QZT_KawaserateTr;
import yuyu.def.zdb.comparator.OrderZT_KawaserateTr;

public class SortZT_KawaserateTr {

    
    public List<ZT_KawaserateTr> OrderZT_KawaserateTrByPkAsc(List<ZT_KawaserateTr> pEntity) {
        List<SortCondition<ZT_KawaserateTr>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_KawaserateTr()).ztrkwsratekjymd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_KawaserateTr()).ztrkawaserendoukbn, SortOrder.ASC));
        List<ZT_KawaserateTr> copyList = new ArrayList<ZT_KawaserateTr>(pEntity);
        Collections.sort(copyList, new OrderZT_KawaserateTr(orders));
        return copyList;
    }

    
    public List<ZT_KawaserateTr> OrderZT_KawaserateTrByPkDesc(List<ZT_KawaserateTr> pEntity) {
        List<SortCondition<ZT_KawaserateTr>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_KawaserateTr()).ztrkwsratekjymd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_KawaserateTr()).ztrkawaserendoukbn, SortOrder.DESC));
        List<ZT_KawaserateTr> copyList = new ArrayList<ZT_KawaserateTr>(pEntity);
        Collections.sort(copyList, new OrderZT_KawaserateTr(orders));
        return copyList;
    }
}
