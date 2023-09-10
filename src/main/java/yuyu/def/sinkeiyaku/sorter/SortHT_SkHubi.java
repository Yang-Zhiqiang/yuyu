package yuyu.def.sinkeiyaku.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.HT_SkHubi;
import yuyu.def.db.meta.QHT_SkHubi;
import yuyu.def.sinkeiyaku.comparator.OrderHT_SkHubi;

public class SortHT_SkHubi {

    
    public List<HT_SkHubi> OrderHT_SkHubiByPkAsc(List<HT_SkHubi> pEntity) {
        List<SortCondition<HT_SkHubi>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QHT_SkHubi()).mosno, SortOrder.ASC));
        orders.add(new SortCondition<>((new QHT_SkHubi()).hubisikibetukey, SortOrder.ASC));
        List<HT_SkHubi> copyList = new ArrayList<HT_SkHubi>(pEntity);
        Collections.sort(copyList, new OrderHT_SkHubi(orders));
        return copyList;
    }

    
    public List<HT_SkHubi> OrderHT_SkHubiByPkDesc(List<HT_SkHubi> pEntity) {
        List<SortCondition<HT_SkHubi>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QHT_SkHubi()).mosno, SortOrder.DESC));
        orders.add(new SortCondition<>((new QHT_SkHubi()).hubisikibetukey, SortOrder.DESC));
        List<HT_SkHubi> copyList = new ArrayList<HT_SkHubi>(pEntity);
        Collections.sort(copyList, new OrderHT_SkHubi(orders));
        return copyList;
    }

}

