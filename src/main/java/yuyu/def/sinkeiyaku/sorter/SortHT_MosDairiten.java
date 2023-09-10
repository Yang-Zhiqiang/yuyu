package yuyu.def.sinkeiyaku.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.HT_MosDairiten;
import yuyu.def.db.meta.QHT_MosDairiten;
import yuyu.def.sinkeiyaku.comparator.OrderHT_MosDairiten;

public class SortHT_MosDairiten {

    
    public List<HT_MosDairiten> OrderHT_MosDairitenByPkAsc(List<HT_MosDairiten> pEntity) {
        List<SortCondition<HT_MosDairiten>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QHT_MosDairiten()).mosno, SortOrder.ASC));
        orders.add(new SortCondition<>((new QHT_MosDairiten()).renno, SortOrder.ASC));
        List<HT_MosDairiten> copyList = new ArrayList<HT_MosDairiten>(pEntity);
        Collections.sort(copyList, new OrderHT_MosDairiten(orders));
        return copyList;
    }

    
    public List<HT_MosDairiten> OrderHT_MosDairitenByPkDesc(List<HT_MosDairiten> pEntity) {
        List<SortCondition<HT_MosDairiten>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QHT_MosDairiten()).mosno, SortOrder.DESC));
        orders.add(new SortCondition<>((new QHT_MosDairiten()).renno, SortOrder.DESC));
        List<HT_MosDairiten> copyList = new ArrayList<HT_MosDairiten>(pEntity);
        Collections.sort(copyList, new OrderHT_MosDairiten(orders));
        return copyList;
    }

}

