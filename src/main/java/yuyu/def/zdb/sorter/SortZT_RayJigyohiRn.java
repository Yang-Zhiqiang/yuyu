package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_RayJigyohiRn;
import yuyu.def.db.meta.QZT_RayJigyohiRn;
import yuyu.def.zdb.comparator.OrderZT_RayJigyohiRn;

public class SortZT_RayJigyohiRn {

    
    public List<ZT_RayJigyohiRn> OrderZT_RayJigyohiRnByPkAsc(List<ZT_RayJigyohiRn> pEntity) {
        List<SortCondition<ZT_RayJigyohiRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_RayJigyohiRn()).zrnsequenceno, SortOrder.ASC));
        List<ZT_RayJigyohiRn> copyList = new ArrayList<ZT_RayJigyohiRn>(pEntity);
        Collections.sort(copyList, new OrderZT_RayJigyohiRn(orders));
        return copyList;
    }

    
    public List<ZT_RayJigyohiRn> OrderZT_RayJigyohiRnByPkDesc(List<ZT_RayJigyohiRn> pEntity) {
        List<SortCondition<ZT_RayJigyohiRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_RayJigyohiRn()).zrnsequenceno, SortOrder.DESC));
        List<ZT_RayJigyohiRn> copyList = new ArrayList<ZT_RayJigyohiRn>(pEntity);
        Collections.sort(copyList, new OrderZT_RayJigyohiRn(orders));
        return copyList;
    }
}
