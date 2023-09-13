package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IT_BAK_KhAuthoriData;
import yuyu.def.db.meta.QIT_BAK_KhAuthoriData;
import yuyu.def.hozen.comparator.OrderIT_BAK_KhAuthoriData;

public class SortIT_BAK_KhAuthoriData {

    public List<IT_BAK_KhAuthoriData> OrderIT_BAK_KhAuthoriDataByPkAsc(List<IT_BAK_KhAuthoriData> pEntity) {
        List<SortCondition<IT_BAK_KhAuthoriData>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_BAK_KhAuthoriData()).ansyuusyskbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_KhAuthoriData()).trkssikibetukey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_KhAuthoriData()).syoriYmd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_KhAuthoriData()).syono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_KhAuthoriData()).authorikaisuu, SortOrder.ASC));
        List<IT_BAK_KhAuthoriData> copyList = new ArrayList<IT_BAK_KhAuthoriData>(pEntity);
        Collections.sort(copyList, new OrderIT_BAK_KhAuthoriData(orders));
        return copyList;
    }

    public List<IT_BAK_KhAuthoriData> OrderIT_BAK_KhAuthoriDataByPkDesc(List<IT_BAK_KhAuthoriData> pEntity) {
        List<SortCondition<IT_BAK_KhAuthoriData>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_BAK_KhAuthoriData()).ansyuusyskbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_KhAuthoriData()).trkssikibetukey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_KhAuthoriData()).syoriYmd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_KhAuthoriData()).syono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_KhAuthoriData()).authorikaisuu, SortOrder.DESC));
        List<IT_BAK_KhAuthoriData> copyList = new ArrayList<IT_BAK_KhAuthoriData>(pEntity);
        Collections.sort(copyList, new OrderIT_BAK_KhAuthoriData(orders));
        return copyList;
    }

}

