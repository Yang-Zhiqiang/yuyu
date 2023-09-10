package yuyu.def.sinkeiyaku.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.HT_MosKihonVrf;
import yuyu.def.db.meta.QHT_MosKihonVrf;
import yuyu.def.sinkeiyaku.comparator.OrderHT_MosKihonVrf;

public class SortHT_MosKihonVrf {

    
    public List<HT_MosKihonVrf> OrderHT_MosKihonVrfByPkAsc(List<HT_MosKihonVrf> pEntity) {
        List<SortCondition<HT_MosKihonVrf>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QHT_MosKihonVrf()).mosno, SortOrder.ASC));
        List<HT_MosKihonVrf> copyList = new ArrayList<HT_MosKihonVrf>(pEntity);
        Collections.sort(copyList, new OrderHT_MosKihonVrf(orders));
        return copyList;
    }

    
    public List<HT_MosKihonVrf> OrderHT_MosKihonVrfByPkDesc(List<HT_MosKihonVrf> pEntity) {
        List<SortCondition<HT_MosKihonVrf>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QHT_MosKihonVrf()).mosno, SortOrder.DESC));
        List<HT_MosKihonVrf> copyList = new ArrayList<HT_MosKihonVrf>(pEntity);
        Collections.sort(copyList, new OrderHT_MosKihonVrf(orders));
        return copyList;
    }

}

