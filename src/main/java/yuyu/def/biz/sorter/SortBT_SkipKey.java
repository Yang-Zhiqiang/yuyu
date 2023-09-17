package yuyu.def.biz.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.biz.comparator.OrderBT_SkipKey;
import yuyu.def.db.entity.BT_SkipKey;
import yuyu.def.db.meta.QBT_SkipKey;

public class SortBT_SkipKey {

    public List<BT_SkipKey> OrderBT_SkipKeyByPkAsc(List<BT_SkipKey> pEntity) {
        List<SortCondition<BT_SkipKey>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBT_SkipKey()).recoverysikibetukey, SortOrder.ASC));
        List<BT_SkipKey> copyList = new ArrayList<BT_SkipKey>(pEntity);
        Collections.sort(copyList, new OrderBT_SkipKey(orders));
        return copyList;
    }

    public List<BT_SkipKey> OrderBT_SkipKeyByPkDesc(List<BT_SkipKey> pEntity) {
        List<SortCondition<BT_SkipKey>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBT_SkipKey()).recoverysikibetukey, SortOrder.DESC));
        List<BT_SkipKey> copyList = new ArrayList<BT_SkipKey>(pEntity);
        Collections.sort(copyList, new OrderBT_SkipKey(orders));
        return copyList;
    }
}
