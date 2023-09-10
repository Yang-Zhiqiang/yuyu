package yuyu.def.sinkeiyaku.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.HT_NrkDif;
import yuyu.def.db.meta.QHT_NrkDif;
import yuyu.def.sinkeiyaku.comparator.OrderHT_NrkDif;

public class SortHT_NrkDif {

    
    public List<HT_NrkDif> OrderHT_NrkDifByPkAsc(List<HT_NrkDif> pEntity) {
        List<SortCondition<HT_NrkDif>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QHT_NrkDif()).mosno, SortOrder.ASC));
        orders.add(new SortCondition<>((new QHT_NrkDif()).vrfkinouid, SortOrder.ASC));
        orders.add(new SortCondition<>((new QHT_NrkDif()).renno3keta, SortOrder.ASC));
        List<HT_NrkDif> copyList = new ArrayList<HT_NrkDif>(pEntity);
        Collections.sort(copyList, new OrderHT_NrkDif(orders));
        return copyList;
    }

    
    public List<HT_NrkDif> OrderHT_NrkDifByPkDesc(List<HT_NrkDif> pEntity) {
        List<SortCondition<HT_NrkDif>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QHT_NrkDif()).mosno, SortOrder.DESC));
        orders.add(new SortCondition<>((new QHT_NrkDif()).vrfkinouid, SortOrder.DESC));
        orders.add(new SortCondition<>((new QHT_NrkDif()).renno3keta, SortOrder.DESC));
        List<HT_NrkDif> copyList = new ArrayList<HT_NrkDif>(pEntity);
        Collections.sort(copyList, new OrderHT_NrkDif(orders));
        return copyList;
    }

}

