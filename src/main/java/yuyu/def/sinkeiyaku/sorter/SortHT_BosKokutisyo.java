package yuyu.def.sinkeiyaku.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.HT_BosKokutisyo;
import yuyu.def.db.meta.QHT_BosKokutisyo;
import yuyu.def.sinkeiyaku.comparator.OrderHT_BosKokutisyo;

public class SortHT_BosKokutisyo {

    
    public List<HT_BosKokutisyo> OrderHT_BosKokutisyoByPkAsc(List<HT_BosKokutisyo> pEntity) {
        List<SortCondition<HT_BosKokutisyo>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QHT_BosKokutisyo()).mosno, SortOrder.ASC));
        List<HT_BosKokutisyo> copyList = new ArrayList<HT_BosKokutisyo>(pEntity);
        Collections.sort(copyList, new OrderHT_BosKokutisyo(orders));
        return copyList;
    }

    
    public List<HT_BosKokutisyo> OrderHT_BosKokutisyoByPkDesc(List<HT_BosKokutisyo> pEntity) {
        List<SortCondition<HT_BosKokutisyo>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QHT_BosKokutisyo()).mosno, SortOrder.DESC));
        List<HT_BosKokutisyo> copyList = new ArrayList<HT_BosKokutisyo>(pEntity);
        Collections.sort(copyList, new OrderHT_BosKokutisyo(orders));
        return copyList;
    }
}
