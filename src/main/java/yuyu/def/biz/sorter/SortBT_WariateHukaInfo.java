package yuyu.def.biz.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.biz.comparator.OrderBT_WariateHukaInfo;
import yuyu.def.db.entity.BT_WariateHukaInfo;
import yuyu.def.db.meta.QBT_WariateHukaInfo;

public class SortBT_WariateHukaInfo {

    public List<BT_WariateHukaInfo> OrderBT_WariateHukaInfoByPkAsc(List<BT_WariateHukaInfo> pEntity) {
        List<SortCondition<BT_WariateHukaInfo>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBT_WariateHukaInfo()).kouteikanriid, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBT_WariateHukaInfo()).subSystemId, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBT_WariateHukaInfo()).jimutetuzukicd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBT_WariateHukaInfo()).wrthukatskid, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBT_WariateHukaInfo()).userId, SortOrder.ASC));
        List<BT_WariateHukaInfo> copyList = new ArrayList<BT_WariateHukaInfo>(pEntity);
        Collections.sort(copyList, new OrderBT_WariateHukaInfo(orders));
        return copyList;
    }

    public List<BT_WariateHukaInfo> OrderBT_WariateHukaInfoByPkDesc(List<BT_WariateHukaInfo> pEntity) {
        List<SortCondition<BT_WariateHukaInfo>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBT_WariateHukaInfo()).kouteikanriid, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBT_WariateHukaInfo()).subSystemId, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBT_WariateHukaInfo()).jimutetuzukicd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBT_WariateHukaInfo()).wrthukatskid, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBT_WariateHukaInfo()).userId, SortOrder.DESC));
        List<BT_WariateHukaInfo> copyList = new ArrayList<BT_WariateHukaInfo>(pEntity);
        Collections.sort(copyList, new OrderBT_WariateHukaInfo(orders));
        return copyList;
    }

}

