package yuyu.def.base.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.OrderAT_KyoutuuInfo;
import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.AT_KyoutuuInfo;
import yuyu.def.db.meta.QAT_KyoutuuInfo;

public class SortAT_KyoutuuInfo {

    public List<AT_KyoutuuInfo> OrderAT_KyoutuuInfoByPkAsc(List<AT_KyoutuuInfo> pEntity) {
        List<SortCondition<AT_KyoutuuInfo>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QAT_KyoutuuInfo()).kinouId, SortOrder.ASC));
        orders.add(new SortCondition<>((new QAT_KyoutuuInfo()).infoSeqNo, SortOrder.ASC));
        List<AT_KyoutuuInfo> copyList = new ArrayList<AT_KyoutuuInfo>(pEntity);
        Collections.sort(copyList, new OrderAT_KyoutuuInfo(orders));
        return copyList;
    }

    public List<AT_KyoutuuInfo> OrderAT_KyoutuuInfoByPkDesc(List<AT_KyoutuuInfo> pEntity) {
        List<SortCondition<AT_KyoutuuInfo>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QAT_KyoutuuInfo()).kinouId, SortOrder.DESC));
        orders.add(new SortCondition<>((new QAT_KyoutuuInfo()).infoSeqNo, SortOrder.DESC));
        List<AT_KyoutuuInfo> copyList = new ArrayList<AT_KyoutuuInfo>(pEntity);
        Collections.sort(copyList, new OrderAT_KyoutuuInfo(orders));
        return copyList;
    }
}
