package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_Sp2RnduyuSouseiritu5Ty;
import yuyu.def.db.meta.QZT_Sp2RnduyuSouseiritu5Ty;
import yuyu.def.zdb.comparator.OrderZT_Sp2RnduyuSouseiritu5Ty;

public class SortZT_Sp2RnduyuSouseiritu5Ty {

    
    public List<ZT_Sp2RnduyuSouseiritu5Ty> OrderZT_Sp2RnduyuSouseiritu5TyByPkAsc(List<ZT_Sp2RnduyuSouseiritu5Ty> pEntity) {
        List<SortCondition<ZT_Sp2RnduyuSouseiritu5Ty>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_Sp2RnduyuSouseiritu5Ty()).ztyktgysyono, SortOrder.ASC));
        List<ZT_Sp2RnduyuSouseiritu5Ty> copyList = new ArrayList<ZT_Sp2RnduyuSouseiritu5Ty>(pEntity);
        Collections.sort(copyList, new OrderZT_Sp2RnduyuSouseiritu5Ty(orders));
        return copyList;
    }

    
    public List<ZT_Sp2RnduyuSouseiritu5Ty> OrderZT_Sp2RnduyuSouseiritu5TyByPkDesc(List<ZT_Sp2RnduyuSouseiritu5Ty> pEntity) {
        List<SortCondition<ZT_Sp2RnduyuSouseiritu5Ty>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_Sp2RnduyuSouseiritu5Ty()).ztyktgysyono, SortOrder.DESC));
        List<ZT_Sp2RnduyuSouseiritu5Ty> copyList = new ArrayList<ZT_Sp2RnduyuSouseiritu5Ty>(pEntity);
        Collections.sort(copyList, new OrderZT_Sp2RnduyuSouseiritu5Ty(orders));
        return copyList;
    }
}
