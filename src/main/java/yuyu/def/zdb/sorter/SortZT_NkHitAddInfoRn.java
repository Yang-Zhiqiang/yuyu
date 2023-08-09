package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_NkHitAddInfoRn;
import yuyu.def.db.meta.QZT_NkHitAddInfoRn;
import yuyu.def.zdb.comparator.OrderZT_NkHitAddInfoRn;

public class SortZT_NkHitAddInfoRn {

    
    public List<ZT_NkHitAddInfoRn> OrderZT_NkHitAddInfoRnByPkAsc(List<ZT_NkHitAddInfoRn> pEntity) {
        List<SortCondition<ZT_NkHitAddInfoRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_NkHitAddInfoRn()).zrnnksyousyono, SortOrder.ASC));
        List<ZT_NkHitAddInfoRn> copyList = new ArrayList<ZT_NkHitAddInfoRn>(pEntity);
        Collections.sort(copyList, new OrderZT_NkHitAddInfoRn(orders));
        return copyList;
    }

    
    public List<ZT_NkHitAddInfoRn> OrderZT_NkHitAddInfoRnByPkDesc(List<ZT_NkHitAddInfoRn> pEntity) {
        List<SortCondition<ZT_NkHitAddInfoRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_NkHitAddInfoRn()).zrnnksyousyono, SortOrder.DESC));
        List<ZT_NkHitAddInfoRn> copyList = new ArrayList<ZT_NkHitAddInfoRn>(pEntity);
        Collections.sort(copyList, new OrderZT_NkHitAddInfoRn(orders));
        return copyList;
    }
}
