package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_NkToukeiHySgTy;
import yuyu.def.db.meta.QZT_NkToukeiHySgTy;
import yuyu.def.zdb.comparator.OrderZT_NkToukeiHySgTy;

public class SortZT_NkToukeiHySgTy {

    
    public List<ZT_NkToukeiHySgTy> OrderZT_NkToukeiHySgTyByPkAsc(List<ZT_NkToukeiHySgTy> pEntity) {
        List<SortCondition<ZT_NkToukeiHySgTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_NkToukeiHySgTy()).ztysequenceno, SortOrder.ASC));
        List<ZT_NkToukeiHySgTy> copyList = new ArrayList<ZT_NkToukeiHySgTy>(pEntity);
        Collections.sort(copyList, new OrderZT_NkToukeiHySgTy(orders));
        return copyList;
    }

    
    public List<ZT_NkToukeiHySgTy> OrderZT_NkToukeiHySgTyByPkDesc(List<ZT_NkToukeiHySgTy> pEntity) {
        List<SortCondition<ZT_NkToukeiHySgTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_NkToukeiHySgTy()).ztysequenceno, SortOrder.DESC));
        List<ZT_NkToukeiHySgTy> copyList = new ArrayList<ZT_NkToukeiHySgTy>(pEntity);
        Collections.sort(copyList, new OrderZT_NkToukeiHySgTy(orders));
        return copyList;
    }
}
