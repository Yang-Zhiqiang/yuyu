package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IT_BAK_KhLincSousinData;
import yuyu.def.db.meta.QIT_BAK_KhLincSousinData;
import yuyu.def.hozen.comparator.OrderIT_BAK_KhLincSousinData;

public class SortIT_BAK_KhLincSousinData {

    public List<IT_BAK_KhLincSousinData> OrderIT_BAK_KhLincSousinDataByPkAsc(List<IT_BAK_KhLincSousinData> pEntity) {
        List<SortCondition<IT_BAK_KhLincSousinData>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_BAK_KhLincSousinData()).kbnkey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_KhLincSousinData()).syono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_KhLincSousinData()).trkssikibetukey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_KhLincSousinData()).syoriYmd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_KhLincSousinData()).renno, SortOrder.ASC));
        List<IT_BAK_KhLincSousinData> copyList = new ArrayList<IT_BAK_KhLincSousinData>(pEntity);
        Collections.sort(copyList, new OrderIT_BAK_KhLincSousinData(orders));
        return copyList;
    }

    public List<IT_BAK_KhLincSousinData> OrderIT_BAK_KhLincSousinDataByPkDesc(List<IT_BAK_KhLincSousinData> pEntity) {
        List<SortCondition<IT_BAK_KhLincSousinData>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_BAK_KhLincSousinData()).kbnkey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_KhLincSousinData()).syono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_KhLincSousinData()).trkssikibetukey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_KhLincSousinData()).syoriYmd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_KhLincSousinData()).renno, SortOrder.DESC));
        List<IT_BAK_KhLincSousinData> copyList = new ArrayList<IT_BAK_KhLincSousinData>(pEntity);
        Collections.sort(copyList, new OrderIT_BAK_KhLincSousinData(orders));
        return copyList;
    }
}
