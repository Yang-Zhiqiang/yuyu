package yuyu.def.biz.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.biz.comparator.OrderBT_TestKykData;
import yuyu.def.db.entity.BT_TestKykData;
import yuyu.def.db.meta.QBT_TestKykData;

public class SortBT_TestKykData {

    public List<BT_TestKykData> OrderBT_TestKykDataByPkAsc(List<BT_TestKykData> pEntity) {
        List<SortCondition<BT_TestKykData>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBT_TestKykData()).uniqueId, SortOrder.ASC));
        List<BT_TestKykData> copyList = new ArrayList<BT_TestKykData>(pEntity);
        Collections.sort(copyList, new OrderBT_TestKykData(orders));
        return copyList;
    }

    public List<BT_TestKykData> OrderBT_TestKykDataByPkDesc(List<BT_TestKykData> pEntity) {
        List<SortCondition<BT_TestKykData>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBT_TestKykData()).uniqueId, SortOrder.DESC));
        List<BT_TestKykData> copyList = new ArrayList<BT_TestKykData>(pEntity);
        Collections.sort(copyList, new OrderBT_TestKykData(orders));
        return copyList;
    }
}
