package yuyu.def.sinkeiyaku.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.HT_Tuusan;
import yuyu.def.db.meta.QHT_Tuusan;
import yuyu.def.sinkeiyaku.comparator.OrderHT_Tuusan;

public class SortHT_Tuusan {

    
    public List<HT_Tuusan> OrderHT_TuusanByPkAsc(List<HT_Tuusan> pEntity) {
        List<SortCondition<HT_Tuusan>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QHT_Tuusan()).mosno, SortOrder.ASC));
        List<HT_Tuusan> copyList = new ArrayList<HT_Tuusan>(pEntity);
        Collections.sort(copyList, new OrderHT_Tuusan(orders));
        return copyList;
    }

    
    public List<HT_Tuusan> OrderHT_TuusanByPkDesc(List<HT_Tuusan> pEntity) {
        List<SortCondition<HT_Tuusan>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QHT_Tuusan()).mosno, SortOrder.DESC));
        List<HT_Tuusan> copyList = new ArrayList<HT_Tuusan>(pEntity);
        Collections.sort(copyList, new OrderHT_Tuusan(orders));
        return copyList;
    }

}

