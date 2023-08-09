package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_SbRituRendouTy;
import yuyu.def.db.meta.QZT_SbRituRendouTy;
import yuyu.def.zdb.comparator.OrderZT_SbRituRendouTy;

public class SortZT_SbRituRendouTy {

    
    public List<ZT_SbRituRendouTy> OrderZT_SbRituRendouTyByPkAsc(List<ZT_SbRituRendouTy> pEntity) {
        List<SortCondition<ZT_SbRituRendouTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_SbRituRendouTy()).ztydatakanrino, SortOrder.ASC));
        List<ZT_SbRituRendouTy> copyList = new ArrayList<ZT_SbRituRendouTy>(pEntity);
        Collections.sort(copyList, new OrderZT_SbRituRendouTy(orders));
        return copyList;
    }

    
    public List<ZT_SbRituRendouTy> OrderZT_SbRituRendouTyByPkDesc(List<ZT_SbRituRendouTy> pEntity) {
        List<SortCondition<ZT_SbRituRendouTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_SbRituRendouTy()).ztydatakanrino, SortOrder.DESC));
        List<ZT_SbRituRendouTy> copyList = new ArrayList<ZT_SbRituRendouTy>(pEntity);
        Collections.sort(copyList, new OrderZT_SbRituRendouTy(orders));
        return copyList;
    }
}
