package yuyu.def.sinkeiyaku.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.HM_Honkouza;
import yuyu.def.db.meta.QHM_Honkouza;
import yuyu.def.sinkeiyaku.comparator.OrderHM_Honkouza;

public class SortHM_Honkouza {

    
    public List<HM_Honkouza> OrderHM_HonkouzaByPkAsc(List<HM_Honkouza> pEntity) {
        List<SortCondition<HM_Honkouza>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QHM_Honkouza()).honkouzacd, SortOrder.ASC));
        List<HM_Honkouza> copyList = new ArrayList<HM_Honkouza>(pEntity);
        Collections.sort(copyList, new OrderHM_Honkouza(orders));
        return copyList;
    }

    
    public List<HM_Honkouza> OrderHM_HonkouzaByPkDesc(List<HM_Honkouza> pEntity) {
        List<SortCondition<HM_Honkouza>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QHM_Honkouza()).honkouzacd, SortOrder.DESC));
        List<HM_Honkouza> copyList = new ArrayList<HM_Honkouza>(pEntity);
        Collections.sort(copyList, new OrderHM_Honkouza(orders));
        return copyList;
    }
}
