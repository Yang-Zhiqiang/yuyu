package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_YakansyoriLincSousinTy;
import yuyu.def.db.meta.QZT_YakansyoriLincSousinTy;
import yuyu.def.zdb.comparator.OrderZT_YakansyoriLincSousinTy;

public class SortZT_YakansyoriLincSousinTy {

    
    public List<ZT_YakansyoriLincSousinTy> OrderZT_YakansyoriLincSousinTyByPkAsc(List<ZT_YakansyoriLincSousinTy> pEntity) {
        List<SortCondition<ZT_YakansyoriLincSousinTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_YakansyoriLincSousinTy()).ztyrecordsyubetukbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_YakansyoriLincSousinTy()).ztykykkanrino, SortOrder.ASC));
        List<ZT_YakansyoriLincSousinTy> copyList = new ArrayList<ZT_YakansyoriLincSousinTy>(pEntity);
        Collections.sort(copyList, new OrderZT_YakansyoriLincSousinTy(orders));
        return copyList;
    }

    
    public List<ZT_YakansyoriLincSousinTy> OrderZT_YakansyoriLincSousinTyByPkDesc(List<ZT_YakansyoriLincSousinTy> pEntity) {
        List<SortCondition<ZT_YakansyoriLincSousinTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_YakansyoriLincSousinTy()).ztyrecordsyubetukbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_YakansyoriLincSousinTy()).ztykykkanrino, SortOrder.DESC));
        List<ZT_YakansyoriLincSousinTy> copyList = new ArrayList<ZT_YakansyoriLincSousinTy>(pEntity);
        Collections.sort(copyList, new OrderZT_YakansyoriLincSousinTy(orders));
        return copyList;
    }
}
