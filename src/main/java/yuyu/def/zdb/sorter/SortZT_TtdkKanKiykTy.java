package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_TtdkKanKiykTy;
import yuyu.def.db.meta.QZT_TtdkKanKiykTy;
import yuyu.def.zdb.comparator.OrderZT_TtdkKanKiykTy;

public class SortZT_TtdkKanKiykTy {

    
    public List<ZT_TtdkKanKiykTy> OrderZT_TtdkKanKiykTyByPkAsc(List<ZT_TtdkKanKiykTy> pEntity) {
        List<SortCondition<ZT_TtdkKanKiykTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_TtdkKanKiykTy()).ztytyouhyouymd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_TtdkKanKiykTy()).ztysyono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_TtdkKanKiykTy()).ztysikibetuno, SortOrder.ASC));
        List<ZT_TtdkKanKiykTy> copyList = new ArrayList<ZT_TtdkKanKiykTy>(pEntity);
        Collections.sort(copyList, new OrderZT_TtdkKanKiykTy(orders));
        return copyList;
    }

    
    public List<ZT_TtdkKanKiykTy> OrderZT_TtdkKanKiykTyByPkDesc(List<ZT_TtdkKanKiykTy> pEntity) {
        List<SortCondition<ZT_TtdkKanKiykTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_TtdkKanKiykTy()).ztytyouhyouymd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_TtdkKanKiykTy()).ztysyono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_TtdkKanKiykTy()).ztysikibetuno, SortOrder.DESC));
        List<ZT_TtdkKanKiykTy> copyList = new ArrayList<ZT_TtdkKanKiykTy>(pEntity);
        Collections.sort(copyList, new OrderZT_TtdkKanKiykTy(orders));
        return copyList;
    }
}
