package yuyu.def.sinkeiyaku.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.HT_BosKihon;
import yuyu.def.db.meta.QHT_BosKihon;
import yuyu.def.sinkeiyaku.comparator.OrderHT_BosKihon;

public class SortHT_BosKihon {

    
    public List<HT_BosKihon> OrderHT_BosKihonByPkAsc(List<HT_BosKihon> pEntity) {
        List<SortCondition<HT_BosKihon>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QHT_BosKihon()).mosno, SortOrder.ASC));
        List<HT_BosKihon> copyList = new ArrayList<HT_BosKihon>(pEntity);
        Collections.sort(copyList, new OrderHT_BosKihon(orders));
        return copyList;
    }

    
    public List<HT_BosKihon> OrderHT_BosKihonByPkDesc(List<HT_BosKihon> pEntity) {
        List<SortCondition<HT_BosKihon>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QHT_BosKihon()).mosno, SortOrder.DESC));
        List<HT_BosKihon> copyList = new ArrayList<HT_BosKihon>(pEntity);
        Collections.sort(copyList, new OrderHT_BosKihon(orders));
        return copyList;
    }

}

