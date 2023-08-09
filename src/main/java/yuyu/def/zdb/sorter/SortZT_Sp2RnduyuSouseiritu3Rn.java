package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_Sp2RnduyuSouseiritu3Rn;
import yuyu.def.db.meta.QZT_Sp2RnduyuSouseiritu3Rn;
import yuyu.def.zdb.comparator.OrderZT_Sp2RnduyuSouseiritu3Rn;

public class SortZT_Sp2RnduyuSouseiritu3Rn {

    
    public List<ZT_Sp2RnduyuSouseiritu3Rn> OrderZT_Sp2RnduyuSouseiritu3RnByPkAsc(List<ZT_Sp2RnduyuSouseiritu3Rn> pEntity) {
        List<SortCondition<ZT_Sp2RnduyuSouseiritu3Rn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_Sp2RnduyuSouseiritu3Rn()).zrnktgysyono, SortOrder.ASC));
        List<ZT_Sp2RnduyuSouseiritu3Rn> copyList = new ArrayList<ZT_Sp2RnduyuSouseiritu3Rn>(pEntity);
        Collections.sort(copyList, new OrderZT_Sp2RnduyuSouseiritu3Rn(orders));
        return copyList;
    }

    
    public List<ZT_Sp2RnduyuSouseiritu3Rn> OrderZT_Sp2RnduyuSouseiritu3RnByPkDesc(List<ZT_Sp2RnduyuSouseiritu3Rn> pEntity) {
        List<SortCondition<ZT_Sp2RnduyuSouseiritu3Rn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_Sp2RnduyuSouseiritu3Rn()).zrnktgysyono, SortOrder.DESC));
        List<ZT_Sp2RnduyuSouseiritu3Rn> copyList = new ArrayList<ZT_Sp2RnduyuSouseiritu3Rn>(pEntity);
        Collections.sort(copyList, new OrderZT_Sp2RnduyuSouseiritu3Rn(orders));
        return copyList;
    }
}
