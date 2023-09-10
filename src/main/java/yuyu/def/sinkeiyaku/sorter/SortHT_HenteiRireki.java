package yuyu.def.sinkeiyaku.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.HT_HenteiRireki;
import yuyu.def.db.meta.QHT_HenteiRireki;
import yuyu.def.sinkeiyaku.comparator.OrderHT_HenteiRireki;

public class SortHT_HenteiRireki {

    
    public List<HT_HenteiRireki> OrderHT_HenteiRirekiByPkAsc(List<HT_HenteiRireki> pEntity) {
        List<SortCondition<HT_HenteiRireki>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QHT_HenteiRireki()).mosno, SortOrder.ASC));
        orders.add(new SortCondition<>((new QHT_HenteiRireki()).renno, SortOrder.ASC));
        List<HT_HenteiRireki> copyList = new ArrayList<HT_HenteiRireki>(pEntity);
        Collections.sort(copyList, new OrderHT_HenteiRireki(orders));
        return copyList;
    }

    
    public List<HT_HenteiRireki> OrderHT_HenteiRirekiByPkDesc(List<HT_HenteiRireki> pEntity) {
        List<SortCondition<HT_HenteiRireki>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QHT_HenteiRireki()).mosno, SortOrder.DESC));
        orders.add(new SortCondition<>((new QHT_HenteiRireki()).renno, SortOrder.DESC));
        List<HT_HenteiRireki> copyList = new ArrayList<HT_HenteiRireki>(pEntity);
        Collections.sort(copyList, new OrderHT_HenteiRireki(orders));
        return copyList;
    }

}

