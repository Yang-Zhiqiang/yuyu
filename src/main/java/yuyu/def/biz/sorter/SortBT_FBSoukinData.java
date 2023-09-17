package yuyu.def.biz.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.biz.comparator.OrderBT_FBSoukinData;
import yuyu.def.db.entity.BT_FBSoukinData;
import yuyu.def.db.meta.QBT_FBSoukinData;

public class SortBT_FBSoukinData {

    public List<BT_FBSoukinData> OrderBT_FBSoukinDataByPkAsc(List<BT_FBSoukinData> pEntity) {
        List<SortCondition<BT_FBSoukinData>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBT_FBSoukinData()).fbsoukindatasikibetukey, SortOrder.ASC));
        List<BT_FBSoukinData> copyList = new ArrayList<BT_FBSoukinData>(pEntity);
        Collections.sort(copyList, new OrderBT_FBSoukinData(orders));
        return copyList;
    }

    public List<BT_FBSoukinData> OrderBT_FBSoukinDataByPkDesc(List<BT_FBSoukinData> pEntity) {
        List<SortCondition<BT_FBSoukinData>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBT_FBSoukinData()).fbsoukindatasikibetukey, SortOrder.DESC));
        List<BT_FBSoukinData> copyList = new ArrayList<BT_FBSoukinData>(pEntity);
        Collections.sort(copyList, new OrderBT_FBSoukinData(orders));
        return copyList;
    }
}
