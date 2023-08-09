package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_SkKaikeiTorihikiFileTy;
import yuyu.def.db.meta.QZT_SkKaikeiTorihikiFileTy;
import yuyu.def.zdb.comparator.OrderZT_SkKaikeiTorihikiFileTy;

public class SortZT_SkKaikeiTorihikiFileTy {

    
    public List<ZT_SkKaikeiTorihikiFileTy> OrderZT_SkKaikeiTorihikiFileTyByPkAsc(List<ZT_SkKaikeiTorihikiFileTy> pEntity) {
        List<SortCondition<ZT_SkKaikeiTorihikiFileTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_SkKaikeiTorihikiFileTy()).ztytorihikiymd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_SkKaikeiTorihikiFileTy()).ztytorihikinon7, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_SkKaikeiTorihikiFileTy()).ztytaisyakukbnn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_SkKaikeiTorihikiFileTy()).ztykanjyoukamokucdn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_SkKaikeiTorihikiFileTy()).ztysuitoubumon, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_SkKaikeiTorihikiFileTy()).ztytekiyoucd, SortOrder.ASC));
        List<ZT_SkKaikeiTorihikiFileTy> copyList = new ArrayList<ZT_SkKaikeiTorihikiFileTy>(pEntity);
        Collections.sort(copyList, new OrderZT_SkKaikeiTorihikiFileTy(orders));
        return copyList;
    }

    
    public List<ZT_SkKaikeiTorihikiFileTy> OrderZT_SkKaikeiTorihikiFileTyByPkDesc(List<ZT_SkKaikeiTorihikiFileTy> pEntity) {
        List<SortCondition<ZT_SkKaikeiTorihikiFileTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_SkKaikeiTorihikiFileTy()).ztytorihikiymd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_SkKaikeiTorihikiFileTy()).ztytorihikinon7, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_SkKaikeiTorihikiFileTy()).ztytaisyakukbnn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_SkKaikeiTorihikiFileTy()).ztykanjyoukamokucdn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_SkKaikeiTorihikiFileTy()).ztysuitoubumon, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_SkKaikeiTorihikiFileTy()).ztytekiyoucd, SortOrder.DESC));
        List<ZT_SkKaikeiTorihikiFileTy> copyList = new ArrayList<ZT_SkKaikeiTorihikiFileTy>(pEntity);
        Collections.sort(copyList, new OrderZT_SkKaikeiTorihikiFileTy(orders));
        return copyList;
    }
}
