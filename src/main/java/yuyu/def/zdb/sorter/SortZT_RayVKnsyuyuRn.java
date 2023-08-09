package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_RayVKnsyuyuRn;
import yuyu.def.db.meta.QZT_RayVKnsyuyuRn;
import yuyu.def.zdb.comparator.OrderZT_RayVKnsyuyuRn;

public class SortZT_RayVKnsyuyuRn {

    
    public List<ZT_RayVKnsyuyuRn> OrderZT_RayVKnsyuyuRnByPkAsc(List<ZT_RayVKnsyuyuRn> pEntity) {
        List<SortCondition<ZT_RayVKnsyuyuRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_RayVKnsyuyuRn()).zrnsequenceno, SortOrder.ASC));
        List<ZT_RayVKnsyuyuRn> copyList = new ArrayList<ZT_RayVKnsyuyuRn>(pEntity);
        Collections.sort(copyList, new OrderZT_RayVKnsyuyuRn(orders));
        return copyList;
    }

    
    public List<ZT_RayVKnsyuyuRn> OrderZT_RayVKnsyuyuRnByPkDesc(List<ZT_RayVKnsyuyuRn> pEntity) {
        List<SortCondition<ZT_RayVKnsyuyuRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_RayVKnsyuyuRn()).zrnsequenceno, SortOrder.DESC));
        List<ZT_RayVKnsyuyuRn> copyList = new ArrayList<ZT_RayVKnsyuyuRn>(pEntity);
        Collections.sort(copyList, new OrderZT_RayVKnsyuyuRn(orders));
        return copyList;
    }
}
