package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_SkKsnKubunKeiriTy;
import yuyu.def.db.meta.QZT_SkKsnKubunKeiriTy;
import yuyu.def.zdb.comparator.OrderZT_SkKsnKubunKeiriTy;

public class SortZT_SkKsnKubunKeiriTy {

    
    public List<ZT_SkKsnKubunKeiriTy> OrderZT_SkKsnKubunKeiriTyByPkAsc(List<ZT_SkKsnKubunKeiriTy> pEntity) {
        List<SortCondition<ZT_SkKsnKubunKeiriTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_SkKsnKubunKeiriTy()).ztytorihikiymd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_SkKsnKubunKeiriTy()).ztytorihikinon7, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_SkKsnKubunKeiriTy()).ztytaisyakukbnn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_SkKsnKubunKeiriTy()).ztykanjyoukamokucdn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_SkKsnKubunKeiriTy()).ztysuitoubumoncd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_SkKsnKubunKeiriTy()).ztykizokusegment, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_SkKsnKubunKeiriTy()).ztyaitesegment, SortOrder.ASC));
        List<ZT_SkKsnKubunKeiriTy> copyList = new ArrayList<ZT_SkKsnKubunKeiriTy>(pEntity);
        Collections.sort(copyList, new OrderZT_SkKsnKubunKeiriTy(orders));
        return copyList;
    }

    
    public List<ZT_SkKsnKubunKeiriTy> OrderZT_SkKsnKubunKeiriTyByPkDesc(List<ZT_SkKsnKubunKeiriTy> pEntity) {
        List<SortCondition<ZT_SkKsnKubunKeiriTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_SkKsnKubunKeiriTy()).ztytorihikiymd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_SkKsnKubunKeiriTy()).ztytorihikinon7, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_SkKsnKubunKeiriTy()).ztytaisyakukbnn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_SkKsnKubunKeiriTy()).ztykanjyoukamokucdn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_SkKsnKubunKeiriTy()).ztysuitoubumoncd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_SkKsnKubunKeiriTy()).ztykizokusegment, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_SkKsnKubunKeiriTy()).ztyaitesegment, SortOrder.DESC));
        List<ZT_SkKsnKubunKeiriTy> copyList = new ArrayList<ZT_SkKsnKubunKeiriTy>(pEntity);
        Collections.sort(copyList, new OrderZT_SkKsnKubunKeiriTy(orders));
        return copyList;
    }
}
