package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_KzhuriAnnaiUlfTy;
import yuyu.def.db.meta.QZT_KzhuriAnnaiUlfTy;
import yuyu.def.zdb.comparator.OrderZT_KzhuriAnnaiUlfTy;

public class SortZT_KzhuriAnnaiUlfTy {

    
    public List<ZT_KzhuriAnnaiUlfTy> OrderZT_KzhuriAnnaiUlfTyByPkAsc(List<ZT_KzhuriAnnaiUlfTy> pEntity) {
        List<SortCondition<ZT_KzhuriAnnaiUlfTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_KzhuriAnnaiUlfTy()).ztysyono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_KzhuriAnnaiUlfTy()).ztyjyuutouym, SortOrder.ASC));
        List<ZT_KzhuriAnnaiUlfTy> copyList = new ArrayList<ZT_KzhuriAnnaiUlfTy>(pEntity);
        Collections.sort(copyList, new OrderZT_KzhuriAnnaiUlfTy(orders));
        return copyList;
    }

    
    public List<ZT_KzhuriAnnaiUlfTy> OrderZT_KzhuriAnnaiUlfTyByPkDesc(List<ZT_KzhuriAnnaiUlfTy> pEntity) {
        List<SortCondition<ZT_KzhuriAnnaiUlfTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_KzhuriAnnaiUlfTy()).ztysyono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_KzhuriAnnaiUlfTy()).ztyjyuutouym, SortOrder.DESC));
        List<ZT_KzhuriAnnaiUlfTy> copyList = new ArrayList<ZT_KzhuriAnnaiUlfTy>(pEntity);
        Collections.sort(copyList, new OrderZT_KzhuriAnnaiUlfTy(orders));
        return copyList;
    }
}
