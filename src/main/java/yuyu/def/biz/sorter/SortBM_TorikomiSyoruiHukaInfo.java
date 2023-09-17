package yuyu.def.biz.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.biz.comparator.OrderBM_TorikomiSyoruiHukaInfo;
import yuyu.def.db.entity.BM_TorikomiSyoruiHukaInfo;
import yuyu.def.db.meta.QBM_TorikomiSyoruiHukaInfo;

public class SortBM_TorikomiSyoruiHukaInfo {

    public List<BM_TorikomiSyoruiHukaInfo> OrderBM_TorikomiSyoruiHukaInfoByPkAsc(List<BM_TorikomiSyoruiHukaInfo> pEntity) {
        List<SortCondition<BM_TorikomiSyoruiHukaInfo>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBM_TorikomiSyoruiHukaInfo()).syoruiCd, SortOrder.ASC));
        List<BM_TorikomiSyoruiHukaInfo> copyList = new ArrayList<BM_TorikomiSyoruiHukaInfo>(pEntity);
        Collections.sort(copyList, new OrderBM_TorikomiSyoruiHukaInfo(orders));
        return copyList;
    }

    public List<BM_TorikomiSyoruiHukaInfo> OrderBM_TorikomiSyoruiHukaInfoByPkDesc(List<BM_TorikomiSyoruiHukaInfo> pEntity) {
        List<SortCondition<BM_TorikomiSyoruiHukaInfo>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBM_TorikomiSyoruiHukaInfo()).syoruiCd, SortOrder.DESC));
        List<BM_TorikomiSyoruiHukaInfo> copyList = new ArrayList<BM_TorikomiSyoruiHukaInfo>(pEntity);
        Collections.sort(copyList, new OrderBM_TorikomiSyoruiHukaInfo(orders));
        return copyList;
    }

    public List<BM_TorikomiSyoruiHukaInfo> OrderBM_TorikomiSyoruiHukaInfoBySortNoAsc(List<BM_TorikomiSyoruiHukaInfo> pEntity) {
        List<SortCondition<BM_TorikomiSyoruiHukaInfo>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBM_TorikomiSyoruiHukaInfo()).sortNo, SortOrder.ASC));
        List<BM_TorikomiSyoruiHukaInfo> copyList = new ArrayList<BM_TorikomiSyoruiHukaInfo>(pEntity);
        Collections.sort(copyList, new OrderBM_TorikomiSyoruiHukaInfo(orders));
        return copyList;
    }

}

