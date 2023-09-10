package yuyu.def.sinkeiyaku.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.HW_HrkmNyknTaisyouWk;
import yuyu.def.db.meta.QHW_HrkmNyknTaisyouWk;
import yuyu.def.sinkeiyaku.comparator.OrderHW_HrkmNyknTaisyouWk;

public class SortHW_HrkmNyknTaisyouWk {

    
    public List<HW_HrkmNyknTaisyouWk> OrderHW_HrkmNyknTaisyouWkByPkAsc(List<HW_HrkmNyknTaisyouWk> pEntity) {
        List<SortCondition<HW_HrkmNyknTaisyouWk>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QHW_HrkmNyknTaisyouWk()).syoriYmd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QHW_HrkmNyknTaisyouWk()).mosno, SortOrder.ASC));
        orders.add(new SortCondition<>((new QHW_HrkmNyknTaisyouWk()).renno, SortOrder.ASC));
        List<HW_HrkmNyknTaisyouWk> copyList = new ArrayList<HW_HrkmNyknTaisyouWk>(pEntity);
        Collections.sort(copyList, new OrderHW_HrkmNyknTaisyouWk(orders));
        return copyList;
    }

    
    public List<HW_HrkmNyknTaisyouWk> OrderHW_HrkmNyknTaisyouWkByPkDesc(List<HW_HrkmNyknTaisyouWk> pEntity) {
        List<SortCondition<HW_HrkmNyknTaisyouWk>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QHW_HrkmNyknTaisyouWk()).syoriYmd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QHW_HrkmNyknTaisyouWk()).mosno, SortOrder.DESC));
        orders.add(new SortCondition<>((new QHW_HrkmNyknTaisyouWk()).renno, SortOrder.DESC));
        List<HW_HrkmNyknTaisyouWk> copyList = new ArrayList<HW_HrkmNyknTaisyouWk>(pEntity);
        Collections.sort(copyList, new OrderHW_HrkmNyknTaisyouWk(orders));
        return copyList;
    }

}

