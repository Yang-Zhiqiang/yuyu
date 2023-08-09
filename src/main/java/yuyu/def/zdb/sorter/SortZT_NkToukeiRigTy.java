package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_NkToukeiRigTy;
import yuyu.def.db.meta.QZT_NkToukeiRigTy;
import yuyu.def.zdb.comparator.OrderZT_NkToukeiRigTy;

public class SortZT_NkToukeiRigTy {

    
    public List<ZT_NkToukeiRigTy> OrderZT_NkToukeiRigTyByPkAsc(List<ZT_NkToukeiRigTy> pEntity) {
        List<SortCondition<ZT_NkToukeiRigTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_NkToukeiRigTy()).ztysequenceno, SortOrder.ASC));
        List<ZT_NkToukeiRigTy> copyList = new ArrayList<ZT_NkToukeiRigTy>(pEntity);
        Collections.sort(copyList, new OrderZT_NkToukeiRigTy(orders));
        return copyList;
    }

    
    public List<ZT_NkToukeiRigTy> OrderZT_NkToukeiRigTyByPkDesc(List<ZT_NkToukeiRigTy> pEntity) {
        List<SortCondition<ZT_NkToukeiRigTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_NkToukeiRigTy()).ztysequenceno, SortOrder.DESC));
        List<ZT_NkToukeiRigTy> copyList = new ArrayList<ZT_NkToukeiRigTy>(pEntity);
        Collections.sort(copyList, new OrderZT_NkToukeiRigTy(orders));
        return copyList;
    }
}
