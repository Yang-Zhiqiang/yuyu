package yuyu.def.biz.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.biz.comparator.OrderBT_GkFBSoukinData;
import yuyu.def.db.entity.BT_GkFBSoukinData;
import yuyu.def.db.meta.QBT_GkFBSoukinData;

public class SortBT_GkFBSoukinData {

    public List<BT_GkFBSoukinData> OrderBT_GkFBSoukinDataByPkAsc(List<BT_GkFBSoukinData> pEntity) {
        List<SortCondition<BT_GkFBSoukinData>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBT_GkFBSoukinData()).fbsoukindatasikibetukey, SortOrder.ASC));
        List<BT_GkFBSoukinData> copyList = new ArrayList<BT_GkFBSoukinData>(pEntity);
        Collections.sort(copyList, new OrderBT_GkFBSoukinData(orders));
        return copyList;
    }

    public List<BT_GkFBSoukinData> OrderBT_GkFBSoukinDataByPkDesc(List<BT_GkFBSoukinData> pEntity) {
        List<SortCondition<BT_GkFBSoukinData>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBT_GkFBSoukinData()).fbsoukindatasikibetukey, SortOrder.DESC));
        List<BT_GkFBSoukinData> copyList = new ArrayList<BT_GkFBSoukinData>(pEntity);
        Collections.sort(copyList, new OrderBT_GkFBSoukinData(orders));
        return copyList;
    }
}
