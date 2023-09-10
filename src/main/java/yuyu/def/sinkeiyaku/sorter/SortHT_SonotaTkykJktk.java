package yuyu.def.sinkeiyaku.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.HT_SonotaTkykJktk;
import yuyu.def.db.meta.QHT_SonotaTkykJktk;
import yuyu.def.sinkeiyaku.comparator.OrderHT_SonotaTkykJktk;

public class SortHT_SonotaTkykJktk {

    
    public List<HT_SonotaTkykJktk> OrderHT_SonotaTkykJktkByPkAsc(List<HT_SonotaTkykJktk> pEntity) {
        List<SortCondition<HT_SonotaTkykJktk>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QHT_SonotaTkykJktk()).mosno, SortOrder.ASC));
        orders.add(new SortCondition<>((new QHT_SonotaTkykJktk()).pmnjtkkbn, SortOrder.ASC));
        List<HT_SonotaTkykJktk> copyList = new ArrayList<HT_SonotaTkykJktk>(pEntity);
        Collections.sort(copyList, new OrderHT_SonotaTkykJktk(orders));
        return copyList;
    }

    
    public List<HT_SonotaTkykJktk> OrderHT_SonotaTkykJktkByPkDesc(List<HT_SonotaTkykJktk> pEntity) {
        List<SortCondition<HT_SonotaTkykJktk>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QHT_SonotaTkykJktk()).mosno, SortOrder.DESC));
        orders.add(new SortCondition<>((new QHT_SonotaTkykJktk()).pmnjtkkbn, SortOrder.DESC));
        List<HT_SonotaTkykJktk> copyList = new ArrayList<HT_SonotaTkykJktk>(pEntity);
        Collections.sort(copyList, new OrderHT_SonotaTkykJktk(orders));
        return copyList;
    }

}

