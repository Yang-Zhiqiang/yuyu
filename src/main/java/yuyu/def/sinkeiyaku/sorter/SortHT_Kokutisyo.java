package yuyu.def.sinkeiyaku.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.HT_Kokutisyo;
import yuyu.def.db.meta.QHT_Kokutisyo;
import yuyu.def.sinkeiyaku.comparator.OrderHT_Kokutisyo;

public class SortHT_Kokutisyo {

    
    public List<HT_Kokutisyo> OrderHT_KokutisyoByPkAsc(List<HT_Kokutisyo> pEntity) {
        List<SortCondition<HT_Kokutisyo>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QHT_Kokutisyo()).mosno, SortOrder.ASC));
        List<HT_Kokutisyo> copyList = new ArrayList<HT_Kokutisyo>(pEntity);
        Collections.sort(copyList, new OrderHT_Kokutisyo(orders));
        return copyList;
    }

    
    public List<HT_Kokutisyo> OrderHT_KokutisyoByPkDesc(List<HT_Kokutisyo> pEntity) {
        List<SortCondition<HT_Kokutisyo>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QHT_Kokutisyo()).mosno, SortOrder.DESC));
        List<HT_Kokutisyo> copyList = new ArrayList<HT_Kokutisyo>(pEntity);
        Collections.sort(copyList, new OrderHT_Kokutisyo(orders));
        return copyList;
    }

}

