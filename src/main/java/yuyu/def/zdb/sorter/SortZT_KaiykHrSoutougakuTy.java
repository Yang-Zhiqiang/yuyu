package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_KaiykHrSoutougakuTy;
import yuyu.def.db.meta.QZT_KaiykHrSoutougakuTy;
import yuyu.def.zdb.comparator.OrderZT_KaiykHrSoutougakuTy;

public class SortZT_KaiykHrSoutougakuTy {

    
    public List<ZT_KaiykHrSoutougakuTy> OrderZT_KaiykHrSoutougakuTyByPkAsc(List<ZT_KaiykHrSoutougakuTy> pEntity) {
        List<SortCondition<ZT_KaiykHrSoutougakuTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_KaiykHrSoutougakuTy()).ztysequenceno, SortOrder.ASC));
        List<ZT_KaiykHrSoutougakuTy> copyList = new ArrayList<ZT_KaiykHrSoutougakuTy>(pEntity);
        Collections.sort(copyList, new OrderZT_KaiykHrSoutougakuTy(orders));
        return copyList;
    }

    
    public List<ZT_KaiykHrSoutougakuTy> OrderZT_KaiykHrSoutougakuTyByPkDesc(List<ZT_KaiykHrSoutougakuTy> pEntity) {
        List<SortCondition<ZT_KaiykHrSoutougakuTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_KaiykHrSoutougakuTy()).ztysequenceno, SortOrder.DESC));
        List<ZT_KaiykHrSoutougakuTy> copyList = new ArrayList<ZT_KaiykHrSoutougakuTy>(pEntity);
        Collections.sort(copyList, new OrderZT_KaiykHrSoutougakuTy(orders));
        return copyList;
    }
}
