package yuyu.def.biz.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.biz.comparator.OrderBT_GkFBSoukinHukaInfo;
import yuyu.def.db.entity.BT_GkFBSoukinHukaInfo;
import yuyu.def.db.meta.QBT_GkFBSoukinHukaInfo;

public class SortBT_GkFBSoukinHukaInfo {

    public List<BT_GkFBSoukinHukaInfo> OrderBT_GkFBSoukinHukaInfoByPkAsc(List<BT_GkFBSoukinHukaInfo> pEntity) {
        List<SortCondition<BT_GkFBSoukinHukaInfo>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBT_GkFBSoukinHukaInfo()).fbsoukindatasikibetukey, SortOrder.ASC));
        List<BT_GkFBSoukinHukaInfo> copyList = new ArrayList<BT_GkFBSoukinHukaInfo>(pEntity);
        Collections.sort(copyList, new OrderBT_GkFBSoukinHukaInfo(orders));
        return copyList;
    }

    public List<BT_GkFBSoukinHukaInfo> OrderBT_GkFBSoukinHukaInfoByPkDesc(List<BT_GkFBSoukinHukaInfo> pEntity) {
        List<SortCondition<BT_GkFBSoukinHukaInfo>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBT_GkFBSoukinHukaInfo()).fbsoukindatasikibetukey, SortOrder.DESC));
        List<BT_GkFBSoukinHukaInfo> copyList = new ArrayList<BT_GkFBSoukinHukaInfo>(pEntity);
        Collections.sort(copyList, new OrderBT_GkFBSoukinHukaInfo(orders));
        return copyList;
    }
}
