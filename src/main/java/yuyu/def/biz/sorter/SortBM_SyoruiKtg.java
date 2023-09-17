package yuyu.def.biz.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.biz.comparator.OrderBM_SyoruiKtg;
import yuyu.def.db.entity.BM_SyoruiKtg;
import yuyu.def.db.meta.QBM_SyoruiKtg;

public class SortBM_SyoruiKtg {

    public List<BM_SyoruiKtg> OrderBM_SyoruiKtgByPkAsc(List<BM_SyoruiKtg> pEntity) {
        List<SortCondition<BM_SyoruiKtg>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBM_SyoruiKtg()).syoruiCd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_SyoruiKtg()).ktgsyoruicd, SortOrder.ASC));
        List<BM_SyoruiKtg> copyList = new ArrayList<BM_SyoruiKtg>(pEntity);
        Collections.sort(copyList, new OrderBM_SyoruiKtg(orders));
        return copyList;
    }

    public List<BM_SyoruiKtg> OrderBM_SyoruiKtgByPkDesc(List<BM_SyoruiKtg> pEntity) {
        List<SortCondition<BM_SyoruiKtg>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBM_SyoruiKtg()).syoruiCd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_SyoruiKtg()).ktgsyoruicd, SortOrder.DESC));
        List<BM_SyoruiKtg> copyList = new ArrayList<BM_SyoruiKtg>(pEntity);
        Collections.sort(copyList, new OrderBM_SyoruiKtg(orders));
        return copyList;
    }

}

