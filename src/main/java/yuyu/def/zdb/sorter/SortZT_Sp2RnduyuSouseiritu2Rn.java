package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_Sp2RnduyuSouseiritu2Rn;
import yuyu.def.db.meta.QZT_Sp2RnduyuSouseiritu2Rn;
import yuyu.def.zdb.comparator.OrderZT_Sp2RnduyuSouseiritu2Rn;

public class SortZT_Sp2RnduyuSouseiritu2Rn {

    
    public List<ZT_Sp2RnduyuSouseiritu2Rn> OrderZT_Sp2RnduyuSouseiritu2RnByPkAsc(List<ZT_Sp2RnduyuSouseiritu2Rn> pEntity) {
        List<SortCondition<ZT_Sp2RnduyuSouseiritu2Rn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_Sp2RnduyuSouseiritu2Rn()).zrnktgysyono, SortOrder.ASC));
        List<ZT_Sp2RnduyuSouseiritu2Rn> copyList = new ArrayList<ZT_Sp2RnduyuSouseiritu2Rn>(pEntity);
        Collections.sort(copyList, new OrderZT_Sp2RnduyuSouseiritu2Rn(orders));
        return copyList;
    }

    
    public List<ZT_Sp2RnduyuSouseiritu2Rn> OrderZT_Sp2RnduyuSouseiritu2RnByPkDesc(List<ZT_Sp2RnduyuSouseiritu2Rn> pEntity) {
        List<SortCondition<ZT_Sp2RnduyuSouseiritu2Rn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_Sp2RnduyuSouseiritu2Rn()).zrnktgysyono, SortOrder.DESC));
        List<ZT_Sp2RnduyuSouseiritu2Rn> copyList = new ArrayList<ZT_Sp2RnduyuSouseiritu2Rn>(pEntity);
        Collections.sort(copyList, new OrderZT_Sp2RnduyuSouseiritu2Rn(orders));
        return copyList;
    }
}
