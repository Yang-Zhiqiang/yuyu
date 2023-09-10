package yuyu.def.sinkeiyaku.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.HT_MiseirijiyuuMeisai;
import yuyu.def.db.meta.QHT_MiseirijiyuuMeisai;
import yuyu.def.sinkeiyaku.comparator.OrderHT_MiseirijiyuuMeisai;

public class SortHT_MiseirijiyuuMeisai {

    
    public List<HT_MiseirijiyuuMeisai> OrderHT_MiseirijiyuuMeisaiByPkAsc(List<HT_MiseirijiyuuMeisai> pEntity) {
        List<SortCondition<HT_MiseirijiyuuMeisai>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QHT_MiseirijiyuuMeisai()).mosno, SortOrder.ASC));
        List<HT_MiseirijiyuuMeisai> copyList = new ArrayList<HT_MiseirijiyuuMeisai>(pEntity);
        Collections.sort(copyList, new OrderHT_MiseirijiyuuMeisai(orders));
        return copyList;
    }

    
    public List<HT_MiseirijiyuuMeisai> OrderHT_MiseirijiyuuMeisaiByPkDesc(List<HT_MiseirijiyuuMeisai> pEntity) {
        List<SortCondition<HT_MiseirijiyuuMeisai>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QHT_MiseirijiyuuMeisai()).mosno, SortOrder.DESC));
        List<HT_MiseirijiyuuMeisai> copyList = new ArrayList<HT_MiseirijiyuuMeisai>(pEntity);
        Collections.sort(copyList, new OrderHT_MiseirijiyuuMeisai(orders));
        return copyList;
    }

}

