package yuyu.def.base.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.OrderAT_FileHozonInfo;
import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.AT_FileHozonInfo;
import yuyu.def.db.meta.QAT_FileHozonInfo;

public class SortAT_FileHozonInfo {

    public List<AT_FileHozonInfo> OrderAT_FileHozonInfoByPkAsc(List<AT_FileHozonInfo> pEntity) {
        List<SortCondition<AT_FileHozonInfo>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QAT_FileHozonInfo()).uniqueId, SortOrder.ASC));
        List<AT_FileHozonInfo> copyList = new ArrayList<AT_FileHozonInfo>(pEntity);
        Collections.sort(copyList, new OrderAT_FileHozonInfo(orders));
        return copyList;
    }

    public List<AT_FileHozonInfo> OrderAT_FileHozonInfoByPkDesc(List<AT_FileHozonInfo> pEntity) {
        List<SortCondition<AT_FileHozonInfo>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QAT_FileHozonInfo()).uniqueId, SortOrder.DESC));
        List<AT_FileHozonInfo> copyList = new ArrayList<AT_FileHozonInfo>(pEntity);
        Collections.sort(copyList, new OrderAT_FileHozonInfo(orders));
        return copyList;
    }

    public List<AT_FileHozonInfo> OrderAT_FileHozonInfoByTourokuTimeDesc(List<AT_FileHozonInfo> pEntity) {
        List<SortCondition<AT_FileHozonInfo>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QAT_FileHozonInfo()).tourokuTime, SortOrder.DESC));
        List<AT_FileHozonInfo> copyList = new ArrayList<AT_FileHozonInfo>(pEntity);
        Collections.sort(copyList, new OrderAT_FileHozonInfo(orders));
        return copyList;
    }
}
