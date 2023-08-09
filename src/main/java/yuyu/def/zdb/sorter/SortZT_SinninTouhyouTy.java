package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_SinninTouhyouTy;
import yuyu.def.db.meta.QZT_SinninTouhyouTy;
import yuyu.def.zdb.comparator.OrderZT_SinninTouhyouTy;

public class SortZT_SinninTouhyouTy {

    
    public List<ZT_SinninTouhyouTy> OrderZT_SinninTouhyouTyByPkAsc(List<ZT_SinninTouhyouTy> pEntity) {
        List<SortCondition<ZT_SinninTouhyouTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_SinninTouhyouTy()).ztysyono, SortOrder.ASC));
        List<ZT_SinninTouhyouTy> copyList = new ArrayList<ZT_SinninTouhyouTy>(pEntity);
        Collections.sort(copyList, new OrderZT_SinninTouhyouTy(orders));
        return copyList;
    }

    
    public List<ZT_SinninTouhyouTy> OrderZT_SinninTouhyouTyByPkDesc(List<ZT_SinninTouhyouTy> pEntity) {
        List<SortCondition<ZT_SinninTouhyouTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_SinninTouhyouTy()).ztysyono, SortOrder.DESC));
        List<ZT_SinninTouhyouTy> copyList = new ArrayList<ZT_SinninTouhyouTy>(pEntity);
        Collections.sort(copyList, new OrderZT_SinninTouhyouTy(orders));
        return copyList;
    }
}
