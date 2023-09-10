package yuyu.def.sinkeiyaku.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.db.meta.QHT_SyoriCTL;
import yuyu.def.sinkeiyaku.comparator.OrderHT_SyoriCTL;

public class SortHT_SyoriCTL {

    
    public List<HT_SyoriCTL> OrderHT_SyoriCTLByPkAsc(List<HT_SyoriCTL> pEntity) {
        List<SortCondition<HT_SyoriCTL>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QHT_SyoriCTL()).mosno, SortOrder.ASC));
        List<HT_SyoriCTL> copyList = new ArrayList<HT_SyoriCTL>(pEntity);
        Collections.sort(copyList, new OrderHT_SyoriCTL(orders));
        return copyList;
    }

    
    public List<HT_SyoriCTL> OrderHT_SyoriCTLByPkDesc(List<HT_SyoriCTL> pEntity) {
        List<SortCondition<HT_SyoriCTL>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QHT_SyoriCTL()).mosno, SortOrder.DESC));
        List<HT_SyoriCTL> copyList = new ArrayList<HT_SyoriCTL>(pEntity);
        Collections.sort(copyList, new OrderHT_SyoriCTL(orders));
        return copyList;
    }

}

