package yuyu.def.sinkeiyaku.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.HT_KykKak;
import yuyu.def.db.meta.QHT_KykKak;
import yuyu.def.sinkeiyaku.comparator.OrderHT_KykKak;

public class SortHT_KykKak {

    
    public List<HT_KykKak> OrderHT_KykKakByPkAsc(List<HT_KykKak> pEntity) {
        List<SortCondition<HT_KykKak>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QHT_KykKak()).mosno, SortOrder.ASC));
        orders.add(new SortCondition<>((new QHT_KykKak()).renno, SortOrder.ASC));
        List<HT_KykKak> copyList = new ArrayList<HT_KykKak>(pEntity);
        Collections.sort(copyList, new OrderHT_KykKak(orders));
        return copyList;
    }

    
    public List<HT_KykKak> OrderHT_KykKakByPkDesc(List<HT_KykKak> pEntity) {
        List<SortCondition<HT_KykKak>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QHT_KykKak()).mosno, SortOrder.DESC));
        orders.add(new SortCondition<>((new QHT_KykKak()).renno, SortOrder.DESC));
        List<HT_KykKak> copyList = new ArrayList<HT_KykKak>(pEntity);
        Collections.sort(copyList, new OrderHT_KykKak(orders));
        return copyList;
    }

}

