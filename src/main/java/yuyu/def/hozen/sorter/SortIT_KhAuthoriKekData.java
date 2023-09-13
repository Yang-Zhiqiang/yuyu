package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IT_KhAuthoriKekData;
import yuyu.def.db.meta.QIT_KhAuthoriKekData;
import yuyu.def.hozen.comparator.OrderIT_KhAuthoriKekData;

public class SortIT_KhAuthoriKekData {

    public List<IT_KhAuthoriKekData> OrderIT_KhAuthoriKekDataByPkAsc(List<IT_KhAuthoriKekData> pEntity) {
        List<SortCondition<IT_KhAuthoriKekData>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_KhAuthoriKekData()).ansyuusyskbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_KhAuthoriKekData()).authorikkdatarenno, SortOrder.ASC));
        List<IT_KhAuthoriKekData> copyList = new ArrayList<IT_KhAuthoriKekData>(pEntity);
        Collections.sort(copyList, new OrderIT_KhAuthoriKekData(orders));
        return copyList;
    }

    public List<IT_KhAuthoriKekData> OrderIT_KhAuthoriKekDataByPkDesc(List<IT_KhAuthoriKekData> pEntity) {
        List<SortCondition<IT_KhAuthoriKekData>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_KhAuthoriKekData()).ansyuusyskbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_KhAuthoriKekData()).authorikkdatarenno, SortOrder.DESC));
        List<IT_KhAuthoriKekData> copyList = new ArrayList<IT_KhAuthoriKekData>(pEntity);
        Collections.sort(copyList, new OrderIT_KhAuthoriKekData(orders));
        return copyList;
    }

}

