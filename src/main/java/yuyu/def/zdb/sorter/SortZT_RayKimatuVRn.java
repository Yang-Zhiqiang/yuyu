package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_RayKimatuVRn;
import yuyu.def.db.meta.QZT_RayKimatuVRn;
import yuyu.def.zdb.comparator.OrderZT_RayKimatuVRn;

public class SortZT_RayKimatuVRn {

    
    public List<ZT_RayKimatuVRn> OrderZT_RayKimatuVRnByPkAsc(List<ZT_RayKimatuVRn> pEntity) {
        List<SortCondition<ZT_RayKimatuVRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_RayKimatuVRn()).zrnsequenceno, SortOrder.ASC));
        List<ZT_RayKimatuVRn> copyList = new ArrayList<ZT_RayKimatuVRn>(pEntity);
        Collections.sort(copyList, new OrderZT_RayKimatuVRn(orders));
        return copyList;
    }

    
    public List<ZT_RayKimatuVRn> OrderZT_RayKimatuVRnByPkDesc(List<ZT_RayKimatuVRn> pEntity) {
        List<SortCondition<ZT_RayKimatuVRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_RayKimatuVRn()).zrnsequenceno, SortOrder.DESC));
        List<ZT_RayKimatuVRn> copyList = new ArrayList<ZT_RayKimatuVRn>(pEntity);
        Collections.sort(copyList, new OrderZT_RayKimatuVRn(orders));
        return copyList;
    }
}
