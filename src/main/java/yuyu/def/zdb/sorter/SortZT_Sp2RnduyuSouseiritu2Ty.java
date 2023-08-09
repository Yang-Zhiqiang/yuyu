package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_Sp2RnduyuSouseiritu2Ty;
import yuyu.def.db.meta.QZT_Sp2RnduyuSouseiritu2Ty;
import yuyu.def.zdb.comparator.OrderZT_Sp2RnduyuSouseiritu2Ty;

public class SortZT_Sp2RnduyuSouseiritu2Ty {

    
    public List<ZT_Sp2RnduyuSouseiritu2Ty> OrderZT_Sp2RnduyuSouseiritu2TyByPkAsc(List<ZT_Sp2RnduyuSouseiritu2Ty> pEntity) {
        List<SortCondition<ZT_Sp2RnduyuSouseiritu2Ty>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_Sp2RnduyuSouseiritu2Ty()).ztyktgysyono, SortOrder.ASC));
        List<ZT_Sp2RnduyuSouseiritu2Ty> copyList = new ArrayList<ZT_Sp2RnduyuSouseiritu2Ty>(pEntity);
        Collections.sort(copyList, new OrderZT_Sp2RnduyuSouseiritu2Ty(orders));
        return copyList;
    }

    
    public List<ZT_Sp2RnduyuSouseiritu2Ty> OrderZT_Sp2RnduyuSouseiritu2TyByPkDesc(List<ZT_Sp2RnduyuSouseiritu2Ty> pEntity) {
        List<SortCondition<ZT_Sp2RnduyuSouseiritu2Ty>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_Sp2RnduyuSouseiritu2Ty()).ztyktgysyono, SortOrder.DESC));
        List<ZT_Sp2RnduyuSouseiritu2Ty> copyList = new ArrayList<ZT_Sp2RnduyuSouseiritu2Ty>(pEntity);
        Collections.sort(copyList, new OrderZT_Sp2RnduyuSouseiritu2Ty(orders));
        return copyList;
    }
}
