package yuyu.def.sinkeiyaku.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.HT_ImusateiRireki;
import yuyu.def.db.meta.QHT_ImusateiRireki;
import yuyu.def.sinkeiyaku.comparator.OrderHT_ImusateiRireki;

public class SortHT_ImusateiRireki {

    
    public List<HT_ImusateiRireki> OrderHT_ImusateiRirekiByPkAsc(List<HT_ImusateiRireki> pEntity) {
        List<SortCondition<HT_ImusateiRireki>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QHT_ImusateiRireki()).mosno, SortOrder.ASC));
        orders.add(new SortCondition<>((new QHT_ImusateiRireki()).renno, SortOrder.ASC));
        List<HT_ImusateiRireki> copyList = new ArrayList<HT_ImusateiRireki>(pEntity);
        Collections.sort(copyList, new OrderHT_ImusateiRireki(orders));
        return copyList;
    }

    
    public List<HT_ImusateiRireki> OrderHT_ImusateiRirekiByPkDesc(List<HT_ImusateiRireki> pEntity) {
        List<SortCondition<HT_ImusateiRireki>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QHT_ImusateiRireki()).mosno, SortOrder.DESC));
        orders.add(new SortCondition<>((new QHT_ImusateiRireki()).renno, SortOrder.DESC));
        List<HT_ImusateiRireki> copyList = new ArrayList<HT_ImusateiRireki>(pEntity);
        Collections.sort(copyList, new OrderHT_ImusateiRireki(orders));
        return copyList;
    }

}

