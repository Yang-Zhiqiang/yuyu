package yuyu.def.biz.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.biz.comparator.OrderBT_MdhnBank;
import yuyu.def.db.entity.BT_MdhnBank;
import yuyu.def.db.meta.QBT_MdhnBank;

public class SortBT_MdhnBank {

    public List<BT_MdhnBank> OrderBT_MdhnBankByPkAsc(List<BT_MdhnBank> pEntity) {
        List<SortCondition<BT_MdhnBank>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBT_MdhnBank()).drtencd, SortOrder.ASC));
        List<BT_MdhnBank> copyList = new ArrayList<BT_MdhnBank>(pEntity);
        Collections.sort(copyList, new OrderBT_MdhnBank(orders));
        return copyList;
    }

    public List<BT_MdhnBank> OrderBT_MdhnBankByPkDesc(List<BT_MdhnBank> pEntity) {
        List<SortCondition<BT_MdhnBank>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBT_MdhnBank()).drtencd, SortOrder.DESC));
        List<BT_MdhnBank> copyList = new ArrayList<BT_MdhnBank>(pEntity);
        Collections.sort(copyList, new OrderBT_MdhnBank(orders));
        return copyList;
    }

}

