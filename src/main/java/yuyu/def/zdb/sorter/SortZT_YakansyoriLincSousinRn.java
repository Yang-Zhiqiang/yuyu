package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_YakansyoriLincSousinRn;
import yuyu.def.db.meta.QZT_YakansyoriLincSousinRn;
import yuyu.def.zdb.comparator.OrderZT_YakansyoriLincSousinRn;

public class SortZT_YakansyoriLincSousinRn {

    
    public List<ZT_YakansyoriLincSousinRn> OrderZT_YakansyoriLincSousinRnByPkAsc(List<ZT_YakansyoriLincSousinRn> pEntity) {
        List<SortCondition<ZT_YakansyoriLincSousinRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_YakansyoriLincSousinRn()).zrnrecordsyubetukbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_YakansyoriLincSousinRn()).zrnkykkanrino, SortOrder.ASC));
        List<ZT_YakansyoriLincSousinRn> copyList = new ArrayList<ZT_YakansyoriLincSousinRn>(pEntity);
        Collections.sort(copyList, new OrderZT_YakansyoriLincSousinRn(orders));
        return copyList;
    }

    
    public List<ZT_YakansyoriLincSousinRn> OrderZT_YakansyoriLincSousinRnByPkDesc(List<ZT_YakansyoriLincSousinRn> pEntity) {
        List<SortCondition<ZT_YakansyoriLincSousinRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_YakansyoriLincSousinRn()).zrnrecordsyubetukbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_YakansyoriLincSousinRn()).zrnkykkanrino, SortOrder.DESC));
        List<ZT_YakansyoriLincSousinRn> copyList = new ArrayList<ZT_YakansyoriLincSousinRn>(pEntity);
        Collections.sort(copyList, new OrderZT_YakansyoriLincSousinRn(orders));
        return copyList;
    }
}
