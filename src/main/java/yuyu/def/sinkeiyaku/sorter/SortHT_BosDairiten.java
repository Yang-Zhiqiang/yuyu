package yuyu.def.sinkeiyaku.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.HT_BosDairiten;
import yuyu.def.db.meta.QHT_BosDairiten;
import yuyu.def.sinkeiyaku.comparator.OrderHT_BosDairiten;

public class SortHT_BosDairiten {

    
    public List<HT_BosDairiten> OrderHT_BosDairitenByPkAsc(List<HT_BosDairiten> pEntity) {
        List<SortCondition<HT_BosDairiten>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QHT_BosDairiten()).mosno, SortOrder.ASC));
        orders.add(new SortCondition<>((new QHT_BosDairiten()).renno, SortOrder.ASC));
        List<HT_BosDairiten> copyList = new ArrayList<HT_BosDairiten>(pEntity);
        Collections.sort(copyList, new OrderHT_BosDairiten(orders));
        return copyList;
    }

    
    public List<HT_BosDairiten> OrderHT_BosDairitenByPkDesc(List<HT_BosDairiten> pEntity) {
        List<SortCondition<HT_BosDairiten>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QHT_BosDairiten()).mosno, SortOrder.DESC));
        orders.add(new SortCondition<>((new QHT_BosDairiten()).renno, SortOrder.DESC));
        List<HT_BosDairiten> copyList = new ArrayList<HT_BosDairiten>(pEntity);
        Collections.sort(copyList, new OrderHT_BosDairiten(orders));
        return copyList;
    }

}

