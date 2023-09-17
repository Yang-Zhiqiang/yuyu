package yuyu.def.biz.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.biz.comparator.OrderBT_GyoumuKouteiInfo;
import yuyu.def.db.entity.BT_GyoumuKouteiInfo;
import yuyu.def.db.meta.QBT_GyoumuKouteiInfo;

public class SortBT_GyoumuKouteiInfo {

    public List<BT_GyoumuKouteiInfo> OrderBT_GyoumuKouteiInfoByPkAsc(List<BT_GyoumuKouteiInfo> pEntity) {
        List<SortCondition<BT_GyoumuKouteiInfo>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBT_GyoumuKouteiInfo()).kouteikanriid, SortOrder.ASC));
        List<BT_GyoumuKouteiInfo> copyList = new ArrayList<BT_GyoumuKouteiInfo>(pEntity);
        Collections.sort(copyList, new OrderBT_GyoumuKouteiInfo(orders));
        return copyList;
    }

    public List<BT_GyoumuKouteiInfo> OrderBT_GyoumuKouteiInfoByPkDesc(List<BT_GyoumuKouteiInfo> pEntity) {
        List<SortCondition<BT_GyoumuKouteiInfo>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBT_GyoumuKouteiInfo()).kouteikanriid, SortOrder.DESC));
        List<BT_GyoumuKouteiInfo> copyList = new ArrayList<BT_GyoumuKouteiInfo>(pEntity);
        Collections.sort(copyList, new OrderBT_GyoumuKouteiInfo(orders));
        return copyList;
    }
    public List<BT_GyoumuKouteiInfo> OrderBT_GyoumuKouteiInfoBySknoAsc(List<BT_GyoumuKouteiInfo> pEntity) {
        List<SortCondition<BT_GyoumuKouteiInfo>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBT_GyoumuKouteiInfo()).skno, SortOrder.ASC));
        List<BT_GyoumuKouteiInfo> copyList = new ArrayList<BT_GyoumuKouteiInfo>(pEntity);
        Collections.sort(copyList, new OrderBT_GyoumuKouteiInfo(orders));
        return copyList;
    }


}

