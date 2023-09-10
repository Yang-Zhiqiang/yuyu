package yuyu.def.sinkeiyaku.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.HT_KnksateiRireki;
import yuyu.def.db.meta.QHT_KnksateiRireki;
import yuyu.def.sinkeiyaku.comparator.OrderHT_KnksateiRireki;

public class SortHT_KnksateiRireki {

    
    public List<HT_KnksateiRireki> OrderHT_KnksateiRirekiByPkAsc(List<HT_KnksateiRireki> pEntity) {
        List<SortCondition<HT_KnksateiRireki>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QHT_KnksateiRireki()).mosno, SortOrder.ASC));
        orders.add(new SortCondition<>((new QHT_KnksateiRireki()).renno, SortOrder.ASC));
        List<HT_KnksateiRireki> copyList = new ArrayList<HT_KnksateiRireki>(pEntity);
        Collections.sort(copyList, new OrderHT_KnksateiRireki(orders));
        return copyList;
    }

    
    public List<HT_KnksateiRireki> OrderHT_KnksateiRirekiByPkDesc(List<HT_KnksateiRireki> pEntity) {
        List<SortCondition<HT_KnksateiRireki>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QHT_KnksateiRireki()).mosno, SortOrder.DESC));
        orders.add(new SortCondition<>((new QHT_KnksateiRireki()).renno, SortOrder.DESC));
        List<HT_KnksateiRireki> copyList = new ArrayList<HT_KnksateiRireki>(pEntity);
        Collections.sort(copyList, new OrderHT_KnksateiRireki(orders));
        return copyList;
    }

}

