package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IT_HrkmNyknDataHzn;
import yuyu.def.db.meta.QIT_HrkmNyknDataHzn;
import yuyu.def.hozen.comparator.OrderIT_HrkmNyknDataHzn;

public class SortIT_HrkmNyknDataHzn {

    public List<IT_HrkmNyknDataHzn> OrderIT_HrkmNyknDataHznByPkAsc(List<IT_HrkmNyknDataHzn> pEntity) {
        List<SortCondition<IT_HrkmNyknDataHzn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_HrkmNyknDataHzn()).densyskbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_HrkmNyknDataHzn()).syoriYmd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_HrkmNyknDataHzn()).itirenno, SortOrder.ASC));
        List<IT_HrkmNyknDataHzn> copyList = new ArrayList<IT_HrkmNyknDataHzn>(pEntity);
        Collections.sort(copyList, new OrderIT_HrkmNyknDataHzn(orders));
        return copyList;
    }

    public List<IT_HrkmNyknDataHzn> OrderIT_HrkmNyknDataHznByPkDesc(List<IT_HrkmNyknDataHzn> pEntity) {
        List<SortCondition<IT_HrkmNyknDataHzn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_HrkmNyknDataHzn()).densyskbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_HrkmNyknDataHzn()).syoriYmd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_HrkmNyknDataHzn()).itirenno, SortOrder.DESC));
        List<IT_HrkmNyknDataHzn> copyList = new ArrayList<IT_HrkmNyknDataHzn>(pEntity);
        Collections.sort(copyList, new OrderIT_HrkmNyknDataHzn(orders));
        return copyList;
    }
}
