package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_SyoumetuTuutiRn;
import yuyu.def.db.meta.QZT_SyoumetuTuutiRn;
import yuyu.def.zdb.comparator.OrderZT_SyoumetuTuutiRn;

public class SortZT_SyoumetuTuutiRn {

    
    public List<ZT_SyoumetuTuutiRn> OrderZT_SyoumetuTuutiRnByPkAsc(List<ZT_SyoumetuTuutiRn> pEntity) {
        List<SortCondition<ZT_SyoumetuTuutiRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_SyoumetuTuutiRn()).zrntyouhyouymd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_SyoumetuTuutiRn()).zrnsyono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_SyoumetuTuutiRn()).zrnsikibetuno, SortOrder.ASC));
        List<ZT_SyoumetuTuutiRn> copyList = new ArrayList<ZT_SyoumetuTuutiRn>(pEntity);
        Collections.sort(copyList, new OrderZT_SyoumetuTuutiRn(orders));
        return copyList;
    }

    
    public List<ZT_SyoumetuTuutiRn> OrderZT_SyoumetuTuutiRnByPkDesc(List<ZT_SyoumetuTuutiRn> pEntity) {
        List<SortCondition<ZT_SyoumetuTuutiRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_SyoumetuTuutiRn()).zrntyouhyouymd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_SyoumetuTuutiRn()).zrnsyono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_SyoumetuTuutiRn()).zrnsikibetuno, SortOrder.DESC));
        List<ZT_SyoumetuTuutiRn> copyList = new ArrayList<ZT_SyoumetuTuutiRn>(pEntity);
        Collections.sort(copyList, new OrderZT_SyoumetuTuutiRn(orders));
        return copyList;
    }
}
