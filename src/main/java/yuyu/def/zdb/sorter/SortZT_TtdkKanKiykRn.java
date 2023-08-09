package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_TtdkKanKiykRn;
import yuyu.def.db.meta.QZT_TtdkKanKiykRn;
import yuyu.def.zdb.comparator.OrderZT_TtdkKanKiykRn;

public class SortZT_TtdkKanKiykRn {

    
    public List<ZT_TtdkKanKiykRn> OrderZT_TtdkKanKiykRnByPkAsc(List<ZT_TtdkKanKiykRn> pEntity) {
        List<SortCondition<ZT_TtdkKanKiykRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_TtdkKanKiykRn()).zrntyouhyouymd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_TtdkKanKiykRn()).zrnsyono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_TtdkKanKiykRn()).zrnsikibetuno, SortOrder.ASC));
        List<ZT_TtdkKanKiykRn> copyList = new ArrayList<ZT_TtdkKanKiykRn>(pEntity);
        Collections.sort(copyList, new OrderZT_TtdkKanKiykRn(orders));
        return copyList;
    }

    
    public List<ZT_TtdkKanKiykRn> OrderZT_TtdkKanKiykRnByPkDesc(List<ZT_TtdkKanKiykRn> pEntity) {
        List<SortCondition<ZT_TtdkKanKiykRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_TtdkKanKiykRn()).zrntyouhyouymd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_TtdkKanKiykRn()).zrnsyono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_TtdkKanKiykRn()).zrnsikibetuno, SortOrder.DESC));
        List<ZT_TtdkKanKiykRn> copyList = new ArrayList<ZT_TtdkKanKiykRn>(pEntity);
        Collections.sort(copyList, new OrderZT_TtdkKanKiykRn(orders));
        return copyList;
    }
}
