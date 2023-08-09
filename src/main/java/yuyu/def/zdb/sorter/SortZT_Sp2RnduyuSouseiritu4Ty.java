package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_Sp2RnduyuSouseiritu4Ty;
import yuyu.def.db.meta.QZT_Sp2RnduyuSouseiritu4Ty;
import yuyu.def.zdb.comparator.OrderZT_Sp2RnduyuSouseiritu4Ty;

public class SortZT_Sp2RnduyuSouseiritu4Ty {

    
    public List<ZT_Sp2RnduyuSouseiritu4Ty> OrderZT_Sp2RnduyuSouseiritu4TyByPkAsc(List<ZT_Sp2RnduyuSouseiritu4Ty> pEntity) {
        List<SortCondition<ZT_Sp2RnduyuSouseiritu4Ty>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_Sp2RnduyuSouseiritu4Ty()).ztyktgysyono, SortOrder.ASC));
        List<ZT_Sp2RnduyuSouseiritu4Ty> copyList = new ArrayList<ZT_Sp2RnduyuSouseiritu4Ty>(pEntity);
        Collections.sort(copyList, new OrderZT_Sp2RnduyuSouseiritu4Ty(orders));
        return copyList;
    }

    
    public List<ZT_Sp2RnduyuSouseiritu4Ty> OrderZT_Sp2RnduyuSouseiritu4TyByPkDesc(List<ZT_Sp2RnduyuSouseiritu4Ty> pEntity) {
        List<SortCondition<ZT_Sp2RnduyuSouseiritu4Ty>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_Sp2RnduyuSouseiritu4Ty()).ztyktgysyono, SortOrder.DESC));
        List<ZT_Sp2RnduyuSouseiritu4Ty> copyList = new ArrayList<ZT_Sp2RnduyuSouseiritu4Ty>(pEntity);
        Collections.sort(copyList, new OrderZT_Sp2RnduyuSouseiritu4Ty(orders));
        return copyList;
    }
}
