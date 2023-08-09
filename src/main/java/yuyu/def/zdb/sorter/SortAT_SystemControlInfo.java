package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.AT_SystemControlInfo;
import yuyu.def.db.meta.QAT_SystemControlInfo;
import yuyu.def.zdb.comparator.OrderAT_SystemControlInfo;

public class SortAT_SystemControlInfo {

    
    public List<AT_SystemControlInfo> OrderAT_SystemControlInfoByPkAsc(List<AT_SystemControlInfo> pEntity) {
        List<SortCondition<AT_SystemControlInfo>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QAT_SystemControlInfo()).systemCtrlInfo, SortOrder.ASC));
        List<AT_SystemControlInfo> copyList = new ArrayList<AT_SystemControlInfo>(pEntity);
        Collections.sort(copyList, new OrderAT_SystemControlInfo(orders));
        return copyList;
    }

    
    public List<AT_SystemControlInfo> OrderAT_SystemControlInfoByPkDesc(List<AT_SystemControlInfo> pEntity) {
        List<SortCondition<AT_SystemControlInfo>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QAT_SystemControlInfo()).systemCtrlInfo, SortOrder.DESC));
        List<AT_SystemControlInfo> copyList = new ArrayList<AT_SystemControlInfo>(pEntity);
        Collections.sort(copyList, new OrderAT_SystemControlInfo(orders));
        return copyList;
    }
}
