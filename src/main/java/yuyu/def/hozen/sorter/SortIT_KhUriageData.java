package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IT_KhUriageData;
import yuyu.def.db.meta.QIT_KhUriageData;
import yuyu.def.hozen.comparator.OrderIT_KhUriageData;

public class SortIT_KhUriageData {

    public List<IT_KhUriageData> OrderIT_KhUriageDataByPkAsc(List<IT_KhUriageData> pEntity) {
        List<SortCondition<IT_KhUriageData>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_KhUriageData()).ansyuusyskbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_KhUriageData()).syoriYmd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_KhUriageData()).syono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_KhUriageData()).authorikaisuu, SortOrder.ASC));
        List<IT_KhUriageData> copyList = new ArrayList<IT_KhUriageData>(pEntity);
        Collections.sort(copyList, new OrderIT_KhUriageData(orders));
        return copyList;
    }

    public List<IT_KhUriageData> OrderIT_KhUriageDataByPkDesc(List<IT_KhUriageData> pEntity) {
        List<SortCondition<IT_KhUriageData>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_KhUriageData()).ansyuusyskbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_KhUriageData()).syoriYmd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_KhUriageData()).syono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_KhUriageData()).authorikaisuu, SortOrder.DESC));
        List<IT_KhUriageData> copyList = new ArrayList<IT_KhUriageData>(pEntity);
        Collections.sort(copyList, new OrderIT_KhUriageData(orders));
        return copyList;
    }

}

