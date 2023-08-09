package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_HoyuuMeisaiRn;
import yuyu.def.db.meta.QZT_HoyuuMeisaiRn;
import yuyu.def.zdb.comparator.OrderZT_HoyuuMeisaiRn;

public class SortZT_HoyuuMeisaiRn {

    
    public List<ZT_HoyuuMeisaiRn> OrderZT_HoyuuMeisaiRnByPkAsc(List<ZT_HoyuuMeisaiRn> pEntity) {
        List<SortCondition<ZT_HoyuuMeisaiRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_HoyuuMeisaiRn()).zrnsequenceno, SortOrder.ASC));
        List<ZT_HoyuuMeisaiRn> copyList = new ArrayList<ZT_HoyuuMeisaiRn>(pEntity);
        Collections.sort(copyList, new OrderZT_HoyuuMeisaiRn(orders));
        return copyList;
    }

    
    public List<ZT_HoyuuMeisaiRn> OrderZT_HoyuuMeisaiRnByPkDesc(List<ZT_HoyuuMeisaiRn> pEntity) {
        List<SortCondition<ZT_HoyuuMeisaiRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_HoyuuMeisaiRn()).zrnsequenceno, SortOrder.DESC));
        List<ZT_HoyuuMeisaiRn> copyList = new ArrayList<ZT_HoyuuMeisaiRn>(pEntity);
        Collections.sort(copyList, new OrderZT_HoyuuMeisaiRn(orders));
        return copyList;
    }
}
