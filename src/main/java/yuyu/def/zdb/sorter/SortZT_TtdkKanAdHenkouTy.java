package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_TtdkKanAdHenkouTy;
import yuyu.def.db.meta.QZT_TtdkKanAdHenkouTy;
import yuyu.def.zdb.comparator.OrderZT_TtdkKanAdHenkouTy;

public class SortZT_TtdkKanAdHenkouTy {

    
    public List<ZT_TtdkKanAdHenkouTy> OrderZT_TtdkKanAdHenkouTyByPkAsc(List<ZT_TtdkKanAdHenkouTy> pEntity) {
        List<SortCondition<ZT_TtdkKanAdHenkouTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_TtdkKanAdHenkouTy()).ztytyouhyouymd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_TtdkKanAdHenkouTy()).ztysyono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_TtdkKanAdHenkouTy()).ztysikibetuno, SortOrder.ASC));
        List<ZT_TtdkKanAdHenkouTy> copyList = new ArrayList<ZT_TtdkKanAdHenkouTy>(pEntity);
        Collections.sort(copyList, new OrderZT_TtdkKanAdHenkouTy(orders));
        return copyList;
    }

    
    public List<ZT_TtdkKanAdHenkouTy> OrderZT_TtdkKanAdHenkouTyByPkDesc(List<ZT_TtdkKanAdHenkouTy> pEntity) {
        List<SortCondition<ZT_TtdkKanAdHenkouTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_TtdkKanAdHenkouTy()).ztytyouhyouymd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_TtdkKanAdHenkouTy()).ztysyono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_TtdkKanAdHenkouTy()).ztysikibetuno, SortOrder.DESC));
        List<ZT_TtdkKanAdHenkouTy> copyList = new ArrayList<ZT_TtdkKanAdHenkouTy>(pEntity);
        Collections.sort(copyList, new OrderZT_TtdkKanAdHenkouTy(orders));
        return copyList;
    }
}
