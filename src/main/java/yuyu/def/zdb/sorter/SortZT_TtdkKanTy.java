package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_TtdkKanTy;
import yuyu.def.db.meta.QZT_TtdkKanTy;
import yuyu.def.zdb.comparator.OrderZT_TtdkKanTy;

public class SortZT_TtdkKanTy {

    
    public List<ZT_TtdkKanTy> OrderZT_TtdkKanTyByPkAsc(List<ZT_TtdkKanTy> pEntity) {
        List<SortCondition<ZT_TtdkKanTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_TtdkKanTy()).ztytyouhyouymd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_TtdkKanTy()).ztysyono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_TtdkKanTy()).ztysikibetuno, SortOrder.ASC));
        List<ZT_TtdkKanTy> copyList = new ArrayList<ZT_TtdkKanTy>(pEntity);
        Collections.sort(copyList, new OrderZT_TtdkKanTy(orders));
        return copyList;
    }

    
    public List<ZT_TtdkKanTy> OrderZT_TtdkKanTyByPkDesc(List<ZT_TtdkKanTy> pEntity) {
        List<SortCondition<ZT_TtdkKanTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_TtdkKanTy()).ztytyouhyouymd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_TtdkKanTy()).ztysyono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_TtdkKanTy()).ztysikibetuno, SortOrder.DESC));
        List<ZT_TtdkKanTy> copyList = new ArrayList<ZT_TtdkKanTy>(pEntity);
        Collections.sort(copyList, new OrderZT_TtdkKanTy(orders));
        return copyList;
    }
}
