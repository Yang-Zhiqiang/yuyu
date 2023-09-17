package yuyu.def.base.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.OrderAT_MqInfo;
import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.AT_MqInfo;
import yuyu.def.db.meta.QAT_MqInfo;

public class SortAT_MqInfo {

    public List<AT_MqInfo> OrderAT_MqInfoByPkAsc(List<AT_MqInfo> pEntity) {
        List<SortCondition<AT_MqInfo>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QAT_MqInfo()).serverType, SortOrder.ASC));
        List<AT_MqInfo> copyList = new ArrayList<AT_MqInfo>(pEntity);
        Collections.sort(copyList, new OrderAT_MqInfo(orders));
        return copyList;
    }

    public List<AT_MqInfo> OrderAT_MqInfoByPkDesc(List<AT_MqInfo> pEntity) {
        List<SortCondition<AT_MqInfo>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QAT_MqInfo()).serverType, SortOrder.DESC));
        List<AT_MqInfo> copyList = new ArrayList<AT_MqInfo>(pEntity);
        Collections.sort(copyList, new OrderAT_MqInfo(orders));
        return copyList;
    }
}
