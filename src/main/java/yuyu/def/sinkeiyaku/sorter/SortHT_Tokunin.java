package yuyu.def.sinkeiyaku.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.HT_Tokunin;
import yuyu.def.db.meta.QHT_Tokunin;
import yuyu.def.sinkeiyaku.comparator.OrderHT_Tokunin;

public class SortHT_Tokunin {

    
    public List<HT_Tokunin> OrderHT_TokuninByPkAsc(List<HT_Tokunin> pEntity) {
        List<SortCondition<HT_Tokunin>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QHT_Tokunin()).mosno, SortOrder.ASC));
        List<HT_Tokunin> copyList = new ArrayList<HT_Tokunin>(pEntity);
        Collections.sort(copyList, new OrderHT_Tokunin(orders));
        return copyList;
    }

    
    public List<HT_Tokunin> OrderHT_TokuninByPkDesc(List<HT_Tokunin> pEntity) {
        List<SortCondition<HT_Tokunin>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QHT_Tokunin()).mosno, SortOrder.DESC));
        List<HT_Tokunin> copyList = new ArrayList<HT_Tokunin>(pEntity);
        Collections.sort(copyList, new OrderHT_Tokunin(orders));
        return copyList;
    }

}

