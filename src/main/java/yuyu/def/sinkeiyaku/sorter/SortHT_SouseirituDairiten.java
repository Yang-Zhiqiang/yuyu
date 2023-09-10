package yuyu.def.sinkeiyaku.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.HT_SouseirituDairiten;
import yuyu.def.db.meta.QHT_SouseirituDairiten;
import yuyu.def.sinkeiyaku.comparator.OrderHT_SouseirituDairiten;

public class SortHT_SouseirituDairiten {

    
    public List<HT_SouseirituDairiten> OrderHT_SouseirituDairitenByPkAsc(List<HT_SouseirituDairiten> pEntity) {
        List<SortCondition<HT_SouseirituDairiten>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QHT_SouseirituDairiten()).syono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QHT_SouseirituDairiten()).renno, SortOrder.ASC));
        List<HT_SouseirituDairiten> copyList = new ArrayList<HT_SouseirituDairiten>(pEntity);
        Collections.sort(copyList, new OrderHT_SouseirituDairiten(orders));
        return copyList;
    }

    
    public List<HT_SouseirituDairiten> OrderHT_SouseirituDairitenByPkDesc(List<HT_SouseirituDairiten> pEntity) {
        List<SortCondition<HT_SouseirituDairiten>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QHT_SouseirituDairiten()).syono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QHT_SouseirituDairiten()).renno, SortOrder.DESC));
        List<HT_SouseirituDairiten> copyList = new ArrayList<HT_SouseirituDairiten>(pEntity);
        Collections.sort(copyList, new OrderHT_SouseirituDairiten(orders));
        return copyList;
    }

}

