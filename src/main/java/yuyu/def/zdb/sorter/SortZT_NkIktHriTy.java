package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_NkIktHriTy;
import yuyu.def.db.meta.QZT_NkIktHriTy;
import yuyu.def.zdb.comparator.OrderZT_NkIktHriTy;

public class SortZT_NkIktHriTy {

    
    public List<ZT_NkIktHriTy> OrderZT_NkIktHriTyByPkAsc(List<ZT_NkIktHriTy> pEntity) {
        List<SortCondition<ZT_NkIktHriTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_NkIktHriTy()).ztydatakanrino, SortOrder.ASC));
        List<ZT_NkIktHriTy> copyList = new ArrayList<ZT_NkIktHriTy>(pEntity);
        Collections.sort(copyList, new OrderZT_NkIktHriTy(orders));
        return copyList;
    }

    
    public List<ZT_NkIktHriTy> OrderZT_NkIktHriTyByPkDesc(List<ZT_NkIktHriTy> pEntity) {
        List<SortCondition<ZT_NkIktHriTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_NkIktHriTy()).ztydatakanrino, SortOrder.DESC));
        List<ZT_NkIktHriTy> copyList = new ArrayList<ZT_NkIktHriTy>(pEntity);
        Collections.sort(copyList, new OrderZT_NkIktHriTy(orders));
        return copyList;
    }
}
