package yuyu.def.sinkeiyaku.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.HT_MosKihon;
import yuyu.def.db.meta.QHT_MosKihon;
import yuyu.def.sinkeiyaku.comparator.OrderHT_MosKihon;

public class SortHT_MosKihon {

    
    public List<HT_MosKihon> OrderHT_MosKihonByPkAsc(List<HT_MosKihon> pEntity) {
        List<SortCondition<HT_MosKihon>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QHT_MosKihon()).mosno, SortOrder.ASC));
        List<HT_MosKihon> copyList = new ArrayList<HT_MosKihon>(pEntity);
        Collections.sort(copyList, new OrderHT_MosKihon(orders));
        return copyList;
    }

    
    public List<HT_MosKihon> OrderHT_MosKihonByPkDesc(List<HT_MosKihon> pEntity) {
        List<SortCondition<HT_MosKihon>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QHT_MosKihon()).mosno, SortOrder.DESC));
        List<HT_MosKihon> copyList = new ArrayList<HT_MosKihon>(pEntity);
        Collections.sort(copyList, new OrderHT_MosKihon(orders));
        return copyList;
    }

}

