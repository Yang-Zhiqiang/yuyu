package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IT_BAK_KhDenpyoData;
import yuyu.def.db.meta.QIT_BAK_KhDenpyoData;
import yuyu.def.hozen.comparator.OrderIT_BAK_KhDenpyoData;

public class SortIT_BAK_KhDenpyoData {

    public List<IT_BAK_KhDenpyoData> OrderIT_BAK_KhDenpyoDataByPkAsc(List<IT_BAK_KhDenpyoData> pEntity) {
        List<SortCondition<IT_BAK_KhDenpyoData>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_BAK_KhDenpyoData()).denrenno, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_KhDenpyoData()).trkssikibetukey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_KhDenpyoData()).edano, SortOrder.ASC));
        List<IT_BAK_KhDenpyoData> copyList = new ArrayList<IT_BAK_KhDenpyoData>(pEntity);
        Collections.sort(copyList, new OrderIT_BAK_KhDenpyoData(orders));
        return copyList;
    }

    public List<IT_BAK_KhDenpyoData> OrderIT_BAK_KhDenpyoDataByPkDesc(List<IT_BAK_KhDenpyoData> pEntity) {
        List<SortCondition<IT_BAK_KhDenpyoData>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_BAK_KhDenpyoData()).denrenno, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_KhDenpyoData()).trkssikibetukey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_KhDenpyoData()).edano, SortOrder.DESC));
        List<IT_BAK_KhDenpyoData> copyList = new ArrayList<IT_BAK_KhDenpyoData>(pEntity);
        Collections.sort(copyList, new OrderIT_BAK_KhDenpyoData(orders));
        return copyList;
    }

}

