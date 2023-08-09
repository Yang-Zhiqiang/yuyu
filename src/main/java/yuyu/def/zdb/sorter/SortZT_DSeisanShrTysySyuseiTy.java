package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_DSeisanShrTysySyuseiTy;
import yuyu.def.db.meta.QZT_DSeisanShrTysySyuseiTy;
import yuyu.def.zdb.comparator.OrderZT_DSeisanShrTysySyuseiTy;

public class SortZT_DSeisanShrTysySyuseiTy {

    
    public List<ZT_DSeisanShrTysySyuseiTy> OrderZT_DSeisanShrTysySyuseiTyByPkAsc(List<ZT_DSeisanShrTysySyuseiTy> pEntity) {
        List<SortCondition<ZT_DSeisanShrTysySyuseiTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_DSeisanShrTysySyuseiTy()).ztysyono, SortOrder.ASC));
        List<ZT_DSeisanShrTysySyuseiTy> copyList = new ArrayList<ZT_DSeisanShrTysySyuseiTy>(pEntity);
        Collections.sort(copyList, new OrderZT_DSeisanShrTysySyuseiTy(orders));
        return copyList;
    }

    
    public List<ZT_DSeisanShrTysySyuseiTy> OrderZT_DSeisanShrTysySyuseiTyByPkDesc(List<ZT_DSeisanShrTysySyuseiTy> pEntity) {
        List<SortCondition<ZT_DSeisanShrTysySyuseiTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_DSeisanShrTysySyuseiTy()).ztysyono, SortOrder.DESC));
        List<ZT_DSeisanShrTysySyuseiTy> copyList = new ArrayList<ZT_DSeisanShrTysySyuseiTy>(pEntity);
        Collections.sort(copyList, new OrderZT_DSeisanShrTysySyuseiTy(orders));
        return copyList;
    }
}
