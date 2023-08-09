package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_KawaserateRn;
import yuyu.def.db.meta.QZT_KawaserateRn;
import yuyu.def.zdb.comparator.OrderZT_KawaserateRn;

public class SortZT_KawaserateRn {

    
    public List<ZT_KawaserateRn> OrderZT_KawaserateRnByPkAsc(List<ZT_KawaserateRn> pEntity) {
        List<SortCondition<ZT_KawaserateRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_KawaserateRn()).zrnkwsratekjymd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_KawaserateRn()).zrnkawaserendoukbn, SortOrder.ASC));
        List<ZT_KawaserateRn> copyList = new ArrayList<ZT_KawaserateRn>(pEntity);
        Collections.sort(copyList, new OrderZT_KawaserateRn(orders));
        return copyList;
    }

    
    public List<ZT_KawaserateRn> OrderZT_KawaserateRnByPkDesc(List<ZT_KawaserateRn> pEntity) {
        List<SortCondition<ZT_KawaserateRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_KawaserateRn()).zrnkwsratekjymd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_KawaserateRn()).zrnkawaserendoukbn, SortOrder.DESC));
        List<ZT_KawaserateRn> copyList = new ArrayList<ZT_KawaserateRn>(pEntity);
        Collections.sort(copyList, new OrderZT_KawaserateRn(orders));
        return copyList;
    }
}
