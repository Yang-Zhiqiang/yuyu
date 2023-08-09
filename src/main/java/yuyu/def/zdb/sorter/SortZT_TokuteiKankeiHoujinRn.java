package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_TokuteiKankeiHoujinRn;
import yuyu.def.db.meta.QZT_TokuteiKankeiHoujinRn;
import yuyu.def.zdb.comparator.OrderZT_TokuteiKankeiHoujinRn;

public class SortZT_TokuteiKankeiHoujinRn {

    
    public List<ZT_TokuteiKankeiHoujinRn> OrderZT_TokuteiKankeiHoujinRnByPkAsc(List<ZT_TokuteiKankeiHoujinRn> pEntity) {
        List<SortCondition<ZT_TokuteiKankeiHoujinRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_TokuteiKankeiHoujinRn()).zrnkinyuukikancd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_TokuteiKankeiHoujinRn()).zrnmeisaibangou, SortOrder.ASC));
        List<ZT_TokuteiKankeiHoujinRn> copyList = new ArrayList<ZT_TokuteiKankeiHoujinRn>(pEntity);
        Collections.sort(copyList, new OrderZT_TokuteiKankeiHoujinRn(orders));
        return copyList;
    }

    
    public List<ZT_TokuteiKankeiHoujinRn> OrderZT_TokuteiKankeiHoujinRnByPkDesc(List<ZT_TokuteiKankeiHoujinRn> pEntity) {
        List<SortCondition<ZT_TokuteiKankeiHoujinRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_TokuteiKankeiHoujinRn()).zrnkinyuukikancd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_TokuteiKankeiHoujinRn()).zrnmeisaibangou, SortOrder.DESC));
        List<ZT_TokuteiKankeiHoujinRn> copyList = new ArrayList<ZT_TokuteiKankeiHoujinRn>(pEntity);
        Collections.sort(copyList, new OrderZT_TokuteiKankeiHoujinRn(orders));
        return copyList;
    }
}
