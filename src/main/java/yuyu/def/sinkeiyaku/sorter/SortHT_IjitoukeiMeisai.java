package yuyu.def.sinkeiyaku.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.HT_IjitoukeiMeisai;
import yuyu.def.db.meta.QHT_IjitoukeiMeisai;
import yuyu.def.sinkeiyaku.comparator.OrderHT_IjitoukeiMeisai;

public class SortHT_IjitoukeiMeisai {

    
    public List<HT_IjitoukeiMeisai> OrderHT_IjitoukeiMeisaiByPkAsc(List<HT_IjitoukeiMeisai> pEntity) {
        List<SortCondition<HT_IjitoukeiMeisai>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QHT_IjitoukeiMeisai()).syono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QHT_IjitoukeiMeisai()).renno8keta, SortOrder.ASC));
        List<HT_IjitoukeiMeisai> copyList = new ArrayList<HT_IjitoukeiMeisai>(pEntity);
        Collections.sort(copyList, new OrderHT_IjitoukeiMeisai(orders));
        return copyList;
    }

    
    public List<HT_IjitoukeiMeisai> OrderHT_IjitoukeiMeisaiByPkDesc(List<HT_IjitoukeiMeisai> pEntity) {
        List<SortCondition<HT_IjitoukeiMeisai>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QHT_IjitoukeiMeisai()).syono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QHT_IjitoukeiMeisai()).renno8keta, SortOrder.DESC));
        List<HT_IjitoukeiMeisai> copyList = new ArrayList<HT_IjitoukeiMeisai>(pEntity);
        Collections.sort(copyList, new OrderHT_IjitoukeiMeisai(orders));
        return copyList;
    }

}

