package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_NkToukeiKtyTy;
import yuyu.def.db.meta.QZT_NkToukeiKtyTy;
import yuyu.def.zdb.comparator.OrderZT_NkToukeiKtyTy;

public class SortZT_NkToukeiKtyTy {

    
    public List<ZT_NkToukeiKtyTy> OrderZT_NkToukeiKtyTyByPkAsc(List<ZT_NkToukeiKtyTy> pEntity) {
        List<SortCondition<ZT_NkToukeiKtyTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_NkToukeiKtyTy()).ztysequenceno, SortOrder.ASC));
        List<ZT_NkToukeiKtyTy> copyList = new ArrayList<ZT_NkToukeiKtyTy>(pEntity);
        Collections.sort(copyList, new OrderZT_NkToukeiKtyTy(orders));
        return copyList;
    }

    
    public List<ZT_NkToukeiKtyTy> OrderZT_NkToukeiKtyTyByPkDesc(List<ZT_NkToukeiKtyTy> pEntity) {
        List<SortCondition<ZT_NkToukeiKtyTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_NkToukeiKtyTy()).ztysequenceno, SortOrder.DESC));
        List<ZT_NkToukeiKtyTy> copyList = new ArrayList<ZT_NkToukeiKtyTy>(pEntity);
        Collections.sort(copyList, new OrderZT_NkToukeiKtyTy(orders));
        return copyList;
    }
}
