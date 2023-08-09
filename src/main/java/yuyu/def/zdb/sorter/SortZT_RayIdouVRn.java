package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_RayIdouVRn;
import yuyu.def.db.meta.QZT_RayIdouVRn;
import yuyu.def.zdb.comparator.OrderZT_RayIdouVRn;

public class SortZT_RayIdouVRn {

    
    public List<ZT_RayIdouVRn> OrderZT_RayIdouVRnByPkAsc(List<ZT_RayIdouVRn> pEntity) {
        List<SortCondition<ZT_RayIdouVRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_RayIdouVRn()).zrnsequenceno, SortOrder.ASC));
        List<ZT_RayIdouVRn> copyList = new ArrayList<ZT_RayIdouVRn>(pEntity);
        Collections.sort(copyList, new OrderZT_RayIdouVRn(orders));
        return copyList;
    }

    
    public List<ZT_RayIdouVRn> OrderZT_RayIdouVRnByPkDesc(List<ZT_RayIdouVRn> pEntity) {
        List<SortCondition<ZT_RayIdouVRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_RayIdouVRn()).zrnsequenceno, SortOrder.DESC));
        List<ZT_RayIdouVRn> copyList = new ArrayList<ZT_RayIdouVRn>(pEntity);
        Collections.sort(copyList, new OrderZT_RayIdouVRn(orders));
        return copyList;
    }
}
