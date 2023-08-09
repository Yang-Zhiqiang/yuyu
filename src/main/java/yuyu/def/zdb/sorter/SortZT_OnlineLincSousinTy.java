package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_OnlineLincSousinTy;
import yuyu.def.db.meta.QZT_OnlineLincSousinTy;
import yuyu.def.zdb.comparator.OrderZT_OnlineLincSousinTy;

public class SortZT_OnlineLincSousinTy {

    
    public List<ZT_OnlineLincSousinTy> OrderZT_OnlineLincSousinTyByPkAsc(List<ZT_OnlineLincSousinTy> pEntity) {
        List<SortCondition<ZT_OnlineLincSousinTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_OnlineLincSousinTy()).ztyrecordsyubetukbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_OnlineLincSousinTy()).ztykykkanrino, SortOrder.ASC));
        List<ZT_OnlineLincSousinTy> copyList = new ArrayList<ZT_OnlineLincSousinTy>(pEntity);
        Collections.sort(copyList, new OrderZT_OnlineLincSousinTy(orders));
        return copyList;
    }

    
    public List<ZT_OnlineLincSousinTy> OrderZT_OnlineLincSousinTyByPkDesc(List<ZT_OnlineLincSousinTy> pEntity) {
        List<SortCondition<ZT_OnlineLincSousinTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_OnlineLincSousinTy()).ztyrecordsyubetukbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_OnlineLincSousinTy()).ztykykkanrino, SortOrder.DESC));
        List<ZT_OnlineLincSousinTy> copyList = new ArrayList<ZT_OnlineLincSousinTy>(pEntity);
        Collections.sort(copyList, new OrderZT_OnlineLincSousinTy(orders));
        return copyList;
    }
}
