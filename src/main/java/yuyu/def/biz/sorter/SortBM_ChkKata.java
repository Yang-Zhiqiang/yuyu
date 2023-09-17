package yuyu.def.biz.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.biz.comparator.OrderBM_ChkKata;
import yuyu.def.db.entity.BM_ChkKata;
import yuyu.def.db.meta.QBM_ChkKata;

public class SortBM_ChkKata {

    public List<BM_ChkKata> OrderBM_ChkKataByPkAsc(List<BM_ChkKata> pEntity) {
        List<SortCondition<BM_ChkKata>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBM_ChkKata()).syouhncd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_ChkKata()).syusyouhnsdnofrom, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_ChkKata()).syusyouhnsdnoto, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_ChkKata()).tktanbrumu, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_ChkKata()).katakbn, SortOrder.ASC));
        List<BM_ChkKata> copyList = new ArrayList<BM_ChkKata>(pEntity);
        Collections.sort(copyList, new OrderBM_ChkKata(orders));
        return copyList;
    }

    public List<BM_ChkKata> OrderBM_ChkKataByPkDesc(List<BM_ChkKata> pEntity) {
        List<SortCondition<BM_ChkKata>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBM_ChkKata()).syouhncd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_ChkKata()).syusyouhnsdnofrom, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_ChkKata()).syusyouhnsdnoto, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_ChkKata()).tktanbrumu, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_ChkKata()).katakbn, SortOrder.DESC));
        List<BM_ChkKata> copyList = new ArrayList<BM_ChkKata>(pEntity);
        Collections.sort(copyList, new OrderBM_ChkKata(orders));
        return copyList;
    }

}

