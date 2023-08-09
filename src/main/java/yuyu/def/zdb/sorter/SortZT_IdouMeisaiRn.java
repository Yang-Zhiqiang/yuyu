package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_IdouMeisaiRn;
import yuyu.def.db.meta.QZT_IdouMeisaiRn;
import yuyu.def.zdb.comparator.OrderZT_IdouMeisaiRn;

public class SortZT_IdouMeisaiRn {

    
    public List<ZT_IdouMeisaiRn> OrderZT_IdouMeisaiRnByPkAsc(List<ZT_IdouMeisaiRn> pEntity) {
        List<SortCondition<ZT_IdouMeisaiRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_IdouMeisaiRn()).zrnsequenceno, SortOrder.ASC));
        List<ZT_IdouMeisaiRn> copyList = new ArrayList<ZT_IdouMeisaiRn>(pEntity);
        Collections.sort(copyList, new OrderZT_IdouMeisaiRn(orders));
        return copyList;
    }

    
    public List<ZT_IdouMeisaiRn> OrderZT_IdouMeisaiRnByPkDesc(List<ZT_IdouMeisaiRn> pEntity) {
        List<SortCondition<ZT_IdouMeisaiRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_IdouMeisaiRn()).zrnsequenceno, SortOrder.DESC));
        List<ZT_IdouMeisaiRn> copyList = new ArrayList<ZT_IdouMeisaiRn>(pEntity);
        Collections.sort(copyList, new OrderZT_IdouMeisaiRn(orders));
        return copyList;
    }
}
