package yuyu.def.biz.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.biz.comparator.OrderBT_DenpyoData;
import yuyu.def.db.entity.BT_DenpyoData;
import yuyu.def.db.meta.QBT_DenpyoData;

public class SortBT_DenpyoData {

    public List<BT_DenpyoData> OrderBT_DenpyoDataByPkAsc(List<BT_DenpyoData> pEntity) {
        List<SortCondition<BT_DenpyoData>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBT_DenpyoData()).densyskbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBT_DenpyoData()).denrenno, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBT_DenpyoData()).edano, SortOrder.ASC));
        List<BT_DenpyoData> copyList = new ArrayList<BT_DenpyoData>(pEntity);
        Collections.sort(copyList, new OrderBT_DenpyoData(orders));
        return copyList;
    }

    public List<BT_DenpyoData> OrderBT_DenpyoDataByPkDesc(List<BT_DenpyoData> pEntity) {
        List<SortCondition<BT_DenpyoData>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBT_DenpyoData()).densyskbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBT_DenpyoData()).denrenno, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBT_DenpyoData()).edano, SortOrder.DESC));
        List<BT_DenpyoData> copyList = new ArrayList<BT_DenpyoData>(pEntity);
        Collections.sort(copyList, new OrderBT_DenpyoData(orders));
        return copyList;
    }

}

