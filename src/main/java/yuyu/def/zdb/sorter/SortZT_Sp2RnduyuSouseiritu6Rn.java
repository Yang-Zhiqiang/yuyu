package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_Sp2RnduyuSouseiritu6Rn;
import yuyu.def.db.meta.QZT_Sp2RnduyuSouseiritu6Rn;
import yuyu.def.zdb.comparator.OrderZT_Sp2RnduyuSouseiritu6Rn;

public class SortZT_Sp2RnduyuSouseiritu6Rn {

    
    public List<ZT_Sp2RnduyuSouseiritu6Rn> OrderZT_Sp2RnduyuSouseiritu6RnByPkAsc(List<ZT_Sp2RnduyuSouseiritu6Rn> pEntity) {
        List<SortCondition<ZT_Sp2RnduyuSouseiritu6Rn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_Sp2RnduyuSouseiritu6Rn()).zrnktgysyono, SortOrder.ASC));
        List<ZT_Sp2RnduyuSouseiritu6Rn> copyList = new ArrayList<ZT_Sp2RnduyuSouseiritu6Rn>(pEntity);
        Collections.sort(copyList, new OrderZT_Sp2RnduyuSouseiritu6Rn(orders));
        return copyList;
    }

    
    public List<ZT_Sp2RnduyuSouseiritu6Rn> OrderZT_Sp2RnduyuSouseiritu6RnByPkDesc(List<ZT_Sp2RnduyuSouseiritu6Rn> pEntity) {
        List<SortCondition<ZT_Sp2RnduyuSouseiritu6Rn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_Sp2RnduyuSouseiritu6Rn()).zrnktgysyono, SortOrder.DESC));
        List<ZT_Sp2RnduyuSouseiritu6Rn> copyList = new ArrayList<ZT_Sp2RnduyuSouseiritu6Rn>(pEntity);
        Collections.sort(copyList, new OrderZT_Sp2RnduyuSouseiritu6Rn(orders));
        return copyList;
    }
}
