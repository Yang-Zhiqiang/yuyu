package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IT_KhLincSousinData;
import yuyu.def.db.meta.QIT_KhLincSousinData;
import yuyu.def.hozen.comparator.OrderIT_KhLincSousinData;

public class SortIT_KhLincSousinData {

    public List<IT_KhLincSousinData> OrderIT_KhLincSousinDataByPkAsc(List<IT_KhLincSousinData> pEntity) {
        List<SortCondition<IT_KhLincSousinData>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_KhLincSousinData()).kbnkey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_KhLincSousinData()).syono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_KhLincSousinData()).syoriYmd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_KhLincSousinData()).renno, SortOrder.ASC));
        List<IT_KhLincSousinData> copyList = new ArrayList<IT_KhLincSousinData>(pEntity);
        Collections.sort(copyList, new OrderIT_KhLincSousinData(orders));
        return copyList;
    }

    public List<IT_KhLincSousinData> OrderIT_KhLincSousinDataByPkDesc(List<IT_KhLincSousinData> pEntity) {
        List<SortCondition<IT_KhLincSousinData>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_KhLincSousinData()).kbnkey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_KhLincSousinData()).syono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_KhLincSousinData()).syoriYmd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_KhLincSousinData()).renno, SortOrder.DESC));
        List<IT_KhLincSousinData> copyList = new ArrayList<IT_KhLincSousinData>(pEntity);
        Collections.sort(copyList, new OrderIT_KhLincSousinData(orders));
        return copyList;
    }
}
