package yuyu.def.biz.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.biz.comparator.OrderBT_BuntanInfo;
import yuyu.def.db.entity.BT_BuntanInfo;
import yuyu.def.db.meta.QBT_BuntanInfo;

public class SortBT_BuntanInfo {

    public List<BT_BuntanInfo> OrderBT_BuntanInfoByPkAsc(List<BT_BuntanInfo> pEntity) {
        List<SortCondition<BT_BuntanInfo>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBT_BuntanInfo()).drtencd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBT_BuntanInfo()).dairitensyouhincd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBT_BuntanInfo()).tesuuryoubuntandrtencd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBT_BuntanInfo()).tesuuryoubuntanstartym, SortOrder.ASC));
        List<BT_BuntanInfo> copyList = new ArrayList<BT_BuntanInfo>(pEntity);
        Collections.sort(copyList, new OrderBT_BuntanInfo(orders));
        return copyList;
    }

    public List<BT_BuntanInfo> OrderBT_BuntanInfoByPkDesc(List<BT_BuntanInfo> pEntity) {
        List<SortCondition<BT_BuntanInfo>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBT_BuntanInfo()).drtencd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBT_BuntanInfo()).dairitensyouhincd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBT_BuntanInfo()).tesuuryoubuntandrtencd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBT_BuntanInfo()).tesuuryoubuntanstartym, SortOrder.DESC));
        List<BT_BuntanInfo> copyList = new ArrayList<BT_BuntanInfo>(pEntity);
        Collections.sort(copyList, new OrderBT_BuntanInfo(orders));
        return copyList;
    }

}

