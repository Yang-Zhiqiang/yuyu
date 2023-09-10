package yuyu.def.sinkeiyaku.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.HT_MosnoKanri;
import yuyu.def.db.meta.QHT_MosnoKanri;
import yuyu.def.sinkeiyaku.comparator.OrderHT_MosnoKanri;

public class SortHT_MosnoKanri {

    
    public List<HT_MosnoKanri> OrderHT_MosnoKanriByPkAsc(List<HT_MosnoKanri> pEntity) {
        List<SortCondition<HT_MosnoKanri>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QHT_MosnoKanri()).mosno8keta, SortOrder.ASC));
        List<HT_MosnoKanri> copyList = new ArrayList<HT_MosnoKanri>(pEntity);
        Collections.sort(copyList, new OrderHT_MosnoKanri(orders));
        return copyList;
    }

    
    public List<HT_MosnoKanri> OrderHT_MosnoKanriByPkDesc(List<HT_MosnoKanri> pEntity) {
        List<SortCondition<HT_MosnoKanri>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QHT_MosnoKanri()).mosno8keta, SortOrder.DESC));
        List<HT_MosnoKanri> copyList = new ArrayList<HT_MosnoKanri>(pEntity);
        Collections.sort(copyList, new OrderHT_MosnoKanri(orders));
        return copyList;
    }

}

