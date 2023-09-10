package yuyu.def.sinkeiyaku.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.HT_BAK_SyoriCTL;
import yuyu.def.db.meta.QHT_BAK_SyoriCTL;
import yuyu.def.sinkeiyaku.comparator.OrderHT_BAK_SyoriCTL;

public class SortHT_BAK_SyoriCTL {

    
    public List<HT_BAK_SyoriCTL> OrderHT_BAK_SyoriCTLByPkAsc(List<HT_BAK_SyoriCTL> pEntity) {
        List<SortCondition<HT_BAK_SyoriCTL>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QHT_BAK_SyoriCTL()).mosno, SortOrder.ASC));
        orders.add(new SortCondition<>((new QHT_BAK_SyoriCTL()).trkssikibetukey, SortOrder.ASC));
        List<HT_BAK_SyoriCTL> copyList = new ArrayList<HT_BAK_SyoriCTL>(pEntity);
        Collections.sort(copyList, new OrderHT_BAK_SyoriCTL(orders));
        return copyList;
    }

    
    public List<HT_BAK_SyoriCTL> OrderHT_BAK_SyoriCTLByPkDesc(List<HT_BAK_SyoriCTL> pEntity) {
        List<SortCondition<HT_BAK_SyoriCTL>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QHT_BAK_SyoriCTL()).mosno, SortOrder.DESC));
        orders.add(new SortCondition<>((new QHT_BAK_SyoriCTL()).trkssikibetukey, SortOrder.DESC));
        List<HT_BAK_SyoriCTL> copyList = new ArrayList<HT_BAK_SyoriCTL>(pEntity);
        Collections.sort(copyList, new OrderHT_BAK_SyoriCTL(orders));
        return copyList;
    }

}

