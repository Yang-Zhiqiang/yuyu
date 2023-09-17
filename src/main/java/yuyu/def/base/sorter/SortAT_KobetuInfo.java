package yuyu.def.base.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.OrderAT_KobetuInfo;
import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.AT_KobetuInfo;
import yuyu.def.db.meta.QAT_KobetuInfo;

public class SortAT_KobetuInfo {

    public List<AT_KobetuInfo> OrderAT_KobetuInfoByPkAsc(List<AT_KobetuInfo> pEntity) {
        List<SortCondition<AT_KobetuInfo>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QAT_KobetuInfo()).userId, SortOrder.ASC));
        orders.add(new SortCondition<>((new QAT_KobetuInfo()).infoSeqNo, SortOrder.ASC));
        List<AT_KobetuInfo> copyList = new ArrayList<AT_KobetuInfo>(pEntity);
        Collections.sort(copyList, new OrderAT_KobetuInfo(orders));
        return copyList;
    }

    public List<AT_KobetuInfo> OrderAT_KobetuInfoByPkDesc(List<AT_KobetuInfo> pEntity) {
        List<SortCondition<AT_KobetuInfo>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QAT_KobetuInfo()).userId, SortOrder.DESC));
        orders.add(new SortCondition<>((new QAT_KobetuInfo()).infoSeqNo, SortOrder.DESC));
        List<AT_KobetuInfo> copyList = new ArrayList<AT_KobetuInfo>(pEntity);
        Collections.sort(copyList, new OrderAT_KobetuInfo(orders));
        return copyList;
    }
}
