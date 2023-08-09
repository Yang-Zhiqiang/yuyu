package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_Sp2RnduyuSouseiritu3Ty;
import yuyu.def.db.meta.QZT_Sp2RnduyuSouseiritu3Ty;
import yuyu.def.zdb.comparator.OrderZT_Sp2RnduyuSouseiritu3Ty;

public class SortZT_Sp2RnduyuSouseiritu3Ty {

    
    public List<ZT_Sp2RnduyuSouseiritu3Ty> OrderZT_Sp2RnduyuSouseiritu3TyByPkAsc(List<ZT_Sp2RnduyuSouseiritu3Ty> pEntity) {
        List<SortCondition<ZT_Sp2RnduyuSouseiritu3Ty>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_Sp2RnduyuSouseiritu3Ty()).ztyktgysyono, SortOrder.ASC));
        List<ZT_Sp2RnduyuSouseiritu3Ty> copyList = new ArrayList<ZT_Sp2RnduyuSouseiritu3Ty>(pEntity);
        Collections.sort(copyList, new OrderZT_Sp2RnduyuSouseiritu3Ty(orders));
        return copyList;
    }

    
    public List<ZT_Sp2RnduyuSouseiritu3Ty> OrderZT_Sp2RnduyuSouseiritu3TyByPkDesc(List<ZT_Sp2RnduyuSouseiritu3Ty> pEntity) {
        List<SortCondition<ZT_Sp2RnduyuSouseiritu3Ty>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_Sp2RnduyuSouseiritu3Ty()).ztyktgysyono, SortOrder.DESC));
        List<ZT_Sp2RnduyuSouseiritu3Ty> copyList = new ArrayList<ZT_Sp2RnduyuSouseiritu3Ty>(pEntity);
        Collections.sort(copyList, new OrderZT_Sp2RnduyuSouseiritu3Ty(orders));
        return copyList;
    }
}
