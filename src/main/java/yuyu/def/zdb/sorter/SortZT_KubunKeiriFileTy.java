package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_KubunKeiriFileTy;
import yuyu.def.db.meta.QZT_KubunKeiriFileTy;
import yuyu.def.zdb.comparator.OrderZT_KubunKeiriFileTy;

public class SortZT_KubunKeiriFileTy {

    
    public List<ZT_KubunKeiriFileTy> OrderZT_KubunKeiriFileTyByPkAsc(List<ZT_KubunKeiriFileTy> pEntity) {
        List<SortCondition<ZT_KubunKeiriFileTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_KubunKeiriFileTy()).ztytorihikiymd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_KubunKeiriFileTy()).ztytorihikinon7, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_KubunKeiriFileTy()).ztytaisyakukbnn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_KubunKeiriFileTy()).ztykanjyoukamokucdn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_KubunKeiriFileTy()).ztysuitoubumoncd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_KubunKeiriFileTy()).ztykizokusegment, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_KubunKeiriFileTy()).ztyaitesegment, SortOrder.ASC));
        List<ZT_KubunKeiriFileTy> copyList = new ArrayList<ZT_KubunKeiriFileTy>(pEntity);
        Collections.sort(copyList, new OrderZT_KubunKeiriFileTy(orders));
        return copyList;
    }

    
    public List<ZT_KubunKeiriFileTy> OrderZT_KubunKeiriFileTyByPkDesc(List<ZT_KubunKeiriFileTy> pEntity) {
        List<SortCondition<ZT_KubunKeiriFileTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_KubunKeiriFileTy()).ztytorihikiymd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_KubunKeiriFileTy()).ztytorihikinon7, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_KubunKeiriFileTy()).ztytaisyakukbnn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_KubunKeiriFileTy()).ztykanjyoukamokucdn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_KubunKeiriFileTy()).ztysuitoubumoncd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_KubunKeiriFileTy()).ztykizokusegment, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_KubunKeiriFileTy()).ztyaitesegment, SortOrder.DESC));
        List<ZT_KubunKeiriFileTy> copyList = new ArrayList<ZT_KubunKeiriFileTy>(pEntity);
        Collections.sort(copyList, new OrderZT_KubunKeiriFileTy(orders));
        return copyList;
    }
}
