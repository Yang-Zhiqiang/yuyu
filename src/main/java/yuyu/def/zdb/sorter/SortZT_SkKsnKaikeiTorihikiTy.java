package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_SkKsnKaikeiTorihikiTy;
import yuyu.def.db.meta.QZT_SkKsnKaikeiTorihikiTy;
import yuyu.def.zdb.comparator.OrderZT_SkKsnKaikeiTorihikiTy;

public class SortZT_SkKsnKaikeiTorihikiTy {

    
    public List<ZT_SkKsnKaikeiTorihikiTy> OrderZT_SkKsnKaikeiTorihikiTyByPkAsc(List<ZT_SkKsnKaikeiTorihikiTy> pEntity) {
        List<SortCondition<ZT_SkKsnKaikeiTorihikiTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_SkKsnKaikeiTorihikiTy()).ztytorihikiymd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_SkKsnKaikeiTorihikiTy()).ztytorihikinon7, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_SkKsnKaikeiTorihikiTy()).ztytaisyakukbnn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_SkKsnKaikeiTorihikiTy()).ztykanjyoukamokucdn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_SkKsnKaikeiTorihikiTy()).ztysuitoubumon, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_SkKsnKaikeiTorihikiTy()).ztytekiyoucd, SortOrder.ASC));
        List<ZT_SkKsnKaikeiTorihikiTy> copyList = new ArrayList<ZT_SkKsnKaikeiTorihikiTy>(pEntity);
        Collections.sort(copyList, new OrderZT_SkKsnKaikeiTorihikiTy(orders));
        return copyList;
    }

    
    public List<ZT_SkKsnKaikeiTorihikiTy> OrderZT_SkKsnKaikeiTorihikiTyByPkDesc(List<ZT_SkKsnKaikeiTorihikiTy> pEntity) {
        List<SortCondition<ZT_SkKsnKaikeiTorihikiTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_SkKsnKaikeiTorihikiTy()).ztytorihikiymd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_SkKsnKaikeiTorihikiTy()).ztytorihikinon7, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_SkKsnKaikeiTorihikiTy()).ztytaisyakukbnn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_SkKsnKaikeiTorihikiTy()).ztykanjyoukamokucdn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_SkKsnKaikeiTorihikiTy()).ztysuitoubumon, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_SkKsnKaikeiTorihikiTy()).ztytekiyoucd, SortOrder.DESC));
        List<ZT_SkKsnKaikeiTorihikiTy> copyList = new ArrayList<ZT_SkKsnKaikeiTorihikiTy>(pEntity);
        Collections.sort(copyList, new OrderZT_SkKsnKaikeiTorihikiTy(orders));
        return copyList;
    }
}
