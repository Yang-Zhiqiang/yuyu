package yuyu.def.biz.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.biz.comparator.OrderBT_FBSoukinHukaInfo;
import yuyu.def.db.entity.BT_FBSoukinHukaInfo;
import yuyu.def.db.meta.QBT_FBSoukinHukaInfo;

public class SortBT_FBSoukinHukaInfo {

    public List<BT_FBSoukinHukaInfo> OrderBT_FBSoukinHukaInfoByPkAsc(List<BT_FBSoukinHukaInfo> pEntity) {
        List<SortCondition<BT_FBSoukinHukaInfo>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBT_FBSoukinHukaInfo()).fbsoukindatasikibetukey, SortOrder.ASC));
        List<BT_FBSoukinHukaInfo> copyList = new ArrayList<BT_FBSoukinHukaInfo>(pEntity);
        Collections.sort(copyList, new OrderBT_FBSoukinHukaInfo(orders));
        return copyList;
    }

    public List<BT_FBSoukinHukaInfo> OrderBT_FBSoukinHukaInfoByPkDesc(List<BT_FBSoukinHukaInfo> pEntity) {
        List<SortCondition<BT_FBSoukinHukaInfo>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBT_FBSoukinHukaInfo()).fbsoukindatasikibetukey, SortOrder.DESC));
        List<BT_FBSoukinHukaInfo> copyList = new ArrayList<BT_FBSoukinHukaInfo>(pEntity);
        Collections.sort(copyList, new OrderBT_FBSoukinHukaInfo(orders));
        return copyList;
    }
}
