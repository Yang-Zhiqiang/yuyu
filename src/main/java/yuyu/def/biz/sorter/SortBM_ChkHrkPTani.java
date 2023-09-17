package yuyu.def.biz.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.biz.comparator.OrderBM_ChkHrkPTani;
import yuyu.def.db.entity.BM_ChkHrkPTani;
import yuyu.def.db.meta.QBM_ChkHrkPTani;

public class SortBM_ChkHrkPTani {

    public List<BM_ChkHrkPTani> OrderBM_ChkHrkPTaniByPkAsc(List<BM_ChkHrkPTani> pEntity) {
        List<SortCondition<BM_ChkHrkPTani>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBM_ChkHrkPTani()).syouhncd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_ChkHrkPTani()).hrkkaisuu, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_ChkHrkPTani()).syusyouhnsdnofrom, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_ChkHrkPTani()).syusyouhnsdnoto, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_ChkHrkPTani()).channelcd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_ChkHrkPTani()).hrktuukasyu, SortOrder.ASC));
        List<BM_ChkHrkPTani> copyList = new ArrayList<BM_ChkHrkPTani>(pEntity);
        Collections.sort(copyList, new OrderBM_ChkHrkPTani(orders));
        return copyList;
    }

    public List<BM_ChkHrkPTani> OrderBM_ChkHrkPTaniByPkDesc(List<BM_ChkHrkPTani> pEntity) {
        List<SortCondition<BM_ChkHrkPTani>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBM_ChkHrkPTani()).syouhncd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_ChkHrkPTani()).hrkkaisuu, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_ChkHrkPTani()).syusyouhnsdnofrom, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_ChkHrkPTani()).syusyouhnsdnoto, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_ChkHrkPTani()).channelcd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_ChkHrkPTani()).hrktuukasyu, SortOrder.DESC));
        List<BM_ChkHrkPTani> copyList = new ArrayList<BM_ChkHrkPTani>(pEntity);
        Collections.sort(copyList, new OrderBM_ChkHrkPTani(orders));
        return copyList;
    }
}
