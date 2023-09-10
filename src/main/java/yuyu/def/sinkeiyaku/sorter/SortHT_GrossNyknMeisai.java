package yuyu.def.sinkeiyaku.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.HT_GrossNyknMeisai;
import yuyu.def.db.meta.QHT_GrossNyknMeisai;
import yuyu.def.sinkeiyaku.comparator.OrderHT_GrossNyknMeisai;

public class SortHT_GrossNyknMeisai {

    
    public List<HT_GrossNyknMeisai> OrderHT_GrossNyknMeisaiByPkAsc(List<HT_GrossNyknMeisai> pEntity) {
        List<SortCondition<HT_GrossNyknMeisai>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QHT_GrossNyknMeisai()).ryosyuymd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QHT_GrossNyknMeisai()).oyadrtencd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QHT_GrossNyknMeisai()).renno, SortOrder.ASC));
        orders.add(new SortCondition<>((new QHT_GrossNyknMeisai()).meisairenno, SortOrder.ASC));
        List<HT_GrossNyknMeisai> copyList = new ArrayList<HT_GrossNyknMeisai>(pEntity);
        Collections.sort(copyList, new OrderHT_GrossNyknMeisai(orders));
        return copyList;
    }

    
    public List<HT_GrossNyknMeisai> OrderHT_GrossNyknMeisaiByPkDesc(List<HT_GrossNyknMeisai> pEntity) {
        List<SortCondition<HT_GrossNyknMeisai>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QHT_GrossNyknMeisai()).ryosyuymd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QHT_GrossNyknMeisai()).oyadrtencd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QHT_GrossNyknMeisai()).renno, SortOrder.DESC));
        orders.add(new SortCondition<>((new QHT_GrossNyknMeisai()).meisairenno, SortOrder.DESC));
        List<HT_GrossNyknMeisai> copyList = new ArrayList<HT_GrossNyknMeisai>(pEntity);
        Collections.sort(copyList, new OrderHT_GrossNyknMeisai(orders));
        return copyList;
    }
}
