package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_OnlineLincSousinRn;
import yuyu.def.db.meta.QZT_OnlineLincSousinRn;
import yuyu.def.zdb.comparator.OrderZT_OnlineLincSousinRn;

public class SortZT_OnlineLincSousinRn {

    
    public List<ZT_OnlineLincSousinRn> OrderZT_OnlineLincSousinRnByPkAsc(List<ZT_OnlineLincSousinRn> pEntity) {
        List<SortCondition<ZT_OnlineLincSousinRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_OnlineLincSousinRn()).zrnrecordsyubetukbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_OnlineLincSousinRn()).zrnkykkanrino, SortOrder.ASC));
        List<ZT_OnlineLincSousinRn> copyList = new ArrayList<ZT_OnlineLincSousinRn>(pEntity);
        Collections.sort(copyList, new OrderZT_OnlineLincSousinRn(orders));
        return copyList;
    }

    
    public List<ZT_OnlineLincSousinRn> OrderZT_OnlineLincSousinRnByPkDesc(List<ZT_OnlineLincSousinRn> pEntity) {
        List<SortCondition<ZT_OnlineLincSousinRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_OnlineLincSousinRn()).zrnrecordsyubetukbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_OnlineLincSousinRn()).zrnkykkanrino, SortOrder.DESC));
        List<ZT_OnlineLincSousinRn> copyList = new ArrayList<ZT_OnlineLincSousinRn>(pEntity);
        Collections.sort(copyList, new OrderZT_OnlineLincSousinRn(orders));
        return copyList;
    }
}
