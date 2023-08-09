package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_AlmNnknHyuTy;
import yuyu.def.db.meta.QZT_AlmNnknHyuTy;
import yuyu.def.zdb.comparator.OrderZT_AlmNnknHyuTy;

public class SortZT_AlmNnknHyuTy {

    
    public List<ZT_AlmNnknHyuTy> OrderZT_AlmNnknHyuTyByPkAsc(List<ZT_AlmNnknHyuTy> pEntity) {
        List<SortCondition<ZT_AlmNnknHyuTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_AlmNnknHyuTy()).ztynksyousyono, SortOrder.ASC));
        List<ZT_AlmNnknHyuTy> copyList = new ArrayList<ZT_AlmNnknHyuTy>(pEntity);
        Collections.sort(copyList, new OrderZT_AlmNnknHyuTy(orders));
        return copyList;
    }

    
    public List<ZT_AlmNnknHyuTy> OrderZT_AlmNnknHyuTyByPkDesc(List<ZT_AlmNnknHyuTy> pEntity) {
        List<SortCondition<ZT_AlmNnknHyuTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_AlmNnknHyuTy()).ztynksyousyono, SortOrder.DESC));
        List<ZT_AlmNnknHyuTy> copyList = new ArrayList<ZT_AlmNnknHyuTy>(pEntity);
        Collections.sort(copyList, new OrderZT_AlmNnknHyuTy(orders));
        return copyList;
    }
}
