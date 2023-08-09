package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_AcsAdrNmRn;
import yuyu.def.db.meta.QZT_AcsAdrNmRn;
import yuyu.def.zdb.comparator.OrderZT_AcsAdrNmRn;

public class SortZT_AcsAdrNmRn {

    
    public List<ZT_AcsAdrNmRn> OrderZT_AcsAdrNmRnByPkAsc(List<ZT_AcsAdrNmRn> pEntity) {
        List<SortCondition<ZT_AcsAdrNmRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_AcsAdrNmRn()).zrnkihontikucd, SortOrder.ASC));
        List<ZT_AcsAdrNmRn> copyList = new ArrayList<ZT_AcsAdrNmRn>(pEntity);
        Collections.sort(copyList, new OrderZT_AcsAdrNmRn(orders));
        return copyList;
    }

    
    public List<ZT_AcsAdrNmRn> OrderZT_AcsAdrNmRnByPkDesc(List<ZT_AcsAdrNmRn> pEntity) {
        List<SortCondition<ZT_AcsAdrNmRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_AcsAdrNmRn()).zrnkihontikucd, SortOrder.DESC));
        List<ZT_AcsAdrNmRn> copyList = new ArrayList<ZT_AcsAdrNmRn>(pEntity);
        Collections.sort(copyList, new OrderZT_AcsAdrNmRn(orders));
        return copyList;
    }
}
