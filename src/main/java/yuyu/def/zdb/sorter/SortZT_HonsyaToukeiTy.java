package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_HonsyaToukeiTy;
import yuyu.def.db.meta.QZT_HonsyaToukeiTy;
import yuyu.def.zdb.comparator.OrderZT_HonsyaToukeiTy;

public class SortZT_HonsyaToukeiTy {

    
    public List<ZT_HonsyaToukeiTy> OrderZT_HonsyaToukeiTyByPkAsc(List<ZT_HonsyaToukeiTy> pEntity) {
        List<SortCondition<ZT_HonsyaToukeiTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_HonsyaToukeiTy()).ztykijyunym, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_HonsyaToukeiTy()).ztymosno, SortOrder.ASC));
        List<ZT_HonsyaToukeiTy> copyList = new ArrayList<ZT_HonsyaToukeiTy>(pEntity);
        Collections.sort(copyList, new OrderZT_HonsyaToukeiTy(orders));
        return copyList;
    }

    
    public List<ZT_HonsyaToukeiTy> OrderZT_HonsyaToukeiTyByPkDesc(List<ZT_HonsyaToukeiTy> pEntity) {
        List<SortCondition<ZT_HonsyaToukeiTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_HonsyaToukeiTy()).ztykijyunym, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_HonsyaToukeiTy()).ztymosno, SortOrder.DESC));
        List<ZT_HonsyaToukeiTy> copyList = new ArrayList<ZT_HonsyaToukeiTy>(pEntity);
        Collections.sort(copyList, new OrderZT_HonsyaToukeiTy(orders));
        return copyList;
    }
}
