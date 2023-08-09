package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_NkHitKsnRn;
import yuyu.def.db.meta.QZT_NkHitKsnRn;
import yuyu.def.zdb.comparator.OrderZT_NkHitKsnRn;

public class SortZT_NkHitKsnRn {

    
    public List<ZT_NkHitKsnRn> OrderZT_NkHitKsnRnByPkAsc(List<ZT_NkHitKsnRn> pEntity) {
        List<SortCondition<ZT_NkHitKsnRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_NkHitKsnRn()).zrnnksyousyono, SortOrder.ASC));
        List<ZT_NkHitKsnRn> copyList = new ArrayList<ZT_NkHitKsnRn>(pEntity);
        Collections.sort(copyList, new OrderZT_NkHitKsnRn(orders));
        return copyList;
    }

    
    public List<ZT_NkHitKsnRn> OrderZT_NkHitKsnRnByPkDesc(List<ZT_NkHitKsnRn> pEntity) {
        List<SortCondition<ZT_NkHitKsnRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_NkHitKsnRn()).zrnnksyousyono, SortOrder.DESC));
        List<ZT_NkHitKsnRn> copyList = new ArrayList<ZT_NkHitKsnRn>(pEntity);
        Collections.sort(copyList, new OrderZT_NkHitKsnRn(orders));
        return copyList;
    }
}
