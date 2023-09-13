package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IT_KhDenpyoData;
import yuyu.def.db.meta.QIT_KhDenpyoData;
import yuyu.def.hozen.comparator.OrderIT_KhDenpyoData;

public class SortIT_KhDenpyoData {

    public List<IT_KhDenpyoData> OrderIT_KhDenpyoDataByPkAsc(List<IT_KhDenpyoData> pEntity) {
        List<SortCondition<IT_KhDenpyoData>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_KhDenpyoData()).denrenno, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_KhDenpyoData()).edano, SortOrder.ASC));
        List<IT_KhDenpyoData> copyList = new ArrayList<IT_KhDenpyoData>(pEntity);
        Collections.sort(copyList, new OrderIT_KhDenpyoData(orders));
        return copyList;
    }

    public List<IT_KhDenpyoData> OrderIT_KhDenpyoDataByPkDesc(List<IT_KhDenpyoData> pEntity) {
        List<SortCondition<IT_KhDenpyoData>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_KhDenpyoData()).denrenno, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_KhDenpyoData()).edano, SortOrder.DESC));
        List<IT_KhDenpyoData> copyList = new ArrayList<IT_KhDenpyoData>(pEntity);
        Collections.sort(copyList, new OrderIT_KhDenpyoData(orders));
        return copyList;
    }

}

