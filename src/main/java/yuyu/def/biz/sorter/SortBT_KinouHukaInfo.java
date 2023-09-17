package yuyu.def.biz.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.biz.comparator.OrderBT_KinouHukaInfo;
import yuyu.def.db.entity.BT_KinouHukaInfo;
import yuyu.def.db.meta.QBT_KinouHukaInfo;

public class SortBT_KinouHukaInfo {

    public List<BT_KinouHukaInfo> OrderBT_KinouHukaInfoByPkAsc(List<BT_KinouHukaInfo> pEntity) {
        List<SortCondition<BT_KinouHukaInfo>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBT_KinouHukaInfo()).kinouId, SortOrder.ASC));
        List<BT_KinouHukaInfo> copyList = new ArrayList<BT_KinouHukaInfo>(pEntity);
        Collections.sort(copyList, new OrderBT_KinouHukaInfo(orders));
        return copyList;
    }

    public List<BT_KinouHukaInfo> OrderBT_KinouHukaInfoByPkDesc(List<BT_KinouHukaInfo> pEntity) {
        List<SortCondition<BT_KinouHukaInfo>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBT_KinouHukaInfo()).kinouId, SortOrder.DESC));
        List<BT_KinouHukaInfo> copyList = new ArrayList<BT_KinouHukaInfo>(pEntity);
        Collections.sort(copyList, new OrderBT_KinouHukaInfo(orders));
        return copyList;
    }

}

