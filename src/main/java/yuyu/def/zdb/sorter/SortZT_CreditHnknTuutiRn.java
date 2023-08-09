package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_CreditHnknTuutiRn;
import yuyu.def.db.meta.QZT_CreditHnknTuutiRn;
import yuyu.def.zdb.comparator.OrderZT_CreditHnknTuutiRn;

public class SortZT_CreditHnknTuutiRn {

    
    public List<ZT_CreditHnknTuutiRn> OrderZT_CreditHnknTuutiRnByPkAsc(List<ZT_CreditHnknTuutiRn> pEntity) {
        List<SortCondition<ZT_CreditHnknTuutiRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_CreditHnknTuutiRn()).zrnsyono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_CreditHnknTuutiRn()).zrntyouhyouymd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_CreditHnknTuutiRn()).zrnsikibetuno, SortOrder.ASC));
        List<ZT_CreditHnknTuutiRn> copyList = new ArrayList<ZT_CreditHnknTuutiRn>(pEntity);
        Collections.sort(copyList, new OrderZT_CreditHnknTuutiRn(orders));
        return copyList;
    }

    
    public List<ZT_CreditHnknTuutiRn> OrderZT_CreditHnknTuutiRnByPkDesc(List<ZT_CreditHnknTuutiRn> pEntity) {
        List<SortCondition<ZT_CreditHnknTuutiRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_CreditHnknTuutiRn()).zrnsyono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_CreditHnknTuutiRn()).zrntyouhyouymd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_CreditHnknTuutiRn()).zrnsikibetuno, SortOrder.DESC));
        List<ZT_CreditHnknTuutiRn> copyList = new ArrayList<ZT_CreditHnknTuutiRn>(pEntity);
        Collections.sort(copyList, new OrderZT_CreditHnknTuutiRn(orders));
        return copyList;
    }
}
