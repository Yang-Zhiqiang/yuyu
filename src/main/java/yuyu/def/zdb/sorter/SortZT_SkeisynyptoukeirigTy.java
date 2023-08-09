package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_SkeisynyptoukeirigTy;
import yuyu.def.db.meta.QZT_SkeisynyptoukeirigTy;
import yuyu.def.zdb.comparator.OrderZT_SkeisynyptoukeirigTy;

public class SortZT_SkeisynyptoukeirigTy {

    
    public List<ZT_SkeisynyptoukeirigTy> OrderZT_SkeisynyptoukeirigTyByPkAsc(List<ZT_SkeisynyptoukeirigTy> pEntity) {
        List<SortCondition<ZT_SkeisynyptoukeirigTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_SkeisynyptoukeirigTy()).ztysequenceno, SortOrder.ASC));
        List<ZT_SkeisynyptoukeirigTy> copyList = new ArrayList<ZT_SkeisynyptoukeirigTy>(pEntity);
        Collections.sort(copyList, new OrderZT_SkeisynyptoukeirigTy(orders));
        return copyList;
    }

    
    public List<ZT_SkeisynyptoukeirigTy> OrderZT_SkeisynyptoukeirigTyByPkDesc(List<ZT_SkeisynyptoukeirigTy> pEntity) {
        List<SortCondition<ZT_SkeisynyptoukeirigTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_SkeisynyptoukeirigTy()).ztysequenceno, SortOrder.DESC));
        List<ZT_SkeisynyptoukeirigTy> copyList = new ArrayList<ZT_SkeisynyptoukeirigTy>(pEntity);
        Collections.sort(copyList, new OrderZT_SkeisynyptoukeirigTy(orders));
        return copyList;
    }
}
