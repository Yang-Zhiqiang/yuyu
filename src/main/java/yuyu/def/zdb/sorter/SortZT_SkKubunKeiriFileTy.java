package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_SkKubunKeiriFileTy;
import yuyu.def.db.meta.QZT_SkKubunKeiriFileTy;
import yuyu.def.zdb.comparator.OrderZT_SkKubunKeiriFileTy;

public class SortZT_SkKubunKeiriFileTy {

    
    public List<ZT_SkKubunKeiriFileTy> OrderZT_SkKubunKeiriFileTyByPkAsc(List<ZT_SkKubunKeiriFileTy> pEntity) {
        List<SortCondition<ZT_SkKubunKeiriFileTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_SkKubunKeiriFileTy()).ztytorihikiymd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_SkKubunKeiriFileTy()).ztytorihikinon7, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_SkKubunKeiriFileTy()).ztytaisyakukbnn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_SkKubunKeiriFileTy()).ztykanjyoukamokucdn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_SkKubunKeiriFileTy()).ztysuitoubumoncd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_SkKubunKeiriFileTy()).ztykizokusegment, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_SkKubunKeiriFileTy()).ztyaitesegment, SortOrder.ASC));
        List<ZT_SkKubunKeiriFileTy> copyList = new ArrayList<ZT_SkKubunKeiriFileTy>(pEntity);
        Collections.sort(copyList, new OrderZT_SkKubunKeiriFileTy(orders));
        return copyList;
    }

    
    public List<ZT_SkKubunKeiriFileTy> OrderZT_SkKubunKeiriFileTyByPkDesc(List<ZT_SkKubunKeiriFileTy> pEntity) {
        List<SortCondition<ZT_SkKubunKeiriFileTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_SkKubunKeiriFileTy()).ztytorihikiymd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_SkKubunKeiriFileTy()).ztytorihikinon7, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_SkKubunKeiriFileTy()).ztytaisyakukbnn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_SkKubunKeiriFileTy()).ztykanjyoukamokucdn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_SkKubunKeiriFileTy()).ztysuitoubumoncd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_SkKubunKeiriFileTy()).ztykizokusegment, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_SkKubunKeiriFileTy()).ztyaitesegment, SortOrder.DESC));
        List<ZT_SkKubunKeiriFileTy> copyList = new ArrayList<ZT_SkKubunKeiriFileTy>(pEntity);
        Collections.sort(copyList, new OrderZT_SkKubunKeiriFileTy(orders));
        return copyList;
    }
}
