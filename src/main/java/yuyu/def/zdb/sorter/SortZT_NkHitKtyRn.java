package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_NkHitKtyRn;
import yuyu.def.db.meta.QZT_NkHitKtyRn;
import yuyu.def.zdb.comparator.OrderZT_NkHitKtyRn;

public class SortZT_NkHitKtyRn {

    
    public List<ZT_NkHitKtyRn> OrderZT_NkHitKtyRnByPkAsc(List<ZT_NkHitKtyRn> pEntity) {
        List<SortCondition<ZT_NkHitKtyRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_NkHitKtyRn()).zrnnksyousyono, SortOrder.ASC));
        List<ZT_NkHitKtyRn> copyList = new ArrayList<ZT_NkHitKtyRn>(pEntity);
        Collections.sort(copyList, new OrderZT_NkHitKtyRn(orders));
        return copyList;
    }

    
    public List<ZT_NkHitKtyRn> OrderZT_NkHitKtyRnByPkDesc(List<ZT_NkHitKtyRn> pEntity) {
        List<SortCondition<ZT_NkHitKtyRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_NkHitKtyRn()).zrnnksyousyono, SortOrder.DESC));
        List<ZT_NkHitKtyRn> copyList = new ArrayList<ZT_NkHitKtyRn>(pEntity);
        Collections.sort(copyList, new OrderZT_NkHitKtyRn(orders));
        return copyList;
    }
}
