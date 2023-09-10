package yuyu.def.sinkeiyaku.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.HM_KetteiSya;
import yuyu.def.db.meta.QHM_KetteiSya;
import yuyu.def.sinkeiyaku.comparator.OrderHM_KetteiSya;

public class SortHM_KetteiSya {

    
    public List<HM_KetteiSya> OrderHM_KetteiSyaByPkAsc(List<HM_KetteiSya> pEntity) {
        List<SortCondition<HM_KetteiSya>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QHM_KetteiSya()).ketsyacd, SortOrder.ASC));
        List<HM_KetteiSya> copyList = new ArrayList<HM_KetteiSya>(pEntity);
        Collections.sort(copyList, new OrderHM_KetteiSya(orders));
        return copyList;
    }

    
    public List<HM_KetteiSya> OrderHM_KetteiSyaByPkDesc(List<HM_KetteiSya> pEntity) {
        List<SortCondition<HM_KetteiSya>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QHM_KetteiSya()).ketsyacd, SortOrder.DESC));
        List<HM_KetteiSya> copyList = new ArrayList<HM_KetteiSya>(pEntity);
        Collections.sort(copyList, new OrderHM_KetteiSya(orders));
        return copyList;
    }

}

