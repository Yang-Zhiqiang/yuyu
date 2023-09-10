package yuyu.def.sinkeiyaku.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.HT_SouseirituKihon;
import yuyu.def.db.meta.QHT_SouseirituKihon;
import yuyu.def.sinkeiyaku.comparator.OrderHT_SouseirituKihon;

public class SortHT_SouseirituKihon {

    
    public List<HT_SouseirituKihon> OrderHT_SouseirituKihonByPkAsc(List<HT_SouseirituKihon> pEntity) {
        List<SortCondition<HT_SouseirituKihon>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QHT_SouseirituKihon()).syono, SortOrder.ASC));
        List<HT_SouseirituKihon> copyList = new ArrayList<HT_SouseirituKihon>(pEntity);
        Collections.sort(copyList, new OrderHT_SouseirituKihon(orders));
        return copyList;
    }

    
    public List<HT_SouseirituKihon> OrderHT_SouseirituKihonByPkDesc(List<HT_SouseirituKihon> pEntity) {
        List<SortCondition<HT_SouseirituKihon>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QHT_SouseirituKihon()).syono, SortOrder.DESC));
        List<HT_SouseirituKihon> copyList = new ArrayList<HT_SouseirituKihon>(pEntity);
        Collections.sort(copyList, new OrderHT_SouseirituKihon(orders));
        return copyList;
    }

}

