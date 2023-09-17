package yuyu.def.biz.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.biz.comparator.OrderBM_SyoruiZokuseiHukaInfo;
import yuyu.def.db.entity.BM_SyoruiZokuseiHukaInfo;
import yuyu.def.db.meta.QBM_SyoruiZokuseiHukaInfo;

public class SortBM_SyoruiZokuseiHukaInfo {

    public List<BM_SyoruiZokuseiHukaInfo> OrderBM_SyoruiZokuseiHukaInfoByPkAsc(List<BM_SyoruiZokuseiHukaInfo> pEntity) {
        List<SortCondition<BM_SyoruiZokuseiHukaInfo>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBM_SyoruiZokuseiHukaInfo()).syoruiCd, SortOrder.ASC));
        List<BM_SyoruiZokuseiHukaInfo> copyList = new ArrayList<BM_SyoruiZokuseiHukaInfo>(pEntity);
        Collections.sort(copyList, new OrderBM_SyoruiZokuseiHukaInfo(orders));
        return copyList;
    }

    public List<BM_SyoruiZokuseiHukaInfo> OrderBM_SyoruiZokuseiHukaInfoByPkDesc(List<BM_SyoruiZokuseiHukaInfo> pEntity) {
        List<SortCondition<BM_SyoruiZokuseiHukaInfo>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBM_SyoruiZokuseiHukaInfo()).syoruiCd, SortOrder.DESC));
        List<BM_SyoruiZokuseiHukaInfo> copyList = new ArrayList<BM_SyoruiZokuseiHukaInfo>(pEntity);
        Collections.sort(copyList, new OrderBM_SyoruiZokuseiHukaInfo(orders));
        return copyList;
    }

}

