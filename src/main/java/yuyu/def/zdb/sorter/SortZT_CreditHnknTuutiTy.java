package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_CreditHnknTuutiTy;
import yuyu.def.db.meta.QZT_CreditHnknTuutiTy;
import yuyu.def.zdb.comparator.OrderZT_CreditHnknTuutiTy;

public class SortZT_CreditHnknTuutiTy {

    
    public List<ZT_CreditHnknTuutiTy> OrderZT_CreditHnknTuutiTyByPkAsc(List<ZT_CreditHnknTuutiTy> pEntity) {
        List<SortCondition<ZT_CreditHnknTuutiTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_CreditHnknTuutiTy()).ztysyono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_CreditHnknTuutiTy()).ztytyouhyouymd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_CreditHnknTuutiTy()).ztysikibetuno, SortOrder.ASC));
        List<ZT_CreditHnknTuutiTy> copyList = new ArrayList<ZT_CreditHnknTuutiTy>(pEntity);
        Collections.sort(copyList, new OrderZT_CreditHnknTuutiTy(orders));
        return copyList;
    }

    
    public List<ZT_CreditHnknTuutiTy> OrderZT_CreditHnknTuutiTyByPkDesc(List<ZT_CreditHnknTuutiTy> pEntity) {
        List<SortCondition<ZT_CreditHnknTuutiTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_CreditHnknTuutiTy()).ztysyono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_CreditHnknTuutiTy()).ztytyouhyouymd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_CreditHnknTuutiTy()).ztysikibetuno, SortOrder.DESC));
        List<ZT_CreditHnknTuutiTy> copyList = new ArrayList<ZT_CreditHnknTuutiTy>(pEntity);
        Collections.sort(copyList, new OrderZT_CreditHnknTuutiTy(orders));
        return copyList;
    }
}
