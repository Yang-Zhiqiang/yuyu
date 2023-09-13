package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IT_KhAuthoriData;
import yuyu.def.db.meta.QIT_KhAuthoriData;
import yuyu.def.hozen.comparator.OrderIT_KhAuthoriData;

public class SortIT_KhAuthoriData {

    public List<IT_KhAuthoriData> OrderIT_KhAuthoriDataByPkAsc(List<IT_KhAuthoriData> pEntity) {
        List<SortCondition<IT_KhAuthoriData>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_KhAuthoriData()).ansyuusyskbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_KhAuthoriData()).syoriYmd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_KhAuthoriData()).syono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_KhAuthoriData()).authorikaisuu, SortOrder.ASC));
        List<IT_KhAuthoriData> copyList = new ArrayList<IT_KhAuthoriData>(pEntity);
        Collections.sort(copyList, new OrderIT_KhAuthoriData(orders));
        return copyList;
    }

    public List<IT_KhAuthoriData> OrderIT_KhAuthoriDataByPkDesc(List<IT_KhAuthoriData> pEntity) {
        List<SortCondition<IT_KhAuthoriData>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_KhAuthoriData()).ansyuusyskbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_KhAuthoriData()).syoriYmd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_KhAuthoriData()).syono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_KhAuthoriData()).authorikaisuu, SortOrder.DESC));
        List<IT_KhAuthoriData> copyList = new ArrayList<IT_KhAuthoriData>(pEntity);
        Collections.sort(copyList, new OrderIT_KhAuthoriData(orders));
        return copyList;
    }

}

