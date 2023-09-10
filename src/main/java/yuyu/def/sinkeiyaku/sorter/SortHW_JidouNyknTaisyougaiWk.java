package yuyu.def.sinkeiyaku.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.HW_JidouNyknTaisyougaiWk;
import yuyu.def.db.meta.QHW_JidouNyknTaisyougaiWk;
import yuyu.def.sinkeiyaku.comparator.OrderHW_JidouNyknTaisyougaiWk;

public class SortHW_JidouNyknTaisyougaiWk {

    
    public List<HW_JidouNyknTaisyougaiWk> OrderHW_JidouNyknTaisyougaiWkByPkAsc(List<HW_JidouNyknTaisyougaiWk> pEntity) {
        List<SortCondition<HW_JidouNyknTaisyougaiWk>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QHW_JidouNyknTaisyougaiWk()).nyksyoriymd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QHW_JidouNyknTaisyougaiWk()).itirenno, SortOrder.ASC));
        List<HW_JidouNyknTaisyougaiWk> copyList = new ArrayList<HW_JidouNyknTaisyougaiWk>(pEntity);
        Collections.sort(copyList, new OrderHW_JidouNyknTaisyougaiWk(orders));
        return copyList;
    }

    
    public List<HW_JidouNyknTaisyougaiWk> OrderHW_JidouNyknTaisyougaiWkByPkDesc(List<HW_JidouNyknTaisyougaiWk> pEntity) {
        List<SortCondition<HW_JidouNyknTaisyougaiWk>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QHW_JidouNyknTaisyougaiWk()).nyksyoriymd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QHW_JidouNyknTaisyougaiWk()).itirenno, SortOrder.DESC));
        List<HW_JidouNyknTaisyougaiWk> copyList = new ArrayList<HW_JidouNyknTaisyougaiWk>(pEntity);
        Collections.sort(copyList, new OrderHW_JidouNyknTaisyougaiWk(orders));
        return copyList;
    }

}

