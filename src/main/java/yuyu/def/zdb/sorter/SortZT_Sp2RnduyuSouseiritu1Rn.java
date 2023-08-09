package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_Sp2RnduyuSouseiritu1Rn;
import yuyu.def.db.meta.QZT_Sp2RnduyuSouseiritu1Rn;
import yuyu.def.zdb.comparator.OrderZT_Sp2RnduyuSouseiritu1Rn;

public class SortZT_Sp2RnduyuSouseiritu1Rn {

    
    public List<ZT_Sp2RnduyuSouseiritu1Rn> OrderZT_Sp2RnduyuSouseiritu1RnByPkAsc(List<ZT_Sp2RnduyuSouseiritu1Rn> pEntity) {
        List<SortCondition<ZT_Sp2RnduyuSouseiritu1Rn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_Sp2RnduyuSouseiritu1Rn()).zrnktgysyono, SortOrder.ASC));
        List<ZT_Sp2RnduyuSouseiritu1Rn> copyList = new ArrayList<ZT_Sp2RnduyuSouseiritu1Rn>(pEntity);
        Collections.sort(copyList, new OrderZT_Sp2RnduyuSouseiritu1Rn(orders));
        return copyList;
    }

    
    public List<ZT_Sp2RnduyuSouseiritu1Rn> OrderZT_Sp2RnduyuSouseiritu1RnByPkDesc(List<ZT_Sp2RnduyuSouseiritu1Rn> pEntity) {
        List<SortCondition<ZT_Sp2RnduyuSouseiritu1Rn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_Sp2RnduyuSouseiritu1Rn()).zrnktgysyono, SortOrder.DESC));
        List<ZT_Sp2RnduyuSouseiritu1Rn> copyList = new ArrayList<ZT_Sp2RnduyuSouseiritu1Rn>(pEntity);
        Collections.sort(copyList, new OrderZT_Sp2RnduyuSouseiritu1Rn(orders));
        return copyList;
    }
}
