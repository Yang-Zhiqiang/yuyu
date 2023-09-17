package yuyu.def.biz.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.biz.comparator.OrderBT_SystemRenkei;
import yuyu.def.db.entity.BT_SystemRenkei;
import yuyu.def.db.meta.QBT_SystemRenkei;

public class SortBT_SystemRenkei {

    public List<BT_SystemRenkei> OrderBT_SystemRenkeiByPkAsc(List<BT_SystemRenkei> pEntity) {
        List<SortCondition<BT_SystemRenkei>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBT_SystemRenkei()).interfaceid, SortOrder.ASC));
        List<BT_SystemRenkei> copyList = new ArrayList<BT_SystemRenkei>(pEntity);
        Collections.sort(copyList, new OrderBT_SystemRenkei(orders));
        return copyList;
    }

    public List<BT_SystemRenkei> OrderBT_SystemRenkeiByPkDesc(List<BT_SystemRenkei> pEntity) {
        List<SortCondition<BT_SystemRenkei>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBT_SystemRenkei()).interfaceid, SortOrder.DESC));
        List<BT_SystemRenkei> copyList = new ArrayList<BT_SystemRenkei>(pEntity);
        Collections.sort(copyList, new OrderBT_SystemRenkei(orders));
        return copyList;
    }
}
