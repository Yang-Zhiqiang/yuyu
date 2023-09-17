package yuyu.def.biz.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.biz.comparator.OrderBT_KawaseRateData;
import yuyu.def.db.entity.BT_KawaseRateData;
import yuyu.def.db.meta.QBT_KawaseRateData;

public class SortBT_KawaseRateData {

    public List<BT_KawaseRateData> OrderBT_KawaseRateDataByPkAsc(List<BT_KawaseRateData> pEntity) {
        List<SortCondition<BT_KawaseRateData>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBT_KawaseRateData()).kwsratekjymd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBT_KawaseRateData()).kwsrendoukbn, SortOrder.ASC));
        List<BT_KawaseRateData> copyList = new ArrayList<BT_KawaseRateData>(pEntity);
        Collections.sort(copyList, new OrderBT_KawaseRateData(orders));
        return copyList;
    }

    public List<BT_KawaseRateData> OrderBT_KawaseRateDataByPkDesc(List<BT_KawaseRateData> pEntity) {
        List<SortCondition<BT_KawaseRateData>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBT_KawaseRateData()).kwsratekjymd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBT_KawaseRateData()).kwsrendoukbn, SortOrder.DESC));
        List<BT_KawaseRateData> copyList = new ArrayList<BT_KawaseRateData>(pEntity);
        Collections.sort(copyList, new OrderBT_KawaseRateData(orders));
        return copyList;
    }
}
