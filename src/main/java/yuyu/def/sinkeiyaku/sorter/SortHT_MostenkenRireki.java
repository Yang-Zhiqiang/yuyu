package yuyu.def.sinkeiyaku.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.HT_MostenkenRireki;
import yuyu.def.db.meta.QHT_MostenkenRireki;
import yuyu.def.sinkeiyaku.comparator.OrderHT_MostenkenRireki;

public class SortHT_MostenkenRireki {

    
    public List<HT_MostenkenRireki> OrderHT_MostenkenRirekiByPkAsc(List<HT_MostenkenRireki> pEntity) {
        List<SortCondition<HT_MostenkenRireki>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QHT_MostenkenRireki()).mosno, SortOrder.ASC));
        orders.add(new SortCondition<>((new QHT_MostenkenRireki()).renno, SortOrder.ASC));
        List<HT_MostenkenRireki> copyList = new ArrayList<HT_MostenkenRireki>(pEntity);
        Collections.sort(copyList, new OrderHT_MostenkenRireki(orders));
        return copyList;
    }

    
    public List<HT_MostenkenRireki> OrderHT_MostenkenRirekiByPkDesc(List<HT_MostenkenRireki> pEntity) {
        List<SortCondition<HT_MostenkenRireki>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QHT_MostenkenRireki()).mosno, SortOrder.DESC));
        orders.add(new SortCondition<>((new QHT_MostenkenRireki()).renno, SortOrder.DESC));
        List<HT_MostenkenRireki> copyList = new ArrayList<HT_MostenkenRireki>(pEntity);
        Collections.sort(copyList, new OrderHT_MostenkenRireki(orders));
        return copyList;
    }

}

