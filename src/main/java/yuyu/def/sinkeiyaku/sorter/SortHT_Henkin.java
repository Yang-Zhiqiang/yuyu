package yuyu.def.sinkeiyaku.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.HT_Henkin;
import yuyu.def.db.meta.QHT_Henkin;
import yuyu.def.sinkeiyaku.comparator.OrderHT_Henkin;

public class SortHT_Henkin {

    
    public List<HT_Henkin> OrderHT_HenkinByPkAsc(List<HT_Henkin> pEntity) {
        List<SortCondition<HT_Henkin>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QHT_Henkin()).mosno, SortOrder.ASC));
        orders.add(new SortCondition<>((new QHT_Henkin()).renno, SortOrder.ASC));
        List<HT_Henkin> copyList = new ArrayList<HT_Henkin>(pEntity);
        Collections.sort(copyList, new OrderHT_Henkin(orders));
        return copyList;
    }

    
    public List<HT_Henkin> OrderHT_HenkinByPkDesc(List<HT_Henkin> pEntity) {
        List<SortCondition<HT_Henkin>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QHT_Henkin()).mosno, SortOrder.DESC));
        orders.add(new SortCondition<>((new QHT_Henkin()).renno, SortOrder.DESC));
        List<HT_Henkin> copyList = new ArrayList<HT_Henkin>(pEntity);
        Collections.sort(copyList, new OrderHT_Henkin(orders));
        return copyList;
    }
    
    public List<HT_Henkin> OrderHT_HenkinByHnkninputrennoAsc(List<HT_Henkin> pEntity) {
        List<SortCondition<HT_Henkin>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QHT_Henkin()).hnkninputrenno, SortOrder.ASC));
        List<HT_Henkin> copyList = new ArrayList<HT_Henkin>(pEntity);
        Collections.sort(copyList, new OrderHT_Henkin(orders));
        return copyList;
    }


}

