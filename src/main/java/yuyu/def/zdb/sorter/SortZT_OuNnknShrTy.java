package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_OuNnknShrTy;
import yuyu.def.db.meta.QZT_OuNnknShrTy;
import yuyu.def.zdb.comparator.OrderZT_OuNnknShrTy;

public class SortZT_OuNnknShrTy {

    
    public List<ZT_OuNnknShrTy> OrderZT_OuNnknShrTyByPkAsc(List<ZT_OuNnknShrTy> pEntity) {
        List<SortCondition<ZT_OuNnknShrTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_OuNnknShrTy()).ztysequenceno, SortOrder.ASC));
        List<ZT_OuNnknShrTy> copyList = new ArrayList<ZT_OuNnknShrTy>(pEntity);
        Collections.sort(copyList, new OrderZT_OuNnknShrTy(orders));
        return copyList;
    }

    
    public List<ZT_OuNnknShrTy> OrderZT_OuNnknShrTyByPkDesc(List<ZT_OuNnknShrTy> pEntity) {
        List<SortCondition<ZT_OuNnknShrTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_OuNnknShrTy()).ztysequenceno, SortOrder.DESC));
        List<ZT_OuNnknShrTy> copyList = new ArrayList<ZT_OuNnknShrTy>(pEntity);
        Collections.sort(copyList, new OrderZT_OuNnknShrTy(orders));
        return copyList;
    }
}
