package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_TtdkKanRn;
import yuyu.def.db.meta.QZT_TtdkKanRn;
import yuyu.def.zdb.comparator.OrderZT_TtdkKanRn;

public class SortZT_TtdkKanRn {

    
    public List<ZT_TtdkKanRn> OrderZT_TtdkKanRnByPkAsc(List<ZT_TtdkKanRn> pEntity) {
        List<SortCondition<ZT_TtdkKanRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_TtdkKanRn()).zrntyouhyouymd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_TtdkKanRn()).zrnsyono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_TtdkKanRn()).zrnsikibetuno, SortOrder.ASC));
        List<ZT_TtdkKanRn> copyList = new ArrayList<ZT_TtdkKanRn>(pEntity);
        Collections.sort(copyList, new OrderZT_TtdkKanRn(orders));
        return copyList;
    }

    
    public List<ZT_TtdkKanRn> OrderZT_TtdkKanRnByPkDesc(List<ZT_TtdkKanRn> pEntity) {
        List<SortCondition<ZT_TtdkKanRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_TtdkKanRn()).zrntyouhyouymd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_TtdkKanRn()).zrnsyono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_TtdkKanRn()).zrnsikibetuno, SortOrder.DESC));
        List<ZT_TtdkKanRn> copyList = new ArrayList<ZT_TtdkKanRn>(pEntity);
        Collections.sort(copyList, new OrderZT_TtdkKanRn(orders));
        return copyList;
    }
}
