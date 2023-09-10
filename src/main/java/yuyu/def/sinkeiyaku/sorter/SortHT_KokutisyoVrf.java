package yuyu.def.sinkeiyaku.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.HT_KokutisyoVrf;
import yuyu.def.db.meta.QHT_KokutisyoVrf;
import yuyu.def.sinkeiyaku.comparator.OrderHT_KokutisyoVrf;

public class SortHT_KokutisyoVrf {

    
    public List<HT_KokutisyoVrf> OrderHT_KokutisyoVrfByPkAsc(List<HT_KokutisyoVrf> pEntity) {
        List<SortCondition<HT_KokutisyoVrf>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QHT_KokutisyoVrf()).mosno, SortOrder.ASC));
        List<HT_KokutisyoVrf> copyList = new ArrayList<HT_KokutisyoVrf>(pEntity);
        Collections.sort(copyList, new OrderHT_KokutisyoVrf(orders));
        return copyList;
    }

    
    public List<HT_KokutisyoVrf> OrderHT_KokutisyoVrfByPkDesc(List<HT_KokutisyoVrf> pEntity) {
        List<SortCondition<HT_KokutisyoVrf>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QHT_KokutisyoVrf()).mosno, SortOrder.DESC));
        List<HT_KokutisyoVrf> copyList = new ArrayList<HT_KokutisyoVrf>(pEntity);
        Collections.sort(copyList, new OrderHT_KokutisyoVrf(orders));
        return copyList;
    }

}

