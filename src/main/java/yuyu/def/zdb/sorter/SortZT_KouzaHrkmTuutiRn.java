package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_KouzaHrkmTuutiRn;
import yuyu.def.db.meta.QZT_KouzaHrkmTuutiRn;
import yuyu.def.zdb.comparator.OrderZT_KouzaHrkmTuutiRn;

public class SortZT_KouzaHrkmTuutiRn {

    
    public List<ZT_KouzaHrkmTuutiRn> OrderZT_KouzaHrkmTuutiRnByPkAsc(List<ZT_KouzaHrkmTuutiRn> pEntity) {
        List<SortCondition<ZT_KouzaHrkmTuutiRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_KouzaHrkmTuutiRn()).zrnsyono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_KouzaHrkmTuutiRn()).zrntyouhyouymd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_KouzaHrkmTuutiRn()).zrnsikibetuno, SortOrder.ASC));
        List<ZT_KouzaHrkmTuutiRn> copyList = new ArrayList<ZT_KouzaHrkmTuutiRn>(pEntity);
        Collections.sort(copyList, new OrderZT_KouzaHrkmTuutiRn(orders));
        return copyList;
    }

    
    public List<ZT_KouzaHrkmTuutiRn> OrderZT_KouzaHrkmTuutiRnByPkDesc(List<ZT_KouzaHrkmTuutiRn> pEntity) {
        List<SortCondition<ZT_KouzaHrkmTuutiRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_KouzaHrkmTuutiRn()).zrnsyono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_KouzaHrkmTuutiRn()).zrntyouhyouymd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_KouzaHrkmTuutiRn()).zrnsikibetuno, SortOrder.DESC));
        List<ZT_KouzaHrkmTuutiRn> copyList = new ArrayList<ZT_KouzaHrkmTuutiRn>(pEntity);
        Collections.sort(copyList, new OrderZT_KouzaHrkmTuutiRn(orders));
        return copyList;
    }
}
