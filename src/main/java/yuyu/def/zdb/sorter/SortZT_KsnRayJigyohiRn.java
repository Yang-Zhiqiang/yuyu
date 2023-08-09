package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_KsnRayJigyohiRn;
import yuyu.def.db.meta.QZT_KsnRayJigyohiRn;
import yuyu.def.zdb.comparator.OrderZT_KsnRayJigyohiRn;

public class SortZT_KsnRayJigyohiRn {

    
    public List<ZT_KsnRayJigyohiRn> OrderZT_KsnRayJigyohiRnByPkAsc(List<ZT_KsnRayJigyohiRn> pEntity) {
        List<SortCondition<ZT_KsnRayJigyohiRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_KsnRayJigyohiRn()).zrnsequenceno, SortOrder.ASC));
        List<ZT_KsnRayJigyohiRn> copyList = new ArrayList<ZT_KsnRayJigyohiRn>(pEntity);
        Collections.sort(copyList, new OrderZT_KsnRayJigyohiRn(orders));
        return copyList;
    }

    
    public List<ZT_KsnRayJigyohiRn> OrderZT_KsnRayJigyohiRnByPkDesc(List<ZT_KsnRayJigyohiRn> pEntity) {
        List<SortCondition<ZT_KsnRayJigyohiRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_KsnRayJigyohiRn()).zrnsequenceno, SortOrder.DESC));
        List<ZT_KsnRayJigyohiRn> copyList = new ArrayList<ZT_KsnRayJigyohiRn>(pEntity);
        Collections.sort(copyList, new OrderZT_KsnRayJigyohiRn(orders));
        return copyList;
    }
}
