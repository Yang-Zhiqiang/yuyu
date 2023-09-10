package yuyu.def.sinkeiyaku.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.HT_ImuSonotaTkykJktk;
import yuyu.def.db.meta.QHT_ImuSonotaTkykJktk;
import yuyu.def.sinkeiyaku.comparator.OrderHT_ImuSonotaTkykJktk;

public class SortHT_ImuSonotaTkykJktk {

    
    public List<HT_ImuSonotaTkykJktk> OrderHT_ImuSonotaTkykJktkByPkAsc(List<HT_ImuSonotaTkykJktk> pEntity) {
        List<SortCondition<HT_ImuSonotaTkykJktk>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QHT_ImuSonotaTkykJktk()).mosno, SortOrder.ASC));
        orders.add(new SortCondition<>((new QHT_ImuSonotaTkykJktk()).renno, SortOrder.ASC));
        orders.add(new SortCondition<>((new QHT_ImuSonotaTkykJktk()).pmnjtkkbn, SortOrder.ASC));
        List<HT_ImuSonotaTkykJktk> copyList = new ArrayList<HT_ImuSonotaTkykJktk>(pEntity);
        Collections.sort(copyList, new OrderHT_ImuSonotaTkykJktk(orders));
        return copyList;
    }

    
    public List<HT_ImuSonotaTkykJktk> OrderHT_ImuSonotaTkykJktkByPkDesc(List<HT_ImuSonotaTkykJktk> pEntity) {
        List<SortCondition<HT_ImuSonotaTkykJktk>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QHT_ImuSonotaTkykJktk()).mosno, SortOrder.DESC));
        orders.add(new SortCondition<>((new QHT_ImuSonotaTkykJktk()).renno, SortOrder.DESC));
        orders.add(new SortCondition<>((new QHT_ImuSonotaTkykJktk()).pmnjtkkbn, SortOrder.DESC));
        List<HT_ImuSonotaTkykJktk> copyList = new ArrayList<HT_ImuSonotaTkykJktk>(pEntity);
        Collections.sort(copyList, new OrderHT_ImuSonotaTkykJktk(orders));
        return copyList;
    }

}

