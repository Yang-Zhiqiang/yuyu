package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_KaikeiTorihikiFileTy;
import yuyu.def.db.meta.QZT_KaikeiTorihikiFileTy;
import yuyu.def.zdb.comparator.OrderZT_KaikeiTorihikiFileTy;

public class SortZT_KaikeiTorihikiFileTy {

    
    public List<ZT_KaikeiTorihikiFileTy> OrderZT_KaikeiTorihikiFileTyByPkAsc(List<ZT_KaikeiTorihikiFileTy> pEntity) {
        List<SortCondition<ZT_KaikeiTorihikiFileTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_KaikeiTorihikiFileTy()).ztytorihikiymd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_KaikeiTorihikiFileTy()).ztytorihikinon7, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_KaikeiTorihikiFileTy()).ztytaisyakukbnn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_KaikeiTorihikiFileTy()).ztykanjyoukamokucdn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_KaikeiTorihikiFileTy()).ztysuitoubumon, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_KaikeiTorihikiFileTy()).ztytekiyoucd, SortOrder.ASC));
        List<ZT_KaikeiTorihikiFileTy> copyList = new ArrayList<ZT_KaikeiTorihikiFileTy>(pEntity);
        Collections.sort(copyList, new OrderZT_KaikeiTorihikiFileTy(orders));
        return copyList;
    }

    
    public List<ZT_KaikeiTorihikiFileTy> OrderZT_KaikeiTorihikiFileTyByPkDesc(List<ZT_KaikeiTorihikiFileTy> pEntity) {
        List<SortCondition<ZT_KaikeiTorihikiFileTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_KaikeiTorihikiFileTy()).ztytorihikiymd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_KaikeiTorihikiFileTy()).ztytorihikinon7, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_KaikeiTorihikiFileTy()).ztytaisyakukbnn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_KaikeiTorihikiFileTy()).ztykanjyoukamokucdn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_KaikeiTorihikiFileTy()).ztysuitoubumon, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_KaikeiTorihikiFileTy()).ztytekiyoucd, SortOrder.DESC));
        List<ZT_KaikeiTorihikiFileTy> copyList = new ArrayList<ZT_KaikeiTorihikiFileTy>(pEntity);
        Collections.sort(copyList, new OrderZT_KaikeiTorihikiFileTy(orders));
        return copyList;
    }
}
