package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_HrhnTtdkKanTy;
import yuyu.def.db.meta.QZT_HrhnTtdkKanTy;
import yuyu.def.zdb.comparator.OrderZT_HrhnTtdkKanTy;

public class SortZT_HrhnTtdkKanTy {

    
    public List<ZT_HrhnTtdkKanTy> OrderZT_HrhnTtdkKanTyByPkAsc(List<ZT_HrhnTtdkKanTy> pEntity) {
        List<SortCondition<ZT_HrhnTtdkKanTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_HrhnTtdkKanTy()).ztytyouhyouymd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_HrhnTtdkKanTy()).ztysyono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_HrhnTtdkKanTy()).ztysikibetuno, SortOrder.ASC));
        List<ZT_HrhnTtdkKanTy> copyList = new ArrayList<ZT_HrhnTtdkKanTy>(pEntity);
        Collections.sort(copyList, new OrderZT_HrhnTtdkKanTy(orders));
        return copyList;
    }

    
    public List<ZT_HrhnTtdkKanTy> OrderZT_HrhnTtdkKanTyByPkDesc(List<ZT_HrhnTtdkKanTy> pEntity) {
        List<SortCondition<ZT_HrhnTtdkKanTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_HrhnTtdkKanTy()).ztytyouhyouymd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_HrhnTtdkKanTy()).ztysyono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_HrhnTtdkKanTy()).ztysikibetuno, SortOrder.DESC));
        List<ZT_HrhnTtdkKanTy> copyList = new ArrayList<ZT_HrhnTtdkKanTy>(pEntity);
        Collections.sort(copyList, new OrderZT_HrhnTtdkKanTy(orders));
        return copyList;
    }
}
