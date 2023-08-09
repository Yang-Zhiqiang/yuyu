package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_KouzaHnknTuutiRn;
import yuyu.def.db.meta.QZT_KouzaHnknTuutiRn;
import yuyu.def.zdb.comparator.OrderZT_KouzaHnknTuutiRn;

public class SortZT_KouzaHnknTuutiRn {

    
    public List<ZT_KouzaHnknTuutiRn> OrderZT_KouzaHnknTuutiRnByPkAsc(List<ZT_KouzaHnknTuutiRn> pEntity) {
        List<SortCondition<ZT_KouzaHnknTuutiRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_KouzaHnknTuutiRn()).zrnsyono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_KouzaHnknTuutiRn()).zrntyouhyouymd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_KouzaHnknTuutiRn()).zrnsikibetuno, SortOrder.ASC));
        List<ZT_KouzaHnknTuutiRn> copyList = new ArrayList<ZT_KouzaHnknTuutiRn>(pEntity);
        Collections.sort(copyList, new OrderZT_KouzaHnknTuutiRn(orders));
        return copyList;
    }

    
    public List<ZT_KouzaHnknTuutiRn> OrderZT_KouzaHnknTuutiRnByPkDesc(List<ZT_KouzaHnknTuutiRn> pEntity) {
        List<SortCondition<ZT_KouzaHnknTuutiRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_KouzaHnknTuutiRn()).zrnsyono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_KouzaHnknTuutiRn()).zrntyouhyouymd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_KouzaHnknTuutiRn()).zrnsikibetuno, SortOrder.DESC));
        List<ZT_KouzaHnknTuutiRn> copyList = new ArrayList<ZT_KouzaHnknTuutiRn>(pEntity);
        Collections.sort(copyList, new OrderZT_KouzaHnknTuutiRn(orders));
        return copyList;
    }
}
