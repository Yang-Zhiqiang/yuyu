package yuyu.def.biz.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.biz.comparator.OrderBT_UserKengenHaneiSskInfo;
import yuyu.def.db.entity.BT_UserKengenHaneiSskInfo;
import yuyu.def.db.meta.QBT_UserKengenHaneiSskInfo;

public class SortBT_UserKengenHaneiSskInfo {

    public List<BT_UserKengenHaneiSskInfo> OrderBT_UserKengenHaneiSskInfoByPkAsc(List<BT_UserKengenHaneiSskInfo> pEntity) {
        List<SortCondition<BT_UserKengenHaneiSskInfo>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBT_UserKengenHaneiSskInfo()).sosikicdkami3, SortOrder.ASC));
        List<BT_UserKengenHaneiSskInfo> copyList = new ArrayList<BT_UserKengenHaneiSskInfo>(pEntity);
        Collections.sort(copyList, new OrderBT_UserKengenHaneiSskInfo(orders));
        return copyList;
    }

    public List<BT_UserKengenHaneiSskInfo> OrderBT_UserKengenHaneiSskInfoByPkDesc(List<BT_UserKengenHaneiSskInfo> pEntity) {
        List<SortCondition<BT_UserKengenHaneiSskInfo>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBT_UserKengenHaneiSskInfo()).sosikicdkami3, SortOrder.DESC));
        List<BT_UserKengenHaneiSskInfo> copyList = new ArrayList<BT_UserKengenHaneiSskInfo>(pEntity);
        Collections.sort(copyList, new OrderBT_UserKengenHaneiSskInfo(orders));
        return copyList;
    }
}
