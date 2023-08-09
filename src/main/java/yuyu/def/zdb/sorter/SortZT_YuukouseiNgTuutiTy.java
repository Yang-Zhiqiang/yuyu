package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_YuukouseiNgTuutiTy;
import yuyu.def.db.meta.QZT_YuukouseiNgTuutiTy;
import yuyu.def.zdb.comparator.OrderZT_YuukouseiNgTuutiTy;

public class SortZT_YuukouseiNgTuutiTy {

    
    public List<ZT_YuukouseiNgTuutiTy> OrderZT_YuukouseiNgTuutiTyByPkAsc(List<ZT_YuukouseiNgTuutiTy> pEntity) {
        List<SortCondition<ZT_YuukouseiNgTuutiTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_YuukouseiNgTuutiTy()).ztytyouhyouymd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_YuukouseiNgTuutiTy()).ztysyono, SortOrder.ASC));
        List<ZT_YuukouseiNgTuutiTy> copyList = new ArrayList<ZT_YuukouseiNgTuutiTy>(pEntity);
        Collections.sort(copyList, new OrderZT_YuukouseiNgTuutiTy(orders));
        return copyList;
    }

    
    public List<ZT_YuukouseiNgTuutiTy> OrderZT_YuukouseiNgTuutiTyByPkDesc(List<ZT_YuukouseiNgTuutiTy> pEntity) {
        List<SortCondition<ZT_YuukouseiNgTuutiTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_YuukouseiNgTuutiTy()).ztytyouhyouymd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_YuukouseiNgTuutiTy()).ztysyono, SortOrder.DESC));
        List<ZT_YuukouseiNgTuutiTy> copyList = new ArrayList<ZT_YuukouseiNgTuutiTy>(pEntity);
        Collections.sort(copyList, new OrderZT_YuukouseiNgTuutiTy(orders));
        return copyList;
    }
}
