package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_NkHitRigRn;
import yuyu.def.db.meta.QZT_NkHitRigRn;
import yuyu.def.zdb.comparator.OrderZT_NkHitRigRn;

public class SortZT_NkHitRigRn {

    
    public List<ZT_NkHitRigRn> OrderZT_NkHitRigRnByPkAsc(List<ZT_NkHitRigRn> pEntity) {
        List<SortCondition<ZT_NkHitRigRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_NkHitRigRn()).zrnnksyousyono, SortOrder.ASC));
        List<ZT_NkHitRigRn> copyList = new ArrayList<ZT_NkHitRigRn>(pEntity);
        Collections.sort(copyList, new OrderZT_NkHitRigRn(orders));
        return copyList;
    }

    
    public List<ZT_NkHitRigRn> OrderZT_NkHitRigRnByPkDesc(List<ZT_NkHitRigRn> pEntity) {
        List<SortCondition<ZT_NkHitRigRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_NkHitRigRn()).zrnnksyousyono, SortOrder.DESC));
        List<ZT_NkHitRigRn> copyList = new ArrayList<ZT_NkHitRigRn>(pEntity);
        Collections.sort(copyList, new OrderZT_NkHitRigRn(orders));
        return copyList;
    }
}
