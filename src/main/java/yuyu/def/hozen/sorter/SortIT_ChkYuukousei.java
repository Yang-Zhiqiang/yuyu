package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IT_ChkYuukousei;
import yuyu.def.db.meta.QIT_ChkYuukousei;
import yuyu.def.hozen.comparator.OrderIT_ChkYuukousei;

public class SortIT_ChkYuukousei {

    public List<IT_ChkYuukousei> OrderIT_ChkYuukouseiByPkAsc(List<IT_ChkYuukousei> pEntity) {
        List<SortCondition<IT_ChkYuukousei>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_ChkYuukousei()).kbnkey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_ChkYuukousei()).ansyuusyskbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_ChkYuukousei()).syoriYmd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_ChkYuukousei()).syono, SortOrder.ASC));
        List<IT_ChkYuukousei> copyList = new ArrayList<IT_ChkYuukousei>(pEntity);
        Collections.sort(copyList, new OrderIT_ChkYuukousei(orders));
        return copyList;
    }

    public List<IT_ChkYuukousei> OrderIT_ChkYuukouseiByPkDesc(List<IT_ChkYuukousei> pEntity) {
        List<SortCondition<IT_ChkYuukousei>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_ChkYuukousei()).kbnkey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_ChkYuukousei()).ansyuusyskbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_ChkYuukousei()).syoriYmd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_ChkYuukousei()).syono, SortOrder.DESC));
        List<IT_ChkYuukousei> copyList = new ArrayList<IT_ChkYuukousei>(pEntity);
        Collections.sort(copyList, new OrderIT_ChkYuukousei(orders));
        return copyList;
    }
}
